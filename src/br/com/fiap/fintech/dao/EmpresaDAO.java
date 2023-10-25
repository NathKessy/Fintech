package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.model.DocumentosSocios;
import br.com.fiap.fintech.model.Empresa;


public class EmpresaDAO {
	
	public void adicionar(Empresa empresa) throws SQLException {
		PreparedStatement stmt = null;
		Connection conexao = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO T_EMPRESA (id_empresa, t_doc_socios_id_socios, razao_social, nome_fantasia, cnpj, capital_emp, cep, telefone, email, endereco, faturamento)\r\n"
					+ "    VALUES (SQ_FINTECH.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setObject(1, empresa.getDocumentosSocios());
			stmt.setString(2, empresa.getRazaoSocial());
			stmt.setString(3, empresa.getNomeFantasia());
			stmt.setString(4, empresa.getCnpj());
			stmt.setDouble(5, empresa.getCapital_empresa());
			stmt.setString(6, empresa.getCep());
			stmt.setString(7, empresa.getTelefone());
			stmt.setString(8, empresa.getEmail());
			stmt.setString(9, empresa.getEndereco());
			stmt.setDouble(10, empresa.getFaturamento());
			
			stmt.executeUpdate();

			System.out.println("INFO: Empresa " + empresa.getTelefone() + " cadastrado!!");
			
		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar um dado da Empresa no banco de dados!");
			e.printStackTrace();
		} finally {
			stmt.close();
			conexao.close();
		}

	}	
	
	public List<Empresa> getAll() throws SQLException {
		List<Empresa> lista = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conexao = null;
		ResultSet rs = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_empresa";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ID_USUARIO");
				DocumentosSocios documentosSocios = (DocumentosSocios) rs.getObject("T_DOC_SOCIOS_ID_DOC_SOCIOS");
				String razaoSocial = rs.getString("RAZAO_SOCIAL");
				String nomeFantasia = rs.getString("NOME_FANTASIA");
				String cnpj = rs.getString("CNPJ");
				Double capital_empresa = rs.getDouble("CAPITAL_EMPRESA");
				String cep = rs.getString("CEP");
				String telefone = rs.getString("TELEFONE");
				String email = rs.getString("EMAIL");
				String endereco = rs.getString("ENDERECO");
				Double faturamento = rs.getDouble("FATURAMENTO");
				
				Empresa empresa = new Empresa(id, documentosSocios, razaoSocial, nomeFantasia, cnpj, capital_empresa, cep, telefone, email, endereco, faturamento);
				lista.add(empresa);
			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar usuários ao banco de dados!");
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conexao.close();
		}

		return lista;
	}
		
}