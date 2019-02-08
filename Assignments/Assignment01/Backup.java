
public class Backup {
	//Rocco Piccirillo
	//Assignment 01

	/*public class Node 
	{
		String data;
		Node next;
		
	}

	/*
	//Rocco Piccirillo
	//Assignment 01

	public class Runner 

	{
		public static void main(String[] args) 
		{
			LinkedList list = new LinkedList();
			
			list.insert("Rocco");
			list.insert("Kyle");
			list.insert("Alex");
			list.insert("Josh");
			list.insert("Oliver");
			list.insert("Dave");
			list.insert("Brendan");
			list.insert("Zach");
			
			list.show();
			
			
		}
	}


	public class LinkedList 
	{
		Node head;
		
		public void insert(String data) 
		{
			Node node = new Node();
			node.data = data;
			
			if(head == null)
			{
				head = node;
			} 
			else 
			{
				Node n = head; 
				while(n.next != null)
				{
					n = n.next;
				}
				n.next = node;
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
			System.out.println(node.data);
		}
	}


	Link Stuff

	/*here to check if my linked list is empty
		public boolean isEmpty() {
			
			//this would mean that nobody has moved into the house yet
			return(firstLink == null);
		}*/

	/*
	//this is how to remove 
	public Link removeFirst(){
		
		Link linkReference = firstLink;
		
		if(!isEmpty()) {
			
			firstLink = firstLink.next;
			
		} else {
			
			System.out.println("Empty House");
		}
		
		return linkReference;
	}*/

	//how to find a specific houseMate
		/*public Link find(String houseMate) {
			
			Link theLink = firstLink;
			
			if(!isEmpty()) {
				
				while(theLink.houseMate != houseMate) {
					
					if(theLink.next == null) {
						
						return null;
						
					} else {
						
						theLink = theLink.next;
					}
				}
			} else {
				
				System.out.println("Empty LinkedList");
			}
			
			return theLink;
		}*/
}
