package algoFinalExam;

import java.util.NoSuchElementException;
import java.util.Stack;


public class MyLinkedList {
	
	private Node head;
	private Node tail;
	
	public MyLinkedList() {
		head = tail = null;
	}
	
	
	private class Node {
		
		private String value;
	    private Node next;	
	    private Node prev;	

	    public Node() {
	    	value = null;
            next = null; 	
            prev = null;
	    }
	    
	    public Node(String value) {
	    	this.value = value;
	    }

		public String getValue() {
			return value;
		}

			
	}

    public void addToStart(String value) {
    	
    	Node newNode = new Node(value);
    	newNode.value = value;
    	newNode.next = head;
    	newNode.prev = null;
    	
    	if(head == null) {
    		tail = newNode; 		
    	} else {
    		head.prev = newNode;	
    	}	
    	head = newNode; 	
    	
    }
    
    public String getElement(int i) {
    	
    	if (i < 0) {
    		throw new IndexOutOfBoundsException("geçersiz indeks: " + i);	
    	}
    	
    	Node current = head;
    	int count = 0;
    	
    	while (current != null) {
    		
    		if (count == i)
    			return current.value;
    		
    		current = current.next;
        	count++;
    	}
    	
    	throw new IndexOutOfBoundsException("geçersiz indeks: " + i);
    	 
    }
    
    public Node removeHead() {
    	
    	if (head == null) {
            throw new NoSuchElementException("Cannot remove from empty list");
        }

        Node removedNode = head;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        removedNode.next = null;
        removedNode.prev = null;

        return removedNode;
    	 	
    }
    
    public Node removeLast() {
    	
    	 if (tail == null) {
             throw new NoSuchElementException("Cannot remove from empty list");
         }

         Node removedNode = tail;

         if (head == tail) {
             head = tail = null;
         } else {
             tail = tail.prev;
             tail.next = null;
         }

         removedNode.next = null;
         removedNode.prev = null;

         return removedNode;
         
    }
    
    public Node remove(int i) {
    	
    	if (i < 0) {
    		throw new IndexOutOfBoundsException("Unvalid index: " + i);
    		}
    	
        if (i == 0) {
    	   return removeHead();
    	    }
       
    	Node current = head;
    	int count = 0;
    	
    	while (current != null) {
    		
    		if (count == i) {
    			
    			Node removedNode = current;
    			current.prev.next = current.next;
    			
    			if (current.next != null) {
    				current.next.prev = current.prev;
    			} else {
    				tail = current.prev;
    				
    			}
    			
    			removedNode.next = null;
    			removedNode.prev = null;
    	
    			return removedNode;
    			
    		}
    		
    		current = current.next;
        	count++;
    	}

    	throw new IndexOutOfBoundsException("Unvalid index: " + i);
    }
    
    public void printOut() {
    	
    	if (isEmpty()) {
           	
            System.out.println("List is empty.");
            
        } else {
        	
            Node current = head;
            
            while (current != null) {
            	
                System.out.println(current.getValue());
                current = current.next;
                
            }
        }
    	
    }

    public boolean isEmpty() {
    	
    	return (head == null);
    	
    }


   public static void main(String[] args) {
	   
	   MyLinkedList list = new MyLinkedList();
	   list.addToStart("Fruit 5");
	   list.addToStart("Fruit 4");
	   list.addToStart("Fruit 3");
	   list.addToStart("Fruit 2");
	   list.addToStart("Fruit 1");
	   
	   list.remove(2);
	   list.printOut();
	   
	   System.out.println();
	   
	   Stack<String> stack = new Stack<>();
	   Node current = list.head;
	   
	   while (current != null) {
		   
		   stack.push(current.value);
		   current = current.next;  
	   }
	   
	   while(!stack.isEmpty()) {
		   
		   System.out.println(stack.pop());
	   }

	   
   }

}
