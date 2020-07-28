package linkedList;

public class LinkedListUse2 {

public static Node<Integer> createLinkedList() {
		
		Node<Integer> n1;//sirf ye line likhne se node create ni hoga sirf reference create hoga
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
//		System.out.println(" print " + head);
		Node<Integer> temp = head;
		while(temp != null) {
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println();
		
	}
	public static void increment(Node<Integer>head) {
		//head.data++;
		Node<Integer> temp = head;
		while(temp != null) {
			//System.out.print(temp.data+"->");
			temp.data++;
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Node<Integer> head = createLinkedList();
//		System.out.println(" Main " + head);
		increment(head);
		print(head);
//		print(head);

	}

}
