/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testes;
import modelo.Aluno;
import dao.*;
import factory.*;
/**
 *
 * @author Fatec
 */
public class TestesDB {
    
    public static void main( String[] args ){
        
        Aluno aluno1 = new Aluno("leonardo");
        Aluno aluno2 = new Aluno("Thiago");
        
        System.out.println(aluno1.getNome());
        System.out.println(aluno2.getNome());

        ClienteDAO.adiciona( aluno1);
    }
    
}
