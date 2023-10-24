package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.model.Empresa;
import br.com.fiap.fintech.model.Usuario;

public class UsuarioDAO {
	
	public void adicionar(Usuario usuario) throws SQLException {
		PreparedStatement stmt = null;
		Connection conexao = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO t_usuario ( id_usuario, t_empresa_id_empresa, login_empresa, email, senha ) "
					+ "VALUES ( SQ_FINTECH.NEXTVAL, ?, ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setObject(1, usuario.getEmpresa());
			stmt.setString(2, usuario.getLoginEmpresa());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			
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
			
			while(rs.next()) {
				int id = rs.getInt("ID_USUARIO");
				Empresa empresa = (Empresa) rs.getObject("T_EMPRESA_ID_EMPRESA");
				String login = rs.getString("LOGIN_EMPRESA");
				String email = rs.getString("EMAIL");
				String senha = rs.getString("SENHA");
				
				Usuario usuario = new Usuario(id, empresa, login, email, senha);
				lista.add(usuario);
			}
			
		} catch (SQLException e) {
			System.out.println();
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conexao.close();
		}
		
		return lista;
	}

}
