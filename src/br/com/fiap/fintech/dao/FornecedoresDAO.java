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
import br.com.fiap.fintech.model.Endereco;
import br.com.fiap.fintech.model.Fornecedores;

public class FornecedoresDAO {
	
	public void adicionar (Fornecedores fornecedores) throws SQLException {
		if (fornecedores.getContaEmpresa().getId() == null) {
			System.out.println("ID conta empresa não localizado na base de dados");
			return;
		}
		
		if (fornecedores.getEndereco().getId() == null) {
			System.out.println("ID endereco não localizado na base de dados");
			return;
		}
		
		Connection conexao = null;
		PreparedStatement stmt = null;
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "INSERT INTO t_fornecedores (ID_FORNECEDORES, T_CONTA_EMPRESA_ID_CONTA, NOME, CNPJ, T_ENDERECO_ID_ENDERECO, TELEFONE, EMAIL, CATEGORIA, STATUS, PROG_PAGAMENTO, DESCRICAO_FORNECEDOR)"
					+ "    VALUES (SQ_FORNECEDORES.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setObject(1, fornecedores.getContaEmpresa().getId());
			stmt.setString(2, fornecedores.getNome());
			stmt.setString(3, fornecedores.getCnpj());
			stmt.setObject(4, fornecedores.getEndereco().getId());
			stmt.setInt(5, fornecedores.getTelefone());
			stmt.setString(6, fornecedores.getEmail());
			stmt.setString(7, fornecedores.getCategoriaFornecedor());
			stmt.setBoolean(8, fornecedores.isStatus());
			
			Date date = Date.valueOf(fornecedores.getProgramacaoPagamento());
			stmt.setDate(9, date);
			
			stmt.setString(10, fornecedores.getDescricaoFornecedores());

			stmt.executeUpdate();
			
			System.out.println("INFO: Fornecedor(a): " + fornecedores.getNome() + ", foi cadastrado!!");
			
		} catch (SQLException erro){
			System.err.println("Erro ao cadastrar o fornecedores no banco de dados!");
			erro.printStackTrace();
	
		} finally {
			stmt.close();
			conexao.close();
		}
	}
	
	public List<Fornecedores> getAll() throws SQLException {
		List<Fornecedores> lista = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conexao = null;
		ResultSet rs = null;
		
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		ContaEmpresaDAO contaEmpresaDAO = new ContaEmpresaDAO();
		
		try {
			conexao = Conexao.abrirConexao();
			String sql = "select * from t_fornecedores order by ID_FORNECEDORES asc";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ID_FORNECEDORES");
				int idContaEmpresa = rs.getInt("T_CONTA_EMPRESA_ID_CONTA");
				String nome = rs.getString("NOME");
				String cnpj = rs.getString("CNPJ");
				int idEndereco = rs.getInt("T_ENDERECO_ID_ENDERECO");
				int telefone = rs.getInt("TELEFONE");
				String email = rs.getString("EMAIL");
				String categoria = rs.getString("CATEGORIA");
				Boolean status = rs.getBoolean("STATUS");
				Date dateProgPagamentos = rs.getDate("PROG_PAGAMENTO");
				String historicoPagamento = rs.getString("DESCRICAO_FORNECEDOR");
				
				@SuppressWarnings("deprecation")
				LocalDate programacaoPagamento = LocalDate.of(dateProgPagamentos.getYear(), dateProgPagamentos.getMonth(), dateProgPagamentos.getDay());
				
				Endereco endereco = enderecoDAO.getById(idEndereco);
				ContaEmpresa contaEmpresa = contaEmpresaDAO.getById(idContaEmpresa);
				
				Fornecedores fornecedor = new Fornecedores(id, contaEmpresa, nome, cnpj, endereco, telefone, email, categoria, status, programacaoPagamento, historicoPagamento);
				lista.add(fornecedor);
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
}
