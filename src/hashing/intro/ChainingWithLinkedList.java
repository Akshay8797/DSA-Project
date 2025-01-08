package hashing.intro;

import java.util.ArrayList;
import java.util.LinkedList;

// Custom hash table with chaining for collision detection 
class HTable {

	private int bucketSize;
	private ArrayList<LinkedList<Integer>> table;

	HTable(int b) {
		this.bucketSize = b;
		this.table = new ArrayList<LinkedList<Integer>>();
		for (int i = 0; i < b; i++)
			table.add(new LinkedList<Integer>());
	}

	void insert(Integer k) {
		int i = k % bucketSize;
		table.get(i).add(k);
	}

	boolean search(Integer k) {
		int i = k % bucketSize;
		return table.get(i).contains(k);
	}

	void delete(Integer k) {
		int i = k % bucketSize;
		table.get(i).remove(k);
	}

}

public class ChainingWithLinkedList {

	public static void main(String[] args) {
		HTable hTable = new HTable(7);
		hTable.insert(10);
		hTable.insert(20);
		hTable.insert(15);
		hTable.insert(7);
		System.out.println(hTable.search(10));
		hTable.delete(15);
		System.out.println(hTable.search(15));
	}

}
