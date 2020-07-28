package queues;

public class QueueUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		QueueUsingArray queue = new QueueUsingArray();
		
		QueueUsingLL<Integer> queue = new QueueUsingLL<>();
		
		int arr[] = {10, 20, 30, 40, 50};
		for(int elem : arr) {
//			try {
				queue.enqueue(elem);
//			}catch(QueueFullException e) {
//			
//			} 
		}
		while(! queue.isEmpty()) {
			try {
				System.out.println(queue.dequeue());
			}catch(QueueEmptyException e) {
				//WILL NEVER REACH HERE
			}
		}
	}

}
