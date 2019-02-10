
public class Runner {

	public static void main(String[] args) {
		
		LinkedList houseMates = new LinkedList();
		
		houseMates.append("Rocco");
		houseMates.append("Dave");
		houseMates.append("Kyle");
		houseMates.append("Alex");
		houseMates.append("Josh");
		houseMates.insertAtStart("Brenden");
		
		houseMates.insertAt(2, "Zach");
		
		houseMates.deleteAt(3);
		
		
		//houseMates.show();
	}
}
