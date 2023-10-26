package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.fintech.model.Saldo;

public class SaldoDAO {
	
	public void adicionar (Saldo saldo) throws SQLException {
		Connection conexao = null;
		PreparedStatement stmt = null;	
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO t_saldo (ID_SALDO, T_CONTA_EMPRESA_ID_CONTA, SALDO_ATUAL, TIPO_MOEDA, DATA_ATUALIZACAO)"
					+ "    VALUES (sq_fintech.nextval, ?, ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, saldo.getContaEmpresa().getId());
			stmt.setDouble(2, saldo.getSaldoAtual());
			stmt.setString(3, saldo.getTipoMoeda().toString());
			
			Date date = Date.valueOf(saldo.getDataAtualizacao());
			stmt.setDate(4, date);
			
			stmt.executeUpdate();
			
			System.out.println("INFO: Seu saldo atual no valor de: " + saldo.getSaldoAtual() + ", foi cadastrado!!");
			
		} catch (SQLException erro){
			System.err.println("Erro ao cadastrar o saldo atual no banco de dados!");
			erro.printStackTrace();
	
		} finally {
			stmt.close();
			conexao.close();
		}
	}
}
