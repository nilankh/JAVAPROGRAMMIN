package linkedList;

public class LengthOFLL {
public static Node<Integer> createLinkedList(){
	Node<Integer> n1;
	n1 = new Node<>(10);
	Node<Integer> n2 = new Node<>(20);
	Node<Integer> n3 = new Node<>(30);
	Node<Integer> n4 = new Node<>(40);
	
	n1.next = n2;
	n2.next = n3;
	n3.next = n4;
	return n1;
}
	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		while(temp!= null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
	}
	public static int LengthOfLL(Node<Integer> head) {
		Node<Integer> temp = head;
		int count = 0;
		while(temp!= null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head =createLinkedList();
		print(head);
		System.out.println(LengthOfLL(head));
//		while(temp!= Null) {
//			
//		}
	}

}
