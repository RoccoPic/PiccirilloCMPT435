import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTree 
{

	//sets an initial root
	BinaryNode root;

	public void addNode(int key, String name) 
	{
		//creates a new BinaryNode and sets it up
		BinaryNode newNode = new BinaryNode(key, name);
		
		//if there is no existing root, the first added becomes the root
		if (root == null) 
		{
			root = newNode;
		} else 
		{
			// Set root as the BinaryNode we will start
			// with as we traverse the tree
			BinaryNode focusNode = root;

			//creates a parent for our newly created binary node
			BinaryNode parent;
			//sets an infinite loop
			while (true) 
			{
				//root is the initial parent so we begin there
				parent = focusNode;
				
			//depending on if the key is less than the focused node
			//we decide to move left or right
			//this key is less than the current Node so we move to the left
				if(key < focusNode.key) 
				{
					//we then switch our focus on the left child
					focusNode = focusNode.leftChild;

					//once we reach the bottom left when their are no children
					if (focusNode == null) 
					{
						//we place the newly added, smaller node as a child
						parent.leftChild = newNode;
						//we can now exit, since our node was added successfully
						return; 
					}

					//this key is greater than the current Node so we move to the right
				} else if(key > focusNode.key)
				{ 
					//we move our focus to the rightmost child
					focusNode = focusNode.rightChild;
					
					//if the right doesn't have any children
					if (focusNode == null) 
					{
						//we place a new node to the right of it
						parent.rightChild = newNode;
						//we can now exit, since our node was successfully added
						return;
					}
				}
			}
		}
	}

	//the nodes get printed in ascending order
	//we use recursion to go to one and then its childs and back n forth
	public void inOrderTraverseTree(BinaryNode focusNode) 
	{
		if (focusNode != null) 
		{
			//traverse the leftmost node, recall function
			inOrderTraverseTree(focusNode.leftChild);

			//depending on which node we are on, we print
			System.out.println(focusNode);

			//traverse the right most node, recall function
			inOrderTraverseTree(focusNode.rightChild);
		}
	}

	//finds a specific node depending on the key given
	public BinaryNode findNode(int key) 
	{
		//we begin at the top of the tree
		BinaryNode focusNode = root;

		//while the focused key has not been found
		while (focusNode.key != key) 
		{
			//if the key is less than we move down to the left
			if (key < focusNode.key) 
			{
				//we move our focus towards the left child
				focusNode = focusNode.leftChild;

			//if the key is greater than we move down to the right
			} else if (key > focusNode.key)
			{
				//we move our focus over to the rightmost child
				focusNode = focusNode.rightChild;
			//this only gets called if we absolutely cannot find the key
			} if (focusNode == null) 
			{
				return null;
			}				
		}
		//once found, we return the searched for node
		return focusNode;
	}

	//finds how many searches it takes to get to the current node
	public int findNodeCounter(int key) 
	{
		//sets a counter value that we return once found
		int counter = 0;
		
		//sets the root of the tree
		BinaryNode focusNode = root;
		
		//since the key hasn't been found yet, we keep looking
		while (focusNode.key != key) 
		{
			//if the key is less we look left
			if (key < focusNode.key) 
			{
			//since we're doing a compare we increase the counter
			counter++;
			//we begin to move lower left
			focusNode = focusNode.leftChild;

			} else 
			{
			//since we're doing a compare we increase the counter
			counter++;
			//we begin to move lower right
			focusNode = focusNode.rightChild;
			//if the node isn't found we return the size of the tree
			}if (focusNode == null)
			{
			return counter;
			}
		}
		//once it has been found, we break out of the while
		//and return the amount of searches that went on
		return counter;
	}
		
	public static void main(String[] args) throws FileNotFoundException 
	{

		BinaryTree theTree = new BinaryTree();
		
		//the scanner is storing the magicitems.txt file temporarily
		Scanner scanner = new Scanner(new File("magicitems"));
		//made to actually store the magic items
		ArrayList<String> wordList = new ArrayList<String>();
		
		//while there is still another line of text more keeps getting added
		while(scanner.hasNextLine()) 
		{
			wordList.add(scanner.nextLine());
		}

		//creates a new arrayList to store our random items
		ArrayList<String> randList = new ArrayList<String>();

			
		//adds all strings from the wordList to the binary tree with their own indexes
		 for(int i = 0; i < wordList.size(); i++)
		 {
			 theTree.addNode(i, wordList.get(i));			
		 }
		 
			//while the size of the randList is less than 42
			while (randList.size() < 42) 
			{
				//a random Index of wordList will be selected
			    int randIndex = (int) (Math.random()*(wordList.size()-1));
			    
			    if (randList.indexOf(randIndex) == -1) 
			    {
			    	//adds to the randList so that we eventually get to size 
			       randList.add(wordList.get(randIndex));
			    	System.out.println(wordList.get(randIndex) + " was found after " + theTree.findNodeCounter(randIndex) + " comparisons");
			    }
			}
			
	}

}