import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class FrameLogin {

	private JFrame frame;
	private Image image_Exit = new ImageIcon(FrameLogin.class.getResource("image/close_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private final JLabel labelUsername = new JLabel("Username:");
	private final JLabel labelPassword = new JLabel("Password:");
	private final JTextField textUsername = new JTextField();
	private final JTextField textPassword = new JTextField();
	private final JButton loginButton = new JButton("Login");
	private final JButton exitButton = new JButton("");
	private final JPanel header = new JPanel();
	
	private int mouseX, mouseY;
	
	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin window = new FrameLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the application.
	public FrameLogin() {
		initialize();
	}
	
	public void setVisible(boolean input){
	    frame.setVisible(input);
	}

	//Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(220, 20, 60));
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 420, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(textUsername);
		textUsername.setBounds(179, 111, 169, 31);
		textUsername.setColumns(10);
		textUsername.setBorder(null);
		
		frame.getContentPane().add(textPassword);
		textPassword.setBounds(179, 150, 169, 31);
		textPassword.setColumns(10);
		textPassword.setBorder(null);
		
		frame.getContentPane().add(labelUsername);
		labelUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelUsername.setBounds(76, 109, 94, 31);
		labelUsername.setForeground(Color.BLACK);
		
		frame.getContentPane().add(labelPassword);
		labelPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelPassword.setBounds(76, 148, 99, 31);
		labelPassword.setForeground(Color.BLACK);
		
		frame.getContentPane().add(loginButton);
		loginButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		loginButton.setBounds(179, 191, 86, 35);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textUsername.getText();
				String password = textPassword.getText();
				if(username.contains("sameshit1398") && password.contains("hoangthien2905")) {
					frame.dispose();
					FrameHomePage homepage = new FrameHomePage();
					FrameHomePage.textUserName.setText(username);
					homepage.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong username or password.\nPlease try again!", "Login Error", 
					JOptionPane.ERROR_MESSAGE);
					textUsername.setText(null);
					textPassword.setText(null);
				}
			}
		});
		
		frame.getContentPane().add(header);
		header.setLayout(null);
		header.setBounds(0, 0, 420, 20);
		
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getX() + e.getX() - mouseX, frame.getY() + e.getY() - mouseY);
			}
		});
		header.addMouseListener(new MouseAdapter( ) {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		
		header.add(exitButton);
		exitButton.setBounds(400, 0, 20, 20);
		exitButton.setBackground(Color.WHITE);
		exitButton.setBorder(null);
		exitButton.setContentAreaFilled(false);
		exitButton.setIcon(new ImageIcon(image_Exit));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame fromLoginSystem = new JFrame("Exit");
				int confirmed = JOptionPane.showConfirmDialog(fromLoginSystem, "Are you sure you want to exit this application?", 
				"Login System", JOptionPane.YES_NO_OPTION);
				if (confirmed == JOptionPane.YES_OPTION)
					System.exit(0);
				else
					frame.setVisible(true);
			}
		});
		
	}
}
