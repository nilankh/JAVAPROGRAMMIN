package linkedList;
import java.util.Scanner;

public class DeleteEveryMN {

	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
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
	
	public static Node<Integer> skipMdeleteN(Node<Integer> head, int m, int n){
		if(m == 0) {
			return null;
		}
		Node<Integer> curr = head, t;
		int count;
		while(curr != null) {
			for(count = 1; count < m && curr != null; count++) {
				curr = curr.next;
			}
			if(curr == null) {
				return head;
			}
			t = curr.next;
			for(count = 1; count <= n && t != null; count++) {
				t = t.next;
			}
			curr.next = t;
			curr = t;
		}
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Node<Integer> head = takeInput();
		int m = s.nextInt();
		int n = s.nextInt();
		print(skipMdeleteN(head, m, n));
	}

}
