package bst1;

import binaryTrees.BinaryTreeNode;

public class BSTDeleteReturn {
	BinaryTreeNode<Integer> root;
	boolean deleted;
	
	public BSTDeleteReturn(BinaryTreeNode<Integer> root, boolean deleted) {
		this.root = root;
		this.deleted = deleted;
	}
}
