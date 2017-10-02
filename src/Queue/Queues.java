package Queue;
//Author: Sandesh Paudel

//generic Queues interface as follows:
public interface Queues<AnyType> {
	
	public boolean isEmpty();
	public void enqueue(AnyType x);
	public AnyType dequeue();
	public Node<AnyType> peek();
	
} 