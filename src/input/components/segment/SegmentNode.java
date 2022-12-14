package input.components.segment;

import input.components.point.PointNode;

/**
 * A utility class only for representing ONE segment
 */
public class SegmentNode
{
	protected PointNode _point1;
	protected PointNode _point2;
	
	public PointNode getPoint1() { return _point1; }
	public PointNode getPoint2() { return _point2; }
	
	public SegmentNode(PointNode pt1, PointNode pt2)
	{
		_point1 = pt1;
		_point2 = pt2;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof SegmentNode))
			return false;
		SegmentNode checkerNode = (SegmentNode) obj;
		if(checkerNode.getPoint1().equals(this._point1) && checkerNode.getPoint2().equals(this._point2))
			return true;
		return false;
	}
	
	public String toString()
	{
		String res = "["; 

		res += _point1.toString();
		res += ", ";
		res += _point2.toString();
		res += "]";

		return res;
	}
	
}