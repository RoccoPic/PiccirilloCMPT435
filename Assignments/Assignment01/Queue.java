
public class Queue {

	LinkedList queue = new LinkedList();
	public int size;
	Node head;
	Node tail;
	
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
	
	public Node deQueue()
	{
		Node node;
		node = head;
		head = head.next;
		return node;
	}
	
	
	public int getSize()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return getSize() == 0;
	}
	
	
	public void show()
	{
		queue.show();
	}
	
	public Node peek()
	{
		return queue.peek();
	}
}
