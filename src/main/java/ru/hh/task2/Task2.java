package ru.hh.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {

	private final int WEIGHT;

	private int sum;
	private List<Integer> inputList;
	private List<Integer> leftScales;
	private List<Integer> rightScales;
	private List<Integer> specificWeight;

	public Task2(List<Integer> inputList, int weight){
		this.WEIGHT = weight;
		this.inputList = inputList;
	}
	
	public String getResult() {
		calsum();
		Collections.sort(inputList, Collections.reverseOrder());

		if ((sum % 2) == 0) {
			int half = sum / 2;
			List<Integer> newInputList = new ArrayList<Integer>(inputList);

			leftScales = reachable(half, 0, new ArrayList<Integer>(),
					newInputList, sum);
			if (leftScales != null) {
				rightScales = new ArrayList<Integer>(inputList);
				for (Integer i : leftScales) {
					rightScales.remove(i);
				}
			}
		}

		if (WEIGHT == sum) {
			specificWeight = inputList;
		}
		if (WEIGHT < sum) {
			List<Integer> newInputList = new ArrayList<Integer>(inputList);
			specificWeight = reachable(WEIGHT, 0, new ArrayList<Integer>(),
					newInputList, sum);
		}

		return getResultForType();
	}


	private List<Integer> reachable(int target, int currentSum,
			List<Integer> passedList, List<Integer> inputList, int capacity) {
		while (!inputList.isEmpty()) {
			if ((currentSum + capacity) < target) {
				return null;
			}

			int curElement = inputList.remove(0);
			int tempSum = currentSum + curElement;

			if (tempSum == target) {
				passedList.add(curElement);
				return passedList;
			}
			if (tempSum > target) {
				capacity -= curElement;
				continue;
			}

			List<Integer> newPassedList = new ArrayList<Integer>(passedList);
			List<Integer> newInputList = new ArrayList<Integer>(inputList);
			newPassedList.add(curElement);

			List<Integer> result = reachable(target, tempSum, newPassedList,
					newInputList, capacity);
			if (result != null) {
				return result;
			}
			capacity -= curElement;
		}
		return null;
	}

	private void calsum() {
		for (int i : inputList) {
			sum += i;
		}
	}

	private String getResultForType() {
		String out = "";
		if (leftScales == null) {
			out += "no balance";
		} else {
			for(int i : leftScales){
				out += i + " ";
			}
			out += "- ";
			for(int i : rightScales){
				out += i + " ";
			}
		}
		out += "\n";
		if (specificWeight == null) {
			out += "no";
		} else {
			out += "yes";
		}
		return out;
	}
	
	public List<Integer> getLeftScales() {
		return leftScales;
	}
	
	public List<Integer> getRightScales() {
		return rightScales;
	}
	
	public List<Integer> getSpecificWeight() {
		return specificWeight;
	}
}
