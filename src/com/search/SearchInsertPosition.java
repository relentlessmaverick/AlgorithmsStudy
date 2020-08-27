package com.search;

/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * @author vikrantmathure
 *
 * Time Complexity is O(n) & Space Complexity is O(1) [constant space solution]
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int result = -1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if(target == arr[mid]) {
                result = mid;
                break;
            } else if (target > arr[mid]){
                l = mid + 1;
            } else {
                r = mid - 1;
            }               
        }
        return result == -1 ? l : result;
    }
    
    public static void main(String[] args) {
		System.out.println(searchInsert(new int[] {1,2,3,4,5,7,8,9,10,11},6));
	}
}
