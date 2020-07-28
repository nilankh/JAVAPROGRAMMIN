package linkedList;
import java.util.Scanner;
public class ReverseLLRecursiveBestWay {

	public static void printR(Node<Integer> head) {
		if(head == null) {
			return;
		}
		System.out.print(head.data + " ");
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
	
	public static Node<Integer> reverseRBest(Node<Integer> head){
		if(head == null || head.next == null) {
			return head;
		}
		Node<Integer> smallHead = reverseRBest(head.next);
		Node<Integer> reverseTail = head.next;
		reverseTail.next = head;
		head.next = null;
		return smallHead;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Node<Integer> head = takeInput();
			printR(head);
	}

}
