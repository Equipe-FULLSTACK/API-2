package models;

import java.util.LinkedHashSet;
import java.util.Set;

public class Alunos {

    String nome;
    Set<Disciplina> disciplinasInscritas = new LinkedHashSet<>();
    Set<Atividades> atividadesPropostas = new LinkedHashSet<>();


    public void inscreverDisciplina(Disciplina disciplina){
        this.disciplinasInscritas.add(disciplina);

    }

}
