
public class BinaryNode 
{
	public int key;
	public String name;

	BinaryNode leftChild;
	BinaryNode rightChild;

	BinaryNode(int key, String name) {

		this.key = key;
		this.name = name;

	}
	
	public String toString() 
	{

		return name + " has the key " + key;
	}
}
