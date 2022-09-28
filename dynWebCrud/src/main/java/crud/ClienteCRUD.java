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

public class ClienteCRUD implements CRUDInterface{
	private static Connection connection = DAO.createConnection();
	private static String query;
	
	public static Cliente encontarPorPK(int id) {
		query=String.format("SELECT * FROM clientes WHERE id = %d",id);
		System.out.println(query);
		Cliente cliente = new Cliente();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));

				cliente.setCpf(rs.getString("cpf"));
				cliente.setData_de_nascimento(rs.getDate("data_de_nascimento"));
				cliente.setData_de_registro(rs.getDate("data_de_registro"));
				//debug
				System.out.println("inPK"+ cliente.getId()+ cliente.getNome() );
				System.out.println("Encontrou Clientes");
			}
			return cliente;
		} catch (SQLException e) {
			System.out.println("erro de busca" + e.getMessage());
			return null;
		}	
	}
	
	public static List<Cliente> listartodos() {
		query=String.format("SELECT * "
							+ "FROM clientes");
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			//While, adicionar todos clientes realizada na pesquisa query em um objeto lista Clientes
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
			//retorna lista para visualização(Chamado em controller)
			return clientes;
		} catch (SQLException e) {
			System.out.println("erro de busca" + e.getMessage());
			return null;
		}
	}
		
	public static List<Cliente> listar(String pesquisa) {
		query=String.format("SELECT * "
							+ "FROM clientes "
							+ "WHERE nome LIKE '%s%%' OR cpf LIKE '%s%%' ", pesquisa, pesquisa);
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			//While, adicionar todos clientes realizada na pesquisa query em um objeto lista Clientes
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
	public static void create(Cliente obj) {
		query = "INSERT INTO clientes "
				+ "VALUES (null, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			//Values ?
			ps.setString(1, obj.getNome());
			ps.setString(2, obj.getCpf());
			ps.setDate(3, obj.getData_de_nascimento());
			ps.setDate(4, obj.getData_de_registro());
			
			ps.executeUpdate();
			
			System.out.println("inserido");
		} catch(SQLException e){
			System.out.println("erro de inserção"+e.getMessage());
		}
	}
	public static void update(Cliente obj) {
		query = "UPDATE clientes SET  nome = ?, cpf = ?, data_de_nascimento = ? "
				+ "WHERE id = ?";
		//Debug
		System.out.println("inUpdate"+ obj.getId()+ obj.getNome() );
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
			//debug
			System.out.println("inUpdateAfter"+ obj.getId()+ obj.getNome() );
			
			ps.executeUpdate();
			System.out.println("Atualizado");
		} catch(SQLException e){
			System.out.println("erro de inserção"+e.getMessage());
		}	
	}
	
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
