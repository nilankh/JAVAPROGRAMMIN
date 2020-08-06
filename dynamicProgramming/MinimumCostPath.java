// Min Cost Path Problem
// Send Feedback
// Given an integer matrix of size m*n, you need to find out the value of minimum cost to reach from the cell (0, 0) to (m-1, n-1).
// From a cell (i, j), you can move in three directions : (i+1, j), (i, j+1) and (i+1, j+1).
// Cost of a path is defined as the sum of values of each cell through which path passes.
// Input Format :
// Line 1 : Two integers, m and n
// Next m lines : n integers of each row (separated by space)
// Output Format :
// Minimum cost
// Constraints :
// 1 <= m, n <= 20
// Sample Input 1 :
// 3 4
// 3 4 1 2
// 2 1 8 9
// 4 7 8 1
// Sample Output 1 :
// 13

package dynamicProgramming;
import java.util.Scanner;
public class MinimumCostPath {
	
	
	public static int minCostPathRe(int cost[][]) {
		return minCostPathReHelper(cost, 0, 0);
	}
	public static int minCostPathReHelper(int[][] cost, int i, int j) {
		
		
		
		int m = cost.length;
		int n = cost[0].length;
//		special case
		if(i == m - 1 && j == n - 1) {
			return cost[i][j];
		}
//		Base case
		if(i >= n || j >= n) {
			return Integer.MAX_VALUE;
		}
		int ans1 = minCostPathReHelper(cost, i + 1, j);
		int ans2 = minCostPathReHelper(cost, i, j + 1);
		int ans3 = minCostPathReHelper(cost, i + 1, j + 1);
		
		int myAns = cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));
		return myAns;
	}
	
	public static int minCostPathReMemo(int[][]cost, int [][] dp) {
		return minCostPathReMemoHelper(cost, dp, 0, 0);
	}
	public static int minCostPathReMemoHelper(int[][] cost, int[][] dp,  int i, int j ) {
		int m = cost.length;
		int n = cost[0].length;
//		special case
		if(i == m - 1 && j == n - 1) {
			return cost[i][j];
		}
//		Base case
		if(i >= n || j >= n) {
			return Integer.MAX_VALUE;
		}
		int ans1, ans2, ans3;
		if(dp[i + 1][j] == Integer.MIN_VALUE) {
			ans1 = minCostPathReHelper(cost, i + 1, j);
			dp[i + 1][j] = ans1;
		}else {
			ans1 = dp[i + 1][j];
		}
		
		if(dp[i][j + 1] == Integer.MIN_VALUE) {
			ans2 = minCostPathReHelper(cost, i, j + 1);
			dp[i][j + 1] = ans2;
		}else {
			ans2 = dp[i][j + 1];
		}
		
		if(dp[i + 1][j + 1] == Integer.MIN_VALUE) {
			ans3 = minCostPathReHelper(cost, i + 1, j + 1);
			dp[i + 1][j + 1] = ans3;
		}else {
			ans3 = dp[i + 1][j + 1];
		}
		
		
		int myAns = cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));
		return myAns;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int cost[][] = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				cost[i][j] = s.nextInt();
			}
		}
		
		int[][] dp = new int[cost.length + 1][cost[0].length + 1];
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
//		System.out.println(minCostPathRe(cost));
		System.out.println(minCostPathReMemo(cost, dp));
	}


}
