//Assignment02
//Rocco Piccirillo
//SelectionSort
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class SelectionSort {

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
	
	//created a method to take in the magicItems List
	public static ArrayList<String> sort(ArrayList<String> A)
	{
		//created an int to store number of swaps
		int numSwap = 0;
		
		//loops over the arrayList
		for(int i = 0; i < A.size()-1; i++)
		{
			numSwap++;
			//sets smallPos as i or the initial index 
			int smallPos = i;
			
			//loop over each string in the arrayList
			for(int j = i+1; j < A.size(); j++)
			{
				numSwap++;
				//compare to returns a positive num or negative num
				//if j is less than smallPos, a negative number prints
				//if j is greater than smallPos, a positive number prints
				//so if the result is negative, it is less than 0 so we swap
				if(A.get(j).compareTo(A.get(smallPos)) < 0)
				{
					//the small position gets swapped with j
					smallPos = j;
					
					//the amount of swaps increases as well
					numSwap++;
				}
			}
			//the temp string is the smallest position
			String temp = A.get(smallPos);
			
			//the smallest position of magicItems gets set to i
			A.set(smallPos, A.get(i));
			
			//and then i gets set to temp
			A.set(i, temp);
			
		}
		
		System.out.println(numSwap);
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


