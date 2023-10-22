package br.com.fiap.fintech.model;

import java.time.LocalDate;

import br.com.fiap.fintech.model.enums.TipoContaEnum;

public class ContaEmpresa {

	private int id;
//	private int idUsuario;
	private int numeroConta;
	private TipoContaEnum tipoConta;
	private boolean statusConta;
	private LocalDate dataAbertura;

	public ContaEmpresa() {
	}

	public ContaEmpresa(int id, int numeroConta, TipoContaEnum tipoConta, boolean statusConta,
			LocalDate dataAbertura) {
		super();
		this.id = id;
		this.numeroConta = numeroConta;
		this.tipoConta = tipoConta;
		this.statusConta = statusConta;
		this.dataAbertura = dataAbertura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
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
		return "ContaEmpresa [id=" + id + ", numeroConta=" + numeroConta + ", tipoConta=" + tipoConta + ", statusConta="
				+ statusConta + ", dataAbertura=" + dataAbertura + "]";
	}
}