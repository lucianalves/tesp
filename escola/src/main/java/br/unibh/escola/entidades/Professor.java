
package br.unibh.escola.entidades;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

/**
 * Classe concreta de professor
 * 
 * @author Luciana
 * @version 1.0
 * @since 2015
 */

@Entity
@PrimaryKeyJoinColumn
@Table(name = "TB_PROFESSOR")
@NamedQueries({
		@NamedQuery(name = "Professor.findByName", query = "select p from Professor p where p.nome like :nome") })
public class Professor extends Pessoa {
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}

	// Vari�veis de Inst�ncia
	/**
	 * Vari�veis de inst�ncia
	 * 
	 * 
	 */
	@Column(columnDefinition = "DECIMAL(14,2)", nullable = true)
	@DecimalMin("500")
	@DecimalMax("100000")
	private BigDecimal salario;

	public static Double BONUS = 0.1D;

	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="sala")
	private List<Disciplina> disciplinas;
	// Construtores
	/**
	 * Construtor padr�o
	 */
	public Professor() {
	}

	/**
	 * Construtor com completo
	 */

	public Professor(Long id, String nome, String cpf, BigDecimal salario) {
		super(id, nome, cpf);
		this.salario = salario;
	}

	public Professor(BigDecimal matricula) {
		super();
		this.salario = matricula;
	}

	// Get e Set
	/**
	 * Get e Set
	 */
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Professor [salario=" + salario + ", toString()=" + super.toString() + "]";
	}

	public BigDecimal getMatricula() {
		return salario;
	}

	public void setMatricula(BigDecimal matricula) {
		this.salario = matricula;
	}

}
