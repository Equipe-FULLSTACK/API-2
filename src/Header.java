import java.awt.event.*;

public class Header {
	static void definirHeader(int width, int height){
		//HEADER
		Menu.definirTBtn(Menu.tbtn_inicio,       Menu.pct(width,  0), 0, Menu.pct(width, 15), Menu.pct(height, 8), Menu.fonteBtnTopo);
		Menu.definirTBtn(Menu.tbtn_aulastarefas, Menu.pct(width, 15), 0, Menu.pct(width, 20), Menu.pct(height, 8), Menu.fonteBtnTopo);
		Menu.definirTBtn(Menu.tbtn_estatisticas, Menu.pct(width, 35), 0, Menu.pct(width, 15), Menu.pct(height, 8), Menu.fonteBtnTopo);
		Menu.definirTBtn(Menu.tbtn_opcoes,       Menu.pct(width, 50), 0, Menu.pct(width, 15), Menu.pct(height, 8), Menu.fonteBtnTopo);
		
		Menu.definirLbl (Menu.lbl_dia,           Menu.pct(width, 66), 0, Menu.pct(width, 14), Menu.pct(height, 8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_data,          Menu.pct(width, 76), 0, Menu.pct(width, 12), Menu.pct(height, 8), Menu.fonteBtnTopo);
		Menu.definirLbl (Menu.lbl_hora,          Menu.pct(width, 88), 0, Menu.pct(width, 10), Menu.pct(height, 8), Menu.fonteBtnTopo);
	}
	
	static void definirEventos(Inicio inicio, AulasTarefas aulastarefas, Estatisticas estatisticas, Opcoes opcoes){
		Menu.tbtn_inicio.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				Menu.tbtn_inicio.setSelected(true); Menu.tbtn_aulastarefas.setSelected(false); Menu.tbtn_estatisticas.setSelected(false); Menu.tbtn_opcoes.setSelected(false);
				inicio.definirVisivel(true); aulastarefas.definirVisivel(false); estatisticas.definirVisivel(false); opcoes.definirVisivel(false);
			}  
		});
		Menu.tbtn_aulastarefas.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				Menu.tbtn_inicio.setSelected(false); Menu.tbtn_aulastarefas.setSelected(true); Menu.tbtn_estatisticas.setSelected(false); Menu.tbtn_opcoes.setSelected(false);
				inicio.definirVisivel(false); aulastarefas.definirVisivel(true); estatisticas.definirVisivel(false); opcoes.definirVisivel(false);
			}  
		});
		Menu.tbtn_estatisticas.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				Menu.tbtn_inicio.setSelected(false); Menu.tbtn_aulastarefas.setSelected(false); Menu.tbtn_estatisticas.setSelected(true); Menu.tbtn_opcoes.setSelected(false);
				inicio.definirVisivel(false); aulastarefas.definirVisivel(false); estatisticas.definirVisivel(true); opcoes.definirVisivel(false);
				
				Database.selectTodasTarefas(Menu.listTarefas3, Menu.listDatas3);
			}  
		});
		Menu.tbtn_opcoes.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				Menu.tbtn_inicio.setSelected(false); Menu.tbtn_aulastarefas.setSelected(false); Menu.tbtn_estatisticas.setSelected(false); Menu.tbtn_opcoes.setSelected(true);
				inicio.definirVisivel(false); aulastarefas.definirVisivel(false); estatisticas.definirVisivel(false); opcoes.definirVisivel(true);
			}  
		});
	}
}