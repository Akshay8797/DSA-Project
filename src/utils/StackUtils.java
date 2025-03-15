package utils;

public class StackUtils {

	public static void stackFullError(int x) {
		System.out.println("Push " + x + " failed - Stack is full!");
	}

	public static Integer stackEmptyError(String action) {
		if (action.equalsIgnoreCase("Pop"))
			System.out.println("Pop failed - Stack is empty!");
		else if (action.equalsIgnoreCase("Peek"))
			System.out.println("Peek failed - Stack is empty!");
		return null;
	}

}
