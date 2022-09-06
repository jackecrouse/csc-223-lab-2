package input.components.segment;

import java.util.HashMap;
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
		
		
		return 4; //just to get rid of red line
	}
	
	/**
	 * 
	 * */
	protected void addDirectedEdge(PointNode a, PointNode b) {
		
	}
	
	/**
	 * 
	 * */
	public void addUndirectedEdge(PointNode a, PointNode b) {
		
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