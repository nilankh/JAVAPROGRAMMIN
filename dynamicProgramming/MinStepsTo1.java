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
