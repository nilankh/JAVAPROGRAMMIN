package binaryTrees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PathSumRootToLeaf {
	
	
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
	
	
	public static void rootToLeafPathSumToKHelper(BinaryTreeNode<Integer> root, ArrayList<Integer>path, int k) {
		if(root == null) {
			return;
		}
		path.add(root.data);
		if(root.left == null && root.right == null && root.data == k) {
//			System.out.print(path + root.data);
//			path.add(root.data);
			for(int i : path) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
//		path.add(root.data);
		
		rootToLeafPathSumToKHelper(root.left, path, k - root.data);
		rootToLeafPathSumToKHelper(root.right, path, k - root.data);
		path.remove(path.size() - 1);
		return;
		
		
		
	}
	public static void rootToLeafPathSumToK(BinaryTreeNode<Integer>root, int k) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		rootToLeafPathSumToKHelper(root, path, k);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
//		printTreeDetailed(root);
		int k = s.nextInt();
		rootToLeafPathSumToK(root,k);
	}

}
