import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelAboutUs extends JPanel {
	private Image image_Back = new ImageIcon(PanelAboutUs.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_Title = new ImageIcon(PanelAboutUs.class.getResource("image/imageAboutUs.jpg")).getImage().getScaledInstance(722, 220, Image.SCALE_SMOOTH);
	
	private final JLabel lblNewLabel = new JLabel("Câu chuyện về chúng tôi - CJ CJV Việt Nam");
	private final JLabel labelImage = new JLabel();
	private final JButton buttonBack = new JButton("");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JPanel contentPane = new JPanel();
	private final JTextArea textNote = new JTextArea();

	//Create the panel.
	public PanelAboutUs() {
		initGUI();
	}
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setLayout(null);
		setBackground(new Color(205, 102, 102));
		
		add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(54, 8, 580, 34);
		
		add(buttonBack);
		buttonBack.setBackground(new Color(205, 102, 102));
		buttonBack.setBorder(null);
		buttonBack.setBounds(10, 10, 32, 26);
		buttonBack.setIcon(new ImageIcon(image_Back));
		buttonBack.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		
		add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 62, 747, 518);
		scrollPane.setBorder(null);
		scrollPane.setViewportView(contentPane);
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(205, 102, 102));
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{722};
		gbl_contentPane.rowHeights = new int[]{220, 290, 20};
		gbl_contentPane.columnWeights = new double[]{0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		GridBagConstraints gbc_imageTitle = new GridBagConstraints();
		gbc_imageTitle.insets = new Insets(0, 0, 5, 5);
		gbc_imageTitle.gridx = 0;
		gbc_imageTitle.gridy = 0;
		contentPane.add(labelImage, gbc_imageTitle);
		labelImage.setIcon(new ImageIcon(image_Title));
		
		GridBagConstraints gbc_text = new GridBagConstraints();
		gbc_text.anchor = GridBagConstraints.NORTH;
		gbc_text.insets = new Insets(5, 0, 0, 0);
		gbc_text.gridx = 0;
		gbc_text.gridy = 1;
		contentPane.add(textNote, gbc_text);
		textNote.setEditable(false);
		textNote.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textNote.setForeground(Color.BLACK);
		textNote.setBackground(new Color(205, 102, 102));
		textNote.setText("Được thành lập vào năm 1998, CJ CGV là tổ hợp giải trí thuộc tập đoàn CJ Group.“CGV” mang ý "
				+ "\nnghĩa Cutural/ Văn hóa – Great/ Tuyệt vời – Vital/ Thiết yếu. CGV hiện tại là hệ thống cụm rạp"
				+ "\nchiếu phim lớn nhất tại Hàn Quốc và có mặt tại nhiều quốc gia khác nhau trên thế giới."
				+ "\n"
				+ "\nCJ CGV Viêt Nam tiếp quản thương hiệu Megastar từ năm 2011 và chính thức nâng tầm thành "
				+ "\nCGV từ năm 2014. Trải qua gần 10 năm phát triển, CGV đã khẳng định được vị trí cụm rạp chiếu "
				+ "\nphim cao cấp tại Việt Nam và chúng tôi vẫn nỗ lực để khẳng định vị trí dẫn đầu trong khu vực."
				+ "\n"
				+ "\nCJ CGV tự hào là nhà phân phối phim và cụm rạp chiếu phim lớn nhất tại thị trường Việt Nam, "
				+ "\ncũng như nằm ở vị trí top 5 các thương hiệu cụm rạp chiếu phim trên toàn thế giới. Chúng tôi "
				+ "\nluôn giữ vững tinh thần đi theo sứ mệnh – “Trải nghiệm vượt xa điện ảnh, hệ thống giải trí phức"
				+ "\nhợp hàng đầu thế giới” cùng với nhiệm vụ - “Tạo ra những trải nghiệm đáng nhớ. Là nơi đầu tiên,"
				+ "\nnơi duy nhất và là nơi tốt nhất”."
				+ "\n"
				+ "\nCJ CGV luôn cam kết hướng tới trách nhiệm cộng đồng và các hoạt động xã hội. Chúng tôi được "
				+ "\nnhìn thấy qua các hoạt động thiện nguyện Trăng cười và Điện ảnh cho mọi người. Chúng tôi luôn"
				+ "\nkhuyến khích và tạo điều kiện cho các thế hệ trẻ có thể phát triển nền công nghiệp điển ảnh nước"
				+ "\nnhà qua việc tổ chức các chương trình Lớp làm phim Toto, CGV Art House, tài trợ cho Liên hoan "
				+ "\nphim Việt Nam và Liên hoan phim quốc tế Hà Nội."
				+ "\n"
				+ "\nBên cạnh đó, CJ CGV luôn hoạt động với hệ thống minh bạch và chuyên nghiệp, đảm bảo điều"
				+ "\nkiện cho tất cả các đối tác kinh doanh. CJ CGV sẽ tiếp tục hành trình hướng tới tương lai thịnh"
				+ "\nvượng của ngành công nghiệp điện ảnh Việt Nam, cùng với các đối tượng, nhà làm phim, đối"
				+ "\ntác kinh doanh và xã hội."
				+ "\n"
				+ "\nCJ CGV luôn mong muốn mang đến những trải nghiệm điện ảnh tuyệt với cho mọi người và "
				+ "\nchúng tôi luôn hy vọng các bạn sẽ đi cùng chúng tôi trên con đường phát triển này. Cùng với CJ"
				+ "\nCGV, bạn có thể chia sẻ niềm đam mê điện ảnh, thể hiện được tài năng và phát triển sự nghiệp "
				+ "\ncủa mình.");
		textNote.setCaretPosition(0);
	}
}
