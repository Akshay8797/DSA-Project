package stack.core;

import java.util.ArrayDeque;
import java.util.Deque;

/*- ArrayDeque is a modern, non-synchronized implementation of Stack.
 * 	Both Stack and ArrayDeque are dynamic array implementations.
 */
public class ArrayDequeStack {

	public static void main(String[] args) {
		// Stack<Integer> stack = new Stack<>();
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("Initial stack: " + stack);
		System.out.println("Empty stack: " + stack.isEmpty());
		System.out.println("Peek: " + stack.peek());
		System.out.println("Popped: " + stack.pop());
		System.out.println("Stack size: " + stack.size());
		System.out.println("Final stack: " + stack);
	}

}
