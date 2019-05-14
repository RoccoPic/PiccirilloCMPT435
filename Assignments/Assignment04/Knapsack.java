//Rocco Piccirillo
//Assignment04
//Knapsack

public class Knapsack 
{
	//sets the number of spices we are using 
	public int numOfItems;
	//sets the capacity we will be using
	public int capacityOfKnapsack;
	//sets up a 2D array for a ds
	public int [][] knapsackTable;
	//depending on how much money we make for our trip we set a profit total
	public int totalProfit;
	public int [] quantity;
	public int [] unitValue;
	
	public Knapsack(int numOfItems, int capacityOfKnapsack, int[] quantity, int[] unitValue)
	{
		this.numOfItems = numOfItems;
		this.capacityOfKnapsack = capacityOfKnapsack;
		this.quantity = quantity;
		this.unitValue = unitValue;
		this.knapsackTable = new int[numOfItems+1][capacityOfKnapsack + 1];
	}
	
	//fills the sack accordingly 
	public void fillSack()
	{
		//worst case time complexity O(i*j)
		//runs through every single item first
		for(int i = 1; i < numOfItems+1; i++)
		{
			//runs through the given capacity of the knapsack
			for(int j = 1; j < capacityOfKnapsack + 1; j++)
			{
				//when the bag is set to full we cannot add further
				int doNotAddItem = knapsackTable[i -1][j]; //cannot take item i
				//whilst the bag isn't full we can continue to add
				int addItem = 0;
				
				//so quantity originally was used for weight
				//so when the quantity of a certain item is less than the capacity
				//we continue to add further
				if(quantity[i] <= j) 
				{
					//adding the value of the item
					addItem = unitValue[i] + knapsackTable[i - 1][j - quantity[i]];
				}
				
				//sets the knapsack table values for i j
				//to the max values of each set
				knapsackTable[i][j] = Math.max(doNotAddItem, addItem);
			}
		}
		
		//the total profit is from the number of items w/ the capacity
		totalProfit = knapsackTable[numOfItems][capacityOfKnapsack];
	}
	
	public void printOut()
	{
		//we print out the total price of spices collected
		System.out.println("Total Spice Price: $" + totalProfit + ".00");
		
		//i is equal to the number of items
		//j is equal to the capacity of the bag
		for(int i = numOfItems, j = capacityOfKnapsack; i > 0; i--)
		{
			//if the item wasn't being used
			//and if the item was already printed we show that
			if (knapsackTable[i][j] != 0 && knapsackTable[i][j] != knapsackTable[i-1][j])
			{
				//this is where we show our prints
				System.out.println("We take item: #" + i);
				j = j - quantity[i];
			}
		}
	}
}
