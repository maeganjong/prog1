import java.io.*;
import java.util.Random;
import java.lang.Math;


class MinHeap {
  private float[][] heap;
	private int size;
	private int max;
	private int[] search;

	public MinHeap (int max) {
		this.max = max;
		this.size = 0;
		//do we have to initialize a 2d array first... or do we just add it as we go... so that it becomes an array of arrys
		this.heap = new float[this.max + 1][2];
		//this.heap[0] = new int[] {0, 2};
		this.search = new int[this.max+1];
		for(int i=0; i<this.search.length; i++)
		{
    	this.search[i] = -1;
		}
	}
  public float peek() {
		return this.heap[0][1];
  }

	public int getSize(){
		return this.size;
	}

  public void minHeapify(int N) {
		// we return the array of size 2 with the vertex index and the distance
		int l = 2*N;
		int r = 2*N+1;
		int smallest;
		if ((this.heap[r] != null) && (this.heap[r][1] < this.heap[N][1])) { //** how to check if it exists?? **//
			smallest = r;
		}
		else {
			smallest = N;
		}

		if ((this.heap[l] != null) && (this.heap[l][1] < this.heap[smallest][1])) {
			smallest = l;
		}

		if (smallest != N) {
			float[] a = this.heap[N];
			this.heap[N] = this.heap[smallest];
			this.heap[smallest] = a;
			this.minHeapify(smallest);
		}
  }

	// extract the index of the vertex
  public int extractMin(){
    float[] min = this.heap[0];
		this.heap[0] = this.heap[this.size];
		this.size -= 1;
		this.minHeapify(0);
		return (int) min[0];
  }

	public void insert(int v, float d) {
		// if the item is already in the search array (this means that it's in the heap) then we only update the new position in the heap after we
		// heapify with the changed value
		// now looking through the code to figure out where we actually compare the weights of the edges...
		int N = 0;
		if (this.search[v]<0){ //if the node is not yet in the heap - and the v index of the search is NULL
			this.size += 1; //we increase the size of the heap to add in another
			this.heap[this.size] = new float[2];
			this.heap[this.size] = new float[] {v, d};
			N = this.size;
		}
		else { //it is in the heap
			N = this.search[v];
			this.heap[N][1] = d; //adjusted the value
		}
		while ((N > 0) && (this.heap[N/2][1] < this.heap[N][1])) {
			float[] a = this.heap[N/2];
			this.heap[N/2] = this.heap[N];
			this.heap[N] = a;
			N /= 2;
		}
		this.search[v] = N;

		
	}

	public static void main(String[] args) {

		int[] nums = new int[] {2,1,6,5,7,8};

		MinHeap H = new MinHeap(6);

		for (int i =0; i < nums.length; i++){
			H.insert(i, nums[i]);
		}
		System.out.println(H.extractMin());
					

		}
}


