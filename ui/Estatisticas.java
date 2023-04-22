import java.awt.event.*;

import java.awt.Color;

public class Estatisticas {
	static void definirEstatisticas(int width, int height){
		Menu.definirLbl (Menu.lbl_dia3,             Menu.pct(width,  2), Menu.pct(height,  9), Menu.pct(width, 22), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_turmas3,          Menu.pct(width,  2), Menu.pct(height, 40), Menu.pct(width, 12), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_inicio3,          Menu.pct(width, 14), Menu.pct(height, 40), Menu.pct(width,  5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_final3,           Menu.pct(width, 19), Menu.pct(height, 40), Menu.pct(width,  5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList(Menu.panel_list_dia3,      Menu.pct(width,  2), Menu.pct(height, 16), Menu.pct(width, 22), Menu.pct(height, 23), Menu.fonteLista, Menu.scroll_list_dia3, Menu.list_dia3);
		Menu.definirList(Menu.panel_list_turmas3,   Menu.pct(width,  2), Menu.pct(height, 47), Menu.pct(width, 12), Menu.pct(height, 43), Menu.fonteLista, Menu.scroll_list_turmas3, Menu.list_turmas3);
		Menu.definirList(Menu.panel_list_inicio3,   Menu.pct(width, 14), Menu.pct(height, 47), Menu.pct(width,  5), Menu.pct(height, 43), Menu.fonteLista, Menu.scroll_list_inicio3, Menu.list_inicio3);
		Menu.definirList(Menu.panel_list_final3,    Menu.pct(width, 19), Menu.pct(height, 47), Menu.pct(width,  5), Menu.pct(height, 43), Menu.fonteLista, Menu.scroll_list_final3, Menu.list_final3);
		
		Menu.definirLbl (Menu.lbl_tarefas3,         Menu.pct(width, 26), Menu.pct(height,  9), Menu.pct(width, 22), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirList(Menu.panel_list_tarefas3,  Menu.pct(width, 26), Menu.pct(height, 16), Menu.pct(width, 22), Menu.pct(height, 74), Menu.fonteLista, Menu.scroll_list_tarefas3, Menu.list_tarefas3);
		
		Menu.definirPanel(Menu.panel_divisao2,      Menu.pct(width, 49.5), Menu.pct(height, 7.75), 1, Menu.pct(height,  100));
		Menu.panel_divisao2.setOpaque(true); Menu.panel_divisao2.setBackground(Color.GRAY);
		
		Menu.definirLbl (Menu.lbl_limiar3,          Menu.pct(width, 51), Menu.pct(height,  9), Menu.pct(width,  5), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTxt (Menu.txt_limiar3,          Menu.pct(width, 57), Menu.pct(height, 10.75), Menu.pct(width, 8), Menu.pct(height,  5), Menu.fonteLista);
		Menu.definirLbl (Menu.lbl_media3,           Menu.pct(width, 66), Menu.pct(height,  9), Menu.pct(width, 30), Menu.pct(height,  8), Menu.fonteBtnTopo);
	}
	static void definirVisivel(boolean status){
		Menu.lbl_dia3.setVisible(status);
		Menu.lbl_turmas3.setVisible(status);
		Menu.lbl_inicio3.setVisible(status);
		Menu.lbl_final3.setVisible(status);
		Menu.lbl_tarefas3.setVisible(status);
		Menu.lbl_limiar3.setVisible(status);
		Menu.lbl_media3.setVisible(status);
		
		Menu.panel_list_dia3.setVisible(status);
		Menu.panel_list_turmas3.setVisible(status);
		Menu.panel_list_inicio3.setVisible(status);
		Menu.panel_list_final3.setVisible(status);
		Menu.panel_list_tarefas3.setVisible(status);
		
		Menu.txt_limiar3.setVisible(status);
		Menu.panel_divisao2.setVisible(status);
	}
	static void definirEventos() {
	}
}