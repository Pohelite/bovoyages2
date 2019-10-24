package fr.gtm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.entities.DatesVoyages;
import fr.gtm.entities.Destination;

public class DestinationDAO extends AbstractDAO<Destination, Long>{
	
	public DestinationDAO(EntityManagerFactory emf) {
		super(emf, Destination.class);
	}
	
	public Destination getDestinationById(long id) {
		EntityManager em=getEntityManagerFactory().createEntityManager();
		Destination destination=em.find(Destination.class,id);
		em.close();
		return destination;
		}
	
	public List<Destination> getDestinations(){
		EntityManager em=getEntityManagerFactory().createEntityManager();
		List<Destination> destinations=em.createNamedQuery("Destination.getDestinations",Destination.class).getResultList();
		em.close();
		return destinations;
	}
	
	public List<DatesVoyages> getDestinationDates(long id){
		EntityManager em=getEntityManagerFactory().createEntityManager();
		List<DatesVoyages> dates=em.createNamedQuery("Destination.getDates",DatesVoyages.class).getResultList();
		em.close();
		return dates;
	}
	
}
