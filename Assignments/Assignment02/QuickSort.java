import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;
public class QuickSort 
{
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
			
			QuickSort(wordList, 0, wordList.size() - 1);
			printArray(wordList);
			System.out.print(compare + " is the number of comparisons.");
	}
	
	private static void QuickSort(ArrayList<String> array, int left, int right)
	{
		int index = partition(array, left, right);
		
		//if left is smaller than the index value
		if(left < index -1)
		{
			//then call the sort method for left
			QuickSort(array, left, index - 1);
			//if right is bigger than the index value
			if(index < right)
			{	
				//then we call the quickSort method from that right value
				QuickSort(array, index, right);
			}
		}
	}
	
	private static int partition(ArrayList<String> array, int left, int right)
	{
		//this string is the midpoint of the array
		String pivot = array.get((left + right) / 2);
		
		//while the left value is less than the right value
		while(left<= right)
		{
			compare++;
			//while the left value is lower than the pivot point
			//increment the left value
			while(array.get(left).compareTo(pivot) < 0)
			{
				compare++;
				left++;
			}
			//while the right value is greater than the pivot point
			//decrement the right value
			while(array.get(right).compareTo(pivot) > 0)
			{
				compare++;
				right--;
			}
			
			//if the left is less than the right
			if(left <= right)
			{
				compare++;
				//the value will be swapped
				//the value first gets stored in a temp variable
				String temp = array.get(left);
				//set left string equal to the right string
				array.set(left, array.get(right));
				//and lastly make temps new value, the right string
				array.set(right, temp);
				
				//after moving on we move forward with the left
				//and move closer with the right
				left++;
				right--;
			}
		}
		
		return left;
		
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
