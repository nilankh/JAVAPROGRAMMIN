package bst1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTrees.BinaryTreeNode;

public class ImproveCheckIsBST {
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
	
	public static IsBSTreturn isBST2(BinaryTreeNode<Integer> root) {
		if(root == null) {
			IsBSTreturn ans = new IsBSTreturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
			return ans;
		}
		IsBSTreturn leftAns = isBST2(root.left);
		IsBSTreturn rightAns = isBST2(root.right);
		
		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		boolean isBST = true;
		if(leftAns.max >= root.data) {
			isBST = false;
		}
		if(rightAns.min < root.data) {
			isBST = false;
		}
		if(!leftAns.isBST) {
			isBST = false;
		}
		if(!rightAns.isBST) {
			isBST = false;
		}
		IsBSTreturn ans = new IsBSTreturn(min, max, isBST);
		return ans;  
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		printTreeDetailed(root);
		IsBSTreturn ans = isBST2(root);
		System.out.println(ans.min + " " + ans.max +" " + ans.isBST);
	}

}
