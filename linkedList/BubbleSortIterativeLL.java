package linkedList;
import java.util.Scanner;
public class BubbleSortIterativeLL {
	
	
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
		Node<Integer>head = null, tail = null;
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
		int count = 0;
		while(head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
	public static Node<Integer> bubbleSort(Node<Integer> head){
		if(head == null || head.next == null){
			return head;
		}
		for(int i = 0; i < length(head); i++) {
			Node<Integer> curr = head;
			Node<Integer> prev = null;
			Node<Integer> Next = curr.next;
			while(curr.next != null) {
				if(curr.data > curr.next.data) {
					if(prev == null) {
						curr.next = Next.next;
						Next.next = curr;
						head = Next;
					}else {
						prev.next = curr.next;
						curr.next = Next.next;
						Next.next = curr;
					}
					prev = Next;
					Next = curr.next;
				}else {
					prev = curr;
					curr = curr.next;
					Next = curr.next;
					
				}
			}
			
		}
		return head;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		Node<Integer> k = bubbleSort(head);
		printR(k);
	}

}
