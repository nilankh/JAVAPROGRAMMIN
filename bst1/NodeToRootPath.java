package bst1;

import java.util.ArrayList;
import java.util.Scanner;

import binaryTrees.BinaryTreeNode;

public class NodeToRootPath {

	public static BinaryTreeNode<Integer> treeInputBetter(boolean isRoot, int parentData,boolean isLeft){
		if(isRoot) {
			System.out.println("Enter Root Data :");
		}else {
			if(isLeft) {
				System.out.println("Enter Left Child of " + parentData);
			}else {
				System.out.println("Enter Right Child of " + parentData);
			}
		}
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		BinaryTreeNode<Integer> leftChild = treeInputBetter(false, rootData, true);
		BinaryTreeNode<Integer> rightChild = treeInputBetter(false, rootData, false);
		root.left = leftChild;
		root.right = rightChild;
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

	public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer>root, int x){
		if(root == null) {
			return null;
		}
		if(root.data == x) {
			ArrayList<Integer> output = new ArrayList<Integer>();
			output.add(root.data);
			return output;
		}
		ArrayList<Integer> leftOutput = nodeToRootPath(root.left, x);
		if(leftOutput != null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		ArrayList<Integer> rightOutput = nodeToRootPath(root.right, x);
		if(rightOutput != null) {
			rightOutput.add(root.data);
			return rightOutput;
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = treeInputBetter(true, 0, true);
		int elem = s.nextInt();
		ArrayList<Integer> path = nodeToRootPath(root,elem);
		if(path == null) {
			System.out.println("Not FOund");
		}else {
			for(int i : path) {
				System.out.print(i + " ");
			}
		}
	}

}
