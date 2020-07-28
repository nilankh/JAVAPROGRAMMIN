// Stair Case
// Send Feedback
// A child is running up a staircase with n steps and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count how many possible ways the child can run up to the stairs. You need to return all possible number of ways.
// Time complexity of your code should be O(n).
// Input format :
// Integer n (No. of steps)
// Constraints :
// n <= 70
// Sample Input 1:
// 4
// Sample Output 1:
// 7

package dynamicProgramming;
import java.util.Scanner;
public class StairCase {
	
	public static int staircase(int n, int[] dp) {
		
		if(n == 0 || n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		if(dp[n] > 0) {
			return dp[n];
		}
		dp[n] = staircase(n - 3, dp) +  staircase(n - 2, dp) + staircase(n - 1, dp);
		return dp[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [] dp = new int[n + 1];
		for(int i = 0; i < dp.length; i++ ) {
			dp[i] = -1;
		}
		System.out.println(staircase(n,dp));
	}

}
