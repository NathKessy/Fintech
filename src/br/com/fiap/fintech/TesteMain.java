package br.com.fiap.fintech;

import java.sql.SQLException;
import java.time.LocalDate;

import br.com.fiap.fintech.dao.ContaEmpresaDAO;
import br.com.fiap.fintech.dao.FornecedoresDAO;
import br.com.fiap.fintech.dao.InvestimentosDAO;
import br.com.fiap.fintech.dao.ReceitaDAO;
import br.com.fiap.fintech.dao.SaldoDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.model.ContaEmpresa;
import br.com.fiap.fintech.model.Fornecedores;
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
//		final String INFO = "INFO: ";

		UsuarioDAO usuarioDao = new UsuarioDAO();
		ContaEmpresaDAO contaEmpresaDao = new ContaEmpresaDAO();

		Usuario usuario = new Usuario();
		usuario.setEmail("dias.thyala@gmail.com");
		usuario.setLoginEmpresa("Thyala");
		usuario.setSenha("15975");

		usuarioDao.adicionar(usuario);

		Usuario userDb = usuarioDao.getById(21);

		ContaEmpresa contaEmpresa = new ContaEmpresa(2, userDb, "101", TipoContaEnum.CONTA_PREMIUM, true,
				LocalDate.now());
		contaEmpresaDao.adicionar(contaEmpresa);

		Saldo saldo = new Saldo();
		saldo.setId(13);
		saldo.setContaEmpresa(contaEmpresa);
		saldo.setSaldoAtual(200);
		saldo.setTipoMoeda(TipoMoedaEnum.DOLAR);
		saldo.setDataAtualizacao(LocalDate.now());

		SaldoDAO saldoDao = new SaldoDAO();
		saldoDao.adicionar(saldo);

		Receita receita = new Receita();
		receita.setId(17);
		receita.setContaEmpresa(contaEmpresa);
		receita.setDataRegistro(LocalDate.now());
		receita.setDataTransacao(LocalDate.now());
		receita.setDescricaoTransacao("Transferência entre contas");
		receita.setNomeTransacao("Roberto Almeida");
		receita.setTipoTransacao(TipoTransacaoEnum.PIX);

		ReceitaDAO receitaDao = new ReceitaDAO();
		receitaDao.adicionar(receita);

		Investimento investimento = new Investimento(14, contaEmpresa, TipoInvestimentoEnum.RENDA_FIXA, 3000,
				LocalDate.now(), LocalDate.now(), "Aplicação direta Renner", StatusEnum.AGENDADO, LocalDate.now());

		InvestimentosDAO investiDao = new InvestimentosDAO();
		investiDao.adicionar(investimento);
		
		Fornecedores forncedores = new Fornecedores(1, contaEmpresa, "Lucas Silva", "12.345.678/00001-10", "Japão Liberdade",
				"(11)4002-8922", "lucasfodase@live.com", "Fornecedor de tecido", true, LocalDate.now(), null);
		
		FornecedoresDAO fornecedoresDao = new FornecedoresDAO();
		fornecedoresDao.adicionar(forncedores);
		
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
