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

public class News6 extends JPanel {
	private Image image_Back = new ImageIcon(News6.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_news = new ImageIcon(News6.class.getResource("news/posterNews6.jpg")).getImage().getScaledInstance(268, 380, Image.SCALE_SMOOTH);
	
	private final JLabel labelTitle = new JLabel("Nâng hạng VIP & VVIP 2021");
	private final JButton buttonBack = new JButton("");
	private final JLabel labelImage = new JLabel("");
	private final JTextArea textNews = new JTextArea();
	private final JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	
	//Create the panel.
	public News6() {
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
		textNews.setText("QUÀ TẶNG CỰC XINH – TRI ÂN KHÁCH HÀNG\n"
				+ "\nThời gian: 16/12 – 23/12/2020"
				+ "\nChào mừng sự trở lại hoành tráng của CGV sau dịch, mua "
				+ "\ntừ 02 vé xem phim nhận ngay 01 túi vải xinh xắn từ CGV.\n"

				+ "\nĐiều Kiện Áp Dụng:"
				+ "\n- Chương trình chỉ áp dụng cho giao dịch trực tiếp tại quầy "
				+ "\nvé offline tại các rạp CGV. "
				+ "\n- Quà tặng không có giá trị quy đổi thành tiền mặt."
				+ "\n- Số lượng quà tặng có hạn, chương trình sẽ kết thúc sớm "
				+ "\nkhi quà tặng được phát hết."
				+ "\n- Mỗi khách hàng được nhận 01 lần ưu đãi trong suốt thời "
				+ "\ngian diễn ra chương trình."
				+ "\n- Chương trình không áp dụng đồng thời với các chương "
				+ "\ntrình khuyến mãi khác của CGV và đối tác."
				+ "\n- Trong mọi trường hợp, quyết định của CGV là quyết định"
				+ "\ncuối cùng.");
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
