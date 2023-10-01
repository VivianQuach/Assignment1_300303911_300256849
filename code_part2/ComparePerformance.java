import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.Random; 

public class ComparePerformance{
    /*Compare the performance of ArrayList, Vector and ordinary arrays. 
    You should do a series of experiments where you do each of the following tests with the three types of collection, timing the execution of each run. 
    You should run each case several times on the same computer to obtain stable average timings.

    (a) Construct very large collections by putting random integers into each collection one at a time. The random integers should range in value from zero to nine. 
    You should make each collection large enough so that the run takes at least 10 seconds to add the integers in the case of an ArrayList. 
    You will have to do some initial experiments to find out what is a good size. You would use the same size of collection for ArrayList, Vector and the array. 
    The ArrayList and Vector can be created by successively adding items and allowing them to grow, while the array has to be created at its full size and then populated with its contents. 
    You could also try to experiment with the case where you do create the ArrayList and Vector initially with their full size.

    (b) Construct very large collections as in (a). Then use iterators to sum the elements. Subtract the construction time to get a measure of how much time the iteration takes.
    Use a for loop for the array, and an Iterator for the Vector and ArrayList. Present your data in suitable tables and draw conclusions from an analysis of the data. 
    From your conclusions, develop recommendations to designers.
    
    Creating object 
    - Large enought for 10 seconnds 
    - random values from 0-9 
    - 

    Testing 
    - With arraylist and vector at its full size 
    - Adding to the object 
    - different sizing 
    - Do mutliple testing and record it 
    

    - Use iterators to sum the elements for vector and arraylist 
    - use for loop to sum up the array list 

    */
    public static void main(String[] args){
        //Time Complexity of O(1)
        Random rand = new Random(); 
        

        int[] array = new int[50000000*5]; 
        //With capacity
        ArrayList<Integer> arrayList = new ArrayList<Integer>(50000000*5); 
        Vector<Integer> vector = new Vector<Integer>(50000000*5);
        //Without capacity
        /*
        ArrayList<Integer> arrayList = new ArrayList<Integer>(); 
        Vector<Integer> vector = new Vector<Integer>();
         */
    
        //testing Array, ArrayList, Vector with Full size 
        
            long start1 = System.currentTimeMillis();
            for(int i = 0; i < array.length; i++){
                array[i] = rand.nextInt(10); 
            }
            long end1 = System.currentTimeMillis();
            
            long start2 = System.currentTimeMillis();
            for(int i = 0; i < array.length; i++){
                arrayList.add(rand.nextInt(10));
            }
            long end2 = System.currentTimeMillis();
            
            long start3 = System.currentTimeMillis();
            for(int i = 0; i < array.length; i++){
                vector.add(rand.nextInt(10));
            }
            long end3 = System.currentTimeMillis();

            System.out.println("Creating the object of sepcfic size");
            System.out.println("Array: " + (end1 - start1) + "\nArrayList: " + (end2 - start2)  + "\nVector: " + (end3 - start3) );
            
           int sum = 0; 
            start1 = System.currentTimeMillis();
            for(int i = 0; i < array.length; i++){
                sum +=array[i];
            }
            end1 = System.currentTimeMillis();

            //Using For-Loop
            /*sum = 0; 
            start2 = System.currentTimeMillis();
            for(int i = 0; i < array.length; i++){
                sum += arrayList.get(i);
            }
            end2 = System.currentTimeMillis();*/

            //Iterators
            sum = 0;
            Iterator<Integer> liter1 = arrayList.iterator();
            start2 = System.currentTimeMillis();
            while(liter1.hasNext()){
                sum += liter1.next();
            }
            end2 = System.currentTimeMillis();

            //Using For-Loop
            /*sum = 0; 
            start3 = System.currentTimeMillis();
            for(int i = 0; i < array.length; i++){
                sum += vector.get(i);
            }
            end3 = System.currentTimeMillis();*/

            //Iterators
            sum = 0;
            Iterator<Integer> liter2 = vector.iterator();
            start3 = System.currentTimeMillis();
            while(liter2.hasNext()){
                sum += liter2.next();
            }
            end3 = System.currentTimeMillis();
            
            System.out.println("Adding to the instance variable: ");
            System.out.println("Array: " + (end1 - start1) + "\nArrayList: " + (end2 - start2)  + "\nVector: " + (end3 - start3));
        
    }

}