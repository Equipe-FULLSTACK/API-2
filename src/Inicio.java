import javax.swing.*;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import java.util.Date;
import java.text.SimpleDateFormat;

import java.awt.event.*;
import java.util.List;

import java.awt.Color;

public class Inicio {
	static void definirInicio(int width, int height){
		Menu.definirLbl    (Menu.lbl_aula_atual,                     Menu.pct(width, 2), Menu.pct(height,  9), Menu.pct(width, 58), Menu.pct(height, 10), Menu.fonteAulaAtual);
		Menu.definirLbl    (Menu.lbl_fim_aula,                       Menu.pct(width, 60), Menu.pct(height, 9), Menu.pct(width, 36), Menu.pct(height, 10), Menu.fonteAulaAtual);
		
		Menu.definirLbl    (Menu.lbl_tarefas_aula,                   Menu.pct(width,  0), Menu.pct(height, 18), Menu.pct(width, 20), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList   (Menu.panel_list_tarefas,                 Menu.pct(width,  2), Menu.pct(height, 26), Menu.pct(width, 17), Menu.pct(height, 30), Menu.fonteLista, Menu.scroll_list_tarefas, Menu.list_tarefas);
		Menu.definirCombo  (Menu.combo_atualizar_entrega,            Menu.pct(width,  2), Menu.pct(height, 58), Menu.pct(width, 13), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirTxt    (Menu.txt_atualizar_nota,                 Menu.pct(width, 15), Menu.pct(height, 58), Menu.pct(width,  4), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirTxtArea(Menu.panel_txtarea_atualizar_comentario, Menu.pct(width,  2), Menu.pct(height, 63), Menu.pct(width, 17), Menu.pct(height, 21), Menu.fonteLista, Menu.scroll_txtarea_atualizar_comentario, Menu.txtarea_atualizar_comentario);
		Menu.definirBtn    (Menu.btn_atualizar,                      Menu.pct(width,  2), Menu.pct(height, 84), Menu.pct(width, 17), Menu.pct(height,  6), Menu.fonteBtn);
		
		Menu.definirLbl    (Menu.lbl_alunos,                         Menu.pct(width, 20), Menu.pct(height, 18), Menu.pct(width, 17), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList   (Menu.panel_list_alunos,                  Menu.pct(width, 20), Menu.pct(height, 26), Menu.pct(width, 17), Menu.pct(height, 64), Menu.fonteLista, Menu.scroll_list_alunos, Menu.list_alunos);
		
		Menu.definirLbl    (Menu.lbl_entregas,                       Menu.pct(width, 38), Menu.pct(height, 18), Menu.pct(width,  9), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList   (Menu.panel_list_entregas,                Menu.pct(width, 38), Menu.pct(height, 26), Menu.pct(width,  9), Menu.pct(height, 64), Menu.fonteLista, Menu.scroll_list_entregas, Menu.list_entregas);
		Menu.definirLbl    (Menu.lbl_notas,                          Menu.pct(width, 47), Menu.pct(height, 18), Menu.pct(width,  5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList   (Menu.panel_list_notas,                   Menu.pct(width, 47), Menu.pct(height, 26), Menu.pct(width,  5), Menu.pct(height, 64), Menu.fonteLista, Menu.scroll_list_notas, Menu.list_notas);
		Menu.definirLbl    (Menu.lbl_comentarios,                    Menu.pct(width, 52), Menu.pct(height, 18), Menu.pct(width, 15), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList   (Menu.panel_list_comentarios,             Menu.pct(width, 52), Menu.pct(height, 26), Menu.pct(width, 15), Menu.pct(height, 64), Menu.fonteLista, Menu.scroll_list_comentarios, Menu.list_comentarios);
		
		Menu.definirLbl    (Menu.lbl_aulas_dia,                      Menu.pct(width, 68), Menu.pct(height, 18), Menu.pct(width, 17), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl    (Menu.lbl_horario,                        Menu.pct(width, 87), Menu.pct(height, 18), Menu.pct(width, 10), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirDate   (Menu.datepicker_inicio,                  Menu.pct(width, 68), Menu.pct(height, 26), Menu.pct(width, 17), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirLbl    (Menu.lbl_dia_semana,                     Menu.pct(width, 83), Menu.pct(height, 24.5), Menu.pct(width, 16.5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList   (Menu.panel_list_aulas,                   Menu.pct(width, 68), Menu.pct(height, 32), Menu.pct(width, 19), Menu.pct(height, 58), Menu.fonteLista, Menu.scroll_list_aulas, Menu.list_aulas);
		Menu.definirList   (Menu.panel_list_horario_inicio,          Menu.pct(width, 87), Menu.pct(height, 32), Menu.pct(width,  5), Menu.pct(height, 58), Menu.fonteLista, Menu.scroll_list_horario_inicio, Menu.list_horario_inicio);
		Menu.definirList   (Menu.panel_list_horario_final,           Menu.pct(width, 92), Menu.pct(height, 32), Menu.pct(width,  5), Menu.pct(height, 58), Menu.fonteLista, Menu.scroll_list_horario_final, Menu.list_horario_final);
	}
	
	static void definirVisivel(boolean status){
		Menu.lbl_aula_atual.setVisible(status);
		Menu.lbl_fim_aula.setVisible(status);
		Menu.lbl_tarefas_aula.setVisible(status);
		Menu.lbl_alunos.setVisible(status);
		Menu.lbl_entregas.setVisible(status);
		Menu.lbl_notas.setVisible(status);
		Menu.lbl_comentarios.setVisible(status);
		Menu.lbl_aulas_dia.setVisible(status);
		Menu.lbl_horario.setVisible(status);
		Menu.lbl_dia_semana.setVisible(status);
		Menu.datepicker_inicio.setVisible(status);
		Menu.panel_list_tarefas.setVisible(status);
		Menu.panel_list_alunos.setVisible(status);
		Menu.panel_list_entregas.setVisible(status);
		Menu.panel_list_notas.setVisible(status);
		Menu.panel_list_comentarios.setVisible(status);
		Menu.panel_list_aulas.setVisible(status);
		Menu.panel_list_horario_inicio.setVisible(status);
		Menu.panel_list_horario_final.setVisible(status);
		Menu.combo_atualizar_entrega.setVisible(status);
		Menu.txt_atualizar_nota.setVisible(status);
		Menu.panel_txtarea_atualizar_comentario.setVisible(status);
		Menu.btn_atualizar.setVisible(status);
	}
	
	static void syncAlunosTarefas(int i){
		Menu.list_alunos.setSelectedIndex(i);
		Menu.list_entregas.setSelectedIndex(i);
		Menu.list_notas.setSelectedIndex(i);
		Menu.list_comentarios.setSelectedIndex(i);
		
		Menu.combo_atualizar_entrega.setSelectedItem(Menu.list_entregas.getSelectedValue());
		Menu.txt_atualizar_nota.setText(Menu.list_notas.getSelectedValue());
		Menu.txtarea_atualizar_comentario.setText(Menu.list_comentarios.getSelectedValue());
	}
	
	static void syncAulasHorario(int i){
		Menu.list_aulas.setSelectedIndex(i);
		Menu.list_horario_inicio.setSelectedIndex(i);
		Menu.list_horario_final.setSelectedIndex(i);
	}
	
	static void definirEventos() {
		//btn_atualizar
		Menu.btn_atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Atualizando");
				if (Menu.combo_atualizar_entrega.getSelectedIndex() == 0){
					Database.updateAlunosTarefas(Menu.lbl_data.getText(), Menu.txt_atualizar_nota.getText(), Menu.txtarea_atualizar_comentario.getText(), Menu.list_tarefas.getSelectedValue(), AulasTarefas.formatador.format(Menu.datepicker_inicio.getDate()), Menu.list_alunos.getSelectedValue());
				} else {
					Database.updateAlunosTarefas("", Menu.txt_atualizar_nota.getText(), Menu.txtarea_atualizar_comentario.getText(), Menu.list_tarefas.getSelectedValue(), AulasTarefas.formatador.format(Menu.datepicker_inicio.getDate()), Menu.list_alunos.getSelectedValue());
				}
				Database.selectAlunosTarefasFull(Menu.listTarefas, Menu.listAlunos, Menu.listEntregas, Menu.listNotas, Menu.listComentarios, Menu.list_tarefas.getSelectedValue(), AulasTarefas.formatador.format(Menu.datepicker_inicio.getDate()));
			}
		});
		
		//lists
		Menu.list_tarefas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Database.selectAlunosTarefasFull(Menu.listTarefas, Menu.listAlunos, Menu.listEntregas, Menu.listNotas, Menu.listComentarios, Menu.list_tarefas.getSelectedValue(), AulasTarefas.formatador.format(Menu.datepicker_inicio.getDate()));
			
			}
		});
		
		Menu.list_alunos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Menu.list_entregas.setSelectedIndex(Menu.list_alunos.getSelectedIndex());
				Menu.list_notas.setSelectedIndex(Menu.list_alunos.getSelectedIndex());
				Menu.list_comentarios.setSelectedIndex(Menu.list_alunos.getSelectedIndex());
				
				System.out.println(Menu.list_entregas.getSelectedValue());
				if (Menu.list_entregas.getSelectedValue() != "Nao entregue"){
					Menu.combo_atualizar_entrega.setSelectedIndex(0);
				} else {
					Menu.combo_atualizar_entrega.setSelectedIndex(1);
				}
				Menu.txt_atualizar_nota.setText(Menu.list_notas.getSelectedValue());
				Menu.txtarea_atualizar_comentario.setText(Menu.list_comentarios.getSelectedValue());
				
				if (Menu.list_alunos.getSelectedIndex() >= 0){
					Menu.combo_atualizar_entrega.setEnabled(true);
					Menu.txt_atualizar_nota.setEnabled(true);
					Menu.txtarea_atualizar_comentario.setEnabled(true);
					Menu.btn_atualizar.setEnabled(true);
				} else {
					Menu.combo_atualizar_entrega.setEnabled(false);
					Menu.txt_atualizar_nota.setEnabled(false);
					Menu.txtarea_atualizar_comentario.setEnabled(false);
					Menu.btn_atualizar.setEnabled(false);
				}
				
				
			}
		});
		Menu.list_entregas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Menu.list_alunos.setSelectedIndex(Menu.list_entregas.getSelectedIndex());
				Menu.list_notas.setSelectedIndex(Menu.list_entregas.getSelectedIndex());
				Menu.list_comentarios.setSelectedIndex(Menu.list_entregas.getSelectedIndex());
			}
		});
		Menu.list_notas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Menu.list_entregas.setSelectedIndex(Menu.list_notas.getSelectedIndex());
				Menu.list_alunos.setSelectedIndex(Menu.list_notas.getSelectedIndex());
				Menu.list_comentarios.setSelectedIndex(Menu.list_notas.getSelectedIndex());
			}
		});
		Menu.list_comentarios.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Menu.list_entregas.setSelectedIndex(Menu.list_comentarios.getSelectedIndex());
				Menu.list_notas.setSelectedIndex(Menu.list_comentarios.getSelectedIndex());
				Menu.list_alunos.setSelectedIndex(Menu.list_comentarios.getSelectedIndex());
			}
		});
		
		
		//list_alunostarefas
		Menu.list_alunos.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			syncAlunosTarefas(Menu.list_alunos.getSelectedIndex());
		}});
		Menu.list_entregas.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			syncAlunosTarefas(Menu.list_entregas.getSelectedIndex());
		}});
		Menu.list_notas.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			syncAlunosTarefas(Menu.list_notas.getSelectedIndex());
		}});
		Menu.list_comentarios.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			syncAlunosTarefas(Menu.list_comentarios.getSelectedIndex());
		}});
		
		//list_aulashorario
		Menu.list_aulas.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			syncAulasHorario(Menu.list_aulas.getSelectedIndex());
		}});
		Menu.list_horario_inicio.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			syncAulasHorario(Menu.list_horario_inicio.getSelectedIndex());
		}});
		Menu.list_horario_final.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			syncAulasHorario(Menu.list_horario_final.getSelectedIndex());
		}});
		
		Menu.datepicker_inicio.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() { public void propertyChange(PropertyChangeEvent e) {
			if ("date".equals(e.getPropertyName())) {
				Menu.lbl_dia_semana.setText((new SimpleDateFormat("EEEE").format((Date) e.getNewValue())).substring(0,1).toUpperCase() + (new SimpleDateFormat("EEEE").format((Date) e.getNewValue())).substring(1));
				
				Database.selectAulas(Menu.listAulas, Menu.listHorarioInicio, Menu.listHorarioFinal, Menu.lbl_dia_semana.getText());
			
				Database.selectTarefas(Menu.listTarefas, AulasTarefas.formatador.format(Menu.datepicker_inicio.getDate()));
			}
		}});
		
	}
}