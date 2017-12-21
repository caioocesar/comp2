package batalhaNaval2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameAleatorio extends Game2 {
	
	private JFrame janelaFimDeJogo;
	private JPanel panelAux;
	private BotaoJ[][] tabuleiroJogador, tabuleiroComputador;
	private int n=0, aux, QntBarcos = 0;
	//private int pontos;
	
	public GameAleatorio(){
		super();
		setPontos(0);
		setPontosC(0);
		tabuleiroJogador = getTabuleiroA();
		tabuleiroComputador = getTabuleiroB();
		posicionarBarcosJogador();
		posicionarBarcosComputador();
		comecarJogo();

	}//fim construtor
	
	private void comecarJogo(){	
		for(int m=0; m<10; m++){
			for(int j=0; j<10; j++){
				int z = m, w=j;
				tabuleiroComputador[m][j].addActionListener(new ActionListener(){
			    	public void actionPerformed(ActionEvent e){
			    		if(tabuleiroComputador[z][w].isLock() == false){
			    			if(tabuleiroComputador[z][w].getTemBarco() == 0){
			    				tabuleiroComputador[z][w].setBackground(Color.BLUE);
			    				tabuleiroComputador[z][w].setLock(true);
			    				jogadaComputador();
			    			}
			    			else{
			    				tabuleiroComputador[z][w].setBackground(Color.DARK_GRAY);
			    				setPontos(getPontos() + 1);
			    				tabuleiroComputador[z][w].setLock(true);
			    				if(getPontos() == 11){
			    					ganhou();
			    				}
			    				jogadaComputador();			    			
			    			}
			    		}
			    	}
			    });
			}
		}
		
	}
	
	private void ganhou(){
		janelaFimDeJogo = new JFrame("Batalha Naval");
		janelaFimDeJogo.setResizable(false);
		janelaFimDeJogo.setSize(600,500);
		janelaFimDeJogo.setVisible(true);
		JLabel label1 = new JLabel("Você Ganhou", null, JLabel.CENTER);
	    label1.setBounds(100, 10, 400, 30);
	    label1.setFont(label1.getFont().deriveFont(20.0f));
	    label1.setForeground(new Color(18, 210, 43));
	    panelAux = new JPanel();
	    panelAux.setLayout(null);
	    janelaJogo.setVisible(false);
	    panelAux.setVisible(true);
	    panelAux.add(label1); 
	    BotaoJ novoJogo = new BotaoJ();
	    BotaoJ menu = new BotaoJ();
	    novoJogo.setText("Novo Jogo");
	    menu.setText("Menu");
	    menu.setBounds(225, 180, 150, 50);
		menu.setBackground(Color.GREEN);
		novoJogo.setBounds(225, 250, 150, 50);
		novoJogo.setBackground(Color.GREEN);
		menu.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				MenuPrincipal c = new MenuPrincipal();
				janelaFimDeJogo.setVisible(false);
				janelaJogo.setVisible(false);
			}
		});
		novoJogo.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				TipoDeJogo t = new TipoDeJogo();
				janelaFimDeJogo.setVisible(false);
				janelaJogo.setVisible(false);
			}
		});
		panelAux.add(novoJogo);
	    panelAux.add(menu);
		janelaFimDeJogo.add(panelAux);	
	}
	
	private void perdeu(){
		janelaFimDeJogo = new JFrame("Batalha Naval");
		janelaFimDeJogo.setResizable(false);
		janelaFimDeJogo.setSize(600,500);
		janelaFimDeJogo.setVisible(true);
	    janelaJogo.setVisible(false);
		JLabel label1 = new JLabel("Você Perdeu", null, JLabel.CENTER);
	    label1.setBounds(100, 10, 400, 30);
	    label1.setFont(label1.getFont().deriveFont(20.0f));
	    label1.setForeground(new Color(0, 225, 0));
	    panelAux = new JPanel();
	    panelAux.setLayout(null);
	    panelAux.setVisible(true);
	    panelAux.add(label1); 
	    BotaoJ novoJogo = new BotaoJ();
	    BotaoJ menu = new BotaoJ();
	    novoJogo.setText("Novo Jogo");
	    menu.setText("Menu");
	    menu.setBounds(225, 180, 150, 50);
		menu.setBackground(Color.RED);
		novoJogo.setBounds(225, 250, 150, 50);
		novoJogo.setBackground(Color.RED);
		menu.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				MenuPrincipal c = new MenuPrincipal();
				janelaFimDeJogo.setVisible(false);
				janelaJogo.setVisible(false);
			}
		});
		novoJogo.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				TipoDeJogo t = new TipoDeJogo();
				janelaFimDeJogo.setVisible(false);
				janelaJogo.setVisible(false);
			}
		});
		panelAux.add(novoJogo);
	    panelAux.add(menu);
		janelaFimDeJogo.add(panelAux);	
	}
	
	private void jogadaComputador(){
		int x, y, auxX, auxY;
		Random jogada = new Random();
		x = jogada.nextInt(10);
		y = jogada.nextInt(10);
		if(tabuleiroJogador[x][y].isLock() == false){
			if(tabuleiroJogador[x][y].getTemBarco() == 0){
				tabuleiroJogador[x][y].setBackground(Color.BLUE);
    			tabuleiroJogador[x][y].setLock(true);
   				aux=0;
   				comecarJogo();
			}
   			else{
	   			tabuleiroJogador[x][y].setBackground(Color.DARK_GRAY);
	   			setPontosC(getPontosC() + 1);
	   			tabuleiroJogador[x][y].setLock(true);
	   			aux=1;
   				if(getPontosC() == 11){
   					perdeu();
				}
  				comecarJogo();
   			}
		}
		else{
			jogadaComputador();
		}
	}
		
	public void actionPerformed(ActionEvent w) {
		
	}
	
	private void addBarcoC(int tamanho){
		int x, y, direcao;
		Random rand = new Random();
		direcao = rand.nextInt(2);
		x = rand.nextInt(10);
		y = rand.nextInt(10);
		if(tamanho == 4){
			if(direcao == 0){
				if(x == 7 || x ==8 || x == 9){
					addBarcoC(tamanho);
				}
				else{
					if(tabuleiroComputador[x][y].getTemBarco()== 0 && tabuleiroComputador[x+1][y].getTemBarco()== 0 && tabuleiroComputador[x+2][y].getTemBarco()== 0 && tabuleiroComputador[x+3][y].getTemBarco()== 0){
						tabuleiroComputador[x][y].setTemBarco(1);
						tabuleiroComputador[x+1][y].setTemBarco(1);
						tabuleiroComputador[x+2][y].setTemBarco(1);
						tabuleiroComputador[x+3][y].setTemBarco(1);
					}
					else{
						addBarcoC(tamanho);
					}
				}
			}
			if(direcao == 1){
				if(y == 7 || y == 8 || y == 9){
					addBarcoC(4);
				}
				else{
					if(tabuleiroComputador[x][y].getTemBarco()== 0 && tabuleiroComputador[x][y+1].getTemBarco()== 0 && tabuleiroComputador[x][y+2].getTemBarco()== 0 && tabuleiroComputador[x][y+3].getTemBarco()== 0){
						tabuleiroComputador[x][y].setTemBarco(1);
						tabuleiroComputador[x][y+1].setTemBarco(1);
						tabuleiroComputador[x][y+2].setTemBarco(1);
						tabuleiroComputador[x][y+3].setTemBarco(1);
					}
					else{
						addBarcoC(tamanho);
					}
				}
			}
		}
		else if(tamanho == 3){
			if(direcao == 0){
				if(x ==8 || x == 9){
					addBarcoC(tamanho);
				}
				else{
					if(tabuleiroComputador[x][y].getTemBarco()== 0 && tabuleiroComputador[x+1][y].getTemBarco()== 0 && tabuleiroComputador[x+2][y].getTemBarco()== 0){
						tabuleiroComputador[x][y].setTemBarco(1);
						tabuleiroComputador[x+1][y].setTemBarco(1);
						tabuleiroComputador[x+2][y].setTemBarco(1);
					}
					else{
						addBarcoC(tamanho);
					}
				}
			}
			if(direcao == 1){
				if(y == 8 || y == 9){
					addBarcoC(tamanho);
				}
				else{
					if(tabuleiroComputador[x][y].getTemBarco()== 0 && tabuleiroComputador[x][y+1].getTemBarco()== 0 && tabuleiroComputador[x][y+2].getTemBarco()== 0){
						tabuleiroComputador[x][y].setTemBarco(1);
						tabuleiroComputador[x][y+1].setTemBarco(1);
						tabuleiroComputador[x][y+2].setTemBarco(1);
					}
					else{
						addBarcoC(tamanho);
					}
				}
			}
		}
		else if(tamanho == 2){
			if(direcao == 0){
				if(x == 9){
					addBarcoC(tamanho);
				}
				else{
					if(tabuleiroComputador[x][y].getTemBarco()== 0 && tabuleiroComputador[x+1][y].getTemBarco()== 0){
						tabuleiroComputador[x][y].setTemBarco(1);
						tabuleiroComputador[x+1][y].setTemBarco(1);
					}
					else{
						addBarcoC(tamanho);
					}
				}
			}
			if(direcao == 1){
				if(y == 9){
					addBarcoC(tamanho);
				}
				else{
					if(tabuleiroComputador[x][y].getTemBarco()== 0 && tabuleiroComputador[x][y+1].getTemBarco()== 0){
						tabuleiroComputador[x][y].setTemBarco(1);
						tabuleiroComputador[x][y+1].setTemBarco(1);
					}
					else{
						addBarcoC(tamanho);
					}
				}
			}
		}
	}

	private void addBarcoJ(int tamanho){
		int x, y, direcao;
		Random rand = new Random();
		direcao = rand.nextInt(2);
		x = rand.nextInt(10);
		y = rand.nextInt(10);
		if(tamanho == 4){
			if(direcao == 0){
				if(x == 7 || x ==8 || x == 9){
					addBarcoJ(tamanho);
				}
				else{
					if(tabuleiroJogador[x][y].getTemBarco()== 0 && tabuleiroJogador[x+1][y].getTemBarco()== 0 && tabuleiroJogador[x+2][y].getTemBarco()== 0 && tabuleiroJogador[x+3][y].getTemBarco()== 0){
						tabuleiroJogador[x][y].setTemBarco(1);
						tabuleiroJogador[x+1][y].setTemBarco(1);
						tabuleiroJogador[x+2][y].setTemBarco(1);
						tabuleiroJogador[x+3][y].setTemBarco(1);
					}
					else{
						addBarcoJ(tamanho);
					}
				}
			}
			if(direcao == 1){
				if(y == 7 || y == 8 || y == 9){
					addBarcoJ(4);
				}
				else{
					if(tabuleiroJogador[x][y].getTemBarco()== 0 && tabuleiroJogador[x][y+1].getTemBarco()== 0 && tabuleiroJogador[x][y+2].getTemBarco()== 0 && tabuleiroJogador[x][y+3].getTemBarco()== 0){
						tabuleiroJogador[x][y].setTemBarco(1);
						tabuleiroJogador[x][y+1].setTemBarco(1);
						tabuleiroJogador[x][y+2].setTemBarco(1);
						tabuleiroJogador[x][y+3].setTemBarco(1);
					}
					else{
						addBarcoJ(tamanho);
					}
				}
			}
		}
		else if(tamanho == 3){
			if(direcao == 0){
				if(x ==8 || x == 9){
					addBarcoJ(tamanho);
				}
				else{
					if(tabuleiroJogador[x][y].getTemBarco()== 0 && tabuleiroJogador[x+1][y].getTemBarco()== 0 && tabuleiroJogador[x+2][y].getTemBarco()== 0){
						tabuleiroJogador[x][y].setTemBarco(1);
						tabuleiroJogador[x+1][y].setTemBarco(1);
						tabuleiroJogador[x+2][y].setTemBarco(1);
					}
					else{
						addBarcoJ(tamanho);
					}
				}
			}
			if(direcao == 1){
				if(y == 8 || y == 9){
					addBarcoJ(tamanho);
				}
				else{
					if(tabuleiroJogador[x][y].getTemBarco()== 0 && tabuleiroJogador[x][y+1].getTemBarco()== 0 && tabuleiroJogador[x][y+2].getTemBarco()== 0){
						tabuleiroJogador[x][y].setTemBarco(1);
						tabuleiroJogador[x][y+1].setTemBarco(1);
						tabuleiroJogador[x][y+2].setTemBarco(1);
					}
					else{
						addBarcoJ(tamanho);
					}
				}
			}
		}
		else if(tamanho == 2){
			if(direcao == 0){
				if(x == 9){
					addBarcoJ(tamanho);
				}
				else{
					if(tabuleiroJogador[x][y].getTemBarco()== 0 && tabuleiroJogador[x+1][y].getTemBarco()== 0){
						tabuleiroJogador[x][y].setTemBarco(1);
						tabuleiroJogador[x+1][y].setTemBarco(1);
					}
					else{
						addBarcoJ(tamanho);
					}
				}
			}
			if(direcao == 1){
				if(y == 9){
					addBarcoJ(tamanho);
				}
				else{
					if(tabuleiroJogador[x][y].getTemBarco()== 0 && tabuleiroJogador[x][y+1].getTemBarco()== 0){
						tabuleiroJogador[x][y].setTemBarco(1);
						tabuleiroJogador[x][y+1].setTemBarco(1);
					}
					else{
						addBarcoJ(tamanho);
					}
				}
			}
		}
	}
	
	private void posicionarBarcosJogador() {
		aux=0;
		addBarcoC(2);
		addBarcoC(2);
		addBarcoC(3);
		addBarcoC(4);
		for(int i=0; i<10; i++){
			for(int j=0; j<10;j++){
				if(tabuleiroComputador[i][j].getTemBarco() == 1){
					aux++;
				}
			}
		}
		if(aux!=11){
			posicionarBarcosJogador();
		}
	}
	
	private void posicionarBarcosComputador() {
		aux=0;
		addBarcoJ(2);
		addBarcoJ(2);
		addBarcoJ(3);
		addBarcoJ(4);
		for(int i=0; i<10; i++){
			for(int j=0; j<10;j++){
				if(tabuleiroJogador[i][j].getTemBarco() == 1){
					aux++;
				}
			}
		}
		if(aux!=11){
			posicionarBarcosComputador();
		}
	}
	
	public void dica() {
		
		int x = Integer.parseInt(dicaX.getText().toString());
		int y = Integer.parseInt(entradaY.getText().toString());
		if(tabuleiroComputador[x][y].getTemBarco()==1)
			JOptionPane.showMessageDialog(janelaJogo,"Há um barco");
		else{
			JOptionPane.showMessageDialog(janelaJogo,"Não há um barco");
		}
	}
	
}


