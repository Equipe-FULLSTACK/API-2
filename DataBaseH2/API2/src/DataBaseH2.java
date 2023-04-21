/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thiag
 */

//CONEXÃO COM BANCO DE DADOS H2
public class DataBaseH2 {

    public static void main(String[] args){
        connectDataBase();
    }
    
       public static void connectDataBase(){
           String jdbcURL = "jdbc:h2:D:/thiag/Documents/00 - Programação/API-2/DataBaseH2/Packpage/h2-2.1.214/gerenciamento";
           String username = "sa";
           String password = "";                
           
           try{
                // Abertura conexão com banco de dados. //
                Connection connection = DriverManager.getConnection(jdbcURL); // inicia conexão com banco de dados.
                System.out.println("Conectado ao banco H2");
                
                connection.close(); // Encerra conexão com banco de dados.
                
           } catch (SQLException e) { // Tratativa de excessões erros de conexão.
                e.printStackTrace(); // Imprimi os erros caso haja problema na conexão.
           }
           
       }
}
