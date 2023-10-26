package br.com.fiap.fintech;

import java.sql.SQLException;
import java.time.LocalDate;

import br.com.fiap.fintech.dao.ComprovantesDAO;
import br.com.fiap.fintech.dao.ContaEmpresaDAO;
import br.com.fiap.fintech.dao.DespesasDAO;
import br.com.fiap.fintech.dao.DocumentosSociosDAO;
import br.com.fiap.fintech.dao.EmpresaDAO;
import br.com.fiap.fintech.dao.EnderecoDAO;
import br.com.fiap.fintech.dao.FornecedoresDAO;
import br.com.fiap.fintech.dao.InvestimentosDAO;
import br.com.fiap.fintech.dao.ReceitaDAO;
import br.com.fiap.fintech.dao.SaldoDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.model.Cidade;
import br.com.fiap.fintech.model.Comprovantes;
import br.com.fiap.fintech.model.ContaEmpresa;
import br.com.fiap.fintech.model.Despesas;
import br.com.fiap.fintech.model.DocumentosSocios;
import br.com.fiap.fintech.model.Empresa;
import br.com.fiap.fintech.model.Endereco;
import br.com.fiap.fintech.model.Estado;
import br.com.fiap.fintech.model.Fornecedores;
import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.model.Pais;
import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.model.Saldo;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.model.enums.StatusEnum;
import br.com.fiap.fintech.model.enums.TipoComprovanteEnum;
import br.com.fiap.fintech.model.enums.TipoContaEnum;
import br.com.fiap.fintech.model.enums.TipoInvestimentoEnum;
import br.com.fiap.fintech.model.enums.TipoMoedaEnum;
import br.com.fiap.fintech.model.enums.TipoTransacaoEnum;

public class Main {

	public static void main(String[] args) throws SQLException {

		SaldoDAO saldoDao 						= new SaldoDAO();
		EmpresaDAO empresaDao			        = new EmpresaDAO();
		UsuarioDAO usuarioDAO 					= new UsuarioDAO();
		ReceitaDAO receitaDao 					= new ReceitaDAO();
		DespesasDAO despesasDao 				= new DespesasDAO();
		EnderecoDAO enderecoDao 				= new EnderecoDAO();
		InvestimentosDAO investiDao             = new InvestimentosDAO();
		ContaEmpresaDAO contaEmpresaDao         = new ContaEmpresaDAO();
		ComprovantesDAO comprovantesDAO         = new ComprovantesDAO();
		FornecedoresDAO fornecedoresDAO         = new FornecedoresDAO();
		DocumentosSociosDAO documentosSociosDAO = new DocumentosSociosDAO();

		// Endereço
		Pais pais = new Pais(1, "Brasil", "BR");
		Cidade cidade = new Cidade(1, "São Paulo");
		Estado estado = new Estado(1, "São Paulo", "SP");

		System.out.println("*** Endereço ***");
		Endereco endereco = new Endereco(1, estado, cidade, pais, "Rua Parainense", "São Bernadence", "1001", "21345678");
		enderecoDao.adicionar(endereco);

		System.out.println("\nListando todos os Endereços cadastrados: ");
		for (Endereco retornoEndereco : enderecoDao.getAll()) {
			System.out.println(retornoEndereco);
		}
		
		// Empresa
		System.out.println("\n*** Empresa ***");
		Empresa empresa = new Empresa(1, "Simba Investimetos", "Simba Invest", "12345678", 10000.0, "12345678", "40028922", "simba@invest.com", endereco, 10000.0);
		empresaDao.adicionar(empresa);
		
		System.out.println("\nListando todas as Empresas cadastrados: ");
		for (Empresa getEmpresa : empresaDao.getAll()) {
			System.out.println(getEmpresa);
		}
		
		// Usuario
		System.out.println("\n*** Usuario ***");
		Usuario usuario = new Usuario(1, empresa, "gustavo.araujo", "gustavo.araujo@gmail.com", "12345678");
		usuarioDAO.adicionar(usuario);
		
		System.out.println("\nListando todos os usuarios cadastrados: ");
		for (Usuario user : usuarioDAO.getAll()) {
			System.out.println(user);
		}
		
		// Documentos Sócios
		System.out.println("\n*** DocumentoSocios ***");
		DocumentosSocios documentoSocios = new DocumentosSocios(1, empresa, "Lucas Thyalo", "1234565", "1234567", LocalDate.now(), "Solteiro", "Brasileiro", "Rua Local, 120");
		documentosSociosDAO.adicionar(documentoSocios);
		
		System.out.println("\nListando todos os documentos Socios:");
		for (DocumentosSocios docSocios : documentosSociosDAO.getAll()) {
			System.out.println(docSocios);
		}
		
		// Comprovantes
		System.out.println("\n*** Comprovantes ***");
		Comprovantes comprovante = new Comprovantes(1, documentoSocios, "Rua Lazaro", LocalDate.now(), TipoComprovanteEnum.PAGAMENTO);
		comprovantesDAO.adicionar(comprovante);
		
		System.out.println("\nListando todos comprovantes:");
		for (Comprovantes comprov : comprovantesDAO.getAll()) {
			System.out.println(comprov);
		}
		
		// Conta Empresa
		System.out.println("\n*** Conta Empresa ***");
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
				"Transferência para a conta Lindinha", LocalDate.now(), LocalDate.now());
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
		
		// Fornecedores
		System.out.println("\n*** Fornecedores ***");
		Fornecedores fornecedores = new Fornecedores(1, contaEmpresa, "Thyalo Lucas - Móveis", "1234567", endereco , 1234567, "gabriela@caixas.com", "ENUM? CATEGORIAFOR", true, LocalDate.now(), "Fornecedor de caixas");
		fornecedoresDAO.adicionar(fornecedores);
		
		System.out.println("\nListando todos os Fornecedores registrados:");
		for (Fornecedores forn : fornecedoresDAO.getAll()) {
			System.out.println(forn);
		}
	}
}
