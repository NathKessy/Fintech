package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.fintech.model.Receita;

public class ReceitaDAO {
	
	public void adicionar (Receita receita) throws SQLException {
		if (receita.getContaEmpresa().getId() == null) {
			System.out.println("ID não localizado na base de dados");
			return;
		}
		
		Connection conexao = null;
		PreparedStatement stmt = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO t_receita (ID_RECEITA, T_CONTA_EMPRESA_ID_CONTA, NOME_TRANSACAO, TIPO_TRANSACAO, DESCRICAO_TRANSACAO, DATA_TRANSACAO, DATA_REGISTRO)"
					+ " VALUES (sq_fintech.nextval, ?, ?, ?, ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, receita.getContaEmpresa().getId());
			stmt.setString(2, receita.getNomeTransacao());
			stmt.setString(3, receita.getTipoTransacao().toString());
			stmt.setString(4, receita.getDescricaoTransacao());

			Date dateTransacao = Date.valueOf(receita.getDataTransacao());
			stmt.setDate(5, dateTransacao);
			
			Date dateRegistro = Date.valueOf(receita.getDataRegistro());
			stmt.setDate(6, dateRegistro);
			
			stmt.executeUpdate();
			
			System.out.println("INFO: " + receita.getDescricaoTransacao() + ", foi cadastrado.");
			
		} catch (SQLException erro){
			System.err.println("Erro ao cadastrar uma nova Conta Empresa no banco de dados!");
			erro.printStackTrace();
		} finally {
			stmt.close();
			conexao.close();
		}
	}
}

	

