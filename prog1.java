import java.io.*;


class RandomWeight {
	public static void main (String[] args) {
		System.out.println("Hello Java");

    // args[1] - 0, args[2] - numpoints, args[3] - numtrials, args[4] - dimension


	int n=5;
	// initializing graph, with vertices stored in array V, consisting of integers that index each vertex

	int V[] = new int[n];
	for (int i = 0; i < V.length; i++;)	{
		V[i]=i;
	}

	// array of (conservative) minimum distance to vertex
	int dist[] = new float[n];
	for (int i = 0; i < V.length; i++;)	{
		V[i]=n; // n-1 edges in MST, max weight of an edge is 1
	}

	// array of pointers (indices) to previous vertex in MST, initialized to a null value
	int prev[] = new int[n];
	for (int i = 0; i < V.length; i++;)	{
		V[i]=-1; // an "null" pointer
	}

	MinHeap H =


	}
}

public class MinHeap {
  private int heap[] = new int[];

  public static float peek() {

  }

  public static void minHeapify(MinHeap H, ) {

  }

  public int extractMin(){
    int min = heap[];
  }
}
// Class for RandomSquare


// Class for RandomDimension

// Returning the average weight!!!
