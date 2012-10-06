package experiment;

import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class IntBoard {

	public final static int ROWS = 4;
	public final static int COLS = 4;
	public final static int GRID_PIECES = ROWS*COLS;
	
	private Map<Integer, LinkedList<Integer>> adjMatrix;
	private TreeSet<Integer> targets;
	private Stack<Integer> path;
	
	public IntBoard() {
		// TODO Auto-generated constructor stub
		adjMatrix = new TreeMap<Integer, LinkedList<Integer>>();
		targets = new TreeSet<Integer>();
		path = new Stack<Integer>();
		calcAdjacencies();
	}

	public void calcAdjacencies() 
	{
		for (int i=0; i<ROWS; i++)
		{
			for (int j=0; j<COLS; j++)
			{
				LinkedList<Integer> adjacencies = new LinkedList<Integer>();
				int index = calcIndex(i,j);
				
				if ((i-1) >= 0)
					adjacencies.add(calcIndex((i-1), j));
				
				if ((j-1) >= 0)
					adjacencies.add(calcIndex(i, (j-1)));
				
				if ((i+1) < ROWS)
					adjacencies.add(calcIndex((i+1), j));
				
				if ((j+1) < COLS)
					adjacencies.add(calcIndex(i, (j+1)));
				
				adjMatrix.put(index, adjacencies);
			}			
		}
		
		return;
	}
	
	public void calcTargets(int startLocation, int numSteps)
	{
		if (path.empty())
			targets.clear();
		
		path.push(startLocation);
		
		if ((numSteps+1) == path.size())
		{
			if (!targets.contains(path.lastElement()))
				targets.add(path.lastElement());
		}
		else
		{
			for (Integer a : getAdjList(startLocation))
			{
				if (!path.contains(a))
					calcTargets(a, numSteps);
			}
		}
		
		path.pop();
		
		return;
	}
	
	public TreeSet<Integer> getTargets()
	{
		return targets;
	}
	
	public LinkedList<Integer> getAdjList(int index)
	{
		return adjMatrix.get(index);
	}
	
	public static int calcIndex(int row, int col)
	{
		return (row*4) + col;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
