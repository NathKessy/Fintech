package br.com.fiap.fintech.model;

import java.time.LocalDate;

import br.com.fiap.fintech.model.enums.StatusEnum;
import br.com.fiap.fintech.model.enums.TipoInvestimentoEnum;

public class Investimento {

	private int id;
//	private int idContaEmpresa;
	private TipoInvestimentoEnum tipoInvestimento;
	private double valorInvestido;
	private LocalDate dataInicio;
	private LocalDate dataResgate;
	private String descricaoInvestimento;
	private StatusEnum status;
	private LocalDate dataRegistro;
	
	public Investimento(){}

	public Investimento(int id, TipoInvestimentoEnum tipoInvestimento, double valorInvestido, LocalDate dataInicio,
			LocalDate dataResgate, String descricaoInvestimento, StatusEnum status, LocalDate dataRegistro) {
		super();
		this.id = id;
		this.tipoInvestimento = tipoInvestimento;
		this.valorInvestido = valorInvestido;
		this.dataInicio = dataInicio;
		this.dataResgate = dataResgate;
		this.descricaoInvestimento = descricaoInvestimento;
		this.status = status;
		this.dataRegistro = dataRegistro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoInvestimentoEnum getTipoInvestimento() {
		return tipoInvestimento;
	}

	public void setTipoInvestimento(TipoInvestimentoEnum tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}

	public double getValorInvestido() {
		return valorInvestido;
	}

	public void setValorInvestido(double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataResgate() {
		return dataResgate;
	}

	public void setDataResgate(LocalDate dataResgate) {
		this.dataResgate = dataResgate;
	}

	public String getDescricaoInvestimento() {
		return descricaoInvestimento;
	}

	public void setDescricaoInvestimento(String descricaoInvestimento) {
		this.descricaoInvestimento = descricaoInvestimento;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	@Override
	public String toString() {
		return "Investimento [id=" + id + ", tipoInvestimento=" + tipoInvestimento + ", valorInvestido="
				+ valorInvestido + ", dataInicio=" + dataInicio + ", dataResgate=" + dataResgate
				+ ", descricaoInvestimento=" + descricaoInvestimento + ", status=" + status + ", dataRegistro="
				+ dataRegistro + "]";
	}
}