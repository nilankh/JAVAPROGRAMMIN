package binaryTrees;
import java.util.Scanner;
public class TreeInput {

	public static BinaryTreeNode<Integer> treeInput(){
		System.out.println("Enter root data: ");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();

		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		BinaryTreeNode<Integer> leftChild = treeInput();
		BinaryTreeNode<Integer> rightChild = treeInput();
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}

	public static BinaryTreeNode<Integer> treeInputBetter(boolean isRoot, int parentData, boolean isLeft){
		if(isRoot) {
			System.out.println("Enter root data: ");
		}else {
			if(isLeft) {
				System.out.println("Enter Left child of " + parentData);
			}else {
				System.out.println("Enter right child of " + parentData);
			}

		}
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();

		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		BinaryTreeNode<Integer> leftChild =  treeInputBetter(false, rootData, true);
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

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = treeInputBetter(true, 0, true);
		printTreeDetailed(root);
	}

}
