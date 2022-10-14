/**
* Alexander Perez Oliva - aperezoliva
* CIS175
* Sep 28, 2022
*/
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListMovies;

/**
 * @author krazy
 *
 */
public class ListMoviesHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MovieList");
	
	public void insertMovie(ListMovies lm) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lm);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListMovies> showAllMovies(){
		EntityManager em = emfactory.createEntityManager();
		List<ListMovies> allMovies = em.createQuery("SELECT i FROM ListMovies i").getResultList();
		return allMovies;
	}
	
	public void deleteItem(ListMovies toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListMovies> typedQuery = 
				em.createQuery("select lm from ListMovies lm where lm.movieName = :selectedMovieName and lm.movieAuthor = :selectedMovieAuthor and lm.releaseDate = :selectedReleaseDate", ListMovies.class);
		
		typedQuery.setParameter("selectedMovieName", toDelete.getMovieName());
		typedQuery.setParameter("selectedMovieAuthor", toDelete.getMovieAuthor());
		typedQuery.setParameter("selectedReleaseDate", toDelete.getReleaseDate());
		
		typedQuery.setMaxResults(1);
		
		ListMovies result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();
	}

	/**
	 * @param storeName
	 * @return
	 */
	public List<ListMovies> searchForMovieByTitle(String movieTitle) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListMovies> typedQuery = em.createQuery("select lm from ListMovies lm where lm.movieName = :selectedMovieName", ListMovies.class);
		typedQuery.setParameter("selectedMovieName", movieTitle);
		List<ListMovies> foundTitle = typedQuery.getResultList();
		
		em.close();
		return foundTitle;
	}

	/**
	 * @param directorName
	 * @return
	 */
	public List<ListMovies> searchForMovieByDirector(String directorName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListMovies> typedQuery = em.createQuery("select lm from ListMovies lm where lm.movieAuthor = :selectedMovieAuthor", ListMovies.class);
		typedQuery.setParameter("selectedMovieAuthor", directorName);
		List<ListMovies> foundDirector = typedQuery.getResultList();
		
		em.close();
		return foundDirector;
	}

	/**
	 * @param releaseDate
	 * @return
	 */
	public List<ListMovies> searchForMovieByDate(int releaseDate) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListMovies> typedQuery = em.createQuery("select lm from ListMovies lm where lm.releaseDate = :selectedReleaseDate", ListMovies.class);
		typedQuery.setParameter("selectedReleaseDate", releaseDate);
		List<ListMovies> foundReleaseDate = typedQuery.getResultList();
		
		em.close();
		return foundReleaseDate;
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public ListMovies searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListMovies found = em.find(ListMovies.class, idToEdit);
		em.close();
		
		
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateMovie(ListMovies toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
}
