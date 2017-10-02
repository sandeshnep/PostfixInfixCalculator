package Stack;
//Author: Sandesh Paudel

public class Test {
	
	public static void main(String[] args) {
		
		LinkedLists<Integer> theLinkedList = new LinkedLists<Integer>();
		theStack<Integer> st = new theStack<Integer>(theLinkedList);
		
		System.out.println("Stack is empty?-" + st.isEmpty());
		st.push(50);
		st.push(40);
		st.push(30);
		st.push(20);
		
		System.out.println("Stack is empty now?-" + st.isEmpty());
		//testing the pushed method by printing out the peek() method;
		System.out.println("Peek: " + st.peek());
		
		st.pop();
		st.pop();
		//testing out pop
		System.out.println("Peek: " + st.peek());
	
		//pop till empty
		st.pop();
		st.pop();
		System.out.println("Peek: " + st.peek());
	}

}
