import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

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
			
			//sets all strings in wordList to upperCase
			UnaryOperator<String> upper = (x) -> x.toUpperCase();
			wordList.replaceAll(upper);
			
			wordList = mergeSort(wordList);
			printArray(wordList);
}
	
	public static ArrayList<String> mergeSort(ArrayList<String> A)
	{
		if(A.size() <= 1)
		{
			return A;
		}
		
		int midpoint = A.size() / 2;
		ArrayList<String> left = new ArrayList<String>(midpoint);
		ArrayList<String> right;
		
		if(A.size() % 2 == 0)
		{
			right = new ArrayList<String>();
		} else
		{
			right = new ArrayList<String>(midpoint + 1);
		}
		ArrayList<String> result = new ArrayList<String>(A.size());
		
		for(int i = 0; i < midpoint; i++)
		{
			left.add(A.get(i));
			//left.set(i, A.get(i));
		}
		int x = 0;
		for(int j = midpoint; j < A.size(); j++)
		{
			right.add((A.get(j)));
			/*if(x < right.size())
			{
			right.set(x, A.get(j));
			x++;
			}*/
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		result = merge(left, right);
		
		return result;
	}
	
	public static ArrayList<String> merge(ArrayList<String> left, ArrayList<String> right)
	{
		int lengthResult = left.size() + right.size();
		ArrayList<String> result = new ArrayList<String>(lengthResult);
		int indexL = 0;
		int indexR = 0;
		int indexRes = 0;
		
		while(indexL < left.size() || indexR < right.size())
		{
			if(indexL < left.size() && indexR < right.size())
			{
				if(left.get(indexL).compareTo(right.get(indexR)) < 0)
						{
							result.add(left.get(indexL));
							//result.set(indexRes, left.get(indexL));
							indexL++;
							indexRes++;
						}
				else 
				{
					result.add(right.get(indexR));
					//result.set(indexRes, right.get(indexR));
					indexR++;
					indexRes++;
				}
			}
			else if (indexL < left.size())
			{
				result.add(left.get(indexL));
				//result.set(indexRes, left.get(indexL));
				indexL++;
				indexRes++;
			} else if (indexR < right.size())
			{
				result.add(right.get(indexR));
				//result.set(indexRes, right.get(indexR));
				indexR++;
				indexRes++;
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
