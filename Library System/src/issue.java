import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import java.awt.Font;
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
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JTextArea;


public class issue extends JFrame {

	private JPanel contentPane;
	int posX=0,posY=0;
	private JButton exit2;
	private JTextField bid;

	private JLabel l1;
	private JLabel alert;
	private static JTextArea t1;
	private JTextField mid;
	private JLabel l2;
	private static JTextArea t2;
	private static JButton Issue;
	String code1;
	String code2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issue frame = new issue();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public issue() {
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
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		
		exit2 = new JButton("");
		exit2.setBounds(898, 11, 87, 78);
		exit2.setFocusPainted(false);
		exit2.setRolloverEnabled(false);
		exit2.setRequestFocusEnabled(false);
		exit2.setContentAreaFilled(false);
		exit2.setBorderPainted(false);
		exit2.setIcon(new ImageIcon(
				"Icons\\icons8-shutdown-64.png"));
		exit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		contentPane.setLayout(null);
		exit2.setBorder(null);
		exit2.setBackground(Color.WHITE);
		contentPane.add(exit2);
		
		JLabel lblBookInfo = new JLabel("Book info");
		lblBookInfo.setForeground(new Color(47, 79, 79));
		lblBookInfo.setFont(new Font("Consolas", Font.BOLD, 20));
		lblBookInfo.setBounds(51, 98, 212, 50);
		contentPane.add(lblBookInfo);
		
		bid = new JTextField();
		bid.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(85, 107, 47)));
		bid.setForeground(new Color(128, 0, 0));
		bid.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		bid.setBounds(51, 159, 147, 50);
		contentPane.add(bid);
		bid.setColumns(10);
		
		JButton f1 = new JButton("");
		f1.setContentAreaFilled(false);
		f1.setBorderPainted(false);
		f1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				code1 = bid.getText().toString().trim();
				alert.setText("Please wait");
				if(code1.equals("")){
					alert.setText("Fill all the informations!");
				}
				else{
					alert.setText("");
					Connection x;
					Statement y;
					ResultSet z;
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						x = DriverManager.getConnection(
								"jdbc:mysql://db4free.net:3306/ytosko_1",
								"ytosko_1", "Psycho1990");
						String sql = "SELECT * FROM `Book_List` WHERE code ='"
								+ code1 + "'";
						y = x.createStatement();

						z = y.executeQuery(sql);
						alert.setText("Please wait");
						if (z.next()) {
							String s = z.getString("name") + System.lineSeparator()+ System.lineSeparator() + "by " + z.getString("author") + System.lineSeparator() + z.getString("edition") + " Edition/Version" + System.lineSeparator() + "Availablity : " + z.getString("status");
							l1.setVisible(true);
							t1.setText(s);
							x.close();
							y.close();
							alert.setText("");
							String a = t1.getText().toString().trim();
							String b = t2.getText().toString().trim();
							if(!a.equals("") && !b.equals("")){
								Issue.setVisible(true);
							}

						} else {
							alert.setText("Book not found in database!");
							x.close();
							y.close();
						}
						x.close();
						y.close();
						alert.setText("");
					} catch (Exception e) {
						System.out.println("Error here!");
					}
			}
			}
		});
		f1.setRolloverEnabled(false);
		f1.setRequestFocusEnabled(false);
		f1.setBorder(null);
		f1.setBackground(new Color(255, 255, 255));
		f1.setIcon(new ImageIcon("Icons\\search_filled_50px.png"));
		f1.setBounds(213, 159, 83, 50);
		contentPane.add(f1);
		
		t1 = new JTextArea();
		t1.setEditable(false);
		t1.setForeground(new Color(255, 69, 0));
		t1.setFont(new Font("Consolas", Font.BOLD, 20));
		t1.setBounds(51, 271, 245, 267);
		contentPane.add(t1);
		
		JLabel lblMemberInfo = new JLabel("Member info");
		lblMemberInfo.setForeground(new Color(85, 107, 47));
		lblMemberInfo.setFont(new Font("Consolas", Font.BOLD, 20));
		lblMemberInfo.setBounds(397, 98, 164, 50);
		contentPane.add(lblMemberInfo);
		
		l1 = new JLabel("Book id");
		l1.setForeground(new Color(128, 0, 0));
		l1.setEnabled(false);
		l1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		l1.setBounds(51, 220, 147, 40);
		contentPane.add(l1);
		
		mid = new JTextField();
		mid.setForeground(new Color(0, 100, 0));
		mid.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		mid.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(139, 0, 139)));
		mid.setBounds(397, 163, 164, 50);
		contentPane.add(mid);
		mid.setColumns(10);
		
		JButton f2 = new JButton("");
		f2.setContentAreaFilled(false);
		f2.setBorderPainted(false);
		f2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				code2 = mid.getText().toString().trim();
				alert.setText("Please wait");
				if(code2.equals("")){
					alert.setText("Fill all the informations!");
				}
				else{
					alert.setText("");
					Connection x;
					Statement y;
					ResultSet z;
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						x = DriverManager.getConnection(
								"jdbc:mysql://db4free.net:3306/ytosko_1",
								"ytosko_1", "Psycho1990");
						String sql = "SELECT * FROM `member` WHERE id ='"
								+ code2 + "'";
						y = x.createStatement();

						z = y.executeQuery(sql);
						
						if (z.next()) {
							String s = "Name : " + z.getString("name") + System.lineSeparator()+ "Institute : " + z.getString("inst") + System.lineSeparator() + "Phone : " + z.getString("phn") + System.lineSeparator() + "E - mail : " + z.getString("mail");
							l2.setVisible(true);
							t2.setText(s);
							x.close();
							y.close();
							String a = t1.getText().toString().trim();
							String b = t2.getText().toString().trim();
							if(!a.equals("") && !b.equals("")){
								Issue.setVisible(true);
							}

						} else {
							alert.setText("Book not found in database!");
							x.close();
							y.close();
						}
						x.close();
						y.close();
						alert.setText("");
					} catch (Exception e) {
						System.out.println("Error here!");
					}
			}
			}
		});
		f2.setIcon(new ImageIcon("Icons\\search_filled_50px.png"));
		f2.setRolloverEnabled(false);
		f2.setRequestFocusEnabled(false);
		f2.setBorder(null);
		f2.setBackground(Color.WHITE);
		f2.setBounds(571, 163, 83, 50);
		contentPane.add(f2);
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
		btnNewButton.setBounds(39, 562, 283, 65);
		contentPane.add(btnNewButton);
		l2 = new JLabel("Member id");
		l2.setForeground(new Color(128, 0, 0));
		l2.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		l2.setEnabled(false);
		l2.setBounds(397, 220, 147, 40);
		contentPane.add(l2);
		
		t2 = new JTextArea();
		t2.setEditable(false);
		t2.setForeground(new Color(255, 69, 0));
		t2.setFont(new Font("Consolas", Font.BOLD, 20));
		t2.setBounds(397, 271, 406, 267);
		contentPane.add(t2);
		
		Issue = new JButton("Issue");
		Issue.setContentAreaFilled(false);
		Issue.setBorderPainted(false);
		Issue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alert.setText("");
				Connection x;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					x = DriverManager.getConnection(
							"jdbc:mysql://db4free.net:3306/ytosko_1",
							"ytosko_1", "Psycho1990");
                   String sql = ("INSERT INTO `lbms`(memid,	bookid,	datei,	dater)" + "VALUES (?,?,?,?)");
                   
                   PreparedStatement y = x.prepareStatement(sql);
                   y.setString(1, code1);
                   y.setString(2, code2);
                   LocalDate localDate = LocalDate.now();
                   y.setString(3, DateTimeFormatter.ofPattern("dd.MM.yyyy").format(localDate));

                   SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                   Calendar c = Calendar.getInstance();
                   c.setTime(new Date()); // Now use today date.
                   c.add(Calendar.DATE, 7); // Adding 5 days
                   String output = sdf.format(c.getTime());
                   y.setString(4, output);
                   y.executeUpdate(); 
                   String sql1 = "UPDATE `Book_List` SET `status`= ?";
                   PreparedStatement y1 = x.prepareStatement(sql1);
                   y1.setString(1 , "no");
                   y1.executeUpdate(); 
                    x.close();
                    y.close();
                    alert.setText("Issued");
			}catch(Exception e){
				
			}
			}
		});
		Issue.setBackground(SystemColor.text);
		Issue.setBorder(null);
		Issue.setRequestFocusEnabled(false);
		Issue.setRolloverEnabled(false);
		Issue.setForeground(new Color(75, 0, 130));
		Issue.setFont(new Font("Consolas", Font.BOLD, 20));
		Issue.setIcon(new ImageIcon("Icons\\magazine_96px.png"));
		Issue.setBounds(813, 475, 128, 143);
		Issue.setVerticalTextPosition( SwingConstants.BOTTOM ) ;
		Issue.setHorizontalTextPosition( SwingConstants.CENTER ) ;
		Issue.setVisible(false);
		contentPane.add(Issue);
		
		alert = new JLabel("");
		alert.setForeground(new Color(128, 0, 0));
		alert.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		alert.setHorizontalAlignment(SwingConstants.CENTER);
		alert.setBounds(764, 407, 231, 57);
		contentPane.add(alert);
	}
}
