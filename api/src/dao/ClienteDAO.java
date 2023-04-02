/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import factory.ConnectionFactory;
import java.sql.*;
import java.sql.PreparedStatement;
import modelo.Aluno;


/**
 *
 * @author Fatec
 */
public class ClienteDAO {
    private Connection connection;
       
    
 // OBTENDO CONEXÃO COM BANCO DE DADOS
    public ClienteDAO () {
        this.connection = new ConnectionFactory().getConnection();
    }

    //CLASSE PARA ADICIONAR CLIENTE
    public void adiciona(Aluno aluno){
        String sql = "INSERT INTO aluno(nome) VALUES(?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            // STRING id aux=Integer.toString(cliente.getId);
            stmt.setString(1, aluno.getNome());
            stmt.execute();
            stmt.close();
            System.out.println("Inserção sucedida com sucesso !!!");
        }
        catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
