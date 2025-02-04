import java.util.*;

public class ReverseString{
    public static String reverse(String str){
        StringBuilder sb= new StringBuilder(str);//creat a stringBuilder to reverse the String because String is immutable

        sb.reverse();//using inbuilt function reverse to reverse the String

        return sb.toString();//convert the StringBuilder to the original String
    }
   

    public static void main(String[] args){
     Scanner sc= new Scanner(System.in);
     System.out.println("Enter a string:");// take input from the user
     String str=sc.nextLine();//store input in String str

     String reversed=reverse(str);//call the method to reverse the string
     System.out.println("Rversed String is: " + reversed);//print the final output
    }
}