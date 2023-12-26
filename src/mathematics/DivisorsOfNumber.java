package mathematics;

/*- Given an int n. print all divisors in increasing order.
 * Ex: 	I/P: 15		=>	O/P: 1,3,5,15
 * 		I/P: 100	=>	O/P: 1,2,4,5,10,20,25,50,100
 */

public class DivisorsOfNumber {

	// T(n): O(n)
	static void printDivisors(int n) {
		for (int i = 1; i <= (n / 2); i++) {
			if (n % i == 0)
				System.out.println(i);
		}
		System.out.println(n);
	}

	/*- Divisors always occurs in pair with 
	 * one of them being smaller than or equal to sqrt(n)
	 * T(n): O(sqrt(n))
	 */
	static void divisorsWithoutOrder(int n) {
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				System.out.println(i);
				// to avoid printing twice for perfect squares
				if (i != n / i)
					System.out.println(n / i);
			}
		}
	}

	static void divisorsWithOrder(int n) {
		int i;
		for (i = 1; i * i < n; i++) {
			if (n % i == 0)
				System.out.println(i);
		}
		for(; i>=1; i--) {
			if(n%i==0)
				System.out.println(n/i);
		}
	}
	
	public static void main(String[] args) {
		printDivisors(7);
		System.out.println();
		divisorsWithOrder(15);
	}

}
