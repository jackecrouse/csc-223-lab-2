package input.components.segment;

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
	public void addAdjacencyList(PointNode a, List<PointNode> b) {

	}

	/**
	 * 
	 * */
	public List<SegmentNode> asSegmentList()
	{
		return null;
	}

	/**
	 * 
	 * */
	public List<SegmentNode> asUniqueSegmentList()
	{
		return null;
	}


}