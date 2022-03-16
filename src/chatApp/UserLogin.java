package chatApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class UserLogin {
	String username;
	String password;
	
	public UserLogin(String username,String password){
		this.username = username;
		this.password = password;
	}
	
	public boolean readFile(){
		
	File file = new File(username+".txt");
	Scanner reader = null;
	try {
		reader =  new Scanner(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		return false;
	}
	while(reader.hasNextLine()){
		String line = reader.nextLine();
		if(line.contains("password")){
			String passwordFile = reader.nextLine();
			if(passwordFile.equals(this.password)){
			LogPerson Loggeduser = new LogPerson(this.username);
			return true;
			}
			else{
			return false;
			}
		}
	}
	return false;
	}
	
}