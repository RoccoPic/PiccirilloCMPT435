////Assignment03
//Rocco Piccirillo
//LinkedObject
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LinkedObject
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Vertex linkedObjects = new Vertex();
		Graphs graph = new Graphs();
		
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
					printList(graph);
					System.out.println();
					//creates a new ArrayList to our multiple linked lists
					linkedObjects = new Vertex();
					
					graph = new Graphs();
					graph.vertices.add(new Vertex());
					
				//once we hit a vertex we create a new linked List
				} else if(currentLine.contains("add vertex"))
				{
					//starts at index 1 since we already added in an initial List
					if(currentLine.length() == 12) 
					{
					char pointOne = currentLine.charAt(currentLine.length()-1);
					int pOne = Character.getNumericValue(pointOne);
					Vertex newVertex = new Vertex();
					newVertex.VId = pOne;
					graph.vertices.add(newVertex);
					} else if(currentLine.length() == 13)
					{
						String pointOne = currentLine.substring(11);
						int pOne = Integer.parseInt(pointOne);
						Vertex newVertex = new Vertex();
						newVertex.VId = pOne;
						graph.vertices.add(newVertex);
					}

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
	
					graph.vertices.get(pOne).vertexes.add(pTwo);
					graph.vertices.get(pTwo).vertexes.add(pOne);
					
					
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
						graph.vertices.get(pOne).vertexes.add(pTwo);
						graph.vertices.get(pTwo).vertexes.add(pOne);
						
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
						graph.vertices.get(pOne).vertexes.add(pTwo);
						graph.vertices.get(pTwo).vertexes.add(pOne);

					}
				}
				
				
			}
		}
		//once we break out of the while loop this happens
		//bc we iniitally have only been printing graphs after
		//a new graph appears, but the last will never print
		//bc a "new graph" text never reappears
		printList(graph);
	}
	
			//provides a clean method to print our LinkedList
			public static void printList(Graphs currList)
			{
				for(int i = 0; i < currList.vertices.size(); i++)
				{
					Vertex vert = currList.vertices.get(i);
					for(int j = 0; j < vert.vertexes.size(); j++) {
						System.out.print(vert.vertexes.get(j) + ", ");
					}
					System.out.print(" |");
				}
			}
	
}
