import java.util.*;
public class Ques5{
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter maximum limit for universe starting from 0: ");
        int univ_max = obj.nextInt();

        System.out.print("Enter no of elements in set a and b: ");
        int a = obj.nextInt(), b = obj.nextInt();

        ArrayList<Integer> arr1 = new ArrayList<Integer>(), arr2 = new ArrayList<Integer>();

        System.out.println("Given elements to add in set (Anything outside universe will be replaced by 0): ");
        ArrayList<Integer> universe = new ArrayList<Integer>();
        for(int i=0;i<=univ_max;i++){
            System.out.print(i+" ");
            universe.add(i);
        }
        System.out.println();

        System.out.print("Enter elements of set a: ");
        int temp;
        boolean present;
        for(int i=0;i<a;i++){
            temp = obj.nextInt();
            if(temp<0 || temp>univ_max){
                temp = 0;
            }
            present = false;
            for(int j=0;j<arr1.size();j++){
                if(arr1.get(j)==temp){
                    present = true;
                }
            }
            if(!present){
                arr1.add(temp);
            }
        }

        System.out.print("Enter elements of set b: ");
        for(int i=0;i<b;i++){
            temp = obj.nextInt();
            if(temp<0 || temp>univ_max){
                temp = 0;
            }
            present = false;
            for(int j=0;j<arr2.size();j++){
                if(arr2.get(j)==temp){
                    present = true;
                }
            }
            if(!present){
                arr2.add(temp);
            }
        }

        Set<Integer> universe_s = new HashSet<Integer>(), s1 = new HashSet<Integer>(), s2 = new HashSet<Integer>();
        universe_s.addAll(universe);
        s1.addAll(arr1);
        s2.addAll(arr2);


        // Union
        long startTime = System.nanoTime();
        ArrayList<Integer> union = new ArrayList<Integer>();
        for(int i=0;i<arr1.size(); i++){
            present = false;
            for(int j=0;j<union.size();j++){
                if(arr1.get(i)==union.get(j)){
                    present = true;
                    break;
                }
            }
            if(!present){
                union.add(arr1.get(i));
            }
        }
        for(int i=0;i<arr2.size(); i++){
            present = false;
            for(int j=0;j<union.size();j++){
                if(arr2.get(i)==union.get(j)){
                    present = true;
                    break;
                }
            }
            if(!present){
                union.add(arr2.get(i));
            }
        }
        System.out.print("Union of a and b using arrays: ");
        for(int i=0;i<union.size();i++){
            System.out.print(union.get(i)+" ");
        }
        System.out.println("");
        long duration1 = System.nanoTime() - startTime;
        System.out.println("Time for union with arrays: " + duration1);

        startTime = System.nanoTime();
        Set<Integer> union_s = new HashSet<Integer>(a);
        union_s.addAll(s2);
        System.out.print("\nUnion of a and b using sets: ");
        System.out.println(union);
        long duration2 = System.nanoTime() - startTime;
        System.out.println("Time for union with sets: " + duration2);


        if(duration1<duration2){
            System.out.println("Time to compute union using arrays < Time to compute union using sets");
        }
        else if(duration2<duration1){
            System.out.println("Time to compute union using sets < Time to compute union using arrays");
        }
        else{
            System.out.println("Time to compute union using sets = Time to compute union using arrays");
        }

        // Intersection
        startTime = System.nanoTime();
        ArrayList<Integer> intersection = new ArrayList<Integer>();
        for(int i=0;i<arr1.size(); i++){
            present = false;
            for(int j=0;j<arr2.size();j++){
                if(arr1.get(i)==arr2.get(j)){
                    present = true;
                    break;
                }
            }
            if(present){
                intersection.add(arr1.get(i));
            }
        }
        System.out.print("\nIntersection of a and b using arrays: ");
        for(int i=0;i<intersection.size();i++){
            System.out.print(intersection.get(i)+" ");
        }
        System.out.println("");
        duration1 = System.nanoTime() - startTime;
        System.out.println("Time for intersection with arrays: " + duration1);

        startTime = System.nanoTime();
        Set<Integer> intersection_s = new HashSet<Integer>(a);
        union_s.retainAll(s2);
        System.out.print("\nIntersection of a and b using sets: ");
        System.out.println(intersection);
        duration2 = System.nanoTime() - startTime;
        System.out.println("Time for intersection with sets: " + duration2);


        if(duration1<duration2){
            System.out.println("Time to compute intersection using arrays < Time to compute intersection using sets");
        }
        else if(duration2<duration1){
            System.out.println("Time to compute intersection using sets < Time to compute intersection using arrays");
        }
        else{
            System.out.println("Time to compute intersection using sets = Time to compute intersection using arrays");
        }

        // Complement
        startTime = System.nanoTime();
        ArrayList<Integer> diff1 = new ArrayList<Integer>();
        for(int i=0;i<universe.size(); i++){
            present = false;
            for(int j=0;j<arr1.size();j++){
                if(arr1.get(j)==universe.get(i)){
                    present = true;
                    break;
                }
            }
            if(!present){
                diff1.add(universe.get(i));
            }
        }
        System.out.print("\nComplement of a using arrays: ");
        for(int i=0;i<diff1.size();i++){
            System.out.print(diff1.get(i)+" ");
        }
        System.out.println("");

        ArrayList<Integer> diff2 = new ArrayList<Integer>();
        for(int i=0;i<universe.size(); i++){
            present = false;
            for(int j=0;j<arr2.size();j++){
                if(arr2.get(j)==universe.get(i)){
                    present = true;
                    break;
                }
            }
            if(!present){
                diff2.add(universe.get(i));
            }
        }
        System.out.print("Complement of b using arrays: ");
        for(int i=0;i<diff2.size();i++){
            System.out.print(diff2.get(i)+" ");
        }
        System.out.println("");
        duration1 = System.nanoTime() - startTime;
        System.out.println("Time for complement of arrays: " + duration1);

        startTime = System.nanoTime();
        Set<Integer> diff1_s = new HashSet<Integer>(universe_s), diff2_s = new HashSet<Integer>(universe_s);
        diff1_s.removeAll(s1);
        System.out.print("\nComplement of a using sets");
        System.out.println(diff1_s);

        diff2_s.removeAll(s2);
        System.out.print("Complement of b using sets");
        System.out.println(diff2_s);
        duration2 = System.nanoTime() - startTime;
        System.out.println("Time for complement with sets: " + duration2);

        if(duration1<duration2){
            System.out.println("Time to compute complement using arrays < Time to compute complement using sets");
        }
        else if(duration2<duration1){
            System.out.println("Time to compute complement using sets < Time to compute complement using arrays");
        }
        else{
            System.out.println("Time to compute complement using sets = Time to compute complement using arrays");
        }
    }
}