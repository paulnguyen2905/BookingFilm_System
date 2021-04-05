import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FinalPaymentWW20h20 extends JPanel {
	Connection connection = null;
	PreparedStatement info = null;
	ResultSet rs = null;
	
	private Image image_Back = new ImageIcon(FinalPaymentWW20h20.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_finalTicket = new ImageIcon(FinalPaymentWW20h20.class.getResource("image/finalTicket_icon.png")).getImage().getScaledInstance(700, 280, Image.SCALE_SMOOTH);
	private Image posterCMB = new ImageIcon(FinalPaymentWW20h20.class.getResource("posterNowShowing/poster_WW.jpg")).getImage().getScaledInstance(140, 188, Image.SCALE_SMOOTH);
	private Image image_MoMo = new ImageIcon(FinalPaymentWW20h20.class.getResource("image/momo_icon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image image_ZaloPay = new ImageIcon(FinalPaymentWW20h20.class.getResource("image/zalopay_icon.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
	private Image image_AirPay = new ImageIcon(FinalPaymentWW20h20.class.getResource("image/airpay_icon.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
	private Image image_Cash = new ImageIcon(FinalPaymentWW20h20.class.getResource("image/cash_icon.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
	private Image image_ATM = new ImageIcon(FinalPaymentWW20h20.class.getResource("image/atm_icon.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
	private Image image_Visa = new ImageIcon(FinalPaymentWW20h20.class.getResource("image/visa_icon.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
	private Image image_ViettelPay = new ImageIcon(FinalPaymentWW20h20.class.getResource("image/viettelpay_icon.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
	private Image image_Payment = new ImageIcon(FinalPaymentWW20h20.class.getResource("image/payment_icon.png")).getImage().getScaledInstance(90, 102, Image.SCALE_SMOOTH);
	
	private final JPanel panelMenu = new JPanel();
	private final JButton buttonBack = new JButton("");
	private final JButton buttonPayment = new JButton("");
	private final JLabel labelTitle = new JLabel("Thanh toán");
	private final JLabel labelPayment = new JLabel("Chọn hình thức thanh toán");
	private final JLabel imageFinalTicket = new JLabel("");
	private final JLabel imageFilm = new JLabel("");
	private final JTextArea textFilm = new JTextArea("");
	private final JTextArea labelbtnPayment = new JTextArea("");
	private final ButtonGroup btnGroup = new ButtonGroup();
	private final JRadioButton radiobtnMoMo = new JRadioButton("       Ví MoMo");
	private final JRadioButton radiobtnZaloPay = new JRadioButton("       ZaloPay");
	private final JRadioButton radiobtnAirPay = new JRadioButton("       AirPay");
	private final JRadioButton radiobtnATM = new JRadioButton("       ATM Card (Thẻ nội địa)");
	private final JRadioButton radiobtnCash = new JRadioButton("       Thanh toán tại quầy");
	private final JRadioButton radiobtnVisa = new JRadioButton("       Visa, Master (Thẻ quốc tế)");
	private final JRadioButton radiobtnViettelPay = new JRadioButton("       ViettelPay");
	private final JLabel imageMoMo = new JLabel("");
	private final JLabel imageZaloPay = new JLabel("");
	private final JLabel imageAirPay = new JLabel("");
	private final JLabel imageATM = new JLabel("");
	private final JLabel imageCash = new JLabel("");
	private final JLabel imageVisa = new JLabel("");
	private final JLabel imageViettelPay = new JLabel("");
	
	public static JTextArea textSeat = new JTextArea("");
	public static JTextArea textPriceCombo = new JTextArea("");
	public static JTextArea textPriceTicket = new JTextArea("");
	public static JTextArea textPriceTotal = new JTextArea("");
	
	ArrayList<JToggleButton> buttons = new ArrayList<JToggleButton>();
	ArrayList<String> seats = new ArrayList<String>();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	
	public static int amountOxCombo;
	public static int amountMyCombo;
	public static int amountPairCombo;
	
	
	//Create the panel.
	public FinalPaymentWW20h20() {
		initGUI();
	}
	
	public void initGUI() {
		setBounds(0 , 0, 747, 580);
		setLayout(null);
		setBackground(new Color(205, 102, 102));
		
		add(labelTitle);
		labelTitle.setBounds(54, 8, 440, 35);
		labelTitle.setForeground(new Color(0, 0, 0));
		labelTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		add(buttonBack);
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelBooking.cardLayout.show(PanelBooking.homeBookingPane, "con9");
			}
		});
		buttonBack.setBackground(new Color(205, 102, 102));
		buttonBack.setBorder(null);
		buttonBack.setBounds(10, 10, 32, 26);
		buttonBack.setIcon(new ImageIcon(image_Back));
		
		add(panelMenu);
		panelMenu.setBounds(0 , 0, 747, 580);
		panelMenu.setLayout(null);
		panelMenu.setBackground(new Color(205, 102, 102));
		
		GridBagLayout gbl_panelMenu = new GridBagLayout();
		gbl_panelMenu.columnWidths = new int[]{420, 320};
		gbl_panelMenu.rowHeights = new int[]{40, 280, 250};
		gbl_panelMenu.columnWeights = new double[]{0.0, 0.0};
		gbl_panelMenu.rowWeights = new double[]{0.0, 0.0, 0.0};
		panelMenu.setLayout(gbl_panelMenu);
		
		GridBagConstraints gbc_imageFilm = new GridBagConstraints();
		gbc_imageFilm.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageFilm.insets = new Insets(46, 126, 5, 0);
		gbc_imageFilm.gridwidth = 2;
		gbc_imageFilm.gridx = 0;
		gbc_imageFilm.gridy = 1;
		panelMenu.add(imageFilm, gbc_imageFilm);
		imageFilm.setIcon(new ImageIcon(posterCMB));
		
		GridBagConstraints gbc_textSeat = new GridBagConstraints();
		gbc_textSeat.anchor = GridBagConstraints.NORTHWEST;
		gbc_textSeat.insets = new Insets(127, 356, 5, 0);
		gbc_textSeat.gridwidth = 2;
		gbc_textSeat.gridx = 0;
		gbc_textSeat.gridy = 1;
		panelMenu.add(textSeat, gbc_textSeat);
		textSeat.setEditable(false);
		textSeat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textSeat.setForeground(new Color(205, 102, 102));
		textSeat.setBackground(Color.BLACK);
		textSeat.setText("Seats here");
		
		GridBagConstraints gbc_textPriceCombo = new GridBagConstraints();
		gbc_textPriceCombo.anchor = GridBagConstraints.NORTHWEST;
		gbc_textPriceCombo.insets = new Insets(151, 476, 5, 0);
		gbc_textPriceCombo.gridwidth = 2;
		gbc_textPriceCombo.gridx = 0;
		gbc_textPriceCombo.gridy = 1;
		panelMenu.add(textPriceCombo, gbc_textPriceCombo);
		textPriceCombo.setEditable(false);
		textPriceCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPriceCombo.setForeground(new Color(205, 102, 102));
		textPriceCombo.setBackground(Color.BLACK);
		textPriceCombo.setText("Price combo here");
		
		GridBagConstraints gbc_textPriceTicket = new GridBagConstraints();
		gbc_textPriceTicket.anchor = GridBagConstraints.NORTHWEST;
		gbc_textPriceTicket.insets = new Insets(175, 350, 5, 0);
		gbc_textPriceTicket.gridwidth = 2;
		gbc_textPriceTicket.gridx = 0;
		gbc_textPriceTicket.gridy = 1;
		panelMenu.add(textPriceTicket, gbc_textPriceTicket);
		textPriceTicket.setEditable(false);
		textPriceTicket.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPriceTicket.setForeground(new Color(205, 102, 102));
		textPriceTicket.setBackground(Color.BLACK);
		textPriceTicket.setText("Price ticket here");
		
		GridBagConstraints gbc_textPriceTotal = new GridBagConstraints();
		gbc_textPriceTotal.anchor = GridBagConstraints.NORTHWEST;
		gbc_textPriceTotal.insets = new Insets(199, 436, 5, 0);
		gbc_textPriceTotal.gridwidth = 2;
		gbc_textPriceTotal.gridx = 0;
		gbc_textPriceTotal.gridy = 1;
		panelMenu.add(textPriceTotal, gbc_textPriceTotal );
		textPriceTotal.setEditable(false);
		textPriceTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPriceTotal.setForeground(new Color(205, 102, 102));
		textPriceTotal.setBackground(Color.BLACK);
		textPriceTotal.setText("Total here");
		
		GridBagConstraints gbc_noteFilm = new GridBagConstraints();
		gbc_noteFilm.anchor = GridBagConstraints.NORTHWEST;
		gbc_noteFilm.insets = new Insets(54, 268, 5, 0);
		gbc_noteFilm.gridwidth = 2;
		gbc_noteFilm.gridx = 0;
		gbc_noteFilm.gridy = 1;
		panelMenu.add(textFilm, gbc_noteFilm);
		textFilm.setEditable(false);
		textFilm.setEnabled(false);
		textFilm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFilm.setForeground(Color.WHITE);
		textFilm.setBackground(Color.BLACK);
		textFilm.setText("| Tên phim: Wonder Woman 1984"
				+ "\n| Suất chiếu: 20:20 PM"
				+ "\n| Ngày chiếu: " + dateFormat.format(date)
				+ "\n| Số ghế: "
				+ "\n| Giá combo bắp nước: "
				+ "\n| Giá vé: "
				+ "\n| Tổng thành tiền: ");
		
		GridBagConstraints gbc_imageFinalTicket = new GridBagConstraints();
		gbc_imageFinalTicket.insets = new Insets(0, 0, 5, 0);
		gbc_imageFinalTicket.gridwidth = 2;
		gbc_imageFinalTicket.gridx = 0;
		gbc_imageFinalTicket.gridy = 1;
		panelMenu.add(imageFinalTicket, gbc_imageFinalTicket);
		imageFinalTicket.setBounds(0, 0, 400, 200);
		imageFinalTicket.setIcon(new ImageIcon(image_finalTicket));
		
		GridBagConstraints gbc_labelPayment = new GridBagConstraints();
		gbc_labelPayment.anchor = GridBagConstraints.NORTHWEST;
		gbc_labelPayment.insets = new Insets(10, 20, 0, 0);
		gbc_labelPayment.gridx = 0;
		gbc_labelPayment.gridy = 2;
		panelMenu.add(labelPayment, gbc_labelPayment);
		labelPayment.setBounds(54, 8, 440, 35);
		labelPayment.setForeground(new Color(0, 0, 0));
		labelPayment.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		btnGroup.add(radiobtnATM);
		btnGroup.add(radiobtnVisa);
		btnGroup.add(radiobtnCash);
		btnGroup.add(radiobtnMoMo);
		btnGroup.add(radiobtnZaloPay);
		btnGroup.add(radiobtnAirPay);
		btnGroup.add(radiobtnViettelPay);
		
		GridBagConstraints gbc_radiobtnATM = new GridBagConstraints();
		gbc_radiobtnATM.anchor = GridBagConstraints.NORTHWEST;
		gbc_radiobtnATM.insets = new Insets(48, 232, 0, 0);
		gbc_radiobtnATM.gridwidth = 2;
		gbc_radiobtnATM.gridx = 0;
		gbc_radiobtnATM.gridy = 2;
		panelMenu.add(radiobtnATM, gbc_radiobtnATM);
		radiobtnATM.setFont(new Font("Tahoma", Font.PLAIN, 22));
		radiobtnATM.setForeground(Color.BLACK);
		radiobtnATM.setContentAreaFilled(false);
		radiobtnATM.setFocusPainted(false);
		
		GridBagConstraints gbc_imageATM = new GridBagConstraints();
		gbc_imageATM.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageATM.insets = new Insets(46, 256, 0, 0);
		gbc_imageATM.gridwidth = 2;
		gbc_imageATM.gridx = 0;
		gbc_imageATM.gridy = 2;
		panelMenu.add(imageATM, gbc_imageATM);
		imageATM.setBounds(0, 0, 400, 200);
		imageATM.setIcon(new ImageIcon(image_ATM));
		
		GridBagConstraints gbc_radiobtnVisa = new GridBagConstraints();
		gbc_radiobtnVisa.anchor = GridBagConstraints.NORTHWEST;
		gbc_radiobtnVisa.insets = new Insets(100, 232, 0, 0);
		gbc_radiobtnVisa.gridwidth = 2;
		gbc_radiobtnVisa.gridx = 0;
		gbc_radiobtnVisa.gridy = 2;
		panelMenu.add(radiobtnVisa, gbc_radiobtnVisa);
		radiobtnVisa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		radiobtnVisa.setForeground(Color.BLACK);
		radiobtnVisa.setContentAreaFilled(false);
		radiobtnVisa.setFocusPainted(false);
		
		GridBagConstraints gbc_imageVisa = new GridBagConstraints();
		gbc_imageVisa.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageVisa.insets = new Insets(100, 256, 0, 0);
		gbc_imageVisa.gridwidth = 2;
		gbc_imageVisa.gridx = 0;
		gbc_imageVisa.gridy = 2;
		panelMenu.add(imageVisa, gbc_imageVisa);
		imageVisa.setBounds(0, 0, 400, 200);
		imageVisa.setIcon(new ImageIcon(image_Visa));
		
		GridBagConstraints gbc_radiobtnCash = new GridBagConstraints();
		gbc_radiobtnCash.anchor = GridBagConstraints.NORTHWEST;
		gbc_radiobtnCash.insets = new Insets(148, 232, 0, 0);
		gbc_radiobtnCash.gridwidth = 2;
		gbc_radiobtnCash.gridx = 0;
		gbc_radiobtnCash.gridy = 2;
		panelMenu.add(radiobtnCash, gbc_radiobtnCash);
		radiobtnCash.setFont(new Font("Tahoma", Font.PLAIN, 22));
		radiobtnCash.setForeground(Color.BLACK);
		radiobtnCash.setContentAreaFilled(false);
		radiobtnCash.setFocusPainted(false);
		radiobtnCash.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Khách hàng vui lòng có mặt tại quầy thanh toán trước 15 phút chiếu phim."
						+ "\nNếu không vé của quý khách sẽ tự động hủy để nhường chỗ cho khách khác."
						+ "\nXin chân thành cám ơn.", "Thông tin lưu ý!", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		GridBagConstraints gbc_imageCash = new GridBagConstraints();
		gbc_imageCash.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageCash.insets = new Insets(148, 256, 0, 0);
		gbc_imageCash.gridwidth = 2;
		gbc_imageCash.gridx = 0;
		gbc_imageCash.gridy = 2;
		panelMenu.add(imageCash, gbc_imageCash);
		imageCash.setBounds(0, 0, 400, 200);
		imageCash.setIcon(new ImageIcon(image_Cash));
		
		GridBagConstraints gbc_radiobtnMoMo = new GridBagConstraints();
		gbc_radiobtnMoMo.anchor = GridBagConstraints.NORTHWEST;
		gbc_radiobtnMoMo.insets = new Insets(54, 18, 0, 0);
		gbc_radiobtnMoMo.gridwidth = 2;
		gbc_radiobtnMoMo.gridx = 0;
		gbc_radiobtnMoMo.gridy = 2;
		panelMenu.add(radiobtnMoMo, gbc_radiobtnMoMo);
		radiobtnMoMo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		radiobtnMoMo.setForeground(Color.BLACK);
		radiobtnMoMo.setContentAreaFilled(false);
		radiobtnMoMo.setFocusPainted(false);
		
		GridBagConstraints gbc_imageMoMo = new GridBagConstraints();
		gbc_imageMoMo.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageMoMo.insets = new Insets(52, 41, 0, 0);
		gbc_imageMoMo.gridwidth = 2;
		gbc_imageMoMo.gridx = 0;
		gbc_imageMoMo.gridy = 2;
		panelMenu.add(imageMoMo, gbc_imageMoMo);
		imageMoMo.setBounds(0, 0, 400, 200);
		imageMoMo.setIcon(new ImageIcon(image_MoMo));
		
		GridBagConstraints gbc_radiobtnZaloPay = new GridBagConstraints();
		gbc_radiobtnZaloPay.anchor = GridBagConstraints.NORTHWEST;
		gbc_radiobtnZaloPay.insets = new Insets(100, 18, 0, 0);
		gbc_radiobtnZaloPay.gridwidth = 2;
		gbc_radiobtnZaloPay.gridx = 0;
		gbc_radiobtnZaloPay.gridy = 2;
		panelMenu.add(radiobtnZaloPay, gbc_radiobtnZaloPay);
		radiobtnZaloPay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		radiobtnZaloPay.setForeground(Color.BLACK);
		radiobtnZaloPay.setContentAreaFilled(false);
		radiobtnZaloPay.setFocusPainted(false);
		
		GridBagConstraints gbc_imageZaloPay = new GridBagConstraints();
		gbc_imageZaloPay.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageZaloPay.insets = new Insets(100, 44, 0, 0);
		gbc_imageZaloPay.gridwidth = 2;
		gbc_imageZaloPay.gridx = 0;
		gbc_imageZaloPay.gridy = 2;
		panelMenu.add(imageZaloPay, gbc_imageZaloPay);
		imageZaloPay.setBounds(0, 0, 400, 200);
		imageZaloPay.setIcon(new ImageIcon(image_ZaloPay));
		
		GridBagConstraints gbc_radiobtnAirPay = new GridBagConstraints();
		gbc_radiobtnAirPay.anchor = GridBagConstraints.NORTHWEST;
		gbc_radiobtnAirPay.insets = new Insets(148, 18, 0, 0);
		gbc_radiobtnAirPay.gridwidth = 2;
		gbc_radiobtnAirPay.gridx = 0;
		gbc_radiobtnAirPay.gridy = 2;
		panelMenu.add(radiobtnAirPay, gbc_radiobtnAirPay);
		radiobtnAirPay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		radiobtnAirPay.setForeground(Color.BLACK);
		radiobtnAirPay.setContentAreaFilled(false);
		radiobtnAirPay.setFocusPainted(false);
		
		GridBagConstraints gbc_imageAirPay = new GridBagConstraints();
		gbc_imageAirPay.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageAirPay.insets = new Insets(148, 44, 0, 0);
		gbc_imageAirPay.gridwidth = 2;
		gbc_imageAirPay.gridx = 0;
		gbc_imageAirPay.gridy = 2;
		panelMenu.add(imageAirPay, gbc_imageAirPay);
		imageAirPay.setBounds(0, 0, 400, 200);
		imageAirPay.setIcon(new ImageIcon(image_AirPay));
		
		GridBagConstraints gbc_radiobtnViettelPay = new GridBagConstraints();
		gbc_radiobtnViettelPay.anchor = GridBagConstraints.NORTHWEST;
		gbc_radiobtnViettelPay.insets = new Insets(196, 18, 0, 0);
		gbc_radiobtnViettelPay.gridwidth = 2;
		gbc_radiobtnViettelPay.gridx = 0;
		gbc_radiobtnViettelPay.gridy = 2;
		panelMenu.add(radiobtnViettelPay, gbc_radiobtnViettelPay);
		radiobtnViettelPay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		radiobtnViettelPay.setForeground(Color.BLACK);
		radiobtnViettelPay.setContentAreaFilled(false);
		radiobtnViettelPay.setFocusPainted(false);
		
		GridBagConstraints gbc_imageViettelPay = new GridBagConstraints();
		gbc_imageViettelPay.anchor = GridBagConstraints.NORTHWEST;
		gbc_imageViettelPay.insets = new Insets(196, 44, 0, 0);
		gbc_imageViettelPay.gridwidth = 2;
		gbc_imageViettelPay.gridx = 0;
		gbc_imageViettelPay.gridy = 2;
		panelMenu.add(imageViettelPay, gbc_imageViettelPay);
		imageViettelPay.setBounds(0, 0, 400, 200);
		imageViettelPay.setIcon(new ImageIcon(image_ViettelPay));
		
		GridBagConstraints gbc_imagePayment = new GridBagConstraints();
		gbc_imagePayment.anchor = GridBagConstraints.NORTHWEST;
		gbc_imagePayment.insets = new Insets(48, 174, 0, 0);
		gbc_imagePayment.gridx = 1;
		gbc_imagePayment.gridy = 2;
		panelMenu.add(buttonPayment, gbc_imagePayment);
		buttonPayment.setFocusPainted(false);
		buttonPayment.setOpaque(true);
		buttonPayment.setBackground(new Color(220, 20, 60));
		buttonPayment.setIcon(new ImageIcon(image_Payment));
		buttonPayment.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonPayment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				try {
					String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=BookingFilm;integratedSecurity=true;";
					connection = DriverManager.getConnection(connectionURL);
					info = connection.prepareStatement("Update WW20h20 set State=? where Seat=?");
					for(String j: WW20h20.str) {
						info.setString(1, "reserved");
	                    info.setString(2, j);
	                    info.executeUpdate();
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
				PanelBooking.cardLayout.show(PanelBooking.homeBookingPane, "0");
				Random rd = new Random();
				int ranNum = 10000000 + rd.nextInt(90000000);
				JOptionPane.showMessageDialog(null, "Đặt vé thành công! \nMã đặt vé: " + ranNum + "\nQuý khách vui lòng lưu mã đặt vé và tới quầy nhận vé \nXin cám ơn và hẹn gặp lại.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		GridBagConstraints gbc_labelbtnPayment = new GridBagConstraints();
		gbc_labelbtnPayment.anchor = GridBagConstraints.NORTHWEST;
		gbc_labelbtnPayment.insets = new Insets(158, 176, 0, 0);
		gbc_labelbtnPayment.gridx = 1;
		gbc_labelbtnPayment.gridy = 2;
		panelMenu.add(labelbtnPayment, gbc_labelbtnPayment);
		labelbtnPayment.setEditable(false);
		labelbtnPayment.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelbtnPayment.setForeground(Color.WHITE);
		labelbtnPayment.setBackground(new Color(220, 20, 60));
		labelbtnPayment.setText("PAYMENT");

	}
}
