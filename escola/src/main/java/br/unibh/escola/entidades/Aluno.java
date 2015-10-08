package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@PrimaryKeyJoinColumn
@Table(name="TB_ALUNO", uniqueConstraints=@UniqueConstraint(columnNames="matricula"))
public class Aluno extends Pessoa{
	
	
	@NotBlank
	@Pattern(regexp="[A-Za-z\\d]*",message="favor fornecer numero e caracteres")
	@Column(length=8,nullable=false, columnDefinition="CHAR(8)")
	private String matricula;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_aniversario",nullable=true)
	private Date dataAniversario;
	
	public Aluno (){}

		public Aluno(Long id, String nome, String cpf, String matricula, Date dataAniversario) {
		super(id, nome, cpf);
		this.matricula = matricula;
		this.dataAniversario = dataAniversario;
	}



	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", dataAniversario=" + dataAniversario + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
