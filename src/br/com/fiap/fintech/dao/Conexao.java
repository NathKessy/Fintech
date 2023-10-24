package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
	private static final String USUARIO = "RM99808";
	private static final String SENHA = "041098";
	
	public static Connection abrirConexao() {
		
		Connection conexao = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
			System.out.println("Conectado!!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro de conexão!");
			e.printStackTrace();
		}
		
		return conexao;
	}
}
