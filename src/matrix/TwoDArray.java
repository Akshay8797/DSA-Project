package matrix;

import java.util.Arrays;

public class TwoDArray {

	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 5, 8 }, { 2, 5, 9 } };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}
		System.out.println("\n");

		int[][] arrSrt = new int[2][2];
		int value = 1;
		for (int i = 0; i < arrSrt.length; i++) {
			for (int j = 0; j < arrSrt[i].length; j++) {
				arrSrt[i][j] = value++;
			}
		}
		for (int[] row : arrSrt) {
			System.out.println(Arrays.toString(row));
		}

		System.out.println();
		int[][] jagged = new int[3][]; // Jagged array
		for (int i = 0; i < jagged.length; i++) {
			jagged[i] = new int[i + 1];
			for (int j = 0; j < jagged[i].length; j++) {
				jagged[i][j] = i;
				System.out.print(jagged[i][j] + " ");
			}
			System.out.println();
		}

	}

}
