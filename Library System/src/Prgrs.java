import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

import javax.swing.JDesktopPane;
import javax.swing.BoxLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.SystemColor;

public class Prgrs extends JFrame {

	private JPanel contentPane;
	private static JProgressBar pb;
	private static int progress;
	private static JButton nxt;
	int posX=0,posY=0;
	private JButton exit2_1;
	/**
	 * Launch the application.
	 */
	public static void prgsRun(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
				}

				Timer timer = new Timer(50, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						progress += 1;
						if (progress >= 100) {
							progress = 100;
							((Timer) e.getSource()).stop();
							nxt.setVisible(true);
						}
						pb.setValue(progress);
					}
				});
				timer.start();

			}

		});
	}

	/**
	 * Create the frame.
	 */
	public Prgrs() {
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
		getContentPane().setCursor(
				Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setBackground(Color.WHITE);
		setUndecorated(true);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("Icons\\Library-icon.png"));
		setBounds(100, 100, 995, 665);
		contentPane = new JPanel();
		contentPane.setFocusTraversalPolicyProvider(true);
		contentPane.setIgnoreRepaint(true);
		contentPane.setInheritsPopupMenu(true);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GREEN));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton exit2_1 = new JButton((String) null);
		exit2_1.setRolloverEnabled(false);
		exit2_1.setFocusPainted(false);
		exit2_1.setRequestFocusEnabled(false);
		exit2_1.setContentAreaFilled(false);
		exit2_1.setBorderPainted(false);
		exit2_1.setIcon(new ImageIcon(
				"Icons\\icons8-shutdown-64.png"));
		exit2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit2_1.setBorder(null);
		exit2_1.setBackground(Color.WHITE);
		exit2_1.setBounds(898, 11, 87, 78);
		contentPane.add(exit2_1);

		pb = new JProgressBar();
		pb.setFont(new Font("Tahoma", Font.BOLD, 20));
		pb.setFocusTraversalPolicyProvider(true);
		pb.setFocusCycleRoot(true);
		pb.setDoubleBuffered(true);
		pb.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		pb.setSize(new Dimension(0, 40));
		pb.setOpaque(true);
		pb.setStringPainted(true);
		pb.setBackground(SystemColor.text);
		pb.setForeground(new Color(0, 128, 128));
		pb.setBounds(75, 360, 833, 56);
		contentPane.add(pb);

		JLabel lblLoggingIn = new JLabel("Logging in");
		lblLoggingIn.setForeground(new Color(255, 140, 0));
		lblLoggingIn.setFont(new Font("Kristen ITC", Font.PLAIN, 35));
		lblLoggingIn.setBounds(393, 150, 253, 61);
		contentPane.add(lblLoggingIn);

		JLabel lblPleaseWait = new JLabel("Please wait");
		lblPleaseWait.setForeground(new Color(128, 0, 0));
		lblPleaseWait.setDisplayedMnemonic(KeyEvent.VK_ENTER);
		lblPleaseWait.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lblPleaseWait.setBounds(428, 220, 119, 28);
		contentPane.add(lblPleaseWait);
		
		nxt = new JButton("  Next");
		nxt.setContentAreaFilled(false);
		nxt.setBorderPainted(false);
		nxt.setRolloverEnabled(false);
		nxt.setRequestFocusEnabled(false);
		nxt.setVisible(false);
		nxt.setBorder(null);
		nxt.setBackground(Color.WHITE);
		nxt.setIcon(new ImageIcon("Icons\\icons8-next-page-48.png"));
		nxt.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		nxt.setForeground(Color.BLUE);
		nxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				LibMS frame = new LibMS();
				frame.setVisible(true);
			}
		});
		nxt.setBounds(380, 468, 215, 72);
		contentPane.add(nxt);

	}
}
