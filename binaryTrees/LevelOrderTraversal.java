package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import queues.QueueUsingLL;

public class LevelOrderTraversal {
	
	
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
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> q1 = new LinkedList<BinaryTreeNode<Integer>>();
		Queue<BinaryTreeNode<Integer>> q2 = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> curr;
		q1.add(root);
		while(!q1.isEmpty()) {
			while(!q1.isEmpty()) {
				curr =q1.poll();
				System.out.print(curr.data + " ");
				
				if(curr.left != null) {
					q2.add(curr.left);
				}
				if(curr.right != null) {
					q2.add(curr.right);
				}
			}
			Queue<BinaryTreeNode<Integer>> temp = new LinkedList<BinaryTreeNode<Integer>>();
			temp = q1;
			q1 = q2;
			q2 = temp;
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		//printTreeDetailed(root);
		printLevelWise(root);
	}

}
