package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AlteraEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String nomeDaEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		String paramIdEmpresa = request.getParameter("id");
		Integer id = Integer.valueOf(paramIdEmpresa);
		Date dataAbertura = null;
		
		System.out.println("acao Alterando empresa." + id);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		empresa.setNome(nomeDaEmpresa);
		empresa.setDataAbertura(dataAbertura);
		empresa.setId(id);
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}
}
