package linkedList;
import java.util.Scanner;
public class InsertNodeInLL {

	public static void print(Node<Integer> head) {
		//System.out.println(" print " + head);
		Node<Integer> temp = head;
		while(temp != null) {
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println();

	}

	public static Node<Integer> takeInput() {

		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null,tail = null;
		while(data != -1) {
			Node<Integer>currentNode = new Node<Integer>(data);
			if(head == null) {
				//Make this Node as head Node and tail Node
				head = currentNode;
				tail = currentNode;
			}else {
				tail.next = currentNode;
				tail = currentNode;//(or)tail = tail.next;
			}
			data = s.nextInt();
		}
		return head;
	}

	public static Node<Integer> insert(Node<Integer>head,int elem,int pos) {
		//upar return type node h line no 36
		Node<Integer>nodeToBeInserted = new Node<Integer>(elem);

		if(pos == 0) {
			nodeToBeInserted.next = head;
			//head = nodeToBeInserted;jaruri ni h ikhne ka likh v skte h
			return nodeToBeInserted;
		}else {

			int count = 0;
			Node<Integer>prev = head;
			while(count < pos - 1 && prev != null) {
				count++;
				prev = prev.next;
			}
			if(prev!= null) {
				nodeToBeInserted.next = prev.next;
				prev.next = nodeToBeInserted; 
			}
			return head;

		}//			print(head)
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		head = insert(head,80,0);
		print(head);

	}

}
