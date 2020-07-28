package bst1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTrees.BinaryTreeNode;
import linkedList.Node;



public class BSTtoLL {
	
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
	
	public static Node<Integer> BSTToSortedLL(BinaryTreeNode<Integer> root){
		if(root == null) {
			return null;
		}
		Node<Integer> curr = new Node<Integer>(root.data);
		Node<Integer> left = BSTToSortedLL(root.left);
		Node<Integer> right = BSTToSortedLL(root.right);
		
		if(left == null) {
			curr.next = right;
			return curr;
		}else {
			Node<Integer> temp = left;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = curr;
			curr.next = right;
			return left;
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		Node<Integer> ans = BSTToSortedLL(root);
		while(ans != null) {
			System.out.print(ans.data + " ");
			ans = ans.next;
		}

	}

}
