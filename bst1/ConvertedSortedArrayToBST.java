package bst1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTrees.BinaryTreeNode;

public class ConvertedSortedArrayToBST {
	
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static BinaryTreeNode<Integer> sortedArrayBSThelper(int[] arr, int start, int end){
		if(start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		int rootData = arr[mid];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		root.left = sortedArrayBSThelper(arr,start, mid - 1);
		root.right = sortedArrayBSThelper(arr, mid + 1, end);
		return root;

	}
	
	public static BinaryTreeNode<Integer> sortedArrayToBST(int[] arr){

		return sortedArrayBSThelper(arr, 0 , arr.length - 1);
	}
	
	private static void preOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = takeInput();
		BinaryTreeNode<Integer>ans = sortedArrayToBST(arr);
		preOrder(ans);
	}

}
