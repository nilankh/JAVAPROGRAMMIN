package linkedList;
import java.util.Scanner;
public class EvenAfterOddLinkedList {
	
	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ->");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> takeInput(){
		Scanner  s = new Scanner(System.in);
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
	
	public static Node<Integer> oddEven(Node<Integer> head){
		Node<Integer> oddH = null;
		Node<Integer> oddT = null;
		Node<Integer> evenH = null;
		Node<Integer> evenT = null;
		while(head != null) {
			if(head.data % 2 == 1) {
				if(oddH == null) {
					oddH = head;
					oddT = head;
					head = head.next;
				}else {
					oddT.next = head;
					oddT = oddT.next;
					head = head.next;
				}
			}else {
				if(evenH == null) {
					evenH = head;
					evenT = head;
					head = head.next;
				}else {
					evenT.next = head;
					evenT = evenT.next;
					head = head.next;
				}
			}
		}
		if(evenT != null) {
			evenT.next = null;
		}
		if(oddH == null) {
			return evenH;
		}else {
			oddT.next = evenH;
			return oddH;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
//		print(head);
		Node<Integer> result = oddEven(head);
		print(head);
	}

}
