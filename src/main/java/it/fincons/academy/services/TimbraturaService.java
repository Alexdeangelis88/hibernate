package it.fincons.academy.services;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.fincons.academy.model.Timbratura;
import it.fincons.hibernate.dao.TimbraturaDao;
import it.fincons.hibernate.dao.Util;

public class TimbraturaService 
{
	public void InserisciTimbratura(Timbratura timbratura) throws Exception
	{
		Session session = Util.getSession();
		TimbraturaDao timbDao = new TimbraturaDao(session);

		Date start = getStartOfDay();
		Date end = getEndOfDay();
		Date dateOfTimb = timbratura.getDate();
		
		//if(dateOfTimb.after(start) && end.after(dateOfTimb)){}
		if((timbratura.getTipo()!=null) && !(timbratura.getTipo().equals("")))
		{
			Transaction tran = null;
			try {
				tran = session.beginTransaction();
				timbDao.inserisci(timbratura);
				tran.commit();			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
				session.getSessionFactory().close();
			}
		}
		else
		{
			throw new Exception("Inserisci il tipo di timbratura");
		}
	}
	
	private Date getStartOfDay() {
	    Calendar calendar = Calendar.getInstance();
	    int year = calendar.get(Calendar.YEAR);
	    int month = calendar.get(Calendar.MONTH);
	    int day = calendar.get(Calendar.DATE);
	    calendar.set(year, month, day, 0, 0, 0);
	    return calendar.getTime();
	}

	private Date getEndOfDay() {
	    Calendar calendar = Calendar.getInstance();
	    int year = calendar.get(Calendar.YEAR);
	    int month = calendar.get(Calendar.MONTH);
	    int day = calendar.get(Calendar.DATE);
	    calendar.set(year, month, day, 23, 59, 59);
	    return calendar.getTime();
	}


}
// SOLO UN ENTRATA PER UN DIP E SOLO UN USCITA PER UN DIP
// CALCOLA LE ORE LAVORARIVE
// STAMPA DA CHE ORA A CHE ORA HA LAVORATO
// CALCOLA RITARDO
// CALCOLA SE HA LAVORATO DI PIU O DI MENO RISPETTO ALLE 8 ORE LAVORATIVE
