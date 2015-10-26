
package br.unibh.escola.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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

	// Vari�veis de Inst�ncia
	/**
	 * Vari�veis de inst�ncia
	 * 
	 * 
	 */
	@Column(columnDefinition = "DECIMAL(14,2)", nullable = true)
	@Size(min = 500, max = 100000)
	private BigDecimal salario;

	public static Double BONUS = 0.1D;

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
