
package br.unibh.teste01.entidades;

import java.math.BigDecimal;

/**
 * Classe concreta de professor
 *@author Alexandre
 *@version 1.0
 *@since 2015
 */

public class Professor extends Pessoa {
	
	// Vari�veis de Inst�ncia
	/**
	 * Vari�veis de inst�ncia
	 */
	private BigDecimal salario;
	public static Double BONUS =0.1D;

	
	// Construtores
	/**
	 * Construtor padr�o
	 */
	public Professor (){}
	
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
