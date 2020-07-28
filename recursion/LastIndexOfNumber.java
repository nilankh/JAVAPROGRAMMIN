package recursion;
import java.util.Scanner;
public class LastIndexOfNumber {
	
	public static int lastIndexHelper(int arr[], int x, int startIndex) {
		if(startIndex == arr.length) {
			return -1;
		}
		int smallAns = lastIndexHelper(arr, x, startIndex + 1);
		if(smallAns != -1) {
			return smallAns;
		}
		if(arr[startIndex] == x) {
			return startIndex;
		}else {
			return -1;
		}
		
	}
	
	public static int lastIndex(int arr[], int x) {
		return lastIndexHelper(arr, x, 0);
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
		System.out.println(lastIndex(arr, x ));
	}

}
