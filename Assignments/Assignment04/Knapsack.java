
public class Knapsack 
{
	int numOfItems;
	int capacityOfKnapsack;
	int [][] knapsackTable;
	int totalProfit;
	int [] quantity;
	int [] unitValue;
	
	public Knapsack(int numOfItems, int capacityOfKnapsack, int[] quantity, int[] unitValue)
	{
		this.numOfItems = numOfItems;
		this.capacityOfKnapsack = capacityOfKnapsack;
		this.quantity = quantity;
		this.unitValue = unitValue;
		this.knapsackTable = new int[numOfItems+1][capacityOfKnapsack + 1];
	}
	
	public void fillSack()
	{
		//worst case time complexity O(i * j)
		for(int i = 1; i < numOfItems+1; i++)
		{
			for(int j = 1; j < capacityOfKnapsack + 1; j++)
			{
				int bagFull = knapsackTable[i -1][j]; //cannot take item i
				int bagNotFull = 0;
				
				//if the weight is less than the capacity, we can fit it in the bag
				if(quantity[i] <= j) 
				{
					bagNotFull = unitValue[i] + knapsackTable[i - 1][j - quantity[i]];
				}
				
				knapsackTable[i][j] = Math.max(bagFull, bagNotFull);
			}
		}
		
		totalProfit = knapsackTable[numOfItems][capacityOfKnapsack];
	}
	
	public void showResult()
	{
		System.out.println("Total Spice Price: " + totalProfit);
		
		
		for(int i = numOfItems, j = capacityOfKnapsack; i > 0; i--)
		{
			if (knapsackTable[i][j] != 0 && knapsackTable[i][j] != knapsackTable[i-1][j])
			{
				System.out.println("We take item: #" + i);
				j = j - quantity[i];
			}
		}
	}
}
