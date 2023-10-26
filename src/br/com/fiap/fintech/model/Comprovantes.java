package br.com.fiap.fintech.model;

import java.time.LocalDate;

import br.com.fiap.fintech.model.enums.TipoComprovanteEnum;

public class Comprovantes {

	private int id;
	private DocumentosSocios documentosSocios;
	private String endereco;
	private LocalDate dataEmissao;
	private TipoComprovanteEnum tipoComprovantes;
	
	public Comprovantes() {	
	}

	public Comprovantes(int id, DocumentosSocios documentosSocios, String endereco, LocalDate dataEmissao,
			TipoComprovanteEnum tipoComprovantes) {
		super();
		this.id = id;
		this.documentosSocios = documentosSocios;
		this.endereco = endereco;
		this.dataEmissao = dataEmissao;
		this.tipoComprovantes = tipoComprovantes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DocumentosSocios getDocumentosSocios() {
		return documentosSocios;
	}

	public void setDocumentosSocios(DocumentosSocios documentosSocios) {
		this.documentosSocios = documentosSocios;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public TipoComprovanteEnum getTipoComprovantes() {
		return tipoComprovantes;
	}

	public void setTipoComprovantes(TipoComprovanteEnum tipoComprovantes) {
		this.tipoComprovantes = tipoComprovantes;
	}

	@Override
	public String toString() {
		return "Comprovantes [id=" + id + ", documentosSocios=" + documentosSocios + ", endereco=" + endereco
				+ ", dataEmissao=" + dataEmissao + ", tipoComprovantes=" + tipoComprovantes + "]";
	}

}