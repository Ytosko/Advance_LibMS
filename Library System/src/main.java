import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.border.MatteBorder;

import java.awt.Toolkit;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.ComponentOrientation;

import javax.swing.JPanel;

import java.awt.Rectangle;

public class main {

	JFrame frmAdvncedLibraryManagement;
	private JTextField txtPoweredByYtosko;
	private final JPanel panel_1 = new JPanel();
	int posX=0,posY=0;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.frmAdvncedLibraryManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmAdvncedLibraryManagement = new JFrame();
		frmAdvncedLibraryManagement.setBounds(new Rectangle(2, 2, 2, 2));
		frmAdvncedLibraryManagement.setUndecorated(true);
		frmAdvncedLibraryManagement.getContentPane()
				.setFocusTraversalPolicyProvider(true);
		frmAdvncedLibraryManagement.getContentPane().setFocusCycleRoot(true);
		frmAdvncedLibraryManagement.getContentPane().setComponentOrientation(
				ComponentOrientation.LEFT_TO_RIGHT);
		frmAdvncedLibraryManagement.setAlwaysOnTop(false);
		frmAdvncedLibraryManagement.setFocusTraversalPolicyProvider(true);
		frmAdvncedLibraryManagement
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frmAdvncedLibraryManagement.setVisible(true);
		frmAdvncedLibraryManagement.setIgnoreRepaint(true);
		frmAdvncedLibraryManagement
				.setTitle("Advnaced library management system");
		frmAdvncedLibraryManagement.setCursor(Cursor
				.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmAdvncedLibraryManagement.setBackground(new Color(255, 228, 225));
		frmAdvncedLibraryManagement.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\Library system\\Library-icon.png"));
		frmAdvncedLibraryManagement.getContentPane().setBackground(
				SystemColor.text);
		frmAdvncedLibraryManagement.setBounds(100, 100, 995, 665);
		frmAdvncedLibraryManagement
				.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdvncedLibraryManagement.getContentPane().setLayout(null);
		
		frmAdvncedLibraryManagement.addMouseListener(new MouseAdapter()
		{
		   public void mousePressed(MouseEvent e)
		   {
		      posX=e.getX();
		      posY=e.getY();
		   }
		});
		frmAdvncedLibraryManagement.addMouseMotionListener(new MouseAdapter()
		{
		     public void mouseDragged(MouseEvent evt)
		     {
				//sets frame position when mouse dragged			
		    	 frmAdvncedLibraryManagement.setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
							
		     }
		});
		
		JLabel lblLibraryManagementSystem = DefaultComponentFactory
				.getInstance().createTitle("Library Management System");
		lblLibraryManagementSystem.setFont(new Font("Berlin Sans FB Demi",
				Font.BOLD, 18));
		lblLibraryManagementSystem
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibraryManagementSystem.setBackground(SystemColor.text);
		lblLibraryManagementSystem.setForeground(new Color(0, 0, 128));
		lblLibraryManagementSystem.setVerifyInputWhenFocusTarget(false);
		lblLibraryManagementSystem.setOpaque(true);
		lblLibraryManagementSystem.setIgnoreRepaint(true);
		lblLibraryManagementSystem
				.setIcon(new ImageIcon(
						main.class
								.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		lblLibraryManagementSystem.setLabelFor(lblLibraryManagementSystem);
		lblLibraryManagementSystem.setBounds(306, 119, 350, 37);
		frmAdvncedLibraryManagement.getContentPane().add(
				lblLibraryManagementSystem);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(661, 59, -140, 37);
		frmAdvncedLibraryManagement.getContentPane().add(textPane);

		JButton reg = new JButton("New user");
		reg.setContentAreaFilled(false);
		reg.setBorderPainted(false);
		reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regi on = new regi();
				on.setVisible(true);
				frmAdvncedLibraryManagement.dispose();
			}
		});
		reg.setInheritsPopupMenu(true);
		reg.setIgnoreRepaint(true);
		reg.setHideActionText(true);
		reg.setFocusTraversalPolicyProvider(true);
		reg.setFocusCycleRoot(true);
		reg.setDoubleBuffered(true);
		reg.setForeground(new Color(0, 128, 0));
		reg.setFont(new Font("Bauhaus 93", Font.PLAIN, 25));
		reg.setBackground(new Color(255, 255, 153));
		reg.setBounds(596, 276, 177, 62);
		frmAdvncedLibraryManagement.getContentPane().add(reg);

		JButton lgin = new JButton("Log in");
		lgin.setContentAreaFilled(false);
		lgin.setBorderPainted(false);
		lgin.setInheritsPopupMenu(true);
		lgin.setIgnoreRepaint(true);
		lgin.setFocusTraversalPolicyProvider(true);
		lgin.setFocusCycleRoot(true);
		lgin.setDoubleBuffered(true);
		lgin.setAutoscrolls(true);
		lgin.setHorizontalTextPosition(SwingConstants.CENTER);
		lgin.setHideActionText(true);
		lgin.setFont(new Font("Bauhaus 93", Font.BOLD, 25));
		lgin.setForeground(new Color(0, 0, 255));
		lgin.setBackground(new Color(224, 255, 255));
		lgin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAdvncedLibraryManagement.dispose();
				LogIn a = new LogIn();
				a.setVisible(true);
			}
		});
		lgin.setToolTipText("");
		lgin.setBounds(236, 276, 177, 62);
		frmAdvncedLibraryManagement.getContentPane().add(lgin);

		txtPoweredByYtosko = new JTextField();
		txtPoweredByYtosko.setBorder(null);
		txtPoweredByYtosko.setAutoscrolls(false);
		txtPoweredByYtosko.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtPoweredByYtosko.setAlignmentY(Component.TOP_ALIGNMENT);
		txtPoweredByYtosko.setVerifyInputWhenFocusTarget(false);
		txtPoweredByYtosko.setRequestFocusEnabled(false);
		txtPoweredByYtosko.setOpaque(false);
		txtPoweredByYtosko.setMargin(new Insets(0, 0, 0, 0));
		txtPoweredByYtosko.setFocusable(false);
		txtPoweredByYtosko.setFocusTraversalKeysEnabled(false);
		txtPoweredByYtosko.setDisabledTextColor(new Color(0, 100, 0));
		txtPoweredByYtosko.setEditable(false);
		txtPoweredByYtosko.setBackground(Color.WHITE);
		txtPoweredByYtosko.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		txtPoweredByYtosko.setForeground(new Color(0, 51, 51));
		txtPoweredByYtosko.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPoweredByYtosko.setText("Powered by YTOSKO");
		txtPoweredByYtosko.setBounds(690, 617, 295, 37);
		frmAdvncedLibraryManagement.getContentPane().add(txtPoweredByYtosko);
		txtPoweredByYtosko.setColumns(10);

		JButton exit1 = new JButton("");
		exit1.setFocusPainted(false);
		exit1.setContentAreaFilled(false);
		exit1.setBorderPainted(false);
		exit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit1.setBorder(null);
		exit1.setBackground(new Color(255, 255, 255));
		exit1.setIcon(new ImageIcon("Icons\\icons8-shutdown-64.png"));
		exit1.setBounds(898, 11, 87, 78);
		frmAdvncedLibraryManagement.getContentPane().add(exit1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 2, 670);
		frmAdvncedLibraryManagement.getContentPane().add(panel);
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(0, 0, 995, 2);
		frmAdvncedLibraryManagement.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 0, 0));
		panel_2.setBounds(0, 663, 995, 2);
		frmAdvncedLibraryManagement.getContentPane().add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 0, 0));
		panel_3.setBounds(993, 0, 2, 670);
		frmAdvncedLibraryManagement.getContentPane().add(panel_3);
	}
}
