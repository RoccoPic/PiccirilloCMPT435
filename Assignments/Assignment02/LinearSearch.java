import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class LinearSearch 
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
		//this is so we know where we are in the magicItemsList
		//this will be used for knowing how many comparisons have been performed
		int pos = 0;
		
		
		//while the counter has not yet reached 42 comparisons yet
		while(counter < 42)
		{
		//if the current position of the wordList is equal to the 
		//current selected string from randList
		if(wordList.get(pos).equals(randList.get(index)))
			{
				pos++;
				//once found the position or number of comparisons will be added
				comparisons.add(pos);
				//this is so we can keep track of what word is being searched for
				//and what position we found said word at
				System.out.println(randList.get(index) + " found at " + pos);
				//the position gets reset back to 0 for our next searched word
				pos = 0;
				//the next word in the randList gets selected
				index++;
				//the counter also gets moved up as well so that
				//once we get to 42 we exit
				counter++;
			//if not found, we move to the next word in the sorted wordList
			} else
			{
				pos++;
				
			}
		}
		
		//the average of comparisons is being printed here
		System.out.print("The average is " + average(comparisons, comparisons.size()));
		
		
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

