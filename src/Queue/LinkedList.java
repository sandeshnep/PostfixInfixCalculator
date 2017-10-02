package Queue;
//Author: Sandesh Paudel

//Doubly linked list
public class LinkedList<AnyType> implements SimpleLinkedList<AnyType> {
 
    public Node<AnyType> first;
    public Node<AnyType> last;
    
    
    //inserts stuff at the front of the list
    @Override
    public void insertfirst(AnyType x){
        //System.out.println("Added to the first: " + x);
        Node<AnyType> nod = new Node<AnyType>();
        nod.setValue(x);
        nod.setNext(first);
        if(first != null) first.setPrevious(nod);
        if(first == null) last = nod;
        first = nod;
    }
     
    
    @Override
    //inserts stuff at the end of the list
    public void insertlast(AnyType x){
        
       //System.out.println("adding at last: "+x);
    	Node<AnyType> nod = new Node<AnyType>();
        nod.setValue(x);
        nod.setPrevious(last);
        if(last != null) last.setNext(nod);
        if(last == null) first = nod;
         
        last = nod;
    }
     
    
    @Override
    //removes the first stuff in the queue
    public void removefirst(){
        if(first == null){
            System.out.println("Null. Unable to remove.");
            return;
        }
     
        Node<AnyType> tempfirst = first.getNext();
        if(tempfirst != null) tempfirst.setPrevious(null);
        if(tempfirst == null) last = null;
        first = tempfirst;
    }
     
    
    @Override
    //removes the last stuff in the queue.
    public void removelast(){
        if(last == null){
            System.out.println("Null. Unable to remove");
            return;
        }
        
        Node<AnyType> templast = last.getPrevious();
        if(templast != null) templast.setNext(null);
        if(templast == null) first = null;
        last = templast;
    }
    


	@Override
	public boolean isEmpty() {
		   return first == null;
	}
	
	
}