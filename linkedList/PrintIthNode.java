package linkedList;
import java.util.Scanner;

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		this.data = data;
	}
}


public class PrintIthNode {
	
	
	
	public static void printI(LinkedListNode<Integer> head, int i) {
		int count = 0;
		if(head == null) {
			return;
		}
		LinkedListNode<Integer> temp = head;
		while(temp != null && count < i) {
			temp = temp.next;
			count ++;
		}
		if(temp != null) {
			System.out.println(temp.data);
		}
	}
	
	
	
	
	
	
static Scanner s = new Scanner(System.in);
	
	public static LinkedListNode<Integer> takeInput() {
		LinkedListNode<Integer> head = null, tail = null;
		int data = s.nextInt();
		while(data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static void print(LinkedListNode<Integer> head){
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode<Integer> head = takeInput();
		int pos = s.nextInt();
		printI(head, pos);
	}

}
