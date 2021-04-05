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

public class News7 extends JPanel {
	private Image image_Back = new ImageIcon(News7.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_news = new ImageIcon(News7.class.getResource("news/posterNews7.jpg")).getImage().getScaledInstance(268, 380, Image.SCALE_SMOOTH);
	
	private final JLabel labelTitle = new JLabel("Nâng hạng VIP & VVIP 2021");
	private final JButton buttonBack = new JButton("");
	private final JLabel labelImage = new JLabel("");
	private final JTextArea textNews = new JTextArea();
	private final JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	
	//Create the panel.
	public News7() {
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
		textNews.setText("Siêu phẩm quà VVIP đã sẵn sàng tại CGV và chờ các VVIP "
				+ "\nđến rước rồi đây!\n"
				
				+ "\nBỘ QUÀ TẶNG GỒM:"
				+ "\n- 02 LY GIỮ NHIỆT DOUBLE WALL CUP CAO CẤP."
				+ "\n- 01 SẠC DỰ PHÒNG COOL NGẦU."
				+ "\n- 01 MOVIE PASS QUYỀN LỰC."
				+ "\nThời gian nhận quà: 15/06/2020 – 31/12/2020."
				+ "\nXẾP LỊCH RA RẠP NHẬN QUÀ THÔI!\n"

				+ "\nĐIỀU KIỆN VÀ ĐIỀU KHOẢN ÁP DỤNG:\n"

				+ "\nĐỐI VỚI 2 LY DOUBLE WALL CUP & SẠC DỰ PHÒNG:"
				+ "\n- Chỉ áp dụng cho thành viên VVIP & mỗi khách hàng chỉ "
				+ "\nnhận được 01 phần quà duy nhất."
				+ "\n- Thời gian nhận quà từ 15/06/2020 - 31/12/2020.\n"
				
				+ "\nĐỐI VỚI MOVIE PASS:"
				+ "\n- Áp dụng cho 01 vé xem phim bất kỳ tại các phòng chiếu "
				+ "\nthường, hoặc các phòng chiếu đặc biệt (không áp dụng "
				+ "\nđịnh dạng L’AMOUR, SWEETBOX, CINE & LIVING ROOM)."
				+ "\n- Được gắn vào tài khoản thành viên của khách hàng VVIP "
				+ "\nvà khả dụng từ 15/06/2020 - 31/12/2020."
				+ "\n- Áp dụng cho cả Lễ Tết/Sneakshow/Early Release."
				+ "\n- Có thể áp dụng trực tiếp tại quầy.\n"

				+ "\nQUY TRÌNH NHẬN QUÀ TẠI RẠP:"
				+ "\n- Chủ thẻ thành viên VVIP vui lòng trực tiếp đến các rạp "
				+ "\ngần nhất để nhận quà."
				+ "\n- Khi nhận quà khách hàng cần xuất trình thẻ thành viên "
				+ "\nVVIP và CMND/Thẻ Căn Cước khớp với thông tin đăng ký "
				+ "\nthành viên tại CGV.\n"
				+ "\n*Phần quà VVIP không có giá trị quy đổi thành tiền mặt.");
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
