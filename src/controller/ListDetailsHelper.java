/**
* Alexander Perez Oliva - aperezoliva
* CIS175
* Oct 14, 2022
*/
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;

/**
 * @author krazy
 *
 */
public class ListDetailsHelper {
	static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("MovieList");
	
	public void insertNewListDetails(ListDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s); 
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}

	/**
	 * @param listToDelete
	 */
	public void deleteList(ListDetails toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListDetails> typedQuery = em.createQuery("select detail from ListDetails detail where detail.id = :selectedId", ListDetails.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		ListDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param tempId
	 * @return
	 */
	public ListDetails searchForListDetailsById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListDetails found = em.find(ListDetails.class, tempId);
		em.close();
		return found;
	}

	/**
	 * @param listToUpdate
	 */
	public void updateList(ListDetails listToUpdate) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(listToUpdate);
		em.getTransaction().commit();
		em.close();
	}
}
