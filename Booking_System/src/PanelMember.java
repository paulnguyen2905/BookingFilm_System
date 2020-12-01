import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMember extends JPanel {
	private final JLabel lblNewLabel = new JLabel("MEMBER INFORMATION");

	//Create the panel.
	public PanelMember() {
		initGUI();
	}
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setBackground(new Color(205, 102, 102));
		setLayout(null);
		
		add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(50, 10, 306, 30);
		
	}

}
