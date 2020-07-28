package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildTreeUsingInorderAndPreOrder {
	
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
	
//	helper FUnction
	public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int[] pre,int[] in, int siPre, int eiPre, int siIn, int eiIn){
		
		if(siPre > eiPre) {
			return null;
		}
		
		int rootData = pre[siPre];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		int rootIndex = -1;
		for(int i = siIn; i <= eiIn; i++) {
			if(in[i] == rootData) {
				rootIndex = i;
				break;
			}
		}
//		 I am assuming that root actually is present in inOrder.
		
		int siPreLeft = siPre + 1 ;
		int siInLeft = siIn;
		int eiInLeft = rootIndex - 1;
		int siInRight = rootIndex + 1;
		int eiPreRight = eiPre;
		int eiInRight =eiIn;
		
		int leftSubTreeLength = eiInLeft - siInLeft + 1;
		
		int eiPreLeft = siPreLeft + leftSubTreeLength - 1;
		int siPreRight = eiPreLeft + 1;
		
		
		BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(pre, in, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
		BinaryTreeNode<Integer> right = buildTreeFromPreInHelper(pre,in,siPreRight, eiPreRight, siInRight, eiInRight);
		root.left = left;
		root.right = right;
		
		return root;
	}
	
	
	public static BinaryTreeNode<Integer> buildTreeFromPreIn(int pre[], int in[]){
		
		BinaryTreeNode<Integer> root = buildTreeFromPreInHelper(pre, in, 0, pre.length - 1, 0, in.length - 1);
		
		return root;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int in[] = {4,2,5,1,3};
		int pre[] = {1,2,4,5,3};
		BinaryTreeNode<Integer> root = buildTreeFromPreIn(pre, in);
		printTreeDetailed(root);
	}

}
