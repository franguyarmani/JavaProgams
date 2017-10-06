

import java.util.LinkedList;

public class MyStack {
	LinkedList<Object> Stack;
	
	public MyStack() {	
		Stack = new LinkedList<Object>();
	}
	
	public void push(char c) {
		Stack.addFirst(c);
	}
	
	public Object top() {
		return Stack.getFirst();
	}

	public Object pop() {
		Object x =  Stack.removeFirst();
		return x;
	}
	
	public boolean empty() {
		if (Stack.isEmpty() == true) {
			return true;
		}
		return false;
	}
	
}
