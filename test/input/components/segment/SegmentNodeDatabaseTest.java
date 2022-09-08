package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import input.components.point.PointNode;

class SegmentNodeDatabaseTest
{
	
	
    public SegmentNodeDatabase build()
    {
    	//      A                                 
    	//     / \                                
    	//    B___C                               
    	//   / \ / \                              
    	//  /   X   \ 
    	// D_________E
    	//
		//
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	  	
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	db.addUndirectedEdge(b, x);
    	db.addUndirectedEdge(b, d);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(c, e);
    	db.addUndirectedEdge(x, d);
    	db.addUndirectedEdge(x, e);
    	db.addUndirectedEdge(d, e);       	
    	
    	return db;
    }
    
    /**
     * 
     * */
	@Test
	void testNumUndirectedEdges()
	{
		SegmentNodeDatabase db = build();
		assertEquals(10, db.numUndirectedEdges());
		
		
    	PointNode a = new PointNode("A", 3, 6);
    	db.addUndirectedEdge(a, a);
    	
    	
		assertEquals(10, db.numUndirectedEdges());
		
	}
	
	/**
     * 
     * */
	@Test
	void testAddUndirectedEdge() 
	{
		PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);
    	PointNode d = new PointNode("D", 0, 0);
    	
    	
    	SegmentNodeDatabase db = new SegmentNodeDatabase();

    	db.addUndirectedEdge(a, b);

		assertEquals(1, db.numUndirectedEdges());
		
    	db.addUndirectedEdge(b, c);
    	
		assertEquals(2, db.numUndirectedEdges());
		
	}
	
	/**
     * 
     * */
	@Test
	void testAddAdjacencyList() 
	{
		
	}
	
	/**
     * 
     * */
	@Test
	void testAsSegmentList() 
	{
		
	}
	
	/**
     * tests asUniqueSegmentList() by executing test on
     * the database created by build()
     * */
	@Test
	void testAsUniqueSegmentList() 
	{
		SegmentNodeDatabase testerDatabase = build();
		List<SegmentNode> uniqueSegments = testerDatabase.asUniqueSegmentList();
		
		SegmentNode testNode = new SegmentNode( new PointNode("A", 3, 6), new PointNode("B", 2, 4));
		
		assertTrue(uniqueSegments.get(0) instanceof SegmentNode);
		assertEquals(uniqueSegments.size(), 10);
		//assertEquals(uniqueSegments.get(0), testNode);
	}
}
