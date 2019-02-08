//Rocco Piccirillo
//Assignment 01
//LinkedList

public class Link 
{
	
	public static void main(String[] args) 
	{
		
		LinkList myHouse = new LinkList();
		
		myHouse.insertNewLink("Rocco", "A3");
		myHouse.insertNewLink("Dave", "A3");
		myHouse.insertNewLink("Alex", "B3");
		myHouse.insertNewLink("Kyle", "B3");
		myHouse.insertNewLink("Josh", "C3");
		myHouse.insertNewLink("Oliver", "C3");
		myHouse.insertNewLink("Zach", "D3");
		myHouse.insertNewLink("Brenden", "D3");
		
		myHouse.display();
	}
	
	//my list includes my housemates and I
	public String houseMate;
	//and the room they live in 
	public String roomNum;
	
	//references the next link in the link list
	public Link next;
	
	
	//constructor to assign names, and room numbers
	public Link(String houseMate, String roomNum) 
	{
		
		this.houseMate = houseMate;
		this.roomNum = roomNum;
	}
	
	//provides the information for my housemates
	public void display() 
	{
		
		System.out.println(houseMate + " lives in room " + roomNum);
	}
	
	//when called, return whichever housemates name
	public String toString()
	{
		
		return houseMate;
		//return roomNum;
	}
	
	
}

class LinkList
{
	
	//the head
	public Link firstLink;
	
	LinkList() 
	{
		//firstLink always starts as null when you make a linked list
		firstLink = null;
	}
	

	
	
	//this is how to add a new head
	public void insertNewLink(String houseMate, String roomNum)
	{
		
		Link newLink = new Link(houseMate, roomNum);
		
		newLink.next = firstLink;
		
		firstLink = newLink; 
	}
	
	

	//how to cycle through all the links
	public void display()
	{
		Link theLink = firstLink;
		
		while(theLink != null) 
		{
			
			theLink.display();
			
			System.out.println("Next Link: " + theLink.next + "\n");
			
			theLink = theLink.next;
			
		}
	}
	
	
}


