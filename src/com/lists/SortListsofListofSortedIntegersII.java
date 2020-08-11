package com.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * sort a list of multiple sorted lists this can also be stated as merge k
 * sorted lists this can also be stated as merge k iterators
 * 
 * @author vikrantmathure
 * 
 * Time Complexity = k.O(log n)
 * Space Complexity = O(n)
 *
 */
public class SortListsofListofSortedIntegersII {
	
	/**
	 * utility pair class for holding smallest element & corresponding list it belongs to
	 */
	private static class Pair {
		Integer smallest;
		Integer listIndex;
		public Pair(Integer smallest, Integer listIndex) {
			super();
			this.smallest = smallest;
			this.listIndex = listIndex;
		}
		public Integer getSmallest() {
			return smallest;
		}
		public Integer getListIndex() {
			return listIndex;
		}
	}
	/**
	 * merges k lists using priority queue
	 * @param list
	 * @return List<Integer>
	 */
	private static List<Integer> mergeKLists(List<List<Integer>> list) {
		//ascending order by smallest element
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.getSmallest() - b.getSmallest());
		List<Iterator<Integer>> listOfIterators = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			Pair pair = new Pair(list.get(i).get(0), i);
			pq.offer(pair);
			listOfIterators.add(list.get(i).iterator());
		}
		
		List<Integer> resultList = new LinkedList<>();

		while (!pq.isEmpty()) {
			Pair smallestOne = pq.remove();
			Integer next = listOfIterators.get(smallestOne.getListIndex()).hasNext() ? listOfIterators.get(smallestOne.getListIndex()).next() : null;
			if (next != null) {
				pq.offer(new Pair(next, smallestOne.getListIndex()));
				resultList.add(next);
			}
		}
		return resultList;
	}
	/**
	 * driver
	 * @param args
	 */
	public static void main(String[] args) {

		List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(15, 25, 35, 45, 55),
				Arrays.asList(12, 22, 32, 42, 52), Arrays.asList(100, 200, 300, 400, 500));

		List<Integer> resultList = mergeKLists(list);
		System.out.println(resultList);
	}
}
