package batalhaNaval2;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuPrincipal implements ActionListener {
	
	private Button iniciarJogo, recordes, sair;
	private JButton botaoMenu1, botaoMenu2, botaoMenu3, botaoMenu4;
	private JFrame janelaMenu;
	
	public MenuPrincipal(){

		//------------------Label e botões-------------------	
	    JLabel label1 = new JLabel("Batalha Navaaal", null, JLabel.CENTER);
	    Dimension size = label1.getPreferredSize();
	    label1.setBounds(250, 20, 400, 200);       //(250, 20, 400, 200)*/
	    label1.setFont(label1.getFont().deriveFont(32.0f));
	    label1.setForeground(new Color(186, 66, 216));
	    botaoMenu1 = new JButton("Start Game");
	    botaoMenu2 = new JButton("Recordes");
	    botaoMenu3 = new JButton("Instruções");
	    botaoMenu4 = new JButton("Sair");
	    botaoMenu1.addActionListener(this);
	    botaoMenu2.addActionListener(this);
	    botaoMenu3.addActionListener(this);
	    botaoMenu4.addActionListener(this);
	    botaoMenu1.setBounds(250, 250, 400, 50);
	    botaoMenu2.setBounds(250, 300, 400, 50);
	    botaoMenu3.setBounds(250, 350, 400, 50);
	    botaoMenu4.setBounds(250, 400, 400, 50);
	   
	    //-------------------Panel ---------------------------
	    JPanel panel1 = new JPanel(null);
		panel1.setForeground(new Color(128, 184, 205));
		panel1.add(label1);
		panel1.add(botaoMenu1);
		panel1.add(botaoMenu2);
		panel1.add(botaoMenu3);
		panel1.add(botaoMenu4);    
	    panel1.setVisible(true);
	    
	    //-------------------------- Janela	----------------------------
	    janelaMenu = new JFrame("Batalha Naval");
		janelaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaMenu.setResizable(false);
		janelaMenu.setSize(900,500);
		janelaMenu.setForeground(new Color(128, 184, 205));		
		janelaMenu.getContentPane().add(panel1);
		janelaMenu.setVisible(true);
	
	} //Fim do construtor
	
		
	//Action Listener botões Menu
	public void actionPerformed(ActionEvent w) {
		Object object = w.getSource();
		if(object == botaoMenu1){
			janelaMenu.setVisible(false);
			TipoDeJogo b = new TipoDeJogo();
		}
		else if(object == botaoMenu2){
			JOptionPane.showInputDialog(this,"recordes");
		}
		else if(object == botaoMenu3){
			JOptionPane.showInputDialog(this,"instrunçoes");
		}
		else if(object == botaoMenu4){
			System.exit(0);
		}
		
	}

	
	public static void main(String [] args){
		MenuPrincipal a = new MenuPrincipal();
	}

}
