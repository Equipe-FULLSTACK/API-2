import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.Date;
import java.text.SimpleDateFormat;

import java.awt.Color;

public class AulasTarefas {
	
	static SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	
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
		Menu.definirBtn (Menu.btn_adicionar_aula1,  Menu.pct(width, 2),  Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtn);
		Menu.definirBtn (Menu.btn_remover_aula1,    Menu.pct(width, 13), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtn);
		
		Menu.definirLbl (Menu.lbl_alunos1,          Menu.pct(width, 26), Menu.pct(height,  9), Menu.pct(width, 22), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList(Menu.panel_list_alunos1,   Menu.pct(width, 26), Menu.pct(height, 16), Menu.pct(width, 22), Menu.pct(height, 61), Menu.fonteLista, Menu.scroll_list_alunos1, Menu.list_alunos1);
		Menu.definirTxt (Menu.txt_alunos1,          Menu.pct(width, 26), Menu.pct(height, 77), Menu.pct(width, 22), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirBtn (Menu.btn_adicionar_aluno1, Menu.pct(width, 26), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtn);
		Menu.definirBtn (Menu.btn_remover_aluno1,   Menu.pct(width, 37), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtn);
		
		
		Menu.definirPanel(Menu.panel_divisao,       Menu.pct(width, 49.5), Menu.pct(height, 7.75), 1, Menu.pct(height,  100));
		Menu.panel_divisao.setOpaque(true); Menu.panel_divisao.setBackground(Color.GRAY);
		
		Menu.definirLbl (Menu.lbl_data2,            Menu.pct(width, 50), Menu.pct(height,  9), Menu.pct(width, 10), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirDate(Menu.datepicker_tarefa,    Menu.pct(width, 51), Menu.pct(height, 16), Menu.pct(width, 22), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirLbl (Menu.lbl_dia2,             Menu.pct(width, 61), Menu.pct(height,  9), Menu.pct(width, 13), Menu.pct(height,  8), Menu.fonteBtnTopo);
		
		Menu.definirLbl (Menu.lbl_turmas2,          Menu.pct(width, 50), Menu.pct(height, 20), Menu.pct(width, 12), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_inicio2,          Menu.pct(width, 63), Menu.pct(height, 20), Menu.pct(width,  5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_final2,           Menu.pct(width, 68), Menu.pct(height, 20), Menu.pct(width,  5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList(Menu.panel_list_turmas2,   Menu.pct(width, 51), Menu.pct(height, 27), Menu.pct(width, 12), Menu.pct(height, 21), Menu.fonteLista, Menu.scroll_list_turmas2, Menu.list_turmas2);
		Menu.definirList(Menu.panel_list_inicio2,   Menu.pct(width, 63), Menu.pct(height, 27), Menu.pct(width,  5), Menu.pct(height, 21), Menu.fonteLista, Menu.scroll_list_inicio2, Menu.list_inicio2);
		Menu.definirList(Menu.panel_list_final2,    Menu.pct(width, 68), Menu.pct(height, 27), Menu.pct(width,  5), Menu.pct(height, 21), Menu.fonteLista, Menu.scroll_list_final2, Menu.list_final2);
		
		Menu.definirLbl (Menu.lbl_tarefas2,         Menu.pct(width, 50), Menu.pct(height, 49), Menu.pct(width, 22), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTxt (Menu.txt_tarefas2,         Menu.pct(width, 51), Menu.pct(height, 56), Menu.pct(width, 22), Menu.pct(height, 5), Menu.fonteLista);
		Menu.definirList(Menu.panel_list_tarefas2,  Menu.pct(width, 51), Menu.pct(height, 61), Menu.pct(width, 22), Menu.pct(height, 21), Menu.fonteLista, Menu.scroll_list_tarefas2, Menu.list_tarefas2);
		Menu.definirBtn (Menu.btn_adicionar_tarefa2, Menu.pct(width, 51), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtn);
		Menu.definirBtn (Menu.btn_remover_tarefa2,   Menu.pct(width, 62), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtn);
		
		Menu.definirLbl (Menu.lbl_alunos2,          Menu.pct(width, 74), Menu.pct(height,  9), Menu.pct(width, 22), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirBtn (Menu.btn_carregar2,        Menu.pct(width, 74), Menu.pct(height, 16), Menu.pct(width, 22), Menu.pct(height,  6), Menu.fonteBtn);
		Menu.definirList(Menu.panel_list_alunos2,   Menu.pct(width, 74), Menu.pct(height, 22), Menu.pct(width, 22), Menu.pct(height, 55), Menu.fonteLista, Menu.scroll_list_alunos2, Menu.list_alunos2);
		Menu.definirTxt (Menu.txt_alunos2,          Menu.pct(width, 74), Menu.pct(height, 77), Menu.pct(width, 22), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirBtn (Menu.btn_adicionar_aluno2, Menu.pct(width, 74), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtn);
		Menu.definirBtn (Menu.btn_remover_aluno2,   Menu.pct(width, 85), Menu.pct(height, 84), Menu.pct(width, 11), Menu.pct(height,  6), Menu.fonteBtn);
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
		//lists
		Menu.list_dia1.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			Database.selectAulas(Menu.listTurmas1, Menu.listInicio1, Menu.listFinal1, Menu.list_dia1.getSelectedValue());
		}});
		
		Menu.list_turmas1.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			Menu.list_inicio1.setSelectedIndex(Menu.list_turmas1.getSelectedIndex());
			Menu.list_final1.setSelectedIndex(Menu.list_turmas1.getSelectedIndex());
			
			Database.selectAlunosAulas(Menu.listAlunos1, Menu.list_turmas1.getSelectedValue(), Menu.list_dia1.getSelectedValue(), Menu.list_inicio1.getSelectedValue(), Menu.list_final1.getSelectedValue());
			if (Menu.list_turmas1.getSelectedIndex() >= 0){
					Menu.btn_adicionar_aluno1.setEnabled(true);
					Menu.btn_remover_aluno1.setEnabled(true);
			} else {
				Menu.btn_adicionar_aluno1.setEnabled(false);
				Menu.btn_remover_aluno1.setEnabled(false);
			}
		}});
		Menu.list_inicio1.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			Menu.list_turmas1.setSelectedIndex(Menu.list_inicio1.getSelectedIndex());
			Menu.list_final1.setSelectedIndex(Menu.list_inicio1.getSelectedIndex());
			
			Database.selectAlunosAulas(Menu.listAlunos1, Menu.list_turmas1.getSelectedValue(), Menu.list_dia1.getSelectedValue(), Menu.list_inicio1.getSelectedValue(), Menu.list_final1.getSelectedValue());
		}});
		Menu.list_final1.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			Menu.list_turmas1.setSelectedIndex(Menu.list_final1.getSelectedIndex());
			Menu.list_inicio1.setSelectedIndex(Menu.list_final1.getSelectedIndex());
			
			Database.selectAlunosAulas(Menu.listAlunos1, Menu.list_turmas1.getSelectedValue(), Menu.list_dia1.getSelectedValue(), Menu.list_inicio1.getSelectedValue(), Menu.list_final1.getSelectedValue());
		}});
		
		
		//btn_adicionar_aula1
		Menu.btn_adicionar_aula1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Adicionando aula"); 
				Database.insertAula(Menu.txt_turmas1.getText(), Menu.list_dia1.getSelectedValue(), Menu.txt_inicio1.getText(), Menu.txt_final1.getText());
				
				Database.selectAulas(Menu.listTurmas1, Menu.listInicio1, Menu.listFinal1, Menu.list_dia1.getSelectedValue());
				Database.selectAulas(Menu.listTurmas2, Menu.listInicio2, Menu.listFinal2, Menu.lbl_dia2.getText());
			}
		});
		//btn_remover_aula1
		Menu.btn_remover_aula1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Removendo aula");
				Database.deleteAula(Menu.list_turmas1.getSelectedValue(), Menu.list_dia1.getSelectedValue(), Menu.list_inicio1.getSelectedValue(), Menu.list_final1.getSelectedValue());
				
				Database.selectAulas(Menu.listTurmas1, Menu.listInicio1, Menu.listFinal1, Menu.list_dia1.getSelectedValue());
				Database.selectAulas(Menu.listTurmas2, Menu.listInicio2, Menu.listFinal2, Menu.lbl_dia2.getText());
			}
		});
		
		//btn_adicionar_aluno1
		Menu.btn_adicionar_aluno1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Adicionando aluno 1");
				Database.insertAlunoAula(Menu.list_turmas1.getSelectedValue(), Menu.list_dia1.getSelectedValue(), Menu.list_inicio1.getSelectedValue(), Menu.list_final1.getSelectedValue(), Menu.txt_alunos1.getText());
				
				Database.selectAlunosAulas(Menu.listAlunos1, Menu.list_turmas1.getSelectedValue(), Menu.list_dia1.getSelectedValue(), Menu.list_inicio1.getSelectedValue(), Menu.list_final1.getSelectedValue());
			}
		});
		//btn_remover_aluno1
		Menu.btn_remover_aluno1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Removendo aluno 1");
				Database.deleteAlunoAula(Menu.list_turmas1.getSelectedValue(), Menu.list_dia1.getSelectedValue(), Menu.list_inicio1.getSelectedValue(), Menu.list_final1.getSelectedValue(), Menu.list_alunos1.getSelectedValue());
				
				Database.selectAlunosAulas(Menu.listAlunos1, Menu.list_turmas1.getSelectedValue(), Menu.list_dia1.getSelectedValue(), Menu.list_inicio1.getSelectedValue(), Menu.list_final1.getSelectedValue());
			}	
		});
		
		
		//btn_adicionar_tarefa2
		Menu.btn_adicionar_tarefa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Adicionando tarefa");
				Database.insertTarefa(Menu.txt_tarefas2.getText(), Menu.lbl_data.getText(), formatador.format(Menu.datepicker_tarefa.getDate()));
				
				Database.selectTarefas(Menu.listTarefas2, formatador.format(Menu.datepicker_tarefa.getDate()));
			}
		});
		//btn_remover_tarefa2
		Menu.btn_remover_tarefa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Removendo tarefa");
				Database.deleteTarefa(Menu.txt_tarefas2.getText(), formatador.format(Menu.datepicker_tarefa.getDate()));
				
				Database.selectTarefas(Menu.listTarefas2, formatador.format(Menu.datepicker_tarefa.getDate()));
			}
		});
		
		
		Menu.list_tarefas2.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			Database.selectAlunosTarefas(Menu.listAlunos2, Menu.list_tarefas2.getSelectedValue(), formatador.format(Menu.datepicker_tarefa.getDate()));
			
			if (Menu.list_tarefas2.getSelectedIndex() >= 0){
					Menu.btn_adicionar_aluno2.setEnabled(true);
					Menu.btn_remover_aluno2.setEnabled(true);
			} else {
				Menu.btn_adicionar_aluno2.setEnabled(false);
				Menu.btn_remover_aluno2.setEnabled(false);
			}
		}});
		
		//btn_adicionar_aluno2
		Menu.btn_adicionar_aluno2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Adicionando aluno 2");
				Database.insertAlunoTarefa(Menu.list_tarefas2.getSelectedValue(), formatador.format(Menu.datepicker_tarefa.getDate()), Menu.txt_alunos2.getText());
				
				Database.selectAlunosTarefas(Menu.listAlunos2, Menu.list_tarefas2.getSelectedValue(), formatador.format(Menu.datepicker_tarefa.getDate()));
			}
		});
		//btn_remover_aluno2
		Menu.btn_remover_aluno2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Removendo aluno 2");
				Database.deleteAlunoTarefa(Menu.list_tarefas2.getSelectedValue(), formatador.format(Menu.datepicker_tarefa.getDate()), Menu.list_alunos2.getSelectedValue());
				
				Database.selectAlunosTarefas(Menu.listAlunos2, Menu.list_tarefas2.getSelectedValue(), formatador.format(Menu.datepicker_tarefa.getDate()));
			}	
		});
		
		//btn_carregar2
		Menu.btn_carregar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Carregando alunos");
				Database.carregarAlunosAulas(Menu.listAlunos2, Menu.list_turmas2.getSelectedValue(), Menu.lbl_dia2.getText(), Menu.list_inicio2.getSelectedValue(), Menu.list_final2.getSelectedValue(), Menu.list_tarefas2.getSelectedValue(), formatador.format(Menu.datepicker_tarefa.getDate()));
			}
		});
		
		Menu.datepicker_tarefa.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() { public void propertyChange(PropertyChangeEvent e) {
			if ("date".equals(e.getPropertyName())) {
				Menu.lbl_dia2.setText((new SimpleDateFormat("EEEE").format((Date) e.getNewValue())).substring(0,1).toUpperCase() + (new SimpleDateFormat("EEEE").format((Date) e.getNewValue())).substring(1));
				Database.selectAulas(Menu.listTurmas2, Menu.listInicio2, Menu.listFinal2, Menu.lbl_dia2.getText());
			
				Database.selectTarefas(Menu.listTarefas2, formatador.format(Menu.datepicker_tarefa.getDate()));
			}
		}});
		
		Menu.list_turmas2.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			Menu.list_inicio2.setSelectedIndex(Menu.list_turmas2.getSelectedIndex());
			Menu.list_final2.setSelectedIndex(Menu.list_turmas2.getSelectedIndex());
			
			if (Menu.list_turmas2.getSelectedIndex() >= 0){
				Menu.btn_carregar2.setEnabled(true);
			} else {
				Menu.btn_carregar2.setEnabled(false);
			}
		}});
		Menu.list_inicio2.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			Menu.list_turmas2.setSelectedIndex(Menu.list_inicio2.getSelectedIndex());
			Menu.list_final2.setSelectedIndex(Menu.list_inicio2.getSelectedIndex());
		}});
		Menu.list_final2.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			Menu.list_turmas2.setSelectedIndex(Menu.list_final2.getSelectedIndex());
			Menu.list_inicio2.setSelectedIndex(Menu.list_final2.getSelectedIndex());
		}});
	}
}