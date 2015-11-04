
package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Classe concreta de professor
 * 
 * @author Luciana
 * @version 1.0
 * @since 2015
 */

@Entity
@PrimaryKeyJoinColumn
@Table(name = "TB_SALA")
@NamedQueries({ @NamedQuery(name = "Sala.findByCapacidade", query = "select s from Sala s where s.capacidade >= :capacidade") })
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CODIGO", nullable = false, columnDefinition = "VARCHAR(10)")
	@NotNull
	private String codigo;

	@Column(name = "CAPACIDADE", nullable = false, columnDefinition = "INT")
	@NotNull
	private Integer capacidade;

	@Column(name = "POSSUIQUADROBRANCO", nullable = true, columnDefinition = "BOOLEAN")
	@NotNull
	private boolean possuiQuadroBranco;

	@Column(name = "POSSUIDATASHOW", nullable = true, columnDefinition = "BOOLEAN")
	@NotNull
	private boolean possuiDataShow;

	@Column(name = "POSSUICOMPUTADOR", nullable = true, columnDefinition = "BOOLEAN")
	@NotNull
	private boolean possuiComputador;

	@Column(name = "OBSERVACAO", nullable = true, columnDefinition = "VARCHAR(255)")
	@NotNull
	private String observacao;

	@Column(name = "STATUS", nullable = false, columnDefinition = "INT")
	@NotNull
	private int status;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATATERMINOMANUTENCAO", nullable = true, columnDefinition = "DATE")
	private Date dataTerminoManutencao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public boolean isPossuiQuadroBranco() {
		return possuiQuadroBranco;
	}

	public void setPossuiQuadroBranco(boolean possuiQuadroBranco) {
		this.possuiQuadroBranco = possuiQuadroBranco;
	}

	public boolean isPossuiDataShow() {
		return possuiDataShow;
	}

	public void setPossuiDataShow(boolean possuiDataShow) {
		this.possuiDataShow = possuiDataShow;
	}

	public boolean isPossuiComputador() {
		return possuiComputador;
	}

	public void setPossuiComputador(boolean possuiComputador) {
		this.possuiComputador = possuiComputador;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDataTerminoManutencao() {
		return dataTerminoManutencao;
	}

	public void setDataTerminoManutencao(Date dataTerminoManutencao) {
		this.dataTerminoManutencao = dataTerminoManutencao;
	}

	public Sala() {
		super();
	}

	public Sala(Long id, String codigo, Integer capacidade, boolean possuiQuadroBranco, boolean possuiDataShow,
			boolean possuiComputador, String observacao, int status, Date dataTerminoManutencao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.capacidade = capacidade;
		this.possuiQuadroBranco = possuiQuadroBranco;
		this.possuiDataShow = possuiDataShow;
		this.possuiComputador = possuiComputador;
		this.observacao = observacao;
		this.status = status;
		this.dataTerminoManutencao = dataTerminoManutencao;
	}
	
	

}
