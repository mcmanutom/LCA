import java.util.ArrayList;
import java.util.List;

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
	

	//Checks if a path exists between two nodes 
	public boolean hasPath(int a, int b)
	{
		
	}
}
