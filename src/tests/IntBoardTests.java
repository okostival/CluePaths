package tests;

import java.util.LinkedList;
import java.util.TreeSet;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import experiment.IntBoard;

public class IntBoardTests {

	private IntBoard board;
	
	@Before
	public void initBoard()
	{
		board = new IntBoard();
		return;
	}
	
	@Test
	public void testCalcIndex() {
		int expected = 10;
		int actual = IntBoard.calcIndex(2,2);
		Assert.assertEquals(expected, actual);
		
		expected = 0;
		actual = IntBoard.calcIndex(0,0);
		Assert.assertEquals(expected, actual);
		
		expected = 7;
		actual = IntBoard.calcIndex(1,3);
		Assert.assertEquals(expected, actual);
		
		expected = 13;
		actual = IntBoard.calcIndex(3, 1);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testAdjacencyList() {
		LinkedList<Integer> expectedList = board.getAdjList(0);
		Assert.assertTrue(expectedList.contains(4));
		Assert.assertTrue(expectedList.contains(1));
		Assert.assertEquals(2, expectedList.size());
	}
	
	@Test 
	public void testAdjacencyList1() {
		LinkedList<Integer> expectedList = board.getAdjList(15);
		Assert.assertTrue(expectedList.contains(11));
		Assert.assertTrue(expectedList.contains(14));
		Assert.assertEquals(2, expectedList.size());
	}
	
	@Test 
	public void testAdjacencyList2() {
		LinkedList<Integer> expectedList = board.getAdjList(2);
		Assert.assertTrue(expectedList.contains(1));
		Assert.assertTrue(expectedList.contains(3));
		Assert.assertTrue(expectedList.contains(6));
		Assert.assertEquals(3, expectedList.size());
	}
	
	@Test 
	public void testAdjacencyList3() {
		LinkedList<Integer> expectedList = board.getAdjList(8);
		Assert.assertTrue(expectedList.contains(4));
		Assert.assertTrue(expectedList.contains(9));
		Assert.assertTrue(expectedList.contains(12));
		Assert.assertEquals(3, expectedList.size());
	}
	
	@Test 
	public void testAdjacencyList4() {
		LinkedList<Integer> expectedList = board.getAdjList(11);
		Assert.assertTrue(expectedList.contains(7));
		Assert.assertTrue(expectedList.contains(10));
		Assert.assertTrue(expectedList.contains(15));
		Assert.assertEquals(3, expectedList.size());
	}
	
	@Test 
	public void testAdjacencyList5() {
		LinkedList<Integer> expectedList = board.getAdjList(6);
		Assert.assertTrue(expectedList.contains(2));
		Assert.assertTrue(expectedList.contains(5));
		Assert.assertTrue(expectedList.contains(7));
		Assert.assertTrue(expectedList.contains(10));
		Assert.assertEquals(4, expectedList.size());
	}
	
	@Test 
	public void testAdjacencyList6() {
		LinkedList<Integer> expectedList = board.getAdjList(9);
		Assert.assertTrue(expectedList.contains(5));
		Assert.assertTrue(expectedList.contains(8));
		Assert.assertTrue(expectedList.contains(10));
		Assert.assertTrue(expectedList.contains(13));
		Assert.assertEquals(4, expectedList.size());
	}
	
	@Test
	public void testTargets0_3() {
		board.calcTargets(0, 3);
		TreeSet<Integer> expectedTree = board.getTargets();
		Assert.assertTrue(expectedTree.contains(3));
		Assert.assertTrue(expectedTree.contains(12));
		Assert.assertTrue(expectedTree.contains(6));
		Assert.assertTrue(expectedTree.contains(9));
		Assert.assertTrue(expectedTree.contains(1));
		Assert.assertTrue(expectedTree.contains(4));
		Assert.assertEquals(6, expectedTree.size());
	}
	
	@Test
	public void testTargets15_3() {
		board.calcTargets(15, 3);
		TreeSet<Integer> expectedTree = board.getTargets();
		Assert.assertTrue(expectedTree.contains(3));
		Assert.assertTrue(expectedTree.contains(12));
		Assert.assertTrue(expectedTree.contains(6));
		Assert.assertTrue(expectedTree.contains(9));
		Assert.assertTrue(expectedTree.contains(11));
		Assert.assertTrue(expectedTree.contains(14));
		Assert.assertEquals(6, expectedTree.size());
	}
	
	@Test
	public void testTargets5_2() {
		board.calcTargets(5, 2);
		TreeSet<Integer> expectedTree = board.getTargets();
		Assert.assertTrue(expectedTree.contains(0));
		Assert.assertTrue(expectedTree.contains(2));
		Assert.assertTrue(expectedTree.contains(8));
		Assert.assertTrue(expectedTree.contains(10));
		Assert.assertTrue(expectedTree.contains(7));
		Assert.assertTrue(expectedTree.contains(13));
		Assert.assertEquals(6, expectedTree.size());
	}
	
	@Test
	public void testTargets10_3() {
		board.calcTargets(10, 3);
		TreeSet<Integer> expectedTree = board.getTargets();
		Assert.assertTrue(expectedTree.contains(1));
		Assert.assertTrue(expectedTree.contains(3));
		Assert.assertTrue(expectedTree.contains(4));
		Assert.assertTrue(expectedTree.contains(9));
		Assert.assertTrue(expectedTree.contains(11));
		Assert.assertTrue(expectedTree.contains(12));
		Assert.assertTrue(expectedTree.contains(14));
		Assert.assertTrue(expectedTree.contains(6));
		Assert.assertEquals(8, expectedTree.size());
	}
	
	@Test
	public void testTargets6_1() {
		board.calcTargets(6, 1);
		TreeSet<Integer> expectedTree = board.getTargets();
		Assert.assertTrue(expectedTree.contains(2));
		Assert.assertTrue(expectedTree.contains(5));
		Assert.assertTrue(expectedTree.contains(7));
		Assert.assertTrue(expectedTree.contains(10));
		Assert.assertEquals(4, expectedTree.size());
	}
	
	@Test
	public void testTargets3_1() {
		board.calcTargets(3, 1);
		TreeSet<Integer> expectedTree = board.getTargets();
		Assert.assertTrue(expectedTree.contains(2));
		Assert.assertTrue(expectedTree.contains(7));
		Assert.assertEquals(2, expectedTree.size());
	}
	
	@Test
	public void testTargets12_4() {
		board.calcTargets(12, 4);
		TreeSet<Integer> expectedTree = board.getTargets();
		Assert.assertTrue(expectedTree.contains(1));
		Assert.assertTrue(expectedTree.contains(11));
		Assert.assertTrue(expectedTree.contains(9));
		Assert.assertTrue(expectedTree.contains(6));
		Assert.assertTrue(expectedTree.contains(14));
		Assert.assertTrue(expectedTree.contains(4));
		Assert.assertEquals(6, expectedTree.size());
	}
}
