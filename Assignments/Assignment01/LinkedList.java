//Assignment01
//Rocco Piccirillo
//LinkedList

public class LinkedList 
{
	
	Node head; //refers to the first node
	
	//want to assign this data to a node
	//gets added at the end of the list
	public void append(char data) 
	{
		//creating a new node everytime you insert
		Node node = new Node();
		
		//whatever data i assign will be in that node
		node.data  = data;
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
	
	//this is premade for enQueue
	public void insertAtStart(char data) 
	{
		Node node = new Node();
		node.data = data;
		node.next = null;
		node.next = head;
		head = node;
		
	}
	//this is premade for my pop/deQueue
	//the head value is being replaced with the next value
	public Node delete() 
	{
		Node node;
		node = head;
		head = head.next;
		return node;
	}
	//prints out all of the values 
	public void show() 
	{
		Node node = head;
		
		while(node.next != null)
		{
			System.out.println(node.data);
			node = node.next;
		}
		System.out.print(node.data);
	}
	
	
}
