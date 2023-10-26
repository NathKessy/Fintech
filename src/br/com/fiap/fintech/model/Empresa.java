package br.com.fiap.fintech.model;

public class Empresa {

	private Integer id;
	private DocumentosSocios documentosSocios;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private double capital_empresa;
	private String cep;
	private String telefone;
	private String email;
	private Endereco endereco;
	private double faturamento;

	public Empresa() {
	}

	public Empresa(Integer id) {
		super();
		this.id = id;
	}

	public Empresa(Integer id, DocumentosSocios documentosSocios, String razaoSocial, String nomeFantasia, String cnpj,
			double capital_empresa, String cep, String telefone, String email, Endereco endereco, double faturamento) {
		super();
		this.id = id;
		this.documentosSocios = documentosSocios;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.capital_empresa = capital_empresa;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.faturamento = faturamento;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public DocumentosSocios getDocumentosSocios() {
		return documentosSocios;
	}


	public void setDocumentosSocios(DocumentosSocios documentosSocios) {
		this.documentosSocios = documentosSocios;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public double getCapital_empresa() {
		return capital_empresa;
	}


	public void setCapital_empresa(double capital_empresa) {
		this.capital_empresa = capital_empresa;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", documentosSocios=" + documentosSocios + ", razaoSocial=" + razaoSocial
				+ ", nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj + ", capital_empresa=" + capital_empresa
				+ ", cep=" + cep + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", faturamento=" + faturamento + "]";
	}

}
