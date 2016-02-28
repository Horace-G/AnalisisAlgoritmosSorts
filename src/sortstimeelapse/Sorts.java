/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortstimeelapse;

/**
 *
 * @author horacio
 */
public class Sorts {
    
    void BubbleSort( int [ ] num )
{
    
    long startTime = System.nanoTime();    
    
     int j;
     boolean flag = true;   // set flag to true to begin first pass
     int temp;   //holding variable

     while ( flag )
     {
            flag= false;    //set flag to false awaiting a possible swap
            for( j=0;  j < num.length -1;  j++ )
            {
                   if ( num[ j ] < num[j+1] )   // change to > for ascending sort
                   {
                           temp = num[ j ];                //swap elements
                           num[ j ] = num[ j+1 ];
                           num[ j+1 ] = temp;
                          flag = true;              //shows a swap occurred  
                  } 
            } 
      } 

    // ... the code being measured ...    
    long estimatedTime = System.nanoTime() - startTime; 
    
    System.out.println("Bubble Sort: Tiempo Sumado: " + estimatedTime + " nanosegundos");
     
}//end bubble sort 
    

	public void mergeSort(int [ ] a)
	{
                long startTime = System.nanoTime();  
		int [] tmp = new int[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
                
                long estimatedTime = System.nanoTime() - startTime; 
    
                System.out.println("Merge Sort: Tiempo Sumado: "+ estimatedTime +" nanosegundos");
	}


	private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}


    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left]< a[right])
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }//end merge sort
    
    public void insertionSort(int [] a){
        long startTime = System.nanoTime();  
        for(int i = 1; i < a.length; i++){
            int temp = a[i];
            int j;
            for(j = 1; j >= 0 && temp < a[j]; j--){
                a[j+1] = a[j];
                a[j+1] = temp;
            }
        }
        long estimatedTime = System.nanoTime() - startTime; 
    
        System.out.println("Insertion Sort: Tiempo Sumado: "+ estimatedTime +" nanosegundos");
    }//fin insertion sort
    
    int partition(int arr[], int left, int right)
{
      int i = left, j = right;
      int tmp;
      int pivot = arr[(left + right) / 2];
     
      while (i <= j) {
            while (arr[i] < pivot)
                  i++;
            while (arr[j] > pivot)
                  j--;
            if (i <= j) {
                  tmp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = tmp;
                  i++;
                  j--;
            }
      };
     
      return i;
}
 
public int [] quickSort(int [] array){
    long startTime = System.nanoTime();  
      int i = 0;
      while (i < array.length-1){
          for(int j = array.length-1; j>=0 ;j--){
              if( i == j){
                  i++;
                  j = array.length-1;
                  
                  if(i == array.length-1){
                      break;
                  }
                  
              }
              
                if(array[j] < array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    j = array.length-1;
                }              
          }
      }
      long estimatedTime = System.nanoTime() - startTime; 
    
        System.out.println("Quick Sort: Tiempo Sumado: "+ estimatedTime/1000000000 +" segundos");
      return array;
  }//end quicksort

public void selectionSort(int[] arr) {
    long startTime = System.nanoTime(); 
      int i, j, minIndex, tmp;
      int n = arr.length;
      for (i = 0; i < n - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < n; j++)
                  if (arr[j] < arr[minIndex])
                        minIndex = j;
            if (minIndex != i) {
                  tmp = arr[i];
                  arr[i] = arr[minIndex];
                  arr[minIndex] = tmp;
            }
      }
      
      long estimatedTime = System.nanoTime() - startTime; 
    
        System.out.println("Selection Sort: Tiempo Sumado: "+ estimatedTime +" nanosegundos");
      
}//end selectionSort

     public void radixSort(int[] input){
         long startTime = System.nanoTime(); 
        // Largest place for a 32-bit int is the 1 billion's place
        for(int place=1; place <= 1000000000; place *= 10){
            // Use counting sort at each digit's place
            input = countingSort(input, place);
        }

        long estimatedTime = System.nanoTime() - startTime; 
    
        System.out.println("Radix Sort: Tiempo Sumado: "+ estimatedTime +" nanosegundos");
    }

    private static int[] countingSort(int[] input, int place){
        int[] out = new int[input.length];

        int[] count = new int[10];

        for(int i=0; i < input.length; i++){
            int digit = getDigit(input[i], place);
            count[digit] += 1;
        }

        for(int i=1; i < count.length; i++){
            count[i] += count[i-1];
        }

        for(int i = input.length-1; i >= 0; i--){
            int digit = getDigit(input[i], place);

            out[count[digit]-1] = input[i];
            count[digit]--;
        }

        return out;

    }

    private static int getDigit(int value, int digitPlace){
        return ((value/digitPlace ) % 10);
    }
    
    
    public int [] heapSort(int [] array ){
        long startTime = System.nanoTime(); 
        int c = 0;
        for(int i = array.length -1; i>=0;i--){
            if(i == 0){
                if(c == 0){
                    break;
                }else{
                    i = array.length -1;
                    c = 0;
                }
            }
            
            if(1 % 2 == 0 || i == 0){
                if(array[i] < array[(i-2)/2]){
                    int temp = array[(i-2)/2];
                    array[(i-2)/2] = array[i];
                    array[i] = temp;
                    c++;
                }
            }else{
                if(array[i] < array[(i-1)/2]){
                    int temp = array[(i-1)/2];
                    array[(i-1)/2] = array[i];
                    array[i] = temp;
                    c++;
                }
            }
            
        }
        
        long estimatedTime = System.nanoTime() - startTime; 
    
        System.out.println("Heap Sort: Tiempo Sumado: "+ estimatedTime +" nanosegundos");
        return array;
        
    }

public void quickSort(int[] array, int low, int high) {
        if (array == null || array.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = array[middle];
        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // recursively sort two sub parts
        if (low < j) {
            quickSort(array, low, j);
        }
        if (high > i) {
            quickSort(array, i, high);
        }
        

        
    }
}
    

