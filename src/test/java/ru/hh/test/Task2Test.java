package ru.hh.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ru.hh.task2.Task2;

public class Task2Test {

	@Test
	public void test1() {
		Integer[] elements = { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		List<Integer> list = Arrays.asList(elements);

		Task2 sut = new Task2(list, 27);
		sut.getResult();
		assertNotNull(sut.getLeftScales());
		assertNotNull(sut.getSpecificWeight());
	}

	@Test
	public void test2() {
		Integer[] elements = { 34440, 8610, 70584, 10906, 36162, 4133, 27638,
				29448, 17220, 7750, 39032, 2870, 7414, 2010, 22386, 93275,
				20090, 40180, 64575, 65006, 39893, 197900, 22960, 4879, 22960,
				18311, 39893, 27638, 58896, 24108, 22386, 2727, 36162, 70584,
				34440, 6027, 8754, 4879, 4133, 34440, 5740, 2727, 15355, 1665,
				197902, 194900, 197900, 188900, 132959 };

		List<Integer> list = Arrays.asList(elements);

		Task2 sut = new Task2(list, 350000);
		sut.getResult();
		assertNull(sut.getLeftScales());
		assertNotNull(sut.getSpecificWeight());
	}

	@Test
	public void test3() {
		Integer[] elements = { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		List<Integer> list = Arrays.asList(elements);

		Task2 sut = new Task2(list, 28);
		sut.getResult();
		assertNotNull(sut.getLeftScales());
		assertNull(sut.getSpecificWeight());
	}
}