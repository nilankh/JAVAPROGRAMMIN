package linkedList;

public class Node<T> {
	//<T>generics q ki hm ni chahte h seperate linked list class banana by changing type
	//we wantthe flexibility to change the type
	public T data;
	public Node<T> next;
	public Node(T data){
		this.data = data;
//		next = null; default value null rehta h hmesha de v skte h nhi v de skte h
	}
	
}

//public class Node{
//	int data;
//	Node next;
//	Node(int data){
//		this.data = data;
////		next = null;
//	}
//}