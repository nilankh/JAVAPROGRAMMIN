package recursion3;
import java.util.Scanner;
public class PrintSUbsetsOfAnArray {
	
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
				
	}
	
	public static void printSubsetsHelper(int input[], int si, int[] output) {
		if(si == input.length) {
			for(int i: output) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		int[] newOutput = new int[output.length + 1];
		int i = 0;
		for(; i < output.length; i++) {
			newOutput[i] = output[i];
//			System.out.println("i"+ i);
		}
//		System.out.println("outside i"+ i);
		newOutput[i] = input[si];
//		System.out.println("newOutput"+newOutput[i]);
		printSubsetsHelper(input, si + 1, output);
		printSubsetsHelper(input, si + 1, newOutput);
	}
	public static void printSubsets(int input[]) {
		int output[] = new int[0];
		System.out.println(output);
		
		printSubsetsHelper(input, 0, output);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = takeInput();
		printSubsets(input);
	}

}
