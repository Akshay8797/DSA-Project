package linkedList;

public class PalindromeLinkedList {

	static class Node {
		char data;
		Node next;

		public Node(char data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = CreatePalindromeLL('R', 'A', 'D', 'A', 'R');
		printList(head);
		System.out.println("Palindrome: " + isPalindromeLL(head));
	}

	// T(n): O(n).
	private static boolean isPalindromeLL(Node head) {
		if (head == null || head.next == null)
			return true;
		// Find the first mid node of the Linked list.
		Node slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// Reverse the second half elements.
		Node rev = reverse(slow.next);
		Node curr = head;
		// Compare first half with the reverse of second half.
		while (rev != null) {
			if (rev.data != curr.data)
				return false;
			rev = rev.next;
			curr = curr.next;
		}
		return true;
	}

	private static Node reverse(Node head) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			Node nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}
		return prev;
	}

	private static Node CreatePalindromeLL(char... values) {
		if (values.length == 0)
			return null;
		Node head = new Node(values[0]);
		Node curr = head;
		for (int i = 1; i < values.length; i++) {
			curr.next = new Node(values[i]);
			curr = curr.next;
		}
		return head;
	}

	private static void printList(Node head) {
		for (Node curr = head; curr != null; curr = curr.next)
			System.out.print(curr.data + " ");
		System.out.println();
	}

}
