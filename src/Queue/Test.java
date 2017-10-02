package Queue;
//Author: Sandesh Paudel
public class Test {

	public static void main(String[] args) {
		
		LinkedList<Integer> theLinkedList = new LinkedList<Integer>();
		theQueue<Integer> q = new theQueue<Integer>(theLinkedList);
		
		
		//is the queue empty?
		System.out.println("Queue is Empty?-" + q.isEmpty());
		 q.enqueue(5);
		 q.enqueue(6);
		 q.enqueue(7);
		 q.enqueue(8);
		 q.enqueue(9);
		 
		//is the queue empty?
		 System.out.println("Queue is Empty now?-" + q.isEmpty());
		 
		 //peek at the first item
		 System.out.println("Peek: " + q.peek());
		 
		 q.dequeue();
		 q.dequeue();
		 
		 //peek at the first item
		 System.out.println("Peek: " + q.peek());
		 
		 
		 //dequeuing until all the items are removed
		 q.dequeue();
		 q.dequeue();
		 q.dequeue();
		 q.dequeue();
		 
		//peek at the first item
		 System.out.println("Peek: " + q.peek());
		 

	}

}
