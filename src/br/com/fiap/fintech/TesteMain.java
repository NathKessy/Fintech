package br.com.fiap.fintech;

import java.time.LocalDate;

import br.com.fiap.fintech.dao.Conexao;
import br.com.fiap.fintech.model.Despesas;
import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.model.Saldo;
import br.com.fiap.fintech.model.enums.TipoMoeda;
import br.com.fiap.fintech.model.enums.TipoTransacao;

public class TesteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Conexao.abrirConexao();
			
			Saldo saldo = new Saldo();
			saldo.setId(1);
			saldo.setSaldoAtual(200);
			saldo.setTipoMoeda(TipoMoeda.DOLAR);
			saldo.setDataAtualizacao(LocalDate.now());
			
			System.out.println(	"INFO: " + saldo);
			
			Receita receita = new Receita();
			receita.setId(2);
			receita.setDataRegistro(LocalDate.now());
			receita.setDataTransacao(LocalDate.now());
			receita.setDescricaoTransacao("Transferência entre contas");
			receita.setNomeTransacao("Roberto Almeida");
			receita.setTipoTransacao(TipoTransacao.PIX);
			
			System.out.println("INFO: " + receita);
			
			Despesas despesaa = new Despesas(3, LocalDate.now(), "Reunião RH", 1, "Setor RH", 1500);
			
			System.out.println("INFO: " + despesaa);
			
	}

}
