import java.io.*;
import java.util.Random;

class RandomWeight {
	public static void main (String[] args) {
		System.out.println("Hello Java");

    // args[1] - 0, args[2] - numpoints, args[3] - numtrials, args[4] - dimension


	int n = 5;
	// initializing graph, with vertices stored in array V, consisting of integers that index each vertex

	int V[] = new int[n];
	for (int i = 0; i < V.length; i++)	{
		V[i] = i;
	}

	// array of (conservative) minimum distance to vertex
	int dist[] = new float[n];
	for (int i = 0; i < V.length; i++)	{
		V[i] = n; // n-1 edges in MST, max weight of an edge is 1
	}

	// array of pointers (indices) to previous vertex in MST, initialized to a null value
	int prev[] = new int[n];
	for (int i = 0; i < V.length; i++)	{
		V[i] = -1; // an "null" pointer
	}

	// set of vertices S for cut property, 1 if in S and 0 otherwise
	int S[] = new int[n]; // initialized to 0

	// start with 0-indexed vertex in S, so its distance to itself is 0
	S[0] = 1;
  dist[0] = 0;

	MinHeap H = new MinHeap(n); // heap of lightest n edges at any given time
	MinHeap tempHeap = new MinHeap(2*n); // temporary heap to contain added edges

	H.insert(0, dist[0]); // add	H to the heap

	Random rand = new Random();
	// generating a number [0,1]
	long seed = 1232323232; //define to something random
	rand.setSeed(seed);
	float value = rand.nextFloat()*(1+2.5e-16);

	//Begin heap operations on remainder of Heap
	while (H.getSize() > 0)	{
		int v = extractMin(H);
		S[v] = 1; // add v to set S
		for (int w = 0; w < V.length && S[i] == 0; i++) { // checking for vertices w not in S
			float weight(v,w) = rand.nextDouble(); // REMOVE!!!!!!!!!!!!!!!!!!!
			if (dist[w] > weight(v,w)){
				dist[w] = weight(v,w);
				prev[w] = v;
				H.insert(w, dist[w]);
			}

		}


	}



	// if smallest edge already in MST, go for second smallest? - Mike
	}
}

public class MinHeap {
  private float[][] heap;
	private int size;
	private int max;
	private int[] search;

	public MinHeap (int max) {
		this.max = max;
		this.size = 0;
		//do we have to initialize a 2d array first... or do we just add it as we go... so that it becomes an array of arrys
		this.heap = new float[this.max + 1][2];
		this.heap[0] = new int[] {0, Integer.MIN_VALUE};
		this.search = new int[this.max+1];
		for(int i=0; i<this.search.length; i++)
		{
    	this.search[i] = null;
		}
	}
  public static float peek() {
		return this.heap[0][1];
  }

	public int getSize(){
		return this.size;
	}

  public static void minHeapify(int N) {
		// we return the array of size 2 with the vertex index and the distance
		int l = 2*N;
		int r = 2*N+1;
		int smallest;
		if ((this.heap[r]) && (this.heap[r][1] < this.heap[N][1])) { //** how to check if it exists?? **//
			smallest = r;
		}
		else {
			smallest = N;
		}

		if ((this.heap[l]) && (this.heap[l][1] < this.heap[smallest][1])) {
			smallest = l;
		}

		if (smallest != N) {
			int a = this.heap[N];
			this.heap[N] = this.heap[smallest];
			this.heap[smallest] = a;
			minHeapify(this, smallest);
		}
  }

	// extract the index of the vertex
  public int extractMin(){
    int[] min = this.heap[0];
		this.heap[0] = this.heap[this.size];
		this.size -= 1;
		minHeapify(this, 0);
		return min[0];
  }

	public void insert(int v, float d) {
		// if the item is already in the search array (this means that it's in the heap) then we only update the new position in the heap after we
		// heapify with the changed value
		// now looking through the code to figure out where we actually compare the weights of the edges...
		int N = 0;
		if (!this.search[v]){ //if the node is not yet in the heap - and the v index of the search is NULL
			this.size += 1; //we increase the size of the heap to add in another
			this.heap[this.size] = new int[2];
			this.heap[this.size] = new int[] {v, d};
			N = this.size;
		}
		else { //it is in the heap
			N = this.search[v];
			this.heap[N][1] = d; //adjusted the value
		}
		while ((N > 0) && (this.heap[N/2] < this.heap[N])) {
			int a = this.heap[N/2];
			this.heap[N/2] = this.heap[N];
			this.heap[N] = a;
			N /= 2;
		}
		this.search[v] = N;
	}
}
// Class for RandomSquare


// Class for RandomDimension

// Returning the average weight!!!
