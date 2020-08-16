package com.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/**
 * sort a list of multiple sorted lists
 * this can also be stated as merge k sorted lists
 * this can also be stated as merge k iterators
 * @author vikrantmathure
 *
 * Time Complexity  = k*O(N) - where N is average size of the list
 * Space Complexity = O(k*N) = k*O(N)
 */
public class SortListsofListofSortedIntegers {

	/**
	 * merges to sorted iterators
	 * @param iter1
	 * @param iter2
	 * @return List<Integer>
	 */
	private static List<Integer> sort(Iterator<Integer> iter1, Iterator<Integer> iter2) {
		List<Integer> result = new ArrayList<>();
		Integer s1 = iter1.hasNext() ? iter1.next() : null;
		Integer s2 = iter2.hasNext() ? iter2.next() : null;

		while (s1 != null & s2 != null) {
			if (s1 < s2) {
				result.add(s1);
				s1 = iter1.hasNext() ? iter1.next() : null;
			} else {
				result.add(s2);
				s2 = iter2.hasNext() ? iter2.next() : null;
			}
		}

		while (s2 != null) {
			result.add(s2);
			s2 = iter2.hasNext() ? iter2.next() : null;
		}
		while (s1 != null) {
			result.add(s1);
			s1 = iter1.hasNext() ? iter1.next() : null;
		}
		return result;
	}
	
	/**
	 * starts the merge process 
	 * @param list
	 */
	private static void mergeKLists(List<List<Integer>> list) {
		List<Integer> resultList = new ArrayList<Integer>(list.get(0));
		Iterator<Integer> result = null;

		for (int i = 1; i < list.size(); i++) {
			result = resultList.iterator();
			resultList = sort(result, new ArrayList<>(list.get(i)).iterator());
		}
		System.out.println(resultList);
	}
	
	/**
	 * driver
	 * @param args
	 */
	public static void main(String[] args) {

		List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5), 
												 Arrays.asList(15, 25, 35, 45, 55),
												 Arrays.asList(12, 22, 32, 42, 52), 
												 Arrays.asList(100, 200, 300, 400, 500)
												 );
		mergeKLists(list);

		System.out.println(sortListOfSortedLists(list));
	}

	/**
	 * brute force: copy all integers into one list and sort it
	 * N - max size of list
	 * k - # of lists
	 * T(n) = O(kNlogkN)
	 * S(n) = O(kN)
	 * @param input
	 * @return
	 */
	public static List<Integer> sortListOfSortedLists(List<List<Integer>> input) {

		List<Integer> listToSort = new ArrayList<>();

		input.forEach(list -> list.forEach(n -> listToSort.add(n)));

		Integer[] arrToSort = new Integer[listToSort.size()];

		for (int i = 0; i < arrToSort.length; i++) {
			arrToSort[i] = listToSort.get(i);
		}

		Arrays.sort(arrToSort);

		return Arrays.asList(arrToSort);
	}
}



