package heap.core;

public class MinHeap {

	int[] heap;
	int size;
	int cap;

	public MinHeap(int cap) {
		this.heap = new int[cap];
		this.size = 0;
		this.cap = cap;
	}

	// Take an existing heap as input.
	public MinHeap(int[] hp, int cap) {
		if (hp.length > cap)
			throw new IllegalStateException("Invalid capacity!");
		this.heap = new int[cap];
		System.arraycopy(hp, 0, this.heap, 0, hp.length);
		this.size = hp.length;
		this.cap = cap;
	}

	public int leftIndx(int indx) {
		return 2 * indx + 1;
	}

	public int rightIndx(int indx) {
		return 2 * indx + 2;
	}

	public int parentIndx(int indx) {
		return (indx - 1) / 2;
	}

	public void printHeap() {
		if (size == 0)
			return;
		for (int i = 0; i < size; i++)
			System.out.print(heap[i] + " ");
		System.out.println();
	}

}
