import java.io.*; 
import java.util.*; 
  

public class ShortestPath 
{ 
	//sets the worst possible value for each
    public int worstRoute = Integer.MAX_VALUE; 
    
    //initializes an adjacency list node class
    class AdjListNode 
    { 
        public int vertex; 
        public int weight; 
        AdjListNode(int vertexValue, int weightValue) { vertex = vertexValue;  weight = weightValue; } 
        int getV()  { return vertex; } 
        int getWeight()  { return weight; } 
    } 
  
    // Class to represent graph as an adjacency list of 
    // nodes of type AdjListNode 
    class Graph 
    { 
        public int Vertex; 
        public LinkedList<AdjListNode>adj[]; 
        
        //initialized Graph class
        Graph(int vertex) 
        { 
        	//set up vertex
            Vertex = vertex; 
            adj = new LinkedList[Vertex]; 
            //depending on how many vertices there are
            for (int i = 0; i < vertex; i++)
            {
                adj[i] = new LinkedList<AdjListNode>(); 
            }
        }
        
        
        void addEdge(int u, int vertex, int weight) 
        { 
            AdjListNode node = new AdjListNode(vertex,weight); 
            adj[u].add(node);// Add vertex to u'sourcePoint list 
        } 
  
        // A recursive function used by shortestPath. 
        // See below link for details 
        void topologicalSortUtil(int vertex, Boolean visited[], Stack stack) 
        { 
            // Mark the current node as visited. 
            visited[vertex] = true; 
            Integer i; 
  
            // Recur for all the vertices adjacent to this vertex 
            Iterator<AdjListNode> it = adj[vertex].iterator(); 
            while (it.hasNext()) 
            { 
                AdjListNode node =it.next(); 
                if (!visited[node.getV()]) 
                    topologicalSortUtil(node.getV(), visited, stack); 
            } 
            // Push current vertex to stack which stores result 
            stack.push(new Integer(vertex)); 
        } 
  
        // The function to find shortest paths from given vertex. It 
        // uses recursive topologicalSortUtil() to get topological 
        // sorting of given graph. 
        void shortestPath(int sourcePoint) 
        { 
            Stack stack = new Stack(); 
            int dist[] = new int[Vertex]; 
  
            // Mark all the vertices as not visited 
            Boolean visited[] = new Boolean[Vertex]; 
            for (int i = 0; i < Vertex; i++) 
                visited[i] = false; 
  
            // Call the recursive helper function to store Topological 
            // Sort starting from all vertices one by one 
            for (int i = 0; i < Vertex; i++) 
                if (visited[i] == false) 
                    topologicalSortUtil(i, visited, stack); 
  
            // Initialize distances to all vertices as infinite and 
            // distance to source as 0 
            for (int i = 0; i < Vertex; i++) 
                dist[i] = worstRoute; 
            dist[sourcePoint] = 0; 
  
            // Process vertices in topological order 
            while (stack.empty() == false) 
            { 
                // Get the next vertex from topological order 
                int u = (int)stack.pop(); 
  
                // Update distances of all adjacent vertices 
                Iterator<AdjListNode> it; 
                if (dist[u] != worstRoute) 
                { 
                    it = adj[u].iterator(); 
                    while (it.hasNext()) 
                    { 
                        AdjListNode i= it.next(); 
                        if (dist[i.getV()] > dist[u] + i.getWeight()) 
                            dist[i.getV()] = dist[u] + i.getWeight(); 
                    } 
                } 
            } 
  
            // Print the calculated shortest distances 
            for (int i = 0; i < Vertex; i++) 
            { 
                if (dist[i] == worstRoute) 
                    System.out.print( "Invalid Point: \n"); 
                else {
                	System.out.print(i + ": ");
                    System.out.println( dist[i] + " "); 
                }
            } 
        } 
    } 
  
    // Method to create a new graph instance through an object 
    // of ShortestPath class. 
    Graph newGraph(int number) 
    { 
        return new Graph(number); 
    } 
  
    public static void main(String args[]) throws FileNotFoundException 
    { 
        ShortestPath shortPath = new ShortestPath(); 
        Graph graph = shortPath.newGraph(8); 
        ArrayList<Integer> graphSize = new ArrayList<Integer>();
        
        int sourcePoint = 1; 
        System.out.println("Following are shortest distances from source " + sourcePoint); 
        graph.shortestPath(sourcePoint); 
        
        
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
      					for(int i = 0; i < graphSize.size(); i++)
      					{      						
      				        System.out.println("Following are shortest distances from source " + sourcePoint ); 
      				        graph.shortestPath(sourcePoint); 
      				        sourcePoint++;
          					System.out.println("");
      					}
      					System.out.println("New Graph");
      					sourcePoint = 1;
      					graph = shortPath.newGraph(8); 
      					graphSize = new ArrayList<Integer>();
      				//once we hit a vertex we create a new linked List
      				}else if(currentLine.contains("add vertex"))
      				{
      					if(graphSize.isEmpty())
      					{
      						graphSize.add(0);
      					}else 
      					{
      						char vertexPoint = currentLine.charAt(currentLine.length()-1);
          					int vertexInt = Character.getNumericValue(vertexPoint);
          					graphSize.add(vertexInt);
      					}
      					
      				}
      				
      				else if(currentLine.contains("add edge"))
      				{
      					//the best way to determine how to do this was by spreading out
      					//by the size of the current string
      					//this example means the relationship is 1 -2 
      					if(currentLine.length() == 16)
      					{
      					//each index is getting stored as a char
      					char pointOne = currentLine.charAt(currentLine.length()-7);
      					char pointTwo = currentLine.charAt(currentLine.length()-3);
      					char directedWeight = currentLine.charAt(currentLine.length()-1);
      					
      					//these chars get converted into integers
      					int pOne = Character.getNumericValue(pointOne);
      					int pTwo = Character.getNumericValue(pointTwo);
      					int weightInt = Character.getNumericValue(directedWeight);
      					
      					//gets the point you start at
      					//the point you are going to
      					//the weight of the traversal
      					graph.addEdge(pOne, pTwo, weightInt);
      					
      					} else if(currentLine.length() == 17)
      					{		
      					//each index is getting stored as a char
          					char pointOne = currentLine.charAt(currentLine.length()-8);
          					char pointTwo = currentLine.charAt(currentLine.length()-4);
          					
          					if(currentLine.contains("  "))
          					{
          						char directedWeight = currentLine.charAt(currentLine.length()-4);
              					
              				//these chars get converted into integers
              					int pOne = Character.getNumericValue(pointOne);
              					int pTwo = Character.getNumericValue(pointTwo);
              					//System.out.print("cat");
              					int weightInt = Character.getNumericValue(directedWeight);
              					//gets the point you start at
              					//the point you are going to
              					//the weight of the traversal
              					graph.addEdge(pOne, pTwo, weightInt);
              					
          					}else
          					{
          						String directedWeight = currentLine.substring(15,17);
              					directedWeight.trim();
              					
              				//these chars get converted into integers
              					int pOne = Character.getNumericValue(pointOne);
              					int pTwo = Character.getNumericValue(pointTwo);
              					System.out.print("cat");
              					int weightInt = Integer.parseInt(directedWeight);
              					//gets the point you start at
              					//the point you are going to
              					//the weight of the traversal
              					graph.addEdge(pOne, pTwo, weightInt);
          					}
          					
          					
      					}
      					
      				}
      				
      				
      			}       
    } 
      	//prints the original w/ a new line as well bc formatting exists
				for(int i = 0; i < graphSize.size(); i++)
				{
					
			        System.out.println("Following are shortest distances from source " + sourcePoint ); 
			        graph.shortestPath(sourcePoint); 
			        sourcePoint++;
					System.out.println();
				}
    }
}
    

