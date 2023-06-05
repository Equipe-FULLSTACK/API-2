import java.awt.event.*;
import java.awt.BorderLayout;

import java.awt.Color;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.DefaultListModel;

public class Estatisticas {
	static void definirEstatisticas(int width, int height){
		Menu.definirLbl (Menu.lbl_dia3,             Menu.pct(width,  2), Menu.pct(height,  9), Menu.pct(width, 18), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_turmas3,          Menu.pct(width,  2), Menu.pct(height, 40), Menu.pct(width,  8), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_inicio3,          Menu.pct(width, 10), Menu.pct(height, 40), Menu.pct(width,  5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_final3,           Menu.pct(width, 15), Menu.pct(height, 40), Menu.pct(width,  5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList(Menu.panel_list_dia3,      Menu.pct(width,  2), Menu.pct(height, 16), Menu.pct(width, 18), Menu.pct(height, 23), Menu.fonteLista, Menu.scroll_list_dia3, Menu.list_dia3);
		Menu.definirList(Menu.panel_list_turmas3,   Menu.pct(width,  2), Menu.pct(height, 47), Menu.pct(width,  8), Menu.pct(height, 43), Menu.fonteLista, Menu.scroll_list_turmas3, Menu.list_turmas3);
		Menu.definirList(Menu.panel_list_inicio3,   Menu.pct(width, 10), Menu.pct(height, 47), Menu.pct(width,  5), Menu.pct(height, 43), Menu.fonteLista, Menu.scroll_list_inicio3, Menu.list_inicio3);
		Menu.definirList(Menu.panel_list_final3,    Menu.pct(width, 15), Menu.pct(height, 47), Menu.pct(width,  5), Menu.pct(height, 43), Menu.fonteLista, Menu.scroll_list_final3, Menu.list_final3);
		
		Menu.definirLbl (Menu.lbl_tarefas3,         Menu.pct(width, 22), Menu.pct(height,  9), Menu.pct(width, 11), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_datas3,           Menu.pct(width, 33), Menu.pct(height,  9), Menu.pct(width,  8), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList(Menu.panel_list_tarefas3,  Menu.pct(width, 22), Menu.pct(height, 16), Menu.pct(width, 11), Menu.pct(height, 74), Menu.fonteLista, Menu.scroll_list_tarefas3, Menu.list_tarefas3);
		Menu.definirList(Menu.panel_list_datas3,    Menu.pct(width, 33), Menu.pct(height, 16), Menu.pct(width,  8), Menu.pct(height, 74), Menu.fonteLista, Menu.scroll_list_datas3, Menu.list_datas3);
		
		Menu.definirPanel(Menu.panel_divisao2,      Menu.pct(width, 42.5), Menu.pct(height, 7.75), 1, Menu.pct(height,  100));
		Menu.panel_divisao2.setOpaque(true); Menu.panel_divisao2.setBackground(Color.GRAY);
		
		Menu.definirLbl (Menu.lbl_limiar3,          Menu.pct(width, 44), Menu.pct(height,  9), Menu.pct(width,  5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTxt (Menu.txt_limiar3,          Menu.pct(width, 50), Menu.pct(height, 10.75), Menu.pct(width, 8), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirLbl (Menu.lbl_media3,           Menu.pct(width, 59), Menu.pct(height,  9), Menu.pct(width, 30), Menu.pct(height,  8), Menu.fonteBtnTopo);
		
		Menu.definirGrafico(Menu.panel_chart,       Menu.pct(width, 44), Menu.pct(height, 17), Menu.pct(width, 53), Menu.pct(height, 73), Menu.aprovados, Menu.reprovados, Menu.nentregues, Menu.natribuidos);
		//Menu.panel_chart.setOpaque(true); Menu.panel_chart.setBackground(Color.GRAY); Menu.panel_chart.setLayout(new java.awt.BorderLayout());
	}
	static void definirVisivel(boolean status){
		Menu.lbl_dia3.setVisible(status);
		Menu.lbl_turmas3.setVisible(status);
		Menu.lbl_inicio3.setVisible(status);
		Menu.lbl_final3.setVisible(status);
		Menu.lbl_tarefas3.setVisible(status);
		Menu.lbl_datas3.setVisible(status);
		Menu.lbl_limiar3.setVisible(status);
		Menu.lbl_media3.setVisible(status);
		
		Menu.panel_list_dia3.setVisible(status);
		Menu.panel_list_turmas3.setVisible(status);
		Menu.panel_list_inicio3.setVisible(status);
		Menu.panel_list_final3.setVisible(status);
		Menu.panel_list_tarefas3.setVisible(status);
		Menu.panel_list_datas3.setVisible(status);
		
		Menu.txt_limiar3.setVisible(status);
		Menu.panel_divisao2.setVisible(status);
		Menu.panel_chart.setVisible(status);
	}
	static void definirEventos() {
		Menu.txt_limiar3.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				definirListasGraficos();
			}
			 public void removeUpdate(DocumentEvent e) {
				definirListasGraficos();
			}
			public void insertUpdate(DocumentEvent e) {
				definirListasGraficos();
			}
		});
		
		Menu.list_dia3.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			Database.selectAulas(Menu.listTurmas3, Menu.listInicio3, Menu.listFinal3, Menu.list_dia3.getSelectedValue());
			
			Menu.list_turmas3.clearSelection(); Menu.list_inicio3.clearSelection();  Menu.list_final3.clearSelection();
			Menu.list_tarefas3.clearSelection(); Menu.list_datas3.clearSelection();
			
			definirListasGraficos();
		}});
		
		Menu.list_turmas3.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			Menu.list_inicio3.setSelectedIndex(Menu.list_turmas3.getSelectedIndex());
			Menu.list_final3.setSelectedIndex(Menu.list_turmas3.getSelectedIndex());
			
			Database.selectAlunosAulas(Menu.listAlunos3, Menu.list_turmas3.getSelectedValue(), Menu.list_dia3.getSelectedValue(), Menu.list_inicio3.getSelectedValue(), Menu.list_final1.getSelectedValue());
		}});
		Menu.list_inicio3.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			Menu.list_turmas3.setSelectedIndex(Menu.list_inicio3.getSelectedIndex());
			Menu.list_final3.setSelectedIndex(Menu.list_inicio3.getSelectedIndex());
			
			Database.selectAlunosAulas(Menu.listAlunos3, Menu.list_turmas3.getSelectedValue(), Menu.list_dia3.getSelectedValue(), Menu.list_inicio3.getSelectedValue(), Menu.list_final3.getSelectedValue());
		}});
		
		Menu.list_final3.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			definirListasGraficos();
		}});
		Menu.list_tarefas3.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			Menu.list_datas3.setSelectedIndex(Menu.list_tarefas3.getSelectedIndex());
			definirListasGraficos();
		}});
		Menu.list_datas3.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) {
			Menu.list_tarefas3.setSelectedIndex(Menu.list_datas3.getSelectedIndex());
			definirListasGraficos();
		}});
	}
	
	static void definirListasGraficos() {
		Menu.list_turmas3.setSelectedIndex(Menu.list_final3.getSelectedIndex());
		Menu.list_inicio3.setSelectedIndex(Menu.list_final3.getSelectedIndex());
		
		
		Database.selectAlunosAulas(Menu.listAlunos3, Menu.list_turmas3.getSelectedValue(), Menu.list_dia3.getSelectedValue(), Menu.list_inicio3.getSelectedValue(), Menu.list_final3.getSelectedValue());
		/*for (int z = 0; z < Menu.listAlunos3.getSize(); z++){
			System.out.println(Menu.listAlunos3.getElementAt(z));
		}
		System.out.println(" ");*/
		Database.selectAlunosTarefasFull(Menu.listTarefas4, Menu.listAlunos4, Menu.listEntregas4, Menu.listNotas4, Menu.listComentarios4, Menu.list_tarefas3.getSelectedValue(), Menu.list_datas3.getSelectedValue());
		/*for (int z = 0; z < Menu.listAlunos4.getSize(); z++){
			System.out.println(Menu.listAlunos4.getElementAt(z));
		}
		System.out.println(" ");*/
		Menu.listMutual = selectMutual(Menu.listAlunos3, Menu.listAlunos4);
		
		int total = Menu.listMutual.getSize();
		double nota_total = 0; Menu.lbl_media3.setText("Media: ");
		Menu.natribuidos = Menu.listAlunos3.getSize() - total;
		Menu.aprovados = 0; Menu.reprovados = 0; Menu.nentregues = 0;
		for (int z = 0; z < Menu.listMutual.getSize(); z++){
			//System.out.println(Menu.listMutual.getElementAt(z));
			if (Database.selectAprovado(Menu.listMutual.getElementAt(z), Double.valueOf(Menu.txt_limiar3.getText()), Menu.list_tarefas3.getSelectedValue(), Menu.list_datas3.getSelectedValue()) > 0) {
				Menu.aprovados++;
				nota_total += Database.selectNota(Menu.listMutual.getElementAt(z), Menu.list_tarefas3.getSelectedValue(), Menu.list_datas3.getSelectedValue());
			} else if (Database.selectReprovado(Menu.listMutual.getElementAt(z), Double.valueOf(Menu.txt_limiar3.getText()), Menu.list_tarefas3.getSelectedValue(), Menu.list_datas3.getSelectedValue()) > 0){
				Menu.reprovados++;
				nota_total += Database.selectNota(Menu.listMutual.getElementAt(z), Menu.list_tarefas3.getSelectedValue(), Menu.list_datas3.getSelectedValue());
			} else { //if (Database.selectNaoEntregue(Menu.listMutual.getElementAt(z), Menu.list_tarefas3.getSelectedValue(), Menu.list_datas3.getSelectedValue()) > 0)
				Menu.nentregues++;
			}
			
			Menu.lbl_media3.setText("Media: " + nota_total/z);
		}
		System.out.println("===");
		/*
		int total = Database.selectTotalTarefas(Menu.list_tarefas3.getSelectedValue(), Menu.list_datas3.getSelectedValue());
		Menu.aprovados = Database.selectAprovados(6.0, Menu.list_tarefas3.getSelectedValue(), Menu.list_datas3.getSelectedValue());
		Menu.reprovados = Database.selectReprovados(6.0, Menu.list_tarefas3.getSelectedValue(), Menu.list_datas3.getSelectedValue());
		Menu.nentregues = Database.selectNaoEntregues(Menu.list_tarefas3.getSelectedValue(), Menu.list_datas3.getSelectedValue());
		Menu.natribuidos = Database.selectTotalAulas(Menu.list_turmas3.getSelectedValue(), Menu.list_dia3.getSelectedValue()) - total;
		*/
		
		int height = Menu.janela.getBounds().getSize().height; int width = Menu.janela.getBounds().getSize().width;
		Menu.definirGrafico(Menu.panel_chart,       Menu.pct(width, 44), Menu.pct(height, 17), Menu.pct(width, 53), Menu.pct(height, 73), Menu.aprovados, Menu.reprovados, Menu.nentregues, Menu.natribuidos);
		
	}
	
	static DefaultListModel<String> selectMutual(DefaultListModel<String> list1, DefaultListModel<String> list2) {
		DefaultListModel<String> list = new DefaultListModel<>();
		for (int x = 0; x < list1.getSize(); x++){
			for (int y = 0; y < list2.getSize(); y++){
				if (list1.getElementAt(x) == list2.getElementAt(y)){
					list.addElement(list1.getElementAt(x));
				}
			}
		}
		return list;
	}
}