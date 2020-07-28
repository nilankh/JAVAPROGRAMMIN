package recursion;

import java.util.Scanner;
public class QuickSort {
	
	public static int partition(int[] arr, int si, int ei) {
		int pivot = arr[si];
		int count = 0;
		for(int i = si; i < ei + 1; i++) {
			if(arr[i] < pivot) {
				count++;
			}
		}
		
		int pivotIndex = si + count;
		arr[si] = arr[pivotIndex];
		arr[pivotIndex] = pivot;
		int i = si, j = ei;
		while(i < j) {
			if(arr[i] < pivot) {
				i++;
			}else if(arr[j] >= pivot){
				j--;
			}else {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		return pivotIndex;
	}
	
	public static void quickSortHelper(int[] arr, int si, int ei) {
		if(si >= ei) {
			return;
		}
		int pivotIndex = partition(arr, si, ei);
		quickSortHelper(arr, si, pivotIndex - 1);
		quickSortHelper(arr, pivotIndex + 1, ei);
	}
	
	
	public static void quickSort(int[] arr) {
		quickSortHelper(arr, 0, arr.length - 1);
	}
	
	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++) {
			input[i] = s.nextInt();
		}
		return input;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = takeInput();
		quickSort(input);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] +" ");
		}
	}

}
