package fr.gtm.dao;

import javax.persistence.EntityManagerFactory;
import fr.gtm.entities.DatesVoyages;

public class DatesVoyagesDAO extends AbstractDAO<DatesVoyages, Long>{

	public DatesVoyagesDAO(EntityManagerFactory emf) {
		super(emf, DatesVoyages.class);
	}
	
	
}
