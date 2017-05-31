// Christian Hahn
// TA: James Wang
// CSE 373 Section AF
// 4/19/2017
// A binary search tree class which implements a dictionary that contains basic
// functions such as find, delete, and insert

public class BSTDict implements Dictionary {

   // binary search tree node class with a key, value pair and left and 
   // right pointers
	private class BSTNode{

      private int key;
      private String value;
      private BSTNode left;
      private BSTNode right;
      

      private BSTNode(int data, String val, BSTNode left, BSTNode right) {
         this.key = data;
         this.value = val;
         this.left = left;
         this.right = right;
      }
      
      private BSTNode(int data, String val) {
         this(data, val, null, null);
      }
	}
	
	private BSTNode root;
   private boolean result;
   
   // constructs an empty BST 
   public BSTDict() {
      root = null;
      result = false;
   }
	
   // inserts a key, value in the tree
	public void insert(int key, String value) {
      if (root == null) {
         root = new BSTNode(key, value);
      } else {
         BSTNode current = root;
         while (current != null) {
            if (key <= current.key) {
               if (current.left == null) {
                  current.left = new BSTNode(key, value);
                  return;
               } else {
                  current = current.left;
               }
            } else {
               if (current.right == null) {
                  current.right = new BSTNode(key, value);
                  return;
               } else {
                  current = current.right;
               }
            }
         }
      }
	}
   
   // finds a key, value pair in the tree
	public String find(int key) {
      BSTNode current = root;
      while (current != null) {
         if (key == current.key) {
            return current.value;
         } else if (key < current.key) {
            current = current.left;
         } else {
            current = current.right;
         }
      }
		return null;
	}

   // deletes a key, value pair in the tree
	public boolean delete(int key) {
      root = deleteHelper(key, root);    
		return result;
	}
   
   // a helper method deleting a node using a key
   private BSTNode deleteHelper(int key, BSTNode current) {
      result = false;
      if (current != null) {
         if (key == current.key) {
            result = true;
            if (current.left == null && current.right == null) {
               current = null;
            } else if (current.left != null && current.right == null) {
               current = current.left;
            } else if (current.left == null && current.right != null) {
               current = current.right;
            } else { 
               BSTNode max = findMax(current.left);
               current.left = deleteHelper(max.key, current.left);
               max.left = current.left;
               max.right = current.right;
               current = max;                   
            }
         } else if (key < current.key) {
            current.left = deleteHelper(key, current.left);
         } else {
            current.right = deleteHelper(key, current.right);
         }
      }
      return current;            
   }
   
   // finds max item in the tree using BST property and current
   private BSTNode findMax(BSTNode current) {
      while(current.right != null) {
         current = current.right;
      }
      return current;
   }
}
