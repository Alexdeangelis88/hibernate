package it.fincons.academy.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.fincons.academy.model.Dipendente;
import it.fincons.hibernate.dao.DipendenteDao;
import it.fincons.hibernate.dao.Util;

public class DipendenteService 
{
	public void InserisciDipendente(Dipendente dip) throws Exception
	{
		Session session = Util.getSession();	
		DipendenteDao dipendenteDao = new DipendenteDao(session);
		
		
		if((dip.getCognome()!=null) && (dip.getNome()!=null) && !(dip.getCognome().equals("") && !(dip.getNome().equals(""))))
		{
			Transaction tran = null;
			try {
				tran = session.beginTransaction();
				dipendenteDao.inserisci(dip);
				tran.commit();
			} catch (Exception e) {
				if(tran!=null) tran.rollback();
				e.printStackTrace();
			}finally {
				session.close();
				session.getSessionFactory().close();
			}		
		}
		else
		{
			throw new Exception("Dipendente non valido!!");
		}		
	}
	
	public void CercaDipendente(Dipendente dipendente)
	{
		Session session = Util.getSession();
		DipendenteDao dipendenteDao = new DipendenteDao(session);
		Transaction transaction = null;
		Boolean boo = null;
		if(dipendente.getNome()!=null && dipendente.getCognome()!=null)
		{
			try 
			{
				transaction = session.beginTransaction();
				boo = dipendenteDao.cerca(dipendente);
				
			} catch (Exception e) {
				if(transaction!=null)
				{
					transaction.rollback();
				}
				e.printStackTrace();
			} finally{
				if(boo)
				{
					System.out.println("Il dipendente " + dipendente.getNome() + " " + dipendente.getCognome() + " esiste!");
				}
				else{
					System.out.println("Il dipendente " + dipendente.getNome() + " " + dipendente.getCognome() + " non esiste!");
				}
				session.close();
				session.getSessionFactory().close();
			}
		}
	}
	
	public void EliminaDipendente(Dipendente dipendente)
	{
		Session session = Util.getSession();
		DipendenteDao dipendenteDao = new DipendenteDao(session);
		Transaction transaction = null;
		System.out.println("Sono in EliminaDipendente con id " + dipendente.getIdDipendente());
		if(dipendente.getIdDipendente()!=0)
		{
			System.out.println("Sono in if");
			try {
				System.out.println("Sono in try");
				transaction = session.beginTransaction();
				dipendenteDao.elimina(dipendente);
				transaction.commit();
			} catch (Exception e) {
				if(transaction!=null)
				{
					System.out.println("Sono in if di catch");
					transaction.rollback();
				}
				e.printStackTrace();
			} finally {
				System.out.println("Sono in finally");
				session.close();
				session.getSessionFactory().close();
			}
		}
	}
}
