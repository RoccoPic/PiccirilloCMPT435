import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class InsertionSort 
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
			
			//sets all strings in wordList to upperCase
			UnaryOperator<String> upper = (x) -> x.toUpperCase();
			wordList.replaceAll(upper);
			
			sort(wordList);
			printArray(wordList);
	}
	public static ArrayList<String> sort(ArrayList<String> A)
	{
		//created an int to store number of swaps
		int numSwap = 0;
		
		//loops over the arrayList
		for(int i = 1; i < A.size(); i++)
		{
			//key is set to the current position of i
			String key = A.get(i);
			
			//j is the point before key
			int j = i-1;
			
			//makes sure that j is in index 0 or greater
			//and that j is > key before initiating this loop
			while(j >= 0 && A.get(j).compareTo(key) > 0 )
			{
				//this then sets the index value of the greater word to +1
				//so that we will be kicked out of the while loop
				A.set(j+1, A.get(j));
				j--;
				
				//increments the swap count
				numSwap++;
			}
			//so since we changed, the key now moves to the next string
			A.set(j+1, key);
		}
		System.out.println(numSwap + " comparisons performed.");
		return A;
	}

	//this makes an easily accessible printing method for the wordList
	public static void printArray(ArrayList<String> wordList)
	{
		for(int i = 0; i < wordList.size(); i++)
		{
			System.out.println(wordList.get(i));
		}
	}
	
}
