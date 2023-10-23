package br.com.fiap.fintech.model;

public class Usuario {

	private int id;
	private ContaEmpresa contaEmpresa;
	private Empresa empresa;
	private String loginEmpresa; 
	private String email;
	private String senha;
	
	public Usuario() {
	}

	public Usuario(int id, ContaEmpresa contaEmpresa, Empresa empresa, String loginEmpresa, String email,
			String senha) {
		super();
		this.id = id;
		this.contaEmpresa = contaEmpresa;
		this.empresa = empresa;
		this.loginEmpresa = loginEmpresa;
		this.email = email;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ContaEmpresa getContaEmpresa() {
		return contaEmpresa;
	}

	public void setContaEmpresa(ContaEmpresa contaEmpresa) {
		this.contaEmpresa = contaEmpresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getLoginEmpresa() {
		return loginEmpresa;
	}

	public void setLoginEmpresa(String loginEmpresa) {
		this.loginEmpresa = loginEmpresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", contaEmpresa=" + contaEmpresa + ", empresa=" + empresa + ", loginEmpresa="
				+ loginEmpresa + ", email=" + email + ", senha=" + senha + "]";
	}

	
}
