import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrameRegistry extends JFrame {
	Connection connection = null;
	PreparedStatement info = null;
	ResultSet rs = null;
	
	private Image image_Exit = new ImageIcon(FrameRegistry.class.getResource("image/close_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	
	public static JFrame frame;
	private final JLabel labelTitle = new JLabel("ĐĂNG KÝ TÀI KHOẢN");
	private final JButton registryButton = new JButton("Đăng ký");
	private final JLabel labelUsername = new JLabel("Tên tài khoản:");
	private final JTextField textUsername = new JTextField("");
	private final JLabel labelPassword = new JLabel("Mật khẩu:");
	private final JTextField textPassword = new JTextField("");
	private final JLabel labelHoTen = new JLabel("Họ và tên:");
	private final JTextField textHoTen = new JTextField("");
	private final JLabel labelDOB = new JLabel("Ngày tháng năm sinh (định dạng: dd/mm/yyyy)");
	private final JTextField textDOB = new JTextField("");
	private final JLabel labelEmail = new JLabel("Địa chỉ Email:");
	private final JTextField textEmail = new JTextField("");
	private final JLabel labelSDT = new JLabel("Số điện thoại:");
	private final JTextField textSDT = new JTextField("");
	private final JPanel header = new JPanel();
	private final JButton exitButton = new JButton("");
	
	private JPanel contentPane;
	private int mouseX, mouseY;

	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameRegistry window = new FrameRegistry();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the frame.
	public FrameRegistry() {
		initGUI();
	}
	private void initGUI() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(550, 100, 440, 500);
		frame.getContentPane().setBackground(new Color(220, 20, 60));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{12, 120, 120, 12};
		gridBagLayout.rowHeights = new int[]{20, 45, 30, 30, 35, 30, 35, 30, 35, 30, 35, 30, 35, 30, 40, 5};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		GridBagConstraints gbc_header = new GridBagConstraints();
		gbc_header.fill = GridBagConstraints.VERTICAL;
		gbc_header.insets = new Insets(0, 0, 0, 0);
		gbc_header.gridwidth = 4;
		gbc_header.gridx = 0;
		gbc_header.gridy = 0;
		gbc_header.fill = GridBagConstraints.BOTH;
		frame.getContentPane().add(header, gbc_header);
		header.setBounds(0, 0, 1000, 20);
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
		exitButton.setBounds(390, 0, 76, 20);
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
				int confirmed = JOptionPane.showConfirmDialog(fromLoginSystem, "Bạn chắc có muốn thoát khỏi cửa sổ đăng ký không?", 
				"Thông báo", JOptionPane.YES_NO_OPTION);
				if (confirmed == JOptionPane.YES_OPTION)
					frame.setVisible(false);
				else
					frame.setVisible(true);
			}
		});
		
		GridBagConstraints gbc_labelTitle = new GridBagConstraints();
		gbc_labelTitle.anchor = GridBagConstraints.SOUTH;
		gbc_labelTitle.insets = new Insets(0, 0, 0, 0);
		gbc_labelTitle.gridwidth = 2;
		gbc_labelTitle.gridx = 1;
		gbc_labelTitle.gridy = 1;
		frame.getContentPane().add(labelTitle, gbc_labelTitle);
		labelTitle.setFont(new Font("Times New Roman", Font.BOLD, 26));
		labelTitle.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelUsername = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_labelUsername.anchor = GridBagConstraints.SOUTHWEST;
		gbc_labelUsername.insets = new Insets(0, 0, 0, 0);
		gbc_labelUsername.gridwidth = 2;
		gbc_labelUsername.gridx = 1;
		gbc_labelUsername.gridy = 2;
		frame.getContentPane().add(labelUsername, gbc_labelUsername);
		labelUsername.setForeground(Color.BLACK);
		labelUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		GridBagConstraints gbc_textUsername = new GridBagConstraints();
		gbc_textUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsername.insets = new Insets(0, 0, 0, 0);
		gbc_textUsername.gridwidth = 2;
		gbc_textUsername.gridx = 1;
		gbc_textUsername.gridy = 3;
		frame.getContentPane().add(textUsername, gbc_textUsername);
		textUsername.setForeground(Color.BLACK);
		textUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_labelPassword = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_labelPassword.anchor = GridBagConstraints.SOUTH;
		gbc_labelPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelPassword.insets = new Insets(0, 0, 0, 0);
		gbc_labelPassword.gridwidth = 2;
		gbc_labelPassword.gridx = 1;
		gbc_labelPassword.gridy = 4;
		frame.getContentPane().add(labelPassword, gbc_labelPassword);
		labelPassword.setForeground(Color.BLACK);
		labelPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_textPassword = new GridBagConstraints();
		gbc_textPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPassword.insets = new Insets(0, 0, 0, 0);
		gbc_textPassword.gridwidth = 2;
		gbc_textPassword.gridx = 1;
		gbc_textPassword.gridy = 5;
		frame.getContentPane().add(textPassword, gbc_textPassword);
		textPassword.setForeground(Color.BLACK);
		textPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_labelHoTen = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_labelHoTen.anchor = GridBagConstraints.SOUTH;
		gbc_labelHoTen.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelHoTen.insets = new Insets(0, 0, 0, 0);
		gbc_labelHoTen.gridwidth = 2;
		gbc_labelHoTen.gridx = 1;
		gbc_labelHoTen.gridy = 6;
		frame.getContentPane().add(labelHoTen, gbc_labelHoTen);
		labelHoTen.setForeground(Color.BLACK);
		labelHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_textHoTen = new GridBagConstraints();
		gbc_textHoTen.fill = GridBagConstraints.HORIZONTAL;
		gbc_textHoTen.insets = new Insets(0, 0, 0, 0);
		gbc_textHoTen.gridwidth = 2;
		gbc_textHoTen.gridx = 1;
		gbc_textHoTen.gridy = 7;
		frame.getContentPane().add(textHoTen, gbc_textHoTen);
		textHoTen.setForeground(Color.BLACK);
		textHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_labelDOB = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_labelDOB.anchor = GridBagConstraints.SOUTH;
		gbc_labelDOB.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelDOB.insets = new Insets(0, 0, 0, 0);
		gbc_labelDOB.gridwidth = 2;
		gbc_labelDOB.gridx = 1;
		gbc_labelDOB.gridy = 8;
		frame.getContentPane().add(labelDOB, gbc_labelDOB);
		labelDOB.setForeground(Color.BLACK);
		labelDOB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_textDOB = new GridBagConstraints();
		gbc_textDOB.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDOB.insets = new Insets(0, 0, 0, 0);
		gbc_textDOB.gridwidth = 2;
		gbc_textDOB.gridx = 1;
		gbc_textDOB.gridy = 9;
		frame.getContentPane().add(textDOB, gbc_textDOB);
		textDOB.setForeground(Color.BLACK);
		textDOB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_labelEmail = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_labelEmail.anchor = GridBagConstraints.SOUTH;
		gbc_labelEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelEmail.insets = new Insets(0, 0, 0, 0);
		gbc_labelEmail.gridwidth = 2;
		gbc_labelEmail.gridx = 1;
		gbc_labelEmail.gridy = 10;
		frame.getContentPane().add(labelEmail, gbc_labelEmail);
		labelEmail.setForeground(Color.BLACK);
		labelEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.insets = new Insets(0, 0, 0, 0);
		gbc_textEmail.gridwidth = 2;
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 11;
		frame.getContentPane().add(textEmail, gbc_textEmail);
		textEmail.setForeground(Color.BLACK);
		textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	
		GridBagConstraints gbc_labelSDT = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_labelSDT.anchor = GridBagConstraints.SOUTH;
		gbc_labelSDT.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelSDT.insets = new Insets(0, 0, 0, 0);
		gbc_labelSDT.gridwidth = 2;
		gbc_labelSDT.gridx = 1;
		gbc_labelSDT.gridy = 12;
		frame.getContentPane().add(labelSDT, gbc_labelSDT);
		labelSDT.setForeground(Color.BLACK);
		labelSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	
		GridBagConstraints gbc_textSDT = new GridBagConstraints();
		gbc_textSDT.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSDT.insets = new Insets(0, 0, 0, 0);
		gbc_textSDT.gridwidth = 2;
		gbc_textSDT.gridx = 1;
		gbc_textSDT.gridy = 13;
		frame.getContentPane().add(textSDT, gbc_textSDT);
		textSDT.setForeground(Color.BLACK);
		textSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_registryButton = new GridBagConstraints();
		gbc_registryButton.anchor = GridBagConstraints.SOUTHWEST;
		gbc_registryButton.insets = new Insets(0, 12, 0, 0);
		gbc_registryButton.gridx = 2;
		gbc_registryButton.gridy = 14;
		frame.getContentPane().add(registryButton, gbc_registryButton);
		registryButton.setFont(new Font("Times New Roman", Font.BOLD, 21));
		registryButton.setFocusPainted(false);
		registryButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				registryButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(textUsername.getText().equals("") || textPassword.getText().equals("") || textHoTen.getText().equals("") || textDOB.getText().equals("") || textEmail.getText().equals("") || textSDT.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!   ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
				else {
					try {
						String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=BookingFilm;integratedSecurity=true;";
						connection = DriverManager.getConnection(connectionURL);
	                    info = connection.prepareStatement("Insert into information (name, username, password, email, phone, dob) values (?, ?, ?, ?, ?, ?)");
	                    info.setString(1, textHoTen.getText());
	                    info.setString(2, textUsername.getText());
	                    info.setString(3, textPassword.getText());
	                    info.setString(4, textEmail.getText());
	                    info.setString(5, textSDT.getText());
	                    info.setString(6, textDOB.getText());
	                    info.executeUpdate();
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
					frame.setVisible(false);
					JOptionPane.showMessageDialog(null, "Đăng ký tài khoản thành công!  ");
				}
			}
		});
	}

}
