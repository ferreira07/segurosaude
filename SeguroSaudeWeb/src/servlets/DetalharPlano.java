package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factories.Context;
import service.IFaixaEtariaService;
import service.IPlanoService;

/**
 * Servlet implementation class DetalharPlano
 */
@WebServlet("/DetalharPlano")
public class DetalharPlano extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IPlanoService planoService;
	IFaixaEtariaService faixaEtariaService;
	
    public DetalharPlano() {
		planoService = Context.getPlanoService();
		faixaEtariaService = Context.getFaixaEtariaService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		
		request.setAttribute("plano", planoService.get(id));
		request.setAttribute("faixas", faixaEtariaService.listByPlano(id));
		
		request.getRequestDispatcher("listarPlanos.jsp").forward(request, response);
	}

}
