/* Quick Union (Union find) Algorithm
 * represents a tree as a array of N length
 * the array stores the parent node to each element
 * every element traces back to a root element 
 * array index = value in tree, array value stored at index = parent
 * 
 * Issues: Can create tall trees
 *         expensive to find element at bottom of tree if tall
 */
public class QuickUnionUF {
	private int[] id;
	
	// Initialise array of N length
	public QuickUnionUF(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
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
	
	// Gets root of p & q, sets parent to q root
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
}
