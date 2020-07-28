package bst1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTrees.BinaryTreeNode;

public class LCAOFBST {

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
	
	public static BinaryTreeNode<Integer> lcaInBstHelper(BinaryTreeNode<Integer> root, int a, int b){
		if(root == null) {
			return null;
		}
		if(root.data == a || root.data == b) {
			return root;
		}
		if(root.data < a && root.data < b) {
			return lcaInBstHelper(root.right, a, b);
		}
		else if(root.data > a && root.data > b) {
			return lcaInBstHelper(root.left, a, b);
		}
		else {
			BinaryTreeNode<Integer> left_lca = lcaInBstHelper(root.left, a, b);
			BinaryTreeNode<Integer> right_lca = lcaInBstHelper(root.right, a, b);
			if(left_lca != null && right_lca != null) {
				return root;
			}else if(left_lca != null) {
				return left_lca;
			}else {
				return right_lca;
			}
		}
	}
	public static int lcaofbst(BinaryTreeNode<Integer> root, int a, int b) {
		BinaryTreeNode<Integer> node = lcaInBstHelper(root, a, b);
		if(node != null) {
			return node.data;
		}else {
			return -1;
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		//		printTreeDetailed(root);
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println(lcaofbst(root,a,b));
	}

}
