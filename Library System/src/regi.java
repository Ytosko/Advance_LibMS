import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import com.sun.xml.internal.ws.api.Component;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class regi extends JFrame {

	private JPanel contentPane;
	private JButton exit2;
	int posX=0,posY=0;
	private JTextField user3;
	private JTextField mail3;
	private JPasswordField pass3;
	private JPasswordField pass4;
	private JTextField Warning;
	private JButton btnNewButton_1;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regi frame = new regi();
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
	public regi() {
		
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
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.CYAN));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		exit2 = new JButton("");
		exit2.setFocusTraversalKeysEnabled(false);
		exit2.setRolloverEnabled(false);
		exit2.setRequestFocusEnabled(false);
		exit2.setFocusPainted(false);
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
		
		JLabel lblNewLabel = new JLabel("Employee Registration");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 30));
		lblNewLabel.setBounds(37, 43, 757, 53);
		contentPane.add(lblNewLabel);
		
		user3 = new JTextField();
		user3.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		user3.setToolTipText("Username");
		user3.setBounds(249, 122, 432, 53);
		contentPane.add(user3);
		user3.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setIcon(new ImageIcon("Icons\\name.png"));
		lblUsername.setForeground(new Color(192, 192, 192));
		lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblUsername.setBounds(37, 117, 210, 64);
		contentPane.add(lblUsername);
		
		mail3 = new JTextField();
		mail3.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		mail3.setBounds(249, 211, 432, 53);
		contentPane.add(mail3);
		mail3.setColumns(10);
		
		JLabel lblEMail = new JLabel("    E - mail");
		lblEMail.setIcon(new ImageIcon("Icons\\email.png"));
		lblEMail.setForeground(new Color(192, 192, 192));
		lblEMail.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblEMail.setBounds(37, 212, 210, 53);
		contentPane.add(lblEMail);
		
		pass3 = new JPasswordField();
		pass3.setBounds(37, 305, 300, 53);
		pass3.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		contentPane.add(pass3);
		
		pass4 = new JPasswordField();
		pass4.setBounds(381, 305, 300, 53);
		pass4.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		contentPane.add(pass4);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setIcon(new ImageIcon("Icons\\password.png"));
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setBounds(37, 369, 300, 58);
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 20));
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("  Confirm password");
		lblConfirmPassword.setIcon(new ImageIcon("Icons\\img_icons8_default_3.png"));
		lblConfirmPassword.setForeground(Color.GRAY);
		lblConfirmPassword.setBounds(381, 372, 290, 53);
		lblConfirmPassword.setFont(new Font("Century Gothic", Font.BOLD, 20));
		contentPane.add(lblConfirmPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setContentAreaFilled(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setBorder(null);
		btnRegister.setRolloverEnabled(false);
		btnRegister.setRequestFocusEnabled(false);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newuser = user3.getText().toString().trim();
				String newmail = mail3.getText().toString().trim();
				String password1 = String.valueOf(pass3.getPassword());
				String password2 = String.valueOf(pass4.getPassword());
				if(newuser.equals("") || newmail.equals("") || password1.equals("") || password2.equals("")){
					Warning.setText("Try filling the form properly!");
					user3.setText("");
					mail3.setText("");
					pass3.setText("");
					pass4.setText("");
					
				}
				else if(password1.equals(password2) && newuser!="" && newmail!=""){
					Warning.setText("");
					Connection x;
					Statement y;
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						x = DriverManager.getConnection(
								"jdbc:mysql://db4free.net:3306/ytosko_1",
								"ytosko_1", "Psycho1990");
						y = x.createStatement();
                       String sql = ("INSERT INTO LogIN(username,password,email)" + "VALUES (?,?,?)");
                       
                       PreparedStatement preparedStatement = x.prepareStatement(sql);
                       preparedStatement.setString(1, newuser);
                       preparedStatement.setString(2, password1);
                       preparedStatement.setString(3, newmail);
                       preparedStatement.executeUpdate(); 
                       
                        x.close();
                        y.close();
                        Warning.setText("You are now registered!");
					} catch (Exception e) {
						System.out.println("Error here!");
					}
				}
				else{
					Warning.setText("Passwords does not matched!");
				}
				
			}
		});
		btnRegister.setBackground(SystemColor.text);
		btnRegister.setForeground(new Color(0, 128, 128));
		btnRegister.setFont(new Font("Consolas", Font.BOLD, 25));
		btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegister.setIcon(new ImageIcon("Icons\\img_icons8_default_2.png"));
		btnRegister.setBounds(37, 518, 210, 58);
		contentPane.add(btnRegister);
		
		JLabel lblByClickingRegister = new JLabel("By clicking register you are validating our  terms and conditions");
		lblByClickingRegister.setForeground(new Color(0, 0, 128));
		lblByClickingRegister.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblByClickingRegister.setBounds(37, 449, 645, 46);
		contentPane.add(lblByClickingRegister);
		
		Warning = new JTextField();
		Warning.setBorder(null);
		Warning.setForeground(new Color(255, 0, 0));
		Warning.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		Warning.setBounds(37, 601, 644, 53);
		contentPane.add(Warning);
		Warning.setColumns(10);
		btnNewButton_1 = new JButton("Back to Hompage");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setRolloverEnabled(false);
		btnNewButton_1.setRequestFocusEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main y = new main();
				setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setBorder(null);
	    btnNewButton_1.setVisible(true);
		btnNewButton_1.setFont(new Font("DialogInput", Font.BOLD, 18));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon("Icons\\icons8-back-64.png"));
		btnNewButton_1.setBounds(702, 514, 283, 65);
		contentPane.add(btnNewButton_1);
	}
}
