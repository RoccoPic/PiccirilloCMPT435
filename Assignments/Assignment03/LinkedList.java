//Assignment03
//Rocco Piccirillo
//LinkedList

public class LinkedList 
{
	
	Node head; //refers to the first node
	
	//want to assign this data to a node
	//gets added at the end of the list
	public void append(int i) 
	{
		//creating a new node everytime you insert
		Node node = new Node();
		
		//whatever data i assign will be in that node
		node.data  = i;
		node.next = null;
		
		//if we are inserting our first object
		if(head == null) 
		{
			head = node;
			
		} else 
		{
			Node n = head;
			while(n.next != null)
			{
				n = n.next;
			}
			n.next = node;
		}
	}
	//prints out all of the values 
	public void show() 
	{
		Node node = head;
		
		try {
		while(node.next != null)
		{
			System.out.print(node.data + ", ");
			node = node.next;
		}
		System.out.print(node.data);
		}
	catch(Exception ex)
	{
		System.out.print("");
	}
	
	
	}
}
