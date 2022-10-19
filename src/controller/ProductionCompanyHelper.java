/**
* Alexander Perez Oliva - aperezoliva
* CIS175
* Oct 13, 2022
*/
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ProductionCompany;

/**
 * @author krazy
 *
 */
public class ProductionCompanyHelper {
	static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("MovieList");
	
	public void insertCompany(ProductionCompany pc) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pc);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ProductionCompany> showAllCompanies() {
		EntityManager em = emfactory.createEntityManager();
		List<ProductionCompany> allCompanies = em.createQuery("SELECT pc FROM ProductionCompany pc").getResultList();
		return allCompanies;
	}

	/**
	 * @param companyName
	 * @return
	 */
	public ProductionCompany findCompany(String nameToLookUp) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ProductionCompany> typedQuery = em.createQuery("select pc from ProductionCompany pc where pc.productionCompanyName = :selectedName", ProductionCompany.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		ProductionCompany foundCompany;
		try {
			foundCompany = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundCompany = new ProductionCompany(nameToLookUp);
		}
		em.close();
		
		return foundCompany;
	}
}
