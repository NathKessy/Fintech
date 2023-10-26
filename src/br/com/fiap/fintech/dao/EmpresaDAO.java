package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.model.Empresa;
import br.com.fiap.fintech.model.Endereco;


public class EmpresaDAO {
	
	public void adicionar(Empresa empresa) throws SQLException {
		PreparedStatement stmt = null;
		Connection conexao = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO T_EMPRESA (id_empresa, t_doc_socios_id_socios, razao_social, nome_fantasia, cnpj, capital_emp, cep, telefone, email, endereco, faturamento)\r\n"
					+ "    VALUES (SQ_EMPRESA.nextval, null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
//			stmt.setObject(1, empresa.getDocumentosSocios().getId());
			stmt.setString(1, empresa.getRazaoSocial());
			stmt.setString(2, empresa.getNomeFantasia());
			stmt.setString(3, empresa.getCnpj());
			stmt.setDouble(4, empresa.getCapital_empresa());
			stmt.setString(5, empresa.getCep());
			stmt.setString(6, empresa.getTelefone());
			stmt.setString(7, empresa.getEmail());
			stmt.setObject(8, empresa.getEndereco().getId());
			stmt.setDouble(9, empresa.getFaturamento());
			
			stmt.executeUpdate();

			System.out.println("INFO: Empresa " + empresa.getNomeFantasia() + " cadastrado!!");
			
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
		
		EnderecoDAO enderecoDao = new EnderecoDAO();
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_empresa order by id_empresa asc";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ID_EMPRESA"); 
//				DocumentosSocios idDocumentosSocios = (DocumentosSocios) rs.getObject("T_DOC_SOCIOS_ID_DOC_SOCIOS");
				String razaoSocial = rs.getString("RAZAO_SOCIAL");
				String nomeFantasia = rs.getString("NOME_FANTASIA");
				String cnpj = rs.getString("CNPJ");
				Double capital_empresa = rs.getDouble("CAPITAL_EMP");
				String cep = rs.getString("CEP");
				String telefone = rs.getString("TELEFONE");
				String email = rs.getString("EMAIL");
				int idEndereco = rs.getInt("ENDERECO");
				Double faturamento = rs.getDouble("FATURAMENTO");
				
				Endereco endereco = enderecoDao.getById(idEndereco);
				Empresa empresa = new Empresa(id, null, razaoSocial, nomeFantasia, cnpj, capital_empresa, cep, telefone, email, endereco, faturamento);
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
	
	public Empresa getById(int idEmpresa) throws SQLException {
		PreparedStatement stmt = null;
		Connection conexao = null;
		ResultSet rs = null;
		
		Empresa empresa = null;
		
		EnderecoDAO enderecoDao = new EnderecoDAO();
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_empresa where id_empresa = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idEmpresa);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt("ID_EMPRESA"); 
//				DocumentosSocios idDocumentosSocios = (DocumentosSocios) rs.getObject("T_DOC_SOCIOS_ID_DOC_SOCIOS");
				String razaoSocial = rs.getString("RAZAO_SOCIAL");
				String nomeFantasia = rs.getString("NOME_FANTASIA");
				String cnpj = rs.getString("CNPJ");
				Double capital_empresa = rs.getDouble("CAPITAL_EMP");
				String cep = rs.getString("CEP");
				String telefone = rs.getString("TELEFONE");
				String email = rs.getString("EMAIL");
				int idEndereco = rs.getInt("ENDERECO");
				Double faturamento = rs.getDouble("FATURAMENTO");
				
				Endereco endereco = enderecoDao.getById(idEndereco);
				empresa = new Empresa(id, null, razaoSocial, nomeFantasia, cnpj, capital_empresa, cep, telefone, email, endereco, faturamento);
			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar usuários ao banco de dados!");
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conexao.close();
		}

		return empresa;
	}
		
}