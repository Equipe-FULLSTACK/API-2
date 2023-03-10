package models;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Atividades {

    String titulo;
    Boolean concluido;
    Set<Alunos> alunosPropostos = new LinkedHashSet<>();


    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Boolean getConcluido() {
        return concluido;
    }
    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }
    public Set<Alunos> getAlunosPropostos() {
        return alunosPropostos;
    }
    public void setAlunosPropostos(Set<Alunos> alunosPropostos) {
        this.alunosPropostos = alunosPropostos;
    }

    
}
