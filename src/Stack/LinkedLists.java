package Stack;
//Author: Sandesh Paudel
public class LinkedLists<AnyType> implements SimpleLinkedList<AnyType>{
	
	public Node<AnyType> head = new Node<AnyType>(null);
	
	public LinkedLists(){
		head=null;
	}
	


	//node: both data, reference
	//methods
	@Override
	public void addFirst(AnyType x) {
		Node<AnyType> newNode = new Node<AnyType>(x);
		newNode.next = head;
		head = newNode;
		
	}
	
	@Override
	public AnyType removeFirst() {
		Node<AnyType> oldFirst = head;
		head = head.next;
		return oldFirst.data;
		
	}
	

    public boolean isEmpty() {
        return head == null;
    }


}