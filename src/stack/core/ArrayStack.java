package stack.core;

public class ArrayStack {

	private static class Stack {
		int top = -1;
		int cap;
		Integer[] arr;

		public Stack(int cap) {
			this.cap = cap;
			arr = new Integer[cap];
		}

		void push(int x) {
			if (top == cap - 1) {
				System.out.println("Push failed - Stack is full!");
				return;
			}
			top++;
			arr[top] = x;
		}

		Integer pop() {
			if (top == -1) {
				System.out.println("Pop failed - Stack is empty!");
				return null;
			}
			int res = arr[top];
			top--;
			return res;
		}

		Integer peek() {
			if (top == -1) {
				System.out.println("Peek failed - Stack is empty!");
				return null;
			}
			return arr[top - 1];
		}

		Integer size() {
			return top + 1;
		}

		Boolean isEmpty() {
			return top == -1;
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack(3);
		stack.push(5);
		stack.push(15);
		stack.push(25);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		stack.push(35);
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
	}

}
