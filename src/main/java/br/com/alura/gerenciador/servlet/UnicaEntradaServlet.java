package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import br.com.alura.gerenciador.acao.Acao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.alura.gerenciador.acao."+ paramAcao;
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse); 
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEndere�o =	nome.split(":");
		
		if(tipoEndere�o[0].equals("forward")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEndere�o[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndere�o[1]);
		}	
		
//		String nome = null;		
//		if(paramAcao.equals("ListaEmpresas")) {
//			
//			ListaEmpresas acao = new ListaEmpresas();
//			nome= acao.executa(request, response);
//		
//		} else if(paramAcao.equals("RemovaEmpresa")) {
//			
//			RemovaEmpresa acao = new RemovaEmpresa();
//			nome= acao.executa(request, response);
//		
//		} else if(paramAcao.equals("MostraEmpresa")) {
//
//			MostraEmpresa acao = new MostraEmpresa();
//			nome= acao.executa(request, response);
//			
//		} else if(paramAcao.equals("AlteraEmpresa")) {
//			
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//		} else if(paramAcao.equals("NovaEmpresa")) {
//			
//			NovaEmpresa acao = new NovaEmpresa();
//			nome =acao.executa(request, response);
//		} else if(paramAcao.equals("NovaEmpresaForm")) {
//			
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome =acao.executa(request, response);
//		}
		
	
	}
		
}
