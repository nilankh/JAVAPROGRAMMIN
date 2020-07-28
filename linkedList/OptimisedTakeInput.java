package linkedList;
import java.util.Scanner;
public class OptimisedTakeInput {
	
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
//					Node<Integer> tail = head;
//					while(tail.next != null) {
//						tail = tail.next;
//					}
					//Now tail will refer to last Node
					//Connect current Node after last node 
					tail.next = currentNode;
					tail = currentNode;//(or)tail = tail.next;
				}
				data = s.nextInt();
			}
			return head;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Node<Integer> head = takeInput();
			print(head);

		}

	}
