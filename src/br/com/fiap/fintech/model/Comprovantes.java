package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Comprovantes {

	private int id;
	private String endereco;
	private LocalDate dataEmissao;
	private String tipoComprovantes;
	
	public Comprovantes() {	
	}

	public Comprovantes(int id, String endereco, LocalDate dataEmissao, String tipoComprovantes) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.dataEmissao = dataEmissao;
		this.tipoComprovantes = tipoComprovantes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getTipoComprovantes() {
		return tipoComprovantes;
	}

	public void setTipoComprovantes(String tipoComprovantes) {
		this.tipoComprovantes = tipoComprovantes;
	}

	@Override
	public String toString() {
		return "Comprov [id=" + id + ", endereco=" + endereco + ", dataEmissao=" + dataEmissao + ", tipoComprov="
				+ tipoComprovantes + "]";
	}
}