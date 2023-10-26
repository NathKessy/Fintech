package br.com.fiap.fintech;

import java.sql.SQLException;
import java.time.LocalDate;

import br.com.fiap.fintech.dao.ContaEmpresaDAO;
import br.com.fiap.fintech.dao.SaldoDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.model.ContaEmpresa;
import br.com.fiap.fintech.model.Saldo;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.model.enums.TipoContaEnum;
import br.com.fiap.fintech.model.enums.TipoMoedaEnum;

public class TesteNathContaEmpresaERelacionamentos {
	
	public static void main(String[] args) throws SQLException {
		
		SaldoDAO saldoDao = new SaldoDAO();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		ContaEmpresaDAO contaEmpresaDao = new ContaEmpresaDAO();
		
		Usuario userDb = usuarioDao.getById(1);
		
		ContaEmpresa contaEmpresa = new ContaEmpresa(1, userDb, "101", TipoContaEnum.CONTA_PREMIUM, true,
				LocalDate.now());
		contaEmpresaDao.adicionar(contaEmpresa);
		
		System.out.println("\nListando todas contas empresas registradas:");
		for (ContaEmpresa contEmpresa : contaEmpresaDao.getAll()) {
			System.out.println(contEmpresa);
		}
		
		System.out.println("\n*** Saldo ***");
		Saldo saldo = new Saldo(1, contaEmpresa, 300.0, LocalDate.now(),TipoMoedaEnum.EURO);
		saldoDao.adicionar(saldo);

		System.out.println("\nListando todos os Saldos registrados:");
		for (Saldo saldoLista : saldoDao.getAll()) {
			System.out.println(saldoLista);
		}
	}

}
