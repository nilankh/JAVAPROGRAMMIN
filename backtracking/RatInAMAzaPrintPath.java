package backtracking;

public class RatInAMAzaPrintPath {


// agar sirf ek part print krane ka h toa ye sahi h line mo 53 tk
	public static boolean ratInAMaze(int maze[][]) {
		int n = maze.length;
		int path[][] = new int[n][n];
		return solveMaze(maze, 0, 0, path);
	}

	public static boolean solveMaze(int maze[][], int i, int j, int path[][]) {

		int n = maze.length;
//		check if i, j, cell is valid or not
		if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] ==0 || path[i][j] == 1) {
			return false;
		}
//		Include the cell in currentPath
		path[i][j] = 1;
		
//		Destination Cell
		if(i == n - 1 && j == n - 1) {
			for(int row = 0; row < n; row++ ) {
				for(int column = 0; column < n; column++) {
					System.out.print(path[row][column] + " ");
				}
				System.out.println();
			}
			return true;
		}
		
//		Explore further in all directions
//		TOP
		if(solveMaze(maze, i - 1, j, path)) {
			return true;
		}
//		RIGHT
		if(solveMaze(maze, i, j + 1, path)) {
			return true;
		}
//		DOWN
		if(solveMaze(maze, i + 1, j, path)) {
			return true;
		}
//		Left
		if(solveMaze(maze, i, j - 1, path)) {
			return true;
		}
		return false;

	}
	
	
//	BELOW THE CODE WILL GIVE ME THE ALL POSSIBLE PATHS
	
	public static void ratInAMazee(int maze[][]) {
		int n = maze.length;
		int path[][] = new int[n][n];
		printAllPaths(maze, 0, 0, path);
//		return solveMaze(maze, 0, 0, path);
	}
	public static void printAllPaths(int maze[][], int i, int j, int path[][]) {
		int n = maze.length;
//		Check if i, k cell is valid or not
		if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
			return;
		}
//		Include the cell in current path
		path[i][j] = 1;
//		Destination cell
		if(i == n - 1 && j == n - 1) {
			for(int row = 0; row < n; row++) {
				for(int column = 0; column < n; column++) {
					System.out.print(path[row][column] + " ");
				}
				System.out.println();
				
			}
//			ye reset q kr rhe h taaki hm further all explore kr paaye
			System.out.println();
			path[i][j] = 0;
			return; 
		}
//		Explore further in all directions
//		TOP
		printAllPaths(maze, i - 1, j, path);
		
//		RIGHT
		printAllPaths(maze, i, j + 1, path);
		
//		DOWN
		printAllPaths(maze, i + 1, j, path);
		
//		LEFT
		printAllPaths(maze, i, j - 1, path);
		path[i][j] = 0;
		
	}
	public static void main(String[] args) {
		int maze[][] = {{1, 1, 0}, {1, 1, 0}, {1, 1, 1}};
//		boolean pathPossible = ratInAMaze(maze);
//		System.out.println(pathPossible);
		ratInAMazee(maze);
	}


}
