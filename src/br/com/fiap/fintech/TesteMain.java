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

public class TesteMain {

	public static void main(String[] args) throws SQLException {

		SaldoDAO saldoDao = new SaldoDAO();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		ContaEmpresaDAO contaEmpresaDao = new ContaEmpresaDAO();
		
		Usuario usuario = usuarioDao.getById(21);

		System.out.println("*** Conta Empresa ***");
		ContaEmpresa contaEmpresa = new ContaEmpresa(2, usuario, "101", TipoContaEnum.CONTA_PREMIUM, true, LocalDate.now());
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

//		System.out.println();
//		Receita receita = new Receita();
//		receita.setId(17);
//		receita.setContaEmpresa(contaEmpresa);
//		receita.setDataRegistro(LocalDate.now());
//		receita.setDataTransacao(LocalDate.now());
//		receita.setDescricaoTransacao("Transferência entre contas");
//		receita.setNomeTransacao("Roberto Almeida");
//		receita.setTipoTransacao(TipoTransacaoEnum.PIX);
//
//		ReceitaDAO receitaDao = new ReceitaDAO();
//		receitaDao.adicionar(receita);
//
//		Investimento investimento = new Investimento(14, contaEmpresa, TipoInvestimentoEnum.RENDA_FIXA, 3000,
//				LocalDate.now(), LocalDate.now(), "Aplicação direta Renner", StatusEnum.AGENDADO, LocalDate.now());
//
//		InvestimentosDAO investiDao = new InvestimentosDAO();
//		investiDao.adicionar(investimento);
//		
//		Fornecedores forncedores = new Fornecedores(1, contaEmpresa, "Lucas Silva", "12.345.678/00001-10", "Japão Liberdade",
//				140028922, "lucasfodase@live.com", "Fornecedor de tecido", true, LocalDate.now(), "Pagamentos Loja Animex");
//		
//		FornecedoresDAO fornecedoresDao = new FornecedoresDAO();
//		fornecedoresDao.adicionar(forncedores);
//		
//		Empresa empresa = new Empresa(1, usuario, "Lucas", "LucasFds", "12.345.678/0001-10", 150000, "05562-025", 
//				"1137822930", "lucasfds@gmail.com", "Rua da Luz", 370000);
//		
//		System.out.println(INFO + empresa);
//		
//
//
//		System.out.println(INFO + saldo);
//
//
//		Despesas despesaa = new Despesas(3, contaEmpresa, LocalDate.now(), "Reunião RH", 1, "Setor RH", 1500);
//		System.out.println(INFO + despesaa);
//
//


	}
}
