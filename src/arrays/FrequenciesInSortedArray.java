package arrays;

// Given a sorted array, print the frequency of each element
public class FrequenciesInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 10, 10, 10, 20, 30, 30 };
		printFreqApproach2(arr);
	}

	@SuppressWarnings("unused")
	private static void printFrequencies(int[] arr) {
		int ele = arr[0], eleCount = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == ele)
				eleCount++;
			else {
				System.out.println(ele + " " + eleCount);
				ele = arr[i];
				eleCount = 1;
			}
		}
		System.out.println(ele + " " + eleCount);
	}

	private static void printFreqApproach2(int[] arr) {
		int freq = 1, i = 1, n = arr.length;
		while (i < n) {
			while (i < n && arr[i] == arr[i - 1]) {
				freq++;
				i++;
			}
			System.out.println(arr[i - 1] + " " + freq);
			i++;
			freq = 1;
		}
// If the last element is not same as 2nd last element or there is only one element, print
		if (n == 1 || arr[n - 1] != arr[n - 2])
			System.out.println(arr[n - 1] + " " + 1);
	}

}
