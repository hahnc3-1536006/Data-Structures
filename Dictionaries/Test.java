import java.util.Random;
public abstract class Test {

	public static void main(String[] args) {
   
         Random rand = new Random();
         int[] storage = new int[10000];
         for (int i = 0; i < 10000; i++) {
            storage[i] = rand.nextInt(10000);
         }
//          test1(new SADict(), storage);
//          test2(new SADict(), storage);  
//          test3(new SADict(), storage);
//          test4(new SADict(), storage);
//          test5(new SADict(), storage);
//          test6(new UADict(), storage);
//          test7(new UADict(), storage);
//          test8(new UADict(), storage);
//          test9(new UADict(), storage);
//          test10(new UADict(), storage);
//          test11(new ULLDict(), storage);
//          test12(new ULLDict(), storage);
//          test13(new ULLDict(), storage);
//          test14(new ULLDict(), storage);
//          test15(new ULLDict(), storage);
//          test16(new SLLDict(), storage);
//          test17(new SLLDict(), storage);
//          test18(new SLLDict(), storage);
//          test19(new SLLDict(), storage);
//          test20(new SLLDict(), storage);
//          test21(new BSTDict(), storage);
//          test22(new BSTDict(), storage);
//          test23(new BSTDict(), storage);
//          test24(new BSTDict(), storage);
//          test25(new BSTDict(), storage);
           test26(new BSTDict());
           test27(new BSTDict());
         //test40(new SLLDict());
         //test51(new SADict());
         //testBST(new BSTDict());
   }
   
   private static void test1(SADict dictionary, int[] storage) {    
      for (int i = 0; i < 10; i++) {
         dictionary.insert(storage[i], "a");
      }
      long startTime = System.currentTimeMillis();
      for (int i = 10; i > 0; i++) {
         dictionary.delete(i);
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
   
   private static void test2(SADict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 100; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
   
   private static void test3(SADict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 1000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
   
   private static void test4(SADict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 5000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }

   private static void test5(SADict dictionary, int[] storage) {    
      for (int i = 0; i < 10000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long startTime = System.currentTimeMillis();
      for (int i = 9999; i >= 0; i++) {
         dictionary.delete(i);
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }

   private static void test6(UADict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 10; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }

   private static void test7(UADict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 100; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
 
   private static void test8(UADict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 1000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
   
   private static void test9(UADict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 5000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
   
   private static void test10(UADict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 10000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   } 

   private static void test11(ULLDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 10; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
   
   private static void test12(ULLDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 100; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
   
   private static void test13(ULLDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 1000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
   
   private static void test14(ULLDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 5000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
   
   private static void test15(ULLDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 10000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
 
   private static void test16(SLLDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 10; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
 
   private static void test17(SLLDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 100; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
 
   private static void test18(SLLDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 1000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
 
   private static void test19(SLLDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();    
      for (int i = 0; i < 5000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
 
   private static void test20(SLLDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();   
      for (int i = 0; i < 10000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
  
   private static void test21(BSTDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();   
      for (int i = 0; i < 10; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
     
   private static void test22(BSTDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();   
      for (int i = 0; i < 100; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
     
   private static void test23(BSTDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();   
      for (int i = 0; i < 1000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
   
   private static void test24(BSTDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();   
      for (int i = 0; i < 5000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }  
     
   private static void test25(BSTDict dictionary, int[] storage) { 
      long startTime = System.currentTimeMillis();   
      for (int i = 0; i < 10000; i++) {
         dictionary.insert(storage[i], "a");
      }
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);      
   }
   
   private static void test26(BSTDict dictionary) {
      dictionary.insert(1, "a");
      long startTime = System.currentTimeMillis(); 
      dictionary.find(1);
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);       
   }
   
   private static void test27(BSTDict dictionary) {    
      for (int i = 0; i < 1000000; i++) {
         dictionary.insert(i, "a");        
      }
      long startTime = System.currentTimeMillis();  
      dictionary.find(999999);
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      System.out.println(totalTime);
   }  
   
   private static void test50(ULLDict dictionary) {
      dictionary.insert(4, "a");
      dictionary.insert(2, "b");
      dictionary.insert(3, "c");
      dictionary.insert(8, "d");
      dictionary.insert(1, "e");
      dictionary.delete(4);
      dictionary.delete(11);
      String find = dictionary.find(1);
      System.out.println(find);
      
   }
   
   private static void test51(SADict dictionary) {
      dictionary.insert(1, "a");
      dictionary.insert(2, "b");
      dictionary.insert(4, "d");
      dictionary.insert(3, "c");
      dictionary.insert(9, "i");
      dictionary.insert(6, "f");
      dictionary.insert(11, "x");
      dictionary.insert(20, "u");
      dictionary.insert(12, "v");
      dictionary.delete(11);
      dictionary.delete(25);
      String s1 = dictionary.find(2);
      System.out.println(s1);
   }
   
   private static void test40(SLLDict dictionary) {
      dictionary.insert(8, "i");
      dictionary.insert(2, "s");
      dictionary.insert(4, "v");
      dictionary.insert(3, "r");
      dictionary.insert(9, "n");
      dictionary.insert(6, "f");
      dictionary.insert(11, "u");
      dictionary.insert(20, "q");
      dictionary.insert(12, "d");
      dictionary.insert(35, "s");
      dictionary.insert(70, "b");
      dictionary.insert(54, "h");
      dictionary.insert(80, "t");
      dictionary.insert(1, "a");
      dictionary.delete(6);
      dictionary.delete(8);
      String s1 = dictionary.find(54);
      System.out.println(s1);
   }  
   
   private static void testBST(BSTDict dictionary) {
      dictionary.insert(7, "a");
      dictionary.insert(5, "b");
      dictionary.insert(9, "c");
      dictionary.insert(3, "d");
      dictionary.insert(6, "e");
      dictionary.insert(1, "f");
      boolean r = dictionary.delete(5);
      String s = dictionary.find(3);
      System.out.println(r);
      System.out.println(s);
   }    
}