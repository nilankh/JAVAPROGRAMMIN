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
