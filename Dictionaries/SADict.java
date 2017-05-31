// Christian Hahn
// TA: James Wang
// CSE 373 Section AF
// 4/19/2017
// A sorted array class which implements a dictionary that contains basic
// functions such as find, delete, and insert

public class SADict implements Dictionary {

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
   
   // constructs a sorted array with default size 10
   public SADict() {
      this.array = new PairedData[10];
      this.size = 0;
   } 
   
   // inserts a key, value pair into the array
	public void insert(int key, String value) {
		// TODO implement insert
      if (size == array.length - 1) {
         resize();
      }
      if (size == 0) {
         array[0] = new PairedData(key, value);
      } else {
         int i = indexSearchForInsert(key);
         int j = size;
         while(j > i) {
            array[j] = array[j - 1];
            j--;
         }
         array[i] = new PairedData(key, value);
      }
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
   
   // finds an item using the key in the array
   public String find(int key) {
      int index = indexOf(key);
      if (index != -1) {
         return array[index].value;
      }
      return null;
   }
   
   // finds index in the array using a key
   private int indexOf(int key) {
      int low = 0;
      int high = size - 1;
      int mid;
      while(low <= high) {
         mid = (low + high) / 2;
         if (array[mid].key == key) {
            return mid;
         } else if (array[mid].key < key) {
            low = mid + 1;
         } else {
            high = mid - 1;
         }
      }
		return -1;
	}
   
   private int indexSearchForInsert(int key) {
      int low = 0;
      int high = size - 1;
      int mid = 0;
      while(low <= high) {
         mid = (low + high) / 2;
         if (array[mid].key == key) {
            break;
         } else if (array[mid].key < key) {
            low = mid + 1;
         } else {
            high = mid - 1;
         }
      }
      if (array[mid].key < key) {
          return mid + 1;
      } else {
         return mid;
      }
	}

	public boolean delete(int key) {
		// TODO implement delete
      boolean result = false;
      int findIndex = indexOf(key);
      if (findIndex != -1) {
         result = true;
         for (int i = findIndex; i < size; i++) {
            array[i] = array[i + 1];
         }
         size--;
      }    
		return result;
	}
}
