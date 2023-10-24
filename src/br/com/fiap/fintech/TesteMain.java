package br.com.fiap.fintech;

import java.sql.SQLException;
import java.time.LocalDate;

import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.model.ContaEmpresa;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.model.enums.TipoContaEnum;

public class TesteMain {

	public static void main(String[] args) throws SQLException {
		final String INFO = "INFO: ";
	
		Usuario usuario = new Usuario();  
		usuario.setEmail("dias.thyala@gmail.com");
		usuario.setId(1);
		usuario.setLoginEmpresa("Thyala");
		usuario.setSenha("15975");
		
		ContaEmpresa contaEmpresa = new ContaEmpresa(1, usuario, 101, TipoContaEnum.CONTA_VIP, true, LocalDate.now());
		System.out.println(INFO + contaEmpresa);

		// Persistindo usuário no banco de dados
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.adicionar(usuario);
		usuarioDao.delete(4);
		
		System.out.println("\n Buscando um usuário especifico");
		System.out.println(usuarioDao.getById(1)); // NÃO É OBRIGATÓRIO!! 
		
		System.out.println("\n *** Lista de usuário *** ");
		for(Usuario user : usuarioDao.getAll()) {
			System.out.println(user);
		}
		
		
		
//		Empresa empresa = new Empresa(1, usuario, "Lucas", "LucasFds", "12.345.678/0001-10", 150000, "05562-025", 
//				"1137822930", "lucasfds@gmail.com", "Rua da Luz", 370000);
//		
//		System.out.println(INFO + empresa);
//		
//
//		Saldo saldo = new Saldo();
//		saldo.setId(1);
//		saldo.setContaEmpresa(contaEmpresa);
//		saldo.setSaldoAtual(200);
//		saldo.setTipoMoeda(TipoMoedaEnum.DOLAR);
//		saldo.setDataAtualizacao(LocalDate.now());
//
//		System.out.println(INFO + saldo);
//
//		Receita receita = new Receita();
//		receita.setId(2);
//		receita.setContaEmpresa(contaEmpresa);
//		receita.setDataRegistro(LocalDate.now());
//		receita.setDataTransacao(LocalDate.now());
//		receita.setDescricaoTransacao("Transferência entre contas");
//		receita.setNomeTransacao("Roberto Almeida");
//		receita.setTipoTransacao(TipoTransacaoEnum.PIX);
//
//		System.out.println(INFO + receita);
//
//		Despesas despesaa = new Despesas(3, contaEmpresa, LocalDate.now(), "Reunião RH", 1, "Setor RH", 1500);
//		System.out.println(INFO + despesaa);
//
//		Investimento investimento = new Investimento(1, contaEmpresa, TipoInvestimentoEnum.RENDA_FIXA, 3000, LocalDate.now(),
//				LocalDate.now(), "Aplicação direta Renner", StatusEnum.AGENDADO, LocalDate.now());
//
//		System.out.println(INFO + investimento);
//
//		Fornecedores forncedores = new Fornecedores(1, contaEmpresa, "Lucas Silva", "12.345.678/00001-10", "Japão Liberdade",
//				"(11)4002-8922", "lucasfodase@live.com", "Fornecedor de tecido", true, LocalDate.now());
//
//		System.out.println(INFO + forncedores);
     
	}
}
