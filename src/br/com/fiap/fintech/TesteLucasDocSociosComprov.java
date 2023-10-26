package br.com.fiap.fintech;

import java.sql.SQLException;
import java.time.LocalDate;

import br.com.fiap.fintech.dao.ComprovantesDAO;
import br.com.fiap.fintech.dao.DocumentosSociosDAO;
import br.com.fiap.fintech.dao.EmpresaDAO;
import br.com.fiap.fintech.model.Comprovantes;
import br.com.fiap.fintech.model.DocumentosSocios;
import br.com.fiap.fintech.model.Empresa;
import br.com.fiap.fintech.model.enums.TipoComprovanteEnum;

public class TesteLucasDocSociosComprov {
	
	public static void main(String[] args) throws SQLException {
		
		EmpresaDAO empresaDao = new EmpresaDAO();
		DocumentosSociosDAO documentosSociosDAO = new DocumentosSociosDAO();
		ComprovantesDAO comprovantesDAO = new ComprovantesDAO();
		
		Empresa empresa = empresaDao.getById(1);
		
		System.out.println("*** DocumentoSocios ***");
		DocumentosSocios documentoSocios = new DocumentosSocios(1, empresa, "Lucas Thyalo", "1234565", "1234567", LocalDate.now(), "Solteiro", "Brasileiro", "Rua Local, 120");
		documentosSociosDAO.adicionar(documentoSocios);
		
		System.out.println("\nListando todos os documentos Socios:");
		for (DocumentosSocios docSocios : documentosSociosDAO.getAll()) {
			System.out.println(docSocios);
		}
		
		System.out.println("\n*** Comprovantes ***");
		Comprovantes comprovante = new Comprovantes(1, documentoSocios, "Rua Lazaro", LocalDate.now(), TipoComprovanteEnum.PAGAMENTO);
		comprovantesDAO.adicionar(comprovante);
		
		System.out.println("\nListando todos comprovantes:");
		for (Comprovantes comprov : comprovantesDAO.getAll()) {
			System.out.println(comprov);
		}
	}

}
