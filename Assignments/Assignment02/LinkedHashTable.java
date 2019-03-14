//Assignment02
//Rocco Piccirillo
//LinkedHashTable
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class LinkedHashTable
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
	
     
       //creates an instance of my hashTable
        HashTable hasher = new HashTable(0);
 
        //created a for loop to insert all 
        //string of my arrayList into the hash
        for(int i = 0; i < wordList.size(); i++)
		{
        	//inserts my string, and a value for it
        	//I chose the value to be the index of the string
        	//thought it would be easier to follow
			hasher.insert(wordList.get(i), i);
		}
		
        //prints out my hash for users to view
        hasher.printHashTable();
        
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
		
		 //stores the amount of comparisons it takes for the randList string
		//to be found in the hash's linkedList
		   ArrayList<Integer> compareCount = new ArrayList<Integer>();
		
		//sets a counter for my while to run 42 times
		int counter = 0;
		//creates an index for my randList to begin checking at
		int index = 0;
		
		//tests for my word at hand being in the hash
		while(counter < 42)
		{
			//if the hasher has an index for the randList string
			//we enter the if statement
			if(hasher.get(randList.get(index)) != -1 )
			{
				//adds the amount of comparisons it took to find the string
				//inside of this arrayList
				compareCount.add(hasher.getComparisons(randList.get(index)));
				
				//prints out the string being found and the amount of comparisons/get it took
				System.out.print("\n" + randList.get(index) + " found after " + hasher.getComparisons(randList.get(index)) + " comparisons.");
				//increments index so we can move onto the next string
				index++;
				//increments counter so we can eventually leave the while loop
				counter++;
			}
			
		}
		
		//prints out the average amount of comparisons
		System.out.print("\nThe average amount of comparisons is " + average(compareCount, compareCount.size()));
		
    }
    
    //Function that return average of an array. 
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