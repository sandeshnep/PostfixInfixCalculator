//Author: Sandesh Paudel
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Input {
	static ArrayList array = new ArrayList();
	static ArrayList arraypost = new ArrayList();
	
	public static void readfile(){
		
		
		try {
			Scanner in = new Scanner(new FileReader ("infix_expr_short.txt"));
			
			//takes advantage of the hasNextLine function to take in the input
			while(in.hasNextLine()==true){
				array.add(in.nextLine());
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("error: " + e.getMessage() + " cannot be opened");
		}
	}
	
	
	public static void readfilepost(){ //reads the file contaiting postfix notation
		
		
		try {
			Scanner in = new Scanner(new FileReader ("postfix.txt"));
			
			//takes advantage of the hasNextLine function to take in the input
			while(in.hasNextLine()==true){
				arraypost.add(in.nextLine());
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("error: " + e.getMessage() + " cannot be opened");
		}
	}

}
