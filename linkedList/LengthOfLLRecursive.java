package linkedList;
import java.util.Scanner;
public class LengthOfLLRecursive {
	
	
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
	
	public static int length(Node<Integer> head) {
		if(head == null) {
			return 0;
		}else {
			return 1 + length(head.next);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		int k = length(head);
		System.out.println(k);
	}

}
