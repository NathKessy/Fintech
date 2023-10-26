package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class DocumentosSocios {

	private Integer id;
	private Empresa empresa;
	private String nome;
	private String rg;
	private String cpf;
	private LocalDate dataNascimento;
	private String estadoCivil;
	private String nacionalidade;
	private String endereco;
	
	public DocumentosSocios() {
	}

	public DocumentosSocios(int id, Empresa empresa, String nome, String rg, String cpf, LocalDate dataNascimento,
			String estadoCivil, String nacionalidade, String endereco) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.estadoCivil = estadoCivil;
		this.nacionalidade = nacionalidade;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "DocumentosSocios [id=" + id + ", empresa=" + empresa + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf
				+ ", dataNascimento=" + dataNascimento + ", estadoCivil=" + estadoCivil + ", nacionalidade="
				+ nacionalidade + ", endereco=" + endereco + "]";
	}

	
}
