// Christian Hahn
// TA: James Wang
// CSE 373 Section AF
// 4/19/2017
// An unsorted array class which implements a dictionary that contains basic
// functions such as find, delete, and insert

public class UADict implements Dictionary {
   
   // paired data class with key and value
   private class PairedData {
      private int key;
      private String value;
      
      private PairedData(int num, String val) {
         key = num;
         value = val;
      }
   }
         
   private int size;
   private PairedData[] array;
   
   // constructs array with default size of 10
   public UADict() {
      this.array = new PairedData[10];
      this.size = 0;
   }
   
   // inserts a key, value pair into the array
	public void insert(int key, String value) {
      if (size == array.length - 1) {
         resize();
      }
      array[size] = new PairedData(key, value);
      size++;
	}
   
   // resizes array if it gets full
   private void resize() {
      PairedData[] newArray = new PairedData[array.length * 2];
      for (int i = 0; i < size; i++) {
         newArray[i] = array[i];
      }
      array = newArray;
   }
   
   // finds an item in the array using a key
	public String find(int key) {
      for (int i = 0; i < size; i++) {
         if (array[i].key == key) {
            return array[i].value;
         }
      }
		return null;
	}
   
   // deletes an item in the array
	public boolean delete(int key) {
      boolean result = false;
      int index = 0;
      for (int i = 0; i < size; i++) {
         if (array[i].key == key) {
            index = i;
            result = true;
         }
      }
      if (result) {
         for (int j = index; j < size; j++) {
            array[j] = array[j + 1];
         } 
         size--;
      }
      return result; 
	}

}
