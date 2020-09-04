
import java.util.*;
public class Ques6 {
    
    public Integer[] hailstone(int n){
        if(n <= 0)
            throw new IllegalArgumentException("n should be a positive integer");
        
        ArrayList<Integer> list = new ArrayList<>();
        while(n != 1){
            list.add(n);
            n = (n%2 == 0)? n/2: n*3+1;
        }
        
        return list.toArray(new Integer[list.size()]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter a positive integer whose hailstone sequence is to be found.");
        while(true){
            if(sc.hasNextInt()){
                n = sc.nextInt();
                if(n>0){
                    break;
                 }
                System.out.println("Please enter a valid positive integer.");
            }
            else{
                System.out.println("Please enter a valid positive integer.");
                String s = sc.nextLine();
            }
        }
        System.out.println("The HailStone sequence for the given positive integer is:");
        System.out.println(Arrays.toString((new Ques6()).hailstone(n)));
    }
    
}
