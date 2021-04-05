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
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FrameLogin {
	Connection connection = null;
	PreparedStatement info = null;
	ResultSet rs = null;

	private JFrame frame;
	private Image image_Exit = new ImageIcon(FrameLogin.class.getResource("image/close_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private final JLabel labelTitle = new JLabel("ĐĂNG NHẬP");
	private final JLabel labelUsername = new JLabel("Tài khoản:");
	private final JLabel labelPassword = new JLabel("Mật khẩu:");
	public static JTextField textUsername = new JTextField();
	public static JPasswordField textPassword = new JPasswordField();
	private final JButton loginButton = new JButton("Đăng nhập");
	private final JButton registryButton = new JButton("Đăng ký");
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
		frame =  new JFrame();
		frame.getContentPane().setBackground(new Color(220, 20, 60));
		frame.setUndecorated(true);
		frame.setBounds(500, 200, 450, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{156, 70, 90, 100};
		gridBagLayout.rowHeights = new int[]{20, 100, 35, 40, 35, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		GridBagConstraints gbc_header = new GridBagConstraints();
		gbc_header.fill = GridBagConstraints.BOTH;
		gbc_header.insets = new Insets(0, 0, 0, 0);
		gbc_header.gridwidth = 4;
		gbc_header.gridx = 0;
		gbc_header.gridy = 0;
		frame.getContentPane().add(header, gbc_header);
		header.setLayout(null);
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
		exitButton.setBounds(400, 0, 76, 20);
		exitButton.setBackground(Color.WHITE);
		exitButton.setBorder(null);
		exitButton.setContentAreaFilled(false);
		exitButton.setIcon(new ImageIcon(image_Exit));
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
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
		
		GridBagConstraints gbc_labelTitle = new GridBagConstraints();
		gbc_labelTitle.anchor = GridBagConstraints.SOUTHWEST;
		gbc_labelTitle.insets = new Insets(0, 0, 5, 5);
		gbc_labelTitle.gridwidth = 2;
		gbc_labelTitle.gridx = 1;
		gbc_labelTitle.gridy = 1;
		frame.getContentPane().add(labelTitle, gbc_labelTitle);
		labelTitle.setFont(new Font("Times New Roman", Font.BOLD, 26));
		labelTitle.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelUsername = new GridBagConstraints();
		gbc_labelUsername.anchor = GridBagConstraints.EAST;
		gbc_labelUsername.fill = GridBagConstraints.VERTICAL;
		gbc_labelUsername.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsername.gridx = 0;
		gbc_labelUsername.gridy = 2;
		frame.getContentPane().add(labelUsername, gbc_labelUsername);
		labelUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelUsername.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textUsername = new GridBagConstraints();
		gbc_textUsername.fill = GridBagConstraints.BOTH;
		gbc_textUsername.insets = new Insets(0, 0, 5, 0);
		gbc_textUsername.gridwidth = 2;
		gbc_textUsername.gridx = 1;
		gbc_textUsername.gridy = 2;
		frame.getContentPane().add(textUsername, gbc_textUsername);
		textUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textUsername.setColumns(10);
		textUsername.setBorder(null);
		
		GridBagConstraints gbc_labelPassword = new GridBagConstraints();
		gbc_labelPassword.anchor = GridBagConstraints.EAST;
		gbc_labelPassword.fill = GridBagConstraints.VERTICAL;
		gbc_labelPassword.insets = new Insets(0, 0, 5, 5);
		gbc_labelPassword.gridx = 0;
		gbc_labelPassword.gridy = 3;
		frame.getContentPane().add(labelPassword, gbc_labelPassword);
		labelPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelPassword.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textPassword = new GridBagConstraints();
		gbc_textPassword.fill = GridBagConstraints.BOTH;
		gbc_textPassword.insets = new Insets(0, 0, 10, 0);
		gbc_textPassword.gridwidth = 2;
		gbc_textPassword.gridx = 1;
		gbc_textPassword.gridy = 3;
		frame.getContentPane().add(textPassword, gbc_textPassword);
		textPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textPassword.setColumns(10);
		textPassword.setBorder(null);
		
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.fill = GridBagConstraints.BOTH;
		gbc_loginButton.insets = new Insets(0, 0, 0, 10);
		gbc_loginButton.gridx = 1;
		gbc_loginButton.gridy = 4;
		frame.getContentPane().add(loginButton, gbc_loginButton);
		loginButton.setFocusPainted(false);
		loginButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		loginButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textUsername.getText();
				String password = textPassword.getText();
				try {
					String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=BookingFilm;integratedSecurity=true;";
					connection = DriverManager.getConnection(connectionURL);
					info = connection.prepareStatement("Select username, password from information where username=? and password=?");
					info.setString(1, username);
                    info.setString(2, password);
                    rs = info.executeQuery();
                    if (rs.next()) {
                        frame.dispose();
                        FrameHomePage homepage = new FrameHomePage();
    					FrameHomePage.textUserName.setText(username);
    					homepage.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công!  ");
                    } else 
                    {
                        JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu!.\nVui lòng nhập lại!  ", "Login Error", JOptionPane.ERROR_MESSAGE);
                        textUsername.setText(null);
    					textPassword.setText(null);
                    }
				}
				catch (SQLException sqlException) {
                    sqlException.printStackTrace();
				}
				finally {
				    if (rs != null) {
				        try {
				            rs.close();
				        } catch (SQLException e1) { /* ignored */}
				    }
				    if (info != null) {
				        try {
				            info.close();
				        } catch (SQLException e1) { /* ignored */}
				    }
				    if (connection != null) {
				        try {
				            connection.close();
				        } catch (SQLException e1) { /* ignored */}
				    }
				}
			}
		});
		registryButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		GridBagConstraints gbc_registryButton = new GridBagConstraints();
		gbc_registryButton.anchor = GridBagConstraints.WEST;
		gbc_registryButton.fill = GridBagConstraints.VERTICAL;
		gbc_registryButton.gridx = 2;
		gbc_registryButton.gridy = 4;
		frame.getContentPane().add(registryButton, gbc_registryButton);
		registryButton.setFocusPainted(false);
		registryButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				registryButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				new FrameRegistry();
				FrameRegistry.frame.setVisible(true);
			}
		});
		
	}
}
