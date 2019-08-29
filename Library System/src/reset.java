import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.*;

import javax.swing.JTextField;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;


public class reset extends JFrame {

	private JPanel contentPane;
	private JButton exit2;
	int posX=0,posY=0;
	private JTextField user2;
	private JTextField mail2;
	private JTextField passf;
	
	private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reset frame = new reset();
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
	public reset() {
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
		
		JLabel lblNewLabel = new JLabel("Employee password recovary");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 30));
		lblNewLabel.setBounds(244, 82, 528, 53);
		contentPane.add(lblNewLabel);
		
		user2 = new JTextField();
		user2.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		user2.setToolTipText("Username");
		user2.setBounds(339, 181, 343, 53);
		contentPane.add(user2);
		user2.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setEnabled(false);
		lblUsername.setForeground(new Color(192, 192, 192));
		lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblUsername.setBounds(338, 245, 159, 53);
		contentPane.add(lblUsername);
		
		mail2 = new JTextField();
		mail2.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		mail2.setBounds(339, 313, 343, 53);
		contentPane.add(mail2);
		mail2.setColumns(10);
		
		JLabel lblEMail = new JLabel("E - mail");
		lblEMail.setEnabled(false);
		lblEMail.setForeground(new Color(192, 192, 192));
		lblEMail.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblEMail.setBounds(339, 377, 158, 53);
		contentPane.add(lblEMail);
		
		JButton btnNewButton = new JButton("Recover Password");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setRolloverEnabled(false);
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection x;
				Statement y;
				ResultSet z;
				String user_2 = user2.getText();
				String email = mail2.getText();
				String password1 = null;
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					x = DriverManager.getConnection(
							"jdbc:mysql://db4free.net:3306/ytosko_1",
							"ytosko_1", "Psycho1990");
					String sql = "SELECT * FROM `LogIN` WHERE username ='"
							+ user_2 + "' AND email ='" + email + "'";
					y = x.createStatement();

					z = y.executeQuery(sql);
					if (z.next()) {
						String s = "Your password is : " + z.getString("password");
						passf.setText(s);
						btnNewButton_1.setVisible(true);
						x.close();
						y.close();

					} else {
						passf.setText("Wrong information! Try again");
						user2.setText("");
						mail2.setText("");
						x.close();
						y.close();
					}
					x.close();
					y.close();
				}catch(Exception e)
				{
					
				}
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("MV Boli", Font.BOLD, 20));
		btnNewButton.setBackground(SystemColor.text);
		btnNewButton.setIcon(new ImageIcon("Icons\\icons8-reset-64.png"));
		btnNewButton.setBounds(339, 463, 363, 73);
		contentPane.add(btnNewButton);
		
		passf = new JTextField();
		passf.setBorder(null);
		passf.setHorizontalAlignment(JTextField.CENTER);
		passf.setForeground(new Color(138, 43, 226));
		passf.setFont(new Font("Arial Black", Font.PLAIN, 18));
		passf.setBounds(339, 571, 363, 53);
		contentPane.add(passf);
		passf.setColumns(10);
		
		btnNewButton_1 = new JButton("Back to log in");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setRolloverEnabled(false);
		btnNewButton_1.setRequestFocusEnabled(false);
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn b = new LogIn();
				b.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFont(new Font("DialogInput", Font.BOLD, 18));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon("Icons\\icons8-back-64.png"));
		btnNewButton_1.setBounds(10, 24, 283, 65);
		contentPane.add(btnNewButton_1);
		
		
	}
}
