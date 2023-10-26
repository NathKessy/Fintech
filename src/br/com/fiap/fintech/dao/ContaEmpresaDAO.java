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
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.model.enums.TipoContaEnum;

public class ContaEmpresaDAO {
	
	public void adicionar(ContaEmpresa contaEmpresa) throws SQLException {	
		if (contaEmpresa.getUsuario().getId() == null) {
			System.out.println("ID não localizado na base de dados");
			return;
		}
		
		Connection conexao = null;
		PreparedStatement stmt = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO t_conta_empresa(ID_CONTA, T_USUARIO_ID_USUARIO, TIPO_CONTA, STATUS_CONTA, NUMERO_CONTA, DATA_ABERTURA)"
					+ "    VALUES (sq_fintech.nextval, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, contaEmpresa.getUsuario().getId());
			stmt.setString(2, contaEmpresa.getTipoConta().toString());
			stmt.setBoolean(3, contaEmpresa.isStatusConta());
			stmt.setString(4, contaEmpresa.getNumeroConta());
			
			Date date = Date.valueOf(contaEmpresa.getDataAbertura());
			stmt.setDate(5, date);
			
			stmt.executeUpdate();
			
			System.out.println("INFO: A Conta Empresa com o número: " + contaEmpresa.getNumeroConta() + ", foi cadastrado!!");
			
		} catch (SQLException erro){
			System.err.println("Erro ao cadastrar uma nova Conta Empresa no banco de dados!");
			erro.printStackTrace();
		} finally {
			stmt.close();
			conexao.close();
		}
	}
	
	public List<ContaEmpresa> getAll() throws SQLException {
		List<ContaEmpresa> lista = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conexao = null;
		ResultSet rs = null;
		
		UsuarioDAO usuarioDao = new UsuarioDAO();

		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_conta_empresa";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID_CONTA");
				int idUsuario = rs.getInt("T_USUARIO_ID_USUARIO");
				String tipoConta = rs.getString("TIPO_CONTA");
				boolean statusConta = rs.getBoolean("STATUS_CONTA");
				String numeroConta = rs.getString("NUMERO_CONTA");
				Date dataAbertura = rs.getDate("DATA_ABERTURA");
				
				Usuario usuario = usuarioDao.getById(idUsuario);

				@SuppressWarnings("deprecation")
				LocalDate date = LocalDate.of(dataAbertura.getYear(), dataAbertura.getMonth(), dataAbertura.getDay());
				
				ContaEmpresa contaEmpresa = new ContaEmpresa(id, usuario, numeroConta, TipoContaEnum.valueOf(tipoConta), statusConta, date);
				lista.add(contaEmpresa);
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
	
	public ContaEmpresa getById(int idEmpresa) throws SQLException {
		PreparedStatement stmt = null;
		Connection conexao = null;
		ResultSet rs = null;
		
		ContaEmpresa contaEmpresa = null;
		UsuarioDAO usuarioDao = new UsuarioDAO();

		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_conta_empresa where id_conta = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idEmpresa);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("ID_CONTA");
				int idUsuario = rs.getInt("T_USUARIO_ID_USUARIO");
				String tipoConta = rs.getString("TIPO_CONTA");
				boolean statusConta = rs.getBoolean("STATUS_CONTA");
				String numeroConta = rs.getString("NUMERO_CONTA");
				Date dataAbertura = rs.getDate("DATA_ABERTURA");
				
				Usuario usuario = usuarioDao.getById(idUsuario);

				@SuppressWarnings("deprecation")
				LocalDate date = LocalDate.of(dataAbertura.getYear(), dataAbertura.getMonth(), dataAbertura.getDay());
				
				contaEmpresa = new ContaEmpresa(id, usuario, numeroConta, TipoContaEnum.valueOf(tipoConta), statusConta, date);
			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar usuários ao banco de dados!");
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conexao.close();
		}

		return contaEmpresa;
	}
}
