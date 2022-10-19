/**
* Alexander Perez Oliva - aperezoliva
* CIS175
* Oct 14, 2022
*/
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author krazy
 *
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate tripDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private ProductionCompany company;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListMovies> listOfMovies;
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, LocalDate tripDate, ProductionCompany company, List<ListMovies> listOfMovies) {
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.company = company;
		this.listOfMovies = listOfMovies;
	}
	
	public ListDetails(String listName, LocalDate tripDate, ProductionCompany company, List<ListMovies> listOfMovies) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.company = company;
		this.listOfMovies = listOfMovies;
	}
	

	
	public ListDetails(String listName, LocalDate tripDate, ProductionCompany company) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public ProductionCompany getCompany() {
		return company;
	}

	public void setCompany(ProductionCompany company) {
		this.company = company;
	}

	public List<ListMovies> getListOfMovies() {
		return listOfMovies;
	}

	public void setListOfMovies(List<ListMovies> listOfMovies) {
		this.listOfMovies = listOfMovies;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", company=" + company
				+ ", listOfMovies=" + listOfMovies + "]";
	}
	
	
}
