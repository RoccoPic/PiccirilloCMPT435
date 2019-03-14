//Assignment02
//Rocco Piccirillo
//MergeSort
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class MergeSort {
	public static int compare = 0;
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
			
			wordList = mergeSort(wordList);
			printArray(wordList);
			System.out.print(compare + " is the number of comparisons");
}
	
	public static ArrayList<String> mergeSort(ArrayList<String> A)
	{
		//if the size of the given array is less than 1
		//we just return 
		if(A.size() <= 1)
		{
			return A;
		}
		
		//first we get the midpoint of the array
		int midpoint = A.size() / 2;
		//creating a subarray called left or the left half
		ArrayList<String> left = new ArrayList<String>();
		//and another sub array for the rightmost half
		ArrayList<String> right = new ArrayList<String>();
		//the last array which will be the product of
		//the merged left and right array
		ArrayList<String> result = new ArrayList<String>();
		
		//we are going to traverse from 0 to midpoint
		//and add until we reach there
		for(int i = 0; i < midpoint; i++)
		{
			left.add(A.get(i));	
		}
		
		//we are going to start at midpoint
		//and add until we reach the end of the arrayList
		for(int j = midpoint; j < A.size(); j++)
		{
			right.add((A.get(j)));
		}
		
		//we are going to call the method again to 
		//split even further until reduced to multiple
		//arrays of 1 and 1 and 1
		//the right is going through the same thing
		left = mergeSort(left);
		right = mergeSort(right);
		
		//once finished divided into singled out elements
		//we are going to merge
		result = merge(left, right);
		
		//System.out.println(numSwap + " number of comparisons.");
		return result;
	}
	
	public static ArrayList<String> merge(ArrayList<String> left, ArrayList<String> right)
	{
	
		//this is the merged arrayList containing the elements
		//of both the arrays
		ArrayList<String> result = new ArrayList<String>();
		//created indexes for both to start at
		int indexL = 0;
		int indexR = 0;
		
		//while elements are still in the left or in the right
		while(indexL < left.size() || indexR < right.size())
		{
			compare++;
			//if the left AND the right still have elements
			//they need to be merged in the right order
			if(indexL < left.size() && indexR < right.size())
			{
				compare++;
				//depending on which is larger we need to know
				//which to add first
				//if the left is smaller than the right
				if(left.get(indexL).compareTo(right.get(indexR)) < 0)
						{
							compare++;
							//we add left first if it is smaller
							result.add(left.get(indexL));
							//we need to also update the index 
							indexL++;	
						}
				//if the right is bigger, we add the right after
				else //if (right.get(indexR).compareTo(left.get(indexL)) > 0)	
				{
					compare++;
					result.add(right.get(indexR));
					indexR++;
				}
			}
			//if there are still elements in the left
			//but not the right
			else if (indexL < left.size())
			{
				compare++;
				result.add(left.get(indexL));
				indexL++;
			//or, if the left is the empty but the right isn't
			//the right needs to be added
			} else if (indexR < right.size())
			{
				compare++;
				result.add(right.get(indexR));
				indexR++;	
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
