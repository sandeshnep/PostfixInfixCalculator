//Author: Sandesh Paudel
//These are the Stacks and Queues that I created for previous labs
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.math.*;
import Queue.*;
import Queue.Node;
import Stack.*;
import Stack.LinkedLists;



public class Main extends Input{



	public static void main(String[] args) {
		
		System.out.println("Welcome to Infix calculator.");
		System.out.println("Input file is infix_expr_short.txt");
		System.out.println("Output file is my_eval.txt");
		System.out.println("Additionally, a postfix.txt file is created containing postfix expressions");
		
		readfile();
		
		try{
			PrintWriter out = new PrintWriter(new File("postfix.txt"));
		
		//First Loop: Goes through the lines
		for(int i = 0; i<= array.size()-1; i++){//array.size()-1; i++){
			
			String infix = (String) array.get(i);
			//infixrw removes all the whitespaces
			String infixrw = infix.replaceAll("\\s+", "");
			//get all the individual terms. For example, 1.0 + 3 is saperated into 1.0, + , 3 by an array
			String[] infixrws = infixrw.split("((?<=\\+|(?=\\+))|(?<=-|(?=-))|(?<=\\*|(?=\\*))|(?<=/|(?=/))|(?<=\\(|(?=\\())|(?<=\\)|(?=\\)))|(?<=<|(?=<))|(?<=>|(?=>))|(?<==|(?==))|(?<=&|(?=&))|(?<=\\||(?=\\|))|(?<=!|(?=!)))");
			
			
			
			//Queue imports
			//infix
			LinkedList<String> theLinkedList = new LinkedList<String>();
			theQueue<String> infixq = new theQueue<String>(theLinkedList);
			//postfix
			LinkedList<String> theLinkedList2 = new LinkedList<String>();
			theQueue<String> postfixq = new theQueue<String>(theLinkedList2);
			//Stack import
			LinkedLists<String>theLinkedList3 = new LinkedLists<String>();
			theStack<String> stack = new theStack<String>(theLinkedList3);
			
			
			
			//adding the spitted string terms to the queue
			for(int j=0; j<=infixrws.length-1; j++){
				infixq.enqueue(infixrws[j]);
			}
			
				
			//Shunting Yard algorithm
			//While the infix queue has stuff:
				
			while(infixq.isEmpty()==false){
				
				Node<String> pee = infixq.peek();
				String peek = pee.toString();
				
				
				//operator detected
				if(peek.equals("+")||peek.equals("-")||peek.equals("*")||peek.equals("/")||peek.equals("-")||peek.equals("<")||peek.equals(">")||peek.equals("=")||peek.equals("&")||peek.equals("|")||peek.equals("!")||peek.equals("(")||peek.equals(")")){
					
					//If stack is empty; First Cases
					if(stack.isEmpty()==true){
						stack.push(peek);
						infixq.dequeue();
					}
					else
						
						//Stack isnt empty
						{
						//Case1: if the stack element has higher presidence than the infix queue operation
						if((peek.equals("+") || peek.equals("-")) && (stack.peek().equals("*")||stack.peek().equals("/"))){
							
							postfixq.enqueue(stack.pop()); //move the stack element to postfixq
							postfixq.enqueue(" ");         //adds space after to saperate elements
							stack.push(peek);			   //push the infixq element to the stack
							infixq.dequeue();			   //remove that infixq element
						}
						else
							//Case 2: The Stack Element has the Same Presidence as the infix queue operation
							if(peek.equals("+")&&stack.peek().equals("-")||peek.equals("-")&&stack.peek().equals("+")||peek.equals("*")&&stack.peek().equals("/")||peek.equals("/")&&stack.peek().equals("*")){
								
								postfixq.enqueue(stack.pop()); //move the stack element to postfixq
								postfixq.enqueue(" ");         //adds space after to saperate elements
								stack.push(peek);			   //push the infixq element to the stack
								infixq.dequeue();			   //remove that infixq element
							}
							else
								//Case 4: Parenthesis
								if(peek.equals(")")){
									infixq.dequeue(); //removes ")"
									
									postfixq.enqueue(stack.pop());
									postfixq.enqueue(" ");
									
								}
								else
									//Case 5: Stacked operators when not empty AND Case 3: The Stack Element has lower precedence than infix queue operation
									{stack.push(peek);
									infixq.dequeue();}
								
					}						
				}
					
				else{
					//numbers detected
					postfixq.enqueue(peek);
					postfixq.enqueue(" ");
					infixq.dequeue();
				}
				
				
			}
			//Adding the last operators stored in the stack
			if(infixq.isEmpty()==true){
				while(stack.isEmpty()==false){
					postfixq.enqueue(stack.pop());
					postfixq.enqueue(" ");
				}
			}
			
			while(postfixq.isEmpty()==false){
				out.print(postfixq.peek());
				postfixq.dequeue();
			}
			out.println();
			
		
			
		} //original multi expression array close
		
		out.close();
		}catch (FileNotFoundException e) {
			System.out.println("error: " + e.getMessage() + " cannot be opened");
		}
		
		
		
		readfilepost();
		
	try{
			PrintWriter out = new PrintWriter(new File("my_eval.txt"));
		//now I have an array with strings of each line of the postfix code
	
		for(int j = 0; j<=arraypost.size()-1; j++){  //runs through the postfix array
			
			String[] breakstring = arraypost.get(j).toString().split("\\s+"); //makes an array in postfix order
			//Stack import
			LinkedLists<Double>theLinkedList4 = new LinkedLists<Double>();
			theStack<Double> stackpost = new theStack<Double>(theLinkedList4);
			
			for(int k = 0; k<=breakstring.length-1; k++){  //runs through postfix expression
			
				
				String peek = breakstring[k];
				//operator detected
				if(peek.equals("+")||peek.equals("-")||peek.equals("*")||peek.equals("/")||peek.equals("<")||peek.equals(">")||peek.equals("=")||peek.equals("&")||peek.equals("|")||peek.equals("^")||peek.equals("mod")||peek.equals("sin")||peek.equals("cos")||peek.equals("tan")){
					
					double number2=0;
					double number1=0;
					if(stackpost.isEmpty()==false){
						number2=stackpost.pop();
						if(stackpost.isEmpty()==false){
						number1=stackpost.pop();}
					}
					double result;
					if(peek.equals("+")){
						result = number1 + number2;
						stackpost.push(result);
					}
					else
						if(peek.equals("-")){
							result = number1 - number2;
							stackpost.push(result);
						}
						else
							if(peek.equals("*")){
								result = number1 * number2;
								stackpost.push(result);
							}
							else 
								
								if(peek.equals("/")){
									result = number1 / number2;
									stackpost.push(result);
							}
								
								else
									if(peek.equals("<")){
										if(number1<number2==true){
											stackpost.push(1.0);
										}
										else
											if(number1<number2==false){
												stackpost.push(0.0);
											}
									}
									else 
										if(peek.equals(">")){
											if(number1>number2==true){
												stackpost.push(1.0);
											}
											else
												if(number1>number2==false){
													stackpost.push(0.0);
												}
										}
										else
											if(peek.equals("=")){
												if(number1==number2==true){
													stackpost.push(1.0);
												}
												else
													if(number1==number2==false){
														stackpost.push(0.0);
													}
											}
											else
													if(peek.equals("&")){
														if(number1==number2==true){
															stackpost.push(1.0);
														}
														else
															if(number1==number2==false){
																stackpost.push(0.0);
															}
													}
													else
														if(peek.equals("|")){
															if(number1==number2==false){
																stackpost.push(1.0);
															}
															else
																if(number1==number2==true){
																	stackpost.push(0.0);
																}
														}
														else
															if(peek.equals("^")){
																result=Math.pow(number1,number2);
																stackpost.push(result);
															}
															else
																if(peek.equals("mod")){
																	result=number1%number2;
																	stackpost.push(result);
																}
																else
																	if(peek.equals("sin")){
																		result=Math.sinh(number2);
																		stackpost.push(result);
																	}
																	else
																		if(peek.equals("cos")){
																			result=Math.cos(number2);
																			stackpost.push(result);
																		}
																		else
																			if(peek.equals("tan")){
																				result=Math.tan(number2);
																				stackpost.push(result);
																			}
																
														
	
					
				}
				else
					if(peek.equals("!")){
						double number4=stackpost.pop();
							if(number4==0.0){
								stackpost.push(1.0);
							}
							else
							{
								stackpost.push(0.0);
							}
						
						
					}
				else //number detected
				{
					if(breakstring[k].equals("(")==false){
					stackpost.push(Double.parseDouble(breakstring[k]));} //pushes the number to the stack
					
			}
			
		}
			Double solution = stackpost.pop();
			out.print(solution);
			out.println();
			
		}//end of initial for loop
			out.close();
			}catch (FileNotFoundException e) {
				System.out.println("error: " + e.getMessage() + " cannot be opened");
			}
	
		
	}
	
	

}
