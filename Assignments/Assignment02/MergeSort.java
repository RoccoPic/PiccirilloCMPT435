import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {
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
			
			wordList = mergeSort(wordList);
			printArray(wordList);
}
	
	public static ArrayList<String> mergeSort(ArrayList<String> array)
	{
		// Recursive control 'if' statement.
				if(array.size() <= 1) {
					
					return array;
					
				}
	
		//setting a mid point for the magicItems List
		int midpoint = array.size() / 2;
		
		//Declaring left and right arrays
		ArrayList<String> left = new ArrayList<String>(midpoint);
		ArrayList<String> right; 
		
		//if the array size is an even number
		//which we know it is
		if(array.size() % 2 == 0)
		{
			
			right = new ArrayList<String>(midpoint);
		 
		} else
		{
			
			right = new ArrayList<String>(midpoint + 1);
			
		}
		
		//this will populate the left array
		for(int i = 0; i < midpoint; i++)
		{
			left.set(i, array.get(i));
		}
		
		//this will populate the right array
		for(int j = 0; j < right.size(); j++)
		{
			right.set(j, array.get(midpoint + j));
		}
		
		ArrayList<String> result = new ArrayList<String>(array.size());
		
		//recursive call for both the left and right arrays
		left = mergeSort(left);
		right = mergeSort(right);
		
		//merges the left and right array together, sorted
		result = merge(left, right);
		
		//returns the sorted and merged array
		return result;
	}
	
	//merges the left and right arrays in an ascending order
	private static ArrayList<String> merge(ArrayList<String> left, ArrayList<String> right)
	{
		//merges the left and right array
		ArrayList<String> result = new ArrayList<String>(left.size() + right.size());
		
		//sets an initialization point for the left and right length
		int leftPointer, rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;
		
		//while the left and right array have elements
		while(leftPointer < left.size() || rightPointer < right.size())
		{

			//checking if the left and right array both have elements
			if(leftPointer < left.size() && rightPointer < right.size())
			{
				//if the left string is lower than the right string
				if(left.get(leftPointer).compareTo(right.get(rightPointer)) < 0)
				{
					
					result.set(resultPointer++, left.get(leftPointer++));
				} else 
				{
					
					result.set(resultPointer++, right.get(rightPointer++));
					
				}
			}
			
			//if there are only elements in the left array, then you 
			//take the elements in the left array and you increment
			//it and the result array
			else if(leftPointer < left.size())
			{
				result.set(resultPointer++, left.get(leftPointer++));
			}
			else if(rightPointer < right.size())
			{
				
					result.set(resultPointer++, right.get(rightPointer++));
				
			}
			
		}
		
		return result;
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
