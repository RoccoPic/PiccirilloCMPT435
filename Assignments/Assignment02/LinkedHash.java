
//creates my key, value, and next
public class LinkedHash
{
    String key;
    int value;
    LinkedHash next;
 
    /* Constructor */
    LinkedHash(String key, int value) 
    {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
 
//created a class for my HashTable
class HashTable
{
	//creates an int for size of the my hash
	//and creates my hash table
     int hashSize; 
     LinkedHash[] table;
 
     //set a constructor for my hashTable
    public HashTable(int ts) 
    {
    	//sets my hashTable size to limit it
        hashSize = 250;
        
        //calls my hashTable and gives it a size of 250
        table = new LinkedHash[hashSize];
       
    } 
   
    //this function was made to find the int value 
    //of whatever specified string
    public int get(String key) 
    {
    	//creates an int to store the index 
    	//of the selected key
        int hash = (myhash( key ) % hashSize);
        //if the the key doesn't exist, exit
        if (table[hash] == null)
            return -1;
        else 
        {
        	//checks the linkedList at hands value
        	//if that is not it, we move to the next
        	//once found, the value of the entry gets returned
            LinkedHash entry = table[hash];
            while (entry != null && !entry.key.equals(key))
            {
                entry = entry.next;
            }
            if (entry == null)
            {
                return -1;
            }
            else
            {
                return entry.value;
            }
        }
        
        
    }
    //this is the same as getting the string but instead 
    //returning the string back we return the number
    //of comparisons it takes to find our string
    public int getComparisons(String key)
    {
    	//counter made to count the compares and get
    	int counter = 0;
    	int hash = (myhash( key ) % hashSize);
        if (table[hash] == null)
            return -1;
        else 
        {
        	//adds a compare bc we are getting the LinkedList it is in
        	counter++;
            LinkedHash entry = table[hash];
            while (entry != null && !entry.key.equals(key))
            {
            	//adds another compare bc we have not yet found the string
            	counter++;
                entry = entry.next;
            }
            if (entry == null)
            {
                return -1;
            }
            else
            {
            	//once found, that means we compared one last time
            	counter++;
                return counter;
            }
        }
    }
  


   //this is my method for inserting a string and its own value
    //into the index
    public void insert(String key, int value) 
    {
        int hash = (myhash( key ) % hashSize);
        if (table[hash] == null)
            table[hash] = new LinkedHash(key, value);
        else 
        {
            LinkedHash entry = table[hash];
            while (entry.next != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry.key.equals(key))
                entry.value = value;
            else
                entry.next = new LinkedHash(key, value);
        }
    }
 
    //through using the ASCII value of each string, 
    //we assign to a specific value of the hash
    private int myhash(String str )
    {  
    	//sets string to upper case
        str = str.toUpperCase();
        //gets the length of the string
        int length = str.length();
        //sets a letter total int
        int letterTotal = 0;
       //Iterate over all letters in the string, totalling their ASCII values.
        for (int i = 0; i < length; i++)
        {
           char thisLetter = str.charAt(i);
           int thisValue = (int)thisLetter;
           letterTotal = letterTotal + thisValue;
        }

        // Scale letterTotal to fit in hashTableSize.
        int hashCode = (letterTotal * 1) % hashSize;  
        
        return hashCode;
    }
    
    //prints all of my hash table out for the user to view
    public void printHashTable()
    {
    	//traverses the whole hash
        for (int i = 0; i < hashSize; i++)
        {
        	//then prints out bucket # has X entries with their indexes
            System.out.print("\nBucket "+ (i + 1) +": ");
            LinkedHash entry = table[i];
            
            //when there are already entries, we chain
            while (entry != null)
            {
                System.out.print(entry.value +" ");
                entry = entry.next;
            }            
        }
    }
}
 
