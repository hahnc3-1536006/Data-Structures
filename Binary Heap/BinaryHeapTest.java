
public abstract class BinaryHeapTest {

	public static void main(String[] args) {
		// Use your tests here to make sure your implementation is working, this is for your help
		// Call your tests here to make sure that your implementation works.
		// This section will not be graded
      System.out.println(testEmpty(new BinaryHeap()));
      System.out.println(testOne(new BinaryHeap()));
      System.out.println(testMany(new BinaryHeap()));
	}
	
	//Make the below tests as thorough as possible.
	//Assume toTest is empty when the function is called
	//These will be tested against other implementations, both correct and incorrect, so be as thorough as you can
	//Only applicable functions need to be tested at each level.
	//Helper tests are strongly recommended
	
	public static boolean testEmpty(BinaryHeap toTest){
		//TODO write a test case that tests functionality for all of the functions applicable to a BinaryHeap when it is empty
		//toTest should be empty when it is called
		//You may find writing helper tests to be useful
		//This should return true if it passes your tests, false otherwise
      int size = toTest.size();
      String a1 = toTest.deleteMin();
      String a2 = toTest.findMin();
      return toTest.size() == 0 && a1 == null && a2 == null && toTest.isEmpty();
	}
	
	public static boolean testOne(BinaryHeap toTest){
		//TODO write a test case that tests functionality for all of the functions applicable to a BinaryHeap when it has one element
		//Add the element in this function, toTest should be empty when it is called.
		//You may find writing helper tests to be useful
		//This should return true if it passes your tests, false otherwise
      toTest.insert("a", 2);
      boolean size = (toTest.size() == 1);
      String one = toTest.findMin();
      toTest.deleteMin();
      toTest.insert("a", 2);
      boolean priority = toTest.changePriority("a", 1);
      toTest.makeEmpty();
      boolean empty = toTest.isEmpty();
		return size && one.equals("a") && empty && priority;
	}
	
	public static boolean testMany(BinaryHeap toTest){
		//TODO write a test case that tests functionality for all of the functions applicable to a BinaryHeap when it has many elements
		//Add the elements to the BinaryHeap in this function, toTest should be empty when it is called.
		//You may find writing helper tests to be useful
		//This should return true if it passes your tests, false otherwise
      insertAndChangePri(toTest);
      String a = toTest.findMin();
      boolean test1 = a.equals("a");
      deleteMultiple(toTest);
      boolean test2 = toTest.findMin().equals("c");
      boolean test3 = (toTest.size() == 10);
      toTest.makeEmpty();
      boolean test4 = toTest.isEmpty();
		return test1 && test2 && test3 && test4;
	}  
   
   private static void insertAndChangePri(BinaryHeap toTest) {
      toTest.insert("a", 12);
      toTest.insert("b", 2);
      toTest.insert("c", 3);
      toTest.insert("d", 8);
      toTest.insert("e", 7);
      toTest.insert("f", 6);
      toTest.insert("g", 5);
      toTest.insert("h", 4);
      toTest.insert("i", 2);
      toTest.insert("j", 50);
      toTest.insert("k", 13);
      toTest.insert("l", 14);
      toTest.insert("m", 10);
      toTest.changePriority("a", 1);
   }
   
   private static void deleteMultiple(BinaryHeap toTest) {
      toTest.deleteMin();
      toTest.deleteMin();
      toTest.deleteMin();     
   }
}
