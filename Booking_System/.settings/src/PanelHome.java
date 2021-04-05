import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class PanelHome extends JPanel {
	
	private Image image_leftArrow = new ImageIcon(PanelHome.class.getResource("image/leftArrow_icon.png")).getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
	private Image image_rightArrow = new ImageIcon(PanelHome.class.getResource("image/rightArrow_icon.png")).getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
	private Image image_Back = new ImageIcon(PanelHome.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	
	private final JLabel lblNewLabel = new JLabel("Trang chủ");
	private final JLabel textNowShowing = new JLabel("------------- Now Showing -------------");
	private final JLabel textComingSoon = new JLabel("------------- Coming Soon -------------");
	private final JLabel NowShowing = new JLabel("");
	private final JLabel ComingSoon = new JLabel("");
	private final JButton buttonLeftArrow1 = new JButton("");
	private final JButton buttonRightArrow1 = new JButton("");
	private final JButton buttonLeftArrow2 = new JButton("");
	private final JButton buttonRightArrow2 = new JButton("");
	private final JButton buttonBack = new JButton("");
		
	public static JPanel contentPane = new JPanel();
	public static JPanel firstPane = new JPanel();
	public static CardLayout cardLayout = new CardLayout();
	public PanelOldFilm oldFilm = new PanelOldFilm();
	public PanelNewFilm newFilm = new PanelNewFilm();

	//Create the panel.
	public PanelHome() {
		initGUI();
		showImageNowShowing(position1);
		showImageComingSoon(position2);
	}
	int position1 = 0;	
	int position2 = 0;
	
	public String[] getImagesNowShowing() {
		File file = new File("D:/Eclipse Workspace/SwingDemo/src/nowshowing");
		String[] imagesList	= file.list();
		return imagesList;
	}
	
	public void showImageNowShowing(int index) {
		String[] imagesList = getImagesNowShowing();
		String imageName = imagesList[index];
		ImageIcon icon = new ImageIcon(getClass().getResource("/nowshowing/"+imageName));
		Image image = icon.getImage().getScaledInstance(NowShowing.getWidth(), NowShowing.getHeight(), Image.SCALE_SMOOTH);
		NowShowing.setIcon(new ImageIcon(image));
	}
	
	public String[] getImagesComingSoon() {
		File file = new File("D:/Eclipse Workspace/SwingDemo/src/comingsoon");
		String[] imagesList	= file.list();
		return imagesList;
	}
	
	public void showImageComingSoon(int index) {
		String[] imagesList = getImagesComingSoon();
		String imageName = imagesList[index];
		ImageIcon icon = new ImageIcon(getClass().getResource("/comingsoon/"+imageName));
		Image image = icon.getImage().getScaledInstance(ComingSoon.getWidth(), ComingSoon.getHeight(), Image.SCALE_SMOOTH);
		ComingSoon.setIcon(new ImageIcon(image));
	}
	
	private void initGUI() {
		setLayout(null);
		setBounds(0 , 0, 747, 580);
		setBackground(Color.GRAY);
		
		add(contentPane);
		contentPane.setBounds(0 , 0, 747, 580);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(205, 102, 102));
		
		contentPane.setLayout(cardLayout);
		contentPane.add(firstPane, "1");
		contentPane.add(oldFilm, "2");
		contentPane.add(newFilm, "3");
		cardLayout.show(contentPane, "1");

		firstPane.setBounds(0 , 0, 747, 580);
		firstPane.setLayout(null);
		firstPane.setBackground(new Color(205, 102, 102));
		
		firstPane.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(54, 8, 154, 35);
		
		firstPane.add(textNowShowing);
		textNowShowing.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				textNowShowing.setForeground(Color.DARK_GRAY);
				textNowShowing.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				textNowShowing.setForeground(Color.BLACK);
			}
			public void mousePressed(MouseEvent e) {
				textNowShowing.setForeground(Color.RED);
			}
			public void mouseReleased(MouseEvent e) {
				textNowShowing.setForeground(Color.DARK_GRAY);
			}
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(contentPane, "2");
			}
		});
		textNowShowing.setForeground(Color.BLACK);
		textNowShowing.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textNowShowing.setBounds(214, 30, 326, 29);
		
		firstPane.add(textComingSoon);
		textComingSoon.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				textComingSoon.setForeground(Color.DARK_GRAY);
				textComingSoon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				textComingSoon.setForeground(Color.BLACK);
			}
			public void mousePressed(MouseEvent e) {
				textComingSoon.setForeground(Color.RED);
			}
			public void mouseReleased(MouseEvent e) {
				textComingSoon.setForeground(Color.DARK_GRAY);
			}
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(contentPane, "3");
			}
		});
		textComingSoon.setForeground(Color.BLACK);
		textComingSoon.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textComingSoon.setBounds(216, 300, 324, 30);
		
		firstPane.add(NowShowing);
		NowShowing.setBounds(144, 60, 450, 240);
		
		firstPane.add(ComingSoon);
		ComingSoon.setBounds(144, 330, 450, 240);
		
		firstPane.add(buttonLeftArrow1);
		buttonLeftArrow1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonLeftArrow1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		buttonLeftArrow1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				position1 = position1 - 1;
				if (position1 < 0)
					position1 = getImagesNowShowing().length - 1;
				showImageNowShowing(position1);
			}
		});
		buttonLeftArrow1.setBackground(new Color(205, 102, 102));
		buttonLeftArrow1.setBorder(null);
		buttonLeftArrow1.setBounds(73, 146, 48, 48);
		buttonLeftArrow1.setIcon(new ImageIcon(image_leftArrow));
		
		firstPane.add(buttonRightArrow1);
		buttonRightArrow1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonRightArrow1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		buttonRightArrow1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				position1 = position1 + 1;
				if (position1 >= getImagesNowShowing().length)
					position1 = 0;
				showImageNowShowing(position1);
			}
		});
		buttonRightArrow1.setBorder(null);
		buttonRightArrow1.setBackground(new Color(205, 102, 102));
		buttonRightArrow1.setBounds(615, 146, 48, 48);
		buttonRightArrow1.setIcon(new ImageIcon(image_rightArrow));
		
		firstPane.add(buttonLeftArrow2);
		buttonLeftArrow2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonLeftArrow2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		buttonLeftArrow2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				position2 = position2 - 1;
				if (position2 < 0)
					position2 = getImagesComingSoon().length - 1;
				showImageComingSoon(position2);
			}
		});
		buttonLeftArrow2.setBorder(null);
		buttonLeftArrow2.setBackground(new Color(205, 102, 102));
		buttonLeftArrow2.setBounds(73, 430, 48, 48);
		buttonLeftArrow2.setIcon(new ImageIcon(image_leftArrow));
		
		firstPane.add(buttonRightArrow2);
		buttonRightArrow2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonRightArrow2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		buttonRightArrow2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				position2 = position2 + 1;
				if (position2 >= getImagesComingSoon().length)
					position2 = 0;
				showImageComingSoon(position2);
			}
		});
		buttonRightArrow2.setBorder(null);
		buttonRightArrow2.setBackground(new Color(205, 102, 102));
		buttonRightArrow2.setBounds(615, 430, 48, 48);
		buttonRightArrow2.setIcon(new ImageIcon(image_rightArrow));
		
		firstPane.add(buttonBack);
		buttonBack.setBackground(new Color(205, 102, 102));
		buttonBack.setBorder(null);
		buttonBack.setBounds(10, 10, 32, 26);
		buttonBack.setIcon(new ImageIcon(image_Back));
		buttonBack.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});

	}
	
}