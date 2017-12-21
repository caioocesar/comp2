package batalhaNaval2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaDePosicaoBarcos {
	
	private JFrame janelaPosicionar;
	private JButton[][] quadradinhos;
	
	
	
	public TelaDePosicaoBarcos(){
		
		JLabel label1 = new JLabel("Batalha Navaaal", null, JLabel.CENTER);
	    Dimension size = label1.getPreferredSize();
	    label1.setBounds(250, 20, 400, 200);       //(250, 20, 400, 200)*/
	    label1.setFont(label1.getFont().deriveFont(32.0f));
	    label1.setForeground(new Color(186, 66, 216));
	    JPanel panel1 = new JPanel(null);
	    panel1.add(label1);
	    janelaPosicionar = new JFrame("Batalha Naval");
	    janelaPosicionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaPosicionar.setResizable(false);
		janelaPosicionar.setSize(900,500);
		janelaPosicionar.setForeground(new Color(128, 184, 205));		
		janelaPosicionar.getContentPane().add(panel1);
		janelaPosicionar.setVisible(true);
	    
		
		
	}
	
	
}
