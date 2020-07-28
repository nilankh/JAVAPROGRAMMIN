package backtracking;
import java.util.Scanner;
public class Nqueens {
	
	private static boolean isSafe(int row, int col, int board[][], int n) {
		int i = row - 1;
		while(i >= 0) {
			if(board[i][col] == 1) {
				return false;
			}i--;
		}
		
		i = row - 1;
		int j = col - 1;
		while(i >= 0 && j >=0) {
			if(board[i][j] == 1) {
				return false;
			}
			i--;
			j--;
		}
		i = row - 1;
		j = col + 1;
		
		while(i >= 0 && j < n) {
			if(board[i][j] == 1) {
				return false;
			}
			i--;
			j++;
		}
		return true;
	}
	
	public static void placeNQueensHelper(int row, int n, int board[][]) {
		
		if(row == n) {
			for(int i = 0; i < n; i++) {
				for(int j = 0;j < n;j++) {
					System.out.print(board[i][j] +" ");
				}
			}
			System.out.println();
			
		}
		
		
		for(int col = 0;col < n; col++) {
			if(isSafe(row, col, board, n)) {
				board[row][col] = 1;
				placeNQueensHelper(row + 1, n, board);
				board[row][col] = 0;
			}
		}
	}
	public static void placeNQueens(int n) {
		
		int board[][] = new int[n][n];
		placeNQueensHelper(0, n, board);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner  s = new Scanner(System.in);
		int n = s.nextInt();
		placeNQueens(n);
	}

}
