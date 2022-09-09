package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

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
		
    	PointNode b = new PointNode("B", 4, 5);
		db.addUndirectedEdge(a, b);
		assertEquals(11, db.numUndirectedEdges());
		
    	SegmentNodeDatabase db2 = new SegmentNodeDatabase();
		assertEquals(0, db2.numUndirectedEdges());

	

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
		SegmentNodeDatabase testerDatabase = build();
		PointNode test1 = new PointNode("A", 3, 6);
		PointNode test2 = new PointNode("L", 3,8);
		PointNode test3 = new PointNode("Q", 7,8);
		PointNode test4 = new PointNode("Z", 3,3);
		
		List<PointNode> nodeList = new ArrayList<PointNode>();
		
		SegmentNode testA = new SegmentNode(test1, test2);
		SegmentNode testB = new SegmentNode(test1, test3);
		SegmentNode testC = new SegmentNode(test1, test4);
		SegmentNode testD = new SegmentNode(test2, test3);
		
		nodeList.add(test2);
		nodeList.add(test3);
		testerDatabase.addAdjacencyList(test1 , nodeList);
		
		//testing segment from first index of list
		assertTrue(testerDatabase.asSegmentList().contains(testA));
		//testing segment from second index of list
		assertTrue(testerDatabase.asSegmentList().contains(testB));
		//testing non included segment
		assertFalse(testerDatabase.asSegmentList().contains(testC));
		//testing two non-associated but contained segments
		assertFalse(testerDatabase.asSegmentList().contains(testD));
	}
	
	/**
     * 
     * */
	@Test
	void testAsSegmentList() 
	{
		SegmentNodeDatabase testerDatabase = build();
		SegmentNode test1 = new SegmentNode( new PointNode("A", 3, 6), new PointNode("B", 2, 4));
		SegmentNode test2 = new SegmentNode( new PointNode("B", 2, 4), new PointNode("A", 3, 6));
    	SegmentNode test3 = new SegmentNode(new PointNode("B", 2, 4), new PointNode("D", 0, 0));
    	SegmentNode test4 = new SegmentNode(new PointNode("D", 0, 0), new PointNode("E", 6, 0));
    	SegmentNode test5 = new SegmentNode(new PointNode("D", 0, 0), new PointNode("G", 9, 0));
		List<SegmentNode> Segments = testerDatabase.asSegmentList();
		//testing if list filled
		assertFalse(Segments.isEmpty());
		//testing if list contains segment going one way
		assertTrue(Segments.contains(test1));
		//testing if aforementioned segment is undirected
		assertTrue(Segments.contains(test2));
		//testing 0,0 on one side
		assertTrue(Segments.contains(test3));
		//testing 0.0 on other side
		assertTrue(Segments.contains(test4));
		//testing contains with not-contained segment
		assertFalse(Segments.contains(test5));
		//testing length
		assertEquals(Segments.size(), 20);
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
		
		SegmentNode testFirstNode = new SegmentNode( new PointNode("A", 3, 6), new PointNode("B", 2, 4));
    	SegmentNode testMiddleNode = new SegmentNode(new PointNode("B", 2, 4), new PointNode("D", 0, 0));
    	SegmentNode testLastNode = new SegmentNode(new PointNode("D", 0, 0), new PointNode("E", 6, 0));
		
		assertTrue(uniqueSegments.get(0) instanceof SegmentNode);
		assertEquals(uniqueSegments.size(), 10);
		assertEquals(uniqueSegments.get(0), testFirstNode);
		assertEquals(uniqueSegments.get(4), testMiddleNode);
		assertEquals(uniqueSegments.get(9), testLastNode);
	}
}
