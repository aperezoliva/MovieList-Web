/**
* Alexander Perez Oliva - aperezoliva
* CIS175
* Oct 15, 2022
*/
package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.ListDetails;
import model.ListMovies;
import model.ProductionCompany;

/**
 * @author krazy
 *
 */
public class ProductionCompanyTester {
	public static void main(String[] args) {
		ProductionCompany universalStudios = new ProductionCompany("Universal Studios");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ListMovies jurassicPark = new ListMovies("Jurassic Park", "Steven Speilberg", 1993);
		ListMovies theLorax = new ListMovies("The Lorax", "Chris Renaud", 2012);
		
		
		List<ListMovies> universalMovies = new ArrayList<ListMovies>(); 
		
		universalMovies.add(theLorax);
		universalMovies.add(jurassicPark);
		ListDetails universalMoviesList = new ListDetails("Univeral Studios Productions", LocalDate.now(), universalStudios);
		
		universalMoviesList.setListOfMovies(universalMovies);
		
		ldh.insertNewListDetails(universalMoviesList);
		
		List<ListDetails> allMovies = ldh.getLists();
		for(ListDetails a: allMovies) {
			System.out.println(a.toString());
		}
	}

}
