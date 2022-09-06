package input.components.point;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PointNodeDatabase {
	
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
	
	public void put(PointNode node)
	{
		_points.add(node);
	}
	
	public boolean contains(PointNode node)
	{
		for(PointNode item : _points)
		{
			if(item.equals(node)) return true;
		}
		
		return false;
	}
	
	public boolean contains(double x, double y)
	{
		for(PointNode item: _points)
		{
			if(item._x == x && item._y == y) return true;
		}
		
		return false;
	}
	
	public String getName(PointNode node)
	{
		for(PointNode item : _points)
		{
			if(item.equals(node)) return item._name;
		}
		return PointNode.ANONYMOUS;
	}
	
	public String getName(double x, double y)
	{
		for(PointNode item : _points)
		{
			if(item._x == x && item._y == y) return item._name;
		}
		return PointNode.ANONYMOUS;
	}
	
	public PointNode getPoint(PointNode node)
	{
		for(PointNode item : _points)
		{
			if(item.equals(node)) return item;
		}
		return null;
	}
	
	public PointNode getPoint(double x, double y)
	{
		for(PointNode item : _points)
		{
			if(item._x == x && item._y == y) return item;
		}
		return null;
	}
}
