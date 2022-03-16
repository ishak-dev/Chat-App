package chatApp.forms;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Cursor;
import com.toedter.calendar.JDateChooser;

import chatApp.UserRegister;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class registerframe {

	private JFrame registerframe;
	private JTextField firstNtext;
	private JTextField lastNtext;
	private JTextField emailText;
	private JTextField phoneText;
	private JTextField usernameText;
	private JPasswordField passText;
	private JPasswordField confirmpassText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerframe window = new registerframe();
					window.registerframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registerframe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		registerframe = new JFrame();
		registerframe.setUndecorated(true);
		registerframe.setBounds(100, 100, 400, 738);
		Image img = new ImageIcon(this.getClass().getResource("/logom.png")).getImage();
		registerframe.setIconImage(img);
		registerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerframe.setLocationRelativeTo(null);
		
		JPanel registerpanel = new JPanel();
		registerpanel.setBackground(new Color(0, 51, 102));
		registerframe.getContentPane().add(registerpanel, BorderLayout.CENTER);
		registerpanel.setLayout(null);
		
		JLabel closelab = new JLabel("");
		closelab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closelab.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				registerframe.dispose();
			}
		});
		closelab.setBounds(370, 11, 20, 20);
		Image imgclose = new ImageIcon(this.getClass().getResource("/closeicon.png")).getImage();
		closelab.setIcon(new ImageIcon(imgclose));
		registerpanel.add(closelab);
		
		JLabel logolab = new JLabel("");
		logolab.setBounds(94, 21, 199, 182);
		logolab.setIcon(new ImageIcon(img));
		registerpanel.add(logolab);
		
		JLabel registerlab = new JLabel("Welcome to ChatTalk!");
		registerlab.setForeground(Color.WHITE);
		registerlab.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		registerlab.setBounds(80, 211, 226, 27);
		registerpanel.add(registerlab);
		
		JLabel firstNlab = new JLabel("First name:");
		firstNlab.setForeground(Color.WHITE);
		firstNlab.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		firstNlab.setBounds(40, 262, 75, 14);
		registerpanel.add(firstNlab);
		
		firstNtext = new JTextField();
		firstNtext.setBounds(149, 258, 199, 20);
		registerpanel.add(firstNtext);
		firstNtext.setColumns(10);
		
		JLabel lastNlab = new JLabel("Last name:");
		lastNlab.setForeground(Color.WHITE);
		lastNlab.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lastNlab.setBounds(40, 298, 75, 14);
		registerpanel.add(lastNlab);
		
		lastNtext = new JTextField();
		lastNtext.setColumns(10);
		lastNtext.setBounds(149, 294, 199, 20);
		registerpanel.add(lastNtext);
		
		JLabel DOBlab = new JLabel("Date of birth:");
		DOBlab.setForeground(Color.WHITE);
		DOBlab.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		DOBlab.setBounds(40, 334, 83, 14);
		registerpanel.add(DOBlab);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser.setBounds(149, 330, 199, 20);
		dateChooser.setDateFormatString("M.dd.yyyy.");
		registerpanel.add(dateChooser);
		
		JLabel emailLab = new JLabel("E-mail:");
		emailLab.setForeground(Color.WHITE);
		emailLab.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		emailLab.setBounds(40, 370, 83, 14);
		registerpanel.add(emailLab);
		
		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(149, 366, 199, 20);
		registerpanel.add(emailText);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(40, 406, 98, 14);
		registerpanel.add(lblPhoneNumber);
		
		phoneText = new JTextField();
		phoneText.setColumns(10);
		phoneText.setBounds(149, 402, 199, 20);
		registerpanel.add(phoneText);
		
		JLabel usernamelab = new JLabel("Username:");
		usernamelab.setForeground(Color.WHITE);
		usernamelab.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		usernamelab.setBounds(40, 470, 75, 14);
		registerpanel.add(usernamelab);
		
		usernameText = new JTextField();
		usernameText.setColumns(10);
		usernameText.setBounds(169, 466, 179, 20);
		registerpanel.add(usernameText);
		
		JLabel passLab = new JLabel("Password:");
		passLab.setForeground(Color.WHITE);
		passLab.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		passLab.setBounds(40, 506, 75, 14);
		registerpanel.add(passLab);
		
		passText = new JPasswordField();
		passText.setBounds(169, 502, 179, 20);
		registerpanel.add(passText);
		
		JLabel confirmLab = new JLabel("Confirm password:");
		confirmLab.setForeground(Color.WHITE);
		confirmLab.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		confirmLab.setBounds(40, 542, 120, 14);
		registerpanel.add(confirmLab);
		
		confirmpassText = new JPasswordField();
		confirmpassText.setBounds(169, 538, 179, 20);
		registerpanel.add(confirmpassText);
		
		JLabel showpasslab = new JLabel("Show password");
		showpasslab.setForeground(Color.WHITE);
		showpasslab.setName("passlab");
		showpasslab.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		showpasslab.setBounds(220, 569, 109, 18);
		registerpanel.add(showpasslab);
		
		JCheckBox showpasscheck = new JCheckBox("");
		showpasscheck.setBackground(new Color(0, 51, 102));
		showpasscheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showpasscheck.isSelected()) {
					passText.setEchoChar((char)0);
					confirmpassText.setEchoChar((char)0);
				}
				else {
					passText.setEchoChar('●');
					confirmpassText.setEchoChar('●');
				}		
			}
		});
		
		showpasscheck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showpasscheck.setBounds(327, 565, 21, 23);
		registerpanel.add(showpasscheck);
		
		JButton registerbutton = new JButton("Register");
		
		registerbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		registerbutton.setForeground(Color.BLACK);
		registerbutton.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		registerbutton.setBorderPainted(false);
		registerbutton.setBorder(null);
		registerbutton.setBackground(Color.YELLOW);
		registerbutton.setBounds(104, 598, 189, 37);
		registerpanel.add(registerbutton);
		registerframe.getRootPane().setDefaultButton(registerbutton);
		
		//register button connection with UserRegister class
		registerbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				if((!firstNtext.getText().equals("")) && (!lastNtext.getText().equals("")) && (dateChooser.getDate()!=null) && (!emailText.getText().equals(""))
						&& (!usernameText.getText().equals("")) && (!passText.getText().equals("")) && (!confirmpassText.getText().equals(""))) {
					
					String pattern = "M.dd.yyyy";
					DateFormat df = new SimpleDateFormat(pattern);
					String userDOB = df.format(dateChooser.getDate());
					
					UserRegister userReg = new UserRegister(firstNtext.getText(),lastNtext.getText(),userDOB,emailText.getText(),phoneText.getText(),
							usernameText.getText(),passText.getText(),confirmpassText.getText());
					
					boolean check = userReg.checkUsers();
					if(check==false) {
						
						check = userReg.checkEmails();
						
						if(check==false) {
							
							if(passText.getText().length()>=8) {
								
								if(userReg.checkPassword()){
									userReg.createFile();
									userReg.addUser();
									
									JOptionPane.showMessageDialog(null, "You've successfully registered!", "Success", JOptionPane.DEFAULT_OPTION);
									
									registerframe.dispose();
									loginframe log = new loginframe();
									log.main(null);
									}
								else {
									JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
									passText.setText("");
									confirmpassText.setText("");
									}
								}
							else {
								JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
								passText.setText("");
								confirmpassText.setText("");
								}
							}
						else {
							JOptionPane.showMessageDialog(null, "That e-mail address is already taken.", "Error", JOptionPane.ERROR_MESSAGE);
							emailText.setText("");
							}
						}
					else {
						JOptionPane.showMessageDialog(null, "That Username is already taken.", "Error", JOptionPane.ERROR_MESSAGE);
						usernameText.setText("");
						}
					}
				else JOptionPane.showMessageDialog(null, "Some fields are still empty!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			});
		
		JLabel msglab = new JLabel("Already have an account?");
		msglab.setForeground(Color.WHITE);
		msglab.setName("welcomelab");
		msglab.setHorizontalAlignment(SwingConstants.CENTER);
		msglab.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		msglab.setBounds(113, 660, 174, 27);
		registerpanel.add(msglab);
		
		JLabel backtologin = new JLabel("Back to login");
		backtologin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				registerframe.dispose();
				loginframe login = new loginframe();
				login.main(null);
			}
		});
		backtologin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backtologin.setName("welcomelab");
		backtologin.setHorizontalTextPosition(SwingConstants.CENTER);
		backtologin.setHorizontalAlignment(SwingConstants.CENTER);
		backtologin.setForeground(Color.YELLOW);
		backtologin.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		backtologin.setBounds(149, 685, 106, 27);
		registerpanel.add(backtologin);
		
	}
}