package linkedList;
import java.util.Scanner;
public class Kreverse {
	
	public static void printR(Node<Integer> head) {
		if(head == null) {
			return;
		}
		System.out.print(head.data+ " ");
		printR(head.next);
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
	
	
	public static Node<Integer> kReverse(Node<Integer> head, int k){
		Node<Integer> current = head;
		Node<Integer> next = null;
		Node<Integer> prev = null;
		int count = 0;
		
		while(count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		
		if(next != null) {
			head.next = kReverse(next, k);
		}
		return prev;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Node<Integer> head = takeInput();
//		printR(head);
		int k = s.nextInt();
		printR(kReverse(head, k));
		
	}


}



