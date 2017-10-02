package Stack;
//Author: Sandsh Paudel

//the SimpleLinkedList was modified to work with stacks, so unnecessary codes were all deleted. 

public interface SimpleLinkedList<AnyType> {
	
	public void addFirst(AnyType x);
	public  AnyType removeFirst();
	public boolean isEmpty();
	String toString();
	
}