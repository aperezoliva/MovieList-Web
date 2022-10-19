package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.ListMovies;
import model.ProductionCompany;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListMoviesHelper lmh = new ListMoviesHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String companyName =
				request.getParameter("productionCompanyName");
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedMovies = request.getParameterValues("allMoviesToAdd");
		List<ListMovies> selectedMovieInList = new ArrayList<ListMovies>(); 
		
		if (selectedMovies != null && selectedMovies.length > 0) {
			for(int i = 0; i < selectedMovies.length; i++) {
				ListMovies m = lmh.searchForItemById(Integer.parseInt(selectedMovies[i]));
				selectedMovieInList.add(m);
			}
		}
		
		ProductionCompany company = new ProductionCompany(companyName);
		ListDetails sld = new ListDetails(listName, ld, company);
		
		sld.setListOfMovies(selectedMovieInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(sld);
		
		System.out.println("it works i guess");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
