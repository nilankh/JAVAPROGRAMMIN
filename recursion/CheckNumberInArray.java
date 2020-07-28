package recursion;
import java.util.Scanner;
public class CheckNumberInArray {
	
	
	public static boolean checkNumH(int arr[], int x, int startIndex) {
		if(startIndex == arr.length) {
			return false;
		}
		if(arr[startIndex] == x) {
			return true;
		}
		return checkNumH(arr, x, startIndex + 1);
	}
	public static boolean checkNumberInArray(int arr[], int x) {
		return checkNumH(arr, x, 0);
		
	}
	
	
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		int x = s.nextInt();
		System.out.println(checkNumberInArray(arr, x));
	}

}
