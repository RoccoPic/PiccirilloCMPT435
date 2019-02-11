
public class Queue {

	LinkedList queue = new LinkedList();
	public int size;
	Node head;
	Node tail;
	
	public void enQueue(String data)
	{
		queue.append(data);
		size = size +1;
	}
	
	public void deQueue()
	{
		//Node data = head;
		//head = head.next;
		//size = size -1;
		queue.delete();
		size = size -1;
	
	}
	
	
	public int getSize()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return getSize() == 0;
	}
	public void peek()
	{
		
	}
	
	public void show()
	{
		queue.show();
	}
}
