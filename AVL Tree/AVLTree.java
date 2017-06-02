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

		String key;
		String value;
		AVLNode left;
		AVLNode right;
		
      int height;
			
		// constructs an AVL node with key, value and height attributes
      private AVLNode(String key, String val, int height, AVLNode left, AVLNode right) {
         this.key = key;
         this.value = val;
         this.height = height;
         this.left = left;
         this.right = right;
      }
      
      // constructs a leaf AVL node
      private AVLNode(String key, String val, int height) {
         this(key, val, height, null, null);
      }     
	}
	
	//Use this variable as your root
	private AVLNode root;
	private int size;
   
   // constructs an empty AVL tree
   public AVLTree() {
      this.root = null;
      this.size = 0;
   }
	
   // removes all elements in an AVL tree
	public void makeEmpty() {
      this.root = null;
      this.size = 0;
	}
	
   // returns the number of elements currently in the tree
	public int size() {
		return this.size;
	}
   
   // inserts a key, value pair into the AVL tree using the self-balancing
   // AVL property
   // throws IllegalArgumentException if a duplicate key is inserted
   public void insert(String key, String value) {
      root = insert(key, value, root);
   }
   
   // helper method returning an AVL node and performing the rotations 
   // neccessary after a node is inserted into the tree
	private AVLNode insert(String key, String value, AVLNode root) {
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
      // left left case
      if (balanceNum > 1 && key.compareTo(root.left.key) < 0) {
         root = rightRotation(root);
      } 
      // left right case
      if (balanceNum > 1 && key.compareTo(root.left.key) > 0) { 
         root.left = leftRotation(root.left);
         root = rightRotation(root);
      }
      // right right case
      if (balanceNum < -1 && key.compareTo(root.right.key) > 0) {
         root = leftRotation(root);
      }
      // right left case
      if (balanceNum < -1 && key.compareTo(root.right.key) < 0) {
         root.right = rightRotation(root.right);
         root = leftRotation(root);
      } 
      return root;
	}
   
   // returns the height of a single node
   private int height(AVLNode node) {
      if (node == null) {
         return 0;
      }
      return node.height;
   }
   
   // returns the difference in heights of a node's left and right subtrees
   private int balance(AVLNode node) {
      if (node == null) {
         return 0;
      }
      return height(node.left) - height(node.right);
   }
   
   // performs a left rotation
   private AVLNode leftRotation(AVLNode r) {
      AVLNode pivot = r.right;
      r.right = pivot.left;
      pivot.left = r;
      
      // update heights
      r.height = Math.max(height(r.left), height(r.right)) + 1;
      pivot.height = Math.max(height(pivot.right), r.height) + 1;
      return pivot;
   }
   
   // performs a right rotation
   private AVLNode rightRotation(AVLNode l) {
      AVLNode pivot = l.left;
      l.left = pivot.right;
      pivot.right = l;
      
      // update heights
      l.height = Math.max(height(l.left), height(l.right)) + 1;
      pivot.height = Math.max(height(pivot.left), l.height) + 1;
      return pivot;
   }   
   
   // returns the value affiliated with the String key
   // throws an ObjectNotFoundException if the key is not in the AVLTree
	public String find(String key) {
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
   
   // returns a BFSIterator 
	public Iterator<String> getBFSIterator() {
      BFSIterator iterator = new BFSIterator(root);
		return iterator;
	}
	
   // BFSIterator class for Strings with functionality for returning the 
   // next key of a node in a BFS node or a boolean if the next key exists
	private class BFSIterator implements Iterator<String>{
   
      private Queue<AVLNode> queue; 
      private Queue<String> queue2;
      
      // constructs a BFSIterator 
      public BFSIterator(AVLNode root) {
         if (root != null) {
            queue = new LinkedList<AVLNode>();
            queue2 = new LinkedList<String>();
            queue.add(root);
         }
         while (!queue.isEmpty()) {
            AVLNode n = queue.remove();
            queue2.add(n.key);
            if (n.left != null) {
               queue.add(n.left);
            }
            if (n.right != null) {
               queue.add(n.right);
            }
         }
      }
		
      // returns true if the iterator has another value to return
		public boolean hasNext() {
			return !queue2.isEmpty();
		}
      
      // returns the next value in a BFS traversal of the tree
      // starts at the root and iterates through left children before right
		public String next() {
// 			if (hasNext()) {
//             while (!queue.isEmpty()) {
//                AVLNode node = queue.remove();
//                if (node.left != null) {
//                   queue.add(node.left);
//                } 
//                if (node.right != null) {
//                   queue.add(node.right);
//                }
//                return node.value;
//             }
//          }
         if (hasNext()) {
            return queue2.remove();
         }
         return null;
		}   
	}
}
