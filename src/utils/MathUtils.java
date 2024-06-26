package utils;

public class MathUtils {
	
	public static int getMidpoint(int low, int high) {
		// To avoid overflow with (low + high) / 2
		return low + (high - low) / 2;
	}

}
