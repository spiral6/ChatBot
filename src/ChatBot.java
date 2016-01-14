import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatBot {

	static File profile;
	
	public ChatBot(String name) throws FileNotFoundException{
		profile = loadFile(name);
		intro();
	}
	
	public File loadFile(String s){
		File profilesFolder = new File("/profiles");
		File[] files = profilesFolder.listFiles();
		for(int i = 0; i < files.length; i++){
			if(files[i].getName().equals(s + ".txt")){
				return files[i];
			}
		}
		return null;
		
	}
	
	public void MessageHandler(ArrayList<String> arr) throws FileNotFoundException{
		for(int i = 0; i < arr.size(); i++){
			String query = arr.get(i);
			//query = aliases(query);
			
			
			switch(query){
				case "Hello": intro(); break;
				case "info": String subject = arr.get(i+1); info(subject); break;
				default: unrecognized();
			}
		}
	}
	
	public String aliases(String s){
		//for now, return null. 
		//Future implementation will use the file to look for aliases.
		return null;
	}
	
	public void intro() throws FileNotFoundException{
		System.out.println(loadDialogue(profile, "%intro"));
	}
	
	public void unrecognized() throws FileNotFoundException{
		System.out.println(loadDialogue(profile, "%unrecognized"));
	}
	
	public void info(String subject) throws FileNotFoundException{
		String info = loadDialogue(profile, "%info");
		System.out.println(loadDialogue(info, subject));
	}
	
	public String loadDialogue(File f, String code) throws FileNotFoundException{
		Scanner kb = new Scanner(f);
		
		String dialogue = "";
		while(kb.hasNextLine()){
			String line = kb.nextLine();
			if(line.equals(code)){
				break;
			}
		}
		
		while(kb.hasNextLine()){
			String line = kb.nextLine();
			if(line.equals(code)){
				break;
			}
			else{
				dialogue += line + "\n";
			}
		}
		
		kb.close();
		return dialogue;
		
	}
	
	public String loadDialogue(String info, String subject){
		Scanner finder = new Scanner(info);
		String dialogue = "";
		while(finder.hasNextLine()){
			String line = finder.nextLine();
			if(line.equals(subject)){
				break;
			}
		}
		
		while(finder.hasNextLine()){
			String line = finder.nextLine();
			if(line.equals(subject)){
				break;
			}
			else{
				dialogue += line + "\n";
			}
		}
		
		finder.close();
		return dialogue;
	}

}
