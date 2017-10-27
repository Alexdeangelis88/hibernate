package it.fincons.academy.MavenHibernate;

import java.util.Date;
import it.fincons.academy.model.Dipendente;
import it.fincons.academy.model.Sede;
import it.fincons.academy.model.Timbratura;
import it.fincons.academy.services.DipendenteService;
import it.fincons.academy.services.SedeService;
import it.fincons.academy.services.TimbraturaService;

public class App 
{
    public static void main( String[] args )
    {    	
    	Sede sede = new Sede();
    	sede.setNome("Bari");
    	SedeService serviceSede = new SedeService(); 	
    	  	
    	Dipendente dipendente = new Dipendente();
    	dipendente.setNome("Alessandro");
    	dipendente.setCognome("De Angelis");
    	dipendente.setCodiceFiscale("blablabla");
    	dipendente.setSede(sede);
    	DipendenteService serviceDip = new DipendenteService();
    	    	
    	Timbratura timbratura = new Timbratura();
    	timbratura.setTipo("Uscita");
    	timbratura.setDipendente(dipendente);
    	timbratura.setDate(new Date());
    	TimbraturaService serviceTimb = new TimbraturaService();
    	
    	try {
    		serviceSede.InserisciSede(sede);
    		//serviceSede.EleminaSede(sede);
     		//serviceSede.ModificaSede(sede);
    		//serviceSede.CercaSede(sede);
    		serviceDip.InserisciDipendente(dipendente);
    		//serviceDip.CercaDipendente(dipendente);
    		//serviceDip.EliminaDipendente(dipendente);
    		serviceTimb.InserisciTimbratura(timbratura);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
//    	List<Dipendente> listDip = session.createQuery("FROM Dipendente").list();
////   	List<Dipendente> listQue = session.createNativeQuery("select * from Dipendente").getResultList();
//    	
//    	for(Dipendente dip:listDip)
//    	{
//    		System.out.println(dip.getNome());
//    	}
    	

    }
}
