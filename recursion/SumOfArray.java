package recursion;
import java.util.*;
public class SumOfArray {
	
	public static int sumOfArrayhelper(int[] arr,int startIndex) {
		if(startIndex == arr.length) {
			return 0;
		}
		else {
			return arr[startIndex] + sumOfArrayhelper(arr, startIndex + 1);
		}
	}
	
	public static int sumOfArray(int[] arr) {
		return sumOfArrayhelper(arr, 0);
	}
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
			
		}
		System.out.println(sumOfArray(arr));
	}

}
