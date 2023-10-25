package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.fintech.model.ContaEmpresa;

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
}
