import java.util.*;

public class FirstNegativeNumber{
    public static int LinearSearch(int[] arr){
        int n=arr.length;
        //iterate all element of the array to check whether it is negative number or not
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                return i;
            }
        }
      return -1;
    }
    public static void main(String[] args){

       Scanner sc=new Scanner(System.in);
       int[] arr=new int[5];
       System.out.println("Enter 5 elements in the array:");
       for(int i=0;i<5;i++){
        arr[i]=sc.nextInt();
       }
        
        
        int result=LinearSearch(arr);// call the linear search method to find first negative number
        
        if(result!=-1){
            System.out.println("The first negative number present at the index: " + result);
        }
        else{
            System.out.println("Array doesn't contain negative number");
        }

    }
}