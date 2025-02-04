//Merge sort
import java.util.*;
public class MergeSort{
  public static void Conquer(int[] bookPrices,int si,int mid,int ei){
    int[] merged=new int[ei-si+1];//creating new array to store the element in the sorted array
    int idx1=si;
    int idx2=mid+1;
    int x=0;
    
    //putting element in the sorted form into the temp array
    while(idx1<=mid && idx2<=ei){
        if(bookPrices[idx1] <= bookPrices[idx2]){
            merged[x++]=bookPrices[idx1++];
        }
        else{
             merged[x++]=bookPrices[idx2++];
        }
    }

    while(idx1<=mid){
        merged[x++]=bookPrices[idx1++];
    }

    while(idx2<=ei){
        merged[x++]=bookPrices[idx2++];
    }  
    //copying all the element into original array from temporary array.
    int j=si;
    for(int i=0;i<merged.length;i++){
        bookPrices[j++]=merged[i];
    }  

  }

  public static void Divide(int[] bookPrices, int si, int ei){
    //base condition for recursion
    if(si>=ei){
        return;
    }
   
    int mid=si+ (ei-si)/2;//calculating mid element

    Divide(bookPrices,si,mid);//Dividing left part of the array untill it conatains only one element.
    Divide(bookPrices,mid+1,ei);//Dividing right part of the array untill it conatains only one element.

   Conquer(bookPrices,si,mid,ei);//merging the element 
  }

   public static void main(String[] args){
    int bookPrices[]={60,30,90,50,20,80};
    int n=bookPrices.length;

    System.out.println("Before swapping price are:");
    for(int i=0;i<n;i++){
        System.out.print(bookPrices[i] + " ");
    }
    //caling Divide method to divide the whole array.
    Divide(bookPrices,0,n-1);

    System.out.println("\nAfter swapping price are:");
    for(int i=0;i<n;i++){
        System.out.print(bookPrices[i] + " ");
    }
   }
}
