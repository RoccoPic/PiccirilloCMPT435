import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Runner {

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
		
		
		
		
		int size = wordList.size();
		
		String []numbers = {"zeta", "hog", "ally", "cob", "boy"};
		
		
		sort(numbers);
		prStringArray(numbers);
		
		
		/*//upper transforms all of the characters Stringo upperCase
		UnaryOperator<String> upper = (x) -> x.toUpperCase();
		//noSpaces removes all of the spaces from wordList
		UnaryOperator<String> noSpaces = (x) -> x.replace(" ", "");
		wordList.replaceAll(upper);
		wordList.replaceAll(noSpaces);*/
		
		
		
	}
	/*
	 public static ArrayList<String> sort(ArrayList<String> A)
{
	for(String i = 0; i < A.size()-1; i++)
	{
		String smallPos = i;
		for(String j = i+1; j < A.size(); j++)
		{
			if(A.get(j) < A.get(smallPos))
			{
				smallPos = j;
			}
		}
		
		String temp = A.get(smallPos);
		A.get(smallPos) = A.get(i);
		A.get(i) = temp;
	}
	
	return A;
}

public static void prStringArray(String[] A)
{
	for(String i = 0; i < A.length; i++)
	{
		System.out.prStringln(A[i]);
	}
}/*for(int i = 0; i < wordList.size()-1; i++)
	{
		int smallPos = i;
		
		for(int j = i+1; j < wordList.size(); j++)
		{
			if(wordList.get(j).compareTo(wordList.get(smallPos)) > 0)
			{
				smallPos = j;
			}
		}
		
		String temp = wordList.get(smallPos);
		wordList.set(smallPos, wordList.get(i));
		
		wordList.set(i, temp);

	}*/
	 
	
	public static String[] sort(String[] A)
	{
		for(int i = 0; i < A.length-1; i++)
		{
			int minIndex = i;
			for(int j = i+1; j < A.length; j++)
			{
				if(A[j] == A[minIndex])
				{
					minIndex = j;
				}
			}
			
			String temp = A[minIndex];
			A[minIndex] = A[i];
			A[i] = temp;
		}
		
		
		
		return A;
	}
	
	public static void prStringArray(String[] A)
	{
		for(int i = 0; i < A.length; i++)
		{
			System.out.println(A[i]);
		}
	}
	
	
	/*
	 * 
	 * public static ArrayList<String> mergeSort(ArrayList<String> array)
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
			//left.add(array.get(i));
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
	 */
}