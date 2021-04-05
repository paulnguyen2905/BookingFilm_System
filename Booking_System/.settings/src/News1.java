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
import java.awt.SystemColor;

public class News1 extends JPanel {
	private Image image_Back = new ImageIcon(News1.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_news = new ImageIcon(News1.class.getResource("news/posterNews1.jpg")).getImage().getScaledInstance(268, 380, Image.SCALE_SMOOTH);
	
	private final JLabel labelTitle = new JLabel("Nâng hạng VIP & VVIP 2021");
	private final JButton buttonBack = new JButton("");
	private final JLabel labelImage = new JLabel("");
	private final JTextArea textNews = new JTextArea();
	private final JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();

	//Create the panel.
	public News1() {
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
		textNews.setText("CGV biết 2020 là 1 năm khó khăn với tất cả các ngành " 
				+ "\nnghề chúng tôi chân thành gửi lời cảm ơn đến tất cả các "
				+ "\nkhách hàng thành viên đã luôn đồng hành cùng CGV "
				+ "\ntrong thời gian vừa qua. Để thay lời cảm ơn, CGV thông "
				+ "\nbáo đến khách hàng tiêu chuẩn nâng hạng VIP/VVIP 2021 "
				+ "\nvới hạn mức thấp hơn quyền lợi vẫn siêu hấp dẫn: \n"
				
				+ "\nThành viên VIP: có tổng chi tiêu trong năm 2020 đạt từ "
				+ "\n2.500.000 VND đến 4.999.999 VND. "
				+ "\nQuyền lợi:"
				+ "\n- 08 vé 2D/3D miễn phí."
				+ "\n- Quà sinh nhật đặc biệt (01 CGV Combo & 01 vé 2D/3D), "
				+ "\n áp dụng trong tháng sinh nhật"
				+ "\n- Tỷ lệ tích điểm hấp dẫn: 7% tại quầy vé & 3% tại quầy"
				+ "\n bắp nước."
				+ "\n- Giảm giá 15% thức ăn nóng. \n"
				
				+ "\nThành viên VVIP: có tổng chi tiêu trong năm 2020 đạt từ "
				+ "\n5.000.000 VND trở lên."
				+ "Quyền lợi:"
				+ "\n- 01 phần quà VVIP độc quyền tại CGV"
				+ "\n- 10 vé 2D/3D miễn phí để thỏa sức tận hưởng các thước"
				+ "\n phim hay."
				+ "\n- Quà sinh nhật đặc biệt (01 CGV Combo & 02 vé 2D/3D), "
				+ "\náp dụng trong tháng sinh nhật."
				+ "\n- Tỷ lệ tích điểm sốc: 10% ngay tại quầy vé & 5% ngay tại "
				+ "\n quầy bắp nước"
				+ "\n- Giảm giá 20% thức ăn nóng. \n"
				
				+ "\nHiện tại, bạn đã đạt chỉ tiêu để nâng hạng VIP/VVIP trong "
				+ "\năm 2021 chưa? Nếu chỉ còn cách “tí xíu” thì còn chần chừ "
				+ "\ngì mà không đến CGV ngay để tận hưởng phim hay cuối "
				+ "\nnăm và tích lũy thêm chi tiêu lên hạng bạn nhé!"
				+ "\nCảm ơn bạn đã luôn tin yêu và đồng hành cùng CGV!");
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
