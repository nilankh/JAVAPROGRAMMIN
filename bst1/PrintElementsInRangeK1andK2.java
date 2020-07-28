package bst1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTrees.BinaryTreeNode;

public class PrintElementsInRangeK1andK2 {
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root Data:");
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
		pendingChildren.add(root);

		while(!pendingChildren.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingChildren.poll();
			System.out.println("Enter left child of " + front.data);
			int left = s.nextInt();
			if(left != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
				front.left = leftChild;
				pendingChildren.add(leftChild);
			}
			System.out.println("Enter right child of " + front.data);
			int right = s.nextInt();
			if(right != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
				front.right = rightChild;
				pendingChildren.add(rightChild);
			}
		}
		return root;

	}
	public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + ":");
		if(root.left != null) {
			System.out.print("L" + root.left.data + ",");
		}
		if(root.right != null) {
			System.out.print("R" + root.right.data);
		}
		System.out.println();
		printTreeDetailed(root.left);
		printTreeDetailed(root.right);
	}

//	Time complexity in Worst Case is O(n)
	public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root, int k1, int k2) {
		if(root == null) {
			return;
		}

		if(root.data < k1) {
			printNodeFromK1ToK2(root.right, k1, k2);
		}else if(root.data > k2) {
			printNodeFromK1ToK2(root.left, k1, k2);
		}else {
			System.out.print(root.data + " ");
			printNodeFromK1ToK2(root.left, k1, k2);
			printNodeFromK1ToK2(root.right, k1, k2);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int k1 = s.nextInt();
		int k2 = s.nextInt();
		printNodeFromK1ToK2(root, k1, k2);
	}

}
