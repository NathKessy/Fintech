package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.fintech.model.Investimento;

public class InvestimentosDAO {
	
	public void adicionar (Investimento investimento) throws SQLException {
		if (investimento.getContaEmpresa().getId() == null) {
			System.out.println("ID não localizado na base de dados");
			return;
		}
		
		Connection conexao = null;
		PreparedStatement stmt = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO t_investimentos (ID_INVESTIMENTOS, T_CONTA_EMPRESA_ID_CONTA, TIPO_INVEST, VALOR_INVESTIDO, DATA_INICIO, DATA_RESGATE, DESCRICAO_INVEST, STATUS, DATA_REGISTRO)"
					+ "    VALUES (sq_fintech.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, investimento.getContaEmpresa().getId());
			stmt.setString(2, investimento.getTipoInvestimento().toString());
			stmt.setDouble(3, investimento.getValorInvestido());
			
			Date dateInicio = Date.valueOf(investimento.getDataInicio());
			stmt.setDate(4, dateInicio);
			
			Date dataResgate = Date.valueOf(investimento.getDataResgate());
			stmt.setDate(5, dataResgate);
			
			stmt.setString(6, investimento.getDescricaoInvestimento());
			stmt.setString(7, investimento.getStatus().toString());
			
			Date dateRegistro = Date.valueOf(investimento.getDataRegistro());
			stmt.setDate(8, dateRegistro);
			
			stmt.executeUpdate();
			
			System.out.println("INFO: O Investimento: " + investimento.getDescricaoInvestimento() + ", foi cadastrado!!");
			
		} catch (SQLException erro){
			System.err.println("Erro ao cadastrar o investimento atual no banco de dados!");
			erro.printStackTrace();
	
		} finally {
			stmt.close();
			conexao.close();
		}
	}

}
