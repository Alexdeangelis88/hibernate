package it.fincons.academy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="timbratura")
public class Timbratura 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name="ID_TIMBRATURA")
	private long idTimbratura;
	
	@Column(name="TIPO")
	private String tipo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_DIPENDENTE")
	private Dipendente dipendente;
	
	@Column(name="DATE")
	private Date date;
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getIdTimbratura() {
		return idTimbratura;
	}

	public void setIdTimbratura(long idTimbratura) {
		this.idTimbratura = idTimbratura;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	
}
