import java.io.*;
import java.util.Random;

class RandomWeight {
	public static void main (String[] args) {
		System.out.println("Hello Java");

    // args[1] - 0, args[2] - numpoints, args[3] - numtrials, args[4] - dimension


	int n=5;
	// initializing graph, with vertices stored in array V, consisting of integers that index each vertex

	int V[] = new int[n];
	for (int i = 0; i < V.length; i++;)	{
		V[i] = i;
	}

	// array of (conservative) minimum distance to vertex
	int dist[] = new float[n];
	for (int i = 0; i < V.length; i++;)	{
		V[i] = n; // n-1 edges in MST, max weight of an edge is 1
	}

	// array of pointers (indices) to previous vertex in MST, initialized to a null value
	int prev[] = new int[n];
	for (int i = 0; i < V.length; i++;)	{
		V[i] = -1; // an "null" pointer
	}

	// set of vertices S for cut property, 1 if in S and 0 otherwise
	int S[] = new int[n]; // initialized to 0

	// start with 0-indexed vertex in S, so its distance to itself is 0
	S[0] = 1;
  dist[0] = 0;

	MinHeap H = new MinHeap(n); // heap of lightest n edges at any given time
	MinHeap tempHeap = new MinHeap(2n); // temporary heap to contain added edges

	H.insert(0, dist[0]); // add	H to the heap

	Random rand = new Random();


	//Begin heap operations on remainder of Heap
	while H.getSize() > 0	{
		int v = extractMin(H);
		S[v] = 1; // add v to set S
		for (int w = 0; w < V.length && S[i] == 0; i++;) { // checking for vertices w not in S
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
  private int[] heap;
	private int size;
	private int max;

	public MinHeap (int max) {
		this.max = max;
		this.size = 0;
		heap = new int[this.max + 1][2];
		heap[0] = 0;
	}
  public static float peek() {
		return heap[1];
  }

	public int getSize(){
		return this.size;
	}

  public static void minHeapify(int N) {
		// we return the array of size 2 with the vertex index and the distance
		int l = 2*N;
		int r = 2*N+1;
		int smallest;
		if (this.heap[r]) && (this.heap[r][1] < this.heap[N][1]) {
			smallest = r;
		}
		else {
			smallest = N;
		}

		if (this.heap[l]) && (this.heap[l][1] < this.heap[smallest][1]) {
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

	public insert(int v, float d) {
		this.size += 1;
		this.heap[this.size] = v;
		int N = this.size;
		while (N > 0) && (this.heap[N/2] < this.heap[N]) {
			int a = this.heap[N/2];
			this.heap[N/2] = this.heap[N];
			this.heap[N] = a;
			N /= 2;
		}

		// if already in, then you would just change the value


		// SEPARATE ARRAY - index of a value is a vertex, value os the location of that vertex within the heap ---- SEARCH FOR IT
	}
}
// Class for RandomSquare


// Class for RandomDimension

// Returning the average weight!!!
