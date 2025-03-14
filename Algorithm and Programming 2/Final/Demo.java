package algoFinalExam;

public class Demo {

   public static void main(String[] args) {
	   
        HashTable hashTable = new HashTable(); // generate new HashTable
        
        //Adding new items

		 hashTable.put("Ankara");
		 hashTable.put("London");
		 hashTable.put("Baku");
		 hashTable.put("Paris");
        
        System.out.println("Hash Table:");
        hashTable.printHashTable();

        String itemToBeDelete = "London";
        boolean isDelete = hashTable.delete(itemToBeDelete);
        
        if (isDelete) 
            System.out.println("\n" + itemToBeDelete + " is deleted from hash table.");
        else 
            System.out.println("\n" + itemToBeDelete + " is not found in hash table.");
        

        System.out.println("\nUpdated Hash Table:");
        hashTable.printHashTable();
    }
}
