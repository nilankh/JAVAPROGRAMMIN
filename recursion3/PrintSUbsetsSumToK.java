package recursion3;

import java.util.Scanner;

public class PrintSUbsetsSumToK {
	
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;

	}
	public static void printSubsetsSumToKHelper(int[] input, int si, int[] output, int k ) {
		if(si == input.length) {
			if(k == 0) {
				for(int i: output) {
					System.out.print(i + " ");
				}
				System.out.println();
				return;
			}else {
				return;
			}
		}
		
		int[] newOutput = new int[output.length + 1];
		int i = 0;
		for(; i < output.length; i++) {
			newOutput[i] = output[i];
		}
		newOutput[i] = input[si];
		printSubsetsSumToKHelper(input, si + 1, output, k);
		printSubsetsSumToKHelper(input, si + 1, newOutput, k - input[si]);
		
	}
	public static void printSubsetsSumToK(int input[], int k) {
		int output[] = new int[0];
		printSubsetsSumToKHelper(input, 0, output, k);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int[] input = takeInput();
		int k = s.nextInt();
		printSubsetsSumToK(input, k);
	}

}
