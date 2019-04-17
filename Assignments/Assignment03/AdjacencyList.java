////Assignment03
//Rocco Piccirillo
//AdjacencyList
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<LinkedListGraph> linkedGraphs = new ArrayList<LinkedListGraph>();
		
		//this is how we are accessing our graphs text file
		Scanner scanner = new Scanner(new File("graphs"));
	
		//while there is still another line of text we parse further
		while(scanner.hasNextLine()) 
		{
			//creates a string that accesses the current line 
			String currentLine = scanner.nextLine();
			
			//if the currentLine doesn't include the -- we begin to create our graph
			if(!currentLine.contains("--"))
			{
				//once a new graph appears, we print our original graph we worked on and 
				//start to create a new one
				if(currentLine.contains("new graph"))
				{
					//prints the original w/ a new line as well bc formatting exists
					printList(linkedGraphs);
					System.out.println();
					//creates a new ArrayList to our multiple linked lists
					linkedGraphs = new ArrayList<LinkedListGraph>();
					//this is done so we can begin with a vertex of zero
					//not all graphs include this but I was getting errors 
					//starting the last graph without it
					linkedGraphs.add(new LinkedListGraph());
					
				//once we hit a vertex we create a new linked List
				} else if(currentLine.contains("add vertex"))
				{
					//starts at index 1 since we already added in an initial List
					linkedGraphs.add(1, new LinkedListGraph());
				
				//once we hit an edge we start building our lists
				} else if(currentLine.contains("add edge"))
				{
					//the best way to determine how to do this was by spreading out
					//by the size of the current string
					//this example means the relationship is 1 -2 
					if(currentLine.length() == 14)
					{
					//each index is getting stored as a char
					char pointOne = currentLine.charAt(currentLine.length()-1);
					char pointTwo = currentLine.charAt(currentLine.length()-5);
					
					//these chars get converted into integers
					int pOne = Character.getNumericValue(pointOne);
					int pTwo = Character.getNumericValue(pointTwo);
					
					//both ints get appended to one another
					//so  1:2
					//and 2:1
					linkedGraphs.get(pOne).append(pTwo);
					linkedGraphs.get(pTwo).append(pOne);
					
					//so now when its 10 -2 or 3 - 11 we check for that condition
					} else if(currentLine.length() == 15)
					{
					
						//making them both strings in case of 1 - 10 or 10 - 1
						//this way we can save them as strings and have a bit of
						//white space which is being trimmed if the string contains it
						String pointOne = currentLine.substring(13);
						String pointTwo = currentLine.substring(9, 11);
						pointOne = pointOne.trim();
						pointTwo = pointTwo.trim();
						
						//these get turned into ints, and it works bc we trimmed the strings
						//of their whitespace already
						int pOne = Integer.parseInt(pointOne);
						int pTwo = Integer.parseInt(pointTwo);
						
						//we then append 
						linkedGraphs.get(pOne).append(pTwo);
						linkedGraphs.get(pTwo).append(pOne);
						
					//this is close to the last one but we actually keep 
						//both of the numbers, since they don't need trimming
						//they'd be checking for 10 - 12 or 13 - 22
					} else if(currentLine.length() == 16)
					{
						//stores the two double digit numbers as strings
						String pointOne = currentLine.substring(14, 16);
						String pointTwo = currentLine.substring(9, 11);
						
						//converts these strings to ints
						int pOne = Integer.parseInt(pointOne);
						int pTwo = Integer.parseInt(pointTwo);
						
						//eventually appends the two
						linkedGraphs.get(pOne).append(pTwo);
						linkedGraphs.get(pTwo).append(pOne);
					}
				}
				
				
			}
		}
		//once we break out of the while loop this happens
		//bc we initally have only been printing graphs after
		//a new graph appears, but the last will never print
		//bc a "new graph" text never reappears
		printList(linkedGraphs);
		
	}
	
			//provides a clean method to print our LinkedListGraph
			public static void printList(ArrayList<LinkedListGraph> currList)
			{
				for(int i = 0; i < currList.size(); i++)
				{
					//prints the current indexes linked list components
					System.out.print(i + " ");
					currList.get(i).show();
					//once we are done we print out this | 
					//all graphs start with one bc we are not 
					//using the index 0 for most
					//also their are blank spots bc some points don't connect
					System.out.print(" :");
				}
			}
	
}
