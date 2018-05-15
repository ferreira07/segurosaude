package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factories.Context;
import service.FaixaEtariaService;
import service.IFaixaEtariaService;
import service.IPlanoService;

/**
 * Servlet implementation class ListarPlano
 */
@WebServlet("/ListarFaixas")
public class ListarFaixas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IPlanoService planoService;
	IFaixaEtariaService faixaEtariaService;

	public ListarFaixas() {
		planoService = Context.getPlanoService();
		faixaEtariaService = Context.getFaixaEtariaService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s = request.getParameter("idade");
		if(s != null){
			int idade= Integer.valueOf(s);
			request.setAttribute("planos", planoService.list());
			request.setAttribute("faixas", faixaEtariaService.listByIdade(idade));
			request.getRequestDispatcher("idade.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("idade.html").forward(request, response);
			
		}
	}
}
