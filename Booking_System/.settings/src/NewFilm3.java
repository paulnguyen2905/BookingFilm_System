import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class NewFilm3 extends JPanel {
	private Image image_back = new ImageIcon(NewFilm1.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_poster = new ImageIcon(NewFilm1.class.getResource("posterComingSoon/poster_ELCE.jpg")).getImage().getScaledInstance(268, 380, Image.SCALE_SMOOTH);
	private Image image_buy = new ImageIcon(NewFilm1.class.getResource("image/buyticket_icon.png")).getImage().getScaledInstance(120, 70, Image.SCALE_SMOOTH);
	private Image image_trailer = new ImageIcon(NewFilm1.class.getResource("image/trailer_icon.png")).getImage().getScaledInstance(148, 64, Image.SCALE_SMOOTH);
	
	private final JLabel labelTitle = new JLabel("EM LÀ CỦA EM");
	private final JLabel labelImage1 = new JLabel();
	private final JLabel labelImage2 = new JLabel();
	private final JLabel labelImage3 = new JLabel();
	private final JButton buttonBack = new JButton("");
	private final JTextArea textFilm = new JTextArea();
	private final JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();

	//Create the panel.
	public NewFilm3() {
		initGUI();
	}
	
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setBackground(new Color(205, 102, 102));
		setLayout(null);
		
		add(labelTitle);
		labelTitle.setBounds(54, 8, 481, 35);
		labelTitle.setForeground(new Color(0, 0, 0));
		labelTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 62, 747, 518);
		scrollPane.setBorder(null);
		scrollPane.setViewportView(contentPane);
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(205, 102, 102));
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		contentPane.setLayout(gbl_contentPane);
		gbl_contentPane.columnWidths = new int[]{309, 243, 0};
		gbl_contentPane.rowHeights = new int[]{394, 0, 85, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		
		GridBagConstraints gbc_image1 = new GridBagConstraints();
		gbc_image1.anchor = GridBagConstraints.NORTH;
		gbc_image1.insets = new Insets(0, 0, 5, 5);
		gbc_image1.gridx = 0;
		gbc_image1.gridy = 0;
		contentPane.add(labelImage1, gbc_image1);
		labelImage1.setIcon(new ImageIcon(image_poster));
		
		GridBagConstraints gbc_image2 = new GridBagConstraints();
		gbc_image2.anchor = GridBagConstraints.NORTHWEST;
		gbc_image2.insets = new Insets(384, 168, 0, 0);
		gbc_image2.gridx = 0;
		gbc_image2.gridy = 0;
		contentPane.add(labelImage2, gbc_image2);
		labelImage2.setIcon(new ImageIcon(image_buy));
		labelImage2.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				labelImage2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
				
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		GridBagConstraints gbc_image3 = new GridBagConstraints();
		gbc_image3.anchor = GridBagConstraints.NORTHWEST;
		gbc_image3.insets = new Insets(384, 16, 0, 0);
		gbc_image3.gridx = 0;
		gbc_image3.gridy = 0;
		contentPane.add(labelImage3, gbc_image3);
		labelImage3.setIcon(new ImageIcon(image_trailer));
		labelImage3.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				labelImage3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
				
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseClicked(MouseEvent e) {
				try {
			        Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=kJcfrHDTSEQ"));
			    }
				catch (IOException | URISyntaxException e1) {
			        e1.printStackTrace();
			    }
			}
		});
		
		GridBagConstraints gbc_text = new GridBagConstraints();
		gbc_text.anchor = GridBagConstraints.NORTHWEST;
		gbc_text.insets = new Insets(0, 0, 5, 0);
		gbc_text.gridx = 1;
		gbc_text.gridy = 0;
		contentPane.add(textFilm, gbc_text);
		textFilm.setEditable(false);
		textFilm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFilm.setForeground(Color.BLACK);
		textFilm.setBackground(new Color(205, 102, 102));
		textFilm.setText("- Đạo diễn: Lê Thiện Viễn" 
				+ "\n- Diễn viên: Ngô Kiến Huy, Jessica Hoàng Anh, Maya, Khả "
				+ "\nNhư, Hứa Vĩ Văn, Hoàng Phi, Đại Nghĩa, Lê Giang…"
				+ "\n- Thể loại: Hài, Tình cảm"
				+ "\n- Khởi chiếu: 08/01/2021 "
				+ "\n- Thời lượng: 97 phút "
				+ "\n- Ngôn ngữ: Tiếng Việt - Phụ đề Tiếng Anh"
				+ "\n- Giới hạn độ tuổi: C16 - CẤM KHÁN GIẢ DƯỚI 16 TUỔI\n"
				
				+ "\nChuyện phim “Em” Là Của Em xoay quanh Hoàng (Ngô "
				+ "\nKiến Huy) - một chàng trai đã 30 tuổi nhưng vẫn chưa đi "
				+ "\nđến được trạm cuối của con đường tình yêu. Phải lòng một"
				+ "\ncô gái hơn tuổi từ tận năm cấp 3, Hoàng đã phải trải qua"
				+ "\nnhiều gian nan trắc trở để “cầm cưa” chị đẹp nhưng đều "
				+ "\nliên tiếp bị chị người thương từ chối. Lúc này, Thanh (Khả"
				+ "\nNhư) trở thành người “cứu rỗi” tình yêu cho Hoàng khi lập"
				+ "\nra cho anh hẳn một kế hoạch cưa đổ crush cực kỳ hoàn "
				+ "\nhảo. Liệu rằng với kế hoạch ấy, anh chàng có thành công"
				+ "\nthu phục trái tim của người đẹp giấu mặt? Câu trả lời sẽ "
				+ "\nđược hé lộ vào ngày 08.01.2021.");
		textFilm.setCaretPosition(0);
		
		add(buttonBack);
		buttonBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});	
		buttonBack.setBackground(new Color(205, 102, 102));
		buttonBack.setBorder(null);
		buttonBack.setBounds(10, 10, 32, 26);
		buttonBack.setIcon(new ImageIcon(image_back));
	}

}