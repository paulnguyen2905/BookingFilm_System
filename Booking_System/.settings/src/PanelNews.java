import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Cursor;
import java.awt.CardLayout;
import java.awt.Color;
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

public class PanelNews extends JPanel {
	private Image image_Back = new ImageIcon(PanelNews.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image imageNews1 = new ImageIcon(PanelNews.class.getResource("news/imageNews1.jpg")).getImage().getScaledInstance(216, 216, Image.SCALE_SMOOTH);
	private Image imageNews2 = new ImageIcon(PanelNews.class.getResource("news/imageNews2.png")).getImage().getScaledInstance(216, 216, Image.SCALE_SMOOTH);
	private Image imageNews3 = new ImageIcon(PanelNews.class.getResource("news/imageNews3.jpg")).getImage().getScaledInstance(216, 216, Image.SCALE_SMOOTH);
	private Image imageNews4 = new ImageIcon(PanelNews.class.getResource("news/imageNews4.jpg")).getImage().getScaledInstance(216, 216, Image.SCALE_SMOOTH);
	private Image imageNews5 = new ImageIcon(PanelNews.class.getResource("news/imageNews5.jpg")).getImage().getScaledInstance(216, 216, Image.SCALE_SMOOTH);
	private Image imageNews6 = new ImageIcon(PanelNews.class.getResource("news/imageNews6.jpg")).getImage().getScaledInstance(216, 216, Image.SCALE_SMOOTH);
	private Image imageNews7 = new ImageIcon(PanelNews.class.getResource("news/imageNews7.jpg")).getImage().getScaledInstance(216, 216, Image.SCALE_SMOOTH);
	private Image imageNews8 = new ImageIcon(PanelNews.class.getResource("news/imageNews8.png")).getImage().getScaledInstance(216, 216, Image.SCALE_SMOOTH);
	private Image imageNews9 = new ImageIcon(PanelNews.class.getResource("news/imageNews9.jpg")).getImage().getScaledInstance(216, 216, Image.SCALE_SMOOTH);

	private final JLabel lblNewLabel = new JLabel("Tin tức - Chương trình khuyến mãi");
	private final JButton buttonBack = new JButton("");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel News1 = new JLabel("");
	private final JLabel News2 = new JLabel("");
	private final JLabel News3 = new JLabel("");
	private final JLabel News4 = new JLabel("");
	private final JLabel News5 = new JLabel("");
	private final JLabel News6 = new JLabel("");
	private final JLabel News7 = new JLabel("");
	private final JLabel News8 = new JLabel("");
	private final JLabel News9 = new JLabel("");
	
	public static CardLayout cardLayout = new CardLayout();
	public static JPanel contentPane = new JPanel();
	public static JPanel firstPane = new JPanel();
	public static JPanel homeNewsPane = new JPanel();
	public News1 news1 = new News1();
	public News2 news2 = new News2();
	public News3 news3 = new News3();
	public News4 news4 = new News4();
	public News5 news5 = new News5();
	public News6 news6 = new News6();
	public News7 news7 = new News7();
	public News8 news8 = new News8();
	public News9 news9 = new News9();

	//Create the panel.
	public PanelNews() {
		initGUI();
	}
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setLayout(null);
		setBackground(new Color(205, 102, 102));
		
		add(homeNewsPane);
		homeNewsPane.setBounds(0 , 0, 747, 580);
		homeNewsPane.setLayout(null);
		homeNewsPane.setBackground(new Color(205, 102, 102));
		
		homeNewsPane.setLayout(cardLayout);
		homeNewsPane.add(firstPane, "0");
		homeNewsPane.add(news1, "1");
		homeNewsPane.add(news2, "2");
		homeNewsPane.add(news3, "3");
		homeNewsPane.add(news4, "4");
		homeNewsPane.add(news5, "5");
		homeNewsPane.add(news6, "6");
		homeNewsPane.add(news7, "7");
		homeNewsPane.add(news8, "8");
		homeNewsPane.add(news9, "9");
		cardLayout.show(homeNewsPane, "0");

		firstPane.setBounds(0 , 0, 747, 580);
		firstPane.setLayout(null);
		firstPane.setBackground(new Color(205, 102, 102));
		
		firstPane.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(54, 8, 462, 30);
		
		firstPane.add(buttonBack);
		buttonBack.setBackground(new Color(205, 102, 102));
		buttonBack.setBorder(null);
		buttonBack.setBounds(10, 10, 32, 26);
		buttonBack.setIcon(new ImageIcon(image_Back));
		
		firstPane.add(scrollPane);
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
		gbl_contentPane.rowHeights = new int[]{250, 250, 250, 85, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		
		GridBagConstraints gbc_imageNews1 = new GridBagConstraints();
		gbc_imageNews1.anchor = GridBagConstraints.EAST;
		gbc_imageNews1.insets = new Insets(0, 0, 5, 5);
		gbc_imageNews1.gridx = 0;
		gbc_imageNews1.gridy = 0;
		contentPane.add(News1, gbc_imageNews1);
		News1.setIcon(new ImageIcon(imageNews1));
		News1.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				News1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(homeNewsPane, "1");
			}
		});
		
		GridBagConstraints gbc_imageNews2 = new GridBagConstraints();
		gbc_imageNews2.insets = new Insets(0, 0, 5, 5);
		gbc_imageNews2.gridx = 1;
		gbc_imageNews2.gridy = 0;
		contentPane.add(News2, gbc_imageNews2);
		News2.setIcon(new ImageIcon(imageNews2));
		News2.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				News2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(homeNewsPane, "2");
			}
		});
		
		GridBagConstraints gbc_imageNews3 = new GridBagConstraints();
		gbc_imageNews3.insets = new Insets(0, 0, 5, 5);
		gbc_imageNews3.gridx = 2;
		gbc_imageNews3.gridy = 0;
		contentPane.add(News3, gbc_imageNews3);
		News3.setIcon(new ImageIcon(imageNews3));
		News3.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				News3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(homeNewsPane, "3");
			}
		});
		
		GridBagConstraints gbc_imageNews4 = new GridBagConstraints();
		gbc_imageNews4.insets = new Insets(0, 0, 5, 5);
		gbc_imageNews4.gridx = 0;
		gbc_imageNews4.gridy = 1;
		contentPane.add(News4, gbc_imageNews4);
		News4.setIcon(new ImageIcon(imageNews4));
		News4.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				News4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(homeNewsPane, "4");
			}
		});
		
		GridBagConstraints gbc_imageNews5 = new GridBagConstraints();
		gbc_imageNews5.insets = new Insets(0, 0, 5, 5);
		gbc_imageNews5.gridx = 1;
		gbc_imageNews5.gridy = 1;
		contentPane.add(News5, gbc_imageNews5);
		News5.setIcon(new ImageIcon(imageNews5));
		News5.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				News5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(homeNewsPane, "5");
			}
		});
		
		GridBagConstraints gbc_imageNews6 = new GridBagConstraints();
		gbc_imageNews6.insets = new Insets(0, 0, 5, 5);
		gbc_imageNews6.gridx = 2;
		gbc_imageNews6.gridy = 1;
		contentPane.add(News6, gbc_imageNews6);
		News6.setIcon(new ImageIcon(imageNews6));
		News6.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				News6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(homeNewsPane, "6");
			}
		});
		
		GridBagConstraints gbc_imageNews7 = new GridBagConstraints();
		gbc_imageNews7.insets = new Insets(0, 0, 5, 5);
		gbc_imageNews7.gridx = 0;
		gbc_imageNews7.gridy = 2;
		contentPane.add(News7, gbc_imageNews7);
		News7.setIcon(new ImageIcon(imageNews7));
		News7.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				News7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(homeNewsPane, "7");
			}
		});
		
		GridBagConstraints gbc_imageNews8 = new GridBagConstraints();
		gbc_imageNews8.insets = new Insets(0, 0, 5, 5);
		gbc_imageNews8.gridx = 1;
		gbc_imageNews8.gridy = 2;
		contentPane.add(News8, gbc_imageNews8);
		News8.setIcon(new ImageIcon(imageNews8));
		News8.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				News8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(homeNewsPane, "8");
			}
		});
		
		GridBagConstraints gbc_imageNews9 = new GridBagConstraints();
		gbc_imageNews9.insets = new Insets(0, 0, 5, 5);
		gbc_imageNews9.gridx = 2;
		gbc_imageNews9.gridy = 2;
		contentPane.add(News9, gbc_imageNews9);
		News9.setIcon(new ImageIcon(imageNews9));
		News9.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				News9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
	
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(homeNewsPane, "9");
			}
		});
	}
}
