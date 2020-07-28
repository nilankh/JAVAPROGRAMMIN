package linkedList;
import java.util.Scanner;

class DoubleNode{
	Node<Integer> head;
	Node<Integer> tail;
	DoubleNode(){
		
	}
	DoubleNode(Node<Integer> head, Node<Integer> tail){
		this.head = head;
		this.tail = tail;
	}
}
public class ReverseLLbetterApproach {
	
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
	
	public static DoubleNode reverseRbetter(Node<Integer> head){
		DoubleNode ans;
		if(head == null || head.next == null) {
//			ans = new DoubleNode(head, head);(ye line v sahi h par isko chalane ke lia neeche ka 2 line comment kr do
			ans = new DoubleNode();
			ans.head = head;
			ans.tail = head;
			
			return ans;
		}
		//this double node will have both head and tail of reverse LL 
		DoubleNode smallAns = reverseRbetter(head.next);
		smallAns.tail.next = head;
		head.next = null;
		ans = new DoubleNode();
		ans.head = smallAns.head;
		ans.tail = head;
		return ans;
	}
	
	public static Node<Integer> reverseRbetter1(Node<Integer> head){
		DoubleNode ans = reverseRbetter(head);
		return ans.head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
//		DoubleNode ans = reverseRbetter(head);
		head = reverseRbetter1(head);
		printR(head);
	}

}
