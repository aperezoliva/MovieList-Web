import java.util.List;
import java.util.Scanner;

import controller.ListMoviesHelper;
import model.ListMovies;

/**
* Alexander Perez Oliva - aperezoliva
* CIS175
* Sep 28, 2022
*/

/**
 * @author krazy
 *
 */
public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static ListMoviesHelper lmh = new ListMoviesHelper();
	
	private static void addAMovie() {
		System.out.println("Enter a movie title: ");
		String title = in.nextLine();
		System.out.println("Enter the movie director: ");
		String director = in.nextLine();
		System.out.println("Enter the movie's release date: ");
		int releaseDate = in.nextInt();
		ListMovies toAdd = new ListMovies(title, director, releaseDate);
		lmh.insertMovie(toAdd);
	}
	
	private static void viewList() {
		// TODO Auto-generated method stub
		List<ListMovies> allMovies = lmh.showAllMovies();
		
		for(ListMovies singleMovie : allMovies) {
			System.out.println(singleMovie.returnMovieDetails());
		}
	}
	
	public static void runMenu() {
		boolean loopMenu = true;
		
		System.out.println("--- Welcome to the movie list program thing ---");
		while (loopMenu) {
			System.out.println("---Select an action:");
			System.out.println("---1 : Add a movie");
			System.out.println("---2 : Edit an movie");
			System.out.println("---3 : Delete a movie");
			System.out.println("---4 : View the list");
			System.out.println("---5 : Close the program");
			System.out.print("---Your selection: ");
			
			int selection = in.nextInt();
			in.nextLine();
			
			if (selection == 1) {
				addAMovie();
			} else if (selection == 2) {
				editAMovie();
			} else if (selection == 3) {
				deleteAMovie();
			} else if (selection == 4) {
				viewList();
			} else {
				lmh.cleanUp();
				System.out.println("   Goodbye!   ");
				loopMenu = false;
			}
		}
	}
	
	private static void deleteAMovie() {
		System.out.print("Enter the movie's title you want removed: ");
		String title = in.nextLine();
		System.out.print("Enter the director of the movie: ");
		String director = in.nextLine();
		System.out.print("Enter the release date of the movie: ");
		int releaseDate = in.nextInt();
		ListMovies toDelete = new ListMovies(title, director, releaseDate);
		lmh.deleteItem(toDelete);
	}


	private static void editAMovie() {
		System.out.println("Please enter a search option: ");
		System.out.println("1 : Search by title");
		System.out.println("2 : Search by director");
		System.out.println("3 : Search by release date");
		int searchBy = in.nextInt();
		in.nextLine();
		
		List<ListMovies> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the movie title: ");
			String movieTitle = in.nextLine();
			foundItems = lmh.searchForMovieByTitle(movieTitle);
		} else if (searchBy == 2) {
			System.out.print("Enter the director's name: ");
			String directorName = in.nextLine();
			foundItems = lmh.searchForMovieByDirector(directorName);
		} else {
			System.out.print("Enter the release date: ");
			int releaseDate = in.nextInt();
			foundItems = lmh.searchForMovieByDate(releaseDate);
		}
		
		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (ListMovies l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ListMovies toEdit = lmh.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getMovieName() + " from " + toEdit.getMovieAuthor() + ", Released: " + toEdit.getReleaseDate());
			System.out.println("1 : Update Movie Title");
			System.out.println("2 : Update Director's Name");
			System.out.println("3 : Update Release Date");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("Change Movie: ");
				String newMovieName = in.nextLine();
				toEdit.setMovieName(newMovieName);
			} else if (update == 2) {
				System.out.print("Change Author: ");
				String newAuthor = in.nextLine();
				toEdit.setMovieAuthor(newAuthor);
			} else if (update == 3) {
				System.out.print("Change Release Date: ");
				int newYear = in.nextInt();
				toEdit.setReleaseDate(newYear);
			}

			lmh.updateMovie(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}
}
