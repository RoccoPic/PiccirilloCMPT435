//Assignment01
//Rocco Piccirillo
//Stack

public class Stack 
{
	
	Node head;
	//pushes the newly created node ontop of the stack
	public void push(char data)
	{
		Node node = new Node();
		node.data = data;
		node.next = null;
		node.next = head;
		head = node;
	}
		
	//changes the address of the head and removes it
	public Node pop() 
	{
		Node node;
		node = head;
		head = head.next;
		return node;	
	}
	
	//prints outs all the node.data from the stack
	public void display() 
	{
		Node node = head;
		while(node.next != null)
		{
			System.out.println(node.data);
			node = node.next;
		}
		System.out.print(node.data);
	}
	
	//prints the top of the stack
	public Node peek()
	{
		Node node;
		node = head;
		System.out.print(node.data);
		return head;
	}
}
