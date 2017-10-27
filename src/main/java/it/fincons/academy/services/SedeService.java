package it.fincons.academy.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.fincons.academy.model.Sede;
import it.fincons.hibernate.dao.SedeDao;
import it.fincons.hibernate.dao.Util;

public class SedeService 
{
	List<Sede> listaSedi = new ArrayList<Sede>();
	public void InserisciSede(Sede sede) throws Exception
	{
		Session session = Util.getSession();	
		
		SedeDao sedeDao = new SedeDao(session);
		
		
		if((sede.getNome()!=null) && !(sede.getNome().equals("")))
		{
			Transaction tran = null;
			try {
				tran = session.beginTransaction();
				sedeDao.inserisci(sede);
				tran.commit();	
			} catch (Exception e) {
				if(tran!=null) tran.rollback();
				e.printStackTrace();
			} finally {
				session.close();
				session.getSessionFactory().close();
			}
		}
		else
		{
			throw new Exception("Inserisci il nome della sede!");
		}
	}
	
	public void EleminaSede(Sede sede) throws Exception
	{
		Session session = Util.getSession();
		SedeDao sedeDao = new SedeDao(session);
		Transaction t = session.beginTransaction();
		if(sede.getIdsede()!=0)
		{
			sedeDao.elimina(sede);
		}
		else
		{
			throw new Exception("Cancellazione non riuscita");
		}
		
		t.commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void ModificaSede(Sede sede) throws Exception
	{
		Session session = Util.getSession();
		SedeDao sedeDao = new SedeDao(session);
		Transaction t = session.beginTransaction();
		
		if(sede.getIdsede()!=0)
		{
			sedeDao.modifica(sede);
		}else{
			throw new Exception("Aggiornamento non riuscito");
		}
		t.commit();
		session.close();
		session.getSessionFactory().close();
	}
	

	public void CercaSede(Sede sede)
	{
		Session session = Util.getSession();
		SedeDao sedeDao = new SedeDao(session);
		Transaction t = session.beginTransaction();
		if((sede.getNome()!=null) && !(sede.getNome().equals("")))
		{
			Boolean boo = sedeDao.cerca(sede);
			if(boo)
			{
				System.out.println("Sede trovata");
			}else{
				System.out.println("Sede non trovata");
			}
		}else{
			System.out.println("Sede non inserita");
		}
		t.commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public List<Sede> getSediService()
	{
		Session session = Util.getSession();
		
		SedeDao sedeDao = new SedeDao(session);

		listaSedi = sedeDao.getSediDao();
		
		session.close();
		session.getSessionFactory().close();
		
		return listaSedi;
	}
}
