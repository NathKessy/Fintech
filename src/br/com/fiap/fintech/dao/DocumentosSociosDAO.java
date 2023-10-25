package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.fintech.model.DocumentosSocios;

public class DocumentosSociosDAO {
	
	public void adicionar (DocumentosSocios documentosSocios) throws SQLException {
		if (documentosSocios.getEmpresa().getId() == null) {
			System.out.println("ID não localizado na base de dados");
			return;
		}
		
		Connection conexao = null;
		PreparedStatement stmt = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO t_saldo (ID_SOCIOS, T_EMPRESA_ID_EMPRESA, NOME, RG, CPF, DATA_NASC, ESTADO_CIVIL, NACIONALIDADE, ENDERECO)"
					+ "    VALUES (sq_fintech.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, documentosSocios.getEmpresa().getId());
			stmt.setString(2, documentosSocios.getNome().toString());
			stmt.setString(3, documentosSocios.getRg().toString());
			stmt.setString(4, documentosSocios.getCpf().toString());
			stmt.setString(6, documentosSocios.getEstadoCivil().toString());
			stmt.setString(7, documentosSocios.getNacionalidade().toString());
			stmt.setString(8, documentosSocios.getEndereco().toString());
			
			Date date = Date.valueOf(documentosSocios.getDataNascimento());
			stmt.setDate(5, date);
			
			stmt.executeUpdate();
			
			System.out.println("INFO: Documentos Socios " + documentosSocios.getNome() + " cadastrado!!");
			
		} catch (SQLException erro){
			System.err.println("Erro ao cadastrar o Documento Socios atual no banco de dados!");
			erro.printStackTrace();
	
		} finally {
			stmt.close();
			conexao.close();
		}
		
		
		
	}
}