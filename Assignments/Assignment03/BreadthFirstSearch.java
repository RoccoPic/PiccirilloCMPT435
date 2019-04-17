////Assignment03
//Rocco Piccirillo
//BreadthFirstSearch
import java.io.*; 
import java.util.*;

public class BreadthFirstSearch 
{ 
     int V;   //the number of vertices
     LinkedList<Integer> BFSList[]; //Adjacency Lists 
  
    //breadthfirstSearch constructor
    BreadthFirstSearch(int V) 
    { 
        this.V = V; 
        BFSList = new LinkedList[V]; 
        for (int i=0; i< V; ++i) 
            BFSList[i] = new LinkedList(); 
    } 
  
    //adds an edge to a point
    void addEdge(int vertOne,int vertTwo) 
    { 
        BFSList[vertOne].add(vertTwo); 
    } 
  
    //prints all not yet marked vertices reachable from point
    void BFS(int s) 
    { 
        //initially marks all points as not yet marked
        boolean marked[] = new boolean[V]; 
  
        //sets up a queue through LinkedList
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        //marks our current node as marked
        marked[s]=true; 
        //and adds to the queue
        queue.add(s); 
  
        //while the queue is not empty
        while (queue.size() != 0) 
        { 
            //the vertex gets dequeued but it also prints
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            //gets all of the vertices that are adjacent that have been dequeued off
            //if a point has not been marked then it will be enqueued to the queue
            Iterator<Integer> i = BFSList[s].listIterator(); 
            
            //while theres another value in i
            while (i.hasNext()) 
            { 
            	//we retrieved it and make sure it isn't marked, so we push it to the stack
            	//this way we aren't just printing it out we are pushing it as well
                int n = i.next(); 
                if (!marked[n]) 
                { 
                    marked[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    } 
  
    public static void main(String args[]) throws FileNotFoundException 
    { 
    	//this is how we are accessing our graphs text file
    	Scanner scanner = new Scanner(new File("graphs"));

    	//sets our BreadthFirstSearch graph, which has a size of 65, which isn't efficient 
    	//but was struggling to figure out another way to do so with the time allotted
        BreadthFirstSearch BFSGraph = new BreadthFirstSearch(65);

        System.out.println("The following is the Breadth First Traversal (Ignore the first)"); 
        
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
					BFSGraph.BFS(1);
					System.out.println();

					//resets our graph DFSGraph to a size of 65
					//65 is not no means an efficient size but I wasn't able to figure out how to fix 
					//this with the amount of time left
					BFSGraph = new BreadthFirstSearch(65);
				
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
					
					//both ints get appended to one another
					//so  1:2
					//and 2:1
					//adds the links for our current graph
					BFSGraph.addEdge(pOne, pTwo);
					BFSGraph.addEdge(pTwo, pOne);
					
					
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
						BFSGraph.addEdge(pOne, pTwo);
						BFSGraph.addEdge(pTwo, pOne);
						
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
						BFSGraph.addEdge(pOne, pTwo);
						BFSGraph.addEdge(pTwo, pOne);
					}
				}				
			}
		}
		//once we break out of the while loop this happens
		//bc we initally have only been printing graphs after
		//a new graph appears, but the last will never print
		//bc a "new graph" text never reappears
		BFSGraph.BFS(0);		
	}
    } 
 