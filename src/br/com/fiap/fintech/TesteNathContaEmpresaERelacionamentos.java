package br.com.fiap.fintech;

import java.sql.SQLException;
import java.time.LocalDate;

import br.com.fiap.fintech.dao.ContaEmpresaDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.model.ContaEmpresa;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.model.enums.TipoContaEnum;

public class TesteNathContaEmpresaERelacionamentos {
	
	public static void main(String[] args) throws SQLException {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		ContaEmpresaDAO contaEmpresaDao = new ContaEmpresaDAO();
		
		Usuario userDb = usuarioDao.getById(21);
		
		ContaEmpresa contaEmpresa = new ContaEmpresa(2, userDb, "101", TipoContaEnum.CONTA_PREMIUM, true,
				LocalDate.now());
		contaEmpresaDao.adicionar(contaEmpresa);
		
		System.out.println("\nListando todas contas empresas registradas:");
		for (ContaEmpresa contEmpresa : contaEmpresaDao.getAll()) {
			System.out.println(contEmpresa);
		}
	}

}
