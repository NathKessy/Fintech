package br.com.fiap.fintech.model;

public class Endereco {

	private int id;
	private Estado estado;
	private Cidade cidade;
	private Pais pais;
	private String logradouro;
	private String bairro;
	private String numero;
	private String cep;

	public Endereco() {
	}
	
	public Endereco(int id) {
		super();
		this.id = id;
	}

	public Endereco(int id, Estado estado, Cidade cidade, Pais pais, String logradouro, String bairro, String numero,
			String cep) {
		super();
		this.id = id;
		this.estado = estado;
		this.cidade = cidade;
		this.pais = pais;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", estado=" + estado + ", cidade=" + cidade + ", pais=" + pais + ", logradouro="
				+ logradouro + ", bairro=" + bairro + ", numero=" + numero + ", cep=" + cep + "]";
	}

}
