package batalhaNaval2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public abstract class Game2 implements ActionListener {
	
	protected JFrame janelaJogo;
	private JPanel panelTabuleiroJ, panelTabuleiroC;
	private BotaoJ[][] tabuleiroA, tabuleiroB;
	private int positionX=10, positionY=10, positionXB=440, positionYB=10, positionTX = 60, positionTY = 500;
	private BotaoJ botaoVoltarMenu;
	private int pontos, pontosC;
	JTextArea dicaX, entradaY;
	JButton dicaa;
	
	
	//========================== Construtor ===============================
	public Game2(){

		pontos = 0;
		tabuleiroA = new BotaoJ[10][10];
		tabuleiroB = new BotaoJ[10][10];
		
		//----------------------- Painel e botões ---------------------------
	    
		//................ Tabuleiro Jogador......................
		panelTabuleiroJ = new JPanel();
		panelTabuleiroJ.setLayout(null);
		panelTabuleiroJ.setVisible(true);  
		
		for(int i=0; i<10;i++){
			for(int j=0; j<10; j++){
				tabuleiroA[i][j] = new BotaoJ();
				
				tabuleiroA[i][j].setBounds(positionX, positionY, 40, 40);
				positionX += 40;
				
				panelTabuleiroJ.add(tabuleiroA[i][j]);
		    	tabuleiroA[i][j].setVisible(true);
		    	tabuleiroB[i][j] = new BotaoJ();
	    		tabuleiroB[i][j].setBounds(positionXB, positionYB, 40, 40);
		    	positionXB += 40;
	    		panelTabuleiroJ.add(tabuleiroB[i][j]);	
	    		tabuleiroB[i][j].setVisible(true);
		    }
		    positionX = 10;
		    positionY += 40;
		    
		    positionXB = 440;
	    	positionYB += 40;
		 }
		
		 botaoVoltarMenu = new BotaoJ();
		 botaoVoltarMenu.setBounds(250, positionTY, 150, 50);
		 botaoVoltarMenu.setBackground(Color.GREEN);
		 botaoVoltarMenu.setForeground(Color.BLACK);
		 botaoVoltarMenu.setVisible(true);
		 panelTabuleiroJ.add(botaoVoltarMenu);
		 botaoVoltarMenu.setText("Voltar Menu");
		    
		 botaoVoltarMenu.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
					Object object = e.getSource();
					if(object == botaoVoltarMenu){
						MenuPrincipal c = new MenuPrincipal();
						janelaJogo.setVisible(false);
					}
				}
		    });
		 
		//-------------------------Janela---------------------------------
			janelaJogo = new JFrame("Batalha Naval");
			janelaJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janelaJogo.setResizable(false);
			janelaJogo.setSize(1000,600);
			janelaJogo.setForeground(new Color(128, 184, 205));
			janelaJogo.getContentPane().add(panelTabuleiroJ);
			janelaJogo.setVisible(true);
		    
		 
		dicaX = new JTextArea();
		dicaX.setEditable(true);
		dicaX.setBounds(440, positionTY, 100, 25);
		dicaX.setBorder(BorderFactory.createLineBorder(Color.black));
		panelTabuleiroJ.add(dicaX);
			
		entradaY = new JTextArea();
		entradaY.setEditable(true);
		entradaY.setBounds(580, positionTY, 100, 25);
		entradaY.setBorder(BorderFactory.createLineBorder(Color.black));
		panelTabuleiroJ.add(entradaY);
		
		
		JButton dicaa = new JButton();
		dicaa.setBounds(positionTX, positionTY, 150, 50);
		dicaa.setBackground(Color.GREEN);
		dicaa.setForeground(Color.BLACK);
		dicaa.setVisible(true);
		dicaa.setText("Dica");
		dicaa.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dica();
			}
		});
		panelTabuleiroJ.add(dicaa);
		  
		   
		
		
		
		
	} //fim construtor


	public abstract void actionPerformed(ActionEvent e);

	public abstract void dica();

	public BotaoJ[][] getTabuleiroA() {
		return tabuleiroA;
	}
	public void setTabuleiroA(BotaoJ[][] tabuleiroA) {
		this.tabuleiroA = tabuleiroA;
	}
	public BotaoJ[][] getTabuleiroB() {
		return tabuleiroB;
	}
	public void setTabuleiroB(BotaoJ[][] tabuleiroB) {
		this.tabuleiroB = tabuleiroB;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public int getPontosC() {
		return pontosC;
	}
	public void setPontosC(int pontosC) {
		this.pontosC = pontosC;
	}
	
	
	
	
	
	
	

}
