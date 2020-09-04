
import java.util.*;

public class Ques3 {
    
    private void merge(String[] arr, int left, int mid, int right){  
        int l = mid - left + 1;  
        int r = right - mid;  

        String[] LeftArray = new String[l];  
        String[] RightArray = new String[r];  

        for (int i=0; i<l; ++i)  
            LeftArray[i] = arr[left + i];  

        for (int j=0; j<r; ++j)  
            RightArray[j] = arr[mid + 1+ j];  

        int i = 0, j = 0;  
        int k = left;  
        
        while (i<l&&j<r)  {  
            if (LeftArray[i].compareTo(RightArray[j]) <= 0){  
                arr[k] = LeftArray[i];  
                i++;  
            }else{  
                arr[k] = RightArray[j];  
                j++;  
            }  
            k++;  
        }
        
        while (i<l){  
            arr[k] = LeftArray[i];  
            i++;  
            k++;  
        }  

        while (j<r){  
            arr[k] = RightArray[j];  
            j++;  
            k++;  
        }  
    }  

    public void sort(String arr[], int left, int right)  
    {  
        if (left<right)  
        {  
            int mid = (left+right)/2;  
            sort(arr, left, mid);  
            sort(arr , mid+1, right);  
            merge(arr, left, mid, right);  
        }  
    } 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Program to sort strings.");
        System.out.println("Enter number of strings that are to be sorted.");
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

        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter element no. "+(i+1));
            String s = sc.nextLine();
            if(s==null || s.isEmpty()){
                System.out.println("Empty strings are not accepted. Please enter a valid string and try again.");
                i--;
            }
            else
                arr[i]=s;
        }
        
        (new Ques3()).sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
}
