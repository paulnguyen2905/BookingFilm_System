import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class PanelTicket extends JPanel {
	private final JLabel lblNewLabel = new JLabel("YOUR TICKET");

	//Create the panel.
	public PanelTicket() {
		initGUI();
	}
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setLayout(null);
		setBackground(new Color(205, 102, 102));
		
		add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(50, 10, 177, 30);
		
	}
}
