package problems;

public class DecimalToBinary {

	// T(n): O(log(n)), S(n): O(log(n))
	static void decimalToBinaryUsingArray(int n) {
		int[] binary = new int[32]; // assuming 32 bit int
		int i = 0;
		while (n > 0) {
			binary[i] = n % 2;
			n /= 2;
			i++;
		}
		for (int j = i - 1; j >= 0; j--) {
			System.out.print(binary[j]);
		}
		System.out.println();
	}

	// T(n): O(1), S(n): O(1)
	static void decimalToBinaryUsingBitwiseOps(int n) {
		for (int i = 31; i >= 0; i--) { // assuming 32 bit int
			int k = n >> i;
			if ((k & 1) > 0)
				System.out.print("1");
			else
				System.out.print("0");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		decimalToBinaryUsingArray(11);
		decimalToBinaryUsingBitwiseOps(17);
	}

}
