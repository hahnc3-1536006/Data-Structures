// Christian Hahn
// TA: James Wang
// CSE 373 Section AF
// 5/25/2017
// A representation of an AVL Tree that contains nodes comprised of string keys
// and values that self-balance using the AVL property.

import java.util.Iterator;
import java.util.*;

public class AVLTree implements StringTree{
	
	private class AVLNode{
		//Do not change these variable names
		String key;
		String value;
		AVLNode left;
		AVLNode right;
		
		//Place any additional fields you need here
      int height;
			
		//TODO implement the node class here
      private AVLNode(String key, String val, int height, AVLNode left, AVLNode right) {
         this.key = key;
         this.value = val;
         this.height = height;
         this.left = left;
         this.right = right;
      }

      private AVLNode(String key, String val, int height) {
         this(key, val, height, null, null);
      }     
	}
	
	//Use this variable as your root
	private AVLNode root;
	private int size;
	//You may use any additional fields here as you see fit
   
   public AVLTree() {
      this.root = null;
      this.size = 0;
   }
	
	public void makeEmpty() {
		// TODO Remove all elements from the AVL tree.
      this.root = null;
	}
	
	public int size() {
		// TODO Return the number of elements currently in the tree.
		return this.size;
	}
   
   public void insert(String key, String value) {
      root = insert(key, value, root);
   }

	private AVLNode insert(String key, String value, AVLNode root) {
		// TODO Insert the <key,value> pair into the AVLTree
		// Throw an IllegalArgumentException if the client attempts to insert a duplicate key
      if (root == null) {
         root = new AVLNode(key, value, 0);
         size++;
      } else if (key.compareTo(root.key) < 0) {
         root.left = insert(key, value, root.left);
      } else if (key.compareTo(root.key) > 0) {
         root.right = insert(key, value, root.right);
      } else { //duplicate key
         throw new IllegalArgumentException();
      }
      root.height = Math.max(height(root.left), height(root.right)) + 1;
      int balanceNum = balance(root);
      if (balanceNum > 1 && key.compareTo(root.left.key) < 0) {
         root = rightRotation(root);
      } 
      if (balanceNum > 1 && key.compareTo(root.left.key) > 0) { 
         root.left = leftRotation(root.left);
         root = rightRotation(root);
      }
      if (balanceNum < -1 && key.compareTo(root.right.key) > 0) {
         root = leftRotation(root);
      }
      if (balanceNum < -1 && key.compareTo(root.right.key) < 0) {
         root.right = rightRotation(root.right);
         root = leftRotation(root);
      } 
      return root;
	}
   
   private int height(AVLNode node) {
      if (node == null) {
         return 0;
      }
      return node.height;
   }
   
   private int balance(AVLNode node) {
      if (node == null) {
         return 0;
      }
      return height(node.left) - height(node.right);
   }
   
   private AVLNode leftRotation(AVLNode r) {
      AVLNode pivot = r.right;
      r.right = pivot.left;
      pivot.left = r;
      
      // update heights
      r.height = Math.max(height(r.left), height(r.right)) + 1;
      pivot.height = Math.max(height(pivot.right), r.height) + 1;
      return pivot;
   }
   
   private AVLNode rightRotation(AVLNode l) {
      AVLNode pivot = l.left;
      l.left = pivot.right;
      pivot.right = l;
      
      // update heights
      l.height = Math.max(height(l.left), height(l.right)) + 1;
      pivot.height = Math.max(height(pivot.left), l.height) + 1;
      return pivot;
   }   
   
	public String find(String key) {
		// TODO Return the value affiliated with the String key.
		// Throw an ObjectNotFoundException if the key is not in the AVLTree
      AVLNode current = root;
      while (current.key != key) {
         if (current.key.compareTo(key) < 0) {
            current = current.left; 
         } else {
            current = current.right;
         }
         if (current == null) {
            throw new NoSuchElementException();
         }
      }
	   return current.value;
	}

	public Iterator<String> getBFSIterator() {
		// TODO Only complete this section if you wish to attempt the 10 points EC
		// This function should return a BFSIterator: Starter code provided below
		return null;
	}
	
/*	Define your private Iterator class below.

	private class BFSIterator implements Iterator<String>{
		
		public boolean hasNext() {
			// TODO Return true if the iterator has another value to return
			return false;
		}

		public String next() {
			// TODO Return the next value in a BFS traversal of the tree
			// It should start at the root and iterate through left children before right
			return null;
		}
	
	}
*/


}
