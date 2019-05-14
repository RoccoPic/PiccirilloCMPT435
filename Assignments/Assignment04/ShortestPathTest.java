//Rocco Piccirillo
//Assignment04
//ShortestPathTest

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShortestPathTest 
{
	//this is where we actually run our shortest path algorithm
    public static void main(String[] args) throws FileNotFoundException 
    { 
    	//amount of vertices and edges in our Graph
    	//initializes it at 0 so our graph class' graph can work
        int vertexAmount = 0; 
        int edgeAmount = 0; 
        //so we know which edge number we are adding to
        int currentEdge = 0;
        //not the most innovative name but it works
        Graph graph = new Graph(vertexAmount, edgeAmount); 
  
        //sets the size of graph so we know how many 
        //source point checks to print out
        ArrayList<Integer> graphSize = new ArrayList<Integer>();
        
        //sets our initial point we go off of
        //will never start at 0 bc we do not have a 0
        int sourcePoint = 1; 
        
        	//this is how we are accessing our graphs text file
      		Scanner scanner = new Scanner(new File("graphs"));
      	
      		//while there is still another line of text we parse further
      		while(scanner.hasNextLine()) 
      		{
      			//creates a string that accesses the current line 
      			String currentLine = scanner.nextLine();
      			
      			//depending on which graph we are in we set 
      			//the amount of vertices and number of edges
      			if(currentLine.contains("--"))
      			{
      				//graph 1
      				if(currentLine.contains("CLRS"))
      				{
      					vertexAmount = 6;
      					edgeAmount = 10;
      				//graph 2
      				}else if(currentLine.contains("Tyler"))
      				{
      					vertexAmount = 8;
      					edgeAmount = 12;
      				//graph 3
      				}else if(currentLine.contains("v2"))
      				{
      					vertexAmount = 8;
      					edgeAmount = 12;
      				}
      				//graph 4
      				else if(currentLine.contains("v3"))
      				{
      					vertexAmount = 8;
      					edgeAmount = 12;
      				}
      			}
      			//if the currentLine doesn't include the -- we begin to create our graph
      			if(!currentLine.contains("--"))
      			{     				
      				//once a new graph appears, we print all of the paths from every point
      				//to every single point
      				if(currentLine.contains("new graph"))
      				{
      					//System.out.println("New Graph");
      					//prints the original w/ a new line as well bc formatting exists
      					//prints out nothing at first bc we have to 
      					for(int i = 0; i < graphSize.size(); i++)
      					{      						
      					 System.out.println("Shortest Paths from: " + sourcePoint ); 
      			        graph.BellmanFord(graph, sourcePoint);  
      			        sourcePoint++;
      					System.out.println();
      					}
      					//once the entire graph is printed out, we reset everything
      					System.out.println("New Graph");
      					sourcePoint = 1;
      					graph  = new Graph(vertexAmount, edgeAmount);
      					graphSize = new ArrayList<Integer>();
      					currentEdge = 0;
      				//once we hit a vertex we add a point to the size ArrayList 
      				//this helps get a better idea how many we need to print out
      				}else if(currentLine.contains("add vertex"))
      				{
      					//if the graph is empty we add a point zero bc each of these
      					//dont have an index 0 point, all start at 1
      					if(graphSize.isEmpty())
      					{
      						//so once this is empty we add the initial 0 
      						graphSize.add(0);
      					}else 
      					{
      						//then we add the rest of the points depending on 
      						//how many points are in
      						char vertexPoint = currentLine.charAt(currentLine.length()-1);
          					int vertexInt = Character.getNumericValue(vertexPoint);
          					graphSize.add(vertexInt);
      					}      					
      				}      				
      				//once there's an edge, here's where the fun begins
      				else if(currentLine.contains("add edge"))
      				{
      					//the best way to determine how to do this was by spreading out
      					//by the size of the current string
      					if(currentLine.length() == 16)
      					{
      					//each index is getting stored as a char along with the weightValue
      					//point one is the main point, and point two is the point that is 
      					//getting pointed to
      					char pointOne = currentLine.charAt(currentLine.length()-7);
      					char pointTwo = currentLine.charAt(currentLine.length()-3);
      					char directedWeight = currentLine.charAt(currentLine.length()-1);
      					
      					//these chars get converted into integers so they can be usable 
      					//in my algorithm
      					int pOne = Character.getNumericValue(pointOne);
      					int pTwo = Character.getNumericValue(pointTwo);
      					int weightInt = Character.getNumericValue(directedWeight);
      					      					
      					//adds new edge from point A to B with a weight of C
      			        graph.edge[currentEdge].mainPoint = pOne; 
      			        graph.edge[currentEdge].destPoint = pTwo; 
      			        graph.edge[currentEdge].weightValue = weightInt; 
      			        currentEdge++;
      					//onto the next type of add edge a - or for double digits
      					} else if(currentLine.length() == 17)
      					{		
      						//each index is getting stored as a char initially
          					char pointOne = currentLine.charAt(currentLine.length()-8);
          					char pointTwo = currentLine.charAt(currentLine.length()-4);
          					
          						String directedWeight = currentLine.substring(15,17);
              					directedWeight.trim();
              					
              					//these chars get converted into integers
              					int pOne = Character.getNumericValue(pointOne);
              					int pTwo = Character.getNumericValue(pointTwo);
              					int weightInt = Integer.parseInt(directedWeight);
              					
             					 //adds new edge from point A to B with ? weightValue
             			        graph.edge[currentEdge].mainPoint = pOne; 
             			        graph.edge[currentEdge].destPoint = pTwo; 
             			        graph.edge[currentEdge].weightValue = weightInt; 
             			       currentEdge++;
          					}
      					}
      				}	
      			}       
      			//prints the last graph bc it doesn't automatically get printed 
      			//this is bc new graph never appears
				for(int i = 0; i < graphSize.size(); i++)
				{					
			        System.out.println("Shortest Paths from: " + sourcePoint ); 
			        graph.BellmanFord(graph, sourcePoint);  
			        sourcePoint++;
					System.out.println();
				}
    } 
}
