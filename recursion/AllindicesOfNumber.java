package recursion;
import java.util.Scanner;

public class AllindicesOfNumber {
	
	public static int[] helper(int arr[], int x, int startIndex) {
		if(startIndex == arr.length) {
			int output[] = new int[0];
//			System.out.println("size of output"+ output.length);
			return output;
		}
		int smallOutput[] = helper(arr, x, startIndex + 1);
		
//		System.out.println("smalloutput ka lenght"+smallOutput.length);
//		System.out.println("startIndex"+startIndex);
		if(arr[startIndex] == x) {
			int output[] = new int[smallOutput.length + 1];
//			System.out.println("ye output ka size" + output.length);
			output[0] = startIndex;
//			System.out.println(output[0]);
			
			for(int i = 0; i < smallOutput.length; i++) {
				
				output[i + 1] = smallOutput[i];
//				System.out.println("smak" + smallOutput[i]);
			}
			return output;
		}else {
			return smallOutput;
		}
	}
	
	public static int[] allIndexes(int arr[], int x) {
		return helper(arr, x, 0);
	}
	
	
	
	public static void he(int[] arr, int start, int x) {
		if(start == arr.length)
			return;
		if(arr[start] == x)
			System.out.print(start +" ");
		he(arr, start + 1, x);
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
//		he(arr, 0, x); ye v sahi h
		int output[] = allIndexes(arr, x);
		for(int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}

}
