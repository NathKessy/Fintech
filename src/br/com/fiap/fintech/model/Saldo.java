package br.com.fiap.fintech.model;

import java.time.LocalDate;

import br.com.fiap.fintech.model.enums.TipoMoedaEnum;

public class Saldo {
	
	private Integer id;
	private ContaEmpresa contaEmpresa;
	private double saldoAtual;
	private LocalDate dataAtualizacao;
	private TipoMoedaEnum tipoMoeda;
	
	public Saldo(){}

	public Saldo(Integer id, ContaEmpresa contaEmpresa, double saldoAtual, LocalDate dataAtualizacao,
			TipoMoedaEnum tipoMoeda) {
		super();
		this.id = id;
		this.contaEmpresa = contaEmpresa;
		this.saldoAtual = saldoAtual;
		this.dataAtualizacao = dataAtualizacao;
		this.tipoMoeda = tipoMoeda;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ContaEmpresa getContaEmpresa() {
		return contaEmpresa;
	}

	public void setContaEmpresa(ContaEmpresa contaEmpresa) {
		this.contaEmpresa = contaEmpresa;
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
		return "Saldo [id=" + id + ", contaEmpresa=" + contaEmpresa + ", saldoAtual=" + saldoAtual
				+ ", dataAtualizacao=" + dataAtualizacao + ", tipoMoeda=" + tipoMoeda + "]";
	}
}
