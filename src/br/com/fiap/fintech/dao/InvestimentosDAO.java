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
import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.model.enums.StatusEnum;
import br.com.fiap.fintech.model.enums.TipoInvestimentoEnum;

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
					+ "    VALUES (sq_investimento.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			
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

	public List<Investimento> getAll() throws SQLException {
		List<Investimento> lista = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conexao = null;
		ResultSet rs = null;
		
		ContaEmpresaDAO contaEmpresaDAO = new ContaEmpresaDAO();
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_investimentos order by id_investimentos asc";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID_INVESTIMENTOS");
				int idEmpresa = rs.getInt("T_CONTA_EMPRESA_ID_CONTA");
				String tipoInvestimento = rs.getString("TIPO_INVEST");
				double valorInvestido = rs.getDouble("VALOR_INVESTIDO");
				Date dataInicio = rs.getDate("DATA_INICIO");
				Date dataRegaste = rs.getDate("DATA_RESGATE");
				String descricaoInvestimento = rs.getString("DESCRICAO_INVEST");
				String status = rs.getString("STATUS");
				Date dataRegistro = rs.getDate("DATA_REGISTRO");
				
				ContaEmpresa contaEmpresa = contaEmpresaDAO.getById(idEmpresa);

				@SuppressWarnings("deprecation")
				LocalDate dateInicio = LocalDate.of(dataInicio.getYear(), dataInicio.getMonth(), dataInicio.getDay());
				
				@SuppressWarnings("deprecation")
				LocalDate dateRegaste = LocalDate.of(dataRegaste.getYear(), dataRegaste.getMonth(), dataRegaste.getDay());
				
				@SuppressWarnings("deprecation")
				LocalDate dateRegistro = LocalDate.of(dataRegistro.getYear(), dataRegistro.getMonth(), dataRegistro.getDay());

				Investimento investimento = new Investimento(id, contaEmpresa, TipoInvestimentoEnum.valueOf(tipoInvestimento), valorInvestido, dateInicio, 
						dateRegaste, descricaoInvestimento, StatusEnum.valueOf(status), dateRegistro);
				lista.add(investimento);
				
			}

		} catch (SQLException e) {
			System.err.println("Erro ao listar investimento ao banco de dados!");
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			conexao.close();
		}

		return lista;
	}
}
