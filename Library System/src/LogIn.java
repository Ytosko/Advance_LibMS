import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import java.awt.Component;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtLogInWith;
	private JButton loginbtn;
	private JButton btnNewButton;
	private JButton back1;
	private JButton exit2;
	private JLabel errormsz;
	int posX=0,posY=0;
	/**
	 * Launch the application.
	 */
	public static void login(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
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
		setAutoRequestFocus(false);
		//setUndecorated(true);
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

		user = new JTextField();
		user.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		user.setActionCommand("");
		user.setToolTipText("Username / E-mail");
		user.setBounds(263, 148, 446, 40);
		contentPane.add(user);
		user.setColumns(10);

		pass = new JPasswordField();
		pass.setEchoChar('*');
		pass.setToolTipText("Password");
		pass.setBounds(263, 251, 446, 40);
		contentPane.add(pass);

		txtUserName = new JTextField();
		txtUserName.setInheritsPopupMenu(true);
		txtUserName.setIgnoreRepaint(true);
		txtUserName.setFocusTraversalPolicyProvider(true);
		txtUserName.setFocusCycleRoot(true);
		txtUserName.setDragEnabled(true);
		txtUserName.setDoubleBuffered(true);
		txtUserName.setBackground(new Color(255, 255, 255));
		txtUserName.setBorder(null);
		txtUserName.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION);
		txtUserName.setEnabled(false);
		txtUserName.setEditable(false);
		txtUserName.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtUserName.setFont(new Font("Courier New", Font.BOLD, 17));
		txtUserName.setForeground(new Color(0, 100, 0));
		txtUserName.setText("Username");
		txtUserName.setBounds(263, 204, 240, 36);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setEditable(false);
		txtPassword.setEnabled(false);
		txtPassword.setDoubleBuffered(true);
		txtPassword.setDragEnabled(true);
		txtPassword.setFocusCycleRoot(true);
		txtPassword.setFocusTraversalPolicyProvider(true);
		txtPassword.setIgnoreRepaint(true);
		txtPassword.setInheritsPopupMenu(true);
		txtPassword.setBackground(new Color(255, 255, 255));
		txtPassword.setBorder(null);
		txtPassword.setFont(new Font("Courier New", Font.BOLD, 17));
		txtPassword.setForeground(new Color(0, 0, 255));
		txtPassword.setText("Password");
		txtPassword.setBounds(263, 302, 240, 36);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);

		txtLogInWith = new JTextField();
		txtLogInWith.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		txtLogInWith.setForeground(new Color(139, 0, 0));
		txtLogInWith.setBorder(null);
		txtLogInWith.setAutoscrolls(false);
		txtLogInWith.setBackground(new Color(255, 255, 255));
		txtLogInWith.setEditable(false);
		txtLogInWith.setText("Log in with your Employee username");
		txtLogInWith.setBounds(280, 40, 501, 67);
		contentPane.add(txtLogInWith);
		txtLogInWith.setColumns(10);

		loginbtn = new JButton("   Log in");
		loginbtn.setBorderPainted(false);
		loginbtn.setContentAreaFilled(false);
		loginbtn.setRolloverEnabled(false);
		loginbtn.setRequestFocusEnabled(false);
		loginbtn.setIcon(new ImageIcon(
				"Icons\\icons8-login-50.png"));
		loginbtn.setBackground(Color.WHITE);
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection x;
				Statement y;
				ResultSet z;
				String user1 = user.getText();
				String pass1 = String.valueOf(pass.getPassword());
				try {
					
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					x = DriverManager.getConnection(
							"jdbc:mysql://db4free.net:3306/ytosko_1",
							"ytosko_1", "Psycho1990");
					String sql = "SELECT * FROM `LogIN` WHERE username ='"
							+ user1 + "' AND password ='" + pass1 + "'";
					y = x.createStatement();

					z = y.executeQuery(sql);
					if (z.next()) {
						setVisible(false);
						Prgrs b = new Prgrs();
						b.setVisible(true);
						Prgrs.prgsRun(null);
						x.close();
						y.close();

					} else {
						errormsz.setVisible(true);
						user.setText("");
						pass.setText("");
						x.close();
						y.close();
					}
					x.close();
					y.close();
				} catch (Exception e) {
					System.out.println("Error here!");
				}
			}
		});
		loginbtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		loginbtn.setForeground(Color.BLUE);
		loginbtn.setBorder(null);
		loginbtn.setAutoscrolls(true);
		loginbtn.setBounds(402, 365, 172, 56);
		contentPane.add(loginbtn);

		btnNewButton = new JButton("Forgotten account?");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setDefaultCapable(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset a = new reset();
				setVisible(true);
				dispose();
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(75, 0, 130));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(499, 309, 210, 23);
		contentPane.add(btnNewButton);

		back1 = new JButton("     Back");
		back1.setContentAreaFilled(false);
		back1.setBorderPainted(false);
		back1.setRolloverEnabled(false);
		back1.setRequestFocusEnabled(false);
		back1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				main y = new main();
				setVisible(true);
				dispose();

			}
		});
		back1.setForeground(new Color(0, 128, 128));
		back1.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		back1.setBorder(null);
		back1.setBackground(new Color(255, 255, 255));
		back1.setIcon(new ImageIcon("Icons\\icons8-back-50.png"));
		back1.setBounds(402, 445, 172, 56);
		contentPane.add(back1);

		exit2 = new JButton("");
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
		exit2.setBorder(null);
		exit2.setBackground(Color.WHITE);
		exit2.setBounds(898, 11, 87, 78);
		contentPane.add(exit2);
		
		errormsz = new JLabel("Wrong username or password! try again");
		errormsz.setForeground(new Color(255, 69, 0));
		errormsz.setVisible(false);
		errormsz.setFont(new Font("Century Gothic", Font.BOLD, 18));
		errormsz.setBounds(319, 513, 358, 40);
		contentPane.add(errormsz);

	}
}
