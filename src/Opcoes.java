import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class Opcoes {
	static void defineEstilo(String estilo) {
		try {
			UIManager.setLookAndFeel(estilo);
			SwingUtilities.updateComponentTreeUI(Menu.janela);
		} catch( Exception ex ) {
			System.err.println( "ERRO FATAL" );
			SwingUtilities.updateComponentTreeUI(Menu.janela);
		}
	}
	
	static void definirOpcoes(int width, int height){
		Menu.definirTBtn(Menu.tbtn_metal,    Menu.pct(width, 50), Menu.pct(height, 16), Menu.pct(width, 20), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTBtn(Menu.tbtn_windows,  Menu.pct(width, 50), Menu.pct(height, 28), Menu.pct(width, 20), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTBtn(Menu.tbtn_win_old,  Menu.pct(width, 50), Menu.pct(height, 40), Menu.pct(width, 20), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTBtn(Menu.tbtn_nimbus,   Menu.pct(width, 50), Menu.pct(height, 52), Menu.pct(width, 20), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTBtn(Menu.tbtn_motif,    Menu.pct(width, 50), Menu.pct(height, 64), Menu.pct(width, 20), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTBtn(Menu.tbtn_gtk,      Menu.pct(width, 50), Menu.pct(height, 76), Menu.pct(width, 20), Menu.pct(height,  8), Menu.fonteBtnTopo); Menu.tbtn_gtk.setEnabled(false);
		
		Menu.definirTBtn(Menu.tbtn_mac,      Menu.pct(width, 75), Menu.pct(height, 16), Menu.pct(width, 20), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTBtn(Menu.tbtn_d_mac,    Menu.pct(width, 75), Menu.pct(height, 28), Menu.pct(width, 20), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTBtn(Menu.tbtn_flatlaf,  Menu.pct(width, 75), Menu.pct(height, 40), Menu.pct(width, 20), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTBtn(Menu.tbtn_darklaf,  Menu.pct(width, 75), Menu.pct(height, 52), Menu.pct(width, 20), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTBtn(Menu.tbtn_intellij, Menu.pct(width, 75), Menu.pct(height, 64), Menu.pct(width, 20), Menu.pct(height,  8), Menu.fonteBtnTopo);
		Menu.definirTBtn(Menu.tbtn_int_dark, Menu.pct(width, 75), Menu.pct(height, 76), Menu.pct(width, 20), Menu.pct(height,  8), Menu.fonteBtnTopo);
	}
	
	static void desligaBotoes(JToggleButton tbtn) {
		Menu.tbtn_metal.setSelected(false);   Menu.tbtn_mac.setSelected(false);
		Menu.tbtn_windows.setSelected(false); Menu.tbtn_d_mac.setSelected(false);
		Menu.tbtn_win_old.setSelected(false); Menu.tbtn_flatlaf.setSelected(false);
		Menu.tbtn_nimbus.setSelected(false);  Menu.tbtn_darklaf.setSelected(false);
		Menu.tbtn_motif.setSelected(false);   Menu.tbtn_intellij.setSelected(false);
		Menu.tbtn_gtk.setSelected(false);     Menu.tbtn_int_dark.setSelected(false);
		tbtn.setSelected(true);
	}
	
	static void definirVisivel(boolean status){
		Menu.tbtn_metal.setVisible(status);   Menu.tbtn_mac.setVisible(status);
		Menu.tbtn_win_old.setVisible(status); Menu.tbtn_d_mac.setVisible(status);
		Menu.tbtn_windows.setVisible(status); Menu.tbtn_flatlaf.setVisible(status);
		Menu.tbtn_nimbus.setVisible(status);  Menu.tbtn_darklaf.setVisible(status);
		Menu.tbtn_motif.setVisible(status);   Menu.tbtn_intellij.setVisible(status);
		Menu.tbtn_gtk.setVisible(status);     Menu.tbtn_int_dark.setVisible(status);
	}
	
	static void definirEventos(){
		Menu.tbtn_metal.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			desligaBotoes(Menu.tbtn_metal);
			defineEstilo(UIManager.getCrossPlatformLookAndFeelClassName());
		}});
		Menu.tbtn_windows.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			desligaBotoes(Menu.tbtn_windows);
			defineEstilo("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}});
		Menu.tbtn_win_old.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			desligaBotoes(Menu.tbtn_win_old);
			defineEstilo("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		}});
		Menu.tbtn_nimbus.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			desligaBotoes(Menu.tbtn_nimbus);
			defineEstilo("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}});
		Menu.tbtn_motif.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			desligaBotoes(Menu.tbtn_motif);
			defineEstilo("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		}});
		Menu.tbtn_gtk.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			desligaBotoes(Menu.tbtn_gtk);
			defineEstilo("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		}});
		
		Menu.tbtn_mac.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			desligaBotoes(Menu.tbtn_mac);
			defineEstilo("com.formdev.flatlaf.themes.FlatMacLightLaf");
		}});
		Menu.tbtn_d_mac.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			desligaBotoes(Menu.tbtn_d_mac);
			defineEstilo("com.formdev.flatlaf.themes.FlatMacDarkLaf");
		}});
		Menu.tbtn_flatlaf.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			desligaBotoes(Menu.tbtn_flatlaf);
			defineEstilo("com.formdev.flatlaf.FlatLightLaf");
		}});
		Menu.tbtn_darklaf.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			desligaBotoes(Menu.tbtn_darklaf);
			defineEstilo("com.formdev.flatlaf.FlatDarkLaf");
		}});
		Menu.tbtn_intellij.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			desligaBotoes(Menu.tbtn_intellij);
			defineEstilo("com.formdev.flatlaf.FlatIntelliJLaf");
		}});
		Menu.tbtn_int_dark.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
			desligaBotoes(Menu.tbtn_int_dark);
			defineEstilo("com.formdev.flatlaf.FlatDarculaLaf");
		}});
	}
}