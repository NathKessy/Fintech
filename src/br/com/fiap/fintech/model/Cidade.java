package br.com.fiap.fintech.model;

public class Cidade {

	private int id;
	private String nomeCidade;

	public Cidade() {
	}

	public Cidade(int id, String nomeCidade) {
		super();
		this.id = id;
		this.nomeCidade = nomeCidade;
	}

	public Cidade(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nomeCidade=" + nomeCidade + "]";
		}

}

