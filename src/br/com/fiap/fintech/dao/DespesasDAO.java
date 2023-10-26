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
import br.com.fiap.fintech.model.Despesas;

public class DespesasDAO {

	public void adicionar(Despesas despesas) throws SQLException {
		PreparedStatement stmt = null;
		Connection conexao = null;

		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO t_despesas (ID_DESPESA, T_CONTA_EMPRESA_ID_CONTA, DATA_REGISTRO, DESC_DESPESAS, QUANTIDADE, DESTINO, CUSTO)\r\n"
					+ "    VALUES (sq_fintech.nextval, ?, ?, ?, ?, ?, ?);";

			stmt = conexao.prepareStatement(sql);
			stmt.setObject(1, despesas.getContaEmpresa().getId());
			stmt.setString(2, despesas.getDescricaoDespesas());
			stmt.setDouble(3, despesas.getQuantidade());
			stmt.setString(4, despesas.getDestino());
			stmt.setDouble(5, despesas.getCustos());
			
			Date date = Date.valueOf(despesas.getDataRegistro());
			stmt.setDate(6, date);

			stmt.executeUpdate();

			System.out.println("INFO: A despesa atual teve o destino: " + despesas.getDestino() + ", foi cadastrado!!");
		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar um novo destino de despesa no banco de dados!");
			e.printStackTrace();
		} finally {
			stmt.close();
			conexao.close();
		}
	}
	
	public List<Despesas> getAll() throws SQLException {
		List<Despesas> lista = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conexao = null;
		ResultSet rs = null;

		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_despesas";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID_DESPESAS");
				int idContaEmpresa = rs.getInt("CONTA_EMPRESA");
				Date dataRegistro = rs.getDate("DATA_REGISTRO");
				String descricaoDespesas = rs.getString("DESC_DESPESAS");
				int quantidade = rs.getInt("QUANTIDADE");
				String destino = rs.getString("DESTINO");
				Double custo = rs.getDouble("CUSTO");
				
				LocalDate localDate = LocalDate.of(dataRegistro.getYear(), dataRegistro.getMonth(), dataRegistro.getDay());

				ContaEmpresa contaEmpresa = new ContaEmpresa();
				Despesas despesas = new Despesas(id, contaEmpresa, localDate, descricaoDespesas, quantidade, destino, custo);
				lista.add(despesas);
			}
				

		} catch (SQLException e) {
			System.err.println("Erro ao listar destinos de despesas no banco de dados!");
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conexao.close();
		}

		return lista;
	}
}