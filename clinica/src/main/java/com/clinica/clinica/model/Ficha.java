package com.clinica.clinica.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ficha")
public class Ficha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codFicha")
	private long codFicha;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codPaciente", referencedColumnName = "codPaciente")
	private Paciente codPaciente;	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codMedico", referencedColumnName = "crm")
	private Medico codMedico;
	
	
	@Column(name = "data", nullable = false)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@Column(name = "valor", nullable = false)
	private double valor;
	
	@Column(name = "diagnostico", nullable = true)
	private String diagnostico;
	
	@Column(name = "procedimento", nullable = true)
	private String procedimento;
	
	@Column(name = "exame", nullable = true)
	private String exame;
	
	@Column(name = "dataRetorno", nullable = true)
	private Date dataRetorno;

	public Paciente getCodPaciente() {
		return codPaciente;
	}

	public void setCodPaciente(Paciente codPaciente) {
		this.codPaciente = codPaciente;
	}

	public Medico getCodMedico() {
		return codMedico;
	}

	public void setCodMedico(Medico codMedico) {
		this.codMedico = codMedico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public long getCodFicha() {
		return codFicha;
	}

	public void setCodFicha(long codFicha) {
		this.codFicha = codFicha;
	}
	
	
}
