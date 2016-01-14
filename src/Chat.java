import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Chat {

	static Scanner kb;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("What persona do you wish to talk to?");
		kb = new Scanner(System.in);
		String persona = kb.next();
		System.out.println("Accessing bot...");
		//kb.close();
		start(persona);

	}
	
	public static void start(String s) throws FileNotFoundException{
		ChatBot bot = new ChatBot(s);
		//Scanner cancer = new Scanner(System.in);
		while(true){
			String input = kb.nextLine();
			if(input.equals("")){
				continue;
			}
			input.toLowerCase();
			String[] temp = input.split("\\s+");
			ArrayList<String> queryString = new ArrayList<String>();
			queryString.addAll(Arrays.asList(temp));
			System.out.println(queryString.toString());
			
			bot.MessageHandler(queryString);
			
		}
	}

}
