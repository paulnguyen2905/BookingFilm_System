import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class PanelMember extends JPanel {
	Connection connection = null;
	PreparedStatement info = null;
	ResultSet rs = null;
	
	private Image image_User = new ImageIcon(PanelMember.class.getResource("image/user_icon.png")).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
	private Image image_Back = new ImageIcon(PanelMember.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_RoundedRectangle = new ImageIcon(PanelMember.class.getResource("image/roundedRectangle_icon.png")).getImage().getScaledInstance(690, 180, Image.SCALE_SMOOTH);
	private Image image_Barcode = new ImageIcon(PanelMember.class.getResource("image/barcode_icon.jpg")).getImage().getScaledInstance(180, 80, Image.SCALE_SMOOTH);
	private final JPanel contentPane = new JPanel();
	private final JLabel labelMember = new JLabel("Thông tin thành viên");
	private final JButton buttonBack = new JButton("");
	private final JButton buttonSave = new JButton("Lưu thay đổi");
	private final JToggleButton buttonEdit = new JToggleButton("THAY ĐỔI");
	private final JLabel imageRoundedRectangle = new JLabel();
	private final JLabel imageUser = new JLabel();
	private final JLabel imageBarcode = new JLabel();
	private final JTextArea textInfo = new JTextArea("");
	private final JTextArea textBarcode = new JTextArea("");
	private final JLabel labelHoTen = new JLabel("Họ và tên:");
	private final JTextField editHoTen = new JTextField("");
	private final JLabel labelDOB = new JLabel("Ngày tháng năm sinh (định dạng: dd/mm/yyyy)");
	private final JTextField editDOB = new JTextField("");
	private final JLabel labelEmail = new JLabel("Địa chỉ Email:");
	private final JTextField editEmail = new JTextField("");
	private final JLabel labelSDT = new JLabel("Số điện thoại:");
	private final JTextField editSDT = new JTextField("");
	private final JLabel labelPassword = new JLabel("Nhập lại mật khẩu (*Bắt buộc):");
	private final JTextField enterPassword = new JTextField("");
	
	public static JTextField textUserName = new JTextField();
	public static JTextArea infoHoTen = new JTextArea("");
	public static JTextArea infoDOB = new JTextArea("");
	public static JTextArea infoEmail = new JTextArea("");
	public static JTextArea infoSDT = new JTextArea("");

	//Create the panel.
	public PanelMember() {
		initGUI();
	}
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setBackground(new Color(205, 102, 102));
		setLayout(null);
		
		add(labelMember); //NHÃN PANEL
		labelMember.setForeground(new Color(0, 0, 0));
		labelMember.setFont(new Font("Times New Roman", Font.BOLD, 30));
		labelMember.setBounds(54, 8, 293, 36);
		
		add(buttonBack); //NÚT BACK
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonBack.setBackground(new Color(205, 102, 102));
		buttonBack.setBorder(null);
		buttonBack.setBounds(10, 10, 32, 26);
		buttonBack.setIcon(new ImageIcon(image_Back));
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{300, 390};
		gbl_contentPane.rowHeights = new int[]{24, 180, 35, 30, 35, 30, 35, 30, 35, 30, 35, 34};
		gbl_contentPane.columnWeights = new double[]{0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		add(contentPane);
		contentPane.setBounds(0 , 0, 747, 580);
		contentPane.setBackground(new Color(205, 102, 102));
		contentPane.setLayout(gbl_contentPane);
		
		GridBagConstraints gbc_buttonEdit = new GridBagConstraints(); //BUTTON THAY ĐỔII THÔNG TIN
		gbc_buttonEdit.insets = new Insets(-104, 26, 0, 0);
		gbc_buttonEdit.gridwidth = 2;
		gbc_buttonEdit.gridx = 0;
		gbc_buttonEdit.gridy = 1;
		contentPane.add(buttonEdit, gbc_buttonEdit);
		buttonEdit.setFocusPainted(false);
		buttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonEdit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				if(buttonEdit.isSelected()) {
					labelHoTen.setVisible(true);
					editHoTen.setVisible(true);
					labelDOB.setVisible(true);
					editDOB.setVisible(true);
					labelEmail.setVisible(true);
					editEmail.setVisible(true);
					labelSDT.setVisible(true);
					editSDT.setVisible(true);
					labelPassword.setVisible(true);
					enterPassword.setVisible(true);
					buttonSave.setVisible(true);
				}
				else {
					labelHoTen.setVisible(false);
					editHoTen.setVisible(false);
					labelDOB.setVisible(false);
					editDOB.setVisible(false);
					labelEmail.setVisible(false);
					editEmail.setVisible(false);
					labelSDT.setVisible(false);
					editSDT.setVisible(false);
					labelPassword.setVisible(false);
					enterPassword.setVisible(false);
					buttonSave.setVisible(false);
				}
			}
		});
		
		GridBagConstraints gbc_imageRoundedRectangle = new GridBagConstraints(); //KHUNG HÌNH CHỮ NHẬT
		gbc_imageRoundedRectangle.fill = GridBagConstraints.BOTH;
		gbc_imageRoundedRectangle.insets = new Insets(0, 0, 0, 0);
		gbc_imageRoundedRectangle.gridwidth = 2;
		gbc_imageRoundedRectangle.gridx = 0;
		gbc_imageRoundedRectangle.gridy = 1;
		contentPane.add(imageRoundedRectangle, gbc_imageRoundedRectangle);
		imageRoundedRectangle.setIcon(new ImageIcon(image_RoundedRectangle));
		
		GridBagConstraints gbc_imageUser = new GridBagConstraints(); //HÌNH USERNAME
		gbc_imageUser.anchor = GridBagConstraints.WEST;
		gbc_imageUser.insets = new Insets(-20, 40, 0, 0);
		gbc_imageUser.gridwidth = 2;
		gbc_imageUser.gridx = 0;
		gbc_imageUser.gridy = 1;
		contentPane.add(imageUser, gbc_imageUser);
		imageUser.setIcon(new ImageIcon(image_User));
		
		GridBagConstraints gbc_textUserName = new GridBagConstraints(); //TEXT USERNAME
		gbc_textUserName.anchor = GridBagConstraints.WEST;
		gbc_textUserName.insets = new Insets(120, 40, 0, 0);
		gbc_textUserName.gridwidth = 2;
		gbc_textUserName.gridx = 0;
		gbc_textUserName.gridy = 1;
		contentPane.add(textUserName, gbc_textUserName);
		textUserName.setText("UserName here");
		textUserName.setDisabledTextColor(Color.BLACK);
		textUserName.setForeground(Color.BLACK);
		textUserName.setBorder(null);
		textUserName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textUserName.setHorizontalAlignment(SwingConstants.CENTER);
		textUserName.setOpaque(false);
		textUserName.setEnabled(false);
		textUserName.setEditable(false);
		
		GridBagConstraints gbc_infoHoTen = new GridBagConstraints(); //INFO HỌ TÊN KHÁCH HÀNG HIỆN TẠI
		gbc_infoHoTen.anchor = GridBagConstraints.WEST;
		gbc_infoHoTen.insets = new Insets(-20, 254, 0, 0);
		gbc_infoHoTen.gridwidth = 2;
		gbc_infoHoTen.gridx = 0;
		gbc_infoHoTen.gridy = 1;
		contentPane.add(infoHoTen, gbc_infoHoTen);
		infoHoTen.setEditable(false);
		infoHoTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		infoHoTen.setForeground(Color.BLACK);
		infoHoTen.setBackground(new Color(205, 102, 102));
		infoHoTen.setText("Họ và tên ở đây");
		
		GridBagConstraints gbc_infoDOB = new GridBagConstraints(); //INFO NGÀY THÁNG NĂM SINH KHÁCH HÀNG HIỆN TẠI
		gbc_infoDOB.anchor = GridBagConstraints.WEST;
		gbc_infoDOB.insets = new Insets(24, 236, 0, 0);
		gbc_infoDOB.gridwidth = 2;
		gbc_infoDOB.gridx = 0;
		gbc_infoDOB.gridy = 1;
		contentPane.add(infoDOB, gbc_infoDOB);
		infoDOB.setEditable(false);
		infoDOB.setFont(new Font("Tahoma", Font.PLAIN, 19));
		infoDOB.setForeground(Color.BLACK);
		infoDOB.setBackground(new Color(205, 102, 102));
		infoDOB.setText("Ngày sinh");
		
		GridBagConstraints gbc_infoEmail = new GridBagConstraints(); //INFO ĐỊA CHỈ MAIL KHÁCH HÀNG HIỆN TẠI
		gbc_infoEmail.anchor = GridBagConstraints.WEST;
		gbc_infoEmail.insets = new Insets(68, 242, 0, 0);
		gbc_infoEmail.gridwidth = 2;
		gbc_infoEmail.gridx = 0;
		gbc_infoEmail.gridy = 1;
		contentPane.add(infoEmail, gbc_infoEmail);
		infoEmail.setEditable(false);
		infoEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		infoEmail.setForeground(Color.BLACK);
		infoEmail.setBackground(new Color(205, 102, 102));
		infoEmail.setText("Địa chỉ mail ở đây");
		
		GridBagConstraints gbc_infoSDT = new GridBagConstraints(); //INFO SỐ ĐIỆN THOẠI KHÁCH HÀNG HIỆN TẠI
		gbc_infoSDT.anchor = GridBagConstraints.WEST;
		gbc_infoSDT.insets = new Insets(112, 308, 0, 0);
		gbc_infoSDT.gridwidth = 2;
		gbc_infoSDT.gridx = 0;
		gbc_infoSDT.gridy = 1;
		contentPane.add(infoSDT, gbc_infoSDT);
		infoSDT.setEditable(false);
		infoSDT.setFont(new Font("Tahoma", Font.PLAIN, 19));
		infoSDT.setForeground(Color.BLACK);
		infoSDT.setBackground(new Color(205, 102, 102));
		infoSDT.setText("Số điện thoại");
		
		GridBagConstraints gbc_noteInfo = new GridBagConstraints(); //DÒNG THÔNG TIN KHÁCH
		gbc_noteInfo.insets = new Insets(3, -190, 0, 0);
		gbc_noteInfo.gridwidth = 2;
		gbc_noteInfo.gridx = 0;
		gbc_noteInfo.gridy = 1;
		contentPane.add(textInfo, gbc_noteInfo);
		textInfo.setEditable(false);
		textInfo.setEnabled(false);
		textInfo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textInfo.setForeground(Color.BLACK);
		textInfo.setBackground(new Color(205, 102, 102));
		textInfo.setText("THÔNG TIN"
				+ "\n--------------"
				+ "\nHọ tên:"
				+ "\nDOB: "
				+ "\nEmail: "
				+ "\nSố điện thoại: ");
		
		GridBagConstraints gbc_noteBarcode = new GridBagConstraints(); //DÒNG THÔNG TIN MÃ VẠCH
		gbc_noteBarcode.insets = new Insets(-86, 440, 0, 0);
		gbc_noteBarcode.gridwidth = 2;
		gbc_noteBarcode.gridx = 0;
		gbc_noteBarcode.gridy = 1;
		contentPane.add(textBarcode, gbc_noteBarcode);
		textBarcode.setEditable(false);
		textBarcode.setEnabled(false);
		textBarcode.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textBarcode.setForeground(Color.BLACK);
		textBarcode.setBackground(new Color(205, 102, 102));
		textBarcode.setText("MÃ THÀNH VIÊN"
				+ "\n--------------------");
		
		GridBagConstraints gbc_imageBarcode = new GridBagConstraints(); //HÌNH MÃ VẠCH
		gbc_imageBarcode.insets = new Insets(46, 440, 0, 0);
		gbc_imageBarcode.gridwidth = 2;
		gbc_imageBarcode.gridx = 0;
		gbc_imageBarcode.gridy = 1;
		contentPane.add(imageBarcode, gbc_imageBarcode);
		imageBarcode.setIcon(new ImageIcon(image_Barcode));
		
		GridBagConstraints gbc_labelHoTen = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_labelHoTen.anchor = GridBagConstraints.SOUTH;
		gbc_labelHoTen.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelHoTen.insets = new Insets(0, 0, 0, 0);
		gbc_labelHoTen.gridwidth = 2;
		gbc_labelHoTen.gridx = 0;
		gbc_labelHoTen.gridy = 2;
		contentPane.add(labelHoTen, gbc_labelHoTen);
		labelHoTen.setForeground(Color.BLACK);
		labelHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelHoTen.setVisible(false);
		
		GridBagConstraints gbc_editHoTen = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_editHoTen.anchor = GridBagConstraints.SOUTH;
		gbc_editHoTen.fill = GridBagConstraints.HORIZONTAL;
		gbc_editHoTen.insets = new Insets(0, 0, 0, 0);
		gbc_editHoTen.gridwidth = 2;
		gbc_editHoTen.gridx = 0;
		gbc_editHoTen.gridy = 3;
		contentPane.add(editHoTen, gbc_editHoTen);
		editHoTen.setForeground(Color.BLACK);
		editHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		editHoTen.setVisible(false);
		
		GridBagConstraints gbc_labelDOB = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_labelDOB.anchor = GridBagConstraints.SOUTH;
		gbc_labelDOB.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelDOB.insets = new Insets(0, 0, 0, 0);
		gbc_labelDOB.gridwidth = 2;
		gbc_labelDOB.gridx = 0;
		gbc_labelDOB.gridy = 4;
		contentPane.add(labelDOB, gbc_labelDOB);
		labelDOB.setForeground(Color.BLACK);
		labelDOB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelDOB.setVisible(false);
		
		GridBagConstraints gbc_editDOB = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_editDOB.anchor = GridBagConstraints.SOUTH;
		gbc_editDOB.fill = GridBagConstraints.HORIZONTAL;
		gbc_editDOB.insets = new Insets(0, 0, 0, 0);
		gbc_editDOB.gridwidth = 2;
		gbc_editDOB.gridx = 0;
		gbc_editDOB.gridy = 5;
		contentPane.add(editDOB, gbc_editDOB);
		editDOB.setForeground(Color.BLACK);
		editDOB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		editDOB.setVisible(false);
		
		GridBagConstraints gbc_labelEmail = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_labelEmail.anchor = GridBagConstraints.SOUTH;
		gbc_labelEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelEmail.insets = new Insets(0, 0, 0, 0);
		gbc_labelEmail.gridwidth = 2;
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 6;
		contentPane.add(labelEmail, gbc_labelEmail);
		labelEmail.setForeground(Color.BLACK);
		labelEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelEmail.setVisible(false);
		
		GridBagConstraints gbc_editEmail = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_editEmail.anchor = GridBagConstraints.SOUTH;
		gbc_editEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_editEmail.insets = new Insets(0, 0, 0, 0);
		gbc_editEmail.gridwidth = 2;
		gbc_editEmail.gridx = 0;
		gbc_editEmail.gridy = 7;
		contentPane.add(editEmail, gbc_editEmail);
		editEmail.setForeground(Color.BLACK);
		editEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		editEmail.setVisible(false);
		
		GridBagConstraints gbc_labelSDT = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_labelSDT.anchor = GridBagConstraints.SOUTH;
		gbc_labelSDT.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelSDT.insets = new Insets(0, 0, 0, 0);
		gbc_labelSDT.gridwidth = 2;
		gbc_labelSDT.gridx = 0;
		gbc_labelSDT.gridy = 8;
		contentPane.add(labelSDT, gbc_labelSDT);
		labelSDT.setForeground(Color.BLACK);
		labelSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelSDT.setVisible(false);
		
		GridBagConstraints gbc_editSDT = new GridBagConstraints(); //NHÃN HỌ TÊN PHẦN SỬA ĐỔI THÔNG TIN
		gbc_editSDT.anchor = GridBagConstraints.SOUTH;
		gbc_editSDT.fill = GridBagConstraints.HORIZONTAL;
		gbc_editSDT.insets = new Insets(0, 0, 0, 0);
		gbc_editSDT.gridwidth = 2;
		gbc_editSDT.gridx = 0;
		gbc_editSDT.gridy = 9;
		contentPane.add(editSDT, gbc_editSDT);
		editSDT.setForeground(Color.BLACK);
		editSDT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		editSDT.setVisible(false);
		
		GridBagConstraints gbc_labelPassword = new GridBagConstraints(); //NHÃN NHẬP LẠI MẬT KHẨU
		gbc_labelPassword.anchor = GridBagConstraints.SOUTH;
		gbc_labelPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelPassword.insets = new Insets(0, 0, 0, 0);
		gbc_labelPassword.gridwidth = 2;
		gbc_labelPassword.gridx = 0;
		gbc_labelPassword.gridy = 10;
		contentPane.add(labelPassword, gbc_labelPassword);
		labelPassword.setForeground(Color.BLACK);
		labelPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelPassword.setVisible(false);
		
		GridBagConstraints gbc_enterPassword = new GridBagConstraints(); //KHUNG NHẬP LẠI MẬT KHẨU
		gbc_enterPassword.anchor = GridBagConstraints.SOUTH;
		gbc_enterPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_enterPassword.insets = new Insets(0, 0, 0, 0);
		gbc_enterPassword.gridx = 0;
		gbc_enterPassword.gridy = 11;
		contentPane.add(enterPassword, gbc_enterPassword);
		enterPassword.setForeground(Color.BLACK);
		enterPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		enterPassword.setVisible(false);
		
		GridBagConstraints gbc_buttonSave = new GridBagConstraints(); //BUTTON LƯU THAY ĐỔI THÔNG TIN
		gbc_buttonSave.anchor = GridBagConstraints.WEST;
		gbc_buttonSave.insets = new Insets(0, 20, 0, 0);
		gbc_buttonSave.gridx = 1;
		gbc_buttonSave.gridy = 11;
		contentPane.add(buttonSave, gbc_buttonSave);
		buttonSave.setFocusPainted(false);
		buttonSave.setVisible(false);
		buttonSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonSave.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				String compareUsername;
				String comparePassword;
				compareUsername = FrameLogin.textUsername.getText();
				comparePassword = FrameLogin.textPassword.getText();
				if(editHoTen.getText().equals("") && editDOB.getText().equals("") && editEmail.getText().equals("") && editSDT.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền thông tin cần thay đổi!   ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
				else if(enterPassword.getText().equals(comparePassword)) {
					try {
						String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=BookingFilm;integratedSecurity=true;";
						connection = DriverManager.getConnection(connectionURL);
	                    if(editDOB.getText().equals("") && editEmail.getText().equals("") && editSDT.getText().equals("")) { //THAY ĐỔI HỌ TÊN
	                    	info = connection.prepareStatement("Update information set name=? where username=?");
	                    	info.setString(1, editHoTen.getText());
	                    	info.setString(2, compareUsername);
	                    }
	                    else if(editHoTen.getText().equals("") && editEmail.getText().equals("") && editSDT.getText().equals("")) { //THAY ĐỔI DOB
	                    	info = connection.prepareStatement("Update information set dob=? where username=?");
	                    	info.setString(1, editDOB.getText());
	                    	info.setString(2, compareUsername);
	                    }
	                    else if(editHoTen.getText().equals("") && editDOB.getText().equals("") && editSDT.getText().equals("")) { //THAY ĐỔI EMAIL
	                    	info = connection.prepareStatement("Update information set email=? where username=?");
	                    	info.setString(1, editEmail.getText());
	                    	info.setString(2, compareUsername);
	                    }
	                    else if(editHoTen.getText().equals("") && editDOB.getText().equals("") && editEmail.getText().equals("")) { //THAY ĐỔI SĐT
	                    	info = connection.prepareStatement("Update information set phone=? where username=?");
	                    	info.setString(1, editSDT.getText());
	                    	info.setString(2, compareUsername);
	                    }
	                    else if(editEmail.getText().equals("") && editSDT.getText().equals("")) {
	                    	info = connection.prepareStatement("Update information set name=?, dob=? where username=?"); //THAY ĐỔI HỌ TÊN, DOB
	                    	info.setString(1, editHoTen.getText());
	                    	info.setString(2, editDOB.getText());
	                    	info.setString(3, compareUsername);
	                    }
	                    else if(editDOB.getText().equals("") && editSDT.getText().equals("")) {
	                    	info = connection.prepareStatement("Update information set name=?, email=? where username=?"); //THAY ĐỔI HỌ TÊN, EMAIL
	                    	info.setString(1, editHoTen.getText());
	                    	info.setString(2, editEmail.getText());
	                    	info.setString(3, compareUsername);
	                    }
	                    else if(editDOB.getText().equals("") && editEmail.getText().equals("")) {
	                    	info = connection.prepareStatement("Update information set name=?, phone=? where username=?"); //THAY ĐỔI HỌ TÊN, SĐT
	                    	info.setString(1, editHoTen.getText());
	                    	info.setString(2, editSDT.getText());
	                    	info.setString(3, compareUsername);
	                    }
	                    else if(editHoTen.getText().equals("") && editSDT.getText().equals("")) {
	                    	info = connection.prepareStatement("Update information set phone, email=? where username=?"); //THAY ĐỔI DOB, EMAIL
	                    	info.setString(1, editDOB.getText());
	                    	info.setString(2, editEmail.getText());
	                    	info.setString(3, compareUsername);
	                    }
	                    else if(editHoTen.getText().equals("") && editEmail.getText().equals("")) {
	                    	info = connection.prepareStatement("Update information set dob=?, phone=? where username=?"); //THAY ĐỔI DOB, SĐT
	                    	info.setString(1, editDOB.getText());
	                    	info.setString(2, editSDT.getText());
	                    	info.setString(3, compareUsername);
	                    }
	                    else if(editHoTen.getText().equals("") && editDOB.getText().equals("")) {
	                    	info = connection.prepareStatement("Update information set email=?, phone=? where username=?"); //THAY ĐỔI Email, SĐT
	                    	info.setString(1, editEmail.getText());
	                    	info.setString(2, editSDT.getText());
	                    	info.setString(3, compareUsername);
	                    }
	                    else if(editSDT.getText().equals("")) {
	                    	info = connection.prepareStatement("Update information set name=?, dob=?, email=? where username=?"); //THAY ĐỔI HỌ TÊN, DOB, EMAIL
	                    	info.setString(1, editHoTen.getText());
	                    	info.setString(2, editDOB.getText());
	                    	info.setString(3, editEmail.getText());
	                    	info.setString(4, compareUsername);
	                    }
	                    else if(editEmail.getText().equals("")) {
	                    	info = connection.prepareStatement("Update information set name=?, dob=?, phone=? where username=?"); //THAY ĐỔI HỌ TÊN, DOB, SĐT
	                    	info.setString(1, editHoTen.getText());
	                    	info.setString(2, editDOB.getText());
	                    	info.setString(3, editSDT.getText());
	                    	info.setString(4, compareUsername);
	                    }
	                    else if(editDOB.getText().equals("")) {
	                    	info = connection.prepareStatement("Update information set name=?, email=?, phone=? where username=?"); //THAY ĐỔI HỌ TÊN, EMAIL, SĐT
	                    	info.setString(1, editHoTen.getText());
	                    	info.setString(2, editEmail.getText());
	                    	info.setString(3, editSDT.getText());
	                    	info.setString(4, compareUsername);
	                    }
	                    else if(editHoTen.getText().equals("")) {
	                    	info = connection.prepareStatement("Update information set dob=?, email=?, phone=? where username=?"); //THAY ĐỔI DOB, EMAIL, SĐT
	                    	info.setString(1, editDOB.getText());
	                    	info.setString(2, editEmail.getText());
	                    	info.setString(3, editSDT.getText());
	                    	info.setString(4, compareUsername);
	                    }
	                    else {
	                    	info = connection.prepareStatement("Update information set name=?, dob=?, email=?, phone=? where username=?"); //THAY ĐỔI DOB, EMAIL, SĐT
	                    	info.setString(1, editHoTen.getText());
	                    	info.setString(2, editDOB.getText());
	                    	info.setString(3, editEmail.getText());
	                    	info.setString(4, editSDT.getText());
	                    	info.setString(5, compareUsername);
	                    }
	                    info.executeUpdate();
	                    
	                    info = connection.prepareStatement("Select name, email, phone, dob from information where username=?");
	                    info.setString(1, compareUsername);
	                    rs = info.executeQuery();
	                    while(rs.next()) {
	                    	infoHoTen.setText(rs.getNString("name"));
	                    	infoEmail.setText(rs.getString("email"));
	                    	infoSDT.setText(rs.getString("phone"));
	                    	infoDOB.setText(rs.getString("dob"));
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
					JOptionPane.showMessageDialog(null, "Thay đổi thông tin thành công!  ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					enterPassword.setText("");
					JOptionPane.showMessageDialog(null, "Nhập sai mật khẩu hoặc chưa nhập mật khẩu!  \nVui lòng nhập lại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

}
