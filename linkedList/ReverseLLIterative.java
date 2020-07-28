package linkedList;
import java.util.Scanner;
public class ReverseLLIterative {
	
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
	
	public static Node<Integer> reverseLLI(Node<Integer> head){
		
		Node<Integer> prev = null;
		Node<Integer> curr = head;
		Node<Integer> nextV;
		while(curr != null) {
			
			nextV = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextV;
		}
		head = prev;
		return head;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
//		printR(head);
		Node<Integer> ans = reverseLLI(head);
		printR(ans);
	}

}
