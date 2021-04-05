import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class PanelNewFilm extends JPanel {
	private Image image_Back = new ImageIcon(PanelNewFilm.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	
	private Image poster_VSDC = new ImageIcon(PanelNewFilm.class.getResource("posterComingSoon/poster_VSDC.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image poster_ELCE = new ImageIcon(PanelNewFilm.class.getResource("posterComingSoon/poster_ELCE.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image poster_TT = new ImageIcon(PanelNewFilm.class.getResource("posterComingSoon/poster_TT.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image poster_GGLC = new ImageIcon(PanelNewFilm.class.getResource("posterComingSoon/poster_GGLC.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image poster_PR2 = new ImageIcon(PanelNewFilm.class.getResource("posterComingSoon/poster_PR2.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	
	private final JLabel labelComingSoon = new JLabel("Phim sắp chiếu");
	private final JButton buttonBack = new JButton("");
	private final JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	
	private final JLabel imageVSDC = new JLabel("");
	private final JTextArea textVSDC = new JTextArea();
	private final JLabel imageTT = new JLabel("");
	private final JTextArea textTT = new JTextArea();
	private final JLabel imageELCE = new JLabel("");
	private final JTextArea textELCE = new JTextArea();
	private final JLabel imageGGLC = new JLabel("");
	private final JTextArea textGGLC = new JTextArea();
	private final JLabel imagePR2 = new JLabel("");
	private final JTextArea textPR2 = new JTextArea();
	
	public NewFilm1 film1 = new NewFilm1();
	public NewFilm2 film2 = new NewFilm2();
	public NewFilm3 film3 = new NewFilm3();
	public NewFilm4 film4 = new NewFilm4();
	public NewFilm5 film5 = new NewFilm5();

	//Create the panel.
	public PanelNewFilm() {
		initGUI();
	}
	
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setBackground(new Color(205, 102, 102));
		setLayout(null);
		add(film1);
		add(film2);
		add(film3);
		add(film4);
		add(film5);
		film1.setVisible(false);
		film2.setVisible(false);
		film3.setVisible(false);
		film4.setVisible(false);
		film5.setVisible(false);
		
		add(labelComingSoon);
		labelComingSoon.setBounds(54, 8, 176, 35);
		labelComingSoon.setForeground(new Color(0, 0, 0));
		labelComingSoon.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
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
		
		GridBagConstraints gbc_imageVSDC = new GridBagConstraints();
		gbc_imageVSDC.fill = GridBagConstraints.VERTICAL;
		gbc_imageVSDC.insets = new Insets(0, 0, 5, 5);
		gbc_imageVSDC.gridx = 0;
		gbc_imageVSDC.gridy = 0;
		contentPane.add(imageVSDC, gbc_imageVSDC);
		imageVSDC.setIcon(new ImageIcon(poster_VSDC));
		imageVSDC.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				imageVSDC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		GridBagConstraints gbc_textVSDC = new GridBagConstraints();
		gbc_textVSDC.anchor = GridBagConstraints.NORTH;
		gbc_textVSDC.insets = new Insets(0, 0, 5, 5);
		gbc_textVSDC.gridx = 0;
		gbc_textVSDC.gridy = 1;
		contentPane.add(textVSDC, gbc_textVSDC);
		textVSDC.setEditable(false);
		textVSDC.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textVSDC.setText("Thể loại: Hài, Tình cảm \nThời lượng: chưa xác định \nKhởi chiếu: 01-01-2021");
		textVSDC.setBackground(new Color(205, 102, 102));
		
		GridBagConstraints gbc_imageTT = new GridBagConstraints();
		gbc_imageTT.fill = GridBagConstraints.VERTICAL;
		gbc_imageTT.insets = new Insets(0, 0, 5, 5);
		gbc_imageTT.gridx = 1;
		gbc_imageTT.gridy = 0;
		contentPane.add(imageTT, gbc_imageTT);
		imageTT.setIcon(new ImageIcon(poster_TT));
		imageTT.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				imageTT.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		GridBagConstraints gbc_textTT = new GridBagConstraints();
		gbc_textTT.fill = GridBagConstraints.VERTICAL;
		gbc_textTT.insets = new Insets(0, 0, 5, 5);
		gbc_textTT.gridx = 1;
		gbc_textTT.gridy = 1;
		contentPane.add(textTT, gbc_textTT);
		textTT.setEditable(false);
		textTT.setText("Thể loại: Phiêu lưu, Thần thoại \nThời lượng: chưa xác định \nKhởi chiếu: 12-02-2021");
		textTT.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textTT.setBackground(new Color(205, 102, 102));
		
		GridBagConstraints gbc_imageELCE = new GridBagConstraints();
		gbc_imageELCE.fill = GridBagConstraints.VERTICAL;
		gbc_imageELCE.insets = new Insets(0, 0, 5, 0);
		gbc_imageELCE.gridx = 2;
		gbc_imageELCE.gridy = 0;
		contentPane.add(imageELCE, gbc_imageELCE);
		imageELCE.setIcon(new ImageIcon(poster_ELCE));
		imageELCE.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				imageELCE.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		GridBagConstraints gbc_texELCE = new GridBagConstraints();
		gbc_texELCE.fill = GridBagConstraints.VERTICAL;
		gbc_texELCE.insets = new Insets(0, 0, 5, 0);
		gbc_texELCE.gridx = 2;
		gbc_texELCE.gridy = 1;
		contentPane.add(textELCE, gbc_texELCE);
		textELCE.setEditable(false);
		textELCE.setText("Thể loại: Hài, Tình cảm \nThời lượng: chưa xác định \nKhởi chiếu: 08-01-2021");
		textELCE.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textELCE.setBackground(new Color(205, 102, 102));
		
		GridBagConstraints gbc_imageGGLC = new GridBagConstraints();
		gbc_imageGGLC.fill = GridBagConstraints.VERTICAL;
		gbc_imageGGLC.insets = new Insets(0, 0, 5, 5);
		gbc_imageGGLC.gridx = 0;
		gbc_imageGGLC.gridy = 2;
		contentPane.add(imageGGLC, gbc_imageGGLC);
		imageGGLC.setIcon(new ImageIcon(poster_GGLC));
		imageGGLC.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				imageGGLC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		GridBagConstraints gbc_textGGLC = new GridBagConstraints();
		gbc_textGGLC.insets = new Insets(0, 0, 0, 5);
		gbc_textGGLC.fill = GridBagConstraints.VERTICAL;
		gbc_textGGLC.gridx = 0;
		gbc_textGGLC.gridy = 3;
		contentPane.add(textGGLC, gbc_textGGLC);
		textGGLC.setEditable(false);
		textGGLC.setText("Thể loại: Hài, Tâm lý \nThời lượng: chưa xác định \nKhởi chiếu: 12-02-2021");
		textGGLC.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textGGLC.setBackground(new Color(205, 102, 102));
		
		GridBagConstraints gbc_imagePR2 = new GridBagConstraints();
		gbc_imagePR2.insets = new Insets(0, 0, 5, 5);
		gbc_imagePR2.gridx = 1;
		gbc_imagePR2.gridy = 2;
		contentPane.add(imagePR2, gbc_imagePR2);
		imagePR2.setIcon(new ImageIcon(poster_PR2));
		imagePR2.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				imagePR2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		GridBagConstraints gbc_textPR2 = new GridBagConstraints();
		gbc_textPR2.insets = new Insets(0, 0, 0, 5);
		gbc_textPR2.fill = GridBagConstraints.VERTICAL;
		gbc_textPR2.gridx = 1;
		gbc_textPR2.gridy = 3;
		contentPane.add(textPR2, gbc_textPR2);
		textPR2.setEditable(false);
		textPR2.setText("Thể loại: Phiêu lưu, Hoạt hình \nThời lượng: chưa xác định \nKhởi chiếu: 15-01-2021");
		textPR2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textPR2.setBackground(new Color(205, 102, 102));
	}

}
