package it.fincons.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import it.fincons.academy.model.Dipendente;
import it.fincons.academy.model.Timbratura;

public class TimbraturaDao 
{
	public TimbraturaDao(Session session)
	{
		this.session = session;
	}
	
	private Session session;
	
	public void inserisci(Timbratura timbratura)
	{
		//voglio fare la join tra timbratura e dipendente
		List<Timbratura> listaTimbraturaEntrata = session.createQuery("FROM dipendente "
				+ "INNER JOIN timbratura ON timbratura.ID_DIPENDENTE = dipendente.ID_DIPENDENTE "
				+ "WHERE timbratura.TIPO='Entrata'", Timbratura.class).list();
//		List<Timbratura> listaTimbraturaEntrata = session.createQuery("FROM Timbratura Where TIPO = 'Uscita'", Timbratura.class).list();
		List<Timbratura> listaTimbraturaUcita = session.createQuery("FROM Timbratura Where TIPO = 'Uscita'", Timbratura.class).list();
		
		if(timbratura.getTipo().equals("Entrata")){
			for(Timbratura listTimbEnt : listaTimbraturaEntrata){
				
			}
		}
		else if(timbratura.getTipo().equals("Uscita")){
			for(Timbratura listTimbUsc : listaTimbraturaUcita){
				
			}			
		}
		else{
			System.out.println("Tipo di timbratura non valido");
		}
		
		session.save(timbratura);
	}
}
