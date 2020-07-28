package linkedList;
import java.util.Scanner;
public class PrintReverseLL {
	
	public static void print(Node<Integer> head) {
		Node<Integer> temp;
		temp = head;
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null, tail = null;
		while(data != -1) {
			Node<Integer> currentNode = new Node<Integer>(data);
			if(head == null) {
				head = currentNode;
				tail = currentNode;
			}else {
				tail.next = currentNode;
				tail = currentNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	
//	public static void reverseLL(Node<Integer> head){
//		
//		if(head == null) {
//			return;
//		}
//		reverseLL(head.next);
//		System.out.print(head.data + " ");
//		
//	
//	}
	
	public static Node<Integer> reverseLL(Node<Integer> head){
		Node<Integer> curr = head;
		Node<Integer> prev = null;
		Node<Integer> next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head;
		head = takeInput();
		head = reverseLL(head);
		print(head);
	}

}
