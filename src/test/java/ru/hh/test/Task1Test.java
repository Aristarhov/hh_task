package ru.hh.test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.hh.task1.Rect;
import ru.hh.task1.Task1;

public class Task1Test {
	private Task1 sut;

	private int[][] list1 = { { 2, 2, 3, 10 }, { 2, 2, 3, 10 },
			{ 2, 9, 11, 10 }, { 2, 3, 10, 4 }, { 8, 1, 9, 9 }, { 5, 6, 6, 7 },
			{ 4, 5, 7, 8 }, { 7, 2, 11, 5 } };

	private int[][] list2 = { { 4, 1, 6, 1 }, { 2, 2, 6, 4 }, { 1, 0, 3, 5 },
			{ 0, 1, 3, 3 }, { 7, 2, 9, 4 } };

	private int[][] list3 = { { 2, 2, 6, 4 }, { 0, 1, 3, 3 }, { 1, 0, 3, 5 } };

	private int[][] list4 = { { 1, 1, 7, 5 }, { 2, 2, 5, 4 }, { 3, 1, 4, 4 },
			{ 8, 5, 10, 7 }, { 5, 5, 11, 6 } };

	private int[][] list5 = { { 0, 0, 2, 2 }, { 0, 0, 1, 2 }, { 0, 1, 1, 4 },
			{ 2, 0, 5, 1 } };

	private int[][] list6 = { { 5, 5, 5, 5 }, { 0, 10, 0, 20 },
			{ 10, 0, 20, 0 } };

	@Before
	public void setUp() {
		sut = new Task1();

	}

	@After
	public void tearDown() {

	}

	@Test
	public void test1() {
		List<Rect> listRect = fillList(list1);
		sut.setInputList(listRect);

		assertEquals(46L, sut.getSq());
	}

	@Test
	public void test2() {
		List<Rect> listRect = fillList(list2);
		sut.setInputList(listRect);

		assertEquals(22L, sut.getSq());
	}

	@Test
	public void test3() {
		List<Rect> listRect = fillList(list3);
		sut.setInputList(listRect);

		assertEquals(18L, sut.getSq());
	}

	@Test
	public void test4() {
		List<Rect> listRect = fillList(list4);
		sut.setInputList(listRect);

		assertEquals(32L, sut.getSq());
	}

	@Test
	public void test5() {
		List<Rect> listRect = fillList(list5);
		sut.setInputList(listRect);

		assertEquals(9L, sut.getSq());
	}

	@Test
	public void test6() {
		List<Rect> listRect = fillList(list6);
		sut.setInputList(listRect);

		assertEquals(0L, sut.getSq());
	}

	private List<Rect> fillList(int[][] list) {
		List<Rect> listRect = new LinkedList<Rect>();

		for (int[] i : list) {
			listRect.add(new Rect(i[0], i[1], i[2], i[3]));
		}
		return listRect;
	}
}
