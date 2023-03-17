package models;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;

public class Alunos {

    private String nome;
    Set<Disciplina> disciplinasInscritas = new LinkedList<>();
    Set<Atividades> atividadesPropostas = new LinkedList<>();


    public void inscreverDisciplina(Disciplina disciplina){
        this.disciplinasInscritas.add(disciplina);

    }

}
