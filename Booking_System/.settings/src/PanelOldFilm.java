import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelOldFilm extends JPanel {
	private Image image_Back = new ImageIcon(PanelOldFilm.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	
	private Image posterCMB = new ImageIcon(PanelOldFilm.class.getResource("posterNowShowing/poster_CMB.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image posterWW = new ImageIcon(PanelOldFilm.class.getResource("posterNowShowing/poster_WW.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image posterNobita = new ImageIcon(PanelOldFilm.class.getResource("posterNowShowing/poster_nobita.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image posterNSK = new ImageIcon(PanelOldFilm.class.getResource("posterNowShowing/poster_NSK.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image posterSoul = new ImageIcon(PanelOldFilm.class.getResource("posterNowShowing/poster_soul.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image posterNCQPN = new ImageIcon(PanelOldFilm.class.getResource("posterNowShowing/poster_NCQPN.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	
	private final JLabel labelNowShowing = new JLabel("Phim đang chiếu");
	private final JButton buttonBack = new JButton("");
	private final JScrollPane scrollPane = new JScrollPane();
	
	private final JLabel imageCMB = new JLabel("");
	private final JTextArea textCMB = new JTextArea();
	private final JLabel imageNobita = new JLabel("");
	private final JTextArea textNobita = new JTextArea();
	private final JLabel imageWW = new JLabel("");
	private final JTextArea textWW = new JTextArea();
	private final JLabel imageNSK = new JLabel("");
	private final JTextArea textNSK = new JTextArea();
	private final JLabel imageSoul = new JLabel("");
	private final JTextArea textSoul = new JTextArea();
	private final JLabel imageNCQPN = new JLabel("");
	private final JTextArea textNCQPN = new JTextArea();
	
	private final JPanel contentPane = new JPanel();
	public static CardLayout cardLayout = new CardLayout();
	public static JPanel firstPane = new JPanel();
	public static JPanel homeFilmPane = new JPanel();
	public static JPanel bigPane = new JPanel();
	public OldFilm1 film1 = new OldFilm1();
	public OldFilm2 film2 = new OldFilm2();
	public OldFilm3 film3 = new OldFilm3();
	public OldFilm4 film4 = new OldFilm4();
	public OldFilm5 film5 = new OldFilm5();
	public OldFilm6 film6 = new OldFilm6();

	//Create the panel.
	public PanelOldFilm() {
		initGUI();
	}
	
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setLayout(null);
		setBackground(new Color(205, 102, 102)); 
		add(film1);
		add(film2);
		add(film3);
		add(film4);
		add(film5);
		add(film6);
		film1.setVisible(false);
		film2.setVisible(false);
		film3.setVisible(false);
		film4.setVisible(false);
		film5.setVisible(false);
		film6.setVisible(false);
		
		add(labelNowShowing);
		labelNowShowing.setBounds(54, 8, 230, 35);
		labelNowShowing.setForeground(new Color(0, 0, 0));
		labelNowShowing.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		add(buttonBack);
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttonBack.setBackground(new Color(205, 102, 102));
		buttonBack.setBorder(null);
		buttonBack.setBounds(10, 10, 32, 26);
		buttonBack.setIcon(new ImageIcon(image_Back));
		
		add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 48, 747, 532);
		scrollPane.setBorder(null);
		scrollPane.setViewportView(contentPane);
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(205, 102, 102));
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		contentPane.setLayout(gbl_contentPane);
		gbl_contentPane.columnWidths = new int[]{243, 243, 243, 0};
		gbl_contentPane.rowHeights = new int[]{250, 85, 0, 85, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		
		GridBagConstraints gbc_imageCMB = new GridBagConstraints();
		gbc_imageCMB.fill = GridBagConstraints.VERTICAL;
		gbc_imageCMB.insets = new Insets(0, 0, 5, 5);
		gbc_imageCMB.gridx = 0;
		gbc_imageCMB.gridy = 0;
		contentPane.add(imageCMB, gbc_imageCMB);
		imageCMB.setIcon(new ImageIcon(posterCMB));
		imageCMB.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				imageCMB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				film1.setVisible(true);
			}
		});
		
		GridBagConstraints gbc_textCMB = new GridBagConstraints();
		gbc_textCMB.anchor = GridBagConstraints.NORTH;
		gbc_textCMB.insets = new Insets(0, 0, 5, 5);
		gbc_textCMB.gridx = 0;
		gbc_textCMB.gridy = 1;
		contentPane.add(textCMB, gbc_textCMB);
		textCMB.setEditable(false);
		textCMB.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textCMB.setText("Thể loại: Hài, Hành động \nThời lượng: 96 phút \nKhởi chiếu: 25-12-2020");
		textCMB.setBackground(new Color(205, 102, 102));
		
		GridBagConstraints gbc_imageNobita = new GridBagConstraints();
		gbc_imageNobita.fill = GridBagConstraints.VERTICAL;
		gbc_imageNobita.insets = new Insets(0, 0, 5, 5);
		gbc_imageNobita.gridx = 1;
		gbc_imageNobita.gridy = 0;
		contentPane.add(imageNobita, gbc_imageNobita);
		imageNobita.setIcon(new ImageIcon(posterNobita));
		imageNobita.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				imageNobita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				film2.setVisible(true);
			}
		});
		
		GridBagConstraints gbc_textNobita = new GridBagConstraints();
		gbc_textNobita.fill = GridBagConstraints.VERTICAL;
		gbc_textNobita.insets = new Insets(0, 0, 5, 5);
		gbc_textNobita.gridx = 1;
		gbc_textNobita.gridy = 1;
		contentPane.add(textNobita, gbc_textNobita);
		textNobita.setEditable(false);
		textNobita.setText("Thể loại: Hoạt hình \nThời lượng: 110 phút \nKhởi chiếu: 18-12-2020");
		textNobita.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textNobita.setBackground(new Color(205, 102, 102));
		
		GridBagConstraints gbc_imageWW = new GridBagConstraints();
		gbc_imageWW.fill = GridBagConstraints.VERTICAL;
		gbc_imageWW.insets = new Insets(0, 0, 5, 0);
		gbc_imageWW.gridx = 2;
		gbc_imageWW.gridy = 0;
		contentPane.add(imageWW, gbc_imageWW);
		imageWW.setIcon(new ImageIcon(posterWW));
		imageWW.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				imageWW.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				film3.setVisible(true);
			}
		});
		
		GridBagConstraints gbc_texWW = new GridBagConstraints();
		gbc_texWW.fill = GridBagConstraints.VERTICAL;
		gbc_texWW.insets = new Insets(0, 0, 5, 0);
		gbc_texWW.gridx = 2;
		gbc_texWW.gridy = 1;
		contentPane.add(textWW, gbc_texWW);
		textWW.setEditable(false);
		textWW.setText("Thể loại: Hành động, Thần thoại \nThời lượng: 151 phút \nKhởi chiếu: 18-12-2020");
		textWW.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textWW.setBackground(new Color(205, 102, 102));
		
		GridBagConstraints gbc_imageNSK = new GridBagConstraints();
		gbc_imageNSK.fill = GridBagConstraints.VERTICAL;
		gbc_imageNSK.insets = new Insets(0, 0, 5, 5);
		gbc_imageNSK.gridx = 0;
		gbc_imageNSK.gridy = 2;
		contentPane.add(imageNSK, gbc_imageNSK);
		imageNSK.setIcon(new ImageIcon(posterNSK));
		imageNSK.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				imageNSK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				film4.setVisible(true);
			}
		});
		
		GridBagConstraints gbc_textNSK = new GridBagConstraints();
		gbc_textNSK.insets = new Insets(0, 0, 0, 5);
		gbc_textNSK.fill = GridBagConstraints.VERTICAL;
		gbc_textNSK.gridx = 0;
		gbc_textNSK.gridy = 3;
		contentPane.add(textNSK, gbc_textNSK);
		textNSK.setEditable(false);
		textNSK.setText("Thể loại: Hài, Hành động \nThời lượng: 111 phút \nKhởi chiếu: 11-12-2020");
		textNSK.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textNSK.setBackground(new Color(205, 102, 102));
		
		GridBagConstraints gbc_imageSoul = new GridBagConstraints();
		gbc_imageSoul.insets = new Insets(0, 0, 5, 5);
		gbc_imageSoul.gridx = 1;
		gbc_imageSoul.gridy = 2;
		contentPane.add(imageSoul, gbc_imageSoul);
		imageSoul.setIcon(new ImageIcon(posterSoul));
		imageSoul.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				imageSoul.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				film5.setVisible(true);
			}
		});
		
		GridBagConstraints gbc_textSoul = new GridBagConstraints();
		gbc_textSoul.insets = new Insets(0, 0, 0, 5);
		gbc_textSoul.fill = GridBagConstraints.VERTICAL;
		gbc_textSoul.gridx = 1;
		gbc_textSoul.gridy = 3;
		contentPane.add(textSoul, gbc_textSoul);
		textSoul.setEditable(false);
		textSoul.setText("Thể loại: Gia đình, Hoạt hình \nThời lượng: 107 phút \nKhởi chiếu: 25-12-2020");
		textSoul.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textSoul.setBackground(new Color(205, 102, 102));
		
		GridBagConstraints gbc_imageNCQPN = new GridBagConstraints();
		gbc_imageNCQPN.insets = new Insets(0, 0, 5, 5);
		gbc_imageNCQPN.gridx = 2;
		gbc_imageNCQPN.gridy = 2;
		contentPane.add(imageNCQPN, gbc_imageNCQPN);
		imageNCQPN.setIcon(new ImageIcon(posterNCQPN));
		imageNCQPN.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				imageNCQPN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				film6.setVisible(true);
			}
		});
		
		GridBagConstraints gbc_textNCQPN = new GridBagConstraints();
		gbc_textNCQPN.insets = new Insets(0, 0, 0, 5);
		gbc_textNCQPN.fill = GridBagConstraints.VERTICAL;
		gbc_textNCQPN.gridx = 2;
		gbc_textNCQPN.gridy = 3;
		contentPane.add(textNCQPN, gbc_textNCQPN);
		textNCQPN.setEditable(false);
		textNCQPN.setText("Thể loại: Hài, Tình cảm \nThời lượng: 110 phút \nKhởi chiếu: 25-12-2020");
		textNCQPN.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textNCQPN.setBackground(new Color(205, 102, 102));
	}

}
