package chatApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LogPerson {
	String username;
	String password;
	Scanner reader = new Scanner(System.in);
	Scanner readerChats;
	
	public LogPerson(String username){
		this.username = username;
	}
		
	//funkcija koja provjerava da li odgovarajuci fajl postoji npr edvin.ishak ili ishak.edvin i rezultat nam vraca jedan od ta dva
	
	public File searchChat(String chatWith){
		// fajl npr edvin.ishak ili ishak.edvin
	    File f1 = new File(this.username + "+" + chatWith+".txt");
	    File f2 = new File(chatWith+ "+" +this.username +".txt" );
	    File chat = null;
	    //Ako fajl postoji onda vraca vrijednost edvin+ishak ukoliko ne postoji vraca null
	    if(f1.exists() && !f1.isDirectory()){
	    	chat=f1;
	    	return chat;
	    }
	    else if(f2.exists()){
	    	chat=f2;
	    	return chat;
	    }
		return chat;
	}

	
	//opcija kada zelimo dodati novu osobu za dopisivanje
    public void startChat(String sNC){
        System.out.println("Mjesto gdje se unosi osoba za chat");
        String startNewChat = sNC;
        //ako vec chat s tom osobom postoji
        if(searchChat(startNewChat)!=null){
            System.out.println("Chat already exist");
        }
        else{
        try {
            //ako chat ne postoji stvaramo novi chat s tom osobom i dodajemo tu osobu na listu svih chatova koje imamo
             FileWriter newChat = new FileWriter(this.username + "+" + startNewChat+".txt");
             FileWriter listOfChats1 = new FileWriter(this.username + "_chats"+".txt",true);
             listOfChats1.write(startNewChat+"\n");
             listOfChats1.close();
             FileWriter listOfChats2 = new FileWriter(startNewChat + "_chats"+".txt",true);
             listOfChats2.write(this.username+"\n");
             listOfChats2.close();
             System.out.println("User added");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
    }


    //ispisujemo listu chatova
    public File showListChats(){
        File listChats = new File(this.username + "_chats"+".txt");
        return listChats;

    }
    
    //pokazujemo chat sa odredjenom osobom
    String toMessage;
    public File showChats(String showChatWith){
        File chat=null;
        if(searchChat(showChatWith).exists()){
            chat = searchChat(showChatWith);
        /*    try {
                readerChats = new Scanner(chat);
                while(readerChats.hasNextLine()){
                    String Line = readerChats.nextLine();
                    System.out.println(Line);
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } */

            toMessage = chat.toString();
            return chat;
        }
        System.out.print(chat);
        return chat;
        //unosimo novu poruku u chat s tom osobom

    }
	
	//Sistem za unosenje poruka
	public void newMessages(String message){
		try {
			FileWriter sendMessage = new FileWriter(toMessage,true);
			sendMessage.write(this.username+":"+"\n");
			sendMessage.write(message+"\n");
			sendMessage.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//SVE SE POKRECE PREKO MAIN.java!!!
	
	
}
