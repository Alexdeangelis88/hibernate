package it.fincons.academy.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sede")
public class Sede {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name="ID_SEDE")
	private long idsede;
	
	@Column(name="NOME")
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="sede")
	private List<Dipendente> dipendente;
	
	
	
	public List<Dipendente> getDipendente() {
		return dipendente;
	}
	public void setDipendente(List<Dipendente> dipendente) {
		this.dipendente = dipendente;
	}
	public long getIdsede() {
		return idsede;
	}
	public void setIdsede(long idsede) {
		this.idsede = idsede;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
