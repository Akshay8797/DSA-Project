package deque;

/*- Given n fuel pumps and their distances arranged in a circular manner.
 * 	Find the position of the first fuel pump from where we can visit all the fuel pumps
 *  and come back to the first, without ever going out of fuel.
 * 	fuel[] = {4, 8, 7, 4}, distance[] = {6, 5, 3, 5} => 2.
 */
public class FirstCircularTour {

	public static void main(String[] args) {
		int[] fuel = { 4, 8, 7, 4 };
		int[] distance = { 6, 5, 3, 5 };
		System.out.println(findStartingPumpEff(fuel, distance));
	}

	/*- T(n)=O(n). If the fuel becomes negative at i, then indexes 0-i can't be the solution.
	 */
	static int findStartingPumpEff(int[] fuel, int[] distance) {
		int start = 0, currFuel = 0, prevFuel = 0;
		for (int i = 0; i < fuel.length; i++) {
			currFuel += fuel[i] - distance[i];
			if (currFuel < 0) {
				start = i + 1;
				prevFuel += currFuel;
				currFuel = 0;
			}
		}
		return ((currFuel + prevFuel) >= 0) ? start + 1 : -1;
	}

	/*- T(n)=O(n). If a pump is re-added after being removed, it must've been revisited in the circular traversal.
	 *  This can happen only once, because the loop stops after completing one full circle (count == n).
	 */
	static int findStartingPump(int[] fuel, int[] distance) {
		int n = fuel.length;
		int start = 0, end = 0; // Start and end of fuel[] used as deque.
		int currFuel = 0, count = 0, totalFuel = 0;

		// Check if completing the circular tour is feasible.
		for (int i = 0; i < n; i++)
			totalFuel += fuel[i] - distance[i];
		if (totalFuel < 0)
			return -1;

		// Traverse pumps circularly and stop after processing all pumps.
		while (count < n) {
			currFuel += fuel[end] - distance[end];
			count++;
			// If fuel becomes negative, remove pumps from the front of the deque.
			while (currFuel < 0) {
				currFuel -= fuel[start] - distance[start];
				start = (start + 1) % n;
				count--;
			}
			end = (end + 1) % n;
		}
		return start + 1;
	}

}
