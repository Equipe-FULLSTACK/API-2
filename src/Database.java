import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;

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
	
	public static void selectAulas(DefaultListModel<String> turma, DefaultListModel<String> hora_inicio, DefaultListModel<String> hora_final, String dia){
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM aulas WHERE dia = '" + dia + "'");
			turma.clear();
			hora_inicio.clear();
			hora_final.clear();
			while (rs.next()) {
				//String id = rs.getString("id");
				turma.addElement(rs.getString("nome"));
				hora_inicio.addElement(rs.getString("inicio"));
				hora_final.addElement(rs.getString("final"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insertAula(String nome, String dia, String hora_inicio, String hora_final){
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO aulas (nome, dia, inicio, final) VALUES ('" + nome + "', '" + dia + "', '" + hora_inicio + "', '" + hora_final + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteAula(String nome, String dia, String hora_inicio, String hora_final){
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM aulas WHERE nome = '" + nome + "' AND dia = '" + dia + "' AND inicio = '" + hora_inicio + "' AND final = '" + hora_final + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void selectAlunosAulas(DefaultListModel<String> list, String nome, String dia, String hora_inicio, String hora_final){
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM alunos_aulas WHERE id_aula = (SELECT id FROM aulas WHERE nome = '" + nome + "' AND dia = '" + dia + "' AND inicio = '" + hora_inicio + "' AND final = '" + hora_final + "');");
			list.clear();
			while (rs.next()) {
				list.addElement(rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insertAlunoAula(String nome, String dia, String hora_inicio, String hora_final, String aluno){
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO alunos_aulas (id_aula, nome) VALUES ( (SELECT id FROM aulas WHERE nome = '" + nome + "' AND dia = '" + dia + "' AND inicio = '" + hora_inicio + "' AND final = '" + hora_final + "'), '" + aluno + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteAlunoAula(String nome, String dia, String hora_inicio, String hora_final, String aluno){
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM alunos_aulas WHERE id_aula = (SELECT id FROM aulas WHERE nome = '" + nome + "' AND dia = '" + dia + "' AND inicio = '" + hora_inicio + "' AND final = '" + hora_final + "') AND nome = '" + aluno + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void selectTarefas(DefaultListModel<String> tarefas, String data_entrega){
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tarefas WHERE data_entrega = '" + data_entrega + "';");
			tarefas.clear();
			while (rs.next()) {
				//String id = rs.getString("id");
				tarefas.addElement(rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insertTarefa(String nome, String data_inicial, String data_entrega){
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO tarefas (nome, data_inicial, data_entrega) VALUES ('" + nome + "', '" + data_inicial + "', '" + data_entrega + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteTarefa(String nome, String data_entrega){
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM tarefas WHERE nome = '" + nome + "' AND data_entrega = '" + data_entrega + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void selectAlunosTarefas(DefaultListModel<String> list, String nome, String data_entrega){
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM alunos_tarefas WHERE id_tarefa = (SELECT id FROM tarefas WHERE nome = '" + nome + "' AND data_entrega = '" + data_entrega + "');");
			list.clear();
			while (rs.next()) {
				list.addElement(rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insertAlunoTarefa(String nome, String data_entrega, String aluno){
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO alunos_tarefas (id_tarefa, nome) VALUES ( (SELECT id FROM tarefas WHERE nome = '" + nome + "' AND data_entrega = '" + data_entrega + "'), '" + aluno + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteAlunoTarefa(String nome, String data_entrega, String aluno){
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM alunos_tarefas WHERE id_tarefa = (SELECT id FROM tarefas WHERE nome = '" + nome + "' AND data_entrega = '" + data_entrega + "') AND nome = '" + aluno + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void carregarAlunosAulas(DefaultListModel<String> list, String aula, String dia, String hora_inicio, String hora_final, String tarefa, String data_entrega){
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM alunos_aulas WHERE id_aula = (SELECT id FROM aulas WHERE nome = '" + aula + "' AND dia = '" + dia + "' AND inicio = '" + hora_inicio + "' AND final = '" + hora_final + "');");
			while (rs.next()) {
				insertAlunoTarefa(tarefa, data_entrega, rs.getString("nome"));
			}
			selectAlunosTarefas(list, tarefa, data_entrega);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
