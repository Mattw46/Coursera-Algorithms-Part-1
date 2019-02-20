/*
 * Quick Find (Union Find) Algorithm
 * Use an array of N length to track connected elements
 * array index = number being tracked, array value = connected group
 * Uses Flat array and runs at quadratic time
 */
public class QuickFindUF {
	private int[] id;
	
	// Initialise Array of N length, set value 1 to N
	public QuickFindUF(int N) 
	{
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	// Connected if both array elements hold same value
	public boolean connected(int p, int q) 
	{
		return id[p] == id [q];
	}
	
	/* Connect point p to q
	 * get value store at p & q
	 * set all p values to q to connect all
	 * connected elements
	 */
	public void union(int p, int q)
	{
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++)
			if (id[i] == pid) id[i] = qid;
	}
}
