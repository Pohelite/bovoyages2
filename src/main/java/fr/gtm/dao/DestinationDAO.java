package fr.gtm.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.entities.DatesVoyages;
import fr.gtm.entities.Destination;

public class DestinationDAO extends AbstractDAO<Destination, Long> {

	public DestinationDAO(EntityManagerFactory emf) {
		super(emf, Destination.class);
	}

	public Destination getDestinationById(long id) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		Destination destination = em.find(Destination.class, id);
		em.close();
		return destination;
	}

	public List<Destination> getDestinations() {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		List<Destination> destinations = em.createNamedQuery("Destination.getDestinations", Destination.class)
				.getResultList();
		em.close();
		return destinations;
	}

	public List<DatesVoyages> getDestinationDates() {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		List<DatesVoyages> dates = em.createNamedQuery("Destination.getDates", DatesVoyages.class).getResultList();
		em.close();
		return dates;
	}

	public Destination addDestinationDate(Destination d, DatesVoyages dates) {
		List<DatesVoyages> destinationDates = d.getDates();
		// pas sûr que ce soit nécessaire
		// option qui set la fk de la nouvelle date à la destination
		// dates.setFkDestination(d.getId());
		destinationDates.add(dates);
		d.setDates(destinationDates);
		return d;
	}

	public Destination deleteDestinationDate(Destination d, DatesVoyages dates) {
		List<DatesVoyages> destinationDates = d.getDates();
		Iterator<DatesVoyages> iterator = destinationDates.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == dates.getId()) {
				iterator.remove();
			}
		}
		d.setDates(destinationDates);
		return d;
	}

	public Destination modifyDestinationDate(Destination d, DatesVoyages newDates, long dateID) {
		List<DatesVoyages> destinationDates = d.getDates();
		Iterator<DatesVoyages> iterator = destinationDates.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == dateID) {
				iterator.remove();
			}
		}
		newDates.setId(dateID);
		destinationDates.add(newDates);
		d.setDates(destinationDates);
		return d;
	}

}
