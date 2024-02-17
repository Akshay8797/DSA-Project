package recursion;

public class Print1ToN {

	// S(n): O(n)
	static void print1ToN(int n) {
		if (n < 1)
			return;
		print1ToN(n - 1);
		System.out.print(n + " ");
	}

	// S(n): O(1)
	static void print1ToNTailRecursive(int n, int k) {
		if (n < 1)
			return;
		System.out.print(k + " ");
		print1ToNTailRecursive(n - 1, ++k);
	}

	public static void main(String[] args) {
		print1ToN(6);
		System.out.println("\n");
		print1ToNTailRecursive(5, 1); // k=1 initially
	}

}
