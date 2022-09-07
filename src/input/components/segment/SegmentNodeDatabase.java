package input.components.segment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import input.components.point.PointNode;

public class SegmentNodeDatabase 
{
	/**
	 * 
	 * */
	protected Map<PointNode, Set<PointNode>> _adjLists;

	public SegmentNodeDatabase()
	{
		this._adjLists = new HashMap<PointNode, Set<PointNode>>();
	}
	public SegmentNodeDatabase(Map<PointNode, Set<PointNode>> _set) 
	{
		this._adjLists = new HashMap<PointNode, Set<PointNode>>();
		this._adjLists.putAll(_set);
	}

	/**
	 * 
	 * */
	public int numUndirectedEdges() 
	{
		int numEdges = 0; 
		
		for(Map.Entry<PointNode, Set<PointNode>> entry : _adjLists.entrySet())
		{
			System.out.println(entry.toString());
		}
		return 0;
	}

	/**
	 * 
	 * */
	private void addDirectedEdge(PointNode a, PointNode b) 
	{
		if(_adjLists.containsKey(a)) {_adjLists.get(a).add(b);}
		
		else 
		{
			Set<PointNode> set = new LinkedHashSet<PointNode>(); 
			set.add(b);
			
			_adjLists.put(a, set);
		}
	}

	/**
	 * 
	 * */
	public void addUndirectedEdge(PointNode a, PointNode b) 
	{
		if(_adjLists.containsKey(a)) {_adjLists.get(a).add(b);}
		
		else 
		{
			Set<PointNode> set = new LinkedHashSet<PointNode>(); 
			set.add(b);
			
			_adjLists.put(a, set);
			
			addUndirectedEdge(b, a); 
		}
	}

	/**
	 * 
	 * */
	public void addAdjacencyList(PointNode a, List<PointNode> b)
	{
		LinkedHashSet<PointNode> adjListHashSet = new LinkedHashSet<>();
		adjListHashSet.addAll(b);
		if(_adjLists.containsKey(a))
			_adjLists.get(a).addAll(adjListHashSet);
		else
			_adjLists.put(a, adjListHashSet);
	}

	/**
	 * 
	 * */
	public List<SegmentNode> asSegmentList()
	{
		return null;
	}

	/**
	 * Creates a List of "directed edges" aka unique segments
	 * */
	public List<SegmentNode> asUniqueSegmentList()
	{
		List<SegmentNode> uniqueSegList = new ArrayList<SegmentNode>();
		PointNode[] keysArray = (PointNode[]) _adjLists.keySet().toArray();
		PointNode[] valuesArray; 
		
		int numOfKeys = _adjLists.keySet().size();
		int numValues;
		
		//loops through keys in _adjLists
		for(int i = 0; i < numOfKeys; i++) 
		{
			numValues = _adjLists.get(keysArray[i]).size();
			valuesArray = (PointNode[]) _adjLists.get(keysArray[i]).toArray();
			
			//loops through values for each key in _adjLists
			for(int j = 0; j < numValues; j++) 
			{
				SegmentNode newSegment = new SegmentNode(keysArray[i], valuesArray[j]);
				
				//checks if segment has already been add
				if(!(uniqueSegList.contains(new SegmentNode(keysArray[i], valuesArray[j]))) ||
						!(uniqueSegList.contains(new SegmentNode(keysArray[j], valuesArray[i])))) 
				{
					uniqueSegList.add(newSegment);
				}
			}
		}
		return uniqueSegList;
	}


}