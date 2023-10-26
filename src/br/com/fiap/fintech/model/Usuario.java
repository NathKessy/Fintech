package br.com.fiap.fintech.model;

public class Usuario {

	private Integer id;
	private Empresa empresa;
	private String loginEmpresa; 
	private String email;
	private String senha;
	
	public Usuario() {
	}

	public Usuario(Integer id, Empresa empresa, String loginEmpresa, String email, String senha) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.loginEmpresa = loginEmpresa;
		this.email = email;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "Usuario [id=" + id + ", empresa=" + empresa + ", loginEmpresa=" + loginEmpresa + ", email=" + email
				+ ", senha=" + senha + "]";
	}

}
