package Queue;
//Author: Sandesh Paudel

public class theQueue<AnyType> implements Queues<AnyType>{
	
	//reference to the doubly linked list
	public LinkedList<AnyType> dblylinkedlist = new LinkedList<>();
	
	
	//Constructor instantiating the linked list?
	public theQueue(LinkedList<AnyType> listin){
		dblylinkedlist = listin;
	}
		

	@Override
	public boolean isEmpty() {
		return dblylinkedlist.isEmpty();
	}

	@Override
	public void enqueue(AnyType x) {
		dblylinkedlist.insertfirst(x);
		
	}

	@Override
	public AnyType dequeue() {
		dblylinkedlist.removelast();
		return null;
	}

	@Override
	public Node<AnyType> peek() {
		
		return dblylinkedlist.last;
	}

}
