package bst1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binaryTrees.BinaryTreeNode;
import linkedList.Node;

public class BSTToLLBetterApproach {
	
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
	public static PairOfNodeElem helperOfBstToLL(BinaryTreeNode<Integer> root) {
		if(root == null) {
			PairOfNodeElem ans = new PairOfNodeElem();
			ans.head = null;
			ans.tail = null;
			return ans;
		}
		Node<Integer> curr = new Node<Integer>(root.data);
        PairOfNodeElem left = helperOfBstToLL(root.left);
        PairOfNodeElem right = helperOfBstToLL(root.right);
        PairOfNodeElem final_ans = new PairOfNodeElem();
        if(left.head != null){
            final_ans.head = left.head;
            final_ans.tail = left.tail;
            final_ans.tail.next = curr;
            final_ans.tail = curr; 
            if(right.head == null){
                return final_ans;
            }
        }
        if(right.head != null && left.head != null){
            final_ans.tail.next = right.head;
            final_ans.tail = right.tail;
            return final_ans;
        }
        if(right.head != null && left.head == null){
            final_ans.head = curr;
            curr.next = right.head;
            final_ans.tail = right.tail;
            return final_ans;
        }
        else{
            final_ans.head = curr;
            final_ans.tail = curr;
            //return final_ans;
        
        }
        
        return final_ans;
        
    }
		
	public static Node<Integer> BSTToSortedLL(BinaryTreeNode<Integer> root){
		return helperOfBstToLL(root).head;
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
