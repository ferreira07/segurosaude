package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factories.Context;
import service.IPlanoService;

/**
 * Servlet implementation class ListarPlano
 */
@WebServlet("/ListarPlano")
public class ListarPlano extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IPlanoService planoService;
	
    public ListarPlano() {
		planoService = Context.getPlanoService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("planos", 	planoService.list());
		request.getRequestDispatcher("listarPlanos.jsp").forward(request, response);
	}
}
