package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.model.ContaEmpresa;
import br.com.fiap.fintech.model.Saldo;
import br.com.fiap.fintech.model.enums.TipoMoedaEnum;

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
	
	public List<Saldo> getAll() throws SQLException {
		List<Saldo> lista = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conexao = null;
		ResultSet rs = null;
		
		ContaEmpresaDAO contaEmpresaDAO = new ContaEmpresaDAO();

		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_saldo";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID_SALDO");
				int idEmpresa = rs.getInt("T_CONTA_EMPRESA_ID_CONTA");
				int saldoAtual = rs.getInt("SALDO_ATUAL");
				String tipoMoeda = rs.getString("TIPO_MOEDA");
				Date dataAtualizacao = rs.getDate("DATA_ATUALIZACAO");
				
				ContaEmpresa contaEmpresa = contaEmpresaDAO.getById(idEmpresa);

				@SuppressWarnings("deprecation")
				LocalDate date = LocalDate.of(dataAtualizacao.getYear(), dataAtualizacao.getMonth(), dataAtualizacao.getDay());
				
				Saldo saldo = new Saldo(id, contaEmpresa, saldoAtual, date, TipoMoedaEnum.valueOf(tipoMoeda));
				lista.add(saldo);
				
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
