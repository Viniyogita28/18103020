import java.util.*;
public class Ques2 {
    public void sort(int[] arr){
        int[] count = new int[21];
        
        for(int i: arr)
            count[i]++;
        
        int lo=0;
        for(int i=0;i<21;++i){
            int temp=lo;
            while(lo<temp+count[i])
              arr[lo++]=i;
        }
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the size of required array.");
        
        int n;
    while(true){
        String input = sc.nextLine();
        try {
            int x = Integer.parseInt(input);
            if(x>0){
              n=x;
              break;
            }
            else{
              System.out.println("Please enter a positive integer.");
            }
        }catch(NumberFormatException e) {
            System.out.println("Input is not an int value. Try again"); 
          } 
      }
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
        	
        	
        	
 			while(true){
        System.out.println("Enter element no. "+(i+1));
 				String input = sc.nextLine();
 				try {
   					int x = Integer.parseInt(input);
   					if(x>=0 && x<=20){
   						arr[i]=x;
   						break;
   					}
   					else{
   						System.out.println("Please enter an integer between 0 and 20.");
   					}
 				}catch(NumberFormatException e) {
   					System.out.println("Input is not an int value. Try again"); 
   				} 
   		}
        }
        (new Ques2()).sort(arr);
        System.out.println(Arrays.toString(arr));
    } 
}