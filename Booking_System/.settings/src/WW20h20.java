import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import java.awt.event.MouseAdapter;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class WW20h20 extends JPanel {
	Connection connection = null;
	PreparedStatement info = null;
	ResultSet rs = null;
	
	private Image image_Back = new ImageIcon(WW20h20.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_nextButton = new ImageIcon(WW20h20.class.getResource("image/nextButton_icon.png")).getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
	private Image image_Screen = new ImageIcon(WW20h20.class.getResource("image/screenTopView_icon.png")).getImage().getScaledInstance(520, 160, Image.SCALE_SMOOTH);
	
	private final JLabel labelTitle = new JLabel("Đặt vé online - Chọn ghế");
	private final JButton buttonBack = new JButton("");
	private final JButton buttonNext = new JButton("");
	private final JPanel contentPane = new JPanel();
	private final JLabel imageScreen = new JLabel("");
	private final JLabel screenNote = new JLabel("Screen");
	private final JTextArea noteFilm = new JTextArea("");
	
	public static CardLayout cardLayout = new CardLayout();
	public static JPanel firstPane = new JPanel();
	public static JPanel homePane = new JPanel();
	
	public static JToggleButton seatA1 = new JToggleButton("A1");
	public static JToggleButton seatA2 = new JToggleButton("A2");
	public static JToggleButton seatA3 = new JToggleButton("A3");
	public static JToggleButton seatA4 = new JToggleButton("A4");
	public static JToggleButton seatA5 = new JToggleButton("A5");
	public static JToggleButton seatA6 = new JToggleButton("A6");
	public static JToggleButton seatA7 = new JToggleButton("A7");
	public static JToggleButton seatA8 = new JToggleButton("A8");
	public static JToggleButton seatB1 = new JToggleButton("B1");
	public static JToggleButton seatB2 = new JToggleButton("B2");
	public static JToggleButton seatB3 = new JToggleButton("B3");
	public static JToggleButton seatB4 = new JToggleButton("B4");
	public static JToggleButton seatB5 = new JToggleButton("B5");
	public static JToggleButton seatB6 = new JToggleButton("B6");
	public static JToggleButton seatB7 = new JToggleButton("B7");
	public static JToggleButton seatB8 = new JToggleButton("B8");
	public static JToggleButton seatC1 = new JToggleButton("C1");
	public static JToggleButton seatC2 = new JToggleButton("C2");
	public static JToggleButton seatC3 = new JToggleButton("C3");
	public static JToggleButton seatC4 = new JToggleButton("C4");
	public static JToggleButton seatC5 = new JToggleButton("C5");
	public static JToggleButton seatC6 = new JToggleButton("C6");
	public static JToggleButton seatC7 = new JToggleButton("C7");
	public static JToggleButton seatC8 = new JToggleButton("C8");
	public static JToggleButton seatD1 = new JToggleButton("D1");
	public static JToggleButton seatD2 = new JToggleButton("D2");
	public static JToggleButton seatD3 = new JToggleButton("D3");
	public static JToggleButton seatD4 = new JToggleButton("D4");
	public static JToggleButton seatD5 = new JToggleButton("D5");
	public static JToggleButton seatD6 = new JToggleButton("D6");
	public static JToggleButton seatD7 = new JToggleButton("D7");
	public static JToggleButton seatD8 = new JToggleButton("D8");
	public static JToggleButton seatE1 = new JToggleButton("E1");
	public static JToggleButton seatE2 = new JToggleButton("E2");
	public static JToggleButton seatE3 = new JToggleButton("E3");
	public static JToggleButton seatE4 = new JToggleButton("E4");
	public static JToggleButton seatE5 = new JToggleButton("E5");
	public static JToggleButton seatE6 = new JToggleButton("E6");
	public static JToggleButton seatE7 = new JToggleButton("E7");
	public static JToggleButton seatE8 = new JToggleButton("E8");
	
	public static ArrayList<String> str = new ArrayList<String>();
	public static int countSeatWW20h20 = 0;
	ArrayList<JToggleButton> buttons = new ArrayList<JToggleButton>();
	ArrayList<JToggleButton> seats = new ArrayList<JToggleButton>();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	
	//Create the panel.
	public WW20h20() {
		initGUI();
		updateSeat();
	}
	
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setBackground(new Color(205, 102, 102));
		setLayout(null);

		firstPane.setBounds(0 , 0, 747, 580);
		firstPane.setBackground(new Color(205, 102, 102));
		firstPane.setLayout(null);
		
		add(homePane);
		homePane.setBounds(0 , 0, 747, 580);
		homePane.setLayout(null);
		homePane.setBackground(new Color(205, 102, 102));
		
		homePane.setLayout(cardLayout);
		homePane.add(firstPane, "0");
		cardLayout.show(homePane, "0");
		
		firstPane.add(labelTitle);
		labelTitle.setBounds(54, 8, 481, 35);
		labelTitle.setForeground(new Color(0, 0, 0));
		labelTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));;
		
		firstPane.add(buttonBack);
		buttonBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});	
		buttonBack.setBackground(new Color(205, 102, 102));
		buttonBack.setBorder(null);
		buttonBack.setBounds(10, 10, 32, 26);
		buttonBack.setIcon(new ImageIcon(image_Back));
		
		firstPane.add(contentPane);
		contentPane.setBounds(0 , 0, 747, 580);
		contentPane.setBackground(new Color(205, 102, 102));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{64, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60};
		gbl_contentPane.rowHeights = new int[]{30, 60, 60, 60, 60, 60, 60, 60, 60};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		GridBagConstraints gbc_imageScreen = new GridBagConstraints();
		gbc_imageScreen.insets = new Insets(0, 0, 5, 5);
		gbc_imageScreen.gridwidth = 10;
		gbc_imageScreen.gridx = 1;
		gbc_imageScreen.gridy = 1;
		contentPane.add(imageScreen, gbc_imageScreen);
		imageScreen.setIcon(new ImageIcon(image_Screen));
		
		GridBagConstraints gbc_screenNote = new GridBagConstraints();
		gbc_screenNote.insets = new Insets(0, 0, -20, 0);
		gbc_screenNote.gridwidth = 10;
		gbc_screenNote.gridx = 1;
		gbc_screenNote.gridy = 1;
		screenNote.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(screenNote, gbc_screenNote);
		
		
		GridBagConstraints gbc_noteFilm = new GridBagConstraints();
		gbc_noteFilm.anchor = GridBagConstraints.WEST;
		gbc_noteFilm.insets = new Insets(0, 0, 0, 5);
		gbc_noteFilm.gridwidth = 7;
		gbc_noteFilm.gridx = 2;
		gbc_noteFilm.gridy = 7;
		contentPane.add(noteFilm, gbc_noteFilm);
		noteFilm.setEditable(false);
		noteFilm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		noteFilm.setForeground(Color.BLACK);
		noteFilm.setBackground(new Color(205, 102, 102));
		noteFilm.setText("Tên phim: Wonder Woman: Nữ thần chiến binh"
				+ "\nSuất chiếu: 20h20, ngày " + dateFormat.format(date));
		
		GridBagConstraints gbc_seatA1 = new GridBagConstraints();
		gbc_seatA1.insets = new Insets(0, 0, 5, 5);
		gbc_seatA1.fill = GridBagConstraints.BOTH;
		gbc_seatA1.gridx = 2;
		gbc_seatA1.gridy = 2;
		contentPane.add(seatA1, gbc_seatA1);
		seatA1.setFocusPainted(false);
		seatA1.setForeground(Color.BLACK);
		seatA1.setBackground(new Color(240, 240, 240));
		seatA1.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatA1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatA1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatA1.isSelected()) {
					seatA1.setContentAreaFilled(false);
					seatA1.setOpaque(true);
					seatA1.setBackground(new Color(220, 20, 60));
				}
				else {
					seatA1.setForeground(Color.BLACK);
					seatA1.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatA2 = new GridBagConstraints();
		gbc_seatA2.insets = new Insets(0, 0, 5, 5);
		gbc_seatA2.fill = GridBagConstraints.BOTH;
		gbc_seatA2.gridx = 3;
		gbc_seatA2.gridy = 2;
		contentPane.add(seatA2, gbc_seatA2);
		seatA2.setFocusPainted(false);
		seatA2.setForeground(Color.BLACK);
		seatA2.setBackground(new Color(240, 240, 240));
		seatA2.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatA2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatA2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatA2.isSelected()) {
					seatA2.setContentAreaFilled(false);
					seatA2.setOpaque(true);
					seatA2.setBackground(new Color(220, 20, 60));
				}
				else {
					seatA2.setForeground(Color.BLACK);
					seatA2.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatA3 = new GridBagConstraints();
		gbc_seatA3.insets = new Insets(0, 0, 5, 5);
		gbc_seatA3.fill = GridBagConstraints.BOTH;
		gbc_seatA3.gridx = 4;
		gbc_seatA3.gridy = 2;
		contentPane.add(seatA3, gbc_seatA3);
		seatA3.setFocusPainted(false);
		seatA3.setForeground(Color.BLACK);
		seatA3.setBackground(new Color(240, 240, 240));
		seatA3.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatA3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatA3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatA3.isSelected()) {
					seatA3.setContentAreaFilled(false);
					seatA3.setOpaque(true);
					seatA3.setBackground(new Color(220, 20, 60));
				}
				else {
					seatA3.setForeground(Color.BLACK);
					seatA3.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatA4 = new GridBagConstraints();
		gbc_seatA4.insets = new Insets(0, 0, 5, 5);
		gbc_seatA4.fill = GridBagConstraints.BOTH;
		gbc_seatA4.gridx = 5;
		gbc_seatA4.gridy = 2;
		contentPane.add(seatA4, gbc_seatA4);
		seatA4.setFocusPainted(false);
		seatA4.setForeground(Color.BLACK);
		seatA4.setBackground(new Color(240, 240, 240));
		seatA4.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatA4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatA4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatA4.isSelected()) {
					seatA4.setContentAreaFilled(false);
					seatA4.setOpaque(true);
					seatA4.setBackground(new Color(220, 20, 60));
				}
				else {
					seatA4.setForeground(Color.BLACK);
					seatA4.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatA5 = new GridBagConstraints();
		gbc_seatA5.insets = new Insets(0, 0, 5, 5);
		gbc_seatA5.fill = GridBagConstraints.BOTH;
		gbc_seatA5.gridx = 6;
		gbc_seatA5.gridy = 2;
		contentPane.add(seatA5, gbc_seatA5);
		seatA5.setFocusPainted(false);
		seatA5.setForeground(Color.BLACK);
		seatA5.setBackground(new Color(240, 240, 240));
		seatA5.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatA5.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatA5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatA5.isSelected()) {
					seatA5.setContentAreaFilled(false);
					seatA5.setOpaque(true);
					seatA5.setBackground(new Color(220, 20, 60));
				}
				else {
					seatA5.setForeground(Color.BLACK);
					seatA5.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatA6 = new GridBagConstraints();
		gbc_seatA6.insets = new Insets(0, 0, 5, 5);
		gbc_seatA6.fill = GridBagConstraints.BOTH;
		gbc_seatA6.gridx = 7;
		gbc_seatA6.gridy = 2;
		contentPane.add(seatA6, gbc_seatA6);
		seatA6.setFocusPainted(false);
		seatA6.setForeground(Color.BLACK);
		seatA6.setBackground(new Color(240, 240, 240));
		seatA6.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatA6.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatA6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatA6.isSelected()) {
					seatA6.setContentAreaFilled(false);
					seatA6.setOpaque(true);
					seatA6.setBackground(new Color(220, 20, 60));
				}
				else {
					seatA6.setForeground(Color.BLACK);
					seatA6.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatA7 = new GridBagConstraints();
		gbc_seatA7.insets = new Insets(0, 0, 5, 5);
		gbc_seatA7.fill = GridBagConstraints.BOTH;
		gbc_seatA7.gridx = 8;
		gbc_seatA7.gridy = 2;
		contentPane.add(seatA7, gbc_seatA7);
		seatA7.setFocusPainted(false);
		seatA7.setForeground(Color.BLACK);
		seatA7.setBackground(new Color(240, 240, 240));
		seatA7.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatA7.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatA7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatA7.isSelected()) {
					seatA7.setContentAreaFilled(false);
					seatA7.setOpaque(true);
					seatA7.setBackground(new Color(220, 20, 60));
				}
				else {
					seatA7.setForeground(Color.BLACK);
					seatA7.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatA8 = new GridBagConstraints();
		gbc_seatA8.insets = new Insets(0, 0, 5, 5);
		gbc_seatA8.fill = GridBagConstraints.BOTH;
		gbc_seatA8.gridx = 9;
		gbc_seatA8.gridy = 2;
		contentPane.add(seatA8, gbc_seatA8);
		seatA8.setFocusPainted(false);
		seatA8.setForeground(Color.BLACK);
		seatA8.setBackground(new Color(240, 240, 240));
		seatA8.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatA8.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatA8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatA8.isSelected()) {
					seatA8.setContentAreaFilled(false);
					seatA8.setOpaque(true);
					seatA8.setBackground(new Color(220, 20, 60));
				}
				else {
					seatA8.setForeground(Color.BLACK);
					seatA8.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatB1 = new GridBagConstraints();
		gbc_seatB1.insets = new Insets(0, 0, 5, 5);
		gbc_seatB1.fill = GridBagConstraints.BOTH;
		gbc_seatB1.gridx = 2;
		gbc_seatB1.gridy = 3;
		contentPane.add(seatB1, gbc_seatB1);
		seatB1.setFocusPainted(false);
		seatB1.setForeground(Color.BLACK);
		seatB1.setBackground(new Color(240, 240, 240));
		seatB1.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatB1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatB1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatB1.isSelected()) {
					seatB1.setContentAreaFilled(false);
					seatB1.setOpaque(true);
					seatB1.setBackground(new Color(220, 20, 60));
				}
				else {
					seatB1.setForeground(Color.BLACK);
					seatB1.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatB2 = new GridBagConstraints();
		gbc_seatB2.insets = new Insets(0, 0, 5, 5);
		gbc_seatB2.fill = GridBagConstraints.BOTH;
		gbc_seatB2.gridx = 3;
		gbc_seatB2.gridy = 3;
		contentPane.add(seatB2, gbc_seatB2);
		seatB2.setFocusPainted(false);
		seatB2.setForeground(Color.BLACK);
		seatB2.setBackground(new Color(240, 240, 240));
		seatB2.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatB2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatB2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatB2.isSelected()) {
					seatB2.setContentAreaFilled(false);
					seatB2.setOpaque(true);
					seatB2.setBackground(new Color(220, 20, 60));
				}
				else {
					seatB2.setForeground(Color.BLACK);
					seatB2.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatB3 = new GridBagConstraints();
		gbc_seatB3.insets = new Insets(0, 0, 5, 5);
		gbc_seatB3.fill = GridBagConstraints.BOTH;
		gbc_seatB3.gridx = 4;
		gbc_seatB3.gridy = 3;
		contentPane.add(seatB3, gbc_seatB3);
		seatB3.setFocusPainted(false);
		seatB3.setForeground(Color.BLACK);
		seatB3.setBackground(new Color(240, 240, 240));
		seatB3.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatB3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatB3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatB3.isSelected()) {
					seatB3.setContentAreaFilled(false);
					seatB3.setOpaque(true);
					seatB3.setBackground(new Color(220, 20, 60));
				}
				else {
					seatB3.setForeground(Color.BLACK);
					seatB3.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatB4 = new GridBagConstraints();
		gbc_seatB4.insets = new Insets(0, 0, 5, 5);
		gbc_seatB4.fill = GridBagConstraints.BOTH;
		gbc_seatB4.gridx = 5;
		gbc_seatB4.gridy = 3;
		contentPane.add(seatB4, gbc_seatB4);
		seatB4.setFocusPainted(false);
		seatB4.setForeground(Color.BLACK);
		seatB4.setBackground(new Color(240, 240, 240));
		seatB4.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatB4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatB4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatB4.isSelected()) {
					seatB4.setContentAreaFilled(false);
					seatB4.setOpaque(true);
					seatB4.setBackground(new Color(220, 20, 60));
				}
				else {
					seatB4.setForeground(Color.BLACK);
					seatB4.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatB5 = new GridBagConstraints();
		gbc_seatB5.insets = new Insets(0, 0, 5, 5);
		gbc_seatB5.fill = GridBagConstraints.BOTH;
		gbc_seatB5.gridx = 6;
		gbc_seatB5.gridy = 3;
		contentPane.add(seatB5, gbc_seatB5);
		seatB5.setFocusPainted(false);
		seatB5.setForeground(Color.BLACK);
		seatB5.setBackground(new Color(240, 240, 240));
		seatB5.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatB5.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatB5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatB5.isSelected()) {
					seatB5.setContentAreaFilled(false);
					seatB5.setOpaque(true);
					seatB5.setBackground(new Color(220, 20, 60));
				}
				else {
					seatB5.setForeground(Color.BLACK);
					seatB5.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatB6 = new GridBagConstraints();
		gbc_seatB6.insets = new Insets(0, 0, 5, 5);
		gbc_seatB6.fill = GridBagConstraints.BOTH;
		gbc_seatB6.gridx = 7;
		gbc_seatB6.gridy = 3;
		contentPane.add(seatB6, gbc_seatB6);
		seatB6.setFocusPainted(false);
		seatB6.setForeground(Color.BLACK);
		seatB6.setBackground(new Color(240, 240, 240));
		seatB6.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatB6.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatB6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatB6.isSelected()) {
					seatB6.setContentAreaFilled(false);
					seatB6.setOpaque(true);
					seatB6.setBackground(new Color(220, 20, 60));
				}
				else {
					seatB6.setForeground(Color.BLACK);
					seatB6.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatB7 = new GridBagConstraints();
		gbc_seatB7.insets = new Insets(0, 0, 5, 5);
		gbc_seatB7.fill = GridBagConstraints.BOTH;
		gbc_seatB7.gridx = 8;
		gbc_seatB7.gridy = 3;
		contentPane.add(seatB7, gbc_seatB7);
		seatB7.setFocusPainted(false);
		seatB7.setForeground(Color.BLACK);
		seatB7.setBackground(new Color(240, 240, 240));
		seatB7.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatB7.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatB7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatB7.isSelected()) {
					seatB7.setContentAreaFilled(false);
					seatB7.setOpaque(true);
					seatB7.setBackground(new Color(220, 20, 60));
				}
				else {
					seatB7.setForeground(Color.BLACK);
					seatB7.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatB8 = new GridBagConstraints();
		gbc_seatB8.insets = new Insets(0, 0, 5, 5);
		gbc_seatB8.fill = GridBagConstraints.BOTH;
		gbc_seatB8.gridx = 9;
		gbc_seatB8.gridy = 3;
		contentPane.add(seatB8, gbc_seatB8);
		seatB8.setFocusPainted(false);
		seatB8.setForeground(Color.BLACK);
		seatB8.setBackground(new Color(240, 240, 240));
		seatB8.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatB8.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatB8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatB8.isSelected()) {
					seatB8.setContentAreaFilled(false);
					seatB8.setOpaque(true);
					seatB8.setBackground(new Color(220, 20, 60));
				}
				else {
					seatB8.setForeground(Color.BLACK);
					seatB8.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatC1 = new GridBagConstraints();
		gbc_seatC1.insets = new Insets(0, 0, 5, 5);
		gbc_seatC1.fill = GridBagConstraints.BOTH;
		gbc_seatC1.gridx = 2;
		gbc_seatC1.gridy = 4;
		contentPane.add(seatC1, gbc_seatC1);
		seatC1.setFocusPainted(false);
		seatC1.setForeground(Color.BLACK);
		seatC1.setBackground(new Color(240, 240, 240));
		seatC1.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatC1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatC1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatC1.isSelected()) {
					seatC1.setContentAreaFilled(false);
					seatC1.setOpaque(true);
					seatC1.setBackground(new Color(220, 20, 60));
				}
				else {
					seatC1.setForeground(Color.BLACK);
					seatC1.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatC2 = new GridBagConstraints();
		gbc_seatC2.insets = new Insets(0, 0, 5, 5);
		gbc_seatC2.fill = GridBagConstraints.BOTH;
		gbc_seatC2.gridx = 3;
		gbc_seatC2.gridy = 4;
		contentPane.add(seatC2, gbc_seatC2);
		seatC2.setFocusPainted(false);
		seatC2.setForeground(Color.BLACK);
		seatC2.setBackground(new Color(240, 240, 240));
		seatC2.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatC2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatC2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatC2.isSelected()) {
					seatC2.setContentAreaFilled(false);
					seatC2.setOpaque(true);
					seatC2.setBackground(new Color(220, 20, 60));
				}
				else {
					seatC2.setForeground(Color.BLACK);
					seatC2.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatC3 = new GridBagConstraints();
		gbc_seatC3.insets = new Insets(0, 0, 5, 5);
		gbc_seatC3.fill = GridBagConstraints.BOTH;
		gbc_seatC3.gridx = 4;
		gbc_seatC3.gridy = 4;
		contentPane.add(seatC3, gbc_seatC3);
		seatC3.setFocusPainted(false);
		seatC3.setForeground(Color.BLACK);
		seatC3.setBackground(new Color(240, 240, 240));
		seatC3.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatC3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatC3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatC3.isSelected()) {
					seatC3.setContentAreaFilled(false);
					seatC3.setOpaque(true);
					seatC3.setBackground(new Color(220, 20, 60));
				}
				else {
					seatC3.setForeground(Color.BLACK);
					seatC3.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatC4 = new GridBagConstraints();
		gbc_seatC4.insets = new Insets(0, 0, 5, 5);
		gbc_seatC4.fill = GridBagConstraints.BOTH;
		gbc_seatC4.gridx = 5;
		gbc_seatC4.gridy = 4;
		contentPane.add(seatC4, gbc_seatC4);
		seatC4.setFocusPainted(false);
		seatC4.setForeground(Color.BLACK);
		seatC4.setBackground(new Color(240, 240, 240));
		seatC4.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatC4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatC4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatC4.isSelected()) {
					seatC4.setContentAreaFilled(false);
					seatC4.setOpaque(true);
					seatC4.setBackground(new Color(220, 20, 60));
				}
				else {
					seatC4.setForeground(Color.BLACK);
					seatC4.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatC5 = new GridBagConstraints();
		gbc_seatC5.insets = new Insets(0, 0, 5, 5);
		gbc_seatC5.fill = GridBagConstraints.BOTH;
		gbc_seatC5.gridx = 6;
		gbc_seatC5.gridy = 4;
		contentPane.add(seatC5, gbc_seatC5);
		seatC5.setFocusPainted(false);
		seatC5.setForeground(Color.BLACK);
		seatC5.setBackground(new Color(240, 240, 240));
		seatC5.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatC5.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatC5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatC5.isSelected()) {
					seatC5.setContentAreaFilled(false);
					seatC5.setOpaque(true);
					seatC5.setBackground(new Color(220, 20, 60));
				}
				else {
					seatC5.setForeground(Color.BLACK);
					seatC5.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatC6 = new GridBagConstraints();
		gbc_seatC6.insets = new Insets(0, 0, 5, 5);
		gbc_seatC6.fill = GridBagConstraints.BOTH;
		gbc_seatC6.gridx = 7;
		gbc_seatC6.gridy = 4;
		contentPane.add(seatC6, gbc_seatC6);
		seatC6.setFocusPainted(false);
		seatC6.setForeground(Color.BLACK);
		seatC6.setBackground(new Color(240, 240, 240));
		seatC6.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatC6.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatC6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatC6.isSelected()) {
					seatC6.setContentAreaFilled(false);
					seatC6.setOpaque(true);
					seatC6.setBackground(new Color(220, 20, 60));
				}
				else {
					seatC6.setForeground(Color.BLACK);
					seatC6.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatC7 = new GridBagConstraints();
		gbc_seatC7.insets = new Insets(0, 0, 5, 5);
		gbc_seatC7.fill = GridBagConstraints.BOTH;
		gbc_seatC7.gridx = 8;
		gbc_seatC7.gridy = 4;
		contentPane.add(seatC7, gbc_seatC7);
		seatC7.setFocusPainted(false);
		seatC7.setForeground(Color.BLACK);
		seatC7.setBackground(new Color(240, 240, 240));
		seatC7.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatC7.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatC7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatC7.isSelected()) {
					seatC7.setContentAreaFilled(false);
					seatC7.setOpaque(true);
					seatC7.setBackground(new Color(220, 20, 60));
				}
				else {
					seatC7.setForeground(Color.BLACK);
					seatC7.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatC8 = new GridBagConstraints();
		gbc_seatC8.insets = new Insets(0, 0, 5, 5);
		gbc_seatC8.fill = GridBagConstraints.BOTH;
		gbc_seatC8.gridx = 9;
		gbc_seatC8.gridy = 4;
		contentPane.add(seatC8, gbc_seatC8);
		seatC8.setFocusPainted(false);
		seatC8.setForeground(Color.BLACK);
		seatC8.setBackground(new Color(240, 240, 240));
		seatC8.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatC8.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatC8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatC8.isSelected()) {
					seatC8.setContentAreaFilled(false);
					seatC8.setOpaque(true);
					seatC8.setBackground(new Color(220, 20, 60));
				}
				else {
					seatC8.setForeground(Color.BLACK);
					seatC8.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatD1 = new GridBagConstraints();
		gbc_seatD1.insets = new Insets(0, 0, 5, 5);
		gbc_seatD1.fill = GridBagConstraints.BOTH;
		gbc_seatD1.gridx = 2;
		gbc_seatD1.gridy = 5;
		contentPane.add(seatD1, gbc_seatD1);
		seatD1.setFocusPainted(false);
		seatD1.setForeground(Color.BLACK);
		seatD1.setBackground(new Color(240, 240, 240));
		seatD1.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatD1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatD1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatD1.isSelected()) {
					seatD1.setContentAreaFilled(false);
					seatD1.setOpaque(true);
					seatD1.setBackground(new Color(220, 20, 60));
				}
				else {
					seatD1.setForeground(Color.BLACK);
					seatD1.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatD2 = new GridBagConstraints();
		gbc_seatD2.insets = new Insets(0, 0, 5, 5);
		gbc_seatD2.fill = GridBagConstraints.BOTH;
		gbc_seatD2.gridx = 3;
		gbc_seatD2.gridy = 5;
		contentPane.add(seatD2, gbc_seatD2);
		seatD2.setFocusPainted(false);
		seatD2.setForeground(Color.BLACK);
		seatD2.setBackground(new Color(240, 240, 240));
		seatD2.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatD2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatD2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatD2.isSelected()) {
					seatD2.setContentAreaFilled(false);
					seatD2.setOpaque(true);
					seatD2.setBackground(new Color(220, 20, 60));
				}
				else {
					seatD2.setForeground(Color.BLACK);
					seatD2.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatD3 = new GridBagConstraints();
		gbc_seatD3.insets = new Insets(0, 0, 5, 5);
		gbc_seatD3.fill = GridBagConstraints.BOTH;
		gbc_seatD3.gridx = 4;
		gbc_seatD3.gridy = 5;
		contentPane.add(seatD3, gbc_seatD3);
		seatD3.setFocusPainted(false);
		seatD3.setForeground(Color.BLACK);
		seatD3.setBackground(new Color(240, 240, 240));
		seatD3.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatD3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatD3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatD3.isSelected()) {
					seatD3.setContentAreaFilled(false);
					seatD3.setOpaque(true);
					seatD3.setBackground(new Color(220, 20, 60));
				}
				else {
					seatD3.setForeground(Color.BLACK);
					seatD3.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatD4 = new GridBagConstraints();
		gbc_seatD4.insets = new Insets(0, 0, 5, 5);
		gbc_seatD4.fill = GridBagConstraints.BOTH;
		gbc_seatD4.gridx = 5;
		gbc_seatD4.gridy = 5;
		contentPane.add(seatD4, gbc_seatD4);
		seatD4.setFocusPainted(false);
		seatD4.setForeground(Color.BLACK);
		seatD4.setBackground(new Color(240, 240, 240));
		seatD4.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatD4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatD4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatD4.isSelected()) {
					seatD4.setContentAreaFilled(false);
					seatD4.setOpaque(true);
					seatD4.setBackground(new Color(220, 20, 60));
				}
				else {
					seatD4.setForeground(Color.BLACK);
					seatD4.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatD5 = new GridBagConstraints();
		gbc_seatD5.insets = new Insets(0, 0, 5, 5);
		gbc_seatD5.fill = GridBagConstraints.BOTH;
		gbc_seatD5.gridx = 6;
		gbc_seatD5.gridy = 5;
		contentPane.add(seatD5, gbc_seatD5);
		seatD5.setFocusPainted(false);
		seatD5.setForeground(Color.BLACK);
		seatD5.setBackground(new Color(240, 240, 240));
		seatD5.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatD5.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatD5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatD5.isSelected()) {
					seatD5.setContentAreaFilled(false);
					seatD5.setOpaque(true);
					seatD5.setBackground(new Color(220, 20, 60));
				}
				else {
					seatD5.setForeground(Color.BLACK);
					seatD5.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatD6 = new GridBagConstraints();
		gbc_seatD6.insets = new Insets(0, 0, 5, 5);
		gbc_seatD6.fill = GridBagConstraints.BOTH;
		gbc_seatD6.gridx = 7;
		gbc_seatD6.gridy = 5;
		contentPane.add(seatD6, gbc_seatD6);
		seatD6.setFocusPainted(false);
		seatD6.setForeground(Color.BLACK);
		seatD6.setBackground(new Color(240, 240, 240));
		seatD6.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatD6.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatD6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatD6.isSelected()) {
					seatD6.setContentAreaFilled(false);
					seatD6.setOpaque(true);
					seatD6.setBackground(new Color(220, 20, 60));
				}
				else {
					seatD6.setForeground(Color.BLACK);
					seatD6.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatD7 = new GridBagConstraints();
		gbc_seatD7.insets = new Insets(0, 0, 5, 5);
		gbc_seatD7.fill = GridBagConstraints.BOTH;
		gbc_seatD7.gridx = 8;
		gbc_seatD7.gridy = 5;
		contentPane.add(seatD7, gbc_seatD7);
		seatD7.setFocusPainted(false);
		seatD7.setForeground(Color.BLACK);
		seatD7.setBackground(new Color(240, 240, 240));
		seatD7.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatD7.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatD7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatD7.isSelected()) {
					seatD7.setContentAreaFilled(false);
					seatD7.setOpaque(true);
					seatD7.setBackground(new Color(220, 20, 60));
				}
				else {
					seatD7.setForeground(Color.BLACK);
					seatD7.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatD8 = new GridBagConstraints();
		gbc_seatD8.insets = new Insets(0, 0, 5, 5);
		gbc_seatD8.fill = GridBagConstraints.BOTH;
		gbc_seatD8.gridx = 9;
		gbc_seatD8.gridy = 5;
		contentPane.add(seatD8, gbc_seatD8);
		seatD8.setFocusPainted(false);
		seatD8.setForeground(Color.BLACK);
		seatD8.setBackground(new Color(240, 240, 240));
		seatD8.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatD8.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatD8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatD8.isSelected()) {
					seatD8.setContentAreaFilled(false);
					seatD8.setOpaque(true);
					seatD8.setBackground(new Color(220, 20, 60));
				}
				else {
					seatD8.setForeground(Color.BLACK);
					seatD8.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatE1 = new GridBagConstraints();
		gbc_seatE1.fill = GridBagConstraints.BOTH;
		gbc_seatE1.insets = new Insets(0, 0, 5, 5);
		gbc_seatE1.gridx = 2;
		gbc_seatE1.gridy = 6;
		contentPane.add(seatE1, gbc_seatE1);
		seatE1.setFocusPainted(false);
		seatE1.setForeground(Color.BLACK);
		seatE1.setBackground(new Color(240, 240, 240));
		seatE1.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatE1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatE1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatE1.isSelected()) {
					seatE1.setContentAreaFilled(false);
					seatE1.setOpaque(true);
					seatE1.setBackground(new Color(220, 20, 60));
				}
				else {
					seatE1.setForeground(Color.BLACK);
					seatE1.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatE2 = new GridBagConstraints();
		gbc_seatE2.insets = new Insets(0, 0, 5, 5);
		gbc_seatE2.fill = GridBagConstraints.BOTH;
		gbc_seatE2.gridx = 3;
		gbc_seatE2.gridy = 6;
		contentPane.add(seatE2, gbc_seatE2);
		seatE2.setFocusPainted(false);
		seatE2.setForeground(Color.BLACK);
		seatE2.setBackground(new Color(240, 240, 240));
		seatE2.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatE2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatE2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatE2.isSelected()) {
					seatE2.setContentAreaFilled(false);
					seatE2.setOpaque(true);
					seatE2.setBackground(new Color(220, 20, 60));
				}
				else {
					seatE2.setForeground(Color.BLACK);
					seatE2.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatE3 = new GridBagConstraints();
		gbc_seatE3.insets = new Insets(0, 0, 5, 5);
		gbc_seatE3.fill = GridBagConstraints.BOTH;
		gbc_seatE3.gridx = 4;
		gbc_seatE3.gridy = 6;
		contentPane.add(seatE3, gbc_seatE3);
		seatE3.setFocusPainted(false);
		seatE3.setForeground(Color.BLACK);
		seatE3.setBackground(new Color(240, 240, 240));
		seatE3.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatE3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatE3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatE3.isSelected()) {
					seatE3.setContentAreaFilled(false);
					seatE3.setOpaque(true);
					seatE3.setBackground(new Color(220, 20, 60));
				}
				else {
					seatE3.setForeground(Color.BLACK);
					seatE3.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatE4 = new GridBagConstraints();
		gbc_seatE4.insets = new Insets(0, 0, 5, 5);
		gbc_seatE4.fill = GridBagConstraints.BOTH;
		gbc_seatE4.gridx = 5;
		gbc_seatE4.gridy = 6;
		contentPane.add(seatE4, gbc_seatE4);
		seatE4.setFocusPainted(false);
		seatE4.setForeground(Color.BLACK);
		seatE4.setBackground(new Color(240, 240, 240));
		seatE4.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatE4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatE4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatE4.isSelected()) {
					seatE4.setContentAreaFilled(false);
					seatE4.setOpaque(true);
					seatE4.setBackground(new Color(220, 20, 60));
				}
				else {
					seatE4.setForeground(Color.BLACK);
					seatE4.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatE5 = new GridBagConstraints();
		gbc_seatE5.insets = new Insets(0, 0, 5, 5);
		gbc_seatE5.fill = GridBagConstraints.BOTH;
		gbc_seatE5.gridx = 6;
		gbc_seatE5.gridy = 6;
		contentPane.add(seatE5, gbc_seatE5);
		seatE5.setFocusPainted(false);
		seatE5.setForeground(Color.BLACK);
		seatE5.setBackground(new Color(240, 240, 240));
		seatE5.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatE5.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatE5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatE5.isSelected()) {
					seatE5.setContentAreaFilled(false);
					seatE5.setOpaque(true);
					seatE5.setBackground(new Color(220, 20, 60));
				}
				else {
					seatE5.setForeground(Color.BLACK);
					seatE5.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatE6 = new GridBagConstraints();
		gbc_seatE6.insets = new Insets(0, 0, 5, 5);
		gbc_seatE6.fill = GridBagConstraints.BOTH;
		gbc_seatE6.gridx = 7;
		gbc_seatE6.gridy = 6;
		contentPane.add(seatE6, gbc_seatE6);
		seatE6.setFocusPainted(false);
		seatE6.setForeground(Color.BLACK);
		seatE6.setBackground(new Color(240, 240, 240));
		seatE6.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatE6.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatE6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatE6.isSelected()) {
					seatE6.setContentAreaFilled(false);
					seatE6.setOpaque(true);
					seatE6.setBackground(new Color(220, 20, 60));
				}
				else {
					seatE6.setForeground(Color.BLACK);
					seatE6.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatE7 = new GridBagConstraints();
		gbc_seatE7.insets = new Insets(0, 0, 5, 5);
		gbc_seatE7.fill = GridBagConstraints.BOTH;
		gbc_seatE7.gridx = 8;
		gbc_seatE7.gridy = 6;
		contentPane.add(seatE7, gbc_seatE7);
		seatE7.setFocusPainted(false);
		seatE7.setForeground(Color.BLACK);
		seatE7.setBackground(new Color(240, 240, 240));
		seatE7.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatE7.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatE7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatE7.isSelected()) {
					seatE7.setContentAreaFilled(false);
					seatE7.setOpaque(true);
					seatE7.setBackground(new Color(220, 20, 60));
				}
				else {
					seatE7.setForeground(Color.BLACK);
					seatE7.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		GridBagConstraints gbc_seatE8 = new GridBagConstraints();
		gbc_seatE8.insets = new Insets(0, 0, 5, 5);
		gbc_seatE8.fill = GridBagConstraints.BOTH;
		gbc_seatE8.gridx = 9;
		gbc_seatE8.gridy = 6;
		contentPane.add(seatE8, gbc_seatE8);
		seatE8.setFocusPainted(false);
		seatE8.setForeground(Color.BLACK);
		seatE8.setBackground(new Color(240, 240, 240));
		seatE8.setFont(new Font("Tahoma", Font.BOLD, 16));
		seatE8.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				seatE8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(seatE8.isSelected()) {
					seatE8.setContentAreaFilled(false);
					seatE8.setOpaque(true);
					seatE8.setBackground(new Color(220, 20, 60));
				}
				else {
					seatE8.setForeground(Color.BLACK);
					seatE8.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		buttons.add(seatA1);
		buttons.add(seatA2);
		buttons.add(seatA3);
		buttons.add(seatA4);
		buttons.add(seatA5);
		buttons.add(seatA6);
		buttons.add(seatA7);
		buttons.add(seatA8);
		buttons.add(seatB1);
		buttons.add(seatB2);
		buttons.add(seatB3);
		buttons.add(seatB4);
		buttons.add(seatB5);
		buttons.add(seatB6);
		buttons.add(seatB7);
		buttons.add(seatB8);
		buttons.add(seatC1);
		buttons.add(seatC2);
		buttons.add(seatC3);
		buttons.add(seatC4);
		buttons.add(seatC5);
		buttons.add(seatC6);
		buttons.add(seatC7);
		buttons.add(seatC8);
		buttons.add(seatD1);
		buttons.add(seatD2);
		buttons.add(seatD3);
		buttons.add(seatD4);
		buttons.add(seatD5);
		buttons.add(seatD6);
		buttons.add(seatD7);
		buttons.add(seatD8);
		buttons.add(seatE1);
		buttons.add(seatE2);
		buttons.add(seatE3);
		buttons.add(seatE4);
		buttons.add(seatE5);
		buttons.add(seatE6);
		buttons.add(seatE7);
		buttons.add(seatE8);
		
		GridBagConstraints gbc_buttonNext = new GridBagConstraints();
		gbc_buttonNext.insets = new Insets(0, 0, 0, 0);
		gbc_buttonNext.gridwidth = 2;
		gbc_buttonNext.gridx = 10;
		gbc_buttonNext.gridy = 4;
		contentPane.add(buttonNext, gbc_buttonNext);
		buttonNext.setBorder(null);
		buttonNext.setContentAreaFilled(false);
		buttonNext.setOpaque(true);
		buttonNext.setBackground(new Color(205, 102, 102));
		buttonNext.setIcon(new ImageIcon(image_nextButton));
		buttonNext.addMouseListener(new MouseAdapter() {
			int flag = -1;
			public void mouseEntered(MouseEvent e) {
				buttonNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				for(JToggleButton j: buttons) {
					if(j.isSelected()) {
						str.add(j.getText());
						countSeatWW20h20++;
					}
				}
				for(JToggleButton i: buttons) {
					if(i.isSelected()) {
						flag = 1;
						PanelBooking.cardLayout.show(PanelBooking.homeBookingPane, "con9");
						break;
					}
					else 
						flag = 0;
				}
				if(flag == 0)
					JOptionPane.showMessageDialog(null, "Khách hàng vui lòng chọn ghế trước!", "Error Occured", JOptionPane.ERROR_MESSAGE);
			}
		});
		
	}
	
	public void updateSeat() {
		try {
			String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=BookingFilm;integratedSecurity=true;";
			connection = DriverManager.getConnection(connectionURL);
			info = connection.prepareStatement("Select Seat, State from WW20h20 where State=?");
			info.setString(1, "reserved");
            rs = info.executeQuery();
            while (rs.next()) {
            	for(JToggleButton i: buttons) {
            		if (i.getText().equals(rs.getString("Seat"))) {
            			i.setSelected(false);
            			i.setContentAreaFilled(false);
    					i.setOpaque(true);
    					i.setBackground(Color.GRAY);
            			i.setForeground(Color.BLACK);
            			i.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            			i.setEnabled(false);
            			i.addMouseListener(new MouseAdapter() {
            				public void mouseClicked(MouseEvent e) {
            					i.setContentAreaFilled(false);
            					i.setSelected(false);
            					i.setOpaque(true);
            					i.setBackground(Color.GRAY);
                    			i.setForeground(Color.BLACK);
            				}
            			});
            		}
            			
            	}
            	
            }
		}
		catch (SQLException sqlException) {
            sqlException.printStackTrace();
		}
		finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (info != null) {
		        try {
		            info.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (connection != null) {
		        try {
		            connection.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
	}
}

