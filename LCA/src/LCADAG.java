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
}
