import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


public class Search extends JFrame {

	int posX=0,posY=0;
	private JButton exit2;
	private JTextField src;
	private JLabel inftitle;
	private JButton btnSearch;
	private JPanel contentPane;
	private JTextArea inf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
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
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 255, 0)));
		setContentPane(contentPane);
		
		exit2 = new JButton("");
		exit2.setBounds(898, 11, 87, 78);
		exit2.setRolloverEnabled(false);
		exit2.setFocusPainted(false);
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
		
		src = new JTextField();
		src.setBounds(284, 133, 457, 73);
		src.setForeground(new Color(255, 140, 0));
		src.setFont(new Font("Consolas", Font.BOLD, 25));
		contentPane.add(src);
		src.setColumns(10);
		
		JLabel lblBookCode = new JLabel("  Book code");
		lblBookCode.setBounds(55, 133, 219, 73);
		lblBookCode.setForeground(new Color(25, 25, 112));
		lblBookCode.setFont(new Font("Consolas", Font.BOLD, 20));
		lblBookCode.setIcon(new ImageIcon("Icons\\icons8-literature-64.png"));
		contentPane.add(lblBookCode);
		
		inftitle = new JLabel("Informatios about the book");
		inftitle.setBounds(55, 266, 907, 41);
		inftitle.setForeground(new Color(0, 102, 51));
		inftitle.setFont(new Font("Courier New", Font.BOLD, 20));
		inftitle.setVisible(false);
		contentPane.add(inftitle);
		
		btnSearch = new JButton("  Search");
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorderPainted(false);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String code = src.getText().toString().trim();
				if(code.equals("")){
					inf.setText("Book code can not be empty!");
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
						String sql = "SELECT * FROM `Book_List` WHERE code ='"
								+ code + "'";
						y = x.createStatement();

						z = y.executeQuery(sql);
						if (z.next()) {
							String s = z.getString("name") + System.lineSeparator() + "by " + z.getString("author") + System.lineSeparator() + z.getString("edition") + " Edition/Version" + System.lineSeparator() + "Availablity : " + z.getString("status");
							inf.setText(s);
							inftitle.setVisible(true);
							x.close();
							y.close();

						} else {
							inf.setText("Book not found in database!");
							src.setText("");
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
		btnSearch.setBackground(SystemColor.text);
		btnSearch.setBounds(783, 133, 167, 73);
		btnSearch.setRequestFocusEnabled(false);
		btnSearch.setRolloverEnabled(false);
		btnSearch.setBorder(null);
		btnSearch.setForeground(new Color(51, 51, 102));
		btnSearch.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setIcon(new ImageIcon("Icons\\icons8-search-64.png"));
		contentPane.add(btnSearch);
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
		btnNewButton.setBounds(10, 24, 283, 65);
		contentPane.add(btnNewButton);
		inf = new JTextArea();
		inf.setSelectionColor(new Color(51, 153, 153));
		inf.setLineWrap(true);
		inf.setWrapStyleWord(true);
		inf.setForeground(Color.DARK_GRAY);
		inf.setFont(new Font("Consolas", Font.BOLD, 25));
		inf.setBackground(SystemColor.text);
		inf.setEditable(false);
		inf.setBounds(55, 328, 907, 265);
		contentPane.add(inf);
	}

}
