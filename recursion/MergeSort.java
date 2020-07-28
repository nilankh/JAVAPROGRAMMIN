package recursion;
import java.util.Scanner;
public class MergeSort {
	
	public static void mergeSort(int[] arr, int si, int ei) {
		if(si >= ei) {
			return;
		}
		int mid = (si + ei)/2;
//		part1
		mergeSort(arr, si, mid);
//		part2
		mergeSort(arr, mid + 1, ei);
		
		merge(arr, si, ei);
	}
	
	public static void merge(int[] arr, int si, int ei) {
		
		int mid = (si + ei)/2;
		int ans[] = new int[ei - si + 1];
		int i = si;
		int j = mid + 1;
		int k = 0;
		while(i <= mid && j <= ei) {
			if(arr[i] < arr[j]) {
				ans[k] = arr[i];
				i++;
				k++;
			}else {
				ans[k] = arr[j];
				k++;
				j++;
			}
		}
		
		while(i<=mid) {
			ans[k] = arr[i];
			i++;
			k++;
		}
		while(j<=ei) {
			ans[k] = arr[j];
			k++;
			j++;
		}
		for(int index = 0; index < ans.length; index++) {
			arr[si + index] = ans[index];
		}
	}
	
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void printArray(int input[]) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = takeInput();
		mergeSort(input, 0, input.length - 1);
		printArray(input);
	}

}
