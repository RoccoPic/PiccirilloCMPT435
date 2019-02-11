
public class Runner {

	public static void main(String[] args) {
		
		LinkedList houseMates = new LinkedList();
		
		houseMates.append("Rocco");
		houseMates.append("Dave");
		houseMates.append("Kyle");
		houseMates.insertAtStart("Josh");
		houseMates.insertAt(2, "Alex");
		houseMates.deleteAt(3);
		
		houseMates.delete();
		//houseMates.show();

		
	
		Stack nums = new Stack();
		
		nums.push("Rocco");
		nums.push("Todd");
		nums.push("Matt");
		nums.pop();
		nums.display();
		
	Queue q = new Queue();
		
		q.enQueue("Rocco");
		q.enQueue("James");
		q.enQueue("Piccirillo");
		q.deQueue();
		//System.out.println("Size " + q.getSize());
		//q.show();
	}
}
