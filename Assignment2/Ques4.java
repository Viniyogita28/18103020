public class Ques4{
    public static void main(String[] args){
        int n=1;
        long sum = 1;
        System.out.println("Numbers satisfying the given property are:");
        while(n<Integer.MAX_VALUE){
            if(sum==n*n){
                System.out.println(n);
            }
            n+=1;
            sum+=n;
        }
        if(sum==n*n){
            System.out.println(n);              //To check for n=INT_MAX
        }
    }
}