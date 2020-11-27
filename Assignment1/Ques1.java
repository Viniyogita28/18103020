
import java.util.Scanner;

public class Ques1 {
    
    
    private boolean check_match(int[] char_array, int[] substr_array){
        for(int i=0;i<26;i++){
            if(char_array[i]!=substr_array[i]){
                return false;
            }
        }
        return true;
    }
    
    public int substringCount(String str, String subStr){
        if(str == null || str.length() < 1 || subStr == null || subStr.length() < 1)
            return 0;
        
        if(str.length() < subStr.length())
            return 0;
        
        int count=0;
        
            
        int[] substr_array = new int[26];
            
        for(int i=0;i<subStr.length();i++){
            substr_array[subStr.charAt(i)-'a']++;
        }
            
        int[] char_array = new int[26];
            
        for(int i=0;i<subStr.length();i++){
            char_array[str.charAt(i)-'a']++;    
        }
            
        if(check_match(char_array,substr_array)){
            count++;
        }
            
        for(int i=subStr.length();i<str.length();i++){
            char_array[str.charAt(i)-'a']++;
            char_array[str.charAt(i-subStr.length())-'a']--;
            if(check_match(char_array,substr_array)){
                count++;
            }
        }
    
        
        return count;
    }

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string:");
        String str = sc.nextLine();
        System.out.println("Enter sub-string:");
        String substr = sc.nextLine();
        
        Ques1 obj = new Ques1();
        int count = obj.substringCount(str.toLowerCase(), substr.toLowerCase());
        System.out.print("No. of substrings in the given string are ");
        System.out.println(count);
        
    }
    
}
