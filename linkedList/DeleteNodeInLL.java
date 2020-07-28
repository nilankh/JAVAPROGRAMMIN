package linkedList;
import java.util.Scanner;
public class DeleteNodeInLL {
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
			Node<Integer>currentNode = new Node<Integer>(data);
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
	public static Node<Integer> deleteIthNode(Node<Integer>head,int i){
			if(head == null) {
				return head;
			}
			if(i == 0) {
				return head.next;
			}
			int count = 0;
			Node<Integer> temp = head;
			while(temp != null && count < i -1) {
				temp = temp.next;
				count++;
			}
			if(temp == null) {
				return head;
			}
			if(temp.next != null) {
				temp.next = temp.next.next;
			}
			return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		head = deleteIthNode(head,0);
		print(head);
	}

}
