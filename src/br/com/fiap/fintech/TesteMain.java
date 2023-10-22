package br.com.fiap.fintech;

import java.time.LocalDate;

import br.com.fiap.fintech.dao.Conexao;
import br.com.fiap.fintech.model.ContaEmpresa;
import br.com.fiap.fintech.model.Despesas;
import br.com.fiap.fintech.model.Fornecedores;
import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.model.Saldo;
import br.com.fiap.fintech.model.enums.StatusEnum;
import br.com.fiap.fintech.model.enums.TipoInvestimentoEnum;
import br.com.fiap.fintech.model.enums.TipoMoedaEnum;
import br.com.fiap.fintech.model.enums.TipoTransacaoEnum;
import br.com.fiap.fintech.model.enums.TipoContaEnum;

public class TesteMain {

	public static void main(String[] args) {
		Conexao.abrirConexao();

		final String INFO = "INFO: ";
		
		ContaEmpresa contaEmpresa = new ContaEmpresa(1, 101, TipoContaEnum.CONTA_VIP, true, LocalDate.now());
		
		System.out.println(INFO + contaEmpresa);

		Saldo saldo = new Saldo();
		saldo.setId(1);
		saldo.setSaldoAtual(200);
		saldo.setTipoMoeda(TipoMoedaEnum.DOLAR);
		saldo.setDataAtualizacao(LocalDate.now());

		System.out.println(INFO + saldo);

		Receita receita = new Receita();
		receita.setId(2);
		receita.setDataRegistro(LocalDate.now());
		receita.setDataTransacao(LocalDate.now());
		receita.setDescricaoTransacao("Transferência entre contas");
		receita.setNomeTransacao("Roberto Almeida");
		receita.setTipoTransacao(TipoTransacaoEnum.PIX);

		System.out.println(INFO + receita);

		Despesas despesaa = new Despesas(3, LocalDate.now(), "Reunião RH", 1, "Setor RH", 1500);
		System.out.println(INFO + despesaa);

		Investimento investimento = new Investimento(1, TipoInvestimentoEnum.RENDA_FIXA, 3000, LocalDate.now(),
				LocalDate.now(), "Aplicação direta Renner", StatusEnum.AGENDADO, LocalDate.now());

		System.out.println(INFO + investimento);

		Fornecedores forncedores = new Fornecedores(1, "Lucas Silva", "12.345.678/00001-10", "Japão Liberdade",
				"(11)4002-8922", "lucasfodase@live.com", "Fornecedor de tecido", true, LocalDate.now());

		System.out.println(INFO + forncedores);

	}
}
