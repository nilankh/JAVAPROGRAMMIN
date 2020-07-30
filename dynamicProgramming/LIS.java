package dynamicProgramming;
import java.util.Scanner;
public class LIS {
//	public static int lis(int[] arr) {
//		int n = arr.length;
//		return helper(arr, 0, n);
//	}
//	public static int helper(int[] arr, int i, int n) {
//		int including_max = 1;
//		for(int j = i + 1; j < n; j ++) {
//			if(arr[j] >= arr[i]) {
//				int further_including_max = helper(arr, i + 1, n);
//				including_max = Math.max(including_max, 1 + further_including_max);
//		int excluding_max = helper(arr, i + 1, n);
//		int overallMax = Math.max(including_max, excluding_max);
//		
//				
//			}
//		}
//	}
	
	public static int lis(int[] arr) {
		int storage[] = new int[arr.length];
		storage[0] = 1;
		int ans = 1;
		for(int i = 1; i < storage.length; i++) {
			int max = 1;
			for(int j = i - 1; j >= 0; j--) {
				if(arr[j] < arr[i]) {
					int op = storage[j] + 1;
					if(op > max) {
						max = op;
					}
				}
			}
			storage[i] = max;
			if(max > ans) {
				ans = max;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(lis(arr));
	}

}
