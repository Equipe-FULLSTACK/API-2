import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {
	static Connection conn;
	
	public static void connectDatabase(){
		String jdbcURL = "jdbc:h2:~/gerenciamento";
		String username = "sa";
		String password = "";                
           
		try{
			// Abertura conexão com banco de dados. //
			conn = DriverManager.getConnection(jdbcURL, username, password); // inicia conexão com banco de dados.
			System.out.println("Conectado ao banco H2");
		} catch (SQLException e) { // Tratativa de excessões erros de conexão.
			e.printStackTrace(); // Imprimi os erros caso haja problema na conexão.
		}  
	}
	
	public static void selectAula(){
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM aula");
			while (rs.next()) {
				String id = rs.getString("id");
				String nome = rs.getString("nome");
				String hora_inicio = rs.getString("inicio");
				String hora_final = rs.getString("final");
				String dia = rs.getString("dia");
				System.out.println(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertAula(String n, String i, String f, int d){
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO aula VALUES (" + n + ", '" + i + "', " + f + ", " + d + ")");
			while (rs.next()) {
				String id = rs.getString("id");
				String nome = rs.getString("nome");
				String hora_inicio = rs.getString("inicio");
				String hora_final = rs.getString("final");
				String dia = rs.getString("dia");
				System.out.println(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
