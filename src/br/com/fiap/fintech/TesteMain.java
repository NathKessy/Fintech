package br.com.fiap.fintech;

import java.sql.SQLException;
import java.time.LocalDate;

import br.com.fiap.fintech.dao.ContaEmpresaDAO;
import br.com.fiap.fintech.dao.DespesasDAO;
import br.com.fiap.fintech.dao.InvestimentosDAO;
import br.com.fiap.fintech.dao.ReceitaDAO;
import br.com.fiap.fintech.dao.SaldoDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.model.ContaEmpresa;
import br.com.fiap.fintech.model.Despesas;
import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.model.Saldo;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.model.enums.StatusEnum;
import br.com.fiap.fintech.model.enums.TipoContaEnum;
import br.com.fiap.fintech.model.enums.TipoInvestimentoEnum;
import br.com.fiap.fintech.model.enums.TipoMoedaEnum;
import br.com.fiap.fintech.model.enums.TipoTransacaoEnum;

public class TesteMain {

	public static void main(String[] args) throws SQLException {

		//DAO
		SaldoDAO saldoDao = new SaldoDAO();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		ReceitaDAO receitaDao = new ReceitaDAO();
		DespesasDAO despesasDao = new DespesasDAO();
		InvestimentosDAO investiDao = new InvestimentosDAO();
		ContaEmpresaDAO contaEmpresaDao = new ContaEmpresaDAO();
		
		Usuario usuario = usuarioDao.getById(1);

		// Conta Empresa
		System.out.println("*** Conta Empresa ***");
		ContaEmpresa contaEmpresa = new ContaEmpresa(1, usuario, "101", TipoContaEnum.CONTA_PREMIUM, true, LocalDate.now());
		contaEmpresaDao.adicionar(contaEmpresa);
		
		System.out.println("\nListando todas contas empresas registradas:");
		for (ContaEmpresa contEmpresa : contaEmpresaDao.getAll()) {
			System.out.println(contEmpresa);
		}

		// Saldo
		System.out.println("\n*** Saldo ***");
		Saldo saldo = new Saldo(1, contaEmpresa, 300.0, LocalDate.now(),TipoMoedaEnum.EURO);
		saldoDao.adicionar(saldo);

		System.out.println("\nListando todos os Saldos registrados:");
		for (Saldo saldoLista : saldoDao.getAll()) {
			System.out.println(saldoLista);
		}
		
		// Receita
		System.out.println("\n*** Receita **** ");
		Receita receita = new Receita(1, contaEmpresa, "Lindinha", TipoTransacaoEnum.DEBITO, 
				"Transferência entre contas", LocalDate.now(), LocalDate.now());
		receitaDao.adicionar(receita);
		
		System.out.println("\nListando todas as receitas registradas:");
		for (Receita receitaLista : receitaDao.getAll()) {
			System.out.println(receitaLista);
		}
		
		// Investimento
		System.out.println("\n*** Investimento ***");
		Investimento investimento = new Investimento(1, contaEmpresa, TipoInvestimentoEnum.RENDA_VARIAVEL, 5000,
				LocalDate.now(), LocalDate.now(), "Aplicação direta Cobasi", StatusEnum.ACEITO, LocalDate.now());
		investiDao.adicionar(investimento);

		System.out.println("\nListando todos os investimento registrados:");
		for (Investimento investimentoLista : investiDao.getAll()) {
			System.out.println(investimentoLista);
		}
		
		// Despesas
		System.out.println("\n*** Despesas ****");
		Despesas despesaa = new Despesas(1, contaEmpresa, LocalDate.now(), "Comprar tecidos", 1000, 
				"Loja de Fantasia Simbista", 15000);
		despesasDao.adicionar(despesaa);
		
		System.out.println("\nListando todas as despesas:");
		for (Despesas despesasLista : despesasDao.getAll()) {
			System.out.println(despesasLista);
		}
	}
}
