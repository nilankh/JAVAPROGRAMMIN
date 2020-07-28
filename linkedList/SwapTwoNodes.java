package linkedList;
import java.util.Scanner;
public class SwapTwoNodes {
	
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
	
	
	public static Node<Integer> swap_nodes(Node<Integer>head, int i, int j){
		Node<Integer> curr = head;
		Node<Integer>prev = null, previ = null, curri = null, prevj = null, currj = null;
		int pos = 0;
		while(curr != null) {
			if(pos == i) {
				previ = prev;
				curri = curr;
			}else if(pos == j) {
				prevj = prev;
				currj = curr;
			}
			prev = curr;
			curr = curr.next;
			pos++;
		}
//		if(curri == null || currj == null) {
//			return;
//		}
		if(previ == null) {
			head = currj;
		}else {
			previ.next = currj;
		}
		if(prevj == null) {
			head = curri;
		}else {
			prevj.next = curri;
		}
		Node<Integer> temp = curri.next;
//		curr = curri.next;
		curri.next = currj.next;
		currj.next = temp;
		return head;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Node<Integer> head = takeInput();
//		printR(head);
		int i = s.nextInt();
		int j = s.nextInt();
		printR(swap_nodes(head, i, j));
		
		
	}

}
