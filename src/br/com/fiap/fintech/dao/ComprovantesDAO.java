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
import br.com.fiap.fintech.model.DocumentosSocios;
import br.com.fiap.fintech.model.enums.TipoComprovanteEnum;

public class ComprovantesDAO {

	public void adicionar(Comprovantes comprovantes) throws SQLException {
		if (comprovantes.getDocumentosSocios().getId() == null) {
			System.out.println("ID não localizado na base de dados");
			return;
		}
		
		PreparedStatement stmt = null;
		Connection conexao = null;

		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO t_comprov (id_comprov, FK_T_COMPROV, endereco, data_emissao, tipo_comprov) "
					+ "VALUES (SQ_FINTECH.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setObject(1, comprovantes.getDocumentosSocios().getId());
			
			
			stmt.setString(2, comprovantes.getEndereco());

			Date date = Date.valueOf(comprovantes.getDataEmissao());
			stmt.setDate(3, date);

			stmt.setString(4, comprovantes.getTipoComprovantes().toString());

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
		
		DocumentosSociosDAO documentosSociosDAO = new DocumentosSociosDAO();

		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_comprov";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID_COMPROV");
				int idDocSocios = rs.getInt("FK_T_COMPROV");
				String endereco = rs.getString("ENDERECO");
				Date dataEmissao = rs.getDate("DATA_EMISSAO");
				String tipoComprovantes = rs.getString("TIPO_COMPROV");
				
				@SuppressWarnings("deprecation")
				LocalDate data = LocalDate.of(dataEmissao.getYear(), dataEmissao.getMonth(), dataEmissao.getDay());
				
				DocumentosSocios documentoSocios = documentosSociosDAO.getById(idDocSocios);
				
				Comprovantes comprovantes = new Comprovantes(id, documentoSocios, endereco, data, TipoComprovanteEnum.valueOf(tipoComprovantes));
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
