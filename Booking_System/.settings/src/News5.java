import java.awt.Color;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class News5 extends JPanel {
	private Image image_Back = new ImageIcon(News5.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_news = new ImageIcon(News5.class.getResource("news/posterNews5.jpg")).getImage().getScaledInstance(268, 380, Image.SCALE_SMOOTH);
	
	private final JLabel labelTitle = new JLabel("Nâng hạng VIP & VVIP 2021");
	private final JButton buttonBack = new JButton("");
	private final JLabel labelImage = new JLabel("");
	private final JTextArea textNews = new JTextArea();
	private final JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	
	//Create the panel.
	public News5() {
		initGUI();
	}
	
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setBackground(new Color(205, 102, 102));
		setLayout(null);
		
		add(labelTitle);
		labelTitle.setBounds(54, 8, 386, 35);
		labelTitle.setForeground(new Color(0, 0, 0));
		labelTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 62, 747, 518);
		scrollPane.setBorder(null);
		scrollPane.setViewportView(contentPane);
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(205, 102, 102));
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		contentPane.setLayout(gbl_contentPane);
		gbl_contentPane.columnWidths = new int[]{309, 243, 0};
		gbl_contentPane.rowHeights = new int[]{457, 0, 85, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		
		GridBagConstraints gbc_image = new GridBagConstraints();
		gbc_image.anchor = GridBagConstraints.NORTH;
		gbc_image.insets = new Insets(0, 0, 5, 5);
		gbc_image.gridx = 0;
		gbc_image.gridy = 0;
		contentPane.add(labelImage, gbc_image);
		labelImage.setIcon(new ImageIcon(image_news));
		
		GridBagConstraints gbc_text = new GridBagConstraints();
		gbc_text.anchor = GridBagConstraints.NORTHWEST;
		gbc_text.insets = new Insets(0, 0, 5, 0);
		gbc_text.gridx = 1;
		gbc_text.gridy = 0;
		contentPane.add(textNews, gbc_text);
		textNews.setEditable(false);
		textNews.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textNews.setForeground(Color.BLACK);
		textNews.setBackground(new Color(205, 102, 102));
		textNews.setText("Duy nhất tại app CGV hoặc Website CGV Cinemas!\n"
				+ "\nTừ nay, bạn có thể dễ dàng mua combo bắp nước thông "
				+ "\nqua Website CGV hoặc App CGV với đồng giá:"
				+ "\n- My Combo: 79.000 đồng."
				+ "\n- CGV Combo: 99.000 đồng."
				+ "\nĐặc biệt hơn, hoàn toàn miễn phí thay đổi vị bắp khi mua "
				+ "\ncombo trực tuyến nhé!\n"
				
				+ "\nThành viên CGV có thể tận hưởng ưu đãi của mình online "
				+ "\nmột cách thật tiện lợi và dễ dàng. Chỉ cần thao tác như các "
				+ "\nbước đơn giản sau đây:"
				+ "\n1. Đăng nhập tài khoản thành viên của bạn trên Website "
				+ "\nhoặc ứng dụng CGV Cinemas."
				+ "\n2. Lựa chọn phim, rạp, suất chiếu bất kì, ghế ngồi."
				+ "\n3. Tại trang thanh toán, chọn loại combo và số lượng."
				+ "\n4. Hoàn tất giao dịch."
				+ "\n5. Xuất trình mã đặt vé nhận combo tại rạp.");
		textNews.setCaretPosition(0);
		
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
	}

}
