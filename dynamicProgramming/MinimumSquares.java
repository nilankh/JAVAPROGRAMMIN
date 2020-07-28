//Minimum Number Of Squares
//Send Feedback
//Given an integer N, find and return the count of minimum numbers, sum of whose squares is equal to N.
//That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. Output will be 1, as 1 is the minimum count of numbers required.
//Note : x^y represents x raise to the power y.
//Input Format :
//Integer N
//Output Format :
//Required minimum count
//Constraints :
//1 <= N <= 1000
//Sample Input 1 :
//12
//Sample Output 1 :
//3
//Sample Output 1 Explanation :
//12 can be represented as :
//1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1
//1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 2^2
//1^1 + 1^1 + 1^1 + 1^1 + 2^2 + 2^2
//2^2 + 2^2 + 2^2
//As we can see, the output should be 3.
//Sample Input 2 :
//9
//Sample Output 2 :
//1



package dynamicProgramming;
import java.util.Scanner;
public class MinimumSquares {
	
	public static int minSquaresR(int n) {
		
		if(n == 0)
			return 0;
		int minAns = Integer.MAX_VALUE;				
		for(int i = 1; i*i <= n; i++) {
			int currAns = minSquaresR(n - (i * i));
			if(minAns > currAns) {
				minAns = currAns;
			}
		}
		int myAns = 1 + minAns;
		return myAns;
	}
	
	public static int minSquaresRM(int n, int[] dp) {
		if(n == 0) {
			return 0;
		}
		int minAns = Integer.MAX_VALUE;
		for(int i = 1; i * i <= n; i++) {
			int currAns;
			if(dp[n - (i * i)] == -1) {
				currAns = minSquaresRM(n - (i * i), dp);
				dp[n - (i * i)] = currAns;
			}else {
				currAns = dp[n - (i * i)];
			}
			if(minAns > currAns) {
				minAns = currAns;
			}
		}
		int myAns = 1 + minAns;
		return myAns;
	}
	public static int minSquaresI(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for(int i = 1; i <= n; i++) {
			
			int minAns = Integer.MAX_VALUE;
			for(int j = 1; j*j <= i; j++) {
				int currAns = dp[i - (j * j)];
				if(minAns > currAns) {
					minAns = currAns;
				}
			}
			dp[i] = 1 + minAns;
		}
		return dp[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
//		int dp[] = new int[n + 1];
//		for(int i = 0; i < dp.length; i++) {
//			dp[i] = -1;
//		}
//		int ans = minSquaresRM(n, dp);
//		System.out.println(ans);
		System.out.println(minSquaresI(n));
//		System.out.println(minSquaresR(n));
	}

}

