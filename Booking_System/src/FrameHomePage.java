import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FrameHomePage extends JFrame {

	private JPanel contentPane;
	private Image image_User = new ImageIcon(FrameHomePage.class.getResource("image/user_icon.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
	private Image image_Home = new ImageIcon(FrameHomePage.class.getResource("image/home_icon.png")).getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
	private Image image_Member = new ImageIcon(FrameHomePage.class.getResource("image/member_icon.png")).getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
	private Image image_Booking = new ImageIcon(FrameHomePage.class.getResource("image/booking_icon.png")).getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
	private Image image_News = new ImageIcon(FrameHomePage.class.getResource("image/news_icon.png")).getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
	private Image image_Ticket = new ImageIcon(FrameHomePage.class.getResource("image/ticket_icon.png")).getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
	private Image image_SignOut = new ImageIcon(FrameHomePage.class.getResource("image/signout_icon.png")).getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
	private Image image_Exit = new ImageIcon(FrameHomePage.class.getResource("image/close_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	
	private final JLabel labelFilmEx = new JLabel("FilmEx");
	private final JPanel panelMenu = new JPanel();
	private final JLabel labelUserIcon = new JLabel("");
	public static JTextField textUserName = new JTextField();
	private final JPanel tabHome = new JPanel();
	private final JPanel tabMember = new JPanel();
	private final JPanel tabBooking = new JPanel();
	private final JPanel tabNews = new JPanel();
	private final JPanel tabTicket = new JPanel();
	private final JPanel tabSignOut = new JPanel();
	private final JLabel labelHome = new JLabel("HOME");
	private final JLabel labelMember = new JLabel("MEMBER");
	private final JLabel labelBooking = new JLabel("BOOKING ");
	private final JLabel labelNews = new JLabel("NEWS");
	private final JLabel labelTicket = new JLabel("TICKET");
	private final JLabel labelSignOut = new JLabel("SIGN OUT");
	private final JLabel labelIconhome = new JLabel("");
	private final JLabel labelIconMember = new JLabel("");
	private final JLabel labelIconBooking = new JLabel("");
	private final JLabel labelIconNews = new JLabel("");
	private final JLabel labelIconTicket = new JLabel("");
	private final JLabel labelIconSignOut = new JLabel("");
	private final JPanel panelMainContent = new JPanel();
	
	private final JPanel header = new JPanel();
	private final JButton exitButton = new JButton("");
	
	private PanelHome panelHome = new PanelHome();
	private PanelMember panelMember = new PanelMember();
	private PanelBooking panelBooking = new PanelBooking();
	private PanelNews panelNews = new PanelNews();
	private PanelTicket panelTicket = new PanelTicket();
	private PanelFilm panelFilm = new PanelFilm();
	
	private int mouseX, mouseY;

	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHomePage frame = new FrameHomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the frame.
	public FrameHomePage() {
		textUserName.setDisabledTextColor(Color.BLACK);
		textUserName.setForeground(Color.BLACK);
		textUserName.setBorder(null);
		textUserName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textUserName.setHorizontalAlignment(SwingConstants.CENTER);
		textUserName.setOpaque(false);
		textUserName.setEnabled(false);
		textUserName.setEditable(false);
		textUserName.setBounds(74, 111, 96, 19);
		textUserName.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		getContentPane().setBackground(new Color(250, 128, 114));
		setUndecorated(true);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		
		//Menu big panel
		getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		panelMenu.setBackground(new Color(220, 20, 60));
		panelMenu.setBounds(0, 20, 254, 580);
		
		panelMenu.add(labelFilmEx);
		labelFilmEx.setFont(new Font("Times New Roman", Font.BOLD, 30));
		labelFilmEx.setBounds(74, 10, 97, 35);
		
		panelMenu.add(labelUserIcon);
		labelUserIcon.setBounds(91, 47, 60, 60);
		labelUserIcon.setIcon(new ImageIcon(image_User));
		
		panelMenu.add(textUserName);
		
		//Home panel
		panelMenu.add(tabHome);
		tabHome.addMouseListener(new PanelButtonMouseAdapter(tabHome) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelHome);
			}
		});
		tabHome.setLayout(null);
		tabHome.setBackground(new Color(220, 20, 60));
		tabHome.setBounds(0, 140, 254, 60);
		
		tabHome.add(labelHome);
		labelHome.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelHome.setBounds(90, 10, 110, 40);
		
		tabHome.add(labelIconhome);
		labelIconhome.setBounds(26, 0, 60, 60);
		labelIconhome.setIcon(new ImageIcon(image_Home));
		
		//Member panel
		panelMenu.add(tabMember);
		tabMember.addMouseListener(new PanelButtonMouseAdapter(tabMember) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelMember);
			}
		});
		tabMember.setLayout(null);
		tabMember.setBackground(new Color(220, 20, 60));
		tabMember.setBounds(0, 200, 254, 60);
		
		tabMember.add(labelMember);
		labelMember.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelMember.setBounds(90, 10, 130, 40);
		
		tabMember.add(labelIconMember);
		labelIconMember.setBounds(26, 0, 48, 60);
		labelIconMember.setIcon(new ImageIcon(image_Member));
		
		//Booking panel
		panelMenu.add(tabBooking);
		tabBooking.addMouseListener(new PanelButtonMouseAdapter(tabBooking) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelBooking);
			}
		});
		tabBooking.setLayout(null);
		tabBooking.setBackground(new Color(220, 20, 60));
		tabBooking.setBounds(0, 259, 254, 60);
		
		tabBooking.add(labelBooking);
		labelBooking.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelBooking.setBounds(90, 10, 144, 40);
		
		tabBooking.add(labelIconBooking);
		labelIconBooking.setBounds(26, 0, 60, 60);
		labelIconBooking.setIcon(new ImageIcon(image_Booking));
		
		//News panel
		panelMenu.add(tabNews);
		tabNews.addMouseListener(new PanelButtonMouseAdapter(tabNews) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelNews);
			}
		});
		tabNews.setLayout(null);
		tabNews.setBackground(new Color(220, 20, 60));
		tabNews.setBounds(0, 319, 254, 60);
		
		tabNews.add(labelNews);
		labelNews.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelNews.setBounds(90, 10, 110, 40);
		
		tabNews.add(labelIconNews);
		labelIconNews.setBounds(26, 0, 60, 60);
		labelIconNews.setIcon(new ImageIcon(image_News));
		
		//Ticket panel
		panelMenu.add(tabTicket);
		tabTicket.addMouseListener(new PanelButtonMouseAdapter(tabTicket) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelTicket);
			}
		});
		tabTicket.setLayout(null);
		tabTicket.setBackground(new Color(220, 20, 60));
		tabTicket.setBounds(0, 379, 254, 60);
		
		tabTicket.add(labelTicket);
		labelTicket.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelTicket.setBounds(90, 10, 110, 40);
		
		tabTicket.add(labelIconTicket);
		labelIconTicket.setBounds(26, 0, 60, 60);
		labelIconTicket.setIcon(new ImageIcon(image_Ticket));
		
		//SignOut panel
		panelMenu.add(tabSignOut);
		tabSignOut.addMouseListener(new PanelButtonMouseAdapter(tabSignOut) {
			@Override
			public void mouseClicked(MouseEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?", "Sign Out", JOptionPane.YES_NO_OPTION);
				if (confirmed == JOptionPane.YES_OPTION) {
					FrameLogin frameLogin = new FrameLogin();
					frameLogin.setVisible(true);
					FrameHomePage.this.dispose();
				}
				else 
					FrameHomePage.this.setVisible(true);
			}
		});
		tabSignOut.setLayout(null);
		tabSignOut.setBackground(new Color(220, 20, 60));
		tabSignOut.setBounds(0, 439, 254, 60);
		
		tabSignOut.add(labelSignOut);
		labelSignOut.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelSignOut.setBounds(90, 10, 130, 40);
		
		tabSignOut.add(labelIconSignOut);
		labelIconSignOut.setBounds(24, 0, 60, 60);
		labelIconSignOut.setIcon(new ImageIcon(image_SignOut));
		
		getContentPane().add(panelMainContent);
		panelMainContent.setBackground(new Color(205, 102, 102));
		panelMainContent.setBounds(254, 20, 747, 580);
		panelMainContent.setLayout(null);
		panelMainContent.add(panelHome);
		panelMainContent.add(panelMember);
		panelMainContent.add(panelBooking);
		panelMainContent.add(panelNews);
		panelMainContent.add(panelTicket);
		
		menuClicked(panelHome);
		
		getContentPane().add(header);
		header.setBounds(0, 0, 1000, 20);
		header.setLayout(null);
		
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getX() + e.getX() - mouseX, getY() + e.getY() - mouseY);
			}
		});
		header.addMouseListener(new MouseAdapter( ) {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		
		header.add(exitButton);
		exitButton.setBounds(980, 0, 20, 20);
		exitButton.setBackground(Color.WHITE);
		exitButton.setBorder(null);
		exitButton.setContentAreaFilled(false);
		exitButton.setIcon(new ImageIcon(image_Exit));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame fromLoginSystem = new JFrame("Exit");
				int confirmed = JOptionPane.showConfirmDialog(fromLoginSystem, "Are you sure you want to exit this application?", 
				"Login System", JOptionPane.YES_NO_OPTION);
				if (confirmed == JOptionPane.YES_OPTION)
					System.exit(0);
				else
					setVisible(true);
			}
		});
	}
	
	public void menuClicked(JPanel panel) {
		panelHome.setVisible(false);
		panelMember.setVisible(false);
		panelBooking.setVisible(false);
		panelNews.setVisible(false);
		panelTicket.setVisible(false);
		panel.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(205, 102, 102));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(220, 20, 60));
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(255, 102, 102));
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(205, 102, 102));
		}
	}
}
