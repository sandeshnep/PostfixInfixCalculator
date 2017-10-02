package Stack;
//Author: Sandesh Paudel

public class theStack <AnyType> implements Stack <AnyType> {
	
	
	//reference to linked list
	public LinkedLists<AnyType> linkedlist = new LinkedLists<>();
	
	//Constructor instantiating the linked list?
	public theStack(LinkedLists<AnyType>listin){
		linkedlist = listin;
	}
	
	

	@Override
	public boolean isEmpty() {
		return linkedlist.isEmpty();
	}

	@Override
	public void push(AnyType x) {
		linkedlist.addFirst(x);
	}

	@Override
	public AnyType pop() {
		if(isEmpty()==true){
			return null;
		}
		else
		return linkedlist.removeFirst();
	}

	
	@Override
	public Node<AnyType> peek() {
		return linkedlist.head;
	}

	
	
	@Override
	public String toString() {
	    return linkedlist.toString();
	}

}
