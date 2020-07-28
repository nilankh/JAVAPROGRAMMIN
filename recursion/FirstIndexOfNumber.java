package recursion;
import java.util.Scanner;
public class FirstIndexOfNumber {

	public static int firstIndex(int arr[], int x, int startIndex) {
		if(startIndex == arr.length) {
			return -1;
		}
		if(arr[startIndex] == x) {
			return startIndex;
		}
		int smallerList = firstIndex(arr, x, startIndex + 1);
		return smallerList;
	}
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = s.nextInt();
		int arr [] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		int x = s.nextInt();
		System.out.println(firstIndex(arr, x, 0));

	}

}
