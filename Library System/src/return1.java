import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.SystemColor;

import javax.swing.JTextArea;


public class return1 extends JFrame {

	private JPanel contentPane;
	private JButton exit2;
	int posX=0,posY=0;
	private JTextField bid1;
	private static JLabel alert;
	private JLabel l1;
	private JTextArea inf;
	String a;
	private JLabel warn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					return1 frame = new return1();
					frame.setVisible(true);
					LocalDate localDate = LocalDate.now();
	                
                    alert.setText("Today is " + DateTimeFormatter.ofPattern("dd.MM.yyyy").format(localDate));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public return1() {
		this.addMouseListener(new MouseAdapter()
		{
		   public void mousePressed(MouseEvent e)
		   {
		      posX=e.getX();
		      posY=e.getY();
		   }
		});
		this.addMouseMotionListener(new MouseAdapter()
		{
		     public void mouseDragged(MouseEvent evt)
		     {
				//sets frame position when mouse dragged			
				setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
							
		     }
		});
		setUndecorated(true);
		setVisible(true);
		setTitle("Employee log in page");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"Icons\\Library-icon.png"));
		setAlwaysOnTop(false);
		setBackground(new Color(255, 228, 225));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 665);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("Icons\\Library-icon.png"));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(
				255, 69, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		exit2 = new JButton("");
		exit2.setRequestFocusEnabled(false);
		exit2.setFocusPainted(false);
		exit2.setRolloverEnabled(false);
		exit2.setContentAreaFilled(false);
		exit2.setBorderPainted(false);
		exit2.setIcon(new ImageIcon(
				"Icons\\icons8-shutdown-64.png"));
		exit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit2.setBorder(null);
		exit2.setBackground(Color.WHITE);
		exit2.setBounds(898, 11, 87, 78);
		contentPane.add(exit2);
		
		l1 = new JLabel("Book id");
		l1.setForeground(new Color(128, 0, 0));
		l1.setEnabled(false);
		l1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		l1.setBounds(51, 220, 147, 40);
		contentPane.add(l1);
		bid1 = new JTextField();
		bid1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(85, 107, 47)));
		bid1.setForeground(new Color(128, 0, 0));
		bid1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		bid1.setBounds(51, 159, 147, 50);
		contentPane.add(bid1);
		bid1.setColumns(10);
		JButton f11 = new JButton("");
		f11.setContentAreaFilled(false);
		f11.setBorderPainted(false);
		f11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String code = bid1.getText().toString().trim();
				if(code.equals("")){
					warn.setText("Book code can not be empty!");
				}
				else{
					inf.setText("");
					Connection x;
					Statement y;
					ResultSet z;
					try{
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						x = DriverManager.getConnection(
								"jdbc:mysql://db4free.net:3306/ytosko_1",
								"ytosko_1", "Psycho1990");
						String sql = "SELECT * FROM `lbms` WHERE bookid ='"
								+ code + "'";
						y = x.createStatement();

						z = y.executeQuery(sql);
						if (z.next()) {
							String s = System.lineSeparator() + "Book id : " + z.getString("bookid") + System.lineSeparator() + "Member id : " + z.getString("memid") + System.lineSeparator() + System.lineSeparator() + "Issued on : " + z.getString("datei") + System.lineSeparator() +  "Return date : " + z.getString("dater");
							inf.setText(s);
							a= z.getString("bookid");
							x.close();
							y.close();
							
						} else {
							warn.setText("Book not found in database!");
							//src.setText("");
							x.close();
							y.close();
						}
						x.close();
						y.close();
					}catch(Exception e){
						
					}
				
			}
			}
		});
		f11.setRolloverEnabled(false);
		f11.setRequestFocusEnabled(false);
		f11.setBorder(null);
		f11.setBackground(new Color(255, 255, 255));
		f11.setIcon(new ImageIcon("Icons\\search_filled_50px.png"));
		f11.setBounds(213, 159, 83, 50);
		contentPane.add(f11);
		JButton btnNewButton = new JButton("Back to Hompage");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setRolloverEnabled(false);
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LibMS y = new LibMS();
				setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(SystemColor.text);
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("DialogInput", Font.BOLD, 18));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("Icons\\icons8-back-64.png"));
		btnNewButton.setBounds(702, 563, 283, 65);
		contentPane.add(btnNewButton);
		alert = new JLabel("");
		alert.setForeground(new Color(128, 0, 0));
		alert.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		alert.setHorizontalAlignment(SwingConstants.CENTER);
		alert.setBounds(662, 159, 231, 57);
		contentPane.add(alert);
		
		JButton issue = new JButton("Recieve book");
		issue.setContentAreaFilled(false);
		issue.setBorderPainted(false);
		issue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(a.equals("")){
					warn.setText("Book code can not be empty!");
				}
				else{
					Connection x1;
					try{
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						x1 = DriverManager.getConnection(
								"jdbc:mysql://db4free.net:3306/ytosko_1",
								"ytosko_1", "Psycho1990");
						String sql = "DELETE FROM `lbms` WHERE bookid = '"
								+ a + "'";
						try(PreparedStatement pstmt = x1.prepareStatement(sql)){
							 
                        pstmt.executeUpdate();
                        warn.setText("The book has been recieved!");
                        String sql1 = "UPDATE `Book_List` SET `status`= ?";
                        PreparedStatement y1 = x1.prepareStatement(sql1);
                        y1.setString(1 , "yes");
                        y1.executeUpdate();
				            x1.close();
		}catch(Exception e){
			
		}
				 
						x1.close();
					}catch(Exception e){
						
					}
				}
			}
		});
		issue.setBorder(null);
		issue.setRolloverEnabled(false);
		issue.setRequestFocusEnabled(false);
		issue.setForeground(new Color(128, 0, 0));
		issue.setFont(new Font("Consolas", Font.BOLD, 20));
		issue.setBackground(SystemColor.text);
		issue.setIcon(new ImageIcon("Icons\\recieve_128px.png"));
		issue.setBounds(677, 266, 207, 146);
		issue.setVerticalTextPosition( SwingConstants.BOTTOM ) ;
		issue.setHorizontalTextPosition( SwingConstants.CENTER ) ;
		contentPane.add(issue);
		
		inf = new JTextArea();
		inf.setEditable(false);
		inf.setForeground(new Color(255, 140, 0));
		inf.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		inf.setBorder(null);
		inf.setBounds(51, 276, 245, 332);
		contentPane.add(inf);
		
		warn = new JLabel("");
		warn.setForeground(new Color(47, 79, 79));
		warn.setFont(new Font("Consolas", Font.BOLD, 15));
		warn.setBounds(676, 460, 309, 57);
		issue.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(warn);
	}
}
