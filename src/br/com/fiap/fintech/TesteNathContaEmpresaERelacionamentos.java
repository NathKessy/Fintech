package br.com.fiap.fintech;

import java.sql.SQLException;
import java.time.LocalDate;

import br.com.fiap.fintech.dao.ContaEmpresaDAO;
import br.com.fiap.fintech.dao.EnderecoDAO;
import br.com.fiap.fintech.dao.FornecedoresDAO;
import br.com.fiap.fintech.dao.SaldoDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.model.ContaEmpresa;
import br.com.fiap.fintech.model.Fornecedores;
import br.com.fiap.fintech.model.Saldo;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.model.enums.TipoContaEnum;
import br.com.fiap.fintech.model.enums.TipoMoedaEnum;

public class TesteNathContaEmpresaERelacionamentos {
	
	public static void main(String[] args) throws SQLException {
		
		SaldoDAO saldoDao = new SaldoDAO();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		EnderecoDAO enderecodao = new EnderecoDAO();
		FornecedoresDAO fornecedoresDAO = new FornecedoresDAO();
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
		
		System.out.println("\n*** Fornecedores ***");
		Fornecedores fornecedores = new Fornecedores(1, contaEmpresa, "Gabriela Caixas", "1234567", enderecodao.getById(1) , 1234567, "gabriela@caixas.com", "ENUM? CATEGORIAFOR", true, LocalDate.now(), "Fornecedor de caixas");
		fornecedoresDAO.adicionar(fornecedores);
		
		System.out.println("\nListando todos os Fornecedores registrados:");
		for (Fornecedores forn : fornecedoresDAO.getAll()) {
			System.out.println(forn);
		}
	}

}
