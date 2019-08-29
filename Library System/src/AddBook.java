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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class AddBook extends JFrame {

	private JPanel contentPane;
	private JButton exit2;
	int posX=0,posY=0;
	private JTextField bookcode;
	private JTextField bookname;
	private JTextField Author;
	private JLabel alert;
	private JTextField Edition;
	private JLabel lblEdition;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook() {
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
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(210, 105, 30)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		exit2 = new JButton("");
		exit2.setFocusPainted(false);
		exit2.setFocusTraversalKeysEnabled(false);
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
		
		bookcode = new JTextField();
		bookcode.setForeground(new Color(128, 0, 0));
		bookcode.setFont(new Font("Consolas", Font.BOLD, 15));
		bookcode.setBounds(354, 143, 395, 63);
		contentPane.add(bookcode);
		bookcode.setColumns(10);
		
		JLabel lblAddBook = new JLabel("Add book to database");
		lblAddBook.setForeground(new Color(85, 107, 47));
		lblAddBook.setFont(new Font("Kristen ITC", Font.BOLD, 30));
		lblAddBook.setBounds(309, 26, 400, 63);
		contentPane.add(lblAddBook);
		
		JLabel lblBookCode = new JLabel("Book code ");
		lblBookCode.setForeground(new Color(0, 128, 0));
		lblBookCode.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblBookCode.setIcon(new ImageIcon("Icons\\icons8-ground-symbol-50.png"));
		lblBookCode.setBounds(128, 140, 216, 63);
		contentPane.add(lblBookCode);
		
		bookname = new JTextField();
		bookname.setForeground(new Color(128, 0, 0));
		bookname.setFont(new Font("Consolas", Font.BOLD, 15));
		bookname.setBounds(354, 217, 395, 63);
		contentPane.add(bookname);
		bookname.setColumns(10);
		
		JLabel lblBookName = new JLabel("Book name ");
		lblBookName.setForeground(new Color(153, 50, 204));
		lblBookName.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 15));
		lblBookName.setIcon(new ImageIcon("Icons\\icons8-literature-64.png"));
		lblBookName.setBounds(128, 214, 206, 63);
		contentPane.add(lblBookName);
		
		Author = new JTextField();
		Author.setForeground(new Color(128, 0, 0));
		Author.setFont(new Font("Consolas", Font.BOLD, 15));
		Author.setBounds(354, 291, 395, 63);
		contentPane.add(Author);
		Author.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setForeground(new Color(0, 0, 139));
		lblAuthor.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		lblAuthor.setIcon(new ImageIcon("Icons\\name.png"));
		lblAuthor.setBounds(128, 288, 216, 63);
		contentPane.add(lblAuthor);
		
		JButton add = new JButton("Add book");
		add.setBorderPainted(false);
		add.setContentAreaFilled(false);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String code = bookcode.getText().toString().trim();
				String name = bookname.getText().toString().trim();
				String writer = Author.getText().toString().trim();
				String ver = Edition.getText().toString().trim();
				
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
                       String sql = ("INSERT INTO `Book_List`(code,name,author,edition,status)" + "VALUES (?,?,?,?,?)");
                       
                       PreparedStatement y = x.prepareStatement(sql);
                       y.setString(1, code);
                       y.setString(2, name);
                       y.setString(3, writer);
                       y.setString(4, ver);
                       y.setString(5, "yes");
                       y.executeUpdate(); 
                       
                        x.close();
                        y.close();
                        alert.setText("The book is now in database!");
					} catch (Exception e) {
						System.out.println("Error here!");
					}
				}
			}
		});
		add.setBorder(null);
		add.setRolloverEnabled(false);
		add.setRequestFocusEnabled(false);
		add.setBackground(SystemColor.text);
		add.setForeground(new Color(0, 0, 128));
		add.setFont(new Font("Consolas", Font.BOLD, 20));
		add.setIcon(new ImageIcon("Icons\\icons8-add-book-96.png"));
		add.setBounds(629, 461, 154, 133);
		add.setVerticalTextPosition( SwingConstants.BOTTOM ) ;
		add.setVerticalAlignment( SwingConstants.TOP ) ;
		add.setHorizontalTextPosition( SwingConstants.CENTER ) ;
		contentPane.add(add);
		
		alert = new JLabel("");
		alert.setIgnoreRepaint(true);
		alert.setForeground(new Color(47, 79, 79));
		alert.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		alert.setBounds(119, 501, 473, 63);
		contentPane.add(alert);
		
		Edition = new JTextField();
		Edition.setForeground(new Color(128, 0, 0));
		Edition.setFont(new Font("Consolas", Font.BOLD, 15));
		Edition.setBounds(354, 365, 395, 63);
		contentPane.add(Edition);
		Edition.setColumns(10);
		
		lblEdition = new JLabel("  Edition");
		lblEdition.setIcon(new ImageIcon("Icons\\icons8-versions-50.png"));
		lblEdition.setForeground(new Color(255, 69, 0));
		lblEdition.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		lblEdition.setBounds(128, 365, 216, 63);
		contentPane.add(lblEdition);
		
		
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
		btnNewButton.setBounds(20, 575, 283, 65);
		contentPane.add(btnNewButton);
		
	
	}
}
