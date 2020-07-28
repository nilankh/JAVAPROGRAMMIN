package linkedList;
import java.util.Scanner;
public class FindANodeInLL {

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

	public static int findANode(Node<Integer> head, int n){
		if(head == null) {
			return -1;
		}
		int count = 0;
		Node<Integer> curr = head;
		while(curr != null) {
			if(curr.data == n){
				return count;
			}else {
				curr = curr.next;
				count++;

			}
		}
		return -1;
	}
	
	public static int findANodeR(Node<Integer> head, int n, int index) {
		if(head == null) {
			return -1;
		}
		if(head.data == n) {
			return index;
		}
		return findANodeR(head.next, n, index + 1);
		
	}
	
	public static int findANodeRR(Node<Integer> head, int n) {
		if(head == null) {
			return -1;
		}
		if(head.data == n) {
			return 0;
		}
		int result = findANodeRR(head.next, n);
		if(result == -1){
			return -1;
		}
		return 1 + result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
//		int k = findANode(head,n);
//		System.out.println(k);
		
//		System.out.println(findANode(head,n));
//		System.out.println(findANodeR(head, n, 0));
		System.out.println(findANodeRR(head, n));
		
		//		head = findANode(head,5);
//		System.out.println(head);
		

	}

}
