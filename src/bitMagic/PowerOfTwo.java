package bitMagic;

public class PowerOfTwo {

	// T(n) = O(log(n))
	static boolean isPowerOf2(int n) {
		if (n == 0)
			return false;
		while (n != 1) {
			if ((n & 1) != 0) // if(n%2 != 0)
				return false;
			n >>= 1;
		}
		return true;
	}

	// T(n) = O(1)
	static boolean isPowerOf2Ef(int n) {
		if (n == 0)
			return false;
		return ((n & (n - 1)) == 0);
	}

	public static void main(String[] args) {
		System.out.println(isPowerOf2(4));
		System.out.println(isPowerOf2Ef(8));
	}

}
