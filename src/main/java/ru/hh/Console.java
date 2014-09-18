package ru.hh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import ru.hh.task1.Rect;
import ru.hh.task1.Task1;
import ru.hh.task2.Task2;

public class Console {
	private static final String RECTANGLE = "1";
	private static final String WEIGHER = "2";
	private static final String EXIT = "Exit";
	private static List<Rect> task1Input = new LinkedList<Rect>();

	public static void start() {
		getTaskList();
		startTask();
		start();
	}

	private static void startTask() {
		String task = readUserInput();

		if (RECTANGLE.equals(task)) {
			task1Discription();
			prepareStmForTask1();
			Task1 task1 = new Task1();
			task1.setInputList(task1Input);
			System.out.println(task1.getSq());
			task1Input = new LinkedList<Rect>();

		}

		else if (WEIGHER.equals(task)) {
			task2Discription();
			int taskNum = 100;
			Task2 task2 = new Task2(readIntList(), taskNum);
			System.out.println(task2.getResult());
		} else {
			printWrongInput();
		}
	}

	private static List<Integer> readIntList() {
		List<Integer> list = new LinkedList<Integer>();
		String userIn = readUserInput();
		if (userIn == null || userIn.length() == 0) {
			printWrongInput();
			readIntList();
		} else {
			for (String str : userIn.replace(" ", "").split(",")) {
				String temp = str.replaceAll("[^\\d]", "");
				if (!temp.equals("")) {
					list.add(Integer.parseInt(temp));
				}
			}
		}
		if (list.size() == 0) {
			printWrongInput();
			readIntList();
		}
		return list;
	}

	private static void prepareStmForTask1() {
		int sizeOfOneSet = 4;
		if (!"".equals(readUserInput())) {
			List<Integer> list = readIntList();
			if ((list.size() % sizeOfOneSet) == 0) {
				for (int i = 0; i < list.size(); i += sizeOfOneSet) {
					task1Input.add(new Rect(list.get(i), list.get(i + 1), list
							.get(i + 2), list.get(i + 3)));
				}
			}
			prepareStmForTask1();
		}
	}

	private static String readUserInput() {
		String in = "";
		try {
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			in = bufferRead.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (EXIT.equals(in)) {
			System.exit(0);
		}
		return in;
	}

	private static void printWrongInput() {
		System.out.println();
		System.out.println("Wrong input, try again");
		System.out.println();
	}

	private static void task1Discription() {
		System.out.println();
		System.out.println("Input coordinates in format : x1,y1,x2,y2");
		System.out.println("Example :\n0,1,3,3\n2,2,6,4\nor\n0,1,3,3,2,2,6,4...");
		System.out.println("When coordinates will be ended, type : empty line");
		System.out.println();
	}

	private static void task2Discription() {
		System.out.println();
		System.out.println("Input numbers in format : 1,2,3,5,6,3,6,7,8,3...");
		System.out.println();
	}

	private static void getTaskList() {
		System.out.println();
		System.out.println("For task with Rectangle, type - " + RECTANGLE);
		System.out.println("For task with Weigher, type - " + WEIGHER);
		System.out.println("For exit, type - " + EXIT);
		System.out.println();
	}
}
