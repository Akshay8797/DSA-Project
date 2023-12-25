package mathematics;

// Given an int num > 0. Count the digits in the number

public class CountDigits {

	// T(n) = O(d) [d : no. of digits].
	static int count(int num) {
		int digitCount = 0;
		while (num != 0) {
			num /= 10;
			digitCount++;
		}
		return digitCount;
	}

	public static void main(String[] args) {
		System.out.println(count(9235));
	}

}
