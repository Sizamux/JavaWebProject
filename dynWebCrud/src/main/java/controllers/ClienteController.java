package controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import crud.ClienteCRUD;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(urlPatterns = {"/clientes", "/cliente", "/cadastrar", "/delete","/atualizar"})

public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void clientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String pesquisa = request.getParameter("pesquisa");

		if(pesquisa == null) {
			pesquisa = "";
		}

		List<Cliente> clientes = ClienteCRUD.listar(pesquisa);
			
		request.setAttribute("clientes", clientes);
		RequestDispatcher rd = request.getRequestDispatcher("clientes.jsp");
		rd.forward(request, response);
		
    }
    
    protected void cadastrarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setData_de_nascimento(Date.valueOf(request.getParameter("nascimento")) );
		cliente.setData_de_registro(new Date(System.currentTimeMillis()) );
		ClienteCRUD.create(cliente);
		response.sendRedirect("clientes");
    }
    
	protected void atualizarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cliId = Integer.valueOf(request.getParameter( "clienteId"));
		Cliente cliente = new Cliente();
		cliente = ClienteCRUD.encontarPorPK(cliId);
		
		cliente.setId(cliId);
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setData_de_nascimento(Date.valueOf(request.getParameter("nascimento")) );
		
		ClienteCRUD.update(cliente);
		
		response.sendRedirect("clientes");
	}
	
	protected void deletarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cliId = Integer.valueOf(request.getParameter( "clienteId"));
		ClienteCRUD.delete(cliId);
		
		response.sendRedirect("clientes");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		switch (action) {
			case "/clientes":
				clientes(request,response);
				break;
			case "/cadastrar":
				cadastrarClientes(request,response);
				break;
			case "/delete":
				deletarCliente(request,response);
				break;
			case "/atualizar":
				atualizarCliente(request, response);
				break;
			default:
				response.sendRedirect("index.jsp");
				break;
		}
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
			case "/atualizar":
				//atualizarCliente(request, response);
				break;
			default:
				doGet(request, response);
				break;
		}
		doGet(request, response);
		
	}

}
