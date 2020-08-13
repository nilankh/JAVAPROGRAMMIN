//LCS - Problem
//Send Feedback
//Given 2 strings of S1 and S2 with lengths m and n respectively,
//find the length of longest common subsequence.
//A subsequence of a string S whose length is n, is a string containing characters 
//in same relative order as they are present in S, but not necessarily contiguous.
//Subsequences contain all the strings of length varying from 0 to n. For example, 
//subsequences of string "abc" are - "",a,b,c,ab,bc,ac,abc.
//Input Format :
//Line 1 : String S1
//Line 2 : String s2
//Output Format :
//Line 1 : Length of longest common subsequence
//Sample Input :
//adebc
//dcadb
//Sample Output :
//3


package dynamicProgramming;
import java.util.Scanner;
public class LCS {


	public static int lcs(String s1, String s2) {
		return lcsHelper(s1, s2, 0, 0);
	}

	public static int lcsHelper(String str1, String str2, int i, int j) {

		if(i == str1.length() || j == str2.length()) {
			return 0;
		}

		int myAns;
		if(str1.charAt(i) == str2.charAt(j)) {
			int smallAns = lcsHelper(str1, str2, i + 1, j + 1);
			myAns = 1 + smallAns;
		}else {
			int ans1 = lcsHelper(str1, str2, i + 1, j);
			int ans2 = lcsHelper(str1, str2, i, j + 1);
			myAns = Math.max(ans1, ans2);
		}
		return myAns;
	}



	public static int LCSRECMEMO(String s1, String s2, int[][] dp) {
		return LCSRECMEMOHelper(s1, s2, 0, 0, dp);
	}
	public static int LCSRECMEMOHelper(String str1, String str2, int i, int j, int[][] dp) {
		if(i == str1.length() || j == str2.length()) {
			return 0;
		}

		int myAns;
		if(str1.charAt(i) == str2.charAt(j)) {
			int smallAns;
			if(dp[i + 1][j + 1] == -1) {
				smallAns = LCSRECMEMOHelper(str1, str2, i + 1, j + 1, dp);
				dp[i + 1][j + 1] = smallAns;
			}else {
				smallAns = dp[i + 1][j + 1];
			}
			myAns = 1 + smallAns;
		}else {
			int ans1, ans2;
			if(dp[i + 1][j] == -1) {
				ans1 = LCSRECMEMOHelper(str1, str2, i + 1, j, dp);
				dp[i + 1][j] = ans1;
			}else {
				ans1 = dp[i + 1][j];
			}
			
			if(dp[i][j + 1] == -1) {
				ans2 = LCSRECMEMOHelper(str1, str2, i, j + 1, dp);
				dp[i][j + 1] = ans2;
			}else {
				ans2 = dp[i][j + 1];
			}
			
			myAns = Math.max(ans1, ans2);
		}
		return myAns;
	}
	
	public static int LCSI(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m + 1][n + 1];
		for(int i = m - 1; i >= 0; i--) {
			for(int j = n - 1; j >= 0; j--) {
				
				int ans;
				if(str1.charAt(i) == str2.charAt(j)) {
					ans = 1 + dp[i + 1][j + 1];
					
				}else {
					int ans1 = dp[i][j + 1];
					int ans2 = dp[i + 1][j];
					ans = Math.max(ans1, ans2);
					
					
				}
				dp[i][j] = ans;
			}
		}
		return dp[0][0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		//		System.out.println(lcs(str1, str2));
//		int[][] dp = new int[(str1.length() + 1)][str2.length() + 1];
//		for(int i = 0; i < dp.length; i++) {
//			for(int j = 0; j < dp[0].length; j++) {
//				dp[i][j] = -1;
//			}
//		}
//		System.out.println(LCSRECMEMO(str1, str2, dp));
		System.out.println(LCSI(str1, str2));
	}

}
