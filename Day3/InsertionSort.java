//Insertion sort
import java.util.*;
public class InsertionSort{
    public static void Insertion(int[] employeeIds){
        int n=employeeIds.length;
        for(int i=1;i<n;i++){
            int temp=employeeIds[i];
            int j=i-1;
            while(j>=0 && temp<employeeIds[j]){
                //shifting element
                employeeIds[j+1]=employeeIds[j];
                j--;
                
            }
            //puting temp variable to its right place
            employeeIds[j+1]=temp;
        }
    }
    public static void main(String[] args){
        int[] employeeIds={8,4,1,5,9,2};

        System.out.println("Employee ID before sorting: ");
        for(int i=0;i<employeeIds.length;i++){
            System.out.print(employeeIds[i]+ " ");
        }

        Insertion(employeeIds);
        System.out.println("\nEmployee ID after sorting: ");
        for(int j=0;j<employeeIds.length;j++){
            System.out.print(employeeIds[j]+ " ");
        }
    }
}
