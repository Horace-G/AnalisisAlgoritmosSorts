/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortstimeelapse;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author horac
 */
public class SortsTimeElapse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //int Result = r.nextInt(High-Low) + Low;
        Random r = new Random();
        Sorts sorts = new Sorts();
        int [] numbers = new int[100000];
        // TODO code application logic here
        
        System.out.println("QUICK SORT: 100,000 Elementos: ");
    for(int j = 0; j<10; j++){
        System.out.print(j+".- : ");
        for(int i = 0 ; i < 100000 ; i++){
            int randomNumber = r.nextInt(100000 - 0) + 0;
            numbers[i] = randomNumber;
        }
        long startTime = System.nanoTime();
        sorts.quickSort(numbers, 0, numbers.length -1);
        //sorts.BubbleSort(numbers);
        //sorts.insertionSort(numbers);
        //sorts.selectionSort(numbers);
        //sorts.heapSort(numbers);
        //sorts.radixSort(numbers);
        //sorts.mergeSort(numbers);
        long stopTime = System.nanoTime();
        
        System.out.println("Heap Sort: Tiempo Sumado: "+ (stopTime - startTime) +" nanosegundos");
        
        System.out.println("");
        System.out.println("**************************************");
    }//fin for 10 corridas
        
    }
    
}
