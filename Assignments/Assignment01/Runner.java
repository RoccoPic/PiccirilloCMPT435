//Assignment01
//Rocco Piccirillo
//Runner

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Runner 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		//the scanner is storing the magicitems.txt file temporarily
		Scanner scanner = new Scanner(new File("magicitems"));
		//made to actually store the magic items
		ArrayList<String> wordList = new ArrayList<String>();
		
		//while there is still another line of text more keeps getting added
		while(scanner.hasNextLine()) 
		{
			wordList.add(scanner.nextLine());
		}
		
		//upper transforms all of the characters into upperCase
		UnaryOperator<String> upper = (x) -> x.toUpperCase();
		//noSpaces removes all of the spaces from wordList
		UnaryOperator<String> noSpaces = (x) -> x.replace(" ", "");
		wordList.replaceAll(upper);
		wordList.replaceAll(noSpaces);
		
		
		//not the most creative names but this is so I don't misplace anything
		Stack stack = new Stack();
		Queue queue = new Queue();
		
		//made for my printouts
		String pally;
        // loop over arrayList
        for (int i = 0; i < wordList.size(); i++)
        {
            pally = " is a palindrome";
            // Loop over each string in arrayList
            for(int j = 0; j < wordList.get(i).length(); j++)
            {
                // filling the stack and queue
                stack.push(wordList.get(i).charAt(j));
                queue.enQueue(wordList.get(i).charAt(j));
            }

            int stackSize = wordList.get(i).length();
            // looping over the stack and queue to do the check
            for (int z = 0; z < stackSize; z++)
            {
                // if any of the chars don't match, it is NOT a palindrome
                // this is simultaneously checking and removing from our stack and queue
                if (stack.pop().data != (queue.deQueue().data))
                {
                    pally = " is not a palindrome";
                }
            }
            // pally is only set to not a palindrome if we find inequalities, otherwise, we found no issues and the default string is good 
            System.out.println(wordList.get(i) + pally);

        }
	}
}



	

