package br.com.fiap.fintech.model;

import java.time.LocalDate;

import br.com.fiap.fintech.model.enums.TipoMoedaEnum;

public class Saldo {
	
	
	private int id;
	//private int id_conta_saldo_atual;
	private double saldoAtual;
	private LocalDate dataAtualizacao;
	private TipoMoedaEnum tipoMoeda;
	
	public Saldo(){}
	
	public Saldo(int id, double saldoAtual, LocalDate dataAtualizacao, TipoMoedaEnum tipoMoeda) {
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

	public TipoMoedaEnum getTipoMoeda() {
		return tipoMoeda;
	}

	public void setTipoMoeda(TipoMoedaEnum tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}	
	
	@Override
	public String toString() {
		return "Saldo [id=" + id + ", saldoAtual=" + saldoAtual + ", dataAtualizacao=" + dataAtualizacao
				+ ", tipoMoeda=" + tipoMoeda + "]";
	}
}
