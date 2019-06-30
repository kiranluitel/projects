package lab9.prog9_3;



public class ArrayQueueImpl {
	private final int INITIAL_SIZE=10;
	private int sizeMultiplier = 1;
	private int[] arr = new int[INITIAL_SIZE];
	private int size = 0;
	private int front = -1;
	private int rear = 0;
	
	public boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
	public void enqueue(int e) {
		if (front == -1) {
			front =0;
			arr[rear++]=e;
			size++;
		}
		else {
			if(rear==(sizeMultiplier*INITIAL_SIZE)) resize();
			arr[rear++]=e;
			size++;
		}
	}
	public int dequeue() {
		
		if(isEmpty()) {
			throw new IllegalStateException("Cannot dequeue because Queue is Empty");
		}
		
			int i = peek();
			front++;
			size--;
		
		return i;
	}
	
	public int peek() {
		if(isEmpty()) throw new IllegalStateException("Cannot peek because Queue is empty!");
		return arr[front];
	}
	private void resize() {
		System.out.println("Resizing...");
			if(rear-front<(INITIAL_SIZE*sizeMultiplier)) {
				int[] temp = new int[sizeMultiplier*INITIAL_SIZE];
				System.arraycopy(arr, front, temp, 0, size-1);
				arr = temp;
				front =0;
				rear =size;
			}
			else {
				int[] temp = new int[++sizeMultiplier*INITIAL_SIZE];
				System.arraycopy(arr, front, temp, 0, size-1);
				arr = temp;
				front =0;
				rear =size;
			}
		
	}
	
	
	public static void main(String[] args) {
		ArrayQueueImpl q = new ArrayQueueImpl();
		
		//uncomment when ready
		for(int i = 0; i < 15; i ++) {
			q.enqueue(i);
			System.out.println("Size after queueing: "+q.size());
			
		}
		for(int i = 0; i < 14; i ++) {
			System.out.println("Dequeued Value: "+q.dequeue()+" Size: "+q.size());
		}
		System.out.println("Size of Queue after queing and dequeing is: "+q.size());
		System.out.println("Peeking the queue gives: "+q.peek());
	}
}

