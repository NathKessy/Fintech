package br.com.fiap.fintech.model;

public class Estado {

	private int id;
	private String UF;
	private String nomeEstado;

	public Estado() {
	}

	public Estado(int id) {
		super();
		this.id = id;
	}

	public Estado(int id, String UF, String nomeEstado) {
		super();
		this.id = id;
		this.UF = UF;
		this.nomeEstado = nomeEstado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", UF=" + UF + ", nomeEstado=" + nomeEstado + "]";
	}

}
