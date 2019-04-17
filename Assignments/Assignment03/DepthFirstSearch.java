//Assignment03
//Rocco Piccirillo
//DepthFirstSearch
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*; 

    public class DepthFirstSearch 
    { 
        int V;//used to set the size of the search
          
        LinkedList<Integer>[] DFSList; //sets list
          
        //constructor for Depth First Search
        DepthFirstSearch(int V) 
        { 
            this.V = V; 
            DFSList = new LinkedList[V];  //sets my linkedList
              
            for (int i = 0; i < DFSList.length; i++) 
            {
            	DFSList[i] = new LinkedList<Integer>(); //sets params for list
            }                 
        } 
          
        //adds an edge to a point
        public void addEdge(int vertOne, int vertTwo) 
        { 
            DFSList[vertOne].add(vertTwo); //Add vertTwo to vertOne’s point list. 
        } 
                 
        // prints all not yet marked vertices reachable from point 
        public void DFS(int point) 
        { 
            //since nothing has been printing yet, we make sure to 
        	//set all points not marked yet, so we can print and then make them true
            Vector<Boolean> marked = new Vector<Boolean>(V); 
            for (int i = 0; i < V; i++) 
            {
            	marked.add(false); 
            }
                    
            // Create a stack for DFS 
            Stack<Integer> stack = new Stack<>(); 
              
            // Push the current source node 
            stack.push(point); 
              
            //while the stack is not empty
            while(!stack.empty()) 
            {
            	//print and pop the point  being used
                point = stack.peek(); 
                stack.pop(); 
                  
                //if the specific point has not yet been marked
                //we print it out and set that point in the marked array as true after
                if(marked.get(point) == false) 
                { 
                	//we print out every point that hasn't been pa
                    System.out.print(point + ", "); 
                    marked.set(point, true); 
                } 
                  
                //gets all of the vertices that are adjacent that have been popped off
                //if a point has not been marked then it will be pushed to the stack
                Iterator<Integer> iterator = DFSList[point].iterator(); 
                  
                //while there is another value in i
                while (iterator.hasNext())  
                { 
                	//we retrieved it and make sure it isn't marked, so we push it to the stack
                	//this way we aren't just printing it out we are pushing it as well
                    int vertOne = iterator.next(); 
                    if(!marked.get(vertOne)) 
                    {
                    stack.push(vertOne); 
                    }                      
                }                  
            } 
        } 
          
    // Driver program to test methods of graph class 
    public static void main(String[] args) throws FileNotFoundException  
    { 
    	//this is how we are accessing our graphs text file
    	Scanner scanner = new Scanner(new File("graphs"));
        
    	//sets our DepthFirstSearch graph, which has a size of 65, which isn't efficient 
    	//but was struggling to figure out another way to do so with the time allotted
        DepthFirstSearch DFSGraph = new DepthFirstSearch(65);

        System.out.println("Following is the Depth First Traversal (Ignore the first printout)"); 
        
		//while there is still another line of text we parse further
		while(scanner.hasNextLine()) 
		{
			//creates a string that accesses the current line 
			String currentLine = scanner.nextLine();
			
			//if the currentLine doesn't include the -- we begin to create our graph
			if(!currentLine.contains("--"))
			{
				//once new graph appears we print out a new graph
				//and reset the old one
				if(currentLine.contains("new graph"))
				{
					//prints the original w/ a new line as well bc formatting exists
					//this will by default print out a graph with a 1 bc I tell it to
					DFSGraph.DFS(1);
					System.out.println();
					
					//resets our graph DFSGraph to a size of 65
					//65 is not no means an efficient size but I wasn't able to figure out how to fix 
					//this with the amount of time left
					DFSGraph = new DepthFirstSearch(65);
						
				//once we hit an edge we start building our links
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
										
					//adds the links for our current graph
					DFSGraph.addEdge(pOne, pTwo);
					DFSGraph.addEdge(pTwo, pOne);
					
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
						
						//adds the links for our current graph
						DFSGraph.addEdge(pOne, pTwo);
						DFSGraph.addEdge(pTwo, pOne);
						
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
						
						//adds the links for our current graph
						DFSGraph.addEdge(pOne, pTwo);
						DFSGraph.addEdge(pTwo, pOne);
					}
				}
			}
		}
		//once we break out of the while loop this happens
		//bc we initally have only been printing graphs after
		//a new graph appears, but the last will never print
		//bc a "new graph" text never reappears
		DFSGraph.DFS(0);
		
	}
    } 
 

