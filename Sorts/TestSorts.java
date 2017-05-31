import java.util.*;
import java.util.Comparator;


public abstract class TestSorts {

   public static void main(String[] args) {
      Integer[] array = {43, 10, 3, 5, -1, -1, 90, 39, 409, 2, 3, 0, 23, 542, 35, 13,
                5, 20};
      mergeSort(array);
      for (int i : array) {
         System.out.print(i + " ");
      }
   }
   
   public static void mergeSort(Integer[] array) {
      if (array.length != 1) {
         Integer[] left = leftPart(array);
         Integer[] right = rightPart(array);
         mergeSort(left);
         mergeSort(right);
         
         merge(array, left, right);
      }
      
   }
   
   private static Integer[] leftPart(Integer[] array) {
      Integer[] result = new Integer[(array.length + 1) / 2];
      for (int i = 0; i < (array.length + 1) / 2; i++) {
         result[i] = array[i];
      }
      return result;
   }
   
   private static Integer[] rightPart(Integer[] array) {
      int leftSize = (array.length + 1) / 2;
      int rightSize = array.length - leftSize;
      Integer[] result = new Integer[rightSize];
      for (int i = 0; i < rightSize; i++) {
         result[i] = array[leftSize + i];
      }
      return result;    
   }
   
   private static void merge(Integer[] array, 
                             Integer[] left, Integer[] right) {
      int leftIndex = 0;
      int rightIndex = 0;
      int index = 0;
      while (leftIndex < left.length && rightIndex < right.length) {
         if (left[leftIndex] <= right[rightIndex]) {
            array[index] = left[leftIndex];
            index++;
            leftIndex++; 
         } else {
            array[index] = right[rightIndex];
            index++;
            rightIndex++;
         }
      }
      while (leftIndex < left.length) {
         array[index] = left[leftIndex];
         index++;
         leftIndex++;
      } 
      while (rightIndex < right.length) {
         array[index] = right[rightIndex];
         index++;
         rightIndex++;
      }
   }
   
   public static void selectionSort(Integer[] array) {
      // TODO: Add your selection sort algorithm here.
      for (int i = 0; i < array.length - 1; i++) {
         for (int k = i + 1; k < array.length; k++) {
            if (array[k] < array[i]) {
               int temp = array[i];
               array[i] = array[k];
               array[k] = temp;
            }
         }
      }      
   }    
   
   public static void insertionSort(Integer[] array) {
      for (int outerIndex = 1; outerIndex < array.length; outerIndex++) {
         Integer currentInt = array[outerIndex];
         int innerIndex = outerIndex - 1;
         while (innerIndex >= 0
                 && currentInt < array[innerIndex]) {
            array[innerIndex + 1] = array[innerIndex];
            innerIndex--;
         }
         array[innerIndex + 1] = currentInt;
      }
   }              
}