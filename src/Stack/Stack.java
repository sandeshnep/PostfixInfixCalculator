package Stack;
//Author: Sandesh Paudel

//generic stack interface as follows:
public interface Stack<AnyType> {
	public boolean isEmpty();
	public void push(AnyType x);
	public AnyType pop();
	public Node<AnyType> peek();
} 