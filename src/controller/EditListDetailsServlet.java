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
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper dao = new ListDetailsHelper();
		ListMoviesHelper lmh = new ListMoviesHelper();
		ProductionCompanyHelper pch = new ProductionCompanyHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String companyName = request.getParameter("productionCompanyName");
		ProductionCompany newCompany = pch.findCompany(companyName);
		
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		try {
			String[] selectedMovies = request.getParameterValues("allMoviesToAdd");
			List<ListMovies> selectedMoviesInList = new ArrayList<ListMovies>();
			
			for (int i = 0; i < selectedMovies.length; i++) {
				System.out.println(selectedMovies[i]);
				ListMovies c = lmh.searchForItemById(Integer.parseInt(selectedMovies[i]));
				selectedMoviesInList.add(c);
				listToUpdate.setListOfMovies(selectedMoviesInList);
			}
		
		} catch (NullPointerException ex) {
			List<ListMovies> selectedMoviesInList = new ArrayList<ListMovies>();
			listToUpdate.setListOfMovies(selectedMoviesInList);
		}
		
		listToUpdate.setListName(newListName);
		listToUpdate.setTripDate(ld);
		listToUpdate.setCompany(newCompany);
		
		dao.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}
}
