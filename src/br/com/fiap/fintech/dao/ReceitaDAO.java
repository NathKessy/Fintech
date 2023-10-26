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
import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.model.enums.TipoTransacaoEnum;

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
	
	public List<Receita> getAll() throws SQLException {
		List<Receita> lista = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conexao = null;
		ResultSet rs = null;

		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_receita";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID_RECEITA");
				int idContaEmpresa = rs.getInt("T_CONTA_EMPRESA_ID_CONTA");
				String nomeTransacao = rs.getString("NOME_TRANSACAO");
				String tipoTransacao = rs.getString("TIPO_TRANSACAO");
				String descricaoTransacao = rs.getString("DESCRICAO_TRANSACAO");
				Date dataTransacaodb = rs.getDate("DATA_TRANSACAO");
				Date dataRegistrodb = rs.getDate("DATA_REGISTRO");
								
				@SuppressWarnings("deprecation")
				LocalDate dateTransacao = LocalDate.of(dataTransacaodb.getYear(), dataTransacaodb.getMonth(), dataTransacaodb.getDay());
				LocalDate dateRegistro = LocalDate.of(dataRegistrodb.getYear(), dataRegistrodb.getMonth(), dataRegistrodb.getDay());
				ContaEmpresa contaEmpresa = new ContaEmpresa(idContaEmpresa);
				
				Receita receita = new Receita(id, contaEmpresa, nomeTransacao, TipoTransacaoEnum.valueOf(tipoTransacao), descricaoTransacao, dateTransacao, dateRegistro);
				lista.add(receita);

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