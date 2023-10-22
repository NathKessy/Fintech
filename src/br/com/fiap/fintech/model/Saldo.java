package br.com.fiap.fintech.model;

import java.time.LocalDate;

import br.com.fiap.fintech.model.enums.TipoMoeda;

public class Saldo {
	
	
	private int id;
	//private int id_conta_saldo_atual;
	private double saldoAtual;
	private LocalDate dataAtualizacao;
	private TipoMoeda tipoMoeda;
	
	public Saldo(){}
	
	public Saldo(int id, double saldoAtual, LocalDate dataAtualizacao, TipoMoeda tipoMoeda) {
		super();
		this.id = id;
		this.saldoAtual = saldoAtual;
		this.dataAtualizacao = dataAtualizacao;
		this.tipoMoeda = tipoMoeda;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public TipoMoeda getTipoMoeda() {
		return tipoMoeda;
	}

	public void setTipoMoeda(TipoMoeda tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}	
	
	@Override
	public String toString() {
		return "Saldo [id=" + id + ", saldoAtual=" + saldoAtual + ", dataAtualizacao=" + dataAtualizacao
				+ ", tipoMoeda=" + tipoMoeda + "]";
	}
}
