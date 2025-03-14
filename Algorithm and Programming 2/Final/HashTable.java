package algoFinalExam;

import java.util.LinkedList;

public class HashTable {
  
    private LinkedList<String>[] hashArray;
    private static final int SIZE = 10;

    public HashTable() { 
        hashArray = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++)
            hashArray[i] = new LinkedList<>();
    }

    private int computeHash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += s.charAt(i);
        }
        return hash % SIZE;
    }

    public boolean containsString(String target) {
        int hash = computeHash(target);
        LinkedList<String> list = hashArray[hash];
        if (list.contains(target))
            return true;
        return false;
    }

    public void put(String s) {
        int hash = computeHash(s);
        LinkedList<String> list = hashArray[hash];
        if (!list.contains(s)) {
            list.addFirst(s);
        }
    }

    public boolean delete(String item) { // first calculate hash value of item to be deleted, and checks whether this item exists in the linked list..
       
    	int hash = computeHash(item);
        LinkedList<String> list = hashArray[hash];
        
        if (list.contains(item)) {
        	
            list.remove(item); 
            return true;
        }
        return false; 
    }

    public void printHashTable() {
    	
        for (int i = 0; i < SIZE; i++) {
            LinkedList<String> list = hashArray[i];
            
            if (!list.isEmpty()) {
            	
                System.out.print("Index " + i + ": "); 
                
                for (String item : list) {
                	
                    System.out.print(item + " "); 
                }
                
                System.out.println();
            }
        }
    }
}
