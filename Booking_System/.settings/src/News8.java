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

public class News8 extends JPanel {
	private Image image_Back = new ImageIcon(News8.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_news = new ImageIcon(News8.class.getResource("news/posterNews8.png")).getImage().getScaledInstance(268, 380, Image.SCALE_SMOOTH);
	
	private final JLabel labelTitle = new JLabel("Nâng hạng VIP & VVIP 2021");
	private final JButton buttonBack = new JButton("");
	private final JLabel labelImage = new JLabel("");
	private final JTextArea textNews = new JTextArea();
	private final JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	
	//Create the panel.
	public News8() {
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
		textNews.setText("Thời gian diễn ra chương trình: 14/12/2020 - 27/12/2020.\n"
				+ "\nQuà IMAX: 05 áo khoác bomber"
				+ "\n- 05 khách hàng thành viên CGV đầu tiên có giao dịch thực "
				+ "\ntế cao nhất cho phim Wonder Woman định dạng IMAX "
				+ "\n(thanh toán thẻ ATM, thẻ tín dụng, ví điện tử trên nền tảng "
				+ "\nWebsite/ứng dụng CGV) trong khoảng thời gian từ 0h00 "
				+ "\nngày 14/12 đến hết 24h00 ngày 27/12/2020."
				+ "\n- Chỉ dành cho khách hàng mua vé xem phim \"WONDER "
				+ "\nWOMAN\" - định dạng IMAX hoặc hóa đơn mua vé và kèm "
				+ "\ntheo thức ăn, thức uống bất kỳ."
				+ "\n- Áp dụng trên toàn quốc."
				+ "\n- Áp dụng khi giao dịch thanh toán trực tuyến, không áp "
				+ "\ndụng mua vé tại quầy."
				+ "\n- Mỗi thành viên chỉ được áp dụng ưu đãi 01 lần duy nhất."
				+ "\n- Không áp dụng đồng thời với các chương trình khuyến "
				+ "\nmãi khác của CGV và đối tác.\n"

				+ "\nQuà REVLON: 10 bộ mỹ phẩm Revlon"
				+ "\n- 10 khách hàng thành viên CGV đầu tiên có giao dịch "
				+ "\nthực tế cao nhất cho phim Wonder Woman - tất cả các "
				+ "\nđịnh dạng xem phim trừ định dạng IMAX (thanh toán thẻ "
				+ "\nATM, thẻ tín dụng, ví điện tử trên nền tảng Website/ứng "
				+ "\ndụng CGV) trong khoảng thời gian từ 0h00 ngày 14/12 "
				+ "\nđến hết 24h00 ngày 27/12/2020."
				+ "\n- Chỉ dành cho khách hàng mua vé xem phim \"WONDER "
				+ "\nWOMAN\" hoặc hóa đơn mua vé và kèm theo thức ăn, thức "
				+ "\nuống bất kỳ."
				+ "\n- Áp dụng trên toàn quốc."
				+ "\n- Áp dụng khi giao dịch thanh toán trực tuyến, không áp "
				+ "\ndụng mua vé tại quầy."
				+ "\n- Mỗi thành viên chỉ được áp dụng ưu đãi 01 lần duy nhất."
				+ "\n- Không áp dụng đồng thời với các chương trình khuyến "
				+ "\nmãi khác của CGV và đối tác.\n"

				+ "\nĐặt vé ngay để sở hữu những phần quà giới hạn này!!!");
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
