package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Plano;
import factories.Context;
import service.IPlanoService;

/**
 * Servlet implementation class AtualizarPlano
 */
@WebServlet("/AdicionarPlano")
public class AdicionarPlano extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IPlanoService planoService;
	
    public AdicionarPlano() {
    		planoService = Context.getPlanoService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		planoService.save(new Plano(nome));
		response.sendRedirect("ListarPlano");
	}

}
