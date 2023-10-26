package br.com.fiap.fintech;

import java.sql.SQLException;

import br.com.fiap.fintech.dao.EmpresaDAO;
import br.com.fiap.fintech.dao.EnderecoDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.model.Cidade;
import br.com.fiap.fintech.model.Empresa;
import br.com.fiap.fintech.model.Endereco;
import br.com.fiap.fintech.model.Estado;
import br.com.fiap.fintech.model.Pais;
import br.com.fiap.fintech.model.Usuario;

public class TesteThyalaEmpresaUsuario {
	
	public static void main(String[] args) throws SQLException {
		
		EnderecoDAO enderecoDao = new EnderecoDAO();
		EmpresaDAO empresaDao = new EmpresaDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Pais pais = new Pais(1, "Brasil", "BR");
		Cidade cidade = new Cidade(1, "São Paulo");
		Estado estado = new Estado(1, "São Paulo", "SP");
		
		Endereco endereco = new Endereco(1, estado, cidade, pais, "Rua Parainense", "São Bernadence", "1001", "21345678");
		enderecoDao.adicionar(endereco);
		
		Empresa empresa = new Empresa(1, null, "Simba Investimetos", "Simba Invest", "12345678", 10000.0, "12345678", "40028922", "simba@invest.com", endereco, 10000.0);
		empresaDao.adicionar(empresa);
		
		System.out.println("\nExibindo todas as Empresas cadastrados: ");
		for (Empresa getEmpresa : empresaDao.getAll()) {
			System.out.println(getEmpresa);
		}
		
		Usuario usuario = new Usuario(1, empresa, "gustavo.araujo", "gustavo.araujo@gmail.com", "12345678");
		usuarioDAO.adicionar(usuario);
	}

}
