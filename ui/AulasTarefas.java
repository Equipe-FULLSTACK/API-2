import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import java.util.Date;
import java.text.SimpleDateFormat;

import java.awt.Color;

public class AulasTarefas {
	static void definirAulasTarefas(int width, int height){
		Menu.definirLbl (Menu.lbl_dia1,             Menu.pct(width,  2), Menu.pct(height,  9), Menu.pct(width, 22), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList(Menu.panel_list_dia1,      Menu.pct(width,  2), Menu.pct(height, 16), Menu.pct(width, 22), Menu.pct(height, 23), Menu.fonteLista, Menu.scroll_list_dia1, Menu.list_dia1);
		
		Menu.definirLbl (Menu.lbl_turmas1,          Menu.pct(width,  2), Menu.pct(height, 40), Menu.pct(width, 12), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_inicio1,          Menu.pct(width, 14), Menu.pct(height, 40), Menu.pct(width,  5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_final1,           Menu.pct(width, 19), Menu.pct(height, 40), Menu.pct(width,  5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTxt (Menu.txt_turmas1,          Menu.pct(width,  2), Menu.pct(height, 47), Menu.pct(width, 12), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirTxt (Menu.txt_inicio1,          Menu.pct(width, 14), Menu.pct(height, 47), Menu.pct(width,  5), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirTxt (Menu.txt_final1,           Menu.pct(width, 19), Menu.pct(height, 47), Menu.pct(width,  5), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirList(Menu.panel_list_turmas1,   Menu.pct(width,  2), Menu.pct(height, 52), Menu.pct(width, 12), Menu.pct(height, 30), Menu.fonteLista, Menu.scroll_list_turmas1, Menu.list_turmas1);
		Menu.definirList(Menu.panel_list_inicio1,   Menu.pct(width, 14), Menu.pct(height, 52), Menu.pct(width, 5),  Menu.pct(height, 30), Menu.fonteLista, Menu.scroll_list_inicio1, Menu.list_inicio1);
		Menu.definirList(Menu.panel_list_final1,    Menu.pct(width, 19), Menu.pct(height, 52), Menu.pct(width, 5),  Menu.pct(height, 30), Menu.fonteLista, Menu.scroll_list_final1,  Menu.list_final1);
		Menu.definirBtn (Menu.btn_adicionar_aula1,  Menu.pct(width, 2),  Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtnTopo);
		Menu.definirBtn (Menu.btn_remover_aula1,    Menu.pct(width, 13), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtnTopo);
		
		Menu.definirLbl (Menu.lbl_alunos1,          Menu.pct(width, 25), Menu.pct(height,  9), Menu.pct(width, 22), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList(Menu.panel_list_alunos1,   Menu.pct(width, 26), Menu.pct(height, 16), Menu.pct(width, 22), Menu.pct(height, 61), Menu.fonteLista, Menu.scroll_list_alunos1, Menu.list_alunos1);
		Menu.definirTxt (Menu.txt_alunos1,          Menu.pct(width, 26), Menu.pct(height, 77), Menu.pct(width, 22), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirBtn (Menu.btn_adicionar_aluno1, Menu.pct(width, 26), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtnTopo);
		Menu.definirBtn (Menu.btn_remover_aluno1,   Menu.pct(width, 37), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtnTopo);
		
		
		Menu.definirPanel(Menu.panel_divisao,       Menu.pct(width, 49.5), Menu.pct(height, 7.75), 1, Menu.pct(height,  100));
		Menu.panel_divisao.setOpaque(true); Menu.panel_divisao.setBackground(Color.GRAY);
		
		Menu.definirLbl (Menu.lbl_data2,            Menu.pct(width, 50), Menu.pct(height,  9), Menu.pct(width, 10), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirDate(Menu.datepicker_tarefa,    Menu.pct(width, 51), Menu.pct(height, 16), Menu.pct(width, 10), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirLbl (Menu.lbl_dia2,             Menu.pct(width, 61), Menu.pct(height, 14), Menu.pct(width, 13), Menu.pct(height,  8), Menu.fonteBtnTopo);
		
		Menu.definirLbl (Menu.lbl_turmas2,          Menu.pct(width, 50), Menu.pct(height, 20), Menu.pct(width, 12), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_inicio2,          Menu.pct(width, 63), Menu.pct(height, 20), Menu.pct(width,  5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_final2,           Menu.pct(width, 68), Menu.pct(height, 20), Menu.pct(width,  5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList(Menu.panel_list_turmas2,   Menu.pct(width, 51), Menu.pct(height, 27), Menu.pct(width, 12), Menu.pct(height, 21), Menu.fonteLista, Menu.scroll_list_turmas2, Menu.list_turmas2);
		Menu.definirList(Menu.panel_list_inicio2,   Menu.pct(width, 63), Menu.pct(height, 27), Menu.pct(width,  5), Menu.pct(height, 21), Menu.fonteLista, Menu.scroll_list_inicio2, Menu.list_inicio2);
		Menu.definirList(Menu.panel_list_final2,    Menu.pct(width, 68), Menu.pct(height, 27), Menu.pct(width,  5), Menu.pct(height, 21), Menu.fonteLista, Menu.scroll_list_final2, Menu.list_final2);
		
		Menu.definirLbl (Menu.lbl_tarefas2,         Menu.pct(width, 50), Menu.pct(height, 49), Menu.pct(width, 22), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTxt (Menu.txt_tarefas2,         Menu.pct(width, 51), Menu.pct(height, 56), Menu.pct(width, 22), Menu.pct(height, 5), Menu.fonteLista);
		Menu.definirList(Menu.panel_list_tarefas2,  Menu.pct(width, 51), Menu.pct(height, 61), Menu.pct(width, 22), Menu.pct(height, 21), Menu.fonteLista, Menu.scroll_list_tarefas2, Menu.list_tarefas2);
		Menu.definirBtn (Menu.btn_adicionar_tarefa2, Menu.pct(width, 51), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtnTopo);
		Menu.definirBtn (Menu.btn_remover_tarefa2,   Menu.pct(width, 62), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtnTopo);
		
		Menu.definirLbl (Menu.lbl_alunos2,          Menu.pct(width, 74), Menu.pct(height,  9), Menu.pct(width, 22), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirBtn (Menu.btn_carregar2,        Menu.pct(width, 74), Menu.pct(height, 16), Menu.pct(width, 22), Menu.pct(height,  6), Menu.fonteBtnTopo);
		Menu.definirList(Menu.panel_list_alunos2,   Menu.pct(width, 74), Menu.pct(height, 22), Menu.pct(width, 22), Menu.pct(height, 55), Menu.fonteLista, Menu.scroll_list_alunos2, Menu.list_alunos2);
		Menu.definirTxt (Menu.txt_alunos2,          Menu.pct(width, 74), Menu.pct(height, 77), Menu.pct(width, 22), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirBtn (Menu.btn_adicionar_aluno2, Menu.pct(width, 74), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtnTopo);
		Menu.definirBtn (Menu.btn_remover_aluno2,   Menu.pct(width, 85), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtnTopo);
	}

	static void definirVisivel(boolean status){
		Menu.lbl_turmas1.setVisible(status);
		Menu.lbl_inicio1.setVisible(status);
		Menu.lbl_final1.setVisible(status);
		Menu.txt_turmas1.setVisible(status);
		Menu.txt_inicio1.setVisible(status);
		Menu.txt_final1.setVisible(status);
		Menu.panel_list_turmas1.setVisible(status);
		Menu.panel_list_inicio1.setVisible(status);
		Menu.panel_list_final1.setVisible(status);
		
		Menu.lbl_alunos1.setVisible(status);
		Menu.txt_alunos1.setVisible(status);
		Menu.panel_list_alunos1.setVisible(status);
		Menu.btn_adicionar_aluno1.setVisible(status);
		Menu.btn_remover_aluno1.setVisible(status);
		
		Menu.lbl_dia1.setVisible(status);
		Menu.panel_list_dia1.setVisible(status);
		Menu.btn_adicionar_aula1.setVisible(status);
		Menu.btn_remover_aula1.setVisible(status);
		
		
		Menu.lbl_data2.setVisible(status);
		Menu.datepicker_tarefa.setVisible(status);
		
		Menu.lbl_turmas2.setVisible(status);
		Menu.lbl_inicio2.setVisible(status);
		Menu.lbl_final2.setVisible(status);
		Menu.panel_list_turmas2.setVisible(status);
		Menu.panel_list_inicio2.setVisible(status);
		Menu.panel_list_final2.setVisible(status);
		
		Menu.lbl_dia2.setVisible(status);
		
		Menu.lbl_tarefas2.setVisible(status);
		Menu.txt_tarefas2.setVisible(status);
		Menu.panel_list_tarefas2.setVisible(status);
		Menu.btn_adicionar_tarefa2.setVisible(status);
		Menu.btn_remover_tarefa2.setVisible(status);
		
		Menu.lbl_alunos2.setVisible(status);
		Menu.panel_list_alunos2.setVisible(status);
		Menu.txt_alunos2.setVisible(status);
		Menu.btn_adicionar_aluno2.setVisible(status);
		Menu.btn_remover_aluno2.setVisible(status);
		Menu.btn_carregar2.setVisible(status);
		
		Menu.panel_divisao.setVisible(status);
	}
	
	static void definirEventos() {
		//btn_adicionar_aula1
		Menu.btn_adicionar_aula1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Adicionando aula");
			}
		});
		//btn_remover_aula1
		Menu.btn_remover_aula1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Removendo aula");
			}
		});
		
		//btn_adicionar_aluno1
		Menu.btn_adicionar_aluno1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Adicionando aluno 1");
			}
		});
		//btn_remover_aluno1
		Menu.btn_remover_aluno1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Removendo aluno 1");
			}
		});
		
		
		//btn_adicionar_tarefa2
		Menu.btn_adicionar_tarefa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Adicionando tarefa");
			}
		});
		//btn_remover_tarefa2
		Menu.btn_remover_tarefa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Removendo tarefa");
			}
		});
		
		//btn_adicionar_aluno2
		Menu.btn_adicionar_aluno2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Adicionando aluno 2");
			}
		});
		//btn_remover_aluno2
		Menu.btn_remover_aluno2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Removendo aluno 2");
			}
		});
		
		//btn_carregar2
		Menu.btn_carregar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Carregando alunos");
			}
		});
		
		Menu.datepicker_tarefa.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() { public void propertyChange(PropertyChangeEvent e) {
			if ("date".equals(e.getPropertyName())) {
				Menu.lbl_dia2.setText(new SimpleDateFormat("EEEE").format((Date) e.getNewValue()));
            }
		}});
	}
}