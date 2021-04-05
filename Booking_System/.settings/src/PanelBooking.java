import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelBooking extends JPanel {
	private Image image_Back = new ImageIcon(PanelBooking.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image posterCMB = new ImageIcon(PanelBooking.class.getResource("posterNowShowing/poster_CMB.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image posterWW = new ImageIcon(PanelBooking.class.getResource("posterNowShowing/poster_WW.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image posterNobita = new ImageIcon(PanelBooking.class.getResource("posterNowShowing/poster_nobita.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image posterNSK = new ImageIcon(PanelBooking.class.getResource("posterNowShowing/poster_NSK.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image posterSoul = new ImageIcon(PanelBooking.class.getResource("posterNowShowing/poster_soul.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	private Image posterNCQPN = new ImageIcon(PanelBooking.class.getResource("posterNowShowing/poster_NCQPN.jpg")).getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH);
	
	public static CardLayout cardLayout = new CardLayout();
	public static JPanel firstPane = new JPanel();
	public static JPanel homeBookingPane = new JPanel();
	
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel imageCMB = new JLabel("");
	private final JLabel titleCMB = new JLabel("CHỊ MƯỜI BA: 3 NGÀY SINH TỬ");
	private final JLabel imageNobita = new JLabel("");
	private final JLabel titleNobita = new JLabel("NOBITA VÀ NHỮNG KHỦNG LONG");
	private final JLabel imageWW = new JLabel("");
	private final JLabel titleWW = new JLabel("NỮ THẦN CHIẾN BINH");
	private final JLabel imageNSK = new JLabel("");
	private final JLabel titleNSK = new JLabel("NGHỀ SIÊU KHÓ");
	private final JLabel imageSoul = new JLabel("");
	private final JLabel titleSoul = new JLabel("CUỘC SỐNG NHIỆM MÀU");
	private final JLabel imageNCQPN = new JLabel("");
	private final JLabel titleNCQPN = new JLabel("NGƯỜI CẦN QUÊN PHẢI NHỚ");
	
	private final JLabel lblNewLabel = new JLabel("Đặt vé online - Chọn phim");
	private final JButton buttonBack = new JButton("");
	private final JPanel panelMenu = new JPanel();
	private final JButton CMB9h30 = new JButton("09:30 AM");
	private final JButton CMB13h20 = new JButton("13:20 PM");
	private final JButton CMB18h30 = new JButton("18:30 PM");
	private final JButton CMB20h35 = new JButton("20:35 PM");
	private final JButton WW9h45 = new JButton("09:45 AM");
	private final JButton WW12h00 = new JButton("12:30 PM");
	private final JButton WW15h40 = new JButton("15:40 PM");
	private final JButton WW18h15 = new JButton("18:15 PM");
	private final JButton WW20h20 = new JButton("20:20 PM");
	private final JButton Nobita10h00 = new JButton("10:00 PM");
	private final JButton Nobita12h50 = new JButton("12:50 PM");
	private final JButton Nobita16h40 = new JButton("16:40 PM");
	private final JButton NSK10h20 = new JButton("10:20 PM");
	private final JButton NSK14h10 = new JButton("14:10 PM");
	private final JButton NSK19h30 = new JButton("19:30 PM");
	private final JButton NSK21h30 = new JButton("21:30 PM");
	private final JButton Soul10h45 = new JButton("10:45 PM");
	private final JButton Soul14h40 = new JButton("14:40 PM");
	private final JButton Soul17h25 = new JButton("17:25 PM");
	private final JButton Soul19h25 = new JButton("19:25 PM");
	private final JButton NCQPN18h10 = new JButton("18:10 PM");
	private final JButton NCQPN20h00 = new JButton("20:00 PM");
	
	public CMB9h30 sheet1 = new CMB9h30();
	public CMB13h20 sheet2 = new CMB13h20();
	public CMB18h30 sheet3 = new CMB18h30();
	public CMB20h35 sheet4 = new CMB20h35();
	public WW9h45 sheet5 = new WW9h45();
	public WW12h00 sheet7 = new WW12h00();
	public WW15h40 sheet6 = new WW15h40();
	public WW18h15 sheet8 = new WW18h15();
	public WW20h20 sheet9 = new WW20h20();
	public ConcessionCMB9h30 concession1 = new ConcessionCMB9h30();
	public ConcessionCMB13h20 concession2 = new ConcessionCMB13h20();
	public ConcessionCMB18h30 concession3 = new ConcessionCMB18h30();
	public ConcessionCMB20h35 concession4 = new ConcessionCMB20h35();
	public ConcessionWW9h45 concession5 = new ConcessionWW9h45();
	public ConcessionWW12h00 concession6 = new ConcessionWW12h00();
	public ConcessionWW15h40 concession7 = new ConcessionWW15h40();
	public ConcessionWW18h15 concession8 = new ConcessionWW18h15();
	public ConcessionWW20h20 concession9 = new ConcessionWW20h20();
	public FinalPaymentCMB9h30 finalPane1 = new FinalPaymentCMB9h30();
	public FinalPaymentCMB13h20 finalPane2 = new FinalPaymentCMB13h20();
	public FinalPaymentCMB18h30 finalPane3 = new FinalPaymentCMB18h30();
	public FinalPaymentCMB20h35 finalPane4 = new FinalPaymentCMB20h35();
	public FinalPaymentWW9h45 finalPane5 = new FinalPaymentWW9h45();
	public FinalPaymentWW12h00 finalPane6 = new FinalPaymentWW12h00();
	public FinalPaymentWW15h40 finalPane7 = new FinalPaymentWW15h40();
	public FinalPaymentWW18h15 finalPane8 = new FinalPaymentWW18h15();
	public FinalPaymentWW20h20 finalPane9 = new FinalPaymentWW20h20();

	//Create the panel.
	public PanelBooking() {
		initGUI();
	}
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setLayout(null);
		setBackground(new Color(205, 102, 102));
		
		add(homeBookingPane);
		homeBookingPane.setBounds(0 , 0, 747, 580);
		homeBookingPane.setLayout(null);
		homeBookingPane.setBackground(new Color(205, 102, 102));
		
		homeBookingPane.setLayout(cardLayout);
		homeBookingPane.add(firstPane, "0");
		homeBookingPane.add(sheet1, "1");
		homeBookingPane.add(sheet2, "2");
		homeBookingPane.add(sheet3, "3");
		homeBookingPane.add(sheet4, "4");
		homeBookingPane.add(sheet5, "5");
		homeBookingPane.add(sheet6, "6");
		homeBookingPane.add(sheet7, "7");
		homeBookingPane.add(sheet8, "8");
		homeBookingPane.add(sheet9, "9");
		homeBookingPane.add(concession1, "con1");
		homeBookingPane.add(concession2, "con2");
		homeBookingPane.add(concession3, "con3");
		homeBookingPane.add(concession4, "con4");
		homeBookingPane.add(concession5, "con5");
		homeBookingPane.add(concession6, "con6");
		homeBookingPane.add(concession7, "con7");
		homeBookingPane.add(concession8, "con8");
		homeBookingPane.add(concession9, "con9");
		homeBookingPane.add(finalPane1, "final1");
		homeBookingPane.add(finalPane2, "final2");
		homeBookingPane.add(finalPane3, "final3");
		homeBookingPane.add(finalPane4, "final4");
		homeBookingPane.add(finalPane5, "final5");
		homeBookingPane.add(finalPane6, "final6");
		homeBookingPane.add(finalPane7, "final7");
		homeBookingPane.add(finalPane8, "final8");
		homeBookingPane.add(finalPane9, "final9");
		cardLayout.show(homeBookingPane, "0");
		
		firstPane.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(54, 8, 334, 35);
		
		firstPane.setBounds(0 , 0, 747, 580);
		firstPane.setLayout(null);
		firstPane.setBackground(new Color(205, 102, 102));
		
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
		
		firstPane.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 48, 747, 532);
		scrollPane.setBorder(null);
		scrollPane.setViewportView(panelMenu);
		panelMenu.setBorder(null);
		panelMenu.setBackground(new Color(205, 102, 102));
		
		GridBagLayout gbl_panelMenu = new GridBagLayout();
		gbl_panelMenu.columnWidths = new int[]{20, 200, 130, 30, 200, 130, 0};
		gbl_panelMenu.rowHeights = new int[]{40, 50, 50, 50, 50, 50, 20, 40, 50, 50, 50, 50, 50, 20, 40, 50, 50, 50, 50, 50, 20};
		gbl_panelMenu.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelMenu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMenu.setLayout(gbl_panelMenu);
		
		GridBagConstraints gbc_imageCMB = new GridBagConstraints();
		gbc_imageCMB.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageCMB.insets = new Insets(0, 0, 5, 5);
		gbc_imageCMB.gridheight = 6;
		gbc_imageCMB.gridx = 1;
		gbc_imageCMB.gridy = 1;
		panelMenu.add(imageCMB, gbc_imageCMB);
		imageCMB.setIcon(new ImageIcon(posterCMB));
		
		GridBagConstraints gbc_titleCMB = new GridBagConstraints();
		gbc_titleCMB.anchor = GridBagConstraints.SOUTH;
		gbc_titleCMB.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleCMB.insets = new Insets(0, 0, 5, 5);
		gbc_titleCMB.gridwidth = 2;
		gbc_titleCMB.gridx = 1;
		gbc_titleCMB.gridy = 0;
		panelMenu.add(titleCMB, gbc_titleCMB);
		titleCMB.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		GridBagConstraints gbc_CMB9h30 = new GridBagConstraints();
		gbc_CMB9h30.fill = GridBagConstraints.BOTH;
		gbc_CMB9h30.insets = new Insets(0, 0, 5, 5);
		gbc_CMB9h30.gridx = 2;
		gbc_CMB9h30.gridy = 1;
		panelMenu.add(CMB9h30, gbc_CMB9h30);
		CMB9h30.setFocusPainted(false);
		CMB9h30.setFont(new Font("Tahoma", Font.BOLD, 18));
		CMB9h30.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				CMB9h30.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				sheet1.updateSeat();
				cardLayout.show(homeBookingPane, "1");
			}
		});

		GridBagConstraints gbc_CMB13h20 = new GridBagConstraints();
		gbc_CMB13h20.fill = GridBagConstraints.BOTH;
		gbc_CMB13h20.insets = new Insets(0, 0, 5, 5);
		gbc_CMB13h20.gridx = 2;
		gbc_CMB13h20.gridy = 2;
		panelMenu.add(CMB13h20, gbc_CMB13h20);
		CMB13h20.setFocusPainted(false);
		CMB13h20.setFont(new Font("Tahoma", Font.BOLD, 18));
		CMB13h20.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				CMB13h20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				sheet2.updateSeat();
				cardLayout.show(homeBookingPane, "2");
			}
		});
		
		GridBagConstraints gbc_CMB18h30 = new GridBagConstraints();
		gbc_CMB18h30.fill = GridBagConstraints.BOTH;
		gbc_CMB18h30.insets = new Insets(0, 0, 5, 5);
		gbc_CMB18h30.gridx = 2;
		gbc_CMB18h30.gridy = 3;
		panelMenu.add(CMB18h30, gbc_CMB18h30);
		CMB18h30.setFocusPainted(false);
		CMB18h30.setFont(new Font("Tahoma", Font.BOLD, 18));
		CMB18h30.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				CMB18h30.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				sheet3.updateSeat();
				cardLayout.show(homeBookingPane, "3");
			}
		});
		
		GridBagConstraints gbc_CMB20h35 = new GridBagConstraints();
		gbc_CMB20h35.fill = GridBagConstraints.BOTH;
		gbc_CMB20h35.insets = new Insets(0, 0, 5, 5);
		gbc_CMB20h35.gridx = 2;
		gbc_CMB20h35.gridy = 4;
		panelMenu.add(CMB20h35, gbc_CMB20h35);
		CMB20h35.setFocusPainted(false);
		CMB20h35.setFont(new Font("Tahoma", Font.BOLD, 18));
		CMB20h35.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				CMB20h35.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				sheet4.updateSeat();
				cardLayout.show(homeBookingPane, "4");
			}
		});
		
		GridBagConstraints gbc_imageWW = new GridBagConstraints();
		gbc_imageWW.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageWW.insets = new Insets(0, 0, 5, 5);
		gbc_imageWW.gridheight = 6;
		gbc_imageWW.gridx = 4;
		gbc_imageWW.gridy = 1;
		panelMenu.add(imageWW, gbc_imageWW);
		imageWW.setIcon(new ImageIcon(posterWW));
		
		GridBagConstraints gbc_titleWW = new GridBagConstraints();
		gbc_titleWW.anchor = GridBagConstraints.SOUTHWEST;
		gbc_titleWW.insets = new Insets(0, 0, 5, 0);
		gbc_titleWW.gridwidth = 2;
		gbc_titleWW.gridx = 4;
		gbc_titleWW.gridy = 0;
		panelMenu.add(titleWW, gbc_titleWW);
		titleWW.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		GridBagConstraints gbc_WW9h45 = new GridBagConstraints();
		gbc_WW9h45.fill = GridBagConstraints.BOTH;
		gbc_WW9h45.insets = new Insets(0, 0, 5, 0);
		gbc_WW9h45.gridx = 5;
		gbc_WW9h45.gridy = 1;
		panelMenu.add(WW9h45, gbc_WW9h45);
		WW9h45.setFocusPainted(false);
		WW9h45.setFont(new Font("Tahoma", Font.BOLD, 18));
		WW9h45.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				WW9h45.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				sheet5.updateSeat();
				cardLayout.show(homeBookingPane, "5");
			}
		});
		
		
		GridBagConstraints gbc_WW12h00 = new GridBagConstraints();
		gbc_WW12h00.fill = GridBagConstraints.BOTH;
		gbc_WW12h00.insets = new Insets(0, 0, 5, 0);
		gbc_WW12h00.gridx = 5;
		gbc_WW12h00.gridy = 2;
		panelMenu.add(WW12h00, gbc_WW12h00);
		WW12h00.setFocusPainted(false);
		WW12h00.setFont(new Font("Tahoma", Font.BOLD, 18));
		WW12h00.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				WW12h00.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				sheet6.updateSeat();
				cardLayout.show(homeBookingPane, "6");
			}
		});
		
		GridBagConstraints gbc_WW15h40 = new GridBagConstraints();
		gbc_WW15h40.fill = GridBagConstraints.BOTH;
		gbc_WW15h40.insets = new Insets(0, 0, 5, 0);
		gbc_WW15h40.gridx = 5;
		gbc_WW15h40.gridy = 3;
		panelMenu.add(WW15h40, gbc_WW15h40);
		WW15h40.setFocusPainted(false);
		WW15h40.setFont(new Font("Tahoma", Font.BOLD, 18));
		WW15h40.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				WW15h40.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				sheet7.updateSeat();
				cardLayout.show(homeBookingPane, "7");
			}
		});
		
		GridBagConstraints gbc_WW18h15 = new GridBagConstraints();
		gbc_WW18h15.fill = GridBagConstraints.BOTH;
		gbc_WW18h15.insets = new Insets(0, 0, 5, 0);
		gbc_WW18h15.gridx = 5;
		gbc_WW18h15.gridy = 4;
		panelMenu.add(WW18h15, gbc_WW18h15);
		WW18h15.setFocusPainted(false);
		WW18h15.setFont(new Font("Tahoma", Font.BOLD, 18));
		WW18h15.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				WW18h15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				sheet8.updateSeat();
				cardLayout.show(homeBookingPane, "8");
			}
		});
		
		GridBagConstraints gbc_WW20h20 = new GridBagConstraints();
		gbc_WW20h20.insets = new Insets(0, 0, 5, 0);
		gbc_WW20h20.fill = GridBagConstraints.BOTH;
		gbc_WW20h20.gridx = 5;
		gbc_WW20h20.gridy = 5;
		panelMenu.add(WW20h20, gbc_WW20h20);
		WW20h20.setFocusPainted(false);
		WW20h20.setFont(new Font("Tahoma", Font.BOLD, 18));
		WW20h20.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				WW20h20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				sheet9.updateSeat();
				cardLayout.show(homeBookingPane, "9");
			}
		});
		
		imageNobita.setIcon(new ImageIcon(posterNobita));
		GridBagConstraints gbc_imageNobita = new GridBagConstraints();
		gbc_imageNobita.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageNobita.insets = new Insets(0, 0, 0, 5);
		gbc_imageNobita.gridheight = 6;
		gbc_imageNobita.gridx = 1;
		gbc_imageNobita.gridy = 8;
		panelMenu.add(imageNobita, gbc_imageNobita);
		
		GridBagConstraints gbc_titleNobita = new GridBagConstraints();
		gbc_titleNobita.anchor = GridBagConstraints.SOUTH;
		gbc_titleNobita.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleNobita.insets = new Insets(0, 0, 5, 5);
		gbc_titleNobita.gridwidth = 3;
		gbc_titleNobita.gridx = 1;
		gbc_titleNobita.gridy = 7;
		panelMenu.add(titleNobita, gbc_titleNobita);
		titleNobita.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		GridBagConstraints gbc_Nobita10h00 = new GridBagConstraints();
		gbc_Nobita10h00.fill = GridBagConstraints.BOTH;
		gbc_Nobita10h00.insets = new Insets(0, 0, 5, 0);
		gbc_Nobita10h00.gridx = 2;
		gbc_Nobita10h00.gridy = 8;
		panelMenu.add(Nobita10h00, gbc_Nobita10h00);
		Nobita10h00.setFocusPainted(false);
		Nobita10h00.setFont(new Font("Tahoma", Font.BOLD, 18));
		Nobita10h00.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Nobita10h00.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		GridBagConstraints gbc_Nobita12h50 = new GridBagConstraints();
		gbc_Nobita12h50.fill = GridBagConstraints.BOTH;
		gbc_Nobita12h50.insets = new Insets(0, 0, 5, 0);
		gbc_Nobita12h50.gridx = 2;
		gbc_Nobita12h50.gridy = 9;
		panelMenu.add(Nobita12h50, gbc_Nobita12h50);
		Nobita12h50.setFocusPainted(false);
		Nobita12h50.setFont(new Font("Tahoma", Font.BOLD, 18));
		Nobita12h50.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Nobita12h50.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		GridBagConstraints gbc_Nobita16h40 = new GridBagConstraints();
		gbc_Nobita16h40.insets = new Insets(0, 0, 5, 0);
		gbc_Nobita16h40.fill = GridBagConstraints.BOTH;
		gbc_Nobita16h40.gridx = 2;
		gbc_Nobita16h40.gridy = 10;
		panelMenu.add(Nobita16h40, gbc_Nobita16h40);
		Nobita16h40.setFocusPainted(false);
		Nobita16h40.setFont(new Font("Tahoma", Font.BOLD, 18));
		Nobita16h40.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Nobita16h40.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		GridBagConstraints gbc_imageNSK = new GridBagConstraints();
		gbc_imageNSK.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageNSK.insets = new Insets(0, 0, 5, 5);
		gbc_imageNSK.gridheight = 6;
		gbc_imageNSK.gridx = 4;
		gbc_imageNSK.gridy = 8;
		panelMenu.add(imageNSK, gbc_imageNSK);
		imageNSK.setIcon(new ImageIcon(posterNSK));
		
		GridBagConstraints gbc_titleNSK = new GridBagConstraints();
		gbc_titleNSK.anchor = GridBagConstraints.SOUTH;
		gbc_titleNSK.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleNSK.insets = new Insets(0, 0, 5, 5);
		gbc_titleNSK.gridwidth = 2;
		gbc_titleNSK.gridx = 4;
		gbc_titleNSK.gridy = 7;
		panelMenu.add(titleNSK, gbc_titleNSK);
		titleNSK.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		GridBagConstraints gbc_NSK10h20 = new GridBagConstraints();
		gbc_NSK10h20.fill = GridBagConstraints.BOTH;
		gbc_NSK10h20.insets = new Insets(0, 0, 5, 5);
		gbc_NSK10h20.gridx = 5;
		gbc_NSK10h20.gridy = 8;
		panelMenu.add(NSK10h20, gbc_NSK10h20);
		NSK10h20.setFocusPainted(false);
		NSK10h20.setFont(new Font("Tahoma", Font.BOLD, 18));
		NSK10h20.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				NSK10h20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {

			}
		});

		GridBagConstraints gbc_NSK14h10 = new GridBagConstraints();
		gbc_NSK14h10.fill = GridBagConstraints.BOTH;
		gbc_NSK14h10.insets = new Insets(0, 0, 5, 5);
		gbc_NSK14h10.gridx = 5;
		gbc_NSK14h10.gridy = 9;
		panelMenu.add(NSK14h10, gbc_NSK14h10);
		NSK14h10.setFocusPainted(false);
		NSK14h10.setFont(new Font("Tahoma", Font.BOLD, 18));
		NSK14h10.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				NSK14h10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		GridBagConstraints gbc_NSK19h30 = new GridBagConstraints();
		gbc_NSK19h30.fill = GridBagConstraints.BOTH;
		gbc_NSK19h30.insets = new Insets(0, 0, 5, 5);
		gbc_NSK19h30.gridx = 5;
		gbc_NSK19h30.gridy = 10;
		panelMenu.add(NSK19h30, gbc_NSK19h30);
		NSK19h30.setFocusPainted(false);
		NSK19h30.setFont(new Font("Tahoma", Font.BOLD, 18));
		NSK19h30.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				NSK19h30.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		GridBagConstraints gbc_NSK21h30 = new GridBagConstraints();
		gbc_NSK21h30.fill = GridBagConstraints.BOTH;
		gbc_NSK21h30.insets = new Insets(0, 0, 5, 5);
		gbc_NSK21h30.gridx = 5;
		gbc_NSK21h30.gridy = 11;
		panelMenu.add(NSK21h30, gbc_NSK21h30);
		NSK21h30.setFocusPainted(false);
		NSK21h30.setFont(new Font("Tahoma", Font.BOLD, 18));
		NSK21h30.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				NSK21h30.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		GridBagConstraints gbc_imageSoul = new GridBagConstraints();
		gbc_imageSoul.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageSoul.insets = new Insets(0, 0, 5, 5);
		gbc_imageSoul.gridheight = 6;
		gbc_imageSoul.gridx = 1;
		gbc_imageSoul.gridy = 15;
		panelMenu.add(imageSoul, gbc_imageSoul);
		imageSoul.setIcon(new ImageIcon(posterSoul));
		
		GridBagConstraints gbc_titleSoul = new GridBagConstraints();
		gbc_titleSoul.anchor = GridBagConstraints.SOUTH;
		gbc_titleSoul.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleSoul.insets = new Insets(0, 0, 5, 5);
		gbc_titleSoul.gridwidth = 2;
		gbc_titleSoul.gridx = 1;
		gbc_titleSoul.gridy = 14;
		panelMenu.add(titleSoul, gbc_titleSoul);
		titleSoul.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		GridBagConstraints gbc_Soul10h45 = new GridBagConstraints();
		gbc_Soul10h45.fill = GridBagConstraints.BOTH;
		gbc_Soul10h45.insets = new Insets(0, 0, 5, 5);
		gbc_Soul10h45.gridx = 2;
		gbc_Soul10h45.gridy = 15;
		panelMenu.add(Soul10h45, gbc_Soul10h45);
		Soul10h45.setFocusPainted(false);
		Soul10h45.setFont(new Font("Tahoma", Font.BOLD, 18));
		Soul10h45.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Soul10h45.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {

			}
		});

		GridBagConstraints gbc_Soul14h40 = new GridBagConstraints();
		gbc_Soul14h40.fill = GridBagConstraints.BOTH;
		gbc_Soul14h40.insets = new Insets(0, 0, 5, 5);
		gbc_Soul14h40.gridx = 2;
		gbc_Soul14h40.gridy = 16;
		panelMenu.add(Soul14h40, gbc_Soul14h40);
		Soul14h40.setFocusPainted(false);
		Soul14h40.setFont(new Font("Tahoma", Font.BOLD, 18));
		Soul14h40.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Soul14h40.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		GridBagConstraints gbc_Soul17h25 = new GridBagConstraints();
		gbc_Soul17h25.fill = GridBagConstraints.BOTH;
		gbc_Soul17h25.insets = new Insets(0, 0, 5, 5);
		gbc_Soul17h25.gridx = 2;
		gbc_Soul17h25.gridy = 17;
		panelMenu.add(Soul17h25, gbc_Soul17h25);
		Soul17h25.setFocusPainted(false);
		Soul17h25.setFont(new Font("Tahoma", Font.BOLD, 18));
		Soul17h25.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Soul17h25.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		GridBagConstraints gbc_Soul19h25 = new GridBagConstraints();
		gbc_Soul19h25.fill = GridBagConstraints.BOTH;
		gbc_Soul19h25.insets = new Insets(0, 0, 5, 5);
		gbc_Soul19h25.gridx = 2;
		gbc_Soul19h25.gridy = 18;
		panelMenu.add(Soul19h25, gbc_Soul19h25);
		Soul19h25.setFocusPainted(false);
		Soul19h25.setFont(new Font("Tahoma", Font.BOLD, 18));
		Soul19h25.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Soul19h25.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		GridBagConstraints gbc_imageNCQPN = new GridBagConstraints();
		gbc_imageNCQPN.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageNCQPN.insets = new Insets(0, 0, 5, 5);
		gbc_imageNCQPN.gridheight = 6;
		gbc_imageNCQPN.gridx = 4;
		gbc_imageNCQPN.gridy = 15;
		panelMenu.add(imageNCQPN, gbc_imageNCQPN);
		imageNCQPN.setIcon(new ImageIcon(posterNCQPN));
		
		GridBagConstraints gbc_titleNCQPN = new GridBagConstraints();
		gbc_titleNCQPN.anchor = GridBagConstraints.SOUTHWEST;
		gbc_titleNCQPN.insets = new Insets(0, 0, 5, 0);
		gbc_titleNCQPN.gridwidth = 2;
		gbc_titleNCQPN.gridx = 4;
		gbc_titleNCQPN.gridy = 14;
		panelMenu.add(titleNCQPN, gbc_titleNCQPN);
		titleNCQPN.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		GridBagConstraints gbc_NCQPN18h10 = new GridBagConstraints();
		gbc_NCQPN18h10.fill = GridBagConstraints.BOTH;
		gbc_NCQPN18h10.insets = new Insets(0, 0, 5, 0);
		gbc_NCQPN18h10.gridx = 5;
		gbc_NCQPN18h10.gridy = 15;
		panelMenu.add(NCQPN18h10, gbc_NCQPN18h10);
		NCQPN18h10.setFocusPainted(false);
		NCQPN18h10.setFont(new Font("Tahoma", Font.BOLD, 18));
		NCQPN18h10.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				NCQPN18h10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		GridBagConstraints gbc_NCQPN20h00 = new GridBagConstraints();
		gbc_NCQPN20h00.fill = GridBagConstraints.BOTH;
		gbc_NCQPN20h00.insets = new Insets(0, 0, 5, 0);
		gbc_NCQPN20h00.gridx = 5;
		gbc_NCQPN20h00.gridy = 16;
		panelMenu.add(NCQPN20h00, gbc_NCQPN20h00);
		NCQPN20h00.setFocusPainted(false);
		NCQPN20h00.setFont(new Font("Tahoma", Font.BOLD, 18));
		NCQPN20h00.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				NCQPN20h00.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {

			}
		});
	}
}
