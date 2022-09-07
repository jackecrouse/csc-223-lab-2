package input.components.point;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

class PointNodeDatabaseTest 
{
	
	/**
	 * Used for auto-filling database to execute tests on
	 * */
	private PointNode zeros = new PointNode("zeros", 0, 0);
	private PointNode ones = new PointNode("ones", 1, 1);
	private PointNode twos = new PointNode("twos", 2, 2);
	private PointNode threes = new PointNode("threes", 3, 3);
	private PointNode fours = new PointNode("fours", 4, 4);
	private final ArrayList<PointNode> FILLER = new ArrayList<>(Arrays.asList(zeros,ones,twos,threes,fours));
	
	/**
     * test put() on an empty and non-empty database
     * */
	@Test
	void testPut() 
	{
		//test put with empty database
		PointNodeDatabase testPut = new PointNodeDatabase();
		assertTrue(testPut.isEmpty());
		PointNode newNode = new PointNode("new", 7, 7);
		testPut.put(newNode);
		assertEquals(testPut.getName(newNode), "new");
		assertTrue(testPut.contains(newNode));
		
		//test put with non-empty database
		PointNodeDatabase testPut2 = new PointNodeDatabase(FILLER);
		assertFalse(testPut2.isEmpty());
		testPut2.put(newNode);
		assertEquals(testPut2.getName(newNode), "new");
		assertTrue(testPut2.contains(newNode));
	}
	
	/**
     * 
     * */
	@Test
	void testContainsPointNode() 
	{
		
	}
	
	/**
     * 
     * */
	@Test
	void testContainsValues() 
	{
		
	}
	
	/**
     * 
     * */
	@Test
	void testGetNamePointNode() 
	{
		PointNodeDatabase testGetNamePN = new PointNodeDatabase(FILLER);
		assertFalse(testGetNamePN.isEmpty());
		assertEquals(testGetNamePN.getName(fours), "fours");
		assertEquals(testGetNamePN.getName(threes), "threes");
		assertEquals(testGetNamePN.getName(twos), "twos");
		assertEquals(testGetNamePN.getName(ones), "ones");
		assertEquals(testGetNamePN.getName(zeros), "zeros");
	}
	
	/**
     * 
     * */
	@Test
	void testGetNameValues() 
	{
		PointNodeDatabase testGetNameV = new PointNodeDatabase(FILLER);
		assertFalse(testGetNameV.isEmpty());
		assertEquals(testGetNameV.getName(4,4), "fours");
		assertEquals(testGetNameV.getName(3,3), "threes");
		assertEquals(testGetNameV.getName(2,2), "twos");
		assertEquals(testGetNameV.getName(1,1), "ones");
		assertEquals(testGetNameV.getName(0,0), "zeros");
		
		assertNotEquals(testGetNameV.getName(4, 4), "threes");
	}
	
	/**
     * 
     * */
	@Test
	void testGetPointPointNode() 
	{
		PointNode dontAddNode = new PointNode(5, 5);
		PointNodeDatabase testGetPointPN = new PointNodeDatabase(FILLER);
		assertFalse(testGetPointPN.isEmpty());
		assertEquals(testGetPointPN.getPoint(fours), fours);
		assertEquals(testGetPointPN.getPoint(threes), threes);
		assertEquals(testGetPointPN.getPoint(twos), twos);
		assertEquals(testGetPointPN.getPoint(ones), ones);
		assertEquals(testGetPointPN.getPoint(zeros), zeros);
		
		assertNotEquals(testGetPointPN.getPoint(fours), zeros);
		assertNull(testGetPointPN.getPoint(dontAddNode));
	}
	
	/**
     * 
     * */
	@Test
	void testGetPointValues() 
	{
		PointNodeDatabase testGetPointV = new PointNodeDatabase(FILLER);
		assertFalse(testGetPointV.isEmpty());
		assertEquals(testGetPointV.getPoint(4,4), fours);
		assertEquals(testGetPointV.getPoint(3,3), threes);
		assertEquals(testGetPointV.getPoint(2,2), twos);
		assertEquals(testGetPointV.getPoint(1,1), ones);
		assertEquals(testGetPointV.getPoint(0,0), zeros);
		
		assertNotEquals(testGetPointV.getPoint(4,4), zeros);
		assertNull(testGetPointV.getPoint(5,5));

	}
}
