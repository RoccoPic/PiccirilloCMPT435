import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class QuickSort 
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
			
			QuickSort(wordList, 0, wordList.size() - 1);
			printArray(wordList);
}
	private static void QuickSort(ArrayList<String> array, int left, int right)
	{
		int index = partition(array, left, right);
		
		if(left < index -1)
		{
			QuickSort(array, left, index - 1);
			if(index < right)
			{
				QuickSort(array, index, right);
			}
		}
	}
	
	private static int partition(ArrayList<String> array, int left, int right)
	{
		String pivot = array.get((left + right) / 2);
		
		while(left<= right)
		{
			while(array.get(left).compareTo(pivot) < 0)
			{
				left++;
			}
			while(array.get(right).compareTo(pivot) > 0)
			{
				right--;
			}
			
			if(left <= right)
			{
				String temp = array.get(left);
				array.set(left, array.get(right));
				array.set(right, temp);
				
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
