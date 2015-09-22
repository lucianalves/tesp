package br.unibh.teste01.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.teste01.persistencia.AlunoDAO;
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
	
	@Test
	public void testeAlunoInsertEdelete() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = new Aluno(null, "Beltrano da Silva","85456325458","7896541", new Date());
		dao.insert(a);
		Aluno b = dao.find("Beltrano");
		Assert.assertNotNull(b);
		
		b.setNome("Ciclano da Silva");
		dao.update(b);
		Aluno c = dao.find("Ciclano");
		Assert.assertNotNull(c);
		
		dao.delete(c);
		Aluno d = dao.find("Ciclano");
		Assert.assertNull(d);
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
		
		@Test
		public void testeProfessorInsertEdelete() {
			ProfessorDAO dao = new ProfessorDAO();
			Professor a = new Professor(null, "Beltrano da Silva","85456325458", new BigDecimal(1212121));
			dao.insert(a);
			Professor b = dao.find("Beltrano");
			Assert.assertNotNull(b);
			
			b.setNome("Ciclano da Silva");
			dao.update(b);
			Professor c = dao.find("Ciclano");
			Assert.assertNotNull(c);
			
			dao.delete(c);
			Professor d = dao.find("Ciclano");
			Assert.assertNull(d);
		}
	
	

}
