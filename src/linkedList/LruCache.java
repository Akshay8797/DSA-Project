package linkedList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import linkedList.core.Node;

// Methods put and printCache should only be called - T(n): O(1).
public class LruCache {

	private final int capacity;
	private final Map<Integer, Node> cache; // value -> Node
	private Node head, tail; // DLL pointers

	public LruCache(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<>();
		this.head = null;
		this.tail = null;
	}

	public void put(int value) {
		if (cache.containsKey(value)) {
			moveToHead(cache.get(value)); // Move existing node to front
		} else {
			if (cache.size() >= capacity) {
				removeTail();
			}
			Node newNode = new Node(value); // Create new node & add to head
			addToHead(newNode);
			cache.put(value, newNode);
		}
	}

	private void moveToHead(Node node) {
		if (node == head)
			return; // Already at head
		removeNode(node);
		addToHead(node);
	}

	private void removeTail() {
		if (tail == null)
			return;
		cache.remove(tail.data);
		removeNode(tail);
	}

	private void addToHead(Node node) {
		node.next = head;
		node.prev = null;
		if (head != null)
			head.prev = node;
		head = node;
		if (tail == null)
			tail = head; // If first node
	}

	private void removeNode(Node node) {
		if (node.prev != null)
			node.prev.next = node.next;
		if (node.next != null)
			node.next.prev = node.prev;

		if (node == head)
			head = node.next;
		if (node == tail)
			tail = node.prev;
	}

	public void printCache() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LruCache lruCache = new LruCache(4);
		List<Integer> nums = List.of(10, 20, 10, 30, 40, 50, 30, 40, 60, 30);
		for (int num : nums) {
			lruCache.put(num);
			lruCache.printCache();
		}
	}

}
