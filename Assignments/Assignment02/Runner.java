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
}