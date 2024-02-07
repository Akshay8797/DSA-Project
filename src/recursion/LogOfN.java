package recursion;

// Given an int n, return Floor(Log2(n))
public class LogOfN {

	static int logOfN(int n) {
		if (n == 1)
			return 0;
		else
			return 1 + logOfN(n / 2);
	}

	public static void main(String[] args) {
		System.out.println(logOfN(16));
	}

}
