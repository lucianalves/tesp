package br.unibh.escola.visao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import br.unibh.escola.entidades.Aluno;
import br.unibh.escola.entidades.Disciplina;
import br.unibh.escola.entidades.Professor;
import br.unibh.escola.entidades.Sala;
import br.unibh.escola.negocio.ServicoAluno;
import br.unibh.escola.negocio.ServicoDisciplina;
import br.unibh.escola.negocio.ServicoProfessor;
import br.unibh.escola.negocio.ServicoSala;

@ManagedBean(name = "disciplinamb")
@ViewScoped
public class ControleDisciplina {

	@Inject
	private Logger log;

	@Inject
	private ServicoDisciplina sd;

	@Inject
	private ServicoSala ss;

	@Inject
	private ServicoAluno sa;

	@Inject
	private ServicoProfessor sp;

	private Disciplina disciplina;
	private Long id;

	private String nomeArg;
	private String cursoArg;

	private List<Disciplina> disciplinas;
	

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public String getNomeArg() {
		return nomeArg;
	}

	public void setNomeArg(String nomeArg) {
		this.nomeArg = nomeArg;
	}

	public String getCursoArg() {
		return cursoArg;
	}

	public void setCursoArg(String cursoArg) {
		this.cursoArg = cursoArg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Sala> getListaSalas() {
		try {
			return ss.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Sala>();
	}

	public List<Professor> getListaProfessores() {
		try {
			return sp.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Professor>();
	}

	public List<Aluno> getListaAlunos() {
		try {
			return sa.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Aluno>();
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	@PostConstruct
	public void inicializaLista() {
		log.info("Executando o MB de Disciplinas");

		try {
			disciplinas = sd.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gravar() {
		FacesMessage facesMsg;

		try {
			if (disciplina.getId() == null) {
				disciplina = sd.insert(disciplina);
				disciplinas.add(disciplina);
			} else {
				disciplina = sd.update(disciplina);
				inicializaLista();
			}
		} catch (Exception e) {
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: " + e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
			return;
		}

		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina salva com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}

	public void pesquisar() {
		try {
			disciplinas = sd.findByNomeECurso(nomeArg, cursoArg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void novo() {
		disciplina = new Disciplina();
	}

	public void cancelar() {
		disciplina = null;
	}

	public void editar(Long id) {
		try {
			disciplina = sd.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		disciplina = null;
	}

	public void excluir(Long id) {
		try {
			sd.delete(sd.find(id));
			inicializaLista();
		} catch (Exception e) {
			e.printStackTrace();
		}
		disciplina = null;
	}

	public String getTipo(int s) {
		switch (s) {
		case 1:
			return "Presencial";
		case 2:
			return "À distância";
		case 3:
			return "Presencial e à distância";
		default:
			return "";
		}
	}

	@SuppressWarnings("unused")
	private DualListModel<Aluno> alunos;

	public DualListModel<Aluno> getAlunos() {
		List<Aluno> source = new ArrayList<Aluno>();
		List<Aluno> target = new ArrayList<Aluno>();
		if (disciplina != null && disciplina.getAlunos() != null) {
			target = disciplina.getAlunos();
		}
		try {
			source = sa.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (target.size() > 0) {
			for (Aluno a : target) {
				source.remove(a);
			}
		}
		return new DualListModel<Aluno>(source, target);
	}

	public void setAlunos(DualListModel<Aluno> alunos) {
		this.alunos = alunos;
		disciplina.setAlunos(alunos.getTarget());
	}
}