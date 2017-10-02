package Stack;
//Author: Sandesh Paudel
public class Node <AnyType>{
	public AnyType data;
	public Node<AnyType> next;  //kind of recursive
	
	public Node(AnyType data){
		this.data = data;
	}
	
	public String toString(){
		return data.toString();
	}

	public void printList() {
		System.out.println(data);
		
	}

}

