package binaryTrees;
import java.util.Scanner;
public class IsBalanced {

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
	
	public static int height(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		//abs(-2) = 2
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}
		boolean isLeftBalanced = isBalanced(root.left);
		boolean isRightBalanced = isBalanced(root.right);
		
		return isLeftBalanced && isRightBalanced;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = treeInputBetter(true, 0, true);
		printTreeDetailed(root);
		System.out.println("Is Balanced " + isBalanced(root));
	}

}
