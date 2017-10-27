package it.fincons.academy.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dipendente")
public class Dipendente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name="ID_DIPENDENTE")
	private long idDipendente;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="COGNOME")
	private  String cognome;
	
	@Column(name="CODICEFISCALE")
	private  String codiceFiscale;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_SEDE")
	private Sede sede;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="dipendente")
	private List<Timbratura> listTimb;

	public long getIdDipendente() {
		return idDipendente;
	}

	public void setIdDipendente(long idDipendente) {
		this.idDipendente = idDipendente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public List<Timbratura> getListTimb() {
		return listTimb;
	}

	public void setListTimb(List<Timbratura> listTimb) {
		this.listTimb = listTimb;
	}
}