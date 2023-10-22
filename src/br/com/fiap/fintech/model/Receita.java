package br.com.fiap.fintech.model;

import java.time.LocalDate;

import br.com.fiap.fintech.model.enums.TipoTransacao;

public class Receita {

	private int id;
	//private int idContaEmpresa;
	private String nomeTransacao;
	private TipoTransacao tipoTransacao;
	private String descricaoTransacao;
	private LocalDate dataTransacao;
	private LocalDate dataRegistro;
	
	public Receita(){}
	
	public Receita(int id, String nomeTransacao, TipoTransacao tipoTransacao, String descricaoTransacao, LocalDate dataTransacao,
			LocalDate dataRegistro) {
		super();
		this.id = id;
		this.nomeTransacao = nomeTransacao;
		this.tipoTransacao = tipoTransacao;
		this.descricaoTransacao = descricaoTransacao;
		this.dataTransacao = dataTransacao;
		this.dataRegistro = dataRegistro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeTransacao() {
		return nomeTransacao;
	}

	public void setNomeTransacao(String nomeTransacao) {
		this.nomeTransacao = nomeTransacao;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public String getDescricaoTransacao() {
		return descricaoTransacao;
	}

	public void setDescricaoTransacao(String descricaoTransacao) {
		this.descricaoTransacao = descricaoTransacao;
	}

	public LocalDate getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(LocalDate dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	@Override
	public String toString() {
		return "Receita [id=" + id + ", nomeTransacao=" + nomeTransacao + ", tipoTransacao=" + tipoTransacao
				+ ", descricaoTransacao=" + descricaoTransacao + ", dataTransacao=" + dataTransacao + ", dataRegistro="
				+ dataRegistro + "]";
	}
}
