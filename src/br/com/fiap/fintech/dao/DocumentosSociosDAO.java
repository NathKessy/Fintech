package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.model.DocumentosSocios;
import br.com.fiap.fintech.model.Empresa;

public class DocumentosSociosDAO {
	
	public void adicionar (DocumentosSocios documentosSocios) throws SQLException {
		if (documentosSocios.getEmpresa().getId() == null) {
			System.out.println("ID não localizado na base de dados");
			return;
		}
		
		Connection conexao = null;
		PreparedStatement stmt = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO t_doc_socios (ID_SOCIOS, T_EMPRESA_ID_EMPRESA, NOME, RG, CPF, DATA_NASC, ESTADO_CIVIL, NACIONALIDADE, ENDERECO)"
					+ "    VALUES (sq_fintech.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setObject(1, documentosSocios.getEmpresa().getId());
			stmt.setString(2, documentosSocios.getNome().toString());
			stmt.setString(3, documentosSocios.getRg().toString());
			stmt.setString(4, documentosSocios.getCpf().toString());
			stmt.setString(6, documentosSocios.getEstadoCivil().toString());
			stmt.setString(7, documentosSocios.getNacionalidade().toString());
			stmt.setString(8, documentosSocios.getEndereco().toString());
			
			Date date = Date.valueOf(documentosSocios.getDataNascimento());
			stmt.setDate(5, date);
			
			stmt.executeUpdate();
			
			System.out.println("INFO: " + documentosSocios.getNome() + ", foi cadastrado!!");
			
		} catch (SQLException erro){
			System.err.println("Erro ao cadastrar o Documento Socios atual no banco de dados!");
			erro.printStackTrace();
	
		} finally {
			stmt.close();
			conexao.close();
		}
		
		
		
	}
	
	public List<DocumentosSocios> getAll() throws SQLException {
		List<DocumentosSocios> lista = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conexao = null;
		ResultSet rs = null;

		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_doc_socios";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID_SOCIOS");
				int idEmpresa = rs.getInt("T_EMPRESA_ID_EMPRESA");
				String nome = rs.getString("NOME");
				String rg = rs.getString("RG");
				String cpf = rs.getString("CPF");
				Date dataNascimento = rs.getDate("DATA_NASC");
				String estadoCivil = rs.getString("ESTADO_CIVIL");
				String nacionalidade = rs.getString("NACIONALIDADE");
				String endereco = rs.getString("ENDERECO");
								
				@SuppressWarnings("deprecation")
				LocalDate data = LocalDate.of(dataNascimento.getYear(), dataNascimento.getMonth(), dataNascimento.getDay());
				Empresa empresa = new Empresa(idEmpresa);
				
				
				DocumentosSocios documentossocios = new DocumentosSocios(id, empresa, nome, rg, cpf, data, estadoCivil, nacionalidade, endereco);
				lista.add(documentossocios);

			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar endereços ao banco de dados!");
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conexao.close();
		}

		return lista;
	}

}