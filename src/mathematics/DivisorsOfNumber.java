package mathematics;

/*- Given an int n. print all divisors in increasing order.
 * Ex: 	I/P: 15		=>	O/P: 1,3,5,15
 * 		I/P: 100	=>	O/P: 1,2,4,5,10,20,25,50,100
 */

public class DivisorsOfNumber {

	static void printDivisors(int n) {
		for (int i = 1; i <= (n / 2); i++) {
			if (n % i == 0)
				System.out.println(i);
		}
		System.out.println(n);
	}

	public static void main(String[] args) {
		printDivisors(7);
	}

}
