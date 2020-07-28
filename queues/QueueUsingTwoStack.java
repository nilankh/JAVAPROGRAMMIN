package queues;

import java.util.Stack;


public class QueueUsingTwoStack<T> {
	Stack<T> s1;
	Stack<T> s2;

	public QueueUsingTwoStack() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	public void enqueue(T elem) {
		while(! s1.isEmpty()) {
			s2.push(s1.pop());
		}
		//push item to s1
		s1.push(elem);

		while(! s2.isEmpty()) {
			s1.push(s2.pop());
			//s2.pop();
		}
	}
	public T dequeue() {
		if(s1.isEmpty()) {
			System.out.println("Q is empty");
			System.exit(0);
		}
		//Return top of s1
		T elem = s1.peek();
		s1.pop();
		return elem;
	}

	public static void main(String[] args) {
		QueueUsingTwoStack<Integer> queue = new QueueUsingTwoStack<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
