package bitMagic;

/*- Given an int n. Count the no. of set bits in n.
 * 	I/P: n=5 : 0...0101		=>	O/P: 2
 * 	I/P: n=13 : 0...01101	=>	O/P: 3
 */

public class CountSetBits {

	// T(n) = O(d) [d: no. of bits from LSB to MSB]
	static int getSetBits(int n) {
		int count = 0;
		while (n != 0) {
			count = count + (n & 1); // if ((n&1) != 0) => count++;
			n /= 2;
		}
		return count;
	}

	/*- Brian Kernighan's Algo: Traverse through only set bits
	 * 	T(n) = O(s) [s: no. of set bits]
	 */
	static int getSetBitsEf1(int n) {
		int count = 0;
		while (n > 0) {
			n &= (n - 1); // n = n & (n-1)
			count++;
		}
		return count;
	}

	/*- Lookup table sol: count set bits with some pre-processing involved.
	 * 	T(n) = O(1)
	 * 	assuming 32 bit nos.
	 */
	static int setBitstbl[] = new int[256];

	static void initLookupTable() {
		setBitstbl[0] = 0;
		for (int i = 1; i < 256; i++) {
			setBitstbl[i] = setBitstbl[i & (i - 1)] + 1;
		}
	}

	/*- considering no. as 8 bit chunks
	 * 	&255 is used to get last 8 bits making leading 24 bits as 0
	 */
	static int getSetBitsEf2(int n) {
		initLookupTable();
		return setBitstbl[n & 255] + setBitstbl[(n >> 8) & 255] + setBitstbl[(n >> 16) & 255] + setBitstbl[n >> 24];
	}

	public static void main(String[] args) {
		System.out.println(getSetBits(7));
		System.out.println(getSetBitsEf2(13));
	}

}
