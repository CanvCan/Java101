package algoProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;

public class NodeList<T> implements Iterable<T> {    // doubly linked list class

    private static class Node<T> {      // node class
     
    	final T value;
        Node<T> next;
        Node<T> prev;

        private Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;

            next.prev = this;
            prev.next = this;
        }

        private Node() {
            value = null;
        }

		public T getValue() {  // no setter method  as it is the last variable
			return value;
		}
        
    }

    private final Comparator<T> comp;
    private  Node<T> head = new Node<>();
    private  Node<T> tail = new Node<>();

    public NodeList(Comparator<T> comp) {
        this.comp = comp;
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public boolean isEmpty() {
        return head.next.value == null;
    }

    public void insert(T value) {
    	
        for (Node<T> node = head; node.next != tail; node = node.next) {
        	
            if (comp.compare(value, node.next.value) < 0) {
            	
                new Node<T>(value, node.next, node);
                return;
                
            }
        }

        new Node<T>(value, tail, tail.prev);
    }
    
    public void printResearchedMovie(T value) {
    	
    	if(isEmpty()) {
    		System.out.println("List is empty !!!");
    	} else {
    		
    	  	for (Node<T> node = head.next; node != tail; node = node.next) {
        		if(node.value == value) {
        			System.out.println(value);
        			break;
        		}

        	}

    	}
    	
    }
    
    public void removeResearchedMovie(T value) {
    	
    	if(isEmpty()) {
    		System.out.println("List is empty !!!");
    	} else {
    		
    		for (Node<T> node = head.next; node != tail; node = node.next) {
        		if(node.value == value) {
        			node.prev.next = node.next;
        			node.next.prev = node.prev;
        			break;
        		}

        	}
    		
    	}
    	
    }
    
    public void saveToFile(String fileName) {
    	
        try {
        	
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            Node<T> current = head.next;
            
            while (current.next != null) {
            	
                writer.write(current.getValue().toString());
                writer.newLine();
                current = current.next;
                
            }
            
            writer.close();
            System.out.println("Data saved to file: " + fileName);
            
        } catch (IOException e) {
        	
            System.out.println("Error saving data to file: " + e.getMessage());
            
        }
    }
    
    public void printFromHead() {
    	
        if (isEmpty()) {
        	
            System.out.println("List is empty.");
            
        } else {
        	
            Node<T> current = head.next;
            
            while (current.next != null) {
            	
                System.out.println(current.getValue().toString());
                current = current.next;
                
            }
        }
    }
 
    public void printFromTail() {
    	
        if (isEmpty()) {
        	
            System.out.println("List is empty.");
            
        } else {
        	
            Node<T> current = tail.prev;
            
            while (current.prev != null) {
            	
                System.out.println(current.getValue().toString());
                current = current.prev;
                
            }
        }
    }
    
    public void printMoviesBeforeYear(int year) {
    	
        if (isEmpty()) {
        	
            System.out.println("List is empty.");
            
        } else {
        	
            Node<T> current = head.next;
            boolean penalty = true;
            
            while (current != null) {
            	
            	Movie movie = (Movie) current.getValue();
            	
                if (movie != null && movie.releaseDate < year) {
                	
                    System.out.println(current.getValue().toString());
                    penalty = false;
            }
                
            current = current.next;
            }
            
            if(penalty)
                System.out.println("No movies before " + year + " in inventory");
        }
    }

    @Override
    public Iterator<T> iterator() {
    	
        return new Iterator<T>() {
            Node<T> node = head.next;

            @Override
            public boolean hasNext() {
                return node != tail;
            }

            @Override
            public T next() {
                final T value = node.value;
                node = node.next;
                return value;
            }
        };
    }
    
}
