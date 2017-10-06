package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SmartParenthesesMatcher {
	static ArrayList<Character> brackets = new ArrayList(
			Arrays.asList('{','}','[',']',')','('));
	static String s;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a String of Parentheses: ");
		s = input.nextLine();
		MyStack Stack = new MyStack();
		if(Checker(s, Stack)) {
			System.out.println("Matched");
		}else {
			System.out.println("Parentheses not matched");
		}
	}
	
	public static boolean Checker(String s, MyStack Stack) {
		
	
		if (!s.isEmpty()) {	
			char c = s.charAt(0);
			if (!brackets.contains(c)) {
				return Checker(s.substring(1), Stack);
			}
			if (Stack.empty()) {
				Stack.push(c);
				return Checker(s.substring(1), Stack);
			}else {
				if (pair(s.charAt(0), (char) Stack.top())){
					Stack.pop();
					return Checker(s.substring(1), Stack);	
				}else {
					Stack.push(s.charAt(0));
					return Checker(s.substring(1), Stack);	
				}
			}
		}
		if (s.isEmpty() && Stack.empty()) {
			return true;
		}
		
		return false;
	}
	
	public static boolean pair(char c1, char c2) {
		if (
				c1 == '(' && c2 == ')' ||
				c1 == '{' && c2 == '}' ||
				c1 == '[' && c2 == ']' ||
				c2 == '(' && c1 == ')' ||
				c2 == '{' && c1 == '}' ||
				c2 == '[' && c1 == ']' 
				) {
			return true;	
		}
		return false;
	}
}
