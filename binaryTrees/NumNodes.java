package binaryTrees;
import java.util.Scanner;
public class NumNodes {

	public static BinaryTreeNode<Integer> treeInputBetter(boolean isRoot, int parentData, boolean isLeft){
		if(isRoot) {
			System.out.println("Enter root Data: ");
		}else {
			if(isLeft) {
				System.out.println("Enter Left child of " + parentData);
			}else {
				System.out.println("Enter RIght Child of " + parentData);
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
	
	public static int numNodes(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int leftNodeCount = numNodes(root.left);
		int rightNodeCount = numNodes(root.right);
		return 1 + leftNodeCount + rightNodeCount;
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = treeInputBetter(true,0,true);
		printTreeDetailed(root);
		System.out.println("Num Nodes " + numNodes(root));
	}

}
