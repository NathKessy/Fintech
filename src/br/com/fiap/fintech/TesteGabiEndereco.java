package br.com.fiap.fintech;

import java.sql.SQLException;

import br.com.fiap.fintech.dao.EnderecoDAO;
import br.com.fiap.fintech.model.Cidade;
import br.com.fiap.fintech.model.Endereco;
import br.com.fiap.fintech.model.Estado;
import br.com.fiap.fintech.model.Pais;

public class TesteGabiEndereco {
	
	public static void main(String[] args) throws SQLException {
		
		EnderecoDAO dao = new EnderecoDAO();
		
		Pais pais = new Pais(1, "Brasil", "BR");
		Cidade cidade = new Cidade(1, "São Paulo");
		Estado estado = new Estado(1, "São Paulo", "SP");
		
		Endereco endereco = new Endereco(1, estado, cidade, pais, "Rua Parainense", "São Bernadence", "1001", "21345678");
		
		dao.adicionar(endereco);
		
		for (Endereco retornoEndereco : dao.getAll()) {
			System.out.println(retornoEndereco);
		}
		
	}
	

}
