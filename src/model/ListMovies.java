/**
* Alexander Perez Oliva - aperezoliva
* CIS175
* Sep 28, 2022
*/
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author krazy
 *
 */
@Entity
@Table(name="movies")
public class ListMovies {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="MOVIENAME")
	private String movieName;
	@Column(name="MOVIEAUTHOR")
	private String movieAuthor; //shoulda realized movieDirector would made more sense, oh well!
	@Column(name="RELEASEDATE")
	private int releaseDate;
	
	public ListMovies() {
		super();
	}
	
	public ListMovies(String movieName, String movieAuthor, int releaseDate) {
		super();
		this.movieName = movieName;
		this.movieAuthor = movieAuthor;
		this.releaseDate = releaseDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieAuthor() {
		return movieAuthor;
	}
	public void setMovieAuthor(String movieAuthor) {
		this.movieAuthor = movieAuthor; 
	}
	public int getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	public String returnMovieDetails() {
		return "Movie: " + this.movieName + "| Director: " + this.movieAuthor + "| Released: " + this.releaseDate;
	}
	
}
