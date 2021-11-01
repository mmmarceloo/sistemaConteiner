package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/movimentacao", "/conteiner", "/inserirConteiner", "/consultaConteiner",
		"/modificarConteiner", "/deleteConteiner", "/editarMovimentacao", "/cadastroMovimentacao",
		"/inserirMovimentacao", "/deletaMovimentacao", "/relatorio","/consultarMovimentacao","/modificarMovimentacao" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans conteiner = new JavaBeans();
	JavaBeans movimentacao = new JavaBeans();
	JavaBeans consulta = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/movimentacao")) { // se o conteudo da variavel for movimentacao
			movimentacao(request, response); // vou redirecionar o metodo a requisição que eu quiser
		} else if (action.equals("/conteiner")) { // envio como parametros o req. e response
			conteiner(request, response);
		
		} else if (action.equals("/inserirConteiner")) {
			inserirConteiner(request, response);
			} else if (action.equals("/inserirMovimentacao")) {
			inserirMovimentacao(request, response);
		
			} else if (action.equals("/consultaConteiner")) {
			consultaConteiner(request, response);
			} else if (action.equals("/modificarConteiner")) {
			modificarConteiner(request, response);
		
			} else if (action.equals("/consultarMovimentacao")) {
			consultarMovimentacao(request, response);
		
		} else if (action.equals("/modificarMovimentacao")) {
			modificarMovimentacao(request, response);
		} else if (action.equals("/deleteConteiner")) {
			deleteConteiner(request, response);
		} else if (action.equals("/deletaMovimentacao")) {
			deletaMovimentacao(request, response);
		} else if (action.equals("/relatorio")) {
			relatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void conteiner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("conteiner.jsp");
	}
	protected void movimentacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("movimentacao.jsp");
	}
	protected void relatorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		ArrayList<JavaBeans> relatorio= dao.relatorio(consulta);
		int  importacao = dao.importacao(consulta);
		int  exportacao= dao.exportacao(consulta);
		
		
		System.out.println(relatorio.get(0).getMov() + "MOV NO controller");
		request.setAttribute("dados",relatorio);
		request.setAttribute("importacao",importacao);
		request.setAttribute("exportacao",exportacao);
		
		 RequestDispatcher rd = request.getRequestDispatcher("relatorio.jsp");
		 rd.forward(request, response);    // encaminha o obj lista a movi.jsp
		
		 
		 	response.sendRedirect("relatorio.jsp");
	}
	
	protected void inserirConteiner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		conteiner.setCpf(request.getParameter("cpf"));
		conteiner.setNumero(request.getParameter("numero"));
		conteiner.setTipo(request.getParameter("tipo"));
		conteiner.setSttus(request.getParameter("sttus"));
		conteiner.setCategoria(request.getParameter("categoria"));
			System.out.println("indo para o dao");
		dao.inserirConteiner(conteiner);

		response.sendRedirect("inserirConteiner.jsp");

	}
	
	protected void inserirMovimentacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		movimentacao.setCpf(request.getParameter("cpf"));
	
		movimentacao.setTipoMov(request.getParameter("tipoMov"));
		movimentacao.setDataInicio(request.getParameter("dataInicio"));
		
		movimentacao.setHoraInicio(request.getParameter("horaInicio"));
		movimentacao.setDataFim(request.getParameter("dataFim"));
		movimentacao.setHoraFim(request.getParameter("horaFim"));
		
		System.out.println(movimentacao.getTipoMov());
		System.out.println("CPF" + movimentacao.getCpf());
		
	dao.inserirMovimentacao(movimentacao);
		
		response.sendRedirect("inserirMovimentacao.jsp");
	}
	
	protected void consultaConteiner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numero = request.getParameter("numero");
		consulta.setNumero(numero);
		dao.consultaConteiner(consulta);

		request.setAttribute("numero", consulta.getNumero()); // pegar do JavaBeans e colocar nas var do form
		request.setAttribute("tipo", consulta.getTipo());
		request.setAttribute("status", consulta.getSttus());
		request.setAttribute("categoria", consulta.getCategoria());
		request.setAttribute("cpf", consulta.getCpf());
		RequestDispatcher rd = request.getRequestDispatcher("consultarConteiner.jsp"); // ctrl shift + o para importar a
																						// classe
		rd.forward(request, response);

	}
	
	
	protected void consultarMovimentacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		System.out.println("O que na string CPF:" + cpf);
		consulta.setCpf(cpf);
		System.out.println("O que naconsulta. CPF:" + consulta.getCpf());
		dao.consultaMovimentacao(consulta);

		request.setAttribute("em", consulta.getEm()); // pegar do JavaBeans e colocar nas var do form
		request.setAttribute("des", consulta.getDes());
		request.setAttribute("gin", consulta.getGin());
		request.setAttribute("gout", consulta.getGout());
		request.setAttribute("rep", consulta.getRep());
		request.setAttribute("pes", consulta.getPes());
		request.setAttribute("sca", consulta.getSca());
		request.setAttribute("mov", consulta.getMov());
		request.setAttribute("dataInicio", consulta.getDataInicio());
		request.setAttribute("horaInicio", consulta.getHoraInicio());
		request.setAttribute("dataFim", consulta.getDataFim());
		request.setAttribute("horaFim", consulta.getHoraFim());
		request.setAttribute("cpf", consulta.getCpf());
		
		
		RequestDispatcher rd = request.getRequestDispatcher("consultarMovimentacao.jsp"); // ctrl shift + o para importar a
																						// classe
		rd.forward(request, response);

	}






	protected void modificarConteiner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		consulta.setNumero(request.getParameter("numero")); // setando variaveis no JavaBeans
		consulta.setTipo(request.getParameter("tipo"));
		consulta.setSttus(request.getParameter("status"));
		consulta.setCategoria(request.getParameter("categoria"));
		consulta.setCpf(request.getParameter("cpf"));
		// executa o metodo para alterar o contato no Dao
		dao.modificarConteiner(consulta);

		response.sendRedirect("conteiner.jsp");

	}
	
	protected void modificarMovimentacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		consulta.setEm(request.getParameter("em")); // setando variaveis no JavaBeans
		consulta.setDes(request.getParameter("des"));
		consulta.setGin(request.getParameter("gin"));
		consulta.setGout(request.getParameter("gout"));
		consulta.setRep(request.getParameter("rep"));
		consulta.setPes(request.getParameter("pes"));
		consulta.setSca(request.getParameter("sca"));
		consulta.setMov(request.getParameter("mov"));
		consulta.setDataInicio(request.getParameter("dataInicio"));
		consulta.setHoraInicio(request.getParameter("horaInicio"));
		consulta.setDataFim(request.getParameter("dataFim"));
		consulta.setHoraFim(request.getParameter("horaFim"));
		consulta.setCpf(request.getParameter("cpf"));
		
		// executa o metodo para alterar o contato no Dao
		dao.modificarMovimentacao(consulta);

		response.sendRedirect("consultarMovimentacao.jsp");

	}
	
	protected void deleteConteiner(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao.deleteConteiner(consulta);
		response.sendRedirect("consultaConteiner.jsp");
		}
	
	protected void deletaMovimentacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("conteudo do cpf antes do dao" + consulta.getCpf());
		dao.deletaMovimentacao(consulta);
		response.sendRedirect("consultaMovimentacao.jsp");
		}
	
	
}