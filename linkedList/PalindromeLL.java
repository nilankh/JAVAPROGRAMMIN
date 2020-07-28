package linkedList;
import java.util.Scanner;
public class PalindromeLL {
	
	public static void printR(Node<Integer> head) {
		if(head == null) {
			return;
		}
		System.out.print(head.data + " ");
		printR(head.next);
	}
	public static boolean isPalindrome(Node<Integer> head) {
		Node<Integer> slow = head, fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		Node<Integer> head1 = head, head2 = slow.next;
		slow.next = null;
		head2 = reverse(head2);
		
		while(head1 != null && head2 != null) {
			if(head1.data != head2.data) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return true;
	}
	
	public static Node<Integer> reverse(Node<Integer> head){
		if(head == null || head.next == null) {
			return head;
		}
		Node<Integer> smallHead = reverse(head.next);
		Node<Integer> reverseTail = head.next;
		reverseTail.next = head;
		head.next = null;
		return smallHead;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer>head = takeInput();
		boolean k = isPalindrome(head);
		if(k) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
//		printR(head);
	}

}
