package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListMovies;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/editMovieServlet")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ListMoviesHelper dao = new ListMoviesHelper();
		
		String movie = request.getParameter("movie");
		String director = request.getParameter("director");
		String date = request.getParameter("date");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ListMovies movieToUpdate = dao.searchForItemById(tempId);
		movieToUpdate.setMovieName(movie);
		movieToUpdate.setMovieAuthor(director);
		movieToUpdate.setReleaseDate(Integer.parseInt(date));
		
		dao.updateMovie(movieToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);;
	}

}
