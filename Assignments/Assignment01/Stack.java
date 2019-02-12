
public class Stack 
{
	public Node head;
	
	LinkedList list = new LinkedList();

	
	public void push(char c)
	{
		
		/*Node n = new Node();
		n.next = list.head;
		list.head = n;
		n.data = c;*/
		list.insertAtStart(c);
		
	}
	
	public void pop() 
	{
			list.delete();
	}
	public void display() 
	{
		
		list.show();
	}
	
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
}
