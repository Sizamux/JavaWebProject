package crud;

import java.util.List;

import model.Cliente;

public interface CRUDInterface {
	
	public static Cliente encontarPorPK(int id) {
		return null;
	}
	public static List<?> listar(String query) {
		return null;
	}
	public static void create(Object obj) {};
	public static void update(Object obj) {};
	public static void delete(int id) {};
	
}
