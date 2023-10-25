package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.fintech.model.Cidade;
import br.com.fiap.fintech.model.Estado;
import br.com.fiap.fintech.model.Pais;

public class EnderecoComplementosDAO {
	
	public Pais getPaisById(int id) throws SQLException {
		Connection conexao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Pais pais = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "SELECT * FROM T_PAIS WHERE ID_PAIS = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				String nomePais = rs.getString("NOME_PAIS");
				String sigla = rs.getString("SIGLA");
				
				pais = new Pais(id, nomePais, sigla);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conexao.close();
		}
		
		return pais;
	}
	
	public Cidade getCidadeById(int id) throws SQLException {
		Connection conexao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Cidade cidade = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "SELECT * FROM T_CIDADE WHERE ID_CIDADE = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				String nomeCidade = rs.getString("NOME_CIDADE");
				
				cidade = new Cidade(id, nomeCidade);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conexao.close();
		}
		
		return cidade;
	}
	
	public Estado getEstadoById(int id) throws SQLException {
		Connection conexao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Estado estado = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "SELECT * FROM T_ESTADO WHERE ID_ESTADO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				String uf = rs.getString("UF");
				String nomeEstado = rs.getString("NOME_ESTADO");
				
				estado = new Estado(id, uf, nomeEstado);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conexao.close();
		}
		
		return estado;
	}

}
