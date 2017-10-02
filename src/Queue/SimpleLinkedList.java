package Queue;
//Author: Sandesh Paudel

//the SimpleLinkedList was modified to work with queues, so unnecessary codes were all deleted. 

public interface SimpleLinkedList<AnyType> {
	
	public void insertfirst(AnyType x);
	public void insertlast(AnyType x);
	public void removefirst();
	public void removelast();
	public boolean isEmpty();
	String toString();
	
}