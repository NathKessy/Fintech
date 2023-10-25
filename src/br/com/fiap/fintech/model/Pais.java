package br.com.fiap.fintech.model;

public class Pais {

	private int id;
	private String nomePais;

	public Pais() {
	}

	public Pais(int id, String nomePais) {
		super();
		this.id = id;
		this.nomePais = nomePais;
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

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nomePais=" + nomePais + "]";
		}
}
