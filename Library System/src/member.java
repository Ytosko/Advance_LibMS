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
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.*;

import javax.swing.SwingConstants;


public class member extends JFrame {

	private JPanel contentPane;
	int posX=0,posY=0;
	private JButton exit2;
	private JTextField name1;
	private JTextField inst;
	private JTextField phn;
	private JTextField em;
	private JTextField id;
	private JLabel alert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					member frame = new member();
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
	public member() {
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
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		setContentPane(contentPane);
		
		exit2 = new JButton("");
		exit2.setBounds(898, 11, 87, 78);
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
		contentPane.setLayout(null);
		exit2.setBorder(null);
		exit2.setBackground(Color.WHITE);
		contentPane.add(exit2);
		
		name1 = new JTextField();
		name1.setForeground(new Color(25, 25, 112));
		name1.setFont(new Font("Consolas", Font.BOLD, 18));
		name1.setBounds(335, 106, 368, 72);
		contentPane.add(name1);
		name1.setColumns(10);
		
		inst = new JTextField();
		inst.setForeground(new Color(25, 25, 112));
		inst.setFont(new Font("Consolas", Font.BOLD, 18));
		inst.setBounds(335, 189, 368, 72);
		contentPane.add(inst);
		inst.setColumns(10);
		
		phn = new JTextField();
		phn.setForeground(new Color(25, 25, 112));
		phn.setFont(new Font("Consolas", Font.BOLD, 18));
		phn.setBounds(335, 272, 368, 72);
		contentPane.add(phn);
		phn.setColumns(10);
		
		em = new JTextField();
		em.setForeground(new Color(25, 25, 112));
		em.setFont(new Font("Consolas", Font.BOLD, 18));
		em.setBounds(335, 355, 368, 72);
		contentPane.add(em);
		em.setColumns(10);
		
		id = new JTextField();
		id.setForeground(new Color(25, 25, 112));
		id.setFont(new Font("Consolas", Font.BOLD, 18));
		id.setBounds(335, 438, 191, 72);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblName = new JLabel("  Name");
		lblName.setIcon(new ImageIcon("Icons\\name_64px.png"));
		lblName.setForeground(new Color(95, 158, 160));
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblName.setBounds(94, 106, 231, 72);
		contentPane.add(lblName);
		
		JLabel lblInstitute = new JLabel("  Institute");
		lblInstitute.setIcon(new ImageIcon("Icons\\student_center_64px.png"));
		lblInstitute.setForeground(new Color(95, 158, 160));
		lblInstitute.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblInstitute.setBounds(94, 189, 231, 72);
		contentPane.add(lblInstitute);
		
		JLabel lblPhoneNumber = new JLabel("  Phone number");
		lblPhoneNumber.setIcon(new ImageIcon("Icons\\phone_48px.png"));
		lblPhoneNumber.setForeground(new Color(95, 158, 160));
		lblPhoneNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblPhoneNumber.setBounds(94, 272, 231, 72);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEMail = new JLabel("  E - mail");
		lblEMail.setIcon(new ImageIcon("Icons\\email_64px.png"));
		lblEMail.setForeground(new Color(95, 158, 160));
		lblEMail.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblEMail.setBounds(94, 355, 231, 72);
		contentPane.add(lblEMail);
		
		JLabel lblMemberId = new JLabel("  Member ID");
		lblMemberId.setIcon(new ImageIcon("Icons\\id_card_64px.png"));
		lblMemberId.setForeground(new Color(95, 158, 160));
		lblMemberId.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblMemberId.setBounds(94, 433, 231, 72);
		contentPane.add(lblMemberId);
		
		JButton btnGenarate = new JButton("Genarate");
		btnGenarate.setContentAreaFilled(false);
		btnGenarate.setBorderPainted(false);
		btnGenarate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection x;
				Statement y;
				ResultSet z;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					x = DriverManager.getConnection(
							"jdbc:mysql://db4free.net:3306/ytosko_1",
							"ytosko_1", "Psycho1990");
                   String sql = ("SELECT MAX(ID) FROM `member`");
                   
                   y = x.createStatement();

					z = y.executeQuery(sql);
					if (z.next()) {
						int ab = z.getInt(1) + 1;
						id.setText(""+ab);
						x.close();
						y.close();

					} else {
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
		btnGenarate.setRolloverEnabled(false);
		btnGenarate.setRequestFocusEnabled(false);
		btnGenarate.setBorder(null);
		btnGenarate.setIcon(new ImageIcon("Icons\\product_64px.png"));
		btnGenarate.setBackground(Color.WHITE);
		btnGenarate.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		btnGenarate.setForeground(new Color(178, 34, 34));
		btnGenarate.setBounds(529, 438, 191, 72);
		contentPane.add(btnGenarate);
		
		JButton btnAddMember = new JButton("Add member");
		btnAddMember.setContentAreaFilled(false);
		btnAddMember.setBorderPainted(false);
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String code = name1.getText().toString().trim();
				String name = inst.getText().toString().trim();
				String writer = phn.getText().toString().trim();
				String ver = em.getText().toString().trim();
				String m = id.getText().toString().trim();
				
				if(code.equals("") || name.equals("") || writer.equals("") || ver.equals("")){
					alert.setText("Fill all the informations!");
				}
				else{
					alert.setText("");
					Connection x;
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						x = DriverManager.getConnection(
								"jdbc:mysql://db4free.net:3306/ytosko_1",
								"ytosko_1", "Psycho1990");
                       String sql = ("INSERT INTO `member`(name	,inst	,phn	,mail	,id)" + "VALUES (?,?,?,?,?)");
                       
                       PreparedStatement y = x.prepareStatement(sql);
                       y.setString(1, code);
                       y.setString(2, name);
                       y.setString(3, writer);
                       y.setString(4, ver);
                       y.setString(5, m);
                       y.executeUpdate(); 
                       
                        x.close();
                        y.close();
                        alert.setText("You are now in database!");
					} catch (Exception e) {
						System.out.println("Error here!");
					}
				}
			}
		});
		btnAddMember.setBorder(null);
		btnAddMember.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
		btnAddMember.setBackground(Color.WHITE);
		btnAddMember.setForeground(Color.DARK_GRAY);
		btnAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		btnAddMember.setHideActionText(true);
		btnAddMember.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddMember.setIcon(new ImageIcon("Icons\\add_96px.png"));
		btnAddMember.setRequestFocusEnabled(false);
		btnAddMember.setRolloverEnabled(false);
		btnAddMember.setBounds(743, 272, 217, 130);
		btnAddMember.setVerticalTextPosition( SwingConstants.BOTTOM ) ;
		btnAddMember.setHorizontalTextPosition( SwingConstants.CENTER ) ;
		contentPane.add(btnAddMember);
		JButton btnNewButton = new JButton("Back to Hompage");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
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
		btnNewButton.setBounds(53, 536, 283, 65);
		contentPane.add(btnNewButton);
		alert = new JLabel("");
		alert.setForeground(new Color(47, 79, 79));
		alert.setHorizontalAlignment(SwingConstants.CENTER);
		alert.setFont(new Font("Consolas", Font.BOLD, 20));
		alert.setBounds(30, 11, 858, 59);
		contentPane.add(alert);
	}
}
