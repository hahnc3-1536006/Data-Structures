// Christian Hahn
// TA: James Wang
// CSE 373 Section AF
// 4/19/2017
// An unsorted linked list class which implements a dictionary that contains basic
// functions such as find, delete, and insert
public class ULLDict implements Dictionary {

   // private node class with key, value, and next pointer
	private class Node{

      Node next;
      int key;
      String value;
      
      Node(int key, String value, Node next) {
         this.key = key;
         this.value = value;
         this.next = next;
      }
      
      Node(int key, String value) {
         this(key, value, null);
      } 
	}
	
	private Node first;
	private Node last;
   private int size;
   
   // constructs a linked list using a front node
	public ULLDict(Node front) {
      this.first = front;
      this.last = front;
   }
   
   // constructs an empty linked list
   public ULLDict() {
      this(null);
   }
   
   // inserts a key, value pair in the linked list
	public void insert(int key, String value) {
      Node newNode = new Node(key, value);
		if (size == 0) {
         first = newNode;
      } else {
         last.next = newNode;
      }
      last = newNode;
      size++;    
	}
   
   // finds an item in the linked list using a key
	public String find(int key) {
      Node current = first;
      while(current != null) {
         if (current.key == key) {
            return current.value;
         }
         current = current.next;
      }
		return null;
	}

   // deletes a key, value pair in the linked list
	public boolean delete(int key) {
      if (size == 0) {
		   return false;
      }
      boolean result = false;
      if (size == 1) {
         if (first.key == key) {
            first = null;
            last = null;
            size--;
            result = true;
         }
      } else if (first.key == key) {
         first = first.next;
         size--;
         result = true;
      } else {
         Node current = first.next;
         Node prev = first;
         while(current != null && !result) {
            if (current.key == key) {
               prev.next = current.next;
               size--;
               result = true;
            } else {
               prev = prev.next;
               current = current.next;
            }
         }
      }
      return result;       
	}
}
