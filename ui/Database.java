import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {
	static Connection conn;
	
	public static void connectDatabase(){
		String jdbcURL = "jdbc:h2:~/api";
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
	
	public static void selectAulas(String dia){
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM aulas WHERE dia = '" + dia + "'");
			Menu.listTurmas1.clear();
			Menu.listInicio1.clear();
			Menu.listFinal1.clear();
			while (rs.next()) {
				//String id = rs.getString("id");
				Menu.listTurmas1.addElement(rs.getString("nome"));
				Menu.listInicio1.addElement(rs.getString("inicio"));
				Menu.listFinal1.addElement(rs.getString("final"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insertAula(String nome, String dia, String hora_inicio, String hora_final){
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO aulas (nome, dia, inicio, final) VALUES ('" + nome + "', '" + dia + "', '" + hora_inicio + "', '" + hora_final + "');");
			atualizarAulas();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteAula(String nome, String dia, String hora_inicio, String hora_final){
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM aulas WHERE nome = '" + nome + "' AND dia = '" + dia + "' AND inicio = '" + hora_inicio + "' AND final = '" + hora_final + "';");
			atualizarAulas();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void atualizarAulas(){
		selectAulas(Menu.list_dia1.getSelectedValue());
	}
	
	public static void selectAlunosAulas(String nome, String dia, String hora_inicio, String hora_final){
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM alunos_aulas WHERE id_aula = (SELECT id FROM aulas WHERE nome = '" + nome + "' AND dia = '" + dia + "' AND inicio = '" + hora_inicio + "' AND final = '" + hora_final + "');");
			Menu.listAlunos1.clear();
			while (rs.next()) {
				Menu.listAlunos1.addElement(rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insertAlunoAula(String nome, String dia, String hora_inicio, String hora_final, String aluno){
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO alunos_aulas (id_aula, nome) VALUES ( (SELECT id FROM aulas WHERE nome = '" + nome + "' AND dia = '" + dia + "' AND inicio = '" + hora_inicio + "' AND final = '" + hora_final + "'), '" + aluno + "');");
			atualizarAlunosAulas();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteAlunoAula(String nome, String dia, String hora_inicio, String hora_final, String aluno){
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM alunos_aulas WHERE id_aula = (SELECT id FROM aulas WHERE nome = '" + nome + "' AND dia = '" + dia + "' AND inicio = '" + hora_inicio + "' AND final = '" + hora_final + "') AND nome = '" + aluno + "';");
			atualizarAlunosAulas();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void atualizarAlunosAulas(){
		selectAlunosAulas(Menu.list_turmas1.getSelectedValue(), Menu.list_dia1.getSelectedValue(), Menu.list_inicio1.getSelectedValue(), Menu.list_final1.getSelectedValue());
	}
	
	
	public static void selectAulas2(String dia){
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM aulas WHERE dia = '" + dia + "'");
			Menu.listTurmas2.clear();
			Menu.listInicio2.clear();
			Menu.listFinal2.clear();
			while (rs.next()) {
				//String id = rs.getString("id");
				Menu.listTurmas2.addElement(rs.getString("nome"));
				Menu.listInicio2.addElement(rs.getString("inicio"));
				Menu.listFinal2.addElement(rs.getString("final"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
