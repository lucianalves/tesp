package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
	@NamedQuery(name="Aluno.findByName", query = "select a from Aluno a where a.nome like :nome")
})
public class Aluno extends Pessoa{
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAniversario == null) ? 0 : dataAniversario.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (dataAniversario == null) {
			if (other.dataAniversario != null)
				return false;
		} else if (!dataAniversario.equals(other.dataAniversario))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

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
