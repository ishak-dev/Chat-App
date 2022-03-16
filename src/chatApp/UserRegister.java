package chatApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class UserRegister {
	String username = "test123";
	String password = "1234";
	String confirmPassword = "1234";
	String name = "sss";
	String surname = "rrr";
	String DOB = "7.1.2222";
	String email = "test@gmail.com";
	String phoneNumber = "033333311";
	//Unique ID
	String ID = UUID.randomUUID().toString();
    String uniqueID ="";
    
    public UserRegister(String name,String surname, String DOB,String email,String phoneNumber,String username,String password,String confirmPassword){
    	this.username = username;
    	this.password = password;
    	this.confirmPassword = confirmPassword;
    	this.name = name;
    	this.surname = surname;
    	this.DOB = DOB;
    	this.email = email;
    	this.phoneNumber = phoneNumber;
    	
    }
    
    public boolean checkPassword(){
    	if(this.password.equals(this.confirmPassword)){
    		return true;
    	}
    	else return false;
    }
    
	public String uniqueID(){
		for(int i=0;i<8;i++){
			uniqueID +=ID.charAt(i);
		}
		return uniqueID;
	}
	
	public void createFile(){
		
		FileWriter writer = null;
	  try {
		writer = new FileWriter(this.username+".txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("error is in " + e.getMessage());
	}
	
	try {
		writer.write("username \n");
		writer.write(username+"\n");
		writer.write("password \n");
		writer.write(password+"\n");
		writer.write("fullname \n");
		writer.write(name+" "+surname+"\n");
		writer.write("dob \n");
		writer.write(DOB+"\n");
		writer.write("email \n");
		writer.write(email+"\n");
		writer.write("phone \n");
		writer.write(phoneNumber+"\n");
		writer.write(uniqueID()+"\n");
		writer.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("error occurred " + e.getMessage());
	 }
	}
	
	public boolean checkUsers() {
		
		File file = new File("users.txt");
		Scanner reader = null;
		
		try {
			reader =  new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		while(reader.hasNextLine()){
			String line = reader.nextLine();
			if(line.equals(this.username)) {
				return true;
			}
			}
		return false;
		}
	
	public boolean checkEmails() {
		
		File file = new File("user_emails.txt");
		Scanner reader = null;
		
		try {
			reader =  new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		while(reader.hasNextLine()){
			String line = reader.nextLine();
			if(line.equals(this.email)) {
				return true;
			}
			}
		return false;
		}
	
	public void addUser() {
		try {
			FileWriter wr = new FileWriter("users.txt", true);
            wr.write("\n"+this.username);
            wr.close();
            
			wr = new FileWriter("user_emails.txt", true);
            wr.write(this.email+"\n");
            wr.close();
            } 
		catch (IOException e) {
			e.printStackTrace();
			}
		}
	
	}