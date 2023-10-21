package br.com.fiap.fintech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteView {

	public static void main(String[] args) {
		try {
			//Registra o Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			  
		    //Abre uma conexão
		    Connection conexao = DriverManager.getConnection(
		    		"jdbc:oracle:thin:@oracle.fiap.com.br:1521/ORCL", "RM99808", "041098");
		        
		    System.out.println("Conectado!");
		        
		    //Fecha a conexão
		    conexao.close();

		     
		//Tratamento de erro
		} catch (SQLException erro) {
			System.err.println("Não foi possível conectar no Banco de Dados");
			erro.printStackTrace();
		} catch (ClassNotFoundException erro) {
			System.err.println("O Driver OJDBC não foi encontado!");
			erro.printStackTrace();
		}
	}
}
