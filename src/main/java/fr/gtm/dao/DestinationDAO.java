package fr.gtm.dao;

import javax.persistence.EntityManagerFactory;


import fr.gtm.entities.Destination;

public class DestinationDAO extends AbstractDAO<Destination, Long>{
	public DestinationDAO(EntityManagerFactory emf) {
		super(emf, Destination.class);
	}
	
	
	
	
}
