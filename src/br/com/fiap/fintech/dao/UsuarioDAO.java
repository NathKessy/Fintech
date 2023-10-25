package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.model.Usuario;

public class UsuarioDAO {

	public void adicionar(Usuario usuario) throws SQLException {
		PreparedStatement stmt = null;
		Connection conexao = null;

		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO t_usuario ( id_usuario, login_empresa, email, senha ) "
					+ "VALUES ( SQ_FINTECH.NEXTVAL, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getLoginEmpresa());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());

			stmt.executeUpdate();

			System.out.println("INFO: Usuário " + usuario.getEmail() + " cadastrado!!");

		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar um novo usuário no banco de dados!");
			e.printStackTrace();
		} finally {
			stmt.close();
			conexao.close();
		}

	}

	public List<Usuario> getAll() throws SQLException {
		List<Usuario> lista = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conexao = null;
		ResultSet rs = null;

		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_usuario";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID_USUARIO");
				String login = rs.getString("LOGIN_EMPRESA");
				String email = rs.getString("EMAIL");
				String senha = rs.getString("SENHA");

				Usuario usuario = new Usuario(id, login, email, senha);
				lista.add(usuario);
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

	public Usuario getById(int id) throws SQLException {
		PreparedStatement stmt = null;
		Connection conexao = null;
		ResultSet rs = null;

		Usuario usuario = null;

		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_usuario where id_usuario = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String login = rs.getString("LOGIN_EMPRESA");
				String email = rs.getString("EMAIL");
				String senha = rs.getString("SENHA");

				usuario = new Usuario(id, login, email, senha);
			}

		} catch (SQLException e) {
			System.out.println();
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conexao.close();
		}

		return usuario;
	}

	public void delete(int id) throws SQLException {
		PreparedStatement stmt = null;
		Connection conexao = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "delete from t_usuario where id_usuario = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			System.out.println("Usuário " + id + " foi excluido com sucesso");
			
		} catch (SQLException e) {
			System.err.println("Erro ao deletar o usuário!");
			e.printStackTrace();
		} finally {
			stmt.close();
			conexao.close();
		}
	}
}
