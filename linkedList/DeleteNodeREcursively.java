package linkedList;

import java.util.Scanner;

public class DeleteNodeREcursively {
	
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
	
	public static int LengthOfLL(Node<Integer> head) {
		Node<Integer> temp = head;
		int count = 0;
		while(temp!= null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public static Node<Integer> deleteIth(Node<Integer> head, int i){
//		if(i >= LengthOfLL(head)) {
//			return head;
//		}
		if(head == null) {
			return null;
		}
		
		if(i == 0) {
			return head.next;
		}
		Node<Integer> smallerHead = deleteIth(head.next, i -1);
		head.next = smallerHead;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		head = deleteIth(head,9);
		printR(head);
		
	}

}
