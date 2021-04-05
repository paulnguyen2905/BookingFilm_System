import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConcessionCMB9h30 extends JPanel {
	private Image image_Back = new ImageIcon(ConcessionCMB9h30.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_nextButton = new ImageIcon(ConcessionCMB9h30.class.getResource("image/nextButton_icon.png")).getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
	private Image image_pairCombo = new ImageIcon(ConcessionCMB9h30.class.getResource("image/cgvCombo_icon.png")).getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
	private Image image_myCombo = new ImageIcon(ConcessionCMB9h30.class.getResource("image/myCombo_icon.png")).getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
	private Image image_oxCombo = new ImageIcon(ConcessionCMB9h30.class.getResource("image/oxCombo_icon.png")).getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
	private Image image_increase = new ImageIcon(ConcessionCMB9h30.class.getResource("image/increase_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image image_decrease = new ImageIcon(ConcessionCMB9h30.class.getResource("image/decrease_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

	public static CardLayout cardLayout = new CardLayout();
	public static JPanel firstPane = new JPanel();
	public static JPanel homeConcessionPane = new JPanel();
	
	private final JPanel panelMenu = new JPanel();
	private final JButton buttonBack = new JButton("");
	private final JButton buttonNext = new JButton("");
	private final JLabel labelTitle = new JLabel("Đặt vé online - Chọn bắp nước");
	private final JLabel imageMyCombo = new JLabel("");
	private final JLabel imagePairCombo = new JLabel("");
	private final JLabel imageOxCombo = new JLabel("");
	private final JTextArea textMyCombo = new JTextArea();
	private final JTextArea textPairCombo = new JTextArea();
	private final JTextArea textOxCombo = new JTextArea();
	private final JTextArea amount1 = new JTextArea();
	private final JTextArea amount2 = new JTextArea();
	private final JTextArea amount3 = new JTextArea();
	private final JButton imageIncrease1 = new JButton("");
	private final JButton imageDecrease1 = new JButton("");
	private final JButton imageIncrease2 = new JButton("");
	private final JButton imageDecrease2 = new JButton("");
	private final JButton imageIncrease3 = new JButton("");
	private final JButton imageDecrease3 = new JButton("");
	
	public int total1 = 0;
	public int total2 = 0;
	public int total3 = 0;
	
	//Create the panel.
	public ConcessionCMB9h30() {
		initGUI();
	}
	
	public void initGUI() {
		setBounds(0 , 0, 747, 580);
		setBackground(new Color(205, 102, 102)); 
		setLayout(null);
		
		firstPane.setBounds(0 , 0, 747, 580);
		firstPane.setBackground(new Color(205, 102, 102));
		firstPane.setLayout(null);
		
		add(homeConcessionPane);
		homeConcessionPane.setBounds(0 , 0, 747, 580);
		homeConcessionPane.setLayout(null);
		homeConcessionPane.setBackground(new Color(205, 102, 102));
		
		homeConcessionPane.setLayout(cardLayout);
		homeConcessionPane.add(firstPane, "0");
		cardLayout.show(homeConcessionPane, "0");
		
		firstPane.add(labelTitle);
		labelTitle.setBounds(54, 8, 440, 35);
		labelTitle.setForeground(new Color(0, 0, 0));
		labelTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		firstPane.add(buttonBack);
		buttonBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				homeConcessionPane.getParent().setVisible(false);
				PanelBooking.cardLayout.show(PanelBooking.homeBookingPane, "1");
				CMB9h30.str.clear();
				CMB9h30.countSeatCMB9h30 = 0;;
			}
		});	
		buttonBack.setBackground(new Color(205, 102, 102));
		buttonBack.setBorder(null);
		buttonBack.setBounds(10, 10, 32, 26);
		buttonBack.setIcon(new ImageIcon(image_Back));
		
		firstPane.add(panelMenu);
		panelMenu.setBounds(0 , 0, 747, 580);
		panelMenu.setLayout(null);
		panelMenu.setBackground(new Color(205, 102, 102));
		
		GridBagLayout gbl_panelMenu = new GridBagLayout();
		gbl_panelMenu.columnWidths = new int[]{160, 400, 53, 80};
		gbl_panelMenu.rowHeights = new int[]{40, 190, 160, 160,};
		gbl_panelMenu.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panelMenu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panelMenu.setLayout(gbl_panelMenu);
		
		GridBagConstraints gbc_imageOxCombo = new GridBagConstraints();
		gbc_imageOxCombo.fill = GridBagConstraints.BOTH;
		gbc_imageOxCombo.insets = new Insets(0, 0, 0, 0);
		gbc_imageOxCombo.gridx = 0;
		gbc_imageOxCombo.gridy = 1;
		panelMenu.add(imageOxCombo, gbc_imageOxCombo);
		imageOxCombo.setIcon(new ImageIcon(image_oxCombo));
		
		GridBagConstraints gbc_textAmount1 = new GridBagConstraints();
		gbc_textAmount1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAmount1.insets = new Insets(0, 10, 0, 25);
		gbc_textAmount1.gridx = 2;
		gbc_textAmount1.gridy = 1;
		panelMenu.add(amount1, gbc_textAmount1);
		amount1.setBounds(0, 0, 40, 40);
		amount1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		amount1.setText("      " + Integer.toString(total1));
		amount1.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_imageIncrease1 = new GridBagConstraints();
		gbc_imageIncrease1.fill = GridBagConstraints.HORIZONTAL;
		gbc_imageIncrease1.insets = new Insets(-70, 10, 0, 25);
		gbc_imageIncrease1.gridx = 2;
		gbc_imageIncrease1.gridy = 1;
		panelMenu.add(imageIncrease1, gbc_imageIncrease1);
		imageIncrease1.setFocusPainted(false);
		imageIncrease1.setBounds(0, 0, 0, 0);
		imageIncrease1.setBorderPainted(false);
		imageIncrease1.setIcon(new ImageIcon(image_increase));
		imageIncrease1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				imageIncrease1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				total1++;
				amount1.setText("      " + Integer.toString(total1));
			}
		});
		
		GridBagConstraints gbc_imageDecrease1 = new GridBagConstraints();
		gbc_imageDecrease1.fill = GridBagConstraints.HORIZONTAL;
		gbc_imageDecrease1.insets = new Insets(70, 10, 0, 25);
		gbc_imageDecrease1.gridx = 2;
		gbc_imageDecrease1.gridy = 1;
		panelMenu.add(imageDecrease1, gbc_imageDecrease1);
		imageDecrease1.setFocusPainted(false);
		imageDecrease1.setBounds(0, 0, 22, 29);
		imageDecrease1.setBorderPainted(false);
		imageDecrease1.setIcon(new ImageIcon(image_decrease));
		imageDecrease1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				imageDecrease1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(total1 <= 0)
					total1 = 0;
				else {
					total1 -= 1;
					amount1.setText("      " + Integer.toString(total1));
				}
			}
		});
		
		GridBagConstraints gbc_textOxCombo = new GridBagConstraints();
		gbc_textOxCombo.insets = new Insets(0, 0, 0, 0);
		gbc_textOxCombo.gridx = 1;
		gbc_textOxCombo.gridy = 1;
		panelMenu.add(textOxCombo, gbc_textOxCombo);
		textOxCombo.setEditable(false);
		textOxCombo.setForeground(Color.BLACK);
		textOxCombo.setBackground(new Color(205, 102, 102));
		textOxCombo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textOxCombo.setText("    Combo gồm: 1 ly con Trâu (kèm nước) + 1 bắp "
				+ "\n    ngọt lớn. "
				+ "\n    Lưu ý:"
				+ "\n    - Miễn phí đổi vị sang bắp Phô mai, Caramel."
				+ "\n    - Combo chỉ có giá trị đổi trong ngày."
				+ "\n    *Giá: 249.000 đ");
		
		
		GridBagConstraints gbc_imageMyCombo = new GridBagConstraints();
		gbc_imageMyCombo.fill = GridBagConstraints.BOTH;
		gbc_imageMyCombo.insets = new Insets(0, 0, 0, 0);
		gbc_imageMyCombo.gridx = 0;
		gbc_imageMyCombo.gridy = 2;
		panelMenu.add(imageMyCombo, gbc_imageMyCombo);
		imageMyCombo.setIcon(new ImageIcon(image_myCombo));
		
		GridBagConstraints gbc_textAmount2 = new GridBagConstraints();
		gbc_textAmount2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAmount2.insets = new Insets(0, 10, 0, 25);
		gbc_textAmount2.gridx = 2;
		gbc_textAmount2.gridy = 2;
		panelMenu.add(amount2, gbc_textAmount2);
		amount2.setBounds(0, 0, 40, 40);
		amount2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		amount2.setText("      " + Integer.toString(total2));
		amount2.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_imageIncrease2 = new GridBagConstraints();
		gbc_imageIncrease2.fill = GridBagConstraints.HORIZONTAL;
		gbc_imageIncrease2.insets = new Insets(-70, 10, 0, 25);
		gbc_imageIncrease2.gridx = 2;
		gbc_imageIncrease2.gridy = 2;
		panelMenu.add(imageIncrease2, gbc_imageIncrease2);
		imageIncrease2.setFocusPainted(false);
		imageIncrease2.setBounds(0, 0, 0, 0);
		imageIncrease2.setBorderPainted(false);
		imageIncrease2.setIcon(new ImageIcon(image_increase));
		imageIncrease2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				imageIncrease2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				total2 += 1;
				amount2.setText("      " + Integer.toString(total2));
			}
		});
		
		GridBagConstraints gbc_imageDecrease2 = new GridBagConstraints();
		gbc_imageDecrease2.fill = GridBagConstraints.HORIZONTAL;
		gbc_imageDecrease2.insets = new Insets(70, 10, 0, 25);
		gbc_imageDecrease2.gridx = 2;
		gbc_imageDecrease2.gridy = 2;
		panelMenu.add(imageDecrease2, gbc_imageDecrease2);
		imageDecrease2.setFocusPainted(false);
		imageDecrease2.setBounds(0, 0, 0, 0);
		imageDecrease2.setBorderPainted(false);
		imageDecrease2.setIcon(new ImageIcon(image_decrease));
		imageDecrease2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				imageDecrease2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(total2 <= 0)
					total2 = 0;
				else {
					total2 -= 1;
					amount2.setText("      " + Integer.toString(total2));
				}
			}
		});
		
		GridBagConstraints gbc_textMyCombo = new GridBagConstraints();
		gbc_textMyCombo.insets = new Insets(0, 0, 0, 0);
		gbc_textMyCombo.gridx = 1;
		gbc_textMyCombo.gridy = 2;
		panelMenu.add(textMyCombo, gbc_textMyCombo);
		textMyCombo.setEditable(false);
		textMyCombo.setForeground(Color.BLACK);
		textMyCombo.setBackground(new Color(205, 102, 102));
		textMyCombo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textMyCombo.setText("    Combo gồm: 1 nước cỡ lớn + 1 bắp ngọt vừa. "
				+ "\n    Lưu ý:"
				+ "\n    - Miễn phí đổi vị sang bắp Caramel."
				+ "\n    - Đổi vị sang bắp Phô mai phụ thu thêm tiền."
				+ "\n    - Combo chỉ có giá trị đổi trong ngày."
				+ "\n    *Giá: 79.000 đ");
		
		GridBagConstraints gbc_imagePairCombo = new GridBagConstraints();
		gbc_imagePairCombo.fill = GridBagConstraints.BOTH;
		gbc_imagePairCombo.insets = new Insets(0, 0, 0, 0);
		gbc_imagePairCombo.gridx = 0;
		gbc_imagePairCombo.gridy = 3;
		panelMenu.add(imagePairCombo, gbc_imagePairCombo);
		imagePairCombo.setIcon(new ImageIcon(image_pairCombo));
		
		GridBagConstraints gbc_textAmount3 = new GridBagConstraints();
		gbc_textAmount3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAmount3.insets = new Insets(0, 10, 0, 25);
		gbc_textAmount3.gridx = 2;
		gbc_textAmount3.gridy = 3;
		panelMenu.add(amount3, gbc_textAmount3);
		amount3.setBounds(0, 0, 40, 40);
		amount3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		amount3.setText("      " + Integer.toString(total3));
		amount3.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_imageIncrease3 = new GridBagConstraints();
		gbc_imageIncrease3.fill = GridBagConstraints.HORIZONTAL;
		gbc_imageIncrease3.insets = new Insets(-70, 10, 0, 25);
		gbc_imageIncrease3.gridx = 2;
		gbc_imageIncrease3.gridy = 3;
		panelMenu.add(imageIncrease3, gbc_imageIncrease3);
		imageIncrease3.setFocusPainted(false);
		imageIncrease3.setBounds(0, 0, 0, 0);
		imageIncrease3.setBorderPainted(false);
		imageIncrease3.setIcon(new ImageIcon(image_increase));
		imageIncrease3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				imageIncrease3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				total3 += 1;
				amount3.setText("      " + Integer.toString(total3));
			}
		});
		
		GridBagConstraints gbc_imageDecrease3 = new GridBagConstraints();
		gbc_imageDecrease3.fill = GridBagConstraints.HORIZONTAL;
		gbc_imageDecrease3.insets = new Insets(70, 10, 0, 25);
		gbc_imageDecrease3.gridx = 2;
		gbc_imageDecrease3.gridy = 3;
		panelMenu.add(imageDecrease3, gbc_imageDecrease3);
		imageDecrease3.setFocusPainted(false);
		imageDecrease3.setBounds(0, 0, 0, 0);
		imageDecrease3.setBorderPainted(false);
		imageDecrease3.setIcon(new ImageIcon(image_decrease));
		imageDecrease3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				imageDecrease3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(total3 <= 0)
					total3 = 0;
				else {
					total3 -= 1;
					amount3.setText("      " + Integer.toString(total3));
				}
			}
		});
		
		GridBagConstraints gbc_textPairCombo = new GridBagConstraints();
		gbc_textPairCombo.insets = new Insets(0, 0, 0, 0);
		gbc_textPairCombo.gridx = 1;
		gbc_textPairCombo.gridy = 3;
		panelMenu.add(textPairCombo, gbc_textPairCombo);
		textPairCombo.setEditable(false);
		textPairCombo.setForeground(Color.BLACK);
		textPairCombo.setBackground(new Color(205, 102, 102));
		textPairCombo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textPairCombo.setText("    Combo gồm: 2 nước cỡ vừa + 1 bắp ngọt lớn. "
				+ "\n    Lưu ý:"
				+ "\n    - Miễn phí đổi vị sang bắp Caramel."
				+ "\n    - Đổi vị sang bắp Phô mai phụ thu thêm tiền."
				+ "\n    - Combo chỉ có giá trị đổi trong ngày."
				+ "\n    *Giá: 99.000 đ");
		
		GridBagConstraints gbc_buttonNext = new GridBagConstraints();
		gbc_buttonNext.anchor = GridBagConstraints.WEST;
		gbc_buttonNext.insets = new Insets(0, 0, 0, 0);
		gbc_buttonNext.gridx = 3;
		gbc_buttonNext.gridy = 2;
		panelMenu.add(buttonNext, gbc_buttonNext);
		buttonNext.setBorder(null);
		buttonNext.setContentAreaFilled(false);
		buttonNext.setOpaque(true);
		buttonNext.setBackground(new Color(205, 102, 102));
		buttonNext.setIcon(new ImageIcon(image_nextButton));
		buttonNext.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				FinalPaymentCMB9h30.textSeat.setText((CMB9h30.str).toString());
				FinalPaymentCMB9h30.textPriceCombo.setText(Integer.toString(total1*249 + total2*79 + total3*99) + ".000 đ");
				FinalPaymentCMB9h30.textPriceTicket.setText(Integer.toString(CMB9h30.countSeatCMB9h30*100) + ".000 đ");
				FinalPaymentCMB9h30.textPriceTotal.setText(Integer.toString(CMB9h30.countSeatCMB9h30*100 + (total1*249 + total2*79 + total3*99)) + ".000 đ");

				PanelBooking.cardLayout.show(PanelBooking.homeBookingPane, "final1");
			}
		});

	}

}
