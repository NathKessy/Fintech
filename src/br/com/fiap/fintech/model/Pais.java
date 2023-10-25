package br.com.fiap.fintech.model;

public class Pais {

	private int id;
	private String nomePais;
	private String sigla;

	public Pais() {
	}

	public Pais(int id, String nomePais, String sigla) {
		super();
		this.id = id;
		this.nomePais = nomePais;
		this.sigla = sigla;
	}

	public Pais(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomePais() {
		return nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nomePais=" + nomePais + ", sigla=" + sigla + "]";
	}

}
