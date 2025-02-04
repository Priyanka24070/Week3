import java.util.*;

public class ConcatenateString{
   public static String concatenate(String[] str){
    StringBuffer sb=new StringBuffer();//create StringBuffer to concatenate the String into Single String bracuse String immutable in nature
    for(String word:str){
        sb.append(word);
    }
    return sb.toString();//converrt StringBuffer to String
   }

    public static void main(String[] args){
        String[] str={" Hello ", "Capgemini! ", "I ", "am ", "Priyanka."};//create array of String

        String result=concatenate(str);//call method to cancatenate the Strings
        System.out.println("The new String is:" + result);
    }
}