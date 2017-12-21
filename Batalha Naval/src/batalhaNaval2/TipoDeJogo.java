package batalhaNaval2;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TipoDeJogo {
	
	private Button iniciarJogo, recordes, sair;
	private JButton botaoMenu1, botaoMenu2, botaoMenu3, botaoMenu4;
	private JFrame janelaEscolha;

	public TipoDeJogo(){
		
		// ======================== Label e Botões ============================
		JLabel label1 = new JLabel("Posições dos Barcos", null, JLabel.CENTER);
	    Dimension size = label1.getPreferredSize();
	    label1.setBounds(250, 20, 400, 200);       //(250, 20, 400, 200)*/
	    label1.setFont(label1.getFont().deriveFont(32.0f));
	    label1.setForeground(new Color(186, 66, 116)); //cor aleatória
	    
	    botaoMenu1 = new JButton("Aleatorio");
	    botaoMenu1.setBounds(250, 250, 400, 50);
	    botaoMenu1.setBackground(Color.PINK);
	    botaoMenu1.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		GameAleatorio ga = new GameAleatorio();
	    		janelaEscolha.setVisible(false);
	    	}
	    });
	    botaoMenu2 = new JButton("Escolher");
	    botaoMenu2.setBounds(250, 300, 400, 50);
	    botaoMenu2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		GameEscolher ge = new GameEscolher();
	    		janelaEscolha.setVisible(false);
	    	}
	    });
	    
	    botaoMenu3 = new JButton("Arquivo");
	    botaoMenu3.setBounds(250, 350, 400, 50);
	    botaoMenu3.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		GameArquivo ga = new GameArquivo();
	    		janelaEscolha.setVisible(false);
	    	}
	    });
	    
	    botaoMenu4 = new JButton("Voltar ao Menu");
	    botaoMenu4.setBounds(250, 400, 400, 50);
	    botaoMenu4.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		MenuPrincipal a = new MenuPrincipal();
	    		janelaEscolha.setVisible(false);
	    	}
	    });
		
		
	    //==================== Panel ============================
		JPanel panel1 = new JPanel(null);
		panel1.setForeground(new Color(128, 184, 205));
		panel1.add(label1);
		panel1.add(botaoMenu1);
		panel1.add(botaoMenu2);
		panel1.add(botaoMenu3);
		panel1.add(botaoMenu4);    
	    panel1.setVisible(true);
		
	    //=================== Janela =============================
	    janelaEscolha = new JFrame("Batalha Naval");
		janelaEscolha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaEscolha.setResizable(false);
		janelaEscolha.setSize(900,500);
		janelaEscolha.setForeground(new Color(128, 184, 205));		
		janelaEscolha.getContentPane().add(panel1);
		janelaEscolha.setVisible(true);

		
	}

}
