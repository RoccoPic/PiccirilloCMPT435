//Rocco Piccirillo
//Assignment04
//SpiceHeist

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpiceHeist
{
	//this is where we will perform the stealing of the spices
    public static void main(String[] args) throws FileNotFoundException 
    { 
	//this is how we are accessing our graphs text file
		Scanner scanner = new Scanner(new File("spice"));
	
		//initializes the two most important variables 
		//for actually filling the knapsack
		int numOfItems = 21;
		int capacityOfKnapsack = 1;
		
		int[] quantityOfSpice = new int[numOfItems + 1];
		int[] profitOfItems = new int[numOfItems + 1];
		
		Knapsack knapsack;
		
		int currentValue = 1;
		
		//while there is still another line of text we parse further
		while(scanner.hasNextLine()) 
		{
			//creates a string that accesses the current line 
			String currentLine = scanner.nextLine();
						
			//if there is no comment we continue to parse
			if(!currentLine.contains("--"))
			{
				if(currentLine.contains("spice"))
				{
				//once a spice is existent we add them all accordingly
				if(currentLine.contains("red"))
				{
					//char quantText = currentLine.charAt(currentLine.length()-2);
					//int quantValue = Character.getNumericValue(quantText);
					
					char priceText = currentLine.charAt(currentLine.length()-12);
					int priceValue  = Character.getNumericValue(priceText);
					
					//so for some reason whenever I used my quantValue int 
					//I seems to get an index out of bound exception 
					//and the only solution I found that works
					//was to throw a one where the quantity is 
					quantityOfSpice[currentValue] = 1;
					profitOfItems[currentValue] = priceValue;
					currentValue++;
				}
				//once a spice is existent we add them all accordingly
				else if(currentLine.contains("green"))
				{
					char quantText = currentLine.charAt(currentLine.length()-2);
					int quantValue = Character.getNumericValue(quantText);
					
					char priceText = currentLine.charAt(currentLine.length()-12);
					int priceValue  = Character.getNumericValue(priceText);
				
					quantityOfSpice[currentValue] = quantValue;
					profitOfItems[currentValue] = priceValue;
					currentValue++;
				}
				//once a spice is existent we add them all accordingly
				else if(currentLine.contains("blue"))
				{
					char quantText = currentLine.charAt(currentLine.length()-2);
					int quantValue = Character.getNumericValue(quantText);

					char priceText = currentLine.charAt(currentLine.length()-12);
					int priceValue  = Character.getNumericValue(priceText);
				
					quantityOfSpice[currentValue] = quantValue;
					profitOfItems[currentValue] = priceValue;
					currentValue++;
				}
				//once a spice is existent we add them all accordingly
				else if(currentLine.contains("orange"))
				{
					char quantText = currentLine.charAt(currentLine.length()-2);
					int quantValue = Character.getNumericValue(quantText);

					char priceText = currentLine.charAt(currentLine.length()-12);
					int priceValue  = Character.getNumericValue(priceText);
				
					quantityOfSpice[currentValue] = quantValue;
					profitOfItems[currentValue] = priceValue;
					currentValue++;
				}
				}
				//whenever the set capacity changes we reset the knapsack depending on
				//the new capacity, and refill the sack once again
				else if(currentLine.contains("capacity"))
				{
					if(currentLine.contains(" 1;"))
					{
						capacityOfKnapsack = 1;
						knapsack = new Knapsack(numOfItems, capacityOfKnapsack, quantityOfSpice, profitOfItems);						 
						knapsack.fillSack();
						System.out.println("For capactity 1 we have");
						knapsack.printOut();
					}
					else if(currentLine.contains("6"))
					{
						capacityOfKnapsack = 6;
						knapsack = new Knapsack(numOfItems, capacityOfKnapsack, quantityOfSpice, profitOfItems);
						knapsack.fillSack();
						System.out.println("For capactity 6 we have");
						knapsack.printOut();
					}
					else if(currentLine.contains("10"))
					{
						capacityOfKnapsack = 10;
						 knapsack = new Knapsack(numOfItems, capacityOfKnapsack, quantityOfSpice, profitOfItems);
						knapsack.fillSack();
						System.out.println("For capactity 10 we have");
						knapsack.printOut();
					}
					else if(currentLine.contains("20"))
					{
						capacityOfKnapsack = 20;
						 knapsack = new Knapsack(numOfItems, capacityOfKnapsack, quantityOfSpice, profitOfItems);
						knapsack.fillSack();
						System.out.println("For capactity 20 we have");
						knapsack.printOut();
					}
					else if(currentLine.contains("21"))
					{
						capacityOfKnapsack = 21;
						 knapsack = new Knapsack(numOfItems, capacityOfKnapsack, quantityOfSpice, profitOfItems);
						knapsack.fillSack();
						System.out.println("For capactity 21 we have");
						knapsack.printOut();
					}
				}
			}
		}
    }
}
			
			

    
