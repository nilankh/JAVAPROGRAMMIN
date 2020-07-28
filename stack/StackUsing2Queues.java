package stack;

import java.util.LinkedList;

import java.util.Queue;

import queues.QueueUsingTwoStack;

public class StackUsing2Queues<T> {
	private Queue<T> queue1;
	private Queue<T> queue2;

	public StackUsing2Queues() {
		this.queue1 = new LinkedList<>();
		this.queue2 = new LinkedList<>();
	}
	public Queue<T>getQueue(){ 
		return this.queue1;
	}
	public void push(T data) {
		this.queue1.add(data);
	}
	public T pop() {
		if(this.isEmpty()) {
			return null;
		}
		while(this.queue1.size() > 1) {
			this.queue2.add(this.queue1.remove());
		}
		T front = this.queue1.remove();

		this.queue2.add(front);
		Queue<T> temp = this.queue1;
		this.queue1 = this.queue2;
		this.queue2 = temp;
		return front;
	}
	public int getSize() {
		return this.queue1.size();
	}
	public boolean isEmpty() {
		return this.queue1.isEmpty();
	}
	public static void main(String[] args) {
		StackUsing2Queues<Integer> stack = new StackUsing2Queues<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
			System.out.println(stack.pop());
			//		System.out.println(stack.pop());
		
	}
}
