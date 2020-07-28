package binaryTrees;
import java.util.Scanner;
public class RemoveLeafs {
	
	public static BinaryTreeNode<Integer> treeInputBetter(boolean isRoot, int parentData, boolean isLeft){
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
	
	public static BinaryTreeNode<Integer> removeLeafs(BinaryTreeNode<Integer> root){
		if(root == null) {
			return null;
		}
		if(root.left == null && root.right == null) {
			return null;
		}
		root.left = removeLeafs(root.left);
		root.right = removeLeafs(root.right);
		return root;
		
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = treeInputBetter(true, 0, true);
		printTreeDetailed(root);
		
		BinaryTreeNode<Integer> newRoot = removeLeafs(root);
		printTreeDetailed(newRoot);
	}

}
