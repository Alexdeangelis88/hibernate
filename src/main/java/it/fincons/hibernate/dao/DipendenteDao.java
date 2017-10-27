package it.fincons.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import it.fincons.academy.model.Dipendente;

public class DipendenteDao 
{
	private Session session;
	
	public DipendenteDao(Session session)
	{
		this.session = session;
	}
	
	public void inserisci(Dipendente dipendente)
	{
		session.save(dipendente);
	}
	
	public Boolean cerca(Dipendente dipendente)
	{
		List<Dipendente> listaDipendenti = session.createQuery("FROM Dipendente", Dipendente.class).list();
		Boolean boo;
		for(Dipendente cercaDipendente : listaDipendenti)
		{
			if(cercaDipendente.getNome().equals(dipendente.getNome()))
			{
				if(cercaDipendente.getCognome().equals(dipendente.getCognome()))
				{
					return boo = true;
				}
				return boo = false;
			}
		}
		return boo = false;
	}
	
	public void elimina(Dipendente dipendente)
	{
		session.delete(dipendente);
	}

}
