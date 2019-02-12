import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("magicitems"));
		ArrayList<String> wordList = new ArrayList<String>();
		
		while(scanner.hasNextLine()) 
		{
			wordList.add(scanner.nextLine());
		}
		
		//wordList.get(1).toCharArray();
		Stack stack = new Stack();
		Queue queue = new Queue();
		
		for (int i = 0; i < wordList.size(); i++){
		 
		     for(int j = 0; j < wordList.get(i).length(); j++)
		     {
		    	 
		    	 stack.push(wordList.get(i).charAt(j));
		    	 queue.enQueue(wordList.get(i).charAt(j));
		    	
		    	 queue.show();
		    	//System.out.println(wordList.get(i).charAt(j));
		     }
		 }
		
		//for (int i = 0; i < wordList.size(); i++) {
		//     System.out.println(wordList.get(i) + " ");
		// }
		
		
		
		/*for(int i = 0; i < wordList.size(); i++)
		{
			
		}*/
	
		

	
		
	}
}
