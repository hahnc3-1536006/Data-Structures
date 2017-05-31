
public abstract class AVLTester {

	public static void main(String[] args) {
      AVLTree test = new AVLTree();
      
      test.insert("c", "1");
      test.insert("b", "2");
      test.insert("a", "3");
      test.insert("e", "4");
      test.insert("d", "5");
      test.insert("m", "6");
   }

	public static boolean verifyAVL(StringTree toTest){
		// TODO Return true if toTest is an AVL implementation of a String tree and false otherwise. 
		// All StringTree interface methods must behave correctly
		// You may assume that size() and isEmpty() return the correct values
		// Other than this, do not assume anything about the tree toTest, including its start size.
		return false;
	}
	
	// You may use as many static helper functions as you think are necessary
}
