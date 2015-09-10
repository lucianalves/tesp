package br.unibh.teste01.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.teste01.persistence.AlunoDAO;
import br.unibh.teste01.persistencia.ProfessorDAO;

//Classe aluno

public class Testes {

	@Test
	public void testeAlunoFindAll() {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 100);
	}

	@Test
	public void testeAlunoFind() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(6L);
		Assert.assertEquals(a.getNome(), "Colby U. Keith");
	}
	
	public void testeAlunoInsertEdelete() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = new Aluno(null, "Beltrano da Silva","85456325458","7896541", new Date());
		dao.insert(a);
		Aluno b = dao.find("Beltrano");
		b.setNome("Ciclano da Silva");
		dao.update(b);
		Assert.assertNotNull(b);
		dao.delete(b);
		Aluno c = dao.find("Ciclano");
		Assert.assertNull(c);
	}
	
	//classe professor
	
	
	

		@Test
		public void testeProfessorFindAll() {
			ProfessorDAO dao = new ProfessorDAO();
			List<Professor> lista = dao.findAll();
			Assert.assertEquals(lista.size(), 105);
		}

		@Test
		public void testeProfessorFind() {
			ProfessorDAO dao = new ProfessorDAO();
			Professor a = dao.find(6L);
			Assert.assertEquals(a.getNome(), "Graham K. Tyson");
		}
		
		public void testeProfessorInsertEdelete() {
			ProfessorDAO dao = new ProfessorDAO();
			Professor a = new Professor(null, "fulano da silva","85456325457",new BigDecimal(7896591));
			dao.insert(a);
			Professor b = dao.find("fulano");
			b.setNome("beltrano da Silva");
			dao.update(b);
			Assert.assertNotNull(b);
			dao.delete(b);
			Professor c = dao.find("beltrano");
			Assert.assertNull(c);
		}
	
	

}
