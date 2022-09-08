package input.components.segment;

import java.util.ArrayList;
import java.util.Arrays;
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
			for(PointNode point : entry.getValue())
			{
				if(_adjLists.get(point).contains(entry.getKey())) {numEdges++; }
			}
		}
		return numEdges / 2;
	}

	/**
	 * 
	 * */
	private void addDirectedEdge(PointNode a, PointNode b) 
	{
		//dangerous
		if(a.equals(b)) {return; }
		
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
		addDirectedEdge(a, b);
		addDirectedEdge(b, a);

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
			List<SegmentNode> SegList = new ArrayList<SegmentNode>();
			
			ArrayList<Object> keyArrayList = new ArrayList<>(Arrays.asList(_adjLists.keySet().toArray()));
			ArrayList<Object> valuesArrayList;
			
			//loops through keys in _adjLists
			for(int i = 0; i < keyArrayList.size(); i++) 
			{	
				//creates arrayList of values at key i
				valuesArrayList = new ArrayList<>(Arrays.asList(_adjLists.get(keyArrayList.get(i)).toArray()));
				
				//loops through values for each key in _adjLists
				for(int j = 0; j < valuesArrayList.size(); j++) 
				{					
					if(keyArrayList.get(i) instanceof PointNode && valuesArrayList.get(j) instanceof PointNode)
					{
						SegmentNode newSegmentNode = 
							new SegmentNode((PointNode) keyArrayList.get(i), (PointNode) valuesArrayList.get(j));
						
						
						if(!(SegList.contains(newSegmentNode))) {
							SegList.add(newSegmentNode);
						}
					}
				}
			}
		
		return SegList;
	}

	/**
	 * Creates a List of "directed edges" aka unique segments
	 * */
	public List<SegmentNode> asUniqueSegmentList()
	{
		List<SegmentNode> uniqueSegList = new ArrayList<SegmentNode>();
		
		ArrayList<Object> keyArrayList = new ArrayList<>(Arrays.asList(_adjLists.keySet().toArray()));
		ArrayList<Object> valuesArrayList;
		
		//loops through keys in _adjLists
		for(int i = 0; i < keyArrayList.size(); i++) 
		{	
			//creates arrayList of values at key i
			valuesArrayList = new ArrayList<>(Arrays.asList(_adjLists.get(keyArrayList.get(i)).toArray()));
			
			//loops through values for each key in _adjLists
			for(int j = 0; j < valuesArrayList.size(); j++) 
			{					
				//checks for "undirected edges" aka repeat segments
				if(keyArrayList.get(i) instanceof PointNode && valuesArrayList.get(j) instanceof PointNode)
				{
					SegmentNode newSegmentNode = 
						new SegmentNode((PointNode) keyArrayList.get(i), (PointNode) valuesArrayList.get(j));
					
					SegmentNode checker = 
							new SegmentNode((PointNode)valuesArrayList.get(j), (PointNode)keyArrayList.get(i)); 
					
					if(!(uniqueSegList.contains(newSegmentNode)) && !(uniqueSegList.contains(checker)))
						uniqueSegList.add(newSegmentNode);
				}
			}
		}
		return uniqueSegList;
	}


}