
public class LinkedList 
{
	
	Node head; //refers to the first node
	
	//want to assign this data to a node
	//gets added at the end of the list
	public void append(String data) 
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
	
	public void insertAtStart(String data) 
	{
		Node node = new Node();
		node.data = data;
		node.next = null;
		node.next = head;
		head = node;
		
	}
	//this is being made so we can insert at any location
	public void insertAt(int index, String data) 
	{
		
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		//if we want to insert at the start this works as well
		if(index == 0)
		{
			insertAtStart(data);
		}
		else 
		{
		Node n = head;
		for(int i = 0; i < index; i++)
		{
			n = n.next;
		}
		node.next = n.next;
		n.next = node;
		}
	}
	
	public Node delete() {
		Node node;
		node = head;
		head = head.next;
		return node;
	}
	
	//not really deleting but changing the reference value for the
	//prior node
	public void deleteAt(int index) 
	{
		if(index == 0) 
		{
			head = head.next;
		} else
		{
			Node n = head;
			Node n1 = null;
			for(int i = 0; i < index; i++)
			{
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			//shows what we are doing
			//System.out.println("n1 " + n1.data);
			//now makes it eligible for garbage collection
			n1 = null;
		}
	}
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
	
	public boolean isEmpty()
	{
		return(head == null);
	}
	
	
}
