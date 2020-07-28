package linkedList;
import java.util.Scanner;
public class AppendLastNToFirst {

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
	
	public static int LengthOfLL(Node<Integer> head) {
		Node<Integer> temp = head;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	public static Node<Integer> appendLastNToFirst(Node<Integer>head, int n){
		Node<Integer> temp = head;
		int count = LengthOfLL(temp) - n;
		int i = 1;
		Node<Integer> curr = head;
		while(i < count) {
			curr = curr.next;
			i++;
		}
		Node<Integer> head2 = curr.next;
		curr.next = null;
		Node<Integer> tail = head2;
		while(tail.next != null) {
			tail = tail.next;
		}
		tail.next = head;
		return head2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		head = appendLastNToFirst(head, n);
		print(head);
	}

}
