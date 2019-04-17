////Assignment03
//Rocco Piccirillo
//Matrix
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//created to access the graphs text file
		Scanner scanner = new Scanner(new File("graphs"));
		//made to actually store the magic items
	
		//sets a counter so we can set a size for our matrix
		int counter = 1;
		//declares an initial size of 0,0 which will be updated
		int [][] matrix = new int[0][0];
		
		//traverses the graph text file while there are still lines
		while(scanner.hasNextLine()) 
		{
			//creates a current line to store the current text
			String currentLine = scanner.nextLine();
			//ignores the inital comment
			if(!currentLine.contains("--"))
			{
				//once there is a new graph, we reset our counter
				//we print the original matrix
				//and we print a new line for formatting
				if(currentLine.contains("new graph"))
				{
					counter = 1;
					printArray(matrix);
					System.out.println();
					
				//when vertexes get added we increase the size of the counter
				//and the size of the matrix increases
				} else if(currentLine.contains("add vertex"))
				{
					 counter++;
					 matrix = new int [counter][counter]; 
				//once add vertex is done, the sizing will be complete
				} else if(currentLine.contains("add edge"))
				{
					//depending on the size of the string we figure out how to add
					//the current values
					if(currentLine.length() == 14)
					{
					//when the size is 14 we only need to add two seperate 
					//one digit numbers, that we store as chars
					char pointOne = currentLine.charAt(currentLine.length()-1);
					char pointTwo = currentLine.charAt(currentLine.length()-5);
					
					//we then convert into seperate ints
					int pOne = Character.getNumericValue(pointOne);
					int pTwo = Character.getNumericValue(pointTwo);
					

					//depending on these ints we turn our matrix values
					//into 1's to show the connected points
					matrix[pOne][pTwo] = 1; 
					matrix[pTwo][pOne] = 1;
					
					//so now when its 10 -2 or 3 - 11 we check for that condition
					} else if(currentLine.length() == 15)
					{
						//stores whatever int is at 13 or from indexes
						//9 to 11, depending on if they are one digit or not
						//we trim the white space
						String pointOne = currentLine.substring(13);
						String pointTwo = currentLine.substring(9, 11);
						pointOne = pointOne.trim();
						pointTwo = pointTwo.trim();
						
						//converts our strings into ints
						int pOne = Integer.parseInt(pointOne);
						int pTwo = Integer.parseInt(pointTwo);
						
						//depending on what the ints are we save it 
						//in the matrix as a 1
						matrix[pOne][pTwo] = 1; 
						matrix[pTwo][pOne] = 1;
						
					//we are now working with double digits so we don't 
					//need to worry about trimming
					} else if(currentLine.length() == 16)
					{
						//takes these two specific numbers
						String pointOne = currentLine.substring(14, 16);
						String pointTwo = currentLine.substring(9, 11);
						
						//converts into ints that can be used
						int pOne = Integer.parseInt(pointOne);
						int pTwo = Integer.parseInt(pointTwo);
						
						//depending on the numbers given we store
						//1's at that given point
						matrix[pOne][pTwo] = 1; 
						matrix[pTwo][pOne] = 1;
					}
				}
				
				
			}
		}
		//after the list is done being parsed, we need no longer
		//have any way to print out our matrix since we only print
		//after new graph, so after the while loop breaks, we print the matrix
		printArray(matrix);
		
	}
	
			//makes it easy to print, the full matrix
			public static void printArray(int [][] currentList)
			{
				//traverses the x index of the matrix
				for(int i = 0; i < currentList.length; i++)
				{
					//traverses the y index of the matrix
					for(int j = 0; j < currentList.length; j++)
					{
						//prints out the matrix
						System.out.print(currentList[i][j]);
						
					
					}
					//prints a new line for our next graph to start on
					System.out.println("");
					
				}
				
			}
	
}
