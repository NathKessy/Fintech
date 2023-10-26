package br.com.fiap.fintech.model;

import java.time.LocalDate;

import br.com.fiap.fintech.model.enums.TipoContaEnum;

public class ContaEmpresa {

	private Integer id;
	private Usuario usuario; 
	private String numeroConta;
	private TipoContaEnum tipoConta;
	private boolean statusConta;
	private LocalDate dataAbertura;

	public ContaEmpresa() {
	}

	public ContaEmpresa(Integer id) {
		super();
		this.id = id;
	}

	public ContaEmpresa(Integer id, Usuario usuario, String numeroConta, TipoContaEnum tipoConta, boolean statusConta,
			LocalDate dataAbertura) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.numeroConta = numeroConta;
		this.tipoConta = tipoConta;
		this.statusConta = statusConta;
		this.dataAbertura = dataAbertura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}

	public boolean isStatusConta() {
		return statusConta;
	}
	
	public void setStatusConta(boolean statusConta) {
		this.statusConta = statusConta;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	@Override
	public String toString() {
		return "ContaEmpresa [id=" + id + ", usuario=" + usuario + ", numeroConta=" + numeroConta + ", tipoConta="
				+ tipoConta + ", statusConta=" + statusConta + ", dataAbertura=" + dataAbertura + "]";
	}

	
}
