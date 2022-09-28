package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import db.DAO;
import model.Cliente;

//Estabelece Conexão
public class ClienteCRUD implements CRUDInterface{
	private static Connection connection = DAO.createConnection();
	private static String query;
	
	//LIST POR PK
	public static Cliente encontarPorPK(int id) {
		//querySQL
		query=String.format("SELECT * FROM clientes WHERE id = %d",id);
		//System.out.println(query);
		//cria Obj cliente
		Cliente cliente = new Cliente();
		//TrataErro
		try {
			Statement st = connection.createStatement();
			//executa query e Guarda Resultados da em novo objeto do tipo ResultSet
			ResultSet rs = st.executeQuery(query);
			//Enquanto tiver Linha em nos Resultados faz; Neste caso só tem uma linha, sem necessidade de criar lista de clientes
			while(rs.next()) {
				//utilização de metodos set's -Obj cliente recebe dados do banco de dados via rs.get"tipo"("nomeDaColuna")
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setData_de_nascimento(rs.getDate("data_de_nascimento"));
				cliente.setData_de_registro(rs.getDate("data_de_registro"));
				System.out.println("Encontrou Clientes");
			}
			return cliente;
		} catch (SQLException e) {
			System.out.println("erro de busca" + e.getMessage());
			return null;
		}	
	}
	//LIST TODOS
	public static List<Cliente> listartodos() {
		query=String.format("SELECT * "
							+ "FROM clientes");
		//Lista de Clientes que aceita objetos clientes
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Statement st = connection.createStatement();
			//executa query e Guarda Resultados da em novo objeto do tipo ResultSet
			ResultSet rs = st.executeQuery(query);
			
			//Enquanto tiver Linha em nos Resultados faz:
			while(rs.next()) {
				//cria obj cliente
				Cliente cliente = new Cliente();
				//utilização de metodos set's -Obj cliente recebe dados do banco de dados via rs.get"tipo"("nomeDaColuna")
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setData_de_nascimento(rs.getDate("data_de_nascimento"));
				cliente.setData_de_registro(rs.getDate("data_de_registro"));
				//adiciona objeto cliente na listas de clientes
				clientes.add(cliente);
			}
			System.out.println("Encontrou Clientes");
			//retorna lista para visualização(Chamado em controller)
			return clientes;
		} catch (SQLException e) {
			System.out.println("erro de busca" + e.getMessage());
			return null;
		}
	}
	//LIST PESQUISA
	public static List<Cliente> listar(String pesquisa) {
		query=String.format("SELECT * "
							+ "FROM clientes "
							+ "WHERE nome LIKE '%s%%' OR cpf LIKE '%s%%' ", pesquisa, pesquisa);
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setData_de_nascimento(rs.getDate("data_de_nascimento"));
				cliente.setData_de_registro(rs.getDate("data_de_registro"));
				
				clientes.add(cliente);
			}
			System.out.println("Encontrou Clientes");
			return clientes;
		} catch (SQLException e) {
			System.out.println("erro de busca" + e.getMessage());
			return null;
		}
		
	}
	//CRIAR
	public static void create(Cliente obj) { //Recebe objeto cliente via action do controlador
		query = "INSERT INTO clientes "
				+ "VALUES (null, ?, ?, ?, ?)";
		try {
			//prepara query para ser enviada ao Banco de dados
			PreparedStatement ps = connection.prepareStatement(query);
			//Values ? em query são tratados: Cada ? da query recebe dados do objeto que veio via parametro
			ps.setString(1, obj.getNome());
			ps.setString(2, obj.getCpf());
			ps.setDate(3, obj.getData_de_nascimento());
			ps.setDate(4, obj.getData_de_registro());
			//Executa o statement e realiza Commit
			ps.executeUpdate();
			
			System.out.println("inserido");
		} catch(SQLException e){
			System.out.println("erro de inserção"+e.getMessage());
		}
	}
	//UPDATE
	public static void update(Cliente obj) {
		query = "UPDATE clientes SET  nome = ?, cpf = ?, data_de_nascimento = ? "
				+ "WHERE id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			//para set
			ps.setString(1, obj.getNome());
			ps.setString(2, obj.getCpf());
			ps.setDate(3, obj.getData_de_nascimento());
			//para where
			ps.setInt(4, obj.getId());
			//commit sql
			ps.execute();
			ps.executeUpdate();
			System.out.println("Atualizado");
		} catch(SQLException e){
			System.out.println("erro de inserção"+e.getMessage());
		}	
	}
	//DELETE
	public static void delete(int id) {
		query = String.format("DELETE FROM clientes WHERE id = %d",id);
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			//commit sql
			ps.executeUpdate();
			
			System.out.println("detetado");
		} catch(SQLException e){
			System.out.println("erro de deleção"+e.getMessage());
		}
	}
}
