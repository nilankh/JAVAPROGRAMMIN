package graph;

import java.util.Scanner;

import java.util.Queue;
import java.util.LinkedList;
public class ImplementationOfGraph {

	public static void dfsHelper(int adjMatrix[][], int currentVertex, boolean visited[]){
		visited[currentVertex] = true;
		System.out.print(currentVertex + " ");

		for(int i = 0; i < adjMatrix.length; i++) {
			if(adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
				//				i is neighbour of currentVertex
				dfsHelper(adjMatrix, i, visited);
			}
		}
	}

	public static void dfs(int adjMatrix[][]) {
		boolean visited[] = new boolean[adjMatrix.length];
		for(int i = 0; i < adjMatrix.length; i++) {
			if(visited[i] == false) {
				dfsHelper(adjMatrix, i, visited);
				System.out.println();
			}
			
		}
	}
	
	public static void bfsHelper(int adjMatrix[][], int sv, boolean visited[]) {
		Queue<Integer> pendingVertices = new LinkedList<>();
		visited[0] = true;
		pendingVertices.add(0);

		while(!pendingVertices.isEmpty()) {
			int currentVertex = pendingVertices.poll();//it will remove from the queue
			System.out.print(currentVertex + " ");
			for(int i = 0; i < adjMatrix.length; i++) {
				if(adjMatrix[currentVertex][i] == 1 && !visited[i]) {
					pendingVertices.add(i);
					//					i is unvisited neigbour of currentVertex
					visited[i] = true;
				}
			}
		}

	
	}

	public static void bfTraversal(int adjMatrix[][]) {
		
		boolean visited[] = new boolean[adjMatrix.length];
		
		for(int i = 0; i < adjMatrix.length; i++) {
			if(visited[i] == false) {
				bfsHelper(adjMatrix, i, visited);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
		int adjMatrix[][] = new int[n][n];

		for(int i = 0; i < e; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
		//		System.out.println(adjMatrix.length);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(adjMatrix[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println();
//				dfs(adjMatrix);
		bfTraversal(adjMatrix);
	}

}
