/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;
import java.sql.Connection; // CONEXÃO SQL PARA JAVA
import java.sql.DriverManager; // DRIVER DE CONEXÃO SQL PARA JAVA
import java.sql.SQLException; // CONEXÃO SQL PARA JAVA

/**
 *
 * @author Fatec
 */
public class ConnectionFactory {
    public Connection getConnection() {
                try{
                    return DriverManager.getConnection("jdbc:mysql://localhost/gerenciamento","root","fatec");
                }
                catch(SQLException excecao){
                    throw new RuntimeException(excecao);
                }
                }
}
