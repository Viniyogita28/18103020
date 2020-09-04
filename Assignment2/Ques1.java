import java.util.Scanner;

public class Ques1 {
    
    public int compare(String a, String b){
        
        if(a==null || b==null || a.isEmpty() || b.isEmpty() )
            throw new NullPointerException("Empty strings are not accepted. Please try again.");
        
        int len = Math.min(b.length(), a.length());
        
        int i=0;

        while(i<len){
        	if(a.charAt(i) == b.charAt(i)){
        		i++;
        	}
        	else{
        		return b.charAt(i) - a.charAt(i);
        	}
        }

        return b.length() - a.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Program to compare two strings lexicographically.");
        System.out.print("Enter first string: ");
        String a = sc.nextLine();
        System.out.print("Enter second string: ");
        String b = sc.nextLine();
        
        int res = (new Ques1()).compare(a, b);
        System.out.println("First String is " + 
                ((res > 0)? "Smaller than ": (res < 0)? "Greater than ": "Equal to ") + 
                "the second string");
    }
    
}
