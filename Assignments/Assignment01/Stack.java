public class Stack 
{
	public Node head;
	
	LinkedList list = new LinkedList();

	
	public void push(char data)
	{
	
			Node node = new Node();
			node.data = data;
			node.next = null;
			node.next = head;
			head = node;
			
		}
		
	
	
	public Node pop() 
	{
		Node node;
		node = head;
		head = head.next;
		return node;
		
		
	}
	public void display() 
	{
		
		list.show();
	}
	
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	public Node peek()
	{
		return list.peek();
		
	}
}
