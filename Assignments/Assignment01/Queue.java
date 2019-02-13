//Assignment01
//Rocco Piccirillo
//Queue

public class Queue {

	Node head;
	
	//adds to the tail of the queue
	public void enQueue(char data)
	{
		
		Node node = new Node();
		node.data  = data;
		node.next = null;
		
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
	
	//removes from the front of the queue
	public Node deQueue()
	{
		Node node;
		node = head;
		head = head.next;
		return node;
	}
	
	//prints out all of the values of the queue
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
	
	//prints out the head node 
	public Node peek()
	{
		Node node;
		node = head;
		System.out.print(node.data);
		return head;
	}
}
