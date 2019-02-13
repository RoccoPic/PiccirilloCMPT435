import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("magicitems"));
		ArrayList<String> wordList = new ArrayList<String>();
		
		
		while(scanner.hasNextLine()) 
		{
			
			wordList.add(scanner.nextLine());
		}
		
		
		UnaryOperator<String> upper = (x) -> x.toUpperCase();
		UnaryOperator<String> noSpaces = (x) -> x.replace(" ", "");
		wordList.replaceAll(upper);
		wordList.replaceAll(noSpaces);
		
		Stack stack = new Stack();
		Queue queue = new Queue();
		
		
		String pally;
        // loop over arrayList
        for (int i = 0; i < wordList.size(); i++)
        {
            pally = " is a palindrome";
            // Loop over Each string in arrayList
            for(int j = 0; j < wordList.get(i).length(); j++)
            {
                // filling the stack and queue
                stack.push(wordList.get(i).charAt(j));
                queue.enQueue(wordList.get(i).charAt(j));
            }

            int stackSize = wordList.get(i).length();
            // looping over the stack and queue to do the check
            for (int z = 0; z< stackSize; z++)
            {
                // if any of the chars dont match, it is NOT a palindrome
                // this is simultaneously checking and removing from our stack and queue
                if (stack.pop() != (queue.deQueue()))
                {
                    pally = " is not a palindrome";
                }
            }
            // pally is only set to not a palindrome if we find inequalities, otherwise, we found no issues and the default string is good 
            System.out.println(wordList.get(i) + pally);

        }
	}
}



	

