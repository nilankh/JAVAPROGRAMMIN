package binaryTrees;
import java.util.Scanner;
public class IsBalancedImproved {

	public static BinaryTreeNode<Integer> treeInputBetter(boolean isRoot, int parentData, boolean isLeft){
		if(isRoot){
			System.out.println("ENter root data :");
		}else {
			if(isLeft){
				System.out.println("Enter left child of " + parentData);
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

	public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			int height = 0;
			boolean isBal = true;
			BalancedTreeReturn ans = new BalancedTreeReturn();
			ans.height = height;
			ans.isBalanced = isBal;
			return ans;
		}
		BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
		BalancedTreeReturn rightOutput = isBalancedBetter(root.right);
		boolean isBal = true;
		int height = 1 + Math.max(leftOutput.height, rightOutput.height);

		if(Math.abs(leftOutput.height - rightOutput.height) > 1) {
			isBal = false;
		}
		if(!leftOutput.isBalanced || !rightOutput.isBalanced) {
			isBal = false;
		}
		BalancedTreeReturn ans = new BalancedTreeReturn();
		ans.height = height;
		ans.isBalanced = isBal;
		return ans;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = treeInputBetter(true, 0, true);
		printTreeDetailed(root);
	}

}
