
import java.util.*;

public class Ques3{

    int paths[];
    int v;
  
    public Ques3(int v){
        this.v = v;
        paths = new int[v + 1];
    }
 
    public void QuesThirdEvaluation(int source, int adjacency_matrix[][]){
        for (int node = 1; node <= v; node++){
            paths[node] = Integer.MAX_VALUE;
        }
 
        paths[source] = 0;
        for (int node = 1; node <= v - 1; node++){
            for (int s= 1; s<= v; s++){
                for (int d = 1; d<= v; d++){
                    if (adjacency_matrix[s][d] != Integer.MAX_VALUE){
                        if (paths[d] > paths[s]  + adjacency_matrix[s][d])
                        	paths[d] = paths[s] + adjacency_matrix[s][d];
                    }
                }
            }
        }
 
        for (int s= 1; s <= v;s++){
            for (int d = 1; d <= v; d++){
                if (adjacency_matrix[s][d] != Integer.MAX_VALUE){
                    if (paths[d] > paths[s] + adjacency_matrix[s][d])
                        System.out.println("The Graph contains negative edge cycle");
                }
            }
        }
 
        for (int x = 1; x <= v; x++){
            System.out.println("distance of source  " + source + " to "
                      + x + " is " + paths[x]);
        }
    }
 
    public static void main(String... arg){
        int v = 0;   
        int source;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        v=sc.nextInt();
		sc.nextLine();
       
        int adjacency_matrix[][] = new int[v + 1][v + 1];   
        
        System.out.println("Enter the adjacency matrix. IF EDGE DOES NOT EXIST, ENTER 0");
        for (int s = 1; s<=v; s++){
            for (int d = 1; d <= v; d++){
            	System.out.println("Enter weight of edge from vertex "+ s +" to vertex "+ d);
                adjacency_matrix[s][d] = sc.nextInt();
 	        	if (s == d){
                    adjacency_matrix[s][d] = 0;
                    continue;
            	}
            	if (adjacency_matrix[s][d] == 0){
                    adjacency_matrix[s][d] = Integer.MAX_VALUE;                 
            	}
            }
        }
 
        System.out.println("Enter the source vertex");
        source = sc.nextInt();
 
        Ques3 qt = new Ques3(v);
        qt.QuesThirdEvaluation(source, adjacency_matrix);
        sc.close();	
    }
}
