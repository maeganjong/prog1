import java.io.*;
import java.util.Random;
import java.lang.Math;

public class prog1{
	public static void main (String[] args) {

	  // args[0] - 0, args[1] - numpoints, args[2] - numtrials, args[3] - dimension

		int n = Integer.parseInt(args[1]);
		int trials = 1; //Integer.parseInt(args[2]);
		int dim = 0; // Integer.parseInt(args[3]);
		// initializing graph, with vertices stored in array V, consisting of integers that index each vertex

		// IMPLEMENT TRIALS

		if (dim == 0) {
			int V[] = new int[n];
			for (int i = 0; i < V.length; i++)	{
				V[i] = i;
			}

			// array of (conservative) minimum distance to vertex
			float dist[] = new float[n];
			for (int i = 0; i < V.length; i++)	{
				dist[i] = n; // n-1 edges in MST, max weight of an edge is 1
			}
			// array of pointers (indices) to previous vertex in MST, initialized to a null value

			int prev[] = new int[n];
			for (int i = 0; i < V.length; i++)	{
				prev[i] = -1; // an "null" pointer
			}

			// set of vertices S for cut property, 1 if in S and 0 otherwise
			int S[] = new int[n]; // initialized to 0

			// start with 0-indexed vertex in S, so its distance to itself is 0
			S[0] = 1;
		  dist[0] = 0;

			MinHeap H = new MinHeap(n); // heap of lightest n edges at any given time
			MinHeap tempHeap = new MinHeap(2*n); // temporary heap to contain added edges

			H.insert(0, dist[0]); // add	H to the heap

			//Begin heap operations on remainder of Heap
			while (H.getSize() > 0)	{
				int v = H.extractMin();
				S[v] = 1; // add v to set S
				for (int w = 0; w < V.length && S[w] == 0; w++) { // checking for vertices w not in S
					// float weight(v,w) = rand.nextDouble();

					//generate random weight for edge (v,w), called value

					Random rand = new Random();
					// generating a number [0,1]
					long seed = System.currentTimeMillis() % 1000; //define to something random
					rand.setSeed(seed);
					float value = rand.nextFloat();

					if (dist[w] > value) {
						dist[w] = value;
						prev[w] = v;
						H.insert(w, dist[w]);
					}
					// if (dist[w] > weight(v,w)){
					// 	dist[w] = weight(v,w);
					// 	prev[w] = v;
					// 	H.insert(w, dist[w]);
					// }

				}
			}

				// Calculate average weight
				float total = 0.0f;

				for (int i = 1; i < V. length; i++) {
					if (prev[i] == -1){
						total += dist[i];
					}
					else {
						total += dist[i] - dist[prev[i]];
					}
				}
				System.out.println(total / (n-1));
		}




		// for higher dimensions
		else {
			float V[][] = new float[n][dim];
			for (int i = 0; i < V.length; i++)	{
				for (int j = 0; j < dim; j++) {
					Random rand = new Random();
					// generating a number [0,1]
					long seed = System.currentTimeMillis() % 1000; //define to something random
					rand.setSeed(seed);
					float value = rand.nextFloat();//*(1+2.5e-16);
					V[i][j] = value;
				}
			}

			float dist[] = new float[n];
			for (int i = 0; i < V.length; i++)	{
				dist[i] = n * n; // n-1 edges in MST, max weight of an edge is sqrt n < n
			}

			// array of pointers (indices) to previous vertex in MST, initialized to a null value
			int prev[] = new int[n];
			for (int i = 0; i < V.length; i++)	{
				prev[i] = -1; // an "null" pointer
			}

			// set of vertices S for cut property, 1 if in S and 0 otherwise
			int S[] = new int[n]; // initialized to 0

			// start with 0-indexed vertex in S, so its distance to itself is 0
			S[0] = 1;
		  dist[0] = 0;

			MinHeap H = new MinHeap(n); // heap of lightest n edges at any given time
			MinHeap tempHeap = new MinHeap(2*n); // temporary heap to contain added edges

			H.insert(0, dist[0]); // add	H to the heap

			//Begin heap operations on remainder of Heap
			while (H.getSize() > 0)	{
				int v = H.extractMin();
				S[v] = 1; // add v to set S
				for (int w = 0; w < V.length && S[w] == 0; w++) { // checking for vertices w not in S
					// float weight(v,w) = rand.nextDouble();
					float d = 0; // running count for distance
					for (int i = 0; i < dim; i++ ){
						d += (V[v][i] - V[w][i]) * (V[v][i] - V[w][i]);
					}
					d = (float) Math.sqrt(d);
					if (dist[w] > d){
						dist[w] = d;
						prev[w] = v;
						H.insert(w, dist[w]);
					}

				}
			}
			// Calculate average weight
			float total = 0.0f;

			for (int i = 1; i < V. length; i++) {
				if (prev[i] == -1){
					total += dist[i];
				}
				else {
					total += dist[i] - dist[prev[i]];
				}
			}
			System.out.println(total / (n-1));
		}


	}


	// public static float weight(int v, int w) {
	// 	if (dim == 0){
	// 		Random rand = new Random();
	// 		// generating a number [0,1]
	// 		long seed = System.currentTimeMillis() % 1000; //define to something random
	// 		rand.setSeed(seed);
	// 		float value = rand.nextFloat()*(1+2.5e-16);
	// 		return value;
	// 	}
	// 	// if dim is higher, calculate distance between them
	// 	else {
	// 		float d = 0; // running count for distance
	// 		for (int i = 0; i < dim; i++ ){
	// 			dist += (V[v][i] - V[v][j]) * (V[v][i] - V[v][j]);
	// 		}
	//
	// 		return Math.sqrt(d);
	// 	}
	// }

}




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
}
