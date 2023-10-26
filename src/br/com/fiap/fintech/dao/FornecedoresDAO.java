package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.fintech.model.Fornecedores;

public class FornecedoresDAO {
	
	public void adicionar (Fornecedores fornecedores) throws SQLException {
		if (fornecedores.getContaEmpresa().getId() == null) {
			System.out.println("ID não localizado na base de dados");
			return;
		}
		
		Connection conexao = null;
		PreparedStatement stmt = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO t_fornecedores (ID_FORNECEDORES, T_CONTA_EMPRESA_ID_CONTA, NOME, CNPJ, ENDERECO, TELEFONE, EMAIL, CATEGORIA, STATUS, PROG_PAGAMENTO,HIST_PAGAMENTOS)"
					+ "    VALUES (sq_fintech.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, fornecedores.getContaEmpresa().getId());
			stmt.setString(2, fornecedores.getNome());
			stmt.setString(3, fornecedores.getCnpj());
			stmt.setString(4, fornecedores.getEndereco());
			stmt.setString(5, fornecedores.getTelefone());
			stmt.setString(6, fornecedores.getEmail());
			stmt.setString(7, fornecedores.getCategoriaFornecedor());
//			stmt.setBoolean(8, fornecedores.getStatus);
			
			Date date = Date.valueOf(fornecedores.getProgramacaoPagamento());
			stmt.setDate(9, date);
			



			
			stmt.executeUpdate();
			
			System.out.println("INFO: Seu saldo atual no valor de: " + fornecedores + ", foi cadastrado!!");
			
		} catch (SQLException erro){
			System.err.println("Erro ao cadastrar o saldo atual no banco de dados!");
			erro.printStackTrace();
	
		} finally {
			stmt.close();
			conexao.close();
		}
	}
}
