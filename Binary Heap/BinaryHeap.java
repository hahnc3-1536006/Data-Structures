// Christian Hahn
// TA: James Wang
// CSE 373 Section AF
// 4/9/17
// A BinaryHeap class that implements a PriorityQueue and has several methods
// to alter the queue such as inserting and deleteMin  

public class BinaryHeap implements PriorityQueue{

   // A private class of type HeapData that stores a data in the form of
   // a string and a priority in the form of an integer
	private class HeapData{
		private String data;
		private int priority;
		
      // constructs a HeapData with the given data and priority
		protected HeapData(String dat,int pri){   
			data = dat;
			priority = pri;
		}
		
      // changes the priority of a data in the heap
		protected void changePriority(int newPri){
			priority = newPri;
		}		
	}
	
	private HeapData[] heap; 
   
   private int size;
   
   // constructs a BinaryHeap with default length 10
	public BinaryHeap(){
      this(10);
	}
	
   // constrcuts a BinaryHeap with default length startArray
	public BinaryHeap(int startArray) {
      heap = new HeapData[startArray];
      size = 0;
	}
	
   // returns a boolean checking if the heap is empty
	public boolean isEmpty(){
		return size() == 0;
	}
	
   // returns the size of the heap
	public int size(){
		return size;
	}
	
   // returns the item of smallest priority in the heap and null
   // if the queue is empty
	public String findMin(){
      if (isEmpty()) {
         return null;
      }
		return heap[1].data;
	}
	
   // inserts a HeapData into the heap given a String data and int
   // priority
	public void insert(String data, int priority){
		// resizes if the heap length is reached
      if (size() + 1 == heap.length) {
         heap = resize();
      }
      heap[size + 1] = new HeapData(data, priority);
      size++;
      percolateUp(size);
	}
	
   // deletes the item in the heap of smallest priority and returns the
   // data in the item
   // returns null if the heap is empty
	public String deleteMin(){
      if (isEmpty()) {
         return null;
      }
      String result = findMin();
      // moves the node with lowest priority to top
      heap[1] = heap[size];
      heap[size] = null;
      size--;
      percolateDown(1);
		return result;
	}
	
   // removes all elements in the heap 
	public void makeEmpty(){
      this.heap = new HeapData[10];
      this.size = 0;
	}
	
   // changes the priority of a certain String in the heap given a String
   // and new priority and returns if the true if the String passed in is
   // contained in the heap
	public boolean changePriority(String data, int newPri){
      boolean found = false;
      int index = 0;
      int oldPriority = 0;
      for (int i = 1; i < size() + 1; i++) {
         if (heap[i].data.equals(data)) {
            oldPriority = heap[i].priority;
            heap[i].changePriority(newPri);
            found = true;
            index = i;
         }
      }
      if (oldPriority > heap[index].priority) {
         percolateUp(index);
      } else {
         percolateDown(index);
      }
		return found;
	}
   
   // resizes the array by creating a new heap double the size and copying 
   // over all the elements into the new array 
   private HeapData[] resize() {      
      HeapData[] newHeap = new HeapData[heap.length * 2];
      for (int i = 1; i <= size; i++) {
         newHeap[i] = heap[i];
      }
      return newHeap;
   }
   
   // swaps two HeapData items in the heap when passed in two indexes
   private void swapper(int index, int swappedIndex) {
     HeapData temp = heap[index];
     heap[index] = heap[swappedIndex];
     heap[swappedIndex] = temp;
   }
   
   // percolates newly inserted values up based on priority
   private void percolateUp(int index) {
      while (hasParent(index) && heap[index].priority 
             < heap[parentIndex(index)].priority) {
         swapper(index, parentIndex(index));
         index = parentIndex(index);
      }
   }
   
   // percolates values down when the min item in the priority is removed
   private void percolateDown(int index) {
      while(hasLeftChild(index)) {
         // finds smaller of two children
         int childIndex = leftChild(index);
         if (hasRightChild(index) && heap[rightChild(index)].priority <      
             heap[leftChild(index)].priority) {
            childIndex = rightChild(index);
         }
         if (heap[childIndex].priority < heap[index].priority) {
            swapper(index, childIndex);
         }
         index = childIndex;
      }
   }
   
   // returns whether the item has a left child
   private boolean hasLeftChild(int i) {
      return leftChild(i) <= size;
   }
   
   // returns the index of the left child
   private int leftChild(int i) {
      return 2 * i;
   }
   
   // returns whether the item has a right child
   private boolean hasRightChild(int i) {
      return rightChild(i) <= size;
   }
   
   // returns the index of the right child
   private int rightChild(int i) {
      return 2 * i + 1;
   }
   
   // returns the index of the parent
   private int parentIndex(int i) {
      return i / 2;
   }
   
   // returns whether the item has a parent
   private boolean hasParent(int i) {
      return i > 1;
   }
} 