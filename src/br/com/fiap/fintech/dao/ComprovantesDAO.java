package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.model.Comprovantes;

public class ComprovantesDAO {

	public void adicionar(Comprovantes comprovantes) throws SQLException {
		PreparedStatement stmt = null;
		Connection conexao = null;

		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO t_comprov (id_comprov, endereco, data_emissao, tipo_comprov) "
					+ "VALUES (SQ_FINTECH.NEXTVAL, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, comprovantes.getEndereco());

			Date date = Date.valueOf(comprovantes.getDataEmissao());
			stmt.setDate(2, date);

			stmt.setString(3, comprovantes.getTipoComprovantes());

			stmt.executeUpdate();

			System.out.println("INFO: Endereço de comprovante " + comprovantes.getEndereco() + " cadastrado!!");

		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar um novo endereço de comprovante no banco de dados!");
			e.printStackTrace();
		} finally {
			stmt.close();
			conexao.close();
		}

	}

	public List<Comprovantes> getAll() throws SQLException {
		List<Comprovantes> lista = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conexao = null;
		ResultSet rs = null;

		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_comprov";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID_COMPROV");
				String endereco = rs.getString("ENDERECO");
				Date dataEmissao = rs.getDate("DATA_EMISSAO");
				String TipoComprovantes = rs.getString("TIPO_COMPROV");
				
				@SuppressWarnings("deprecation")
				LocalDate data = LocalDate.of(dataEmissao.getYear(), dataEmissao.getMonth(), dataEmissao.getDay());
				
				Comprovantes comprovantes = new Comprovantes(id, endereco, data, TipoComprovantes);
				lista.add(comprovantes);

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
