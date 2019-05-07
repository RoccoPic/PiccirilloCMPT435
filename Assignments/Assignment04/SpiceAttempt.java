
public class SpiceAttempt 
{
	public static void main(String[] args)
	{
	int numOfItems = 21;//adds 1 bc we already set 0 as 0
	
	int capacityOfKnapsack = 19;
	
	int[] quantityOfSpice = new int[numOfItems + 1];
	int[] profitOfItems = new int[numOfItems + 1];
	
	for(int red = 1; red < 5; red++)
	{
		quantityOfSpice[red] = 1;
		profitOfItems[red] = 1;
	}
	for(int green = 5; green < 11; green++)
	{
		quantityOfSpice[green] = 1;
		profitOfItems[green] = 2;
	}
	for(int blue = 11; blue < 19; blue++)
	{
		quantityOfSpice[blue] = 1; 
		profitOfItems[blue] = 5; 
	}
	for(int green = 19; green < 21; green++)
	{
		quantityOfSpice[green] = 1; 
		profitOfItems[green] = 9; 
	}
	
	Knapsack knapsack = new Knapsack(numOfItems, capacityOfKnapsack, quantityOfSpice, profitOfItems);
	knapsack.fillSack();
	knapsack.showResult();
	}
}
