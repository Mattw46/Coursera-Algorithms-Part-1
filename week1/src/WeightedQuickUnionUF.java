/* Weight Quick Union (Union Find) Algorithm
 * Similar to Quick find with addition of a weight (tree height)
 * shorter tree added to taller tree to keep height under control
 * shorter tree narrows search length*/
public class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz;
	
	// Initialise array of N length
	public WeightedQuickUnionUF(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++) sz[i] = 0;
	}
	
	// traces element i back to root node and returns value
	private int root(int i)
	{
		while (i != id[i]) 
			i = id[i];
			return i;
	}
	
	// Check if p & q share same root element
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	// Gets root of p & q, find shorter tree and append to taller tree
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		// return if same element
		if (i == j) return;
		if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
		else { id[j] = i; sz[i] += sz[j]; }
	}
}
