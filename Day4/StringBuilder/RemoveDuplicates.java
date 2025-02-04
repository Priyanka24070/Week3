import java.util.*;

public class RemoveDuplicates{
    public static String removeDupliacteschar(String str){
        StringBuilder sb=new StringBuilder();

        HashSet<Character> set=new HashSet<>();

        for(char ch:str.toCharArray()){
            if(!set.contains(ch)){
                sb.append(ch);
                set.add(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String: ");
        String str=sc.nextLine();

        String newstr=removeDupliacteschar(str);
        System.out.println("New String is: " + newstr);
    }
}