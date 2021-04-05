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

public class News2 extends JPanel {
	private Image image_Back = new ImageIcon(News2.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_news = new ImageIcon(News2.class.getResource("news/posterNews2.png")).getImage().getScaledInstance(268, 380, Image.SCALE_SMOOTH);
	
	private final JLabel labelTitle = new JLabel("Chỉ 1.000Đ/1 vé qua ZaloPay");
	private final JButton buttonBack = new JButton("");
	private final JLabel labelImage = new JLabel("");
	private final JTextArea textNews = new JTextArea();
	private final JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	
	
	//Create the panel.
	public News2() {
		initGUI();
	}
	
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setBackground(new Color(205, 102, 102));
		setLayout(null);
		
		add(labelTitle);
		labelTitle.setBounds(54, 8, 370, 35);
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
		textNews.setText("THANH TOÁN ZALOPAY ĐỂ HƯỞNG KHUYẾN MÃI ĐỒNG"
				+ "\nGIÁ VÉ CHỈ 1.000Đ"
				+ "\n       *** Thời gian: 25/09/2020 - 31/12/2020 ***\n" 
				
				+ "\nNội dung ưu đãi:"
				+ "\nChỉ 1.000đ/vé CGV khi thanh toán bằng ví điện tử ZaloPay, "
				+ "\nngoài ra còn nhận thêm:"
				+ "\n● Tặng 01 voucher giảm 20k cho đơn hàng từ 100k "
				+ "\n(trừ dịch vụ phim)."
				+ "\n● Tặng 01 voucher giảm 10k cho đơn hàng từ 100k "
				+ "\n(tất cả dịch vụ).\n"
				
				+ "\nĐối tượng nhận ưu đãi:"
				+ "\nLần đầu tiên liên kết thẻ (tài khoản) ngân hàng mới với "
				+ "\nZaloPay trong thời gian diễn ra chương trình và chưa từng "
				+ "\nthực hiện giao dịch thanh toán trên ZaloPay.\n"
				
				+ "\nCách thức nhận ưu đãi:"
				+ "\n1: Tải/cập nhật ứng dụng ZaloPay phiên bản mới nhất "
				+ "\n(từ 4.22 trở lên). Hoặc sử dụng ZaloPay trên Zalo."
				+ "\n2: Lần đầu liên kết thẻ/tài khoản Ngân hàng với ZaloPay "
				+ "\ntrong thời gian diễn ra chương trình."
				+ "\n3: Thực hiện 01 giao dịch nạp tiền vào ví từ thẻ/tài khoản "
				+ "\nngân hàng vừa liên kết."
				+ "\n4: Thanh toán đơn hàng mua vé tại web/app của rạp CGV, "
				+ "\nchọn thanh toán bằng ZaloPay."
				+ "\n5: Vé 1.000đ sẽ tự động áp dụng nếu bạn thỏa điều kiện "
				+ "\nkhi chuyển sang màn hình thanh toán của ZaloPay. Đơn "
				+ "\nhàng thành công khách hàng sẽ nhận 02 voucher.");
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
