package br.com.fiap.fintech;

import java.sql.SQLException;
import java.time.LocalDate;

import br.com.fiap.fintech.dao.DocumentosSociosDAO;
import br.com.fiap.fintech.dao.EmpresaDAO;
import br.com.fiap.fintech.model.DocumentosSocios;
import br.com.fiap.fintech.model.Empresa;

public class TesteLucasDocSociosComprov {
	
	public static void main(String[] args) throws SQLException {
		
		EmpresaDAO empresaDao = new EmpresaDAO();
		DocumentosSociosDAO documentosSociosDAO = new DocumentosSociosDAO();
		
		Empresa empresa = empresaDao.getById(1);
		
		System.out.println("*** DocumentoSocios ***");
		DocumentosSocios documentoSocios = new DocumentosSocios(1, empresa, "Lucas Thyalo", "1234565", "1234567", LocalDate.now(), "Solteiro", "Brasileiro", "Rua Local, 120");
		documentosSociosDAO.adicionar(documentoSocios);
		
		for (DocumentosSocios docSocios : documentosSociosDAO.getAll()) {
			System.out.println(docSocios);
		}
	}

}
