package chatApp.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import chatApp.LogPerson;

import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JMenu;
import java.awt.List;
import java.awt.Dialog.ModalExclusionType;

public class mainGUI {

	private JFrame mainFrame;
	private JTextField messagebox;
	private JTextField newChatText;
	private JLabel fullnamelbl = new JLabel("Full name");
	private JLabel doblbl = new JLabel("Date of Birth");
	private JLabel emaillbl = new JLabel("Email");
	private JLabel phonelbl = new JLabel("Phoneno");

	public static void main(String[] args, String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainGUI window = new mainGUI(username);
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String username;
	LogPerson userLog;
	private JTable table;
	private JTextField textFieldSearch;
	private JButton chatWith;
	private JTextArea listChats;
	private JTextArea textArea;
	private JLabel friendlbl;
	File r =null;
	
	public mainGUI(String username) {
		this.username = username;
		userLog = new LogPerson(this.username);
		mainFrame = new JFrame();
		mainFrame.setUndecorated(true);
		mainFrame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		mainFrame.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				messagebox.setFocusable(false);
				messagebox.setText("Type a message...");
				messagebox.setForeground(Color.gray);
				
				newChatText.setFocusable(false);
				newChatText.setText("New chat");
				newChatText.setForeground(Color.gray);
			}
		});
		
		File user = new File(username+".txt");
		Scanner reader = null;//ovdje ovo za usera
		
		try {
			reader =  new Scanner(user);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(reader.hasNextLine()){
			String line = reader.nextLine();
			if(line.contains("fullname")){
				fullnamelbl.setText(reader.nextLine());
			}
			if(line.contains("dob")){
				doblbl.setText(reader.nextLine());
			}
			if(line.contains("email")){
				emaillbl.setText(reader.nextLine());
			}
			if(line.contains("phone")){
				phonelbl.setText(reader.nextLine());
			}
		}
		
		mainFrame.setBounds(100, 100, 1000, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.getContentPane().setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/logom.png")).getImage();
		mainFrame.setIconImage(img);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(231, 64, 535, 482);
		mainFrame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(231, 0, 769, 64);
		mainFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel closebtn = new JLabel("");
		closebtn.setOpaque(true);
		closebtn.setHorizontalAlignment(SwingConstants.CENTER);
		Image closeimg = new ImageIcon(this.getClass().getResource("/closeimg.png")).getImage();
		closebtn.setIcon(new ImageIcon(closeimg));
		closebtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainFrame.dispose();
			}
			public void mouseEntered(MouseEvent e) {
				closebtn.setBackground(new Color(247, 247, 247));
			}
			public void mouseExited(MouseEvent e) {
				closebtn.setBackground(new Color(240, 240, 240));
			}
		});
		closebtn.setBounds(705, 0, 64, 64);
		panel.add(closebtn);
		
		JLabel minimizebtn = new JLabel("");
		minimizebtn.setOpaque(true);
		minimizebtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainFrame.setState(JFrame.ICONIFIED);
			}
			public void mouseEntered(MouseEvent e) {
				minimizebtn.setBackground(new Color(247, 247, 247));
			}
			public void mouseExited(MouseEvent e) {
				minimizebtn.setBackground(new Color(240, 240, 240));
			}
		});
		minimizebtn.setBackground(new Color(240, 240, 240));
		Image minim = new ImageIcon(this.getClass().getResource("/minimize.png")).getImage();
		minimizebtn.setIcon(new ImageIcon(minim));
		minimizebtn.setBounds(640, 0, 64, 64);
		panel.add(minimizebtn);
		
		JLabel personimg = new JLabel("");
		personimg.setHorizontalAlignment(SwingConstants.CENTER);
		personimg.setOpaque(true);
		personimg.setBackground(SystemColor.menu);
		Image accimg = new ImageIcon(this.getClass().getResource("/personimg.png")).getImage();
		personimg.setIcon(new ImageIcon(accimg));
		personimg.setBounds(0, 0, 64, 64);
		panel.add(personimg);
		
		friendlbl = new JLabel("Username");
		friendlbl.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		friendlbl.setBounds(65, 16, 169, 22);
		panel.add(friendlbl);
		
		JLabel friendphone = new JLabel("Check validity");
		friendphone.setForeground(new Color(153, 51, 0));
		friendphone.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		friendphone.setBounds(65, 35, 169, 22);
		panel.add(friendphone);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(231, 546, 535, 54);
		mainFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		messagebox = new JTextField();
		messagebox.setHorizontalAlignment(SwingConstants.LEFT);
		messagebox.setFocusable(false);
		messagebox.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				messagebox.setText("");
				messagebox.setForeground(Color.black);
			}
			public void mouseEntered(MouseEvent e) {
				messagebox.setFocusable(true);
			}
		});
		messagebox.setBorder(null);
		messagebox.setForeground(Color.GRAY);
		messagebox.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		messagebox.setText("Type a message...");
		messagebox.setBounds(10, 12, 472, 32);
		panel_1.add(messagebox);
		
		JButton sendbtn = new JButton("");
		sendbtn.setForeground(Color.WHITE);
		sendbtn.setBackground(Color.WHITE);
		Image sendimg = new ImageIcon(this.getClass().getResource("/sendimg2.png")).getImage();
		sendbtn.setIcon(new ImageIcon(sendimg));
		mainFrame.getRootPane().setDefaultButton(sendbtn);
		
//		sendbtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(!messagebox.getText().isEmpty()) {
//					textArea.append(username+":\n");
//					textArea.append(messagebox.getText()+"\n");
//					textArea.append("\n");
//					messagebox.setText("");
//				}
//			}
//		});
		//Button za dodavanje poruke
		sendbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userLog.newMessages(messagebox.getText());
				showAllChat();
				messagebox.setText("");
				
//				Timer t = new Timer();
//				t.schedule(new TimerTask(){
//					public void run(){
//					   showAllChat();
//					}
//				}, 0L,500L);
				
			}
		});
		sendbtn.setBounds(483, 0, 52, 54);
		panel_1.add(sendbtn);
		
		JLabel profileicon = new JLabel("");
		profileicon.setHorizontalAlignment(SwingConstants.CENTER);
		profileicon.setBounds(790, 75, 188, 175);
		Image profimg = new ImageIcon(this.getClass().getResource("/profileicon.png")).getImage();
		profileicon.setIcon(new ImageIcon(profimg));
		mainFrame.getContentPane().add(profileicon);
		
		JLabel usernamelbl = new JLabel(username);
		usernamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		usernamelbl.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		usernamelbl.setBounds(770, 304, 227, 22);
		mainFrame.getContentPane().add(usernamelbl);
		
		emaillbl.setHorizontalAlignment(SwingConstants.CENTER);
		emaillbl.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		emaillbl.setBounds(770, 370, 227, 22);
		mainFrame.getContentPane().add(emaillbl);
		
		phonelbl.setHorizontalAlignment(SwingConstants.CENTER);
		phonelbl.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		phonelbl.setBounds(770, 403, 227, 22);
		mainFrame.getContentPane().add(phonelbl);
		
		fullnamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fullnamelbl.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		fullnamelbl.setBounds(770, 271, 227, 22);
		mainFrame.getContentPane().add(fullnamelbl);
		
		doblbl.setHorizontalAlignment(SwingConstants.CENTER);
		doblbl.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		doblbl.setBounds(769, 338, 227, 22);
		mainFrame.getContentPane().add(doblbl);
		
		newChatText = new JTextField();
		newChatText.setFocusable(false);
		newChatText.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				newChatText.setFocusable(true);
				}
			public void mouseClicked(MouseEvent e) {
				newChatText.setText("");
				newChatText.setForeground(Color.black);
			}
		});
		newChatText.setForeground(Color.GRAY);
		newChatText.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		newChatText.setText("New chat");
		newChatText.setBounds(10, 15, 148, 31);
		mainFrame.getContentPane().add(newChatText);
		newChatText.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(163, 19, 62, 23);
		mainFrame.getContentPane().add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 64, 232, 536);
		mainFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(15, 408, 128, 31);
		panel_2.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		chatWith = new JButton("Open");
		chatWith.setBounds(143, 407, 69, 33);
		panel_2.add(chatWith);
		
		JLabel lblNewLabel = new JLabel("Chose Chat ");
		lblNewLabel.setBounds(47, 439, 79, 14);
		panel_2.add(lblNewLabel);
		
		listChats = new JTextArea();
		listChats.setEditable(false);
		listChats.setBounds(15, 24, 197, 375);
		panel_2.add(listChats);
		
        chatWith.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	
            	
                showAllChat();
                File userExist = new File (textFieldSearch.getText() + ".txt");         
               if(userExist.exists()){
            	   friendphone.setText("User registered");
            	   friendphone.setForeground(new Color(0, 102, 0));
               }
               else {
            	   friendphone.setText("User does not exist");
            	   friendphone.setForeground(new Color(153, 51, 0));
               }
            }
        });
				
		//Dodajemo novuosobu za chat
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Dodavanje osobe");
				userLog.startChat(newChatText.getText());
				listChatsArea();
			}
		});
		listChatsArea();
		
		
	}
	
	//list conversations
	public void listChatsArea(){
		 try{
             File listChatsFile =null;
             listChatsFile = userLog.showListChats();
             FileReader readerChatList = new FileReader(listChatsFile);
             BufferedReader br = new BufferedReader(readerChatList);
             listChats.read(br,null);
             br.close();
             listChats.requestFocus();
             }catch (Exception r){
                 System.out.println(r.getMessage());
             }}
	
	//show chat
	public void showAllChat(){
		try{

                r = userLog.showChats(textFieldSearch.getText());
                FileReader readerChat = new FileReader(r);
                BufferedReader br = new BufferedReader(readerChat);
                textArea.read(br,null);
                br.close();
                textArea.requestFocus();
                friendlbl.setText(textFieldSearch.getText());
                }catch (Exception r){
                    System.out.println(r.getMessage());
                }
	}
	
	
}