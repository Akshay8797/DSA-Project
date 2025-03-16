package utils;

public class StackUtils {

	public static void stackFullError(int x) {
		System.err.println("Push " + x + " failed - Stack is full!");
	}

	public static void stackFullError(int x, int stackNum) {
		System.err.println("Push " + x + " failed - Stack " + stackNum + " is full!");
	}

	public static Integer stackEmptyError(String action) {
		if (action.equalsIgnoreCase("Pop"))
			System.err.println("Pop failed - Stack is empty!");
		else if (action.equalsIgnoreCase("Peek"))
			System.err.println("Peek failed - Stack is empty!");
		else
			System.err.println("Stack is empty!");
		return null;
	}

	public static Integer stackEmptyError(String action, int stackNum) {
		if (action.equalsIgnoreCase("Pop"))
			System.err.println("Pop failed - Stack " + stackNum + " is empty!");
		else if (action.equalsIgnoreCase("Peek"))
			System.err.println("Peek failed - Stack " + stackNum + " is empty!");
		else
			System.err.println("Stack " + stackNum + " is empty!");
		return null;
	}

}
