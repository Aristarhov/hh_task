package ru.hh.task1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Task1 {
	private List<Rect> inputList = new LinkedList<Rect>();
	private List<Rect> addedList = new LinkedList<Rect>();

	public long getSq() {
		intersectionRect();
		long result = 0;
		for (Rect rect : addedList) {
			result += rect.getArea();
		}
		return result;
	}

	private void intersectionRect() {
		if (inputList.isEmpty()) {
			return;
		}

		addedList.add(inputList.remove(0));

		while (!inputList.isEmpty()) {
			addRect(inputList.remove(0));
		}
	}

	private void addRect(Rect input) {
		for (Rect added : addedList) {
			if (compareRect(added, input)) {
				return;
			}
		}
		addedList.add(input);
	}

	private boolean compareRect(Rect a, Rect n) {
		if ((a.x1 >= n.x2) || (a.x2 <= n.x1) || (a.y1 >= n.y2)
				|| (a.y2 <= n.y1)) {
			return false;
		}

		if ((a.x1 <= n.x1) && (a.x2 >= n.x2) && (a.y1 <= n.y1)
				&& (a.y2 >= n.y2)) {
			return true;
		}

		if (n.x1 < a.x1) {
			inputList.add(new Rect(n.x1, n.y1, a.x1, n.y2));
		}
		
		if (n.x2 > a.x2) {
			inputList.add(new Rect(a.x2, n.y1, n.x2, n.y2));
		}

		if (a.y1 > n.y1) {
			int x1 = (n.x1 > a.x1) ? n.x1 : a.x1;
			int x2 = (n.x2 < a.x2) ? n.x2 : a.x2;
			inputList.add(new Rect(x1, n.y1, x2, a.y1));
		}
		
		if (a.y2 < n.y2) {
			int x1 = (n.x1 > a.x1) ? n.x1 : a.x1;
			int x2 = (n.x2 < a.x2) ? n.x2 : a.x2;
			inputList.add(new Rect(x1, a.y2, x2, n.y2));
		}

		return true;
	}

	public void setInputList(List<Rect> inputList) {
		Collections.sort(inputList);
		this.inputList = inputList;
	}

}
