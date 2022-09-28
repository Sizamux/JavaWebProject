package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Classe que estabelece conecção ao banco de dados
public class DAO {
	private static final String url = "jdbc:mysql://localhost:3306/dannydb";
	private static final String user = "admin";
	private static final String password = "password";
	
	//metodo para estabelecer conecção
	public static Connection createConnection() {
		//Tratamento de erro-driver
		try {		
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver encontrado.");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver não encontrado. erro: " + e.getMessage());
		}
		//Tratamento de erro-Banco de dados
		try {	
			Connection connection = DriverManager.getConnection(url,user,password);
			System.out.println("Conectado ao Banco de Dados.");
			return connection;		//estabelece conecção
		}
		catch (SQLException e) {
			System.out.println("Não foi conectado ao Banco de Dados. erro: " + e.getMessage());
			return null;			//retorna nulo
		}
	}
}
