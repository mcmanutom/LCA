import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class LCADAG {
    //Creating array list
	private ArrayList<Integer>[] list1;
	private ArrayList<Integer>[] list2;
	private int x;
	
	//Constructing directed acyclic graph
	public LCADAG(int x)
	{
		this.x = x;
		list1 = (ArrayList<Integer>[]) new ArrayList[x];
		list2 = (ArrayList<Integer>[]) new ArrayList[x];
		for (int y = 0; y < x; x++)
		{
			list1[x] = new ArrayList<Integer>();	
			list2[x] = new ArrayList<Integer>();
		}
	}
	
	public boolean addEdge(int a, int b)
	{
		//Make sure vertexes are both in range (not less than 0 or bigger than number of vertexes in the DAG)
		if(a >= this.x || b >= this.x || a < 0 || b < 0)
		{
			return false;
		}
		if(a != b && !hasPath(a, b) && !list1[a].contains(b))
		{
			list1[a].add(b);
			list2[a].add(b);
			return true;
		}	
		else
		{
			return false;
		}
	}
	
	//Returns number of vertexes in the graph
	public int vertexes()
	{
		return x;
	}

	//Returns list of vertices pointing from the vertex y 
	public ArrayList<Integer> list1(int y)
	{ 
		return list1[y];
	}

	//Returns reversed list of vertices pointing from the vertex y 
	public ArrayList<Integer> reverseAdj(int y)
	{
		return list2[y];
	}
	
	// Class to create a depth first search object on the graph
	private class DFS
	{
		private boolean[] list1Marked;
		private boolean[] list2Marked;
		
		public DFS(LCADAG a, int b)
		{
			list1Marked = new boolean[a.vertexes()];
			list2Marked = new boolean[a.vertexes()];
			dfs(a, b);
		}
		
		private void dfs(LCADAG a, int b)
		{
			list1Marked[b] = true;
			for (int y : a.list1(b))
			if (!list1Marked[y])
				{
					dfs(a, y);
				}
		}
		

		private void reverseDfs(LCADAG a, int b)
		{
			list2Marked[b] = true;
			for (int y : a.reverseAdj(b))
			if (!list2Marked[y]) reverseDfs(a, y);
		}
		
		public boolean visited(int v)
		{ 
			return list1Marked[v]; 
		}
		
		public boolean revVisited(int v)
		{ 
			return list2Marked[v]; 
		}
	}

	//Checks if a path exists between two nodes 
	public boolean hasPath(int a, int b)
	{
		DFS search = new DFS(this, a);
		return search.visited(b);
	}
	//lowestCommonAncestor code
	public ArrayList<Integer> lowestCommonAncestor(int x, int y)
	{
		ArrayList<Integer> lca = new ArrayList<Integer>();
		int MaxDist = Integer.MAX_VALUE;

		//check for invalid input
		if(x==y || x >= this.x || y >= this.x || x < 0 || y < 0) { return lca; } 
			
			DFS search = new DFS(this, x);
			search.reverseDfs(this, x);
			int xDist;
			int yDist;
			
			for(int a = 0; a < this.x; a++)
			{
			
				if(search.revVisited(a) && hasPath(a, y))
				{
					xDist = getDistance(a, x);
					yDist = getDistance(a, y);
					
					if(Integer.max(xDist, yDist) < MaxDist)
					{		
						lca = new ArrayList<Integer>();
						lca.add(a);
						MaxDist = Integer.max(xDist, yDist);
					}
					else if(Integer.max(xDist, yDist) == MaxDist)
					{
						lca.add(a);
						MaxDist = Integer.max(xDist, yDist);
					}
				}
			}
			return lca;
		}
	
		private int getDistance(int x, int target)
		{
		    
			if( x == target) 
			{ 
				return 0; 
			}
			else 
			{
		        Queue<Integer> q = new LinkedList<Integer>();
		        int[] distTo = new int[this.x];
		        boolean[] marked = new boolean[this.x];
		        for (int a = 0; a < this.x; a++)
		        { 
		        	distTo[a] = Integer.MAX_VALUE;
	        	}
		        
		        distTo[x] = 0;
		        marked[x] = true;
		        q.add(x);
		
		        while (!q.isEmpty())
		        {
		            int b = q.remove();
		            for (int y : this.list1(b)) 
		            {
		                if (!marked[y]) {
		                	
		                	distTo[y] = distTo[b] + 1;
		                    marked[y] = true;
		                    
		                    q.add(y);
		                }
	            	}
		        }
		        
		        return distTo[target];
			}
	}
}
