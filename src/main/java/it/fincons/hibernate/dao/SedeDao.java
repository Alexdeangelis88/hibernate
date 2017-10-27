package it.fincons.hibernate.dao;


import java.util.List;

import org.hibernate.Session;


import it.fincons.academy.model.Sede;

public class SedeDao 
{
	public SedeDao(Session session)
	{
		this.session = session;
	}
	
	private Session session;
	
//	public Long inserisci(Sede sede)
//	{
//		return (Long) session.save(sede);
//	}
	
	public int inserisci(Sede sede)
	{
		int f;
		List<Sede> sedeList = getSediDao();
		for(Sede s : sedeList)
		{
			if(s.getNome().equals(sede.getNome())) {
					session.save(sede);
					return f = 0;
				}	
		}
		session.save(sede);
		return f=1;		
	}
	
	public void elimina(Sede sede)
	{
		session.delete(sede);
	}
	
	public void modifica(Sede sede)
	{
		session.update(sede);
	}

	public Boolean cerca(Sede sede)
	{
		Boolean boo = false;
		List<Sede> listSede = session.createQuery("FROM Sede", Sede.class).list();
		for(Sede cercaSed:listSede)
		{
			if(cercaSed.getNome().equals(sede.getNome()))
			{
				return boo = true;
			}
		}
		return boo;
	}
	
	public List<Sede> getSediDao()
	{
		List<Sede> listDip = session.createQuery("FROM Sede", Sede.class).list();
		return listDip;
	}
	
	
}
