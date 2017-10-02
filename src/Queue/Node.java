package Queue;
//Author: Sandesh Paudel

public class Node<AnyType>{
     
    private Node<AnyType> previous;
    public Node<AnyType> next;
    private AnyType value;
     
    
    public Node<AnyType> getPrevious() {
        return previous;
    }
    
    
    public void setPrevious(Node<AnyType> previous) {
        this.previous = previous;
    }
    
    
    public Node<AnyType> getNext() {
        return next;
    }
    
    
    public void setNext(Node<AnyType>first) {
        this.next = first;
    }
    
    
    public AnyType getValue() {
        return value;
    }
    
    public String toString(){
		return value.toString();
	}
    
    
    public void setValue(AnyType value) {
        this.value = value;
    }

}

