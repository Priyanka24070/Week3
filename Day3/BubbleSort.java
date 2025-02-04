//Bubble sort
/*import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j + 1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swaps were made, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] studentMarks = {78, 55, 89, 91, 42, 67, 88};

        System.out.println("Original Marks: " + Arrays.toString(studentMarks));
        bubbleSort(studentMarks);
        System.out.println("Sorted Marks: " + Arrays.toString(studentMarks));
    }
}*/

import java.util.*;

public class BubbleSort{
public static void BubbleSort(int[] marks){
    int n=marks.length-1;
    for(int i=0;i<=n;i++){
        for(int j=0;j<=n-1-1;j++){
            if(marks[j]<marks[j+1]){
                //swap marks when marks[j+1]>marks[j]
                int temp=marks[j];
                marks[j]=marks[j+1];
                marks[j+1]=temp;
            }
        }
    }

}


    public static void main(String[] args){
        int [] marks={80,56,34,67,12,};

        System.out.println("Before using Bubble Sort the marks are: ");
        for(int i=0;i<marks.length;i++){
            System.out.print(marks[i] + " ");
        }
       
        BubbleSort(marks);
        System.out.println("\nAfter using Bubble Sort the marks are: ");
        for(int i=0;i<marks.length;i++){
            System.out.print(marks[i] + " ");
        }
        
    }
}
