package bitMagic;

public class BitwiseOps {

	// I/P: x: 3 => 0...011 , y: 6 => 0...0110 ; O/P: 2 => 0...010
	static int bitwiseAnd(int x, int y) {
		return x & y;
	}

	// I/P: x: 3 => 0...011 , y: 6 => 0...0110 ; O/P: 7 => 0...0111
	static int bitwiseOr(int x, int y) {
		return x | y;
	}

	// I/P: x: 3 => 0...011 , y: 6 => 0...0110 ; O/P: 5 => 0...0101
	static int bitwiseXor(int x, int y) {
		return x ^ y;
	}

	/*- 2's complement of -x = 2^n - x.
	 * 	x: 0...001	=>	~x: 1...110 (2^32 - 1 - 1).
	 */
	static int bitwiseNot(int x) {
		return ~x;
	}

	/*- x=3: 0...011 ->	<< 1 =>	6: 0...110
	 * 	x << y => x * (2^y)	(as long as no overflow)
	 */
	static int leftShift(int x, int y) {
		return x << y;
	}

	/*- x=33: 0...100001 -> >> 1 => 16: 0...010000
	 * 	for -ve nos. the shifted leading bits are filled with 1s.
	 * 	x >> y => Floor(x / (2^y))
	 */
	static int signedRightShift(int x, int y) {
		return x >> y;
	}

	// for -ve nos shifted leading bits are filled with 0s (like +ves).
	static int unsignedRightShift(int x, int y) {
		return x >>> y;
	}

	public static void main(String[] args) {
		System.out.println("And: " + bitwiseAnd(3, 6));
		System.out.println("Or: " + bitwiseOr(3, 6));
		System.out.println("Xor: " + bitwiseXor(3, 6));
		System.out.println("Not: " + bitwiseNot(1));
		System.out.println("Left Shift: " + leftShift(3, 1));
		System.out.println("Signed Right Shift (+ve): " + signedRightShift(33, 4));
		System.out.println("Signed Right Shift (-ve): " + signedRightShift(-2, 4));
		System.out.println("Unsigned Right Shift (-ve): " + unsignedRightShift(-2, 4));
	}

}
