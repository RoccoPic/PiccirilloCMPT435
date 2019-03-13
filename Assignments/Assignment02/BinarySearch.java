import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class BinarySearch 
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
			
			//creates a new arrayList to store our random items
			ArrayList<String> randList = new ArrayList<String>();
			
			//while the size of the randList is less than 42
			while (randList.size() < 42) 
			{
				//a random Index of wordList will be selected
			    int randIndex = (int) (Math.random()*(wordList.size()-1));
			    //if 
			    if (randList.indexOf(randIndex) == -1) 
			    {
			    	//the randList adds the random indexed number to the List
			        randList.add(wordList.get(randIndex));
			    	
			    }
			}
	
		//first we will be sorting the arrayList
		//this is being done so that finding everything in the list won't be incredibly skewed
		sort(wordList);
			
		//this list is being done so that we can sort the 
		//amount of comparisons being performed
		ArrayList<Integer> comparisons = new ArrayList<Integer>();
		
		//a basic counter being made for the while loop
		int counter = 0;
		//made so we can store the index of randList and 
		//end up incrementing it as we continue
		int index = 0;
		
		//while the counter has not yet reached 42 comparisons yet
		while(counter < 42)
		{
			System.out.print(randList.get(index) + " was found after ");
			
			//this lets us call our binarySearch
			//using the wordList to search and picking 
			//a string from randList to be found
			binSearch(wordList, randList.get(index), comparisons);
			//after being found we increment randList's index
			index++;
			//once our comparisons 
			if(comparisons.size() == 42)
			{
				System.out.print("The average of comparisons:" + average(comparisons, comparisons.size()));
			}
			//the counter also gets increased so eventually we exit the loop
			counter++;
			
		}
	}
		//our binarySearch method
		public static boolean binSearch(ArrayList<String> A, String target, ArrayList<Integer> compare)
		{
			//start is at the beginning of the array being called
			int start = 0;
			//stop is at the end of the arrayList 
			int stop = A.size() -1;
			//midpoint point is the exact middle of our list
			int midpoint = (start + stop)/2;
			//while the start is less than or equal we stay in our loop
			while(start <= stop)
			{
				//if A is before the target alphabetically
				//we move the start up 1
				if(A.get(midpoint).compareTo(target) < 0)
				{
					start = midpoint + 1;
				}
				//if the arrays string equals our target string
				else if(A.get(midpoint).equals(target))
				{
					midpoint++;
					//we print out the number of comparisons it took to be found
					System.out.println((midpoint) + " comparisons");
					compare.add(midpoint);
					//this lets us exit the method since our target was found
					return true;
				}else
				{	//if midpoint is greater than the target point
					stop = midpoint -1;
				}
				//midpoint gets reset back
				midpoint = (start + stop) / 2;
			}
			//if not found, we return as false
			return false;
			
		}
	
	public static ArrayList<String> sort(ArrayList<String> A)
	{
		
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
			}
			//so since we changed, the key now moves to the next string
			A.set(j+1, key);
		}
		//System.out.println(numSwap);
		return A;
	}
	
	// Function that return average of an array. 
    public static double average(ArrayList<Integer> averageArray, int size) 
    { 
          
        // Find sum of array element 
        int sum = 0;
        
        //for the the size of  
        for (int i = 0; i < size; i++) 
        {
        	//we will be adding our newest found item 
        	//to our total sum at the time
            sum += averageArray.get(i); 
        }
        //returns our average aka our sum of ints / our arraySize
        return sum / size; 
    } 
}




