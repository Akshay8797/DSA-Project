package stack;

import java.util.Arrays;

import utils.StackUtils;

// Implement k stacks in an array. stackNum should be from 0 to k-1.
public class KStacks {

	private static class kStack {
		private int arr[], top[], next[];
		private int cap, k, freeTop;

		kStack(int k, int n) {
			if (k > n)
				throw new IllegalArgumentException("No. of stacks cannot exceed array capacity.");
			this.k = k;
			cap = n;
			arr = new int[cap]; // Store stack elements.
			top = new int[k]; // Store indices of top elements of stacks.
			next = new int[cap]; // Stores the next available slots and maintains links between stack elements.

			Arrays.fill(top, -1); // Initialize all stack tops to -1 (empty).
			freeTop = 0;
			for (int i = 0; i < cap - 1; i++)
				next[i] = i + 1; // Link all slots to the next free slot.
			next[cap - 1] = -1; // Last slot points to -1 (end of free list).
		}

		Boolean isEmpty(int stackNum) {
			if (!isStackNumValid(stackNum))
				return null;
			return (top[stackNum] == -1);
		}

		void push(int x, int stackNum) {
			if (!isStackNumValid(stackNum))
				return;
			if (freeTop == -1) { // Stack full
				StackUtils.stackFullError(x, stackNum);
				return;
			}
			int i = freeTop; // Get the first free index.
			freeTop = next[i]; // Update freeTop to the next free slot.
			next[i] = top[stackNum]; // Link the new element to the previous top.
			top[stackNum] = i; // Update top of the stack to the new element.
			arr[i] = x;
		}

		Integer pop(int stackNum) {
			if (!isStackNumValid(stackNum))
				return null;
			if (isEmpty(stackNum))
				return StackUtils.stackEmptyError("Pop", stackNum);
			int i = top[stackNum]; // Get the top element index.
			top[stackNum] = next[i]; // Update top to the previous element in stack.
			next[i] = freeTop; // Add the freed slot to the free list.
			freeTop = i; // Update freeTop to the popped slot.
			return arr[i];
		}

		void printStack(int stackNum) {
			if (!isStackNumValid(stackNum))
				return;
			if (isEmpty(stackNum)) {
				StackUtils.stackEmptyError("", stackNum);
				return;
			}
			System.out.print("Stack " + stackNum + ": ");
			int i = top[stackNum]; // Start from the top of the stack.
			while (i != -1) {
				System.out.print(arr[i] + " ");
				i = next[i]; // Move to the next element in the stack.
			}
			System.out.println();
		}

		boolean isStackNumValid(int stackNum) {
			if (stackNum < 0 || stackNum >= k) {
				System.err.println("Invalid stack number: " + stackNum);
				return false;
			}
			return true;
		}
	}

	public static void main(String[] args) {
		kStack kstck = new kStack(3, 5);
		kstck.push(10, 0);
		kstck.push(20, 0);
		kstck.push(30, 1);
		kstck.push(40, 1);
		kstck.pop(0);
		kstck.push(50, 2);
		kstck.push(60, 2);
		kstck.printStack(0);
		kstck.printStack(1);
		kstck.printStack(2);
	}

}
