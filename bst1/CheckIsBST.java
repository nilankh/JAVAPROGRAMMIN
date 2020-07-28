package bst1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTrees.BinaryTreeNode;

public class CheckIsBST {
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

	public static int minimum(BinaryTreeNode<Integer> root) {

		if(root == null) {
			return Integer.MAX_VALUE;
		}

		int leftMin = minimum(root.left);
		int rightMin = minimum(root.right);

		return Math.min(root.data, Math.min(leftMin, rightMin));
	}

	public static int maximum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		int leftMax = maximum(root.left);
		int rightMax = maximum(root.right);

		return Math.max(root.data, Math.max(leftMax, rightMax));
	}
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		int leftMax = maximum(root.left);
		if(leftMax >= root.data) {
			return false;
		}
		int rightMin = minimum(root.right);  
		if(rightMin <= root.data) {
			return false;
		}
		boolean isLeftBST = isBST(root.left);
		boolean isRightBST = isBST(root.right);

		return isLeftBST && isRightBST;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		printTreeDetailed(root);
		System.out.println(isBST(root));
	}
}
