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

public class News3 extends JPanel {
	private Image image_Back = new ImageIcon(News3.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_news = new ImageIcon(News3.class.getResource("news/posterNews3.jpg")).getImage().getScaledInstance(268, 380, Image.SCALE_SMOOTH);
	
	private final JLabel labelTitle = new JLabel("2 ngày hoàn 40% điểm trên Grabrewards");
	private final JButton buttonBack = new JButton("");
	private final JLabel labelImage = new JLabel("");
	private final JTextArea textNews = new JTextArea();
	private final JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	
	//Create the panel.
	public News3() {
		initGUI();
	}
	
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setBackground(new Color(205, 102, 102));
		setLayout(null);
		
		add(labelTitle);
		labelTitle.setBounds(54, 8, 545, 35);
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
		textNews.setText("Chỉ trong 2 ngày từ 20 - 21/12/2020, đổi quà xịn, “deal” "
				+ "\nhời từ nhiều thương hiệu nổi tiếng trên GrabRewards với "
				+ "\nsố điểm ưu đãi mà còn được hoàn điểm đến 40%. Tranh "
				+ "\nthủ \"xả điểm\" đổi quà cho đã và nhận hoàn điểm lên đến "
				+ "\n40% siêu hời nha!\n"

				+ "\nHướng dẫn cách đổi ưu đãi nhận hoàn điểm lên đến 40%:"
				+ "\n- Bước 1: Mở ứng dụng Grab, bấm \"Xem thêm/ More\" và "
				+ "\nchọn \"Rewards\" để vào GrabRewards"
				+ "\n- Bước 2: Chọn ưu đãi mà bạn thích trong GrabRewards, "
				+ "\nbạn sẽ được hoàn điểm đến 40% trong ngày 23/12/2020."
				+ "\n- Bước 3: Tận hưởng ưu đãi vừa đổi được và tích lũy đổi "
				+ "\nthêm các ưu đãi khác.\n"
				
				+ "\nThông tin chi tiết ưu đãi:"
				+ "\n- Đối với hạng mức thành viên/ Member và thành viên "
				+ "\nBạc/ Silver: HOÀN ĐIỂM 10% khi đổi ưu đãi bất kì trên"
				+ "\nGrabRewards."
				+ "\n- Đối với hạng mức thành viên Vàng/ Gold: HOÀN ĐIỂM "
				+ "\n30% khi đổi ưu đãi bất kì trên GrabRewards."
				+ "\n- Đối với hạng mức thành viên Bạch Kim/ Platinum: HOÀN "
				+ "\nĐIỂM 40% khi đổi ưu đãi bất kì trên GrabRewards.\n"
				
				+ "\nLưu ý:"
				+ "\n- Mỗi khách hàng được hoàn điểm tối đa 7.000 điểm trong "
				+ "\nsuốt chương trình."
				+ "\n- Chỉ dành cho 50.000 khách hàng đầu tiên* tham gia "
				+ "\nchương trình."
				+ "\n- Chương trình hoàn điểm này áp dụng đồng thời với các "
				+ "\nchương trình khác đang diễn ra trên Grabrewards.\n"
				
				+ "\n*Cách xác định 50.000 khách hàng may mắn đầu tiên và "
				+ "\nđiểm thưởng sẽ nhận được: "
				+ "\nChương trình sẽ xác định khách hàng đầu tiên dựa vào thời"
				+ "\ngian của lượt đổi điểm đầu tiên mà từng khách hàng thực "
				+ "\nhiện. Tổng tất cả các ưu đãi mà 50.000 khách hàng này "
				+ "\nđổi từ lúc 00:00 20/12/2020 đến 23:59 ngày 21/12/2020 "
				+ "\nsẽ nhận được hoàn điểm trong ngày 23/12/2020.");
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
