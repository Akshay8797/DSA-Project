package problems;

public class MethodCall {

	/*- From two overloaded methods. The specific one is chosen.
	 *  This is compile-time polymorphism.
	 */
	public static void main(String[] args) {
		callMethod(null);
	}

	@SuppressWarnings("unused")
	private static void callMethod(Object object) {
		System.out.println("Object Method Called");
	}

	private static void callMethod(String string) {
		System.out.println("String Method Called");
	}

}
