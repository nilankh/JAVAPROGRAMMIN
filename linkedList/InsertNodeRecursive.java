package linkedList;

import java.util.Scanner;

public class InsertNodeRecursive {

	public static void printR(Node<Integer> head) {
		if(head == null) {
			return;
		}
		System.out.print(head.data + " ");
		printR(head.next);
	}


	public static Node<Integer> takeInput() {

		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null,tail = null;
		while(data != -1) {
			Node<Integer>currentNode = new Node<Integer>(data);
			if(head == null) {
				//Make this Node as head Node and tail Node
				head = currentNode;
				tail = currentNode;
			}else {
				tail.next = currentNode;
				tail = currentNode;//(or)tail = tail.next;
			}
			data = s.nextInt();
		}
		return head;
	}

	public static Node<Integer> insertR(Node<Integer> head, int elem, int pos){

		if(head == null && pos > 0) {//pos>0 means suppose some 1 enter null,20,0 now it will be inserted at 0th position 
			return head;
		}
		if(pos == 0) {
			Node<Integer> newNode = new Node<>(elem);
			newNode.next = head;
			return newNode;
		}else {
			Node<Integer> smallerHead = insertR(head.next, elem, pos - 1);
			head.next = smallerHead;
			return head;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		head = insertR(head, 20, 2);
//		head = insertR(null, 20, 0);
		printR(head);
	}

}
