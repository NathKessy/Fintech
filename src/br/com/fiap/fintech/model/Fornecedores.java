package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Fornecedores {

//	Verificar com equipe cagotegoria e status. (aguardando respostas)

	private int id;
//	private ContaEmpresa idContaEmpresa;
	private String nome;
	private String cnpj;
	private String endereco;
	private String telefone;
	private String email;
	private String categoriaFornecedor;
	private boolean status;
	private LocalDate programacaoPagamento;

	public Fornecedores() {
	}

	public Fornecedores(int id, String nome, String cnpj, String endereco, String telefone, String email,
			String categoriaFornecedor, boolean status, LocalDate programacaoPagamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.categoriaFornecedor = categoriaFornecedor;
		this.status = status;
		this.programacaoPagamento = programacaoPagamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getCategoriaFornecedor() {
		return categoriaFornecedor;
	}

	public void setCategoriaFornecedor(String categoriaFornecedor) {
		this.categoriaFornecedor = categoriaFornecedor;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDate getProgramacaoPagamento() {
		return programacaoPagamento;
	}

	public void setProgramacaoPagamento(LocalDate programacaoPagamento) {
		this.programacaoPagamento = programacaoPagamento;
	}

	@Override
	public String toString() {
		return "Fornecedores [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", endereco=" + endereco + ", telefone="
				+ telefone + ", email=" + email + ", categoriaFornecedor=" + categoriaFornecedor + ", status=" + status
				+ ", programacaoPagamento=" + programacaoPagamento + "]";
	}
}
