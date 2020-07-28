package linkedList;
import java.util.Scanner;
public class ElminatesADuplicatesFromLL {
	
	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
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
	//one method
//	public static Node<Integer> removeDuplicates(Node<Integer> head){
//		Node<Integer> t1 = head;
//		if(t1 == null) {
//			return null;
//		}
//		while(t1.next != null) {
//			if(t1.data.equals(t1.next.data)) {
//				t1.next = t1.next.next;
//			}else {
//				t1 = t1.next;
//			}
//		}
//		return head;
//	}
//	
	//another method
	
	public static Node<Integer> removeDuplicates(Node<Integer> head){
		Node<Integer> t1 = head;
		Node<Integer> t2;
		if(t1 == null) {
			return null;
		}else {
			t2 = head.next;
		}
		while(t2 != null) {
			if(t1.data.equals(t2.data)) {
				t1.next = t2.next;
				t2 = t2.next;
			}else {
				t1 = t2;
				t2 = t2.next;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		head = removeDuplicates(head);
		print(head);
	}

}
