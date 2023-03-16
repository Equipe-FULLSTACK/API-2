package models;

import java.util.LinkedHashSet;
import java.util.Set;

public class Disciplina {
    private String nome;
    Set<Alunos> alunosInscritos = new LinkedHashSet<>();
    Set<Atividades> atividades = new LinkedHashSet<>();


    public void inscreverAluno(Alunos aluno){

        this.alunosInscritos.add(aluno);
    }

    public void adicionarAtividade(Atividades atividade){

        this.atividades.add(atividade);
        atividade.getAlunosPropostos().addAll(alunosInscritos);
    }



    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set<Alunos> getAlunosInscritos() {
        return alunosInscritos;
    }
    public void setAlunosInscritos(Set<Alunos> alunosInscritos) {
        this.alunosInscritos = alunosInscritos;
    }
    public Set<Atividades> getAtividades() {
        return atividades;
    }
    public void setAtividades(Set<Atividades> atividades) {
        this.atividades = atividades;
    }
    

    
}
