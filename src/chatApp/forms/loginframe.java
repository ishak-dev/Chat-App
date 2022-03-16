package chatApp.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import chatApp.UserLogin;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Cursor;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginframe {

	private JFrame loginframe;
	private JTextField usertext;
	private JPasswordField passtext;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginframe window = new loginframe();
					window.loginframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public loginframe() {
		loginframe = new JFrame();
		loginframe.setUndecorated(true);
		loginframe.setTitle("ChatTalk");
		Image img = new ImageIcon(this.getClass().getResource("/logom.png")).getImage();
		loginframe.setIconImage(img);
		loginframe.setName("loginwindow");
		loginframe.setBounds(100, 100, 400, 550);
		loginframe.setSize(new Dimension(400, 650));
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 102));
		panel.setName("loginpanel");
		loginframe.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel closelabel = new JLabel("");
		closelabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				loginframe.dispose();
			}
		});
		closelabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgclose = new ImageIcon(this.getClass().getResource("/closeicon.png")).getImage();
		closelabel.setIcon(new ImageIcon(imgclose));
		closelabel.setBounds(370, 11, 20, 20);
		panel.add(closelabel);
		
		JLabel imagelab = new JLabel("");
		imagelab.setHorizontalTextPosition(SwingConstants.CENTER);
		imagelab.setHorizontalAlignment(SwingConstants.CENTER);
		imagelab.setIcon(new ImageIcon(img));

		imagelab.setBounds(94, 61, 199, 182);
		panel.add(imagelab);
		
		JLabel welcomelab = new JLabel("Welcome to ChatTalk!");
		welcomelab.setForeground(new Color(255, 255, 255));
		welcomelab.setName("welcomelab");
		welcomelab.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		welcomelab.setBounds(80, 251, 238, 27);
		panel.add(welcomelab);
		
		JLabel userlab = new JLabel("Username:");
		userlab.setForeground(new Color(255, 255, 255));
		userlab.setBackground(new Color(255, 255, 255));
		userlab.setName("userlab");
		userlab.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		userlab.setBounds(40, 340, 96, 18);
		panel.add(userlab);
		
		usertext = new JTextField();
		usertext.setName("usertext");
		usertext.setBounds(129, 338, 199, 20);
		panel.add(usertext);
		usertext.setColumns(10);
		
		JLabel passlab = new JLabel("Password:");
		passlab.setForeground(new Color(255, 255, 255));
		passlab.setName("passlab");
		passlab.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		passlab.setBounds(40, 400, 96, 18);
		panel.add(passlab);
		
		JLabel showpasslab = new JLabel("Show password");
		showpasslab.setForeground(Color.WHITE);
		showpasslab.setName("passlab");
		showpasslab.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		showpasslab.setBounds(200, 429, 109, 18);
		panel.add(showpasslab);
		
		JCheckBox showpasscheck = new JCheckBox("");
		showpasscheck.setBackground(new Color(0, 51, 102));
		showpasscheck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showpasscheck.setBounds(307, 425, 21, 23);
		panel.add(showpasscheck);
		
		passtext = new JPasswordField();
		passtext.setBounds(129, 398, 199, 20);
		panel.add(passtext);
		
		showpasscheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(showpasscheck.isSelected()) {
					passtext.setEchoChar((char)0);
				}
				else {
					passtext.setEchoChar('●');
				}		
			}
		});
		
		JButton loginbutton = new JButton("Login");
		loginbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginbutton.setBorderPainted(false);
		loginbutton.setBorder(null);
		loginbutton.setBackground(Color.YELLOW);
		loginbutton.setForeground(new Color(0, 0, 0));
		loginbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		loginbutton.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		loginbutton.setBounds(104, 470, 189, 37);
		panel.add(loginbutton);
		loginframe.getRootPane().setDefaultButton(loginbutton);
		
		//Connecting with UserLogin class		
		loginbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String username = usertext.getText();
				String password = passtext.getText();
				if((!username.equals("")) && (!password.equals(""))) {
				UserLogin userLog = new UserLogin(username, password);
				if(userLog.readFile()==true) {
					loginframe.dispose();
					mainGUI main = new mainGUI(username);
					main.main(null, username);
					}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
					usertext.setText("");
					passtext.setText("");
					}
				}
			}
			});
		
		JLabel msglab = new JLabel("Don't have an account?");
		msglab.setForeground(new Color(255, 255, 255));
		msglab.setHorizontalAlignment(SwingConstants.CENTER);
		msglab.setName("welcomelab");
		msglab.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		msglab.setBounds(129, 547, 152, 27);
		panel.add(msglab);
		
		JLabel registerlab = new JLabel("Register");
		registerlab.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				loginframe.dispose();
				registerframe frame = new registerframe();
				frame.main(null);
			}
		});
		
		registerlab.setHorizontalTextPosition(SwingConstants.CENTER);
		registerlab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerlab.setForeground(Color.YELLOW);
		registerlab.setHorizontalAlignment(SwingConstants.CENTER);
		registerlab.setName("welcomelab");
		registerlab.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		registerlab.setBounds(162, 574, 75, 27);
		panel.add(registerlab);
	}
}