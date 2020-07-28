package graph;
import java.util.Scanner;
public class HasPath {
	
	public static boolean hasPathHelper(int adjMatrix[][], int v1, int v2, boolean visited[]) {
        if(adjMatrix[v1][v2] == 1) {
            return true;
        }
        visited[v1] = true;
        for(int i = 0; i < adjMatrix.length; i++) {
            if(adjMatrix[v1][i] > 0 && visited[i] == false) {
                return hasPathHelper(adjMatrix, i, v2, visited);

            }
        }return false;
    }
    public static boolean hasPath(int adjMatrix[][], int v1, int v2) {
        boolean visited[] = new boolean[adjMatrix.length];

        return hasPathHelper(adjMatrix, v1, v2, visited);

    }


    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();
		int adjMatrix[][] = new int[v][v];
		for(int i = 0; i < e; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
        
        
        int v1 = s.nextInt();
		int v2 = s.nextInt();
        System.out.println(hasPath(adjMatrix, v1, v2));
    }

}
