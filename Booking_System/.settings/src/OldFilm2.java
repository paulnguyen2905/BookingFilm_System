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

public class OldFilm2 extends JPanel {
	private Image image_back = new ImageIcon(OldFilm2.class.getResource("image/back_icon.png")).getImage().getScaledInstance(32, 26, Image.SCALE_SMOOTH);
	private Image image_poster = new ImageIcon(OldFilm2.class.getResource("posterNowShowing/poster_nobita.jpg")).getImage().getScaledInstance(268, 380, Image.SCALE_SMOOTH);
	private Image image_buy = new ImageIcon(OldFilm2.class.getResource("image/buyticket_icon.png")).getImage().getScaledInstance(120, 70, Image.SCALE_SMOOTH);
	private Image image_trailer = new ImageIcon(OldFilm2.class.getResource("image/trailer_icon.png")).getImage().getScaledInstance(148, 64, Image.SCALE_SMOOTH);
	
	private final JLabel labelTitle = new JLabel("NOBITA VÀ NHỮNG BẠN KHỦNG LONG MỚI");
	private final JLabel labelImage1 = new JLabel();
	private final JLabel labelImage2 = new JLabel();
	private final JLabel labelImage3 = new JLabel();
	private final JButton buttonBack = new JButton("");
	private final JTextArea textFilm = new JTextArea();
	private final JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();

	//Create the panel.
	public OldFilm2() {
		initGUI();
	}
	
	private void initGUI() {
		setBounds(0 , 0, 747, 580);
		setBackground(new Color(205, 102, 102));
		setLayout(null);
		
		add(labelTitle);
		labelTitle.setBounds(54, 8, 665, 35);
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
			        Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=2vdLzk15Z0w&feature=emb_title"));
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
		textFilm.setText("- Đạo diễn: Kazuaki Imai" 
				+ "\n- Diễn viên: "
				+ "\n- Thể loại: Hoạt Hình"
				+ "\n- Khởi chiếu: 18/12/2020 "
				+ "\n- Thời lượng: 110 phút "
				+ "\n- Ngôn ngữ: Tiếng Nhật - Phụ đề Tiếng Việt; Lồng tiếng"
				+ "\n- Giới hạn độ tuổi: P - PHIM DÀNH CHO MỌI ĐỐI TƯỢNG\n"
				
				+ "\nTrong lúc đang tham gia hoạt động khảo cổ ở một cuộc "
				+ "\ntriễn lãm khủng long, Nobita tình cờ tìm thấy một viên hóa "
				+ "\nthạch và cậu tin rằng đây là trứng khủng long. "
				+ "\nNobita liền mượn bảo bối thần kỳ \"khăn trùm thời gian\" "
				+ "\ncủa Doraemon để giúp viên hóa thạch trở lại thời của "
				+ "\nchúng nhưng ngay sau đó, quả trứng liền nở ra một cặp "
				+ "\nkhủng long song sinh. Ngạc nhiên hơn hết, đây lại là loài "
				+ "\nkhủng long mới hoàn toàn và chưa từng được phát hiện.");
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
