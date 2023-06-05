import javax.swing.*;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.text.SimpleDateFormat;

import java.awt.BorderLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.labels.PieSectionLabelGenerator;  
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;  
import org.jfree.chart.plot.PiePlot;
import java.text.DecimalFormat;


public class Menu {
	//javac -d ./api/ -cp ".;jcalendar-1.4.jar;flatlaf-3.0.jar;jcommon-1.0.0.jar;jfreechart-1.0.1.jar;h2-2.1.214.jar" Menu.java
	//java -cp ".;jcalendar-1.4.jar;flatlaf-3.0.jar;jcommon-1.0.0.jar;jfreechart-1.0.1.jar;h2-2.1.214.jar;api" Menu
	//java -jar h2-2.1.214.jar
	
	//janela
	static JFrame janela = new JFrame();
	static int width = 1200; static int height = 675;
	static int aulaatual = -1;
	static int aulaatualantiga = -2;
	
	//objetos
	static Header header = new Header();
	static Inicio inicio = new Inicio();
	static AulasTarefas aulastarefas = new AulasTarefas();
	static Estatisticas estatisticas = new Estatisticas();
	static Opcoes opcoes = new Opcoes();
	static Database database = new Database();
	
	//data
	static DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	static DateTimeFormatter horaFormato = DateTimeFormatter.ofPattern("HH:mm:ss");
	static DateTimeFormatter horarioFormato = DateTimeFormatter.ofPattern("HH:mm");
	static DateTimeFormatter diaFormato = DateTimeFormatter.ofPattern("EEEE");
	static LocalDateTime dataAtual = LocalDateTime.now();
	
	//calcula porcentagem p do numero n
	static int pct(double n, double p) {
		return (int)((n/100)*p);
	}
	
	//fontes
	static Font fonteAulaAtual = new Font("Arial", Font.PLAIN, pct((int)(((double)width+((double)height)*0.5625)/2), 3.5));
	static Font fonteBtnTopo = new Font("Arial", Font.PLAIN, pct((int)(((double)width+((double)height)*0.5625)/2), 2.75));
	static Font fonteBtn = new Font("Arial", Font.PLAIN, pct((int)(((double)width+((double)height)*0.5625)/2), 2.5));
	static Font fonteLista = new Font("Arial", Font.PLAIN, pct((int)(((double)width+((double)height)*0.5625)/2), 2));
	
	//HEADER
	static JToggleButton tbtn_inicio = new JToggleButton("Inicio");
	static JToggleButton tbtn_aulastarefas = new JToggleButton("Aulas / Tarefas");
	static JToggleButton tbtn_estatisticas = new JToggleButton("Estatisticas");
	static JToggleButton tbtn_opcoes = new JToggleButton("Opcoes");
	
	static JLabel lbl_dia = new JLabel(dataAtual.format(diaFormato));
	static JLabel lbl_data = new JLabel(dataAtual.format(dataFormato), SwingConstants.CENTER);
	static JLabel lbl_hora = new JLabel(dataAtual.format(horaFormato), SwingConstants.CENTER);
	
	//INICIO
	static JLabel lbl_aula_atual = new JLabel("");
	static JLabel lbl_fim_aula = new JLabel("", SwingConstants.RIGHT);
	
	//labels
	static JLabel lbl_tarefas_aula = new JLabel("Tarefas do Dia", SwingConstants.CENTER);
	static JLabel lbl_alunos = new JLabel("Aluno", SwingConstants.CENTER);
	static JLabel lbl_entregas = new JLabel("Entrega", SwingConstants.CENTER);
	static JLabel lbl_notas = new JLabel("Nota", SwingConstants.CENTER);
	static JLabel lbl_comentarios = new JLabel("Comentarios", SwingConstants.CENTER);
	static JLabel lbl_aulas_dia = new JLabel("Aulas do dia", SwingConstants.CENTER);
	static JLabel lbl_horario = new JLabel("Horario", SwingConstants.CENTER);
	static JLabel lbl_dia_semana = new JLabel("Quinta-feira", SwingConstants.CENTER);
	
	//textfields, comboboxes
	static String[] comboAtualizarEntrega = {"Entregue", "Nao Entregue"}; static JComboBox<String> combo_atualizar_entrega = new JComboBox<>(comboAtualizarEntrega);
	static JTextField txt_atualizar_nota = new JTextField("");
	
	//textarea
	static JPanel panel_txtarea_atualizar_comentario = new JPanel(new BorderLayout());
	static JTextArea txtarea_atualizar_comentario = new JTextArea("");
	static JScrollPane scroll_txtarea_atualizar_comentario = new JScrollPane(txtarea_atualizar_comentario, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//listboxes
	static JPanel panel_list_tarefas = new JPanel(new BorderLayout());
	static DefaultListModel<String> listTarefas = new DefaultListModel<>();
	static JList<String> list_tarefas = new JList<>(listTarefas);
	static JScrollPane scroll_list_tarefas = new JScrollPane(list_tarefas);
	
	static JPanel panel_list_alunos = new JPanel(new BorderLayout());
	static DefaultListModel<String> listAlunos = new DefaultListModel<>();
	static JList<String> list_alunos = new JList<>(listAlunos);
	static JScrollPane scroll_list_alunos = new JScrollPane(list_alunos);
	
	static JPanel panel_list_entregas = new JPanel(new BorderLayout());
	static DefaultListModel<String> listEntregas = new DefaultListModel<>();
	static JList<String> list_entregas = new JList<>(listEntregas);
	static JScrollPane scroll_list_entregas = new JScrollPane(list_entregas);
	
	static JPanel panel_list_notas = new JPanel(new BorderLayout());
	static DefaultListModel<String> listNotas = new DefaultListModel<>();
	static JList<String> list_notas = new JList<>(listNotas);
	static JScrollPane scroll_list_notas = new JScrollPane(list_notas);
	
	static JPanel panel_list_comentarios = new JPanel(new BorderLayout());
	static DefaultListModel<String> listComentarios = new DefaultListModel<>();
	static JList<String> list_comentarios = new JList<>(listComentarios);
	static JScrollPane scroll_list_comentarios = new JScrollPane(list_comentarios);
	
	
	//listboxes aulas e horario
	static JPanel panel_list_aulas = new JPanel(new BorderLayout());
	static DefaultListModel<String> listAulas = new DefaultListModel<>();
	static JList<String> list_aulas = new JList<>(listAulas);
	static JScrollPane scroll_list_aulas = new JScrollPane(list_aulas);
	
	static JPanel panel_list_horario_inicio = new JPanel(new BorderLayout());
	static DefaultListModel<String> listHorarioInicio = new DefaultListModel<>();
	static JList<String> list_horario_inicio = new JList<>(listHorarioInicio);
	static JScrollPane scroll_list_horario_inicio = new JScrollPane(list_horario_inicio);
	
	static JPanel panel_list_horario_final = new JPanel(new BorderLayout());
	static DefaultListModel<String> listHorarioFinal = new DefaultListModel<>();
	static JList<String> list_horario_final = new JList<>(listHorarioFinal);
	static JScrollPane scroll_list_horario_final = new JScrollPane(list_horario_final);
	
	//datepicker
	static com.toedter.calendar.JDateChooser datepicker_inicio = new com.toedter.calendar.JDateChooser();
	static com.toedter.calendar.JDateChooser datepicker_tarefa = new com.toedter.calendar.JDateChooser();
	
	//botoes
	static JButton btn_atualizar = new JButton("Atualizar");
	
	
	
	//AULASTAREFAS
	//labels
	static JLabel lbl_turmas1 = new JLabel("Turma", SwingConstants.CENTER);
	static JLabel lbl_inicio1 = new JLabel("Inicio", SwingConstants.CENTER);
	static JLabel lbl_final1 = new JLabel("Final", SwingConstants.CENTER);
	static JLabel lbl_dia1 = new JLabel("Dia", SwingConstants.CENTER);
	static JLabel lbl_alunos1 = new JLabel("Alunos", SwingConstants.CENTER);
	
	static JLabel lbl_data2 = new JLabel("Data", SwingConstants.CENTER);
	static JLabel lbl_dia2 = new JLabel("Quinta-feira", SwingConstants.CENTER);
	static JLabel lbl_turmas2 = new JLabel("Turma", SwingConstants.CENTER);
	static JLabel lbl_inicio2 = new JLabel("Inicio", SwingConstants.CENTER);
	static JLabel lbl_final2 = new JLabel("Final", SwingConstants.CENTER);
	static JLabel lbl_tarefas2 = new JLabel("Tarefa", SwingConstants.CENTER);
	static JLabel lbl_alunos2 = new JLabel("Alunos", SwingConstants.CENTER);
	
	
	//textfields, comboboxes
	static JTextField txt_turmas1 = new JTextField("");
	static JTextField txt_inicio1 = new JTextField("");
	static JTextField txt_final1 = new JTextField("");
	static JTextField txt_alunos1 = new JTextField("");
	
	static JTextField txt_alunos2 = new JTextField("");
	static JTextField txt_tarefas2 = new JTextField("");
	
	//listboxes
	static JPanel panel_list_turmas1 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listTurmas1 = new DefaultListModel<>();
	static JList<String> list_turmas1 = new JList<>(listTurmas1);
	static JScrollPane scroll_list_turmas1 = new JScrollPane(list_turmas1);
	
	static JPanel panel_list_inicio1 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listInicio1 = new DefaultListModel<>();
	static JList<String> list_inicio1 = new JList<>(listInicio1);
	static JScrollPane scroll_list_inicio1 = new JScrollPane(list_inicio1);
	
	static JPanel panel_list_final1 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listFinal1 = new DefaultListModel<>();
	static JList<String> list_final1 = new JList<>(listFinal1);
	static JScrollPane scroll_list_final1 = new JScrollPane(list_final1);
	
	static JPanel panel_list_dia1 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listDia1 = new DefaultListModel<>();
	static JList<String> list_dia1 = new JList<>(listDia1);
	static JScrollPane scroll_list_dia1 = new JScrollPane(list_dia1);
	
	static JPanel panel_list_alunos1 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listAlunos1 = new DefaultListModel<>();
	static JList<String> list_alunos1 = new JList<>(listAlunos1);
	static JScrollPane scroll_list_alunos1 = new JScrollPane(list_alunos1);
	
	//listboxes pt2
	static JPanel panel_list_turmas2 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listTurmas2 = new DefaultListModel<>();
	static JList<String> list_turmas2 = new JList<>(listTurmas2);
	static JScrollPane scroll_list_turmas2 = new JScrollPane(list_turmas2);
	
	static JPanel panel_list_inicio2 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listInicio2 = new DefaultListModel<>();
	static JList<String> list_inicio2 = new JList<>(listInicio2);
	static JScrollPane scroll_list_inicio2 = new JScrollPane(list_inicio2);
	
	static JPanel panel_list_final2 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listFinal2 = new DefaultListModel<>();
	static JList<String> list_final2 = new JList<>(listFinal2);
	static JScrollPane scroll_list_final2 = new JScrollPane(list_final2);
	
	static JPanel panel_list_alunos2 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listAlunos2 = new DefaultListModel<>();
	static JList<String> list_alunos2 = new JList<>(listAlunos2);
	static JScrollPane scroll_list_alunos2 = new JScrollPane(list_alunos2);
	
	static JPanel panel_list_tarefas2 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listTarefas2 = new DefaultListModel<>();
	static JList<String> list_tarefas2 = new JList<>(listTarefas2);
	static JScrollPane scroll_list_tarefas2 = new JScrollPane(list_tarefas2);
	
	static JPanel panel_divisao = new JPanel(new BorderLayout());
	
	//botoes
	static JButton btn_adicionar_aula1 = new JButton("Adicionar");
	static JButton btn_remover_aula1 = new JButton("Remover");
	static JButton btn_adicionar_aluno1 = new JButton("Adicionar");
	static JButton btn_remover_aluno1 = new JButton("Remover");
	static JButton btn_adicionar_tarefa2 = new JButton("Adicionar");
	static JButton btn_remover_tarefa2 = new JButton("Remover");
	static JButton btn_adicionar_aluno2 = new JButton("Adicionar");
	static JButton btn_remover_aluno2 = new JButton("Remover");
	static JButton btn_carregar2 = new JButton("Carregar");
	
	
	
	//ESTATISTICAS
	//labels
	static JLabel lbl_dia3 = new JLabel("Dia", SwingConstants.CENTER);
	static JLabel lbl_turmas3 = new JLabel("Turma", SwingConstants.CENTER);
	static JLabel lbl_inicio3 = new JLabel("Inicio", SwingConstants.CENTER);
	static JLabel lbl_final3 = new JLabel("Final", SwingConstants.CENTER);
	static JLabel lbl_tarefas3 = new JLabel("Tarefas", SwingConstants.CENTER);
	static JLabel lbl_datas3 = new JLabel("Entrega", SwingConstants.CENTER);
	
	static JLabel lbl_limiar3 = new JLabel("Limiar");
	static JLabel lbl_media3 = new JLabel("Media: ");
	
	//listboxes
	static JPanel panel_list_dia3 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listDia3 = new DefaultListModel<>();
	static JList<String> list_dia3 = new JList<>(listDia3);
	static JScrollPane scroll_list_dia3 = new JScrollPane(list_dia3);
	
	static JPanel panel_list_turmas3 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listTurmas3 = new DefaultListModel<>();
	static JList<String> list_turmas3 = new JList<>(listTurmas3);
	static JScrollPane scroll_list_turmas3 = new JScrollPane(list_turmas3);
	
	static JPanel panel_list_inicio3 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listInicio3 = new DefaultListModel<>();
	static JList<String> list_inicio3 = new JList<>(listInicio3);
	static JScrollPane scroll_list_inicio3 = new JScrollPane(list_inicio3);
	
	static JPanel panel_list_final3 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listFinal3 = new DefaultListModel<>();
	static JList<String> list_final3 = new JList<>(listFinal3);
	static JScrollPane scroll_list_final3 = new JScrollPane(list_final3);
	
	static JPanel panel_list_tarefas3 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listTarefas3 = new DefaultListModel<>();
	static JList<String> list_tarefas3 = new JList<>(listTarefas3);
	static JScrollPane scroll_list_tarefas3 = new JScrollPane(list_tarefas3);
	
	static JPanel panel_list_datas3 = new JPanel(new BorderLayout());
	static DefaultListModel<String> listDatas3 = new DefaultListModel<>();
	static JList<String> list_datas3 = new JList<>(listDatas3);
	static JScrollPane scroll_list_datas3 = new JScrollPane(list_datas3);
	
	
	
	//outros
	static JTextField txt_limiar3 = new JTextField("6.0");
	static JPanel panel_divisao2 = new JPanel(new BorderLayout());
	static JPanel panel_chart = new JPanel(new BorderLayout());
	
	static DefaultListModel<String> listAlunos3 = new DefaultListModel<>();
	static DefaultListModel<String> listAlunos4 = new DefaultListModel<>();
	static DefaultListModel<String> listEntregas4 = new DefaultListModel<>();
	static DefaultListModel<String> listNotas4 = new DefaultListModel<>();
	static DefaultListModel<String> listComentarios4 = new DefaultListModel<>();
	static DefaultListModel<String> listTarefas4 = new DefaultListModel<>();
	static DefaultListModel<String> listMutual = new DefaultListModel<>();
	
	static int aprovados = 0;
	static int reprovados = 0;
	static int nentregues = 0;
	static int natribuidos = 0;
	
	
	//OPCOES
	static JToggleButton tbtn_metal = new JToggleButton("Java");        static JToggleButton tbtn_windows = new JToggleButton("Windows"); 
	static JToggleButton tbtn_mac = new JToggleButton("Mac");           static JToggleButton tbtn_win_old = new JToggleButton("Windows Antigo");
	static JToggleButton tbtn_d_mac = new JToggleButton("Mac Escuro");  static JToggleButton tbtn_flatlaf = new JToggleButton("FlatLook");
	static JToggleButton tbtn_nimbus = new JToggleButton("Nimbus");     static JToggleButton tbtn_darklaf = new JToggleButton("FlatLook Escuro");
	static JToggleButton tbtn_motif = new JToggleButton("Motif");       static JToggleButton tbtn_intellij = new JToggleButton("IntelliJ");
	static JToggleButton tbtn_gtk = new JToggleButton("GTK");           static JToggleButton tbtn_int_dark = new JToggleButton("IntelliJ Escuro");
	
	static int descobrirAulaAtual(){
		int index = -1; long minutos = -1;
		boolean achou = false;
		for (int c = 0; c < listHorarioInicio.size(); c++){
			LocalTime t = LocalTime.parse(dataAtual.format(horarioFormato));
			LocalTime t_inicio = LocalTime.parse(listHorarioInicio.getElementAt(c));
			LocalTime t_final = LocalTime.parse(listHorarioFinal.getElementAt(c));
			//System.out.println(t_inicio + " " + t_final + " : " + t + " : " + aulaatual + " " + aulaatualantiga);
			if (t.compareTo(t_inicio) >= 0 && t.compareTo(t_final) < 0){
				index = c;
				long minutosanterior = minutos;
				minutos = t.until(t_final, MINUTES);
				if (minutos != minutosanterior) {
					if (minutos > 1) {
						lbl_fim_aula.setText(minutos + " minutos para o fim da aula");
					} else {
						lbl_fim_aula.setText(minutos + " minuto para o fim da aula");
					}
					lbl_aula_atual.setText("Aula Atual: " + listAulas.getElementAt(c));
					achou = true;
				}
			}
			if (achou != true) {
				if (lbl_aula_atual.getText() != "Sem aula no momento atual" && lbl_fim_aula.getText() != "");
				lbl_aula_atual.setText("Sem aula no momento atual");
				lbl_fim_aula.setText("");
			}
			//System.out.println(aulaatual);
			
		}
		LocalTime t = LocalTime.parse(dataAtual.format(horarioFormato));
		
		return index;
	}
	static void atualizarAulaAtual(){
		list_aulas.clearSelection();
        list_horario_inicio.clearSelection();
        list_horario_final.clearSelection();
		list_aulas.setSelectedIndex(aulaatual);
	}
	
	//metodos de definicao
	static void definirBtn(JButton obj, int x, int y, int w, int h, Font fonte){
		obj.setBounds(x, y, w, h);
		obj.setFont(fonte);
		obj.setFocusable(false);
		janela.add(obj);
	}
	static void definirTBtn(JToggleButton obj, int x, int y, int w, int h, Font fonte){
		obj.setBounds(x, y, w, h);
		obj.setFont(fonte);
		obj.setFocusable(false);
		janela.add(obj);
	}
	static void definirLbl(JLabel obj, int x, int y, int w, int h, Font fonte){
		obj.setBounds(x, y, w, h);
		obj.setFont(fonte);
		janela.add(obj);
	}
	static void definirTxt(JTextField obj, int x, int y, int w, int h, Font fonte){
		obj.setBounds(x, y, w, h);
		obj.setFont(fonte);
		janela.add(obj);
	}
	static void definirCombo(JComboBox obj, int x, int y, int w, int h, Font fonte){
		obj.setBounds(x, y, w, h);
		obj.setFont(fonte);
		obj.setFocusable(false);
		janela.add(obj);
	}
	static void definirTxtArea(JPanel panel, int x, int y, int w, int h, Font fonte, JScrollPane scroll, JTextArea obj){
		scroll.setViewportView(obj);
		panel.add(scroll);
		panel.setBounds(x, y, w, h);
		obj.setFont(fonteLista);
		obj.setLineWrap(true);
		janela.add(panel);
	}
	static void definirList(JPanel panel, int x, int y, int w, int h, Font fonte, JScrollPane scroll, JList<String> obj){
		scroll.setViewportView(obj);
		obj.setLayoutOrientation(JList.VERTICAL);
		panel.add(scroll);
		panel.setBounds(x, y, w, h);
		obj.setFont(fonte);
		obj.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		janela.add(panel);
	}
	static void definirDate(com.toedter.calendar.JDateChooser obj, int x, int y, int w, int h, Font fonte){
		obj.setBounds(x, y, w, h);
		obj.setFont(fonte);
		Date data = new Date();
		obj.setDate(data);
		janela.add(obj);
	}
	static void definirPanel(JPanel obj, int x, int y, int w, int h){
		obj.setBounds(x, y, w, h);
		janela.add(obj);
	}
	static void definirGrafico(JPanel obj, int x, int y, int w, int h, int aprovados, int reprovados, int nentregues, int natribuidos){
		obj.removeAll();
		obj.setBounds(x, y, w, h);
		
		DefaultPieDataset dataset = new DefaultPieDataset( );
		dataset.setValue( "Aprovados" , aprovados );
		dataset.setValue( "Reprovados" , reprovados );
		dataset.setValue( "Nao Entregue" , nentregues );
		dataset.setValue( "Nao Atribuidos" , natribuidos );
        JFreeChart chart = ChartFactory.createPieChart(null, dataset, true, true, false);
        ChartPanel chartpanel = new ChartPanel(chart);
        //chartpanel.setDomainZoomable(true);
		
		PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(  
			"{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
		PiePlot plot = (PiePlot) chart.getPlot();
			plot.setLabelGenerator(labelGenerator);
			plot.setSectionPaint(0, Color.green);
			plot.setSectionPaint(1, Color.red);
			plot.setSectionPaint(2, Color.lightGray);
			plot.setSectionPaint(3, Color.darkGray);
		
		obj.add(chartpanel);
		janela.add(obj);
		chartpanel.updateUI();
	}

	
	public static void main(String args[]) {
		
		header.definirHeader(width, height);
		inicio.definirInicio(width, height); inicio.definirVisivel(false);
		aulastarefas.definirAulasTarefas(width, height); aulastarefas.definirVisivel(false);
		estatisticas.definirEstatisticas(width, height); estatisticas.definirVisivel(false);
		opcoes.definirOpcoes(width, height); opcoes.definirVisivel(false);
		
		
		header.definirEventos(inicio, aulastarefas, estatisticas, opcoes);
		inicio.definirEventos();
		aulastarefas.definirEventos();
		estatisticas.definirEventos();
		opcoes.definirEventos();
		
		janela.setSize(width, height);
		janela.setLayout(null);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setTitle("Gerenciador de Aulas");
		//janela.setResizable(false);
		janela.setMinimumSize(new Dimension(800, 450));
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				width = janela.getBounds().getSize().width;
				height = janela.getBounds().getSize().height;
				
				fonteAulaAtual = new Font("Arial", Font.PLAIN, pct((int)(((double)width+((double)height)*0.5625)/2), 3.5));
				fonteBtnTopo = new Font("Arial", Font.PLAIN, pct((int)(((double)width+((double)height)*0.5625)/2), 2.75));
				fonteBtn = new Font("Arial", Font.PLAIN, pct((int)(((double)width+((double)height)*0.5625)/2), 2.5));
				fonteLista = new Font("Arial", Font.PLAIN, pct((int)(((double)width+((double)height)*0.5625)/2), 2));
				
				header.definirHeader(width, height);
				inicio.definirInicio(width, height);
				aulastarefas.definirAulasTarefas(width, height);
				estatisticas.definirEstatisticas(width, height);
				opcoes.definirOpcoes(width, height);
			}
		});
		
		class AtualizaTempo extends TimerTask {
			public void run() {
				dataAtual = LocalDateTime.now();
				String horaFormatada = dataAtual.format(horaFormato);
				String dataFormatada = dataAtual.format(dataFormato);
				String diaFormatado = dataAtual.format(diaFormato);
				lbl_hora.setText(horaFormatada);
				lbl_data.setText(dataFormatada);
				lbl_dia.setText(diaFormatado.substring(0,1).toUpperCase() + diaFormatado.substring(1));
				aulaatualantiga = aulaatual;
				aulaatual = descobrirAulaAtual();
				if (list_aulas.getSelectedIndex() == aulaatualantiga && aulaatual != aulaatualantiga) {
					atualizarAulaAtual();
				}
			}
		}
		lbl_dia_semana.setText(LocalDateTime.now().format(diaFormato).substring(0,1).toUpperCase() + LocalDateTime.now().format(diaFormato).substring(1));
		lbl_dia2.setText(LocalDateTime.now().format(diaFormato).substring(0,1).toUpperCase() + LocalDateTime.now().format(diaFormato).substring(1));
		
		Timer temporizador = new Timer();
		temporizador.schedule(new AtualizaTempo(), 0, 1000);
		
		tbtn_win_old.doClick();
		tbtn_windows.doClick();
		tbtn_inicio.doClick();
		
		list_alunos.setSelectedIndex(0);
		SwingUtilities.updateComponentTreeUI(janela);
		atualizarAulaAtual();
		
		listDia1.addElement("Segunda-feira"); listDia3.addElement("Segunda-feira");
		listDia1.addElement("Terca-feira");   listDia3.addElement("Terca-feira");
		listDia1.addElement("Quarta-feira");  listDia3.addElement("Quarta-feira");
		listDia1.addElement("Quinta-feira");  listDia3.addElement("Quinta-feira");
		listDia1.addElement("Sexta-feira");   listDia3.addElement("Sexta-feira");
		listDia1.addElement("Sabado");        listDia3.addElement("Sabado");
		listDia1.addElement("Domingo");       listDia3.addElement("Domingo");
		
		Database.connectDatabase();
		
		Database.selectAulas(listAulas, listHorarioInicio, listHorarioFinal, lbl_dia2.getText());
		Database.selectTarefas(listTarefas, AulasTarefas.formatador.format(datepicker_inicio.getDate()));
		
		Database.selectAulas(listTurmas2, listInicio2, listFinal2, lbl_dia2.getText());
		Database.selectTarefas(listTarefas2, AulasTarefas.formatador.format(datepicker_tarefa.getDate()));
		
		Database.selectTodasTarefas(Menu.listTarefas3, Menu.listDatas3);
		
		btn_carregar2.setEnabled(false);
		btn_adicionar_aluno1.setEnabled(false);
		btn_adicionar_aluno2.setEnabled(false);
		btn_remover_aluno1.setEnabled(false);
		btn_remover_aluno2.setEnabled(false);
		
		
		combo_atualizar_entrega.setEnabled(false);
		txt_atualizar_nota.setEnabled(false);
		txtarea_atualizar_comentario.setEnabled(false);
		btn_atualizar.setEnabled(false);
		combo_atualizar_entrega.setSelectedIndex(-1);
	}
}