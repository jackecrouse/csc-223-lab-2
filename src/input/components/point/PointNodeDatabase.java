package input.components.point;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PointNodeDatabase 
{
	/**
	 * Instance vars and 2 constructors for PointNodeDatabase
	 * */
	Set<PointNode> _points;
	
	PointNodeDatabase()
	{		
		this._points = new LinkedHashSet<PointNode>();
	}
	
	PointNodeDatabase(List<PointNode> list)
	{
		this._points = new LinkedHashSet<PointNode>();
		_points.addAll(list);
	}
	
	/**
	 * adds PointNode to _points
	 * */
	public void put(PointNode node)
	{
		_points.add(node);
	}
	
	/**
	 * checks if _points contains a given PointNode
	 * @return boolean
	 * */
	public boolean contains(PointNode node)
	{
		for(PointNode item : _points)
		{
			if(item.equals(node)) return true;
		}
		
		return false;
	}
	
	/**
	 * checks if _points contains a PointNode containing 
	 * specified values
	 * @return boolean
	 * */
	public boolean contains(double x, double y)
	{
		for(PointNode item: _points)
		{
			if(item._x == x && item._y == y) return true;
		}
		
		return false;
	}
	
	/**
	 * @return name of given PointNode
	 * */
	public String getName(PointNode node)
	{
		for(PointNode item : _points)
		{
			if(item.equals(node)) return item._name;
		}
		return PointNode.ANONYMOUS;
	}
	
	/**
	 * @return name of PointNode containing give values
	 * */
	public String getName(double x, double y)
	{
		for(PointNode item : _points)
		{
			if(item._x == x && item._y == y) return item._name;
		}
		return PointNode.ANONYMOUS;
	}
	
	/**
	 * getter for given PointNode
	 * @return PointNode
	 * */
	public PointNode getPoint(PointNode node)
	{
		for(PointNode item : _points)
		{
			if(item.equals(node)) return item;
		}
		return null;
	}
	
	/**
	 * getter for PointNode containing specified values
	 * @return PointNode
	 * */
	public PointNode getPoint(double x, double y)
	{
		for(PointNode item : _points)
		{
			if(item._x == x && item._y == y) return item;
		}
		return null;
	}
}
