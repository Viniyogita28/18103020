
import java.util.*;

public class Ques4 {
   
    public boolean areAnagrams(String str1, String str2){
        if(str1 == null || str2 == null || str1.length()!=str2.length())
            return false;
        
        Map<Character, Integer> str1_map = new HashMap<Character, Integer>();
        Map<Character, Integer> str2_map = new HashMap<Character, Integer>();
        
        for(int i=0;i<str1.length();i++){
        	if(str1_map.get(str1.charAt(i))!=null){
	            str1_map.replace(str1.charAt(i),((Integer)str1_map.get(str1.charAt(i)))+1);
	        }
	        else{
	        	str1_map.put(str1.charAt(i),1);
	        }
	        if(str2_map.get(str2.charAt(i))!=null){
	            str2_map.replace(str2.charAt(i),((Integer)str2_map.get(str2.charAt(i)))+1);
        	}
        	else{
        		str2_map.put(str2.charAt(i),1);
        	}
        }
        
        for(Map.Entry mapElement : str1_map.entrySet()){
            char key = (char)mapElement.getKey();
            int value = (int)mapElement.getValue();
            if(str2_map.get(key)==null || str2_map.get(key)!=value){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First string:");
        String a = sc.nextLine();
        System.out.println("Enter Second string:");
        String b = sc.nextLine();

        Ques4 obj = new Ques4();
        boolean answer = obj.areAnagrams(a,b);
        if(answer){
            System.out.println("Strings are anagrams.");
        }
        else{
            System.out.println("Strings are NOT anagrams.");
        }
    }
    
}