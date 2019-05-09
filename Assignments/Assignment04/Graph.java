//Rocco Piccirillo
//Assignment04
//Graph

//class to represent our directed weighted graphs 
public class Graph 
{ 
	//sets the amount of vertexes, and amount of edges
    public int vertexAmount;
    public int edgeAmount; 
    public Edge edge[]; 
  
    //creates a graph with a certain amount of vertices
    //or a certain amount of  edges
    Graph(int vertexValue, int edgeValue) 
    { 
        vertexAmount = vertexValue; 
        edgeAmount = edgeValue; 
        edge = new Edge[edgeValue]; 
        
        for (int i = 0; i < edgeValue; i++) 
        {
        	edge[i] = new Edge(); 
        }          
    } 

    //our function for finding the shortest path from our mainPoint
    //across the entire graph, as in every point
    public void BellmanFord(Graph graph,int mainPoint) 
    { 
        int vertexAmount = graph.vertexAmount;
        int edgeAmount = graph.edgeAmount; 
        int dist[] = new int[vertexAmount]; 

        //1. sets the distances from our mainpoint to every other point as infinite initially
        //this is bc sometimes a point will never be able to reach another point bc there's no links
        for (int i = 0; i < vertexAmount; i++) 
        {
        	dist[i] = Integer.MAX_VALUE; 
            dist[mainPoint] = 0; 
        }

        //2. creates a short path where you can at most contain the 
        //the amount of vertexs - 1 edges
        for (int i = 1; i < vertexAmount; i++) 
        { 
            for (int j = 0; j < edgeAmount; j++) 
            { 
                int point = graph.edge[j].mainPoint; 
                int vertexValue = graph.edge[j].destPoint; 
                int weightValue = graph.edge[j].weightValue; 
                if (dist[point]!=Integer.MAX_VALUE && dist[point]+weightValue<dist[vertexValue]) 
                {
                	dist[vertexValue]=dist[point]+weightValue; 
                }
            } 
        } 
  
        //3. the second step is mainly for shortest path without negative values 
        //this for shortest path with negatives, can create a loop
        for (int j = 0; j < edgeAmount; j++) 
        { 
            int point = graph.edge[j].mainPoint; 
            int vertexValue = graph.edge[j].destPoint; 
            int weightValue = graph.edge[j].weightValue; 
            
            //this is saying that there is a possibility of a loop forming 
            if (dist[point] != Integer.MAX_VALUE && dist[point]+weightValue < dist[vertexValue]) 
            {
            	System.out.println("Graph contains negative weight Value cycle"); 
            }
              
        }
        //once we break out, we print 
        printGraphLinks(dist, vertexAmount); 
    } 
  
    //prints the solution out nicely
    public void printGraphLinks(int dist[], int vertexAmount) 
    { 
        System.out.println("Vertex\t\tDistance"); 
        for (int i = 0; i < vertexAmount; i++) 
        {
        	if(dist[i] == 2147483647)
        	{
        		System.out.println(i+"\t\tNo Possible Path"); 
        	}else 
        	{
        		System.out.println(i+"\t\t"+dist[i]); 
        	}       	
        }
    } 
} 