package hashing.intro;

import java.util.Arrays;

// Empty slot: -1, Deleted slot: -2.
class HashArray {

	private int arr[];
	private int cap;
	private int size;

	public HashArray(int c) {
		this.cap = c;
		this.size = 0;
		this.arr = new int[cap];
		Arrays.fill(arr, -1);
	}

	int hash(int key) {
		return key % cap;
	}

	boolean insert(int key) {
		if (size == cap)
			return false;
		int i = hash(key);
		while (arr[i] != -1 && arr[i] != -2 && arr[i] != key)
			i = (i + 1) % cap;
		if (arr[i] == key)
			return false;
		else {
			arr[i] = key;
			size++;
			return true;
		}
	}

	boolean search(int key) {
		int h = hash(key), i = h;
		while (arr[i] != -1) {
			if (arr[i] == key)
				return true;
			i = (i + 1) % cap;
			if (i == h)
				return false;
		}
		return false;
	}

	boolean erase(int key) {
		int h = hash(key), i = h;
		while (arr[i] != -1) {
			if (arr[i] == key) {
				arr[i] = -2;
				return true;
			}
			i = (i + 1) % cap;
			if (i == h)
				return false;
		}
		return false;
	}

}

public class OpenAddressingWithLinearProbing {

	public static void main(String[] args) {
		HashArray hArray = new HashArray(7);
		print("Ins", 49, hArray.insert(49));
		print("Ins", 56, hArray.insert(56));
		print("Ins", 72, hArray.insert(72));
		print("Ins", 72, hArray.insert(72)); // Duplicate
		print("Srch", 56, hArray.search(56));
		print("Del", 56, hArray.erase(56));
		print("Srch", 56, hArray.search(56));
	}

	private static void print(String action, int key, boolean res) {
		String msg = switch (action) {
			case "Ins" -> res ? "Inserted " + key : "Failed to insert " + key;
			case "Srch" -> res ? "Found " + key : key + " not found";
			case "Del" -> res ? "Deleted " + key : "Failed to delete " + key;
			default -> "Invalid action";
		};
		System.out.println(msg);
	}

}
