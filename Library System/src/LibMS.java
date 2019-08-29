import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Component;


public class LibMS extends JFrame {

	private JPanel contentPane;
	int posX=0,posY=0;
	private JButton exit2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibMS frame = new LibMS();
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
	public LibMS() {
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
		exit2.setBorder(null);
		exit2.setBackground(Color.WHITE);
		exit2.setBounds(898, 11, 87, 78);
		contentPane.add(exit2);
		
		JButton btnNewButton = new JButton("  Add book");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBook on = new AddBook();
				on.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setRolloverEnabled(false);
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setIcon(new ImageIcon("Icons\\icons8-add-book-96.png"));
		btnNewButton.setBounds(57, 72, 278, 104);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("  Add member");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				member a = new member();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setRequestFocusEnabled(false);
		btnNewButton_1.setRolloverEnabled(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(new Color(255, 69, 0));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon("Icons\\icons8-add-user-group-woman-man-96.png"));
		btnNewButton_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(57, 200, 278, 124);
		contentPane.add(btnNewButton_1);
		
		JButton btnSearchBook = new JButton("Search book");
		btnSearchBook.setBorderPainted(false);
		btnSearchBook.setContentAreaFilled(false);
		btnSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search on = new Search();
				on.setVisible(true);
				dispose();
			}
		});
		btnSearchBook.setRequestFocusEnabled(false);
		btnSearchBook.setRolloverEnabled(false);
		btnSearchBook.setVerticalAlignment(SwingConstants.TOP);
		btnSearchBook.setBorder(null);
		btnSearchBook.setBackground(Color.WHITE);
		btnSearchBook.setForeground(Color.RED);
		btnSearchBook.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
		btnSearchBook.setIcon(new ImageIcon("Icons\\icons8-google-web-search-96.png"));
		btnSearchBook.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearchBook.setBounds(52, 350, 283, 97);
		contentPane.add(btnSearchBook);
		
		JButton issue = new JButton("Issue book");
		issue.setContentAreaFilled(false);
		issue.setBorderPainted(false);
		issue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				issue on = new issue();
				on.setVisible(true);
				dispose();
			}
		});
		issue.setRolloverEnabled(false);
		issue.setRequestFocusEnabled(false);
		issue.setFocusTraversalKeysEnabled(false);
		issue.setFocusPainted(false);
		issue.setBorder(null);
		issue.setBackground(new Color(255, 255, 255));
		issue.setAutoscrolls(true);
		issue.setAlignmentX(Component.CENTER_ALIGNMENT);
		issue.setForeground(new Color(72, 61, 139));
		issue.setFont(new Font("Lucida Console", Font.BOLD, 20));
		issue.setIcon(new ImageIcon("Icons\\icons8-book-128.png"));
		issue.setBounds(506, 72, 288, 161);
		issue.setVerticalTextPosition( SwingConstants.BOTTOM ) ;
		issue.setVerticalAlignment( SwingConstants.TOP ) ;
		issue.setHorizontalTextPosition( SwingConstants.CENTER ) ;
		contentPane.add(issue);
		
		JButton rtn = new JButton("Return book");
		rtn.setContentAreaFilled(false);
		rtn.setBorderPainted(false);
		rtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				return1 i = new return1();
				i.setVisible(true);
				dispose();
			}
		});
		rtn.setInheritsPopupMenu(true);
		rtn.setIgnoreRepaint(true);
		rtn.setHideActionText(true);
		rtn.setFocusTraversalPolicyProvider(true);
		rtn.setFocusCycleRoot(true);
		rtn.setDoubleBuffered(true);
		rtn.setBorder(null);
		rtn.setForeground(new Color(0, 128, 128));
		rtn.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		rtn.setBackground(new Color(255, 255, 255));
		rtn.setAutoscrolls(true);
		rtn.setRolloverEnabled(false);
		rtn.setRequestFocusEnabled(false);
		rtn.setIcon(new ImageIcon("Icons\\icons8-return-book-96.png"));
		rtn.setBounds(506, 394, 288, 171);
		rtn.setVerticalTextPosition( SwingConstants.BOTTOM ) ;
		rtn.setHorizontalTextPosition( SwingConstants.CENTER ) ;
		contentPane.add(rtn);
		
		JButton btnDeleteBook = new JButton("  Delete book");
		btnDeleteBook.setContentAreaFilled(false);
		btnDeleteBook.setBorderPainted(false);
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookDel x = new BookDel();
				x.setVisible(true);
				dispose();
			}
		});
		btnDeleteBook.setBackground(new Color(255, 255, 255));
		btnDeleteBook.setBorder(null);
		btnDeleteBook.setRolloverEnabled(false);
		btnDeleteBook.setRequestFocusEnabled(false);
		btnDeleteBook.setForeground(new Color(0, 128, 0));
		btnDeleteBook.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeleteBook.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
		btnDeleteBook.setIcon(new ImageIcon("Icons\\icons8-delete-50.png"));
		btnDeleteBook.setBounds(69, 479, 278, 86);
		contentPane.add(btnDeleteBook);
	}
}
