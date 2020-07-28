// Min Steps To One
// Send Feedback
// Given a positive integer n, find the minimum number of steps s, that takes n to 1. You can perform any one of the following 3 steps.
// 1.) Subtract 1 from it. (n= n - ­1) ,
// 2.) If its divisible by 2, divide by 2.( if n%2==0, then n= n/2 ) ,
// 3.) If its divisible by 3, divide by 3. (if n%3 == 0, then n = n / 3 ).  
// Just write brute-force recursive solution for this.
// Input format :
// Line 1 : A single integer i.e. n
// Output format :
// Line 1 : Single integer i.e number of steps
// Constraints :
// 1 <= n <= 500
// Sample Input 1 :
// 4
// Sample Output 1 :
// 2 
// Sample Output 1 Explanation :
// For n = 4
// Step 1 : n = 4/2 = 2
// Step 2 : n = 2/2 = 1
// Sample Input 2 :
// 7
// Sample Output 2 :
// 3
// Sample Output 2 Explanation :
// For n = 7
// Step 1 : n = 7 ­ - 1 = 6
// Step 2 : n = 6 / 3 = 2
// Step 3 : n = 2 / 2 = 1

package dynamicProgramming;
import java.util.Scanner;
public class MinStepsTo1 {

	public static int minStepTp1(int n) {
		if(n == 1) {
			return 0;
		}
		int ans1 =minStepTp1(n - 1);
		int ans2 = Integer.MAX_VALUE;
		if(n % 2 == 0) {
			ans2 = minStepTp1(n/2);
		}
		int ans3 = Integer.MAX_VALUE;
		if(n % 3 == 0) {
			ans3 = minStepTp1(n/3);
		}
		int ans = Math.min(ans1, Math.min(ans2, ans3)) + 1;
		return ans;
	}

	public static int minStepTo1M(int n, int[] dp) {
		if(n == 1) {
			return 0;
		}
		int ans1;
		if(dp[n - 1] == -1) {
			ans1 = minStepTo1M(n - 1, dp);
			dp[n - 1] = ans1;
		}else {
			ans1 = dp[n - 1];
		}
		int ans2 = Integer.MAX_VALUE;
		if(n % 2 == 0) {
			if(dp[n/2] == -1) {
				ans2 = minStepTo1M(n/2, dp);
				dp[n/2] = ans2;
			}else {
				ans2 = dp[n/2];
			}
		}
		int ans3 = Integer.MAX_VALUE;
		if(n % 3 == 0) {
			if(dp[n/3] == -1) {
				ans3 = minStepTo1M(n/3, dp);
				dp[n/3] = ans3;
			}else {
				ans3 = dp[n/3];
			}
		}
		int myAns = Math.min(ans1, Math.min(ans2, ans3)) + 1;
//		System.out.println(myAns);
		return myAns;
	}
	
	public static int minStepTo1I(int n) {
		int dp[] = new int[n + 1];
		for(int i = 2; i <= n; i++) {
			int count1 = Integer.MAX_VALUE;
			int count2 = Integer.MAX_VALUE;
			int count3 = Integer.MAX_VALUE;
			count1 = dp[i - 1];
			if(i % 2 == 0) {
				count2 = dp[i / 2];
			}
			if(i % 3 == 0) {
				count3 = dp[i / 3];
			}
			dp[i] = 1 + Math.min(count1, Math.min(count2, count3));
			
		}
		return dp[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
//		int[] dp = new int[n + 1];
//		for(int i = 0; i < dp.length; i++) {
//			dp[i] = -1;
//		}
//		int ans = minStepTp1(n);
//		int ans = minStepTo1M(n, dp);
		int ams = minStepTo1I(n);
		System.out.println(ams);
	}

}
