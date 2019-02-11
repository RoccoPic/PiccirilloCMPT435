
public class Stack 
{
	public Node head;
	
	LinkedList list = new LinkedList();

	
	public void push(String x)
	{
		
		Node n = new Node();
		n.next = list.head;
		list.head = n;
		n.data = x;
		
	}
	
	public String pop() 
	{
		
		String val = head.data;
		head = head.next;
		return val;
		
			//list.delete();
	}
	public void display() 
	{
		/*Node node = head;
		
		while(node.next != null)
		{
			System.out.println(node.data);
			node = node.next;
		}
		System.out.print(node.data);*/
		
		list.show();
	}
	
	
}
