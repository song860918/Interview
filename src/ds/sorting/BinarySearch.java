package ds.sorting;

public class BinarySearch {

    public int find(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return find(arr, key, 0, arr.length - 1);
    }

    private int find(int[] arr, int key, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (key == arr[mid]) {
            return mid;
        } else if (key < arr[mid]) {
            return find(arr, key, start, mid - 1);
        } else {
            return find(arr, key, mid + 1, end);
        }

    }

    public int findIterative(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0, end = arr.length - 1;
        int mid = -1;

        while (start <= end) {
            mid = (start + end) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    /**
     * This is WRONG!
     * The reason is the first if-if branch is sorted, but the second if-if branch is not, so we cannot determine "start = mid + 1" because it can be in the first half of array or second half.
     * Same thing apply to the fourth condition.
     * So the strategy should be finding which half of the array is sorted, and then determine if target is in there. If not, we are sure target is in the other half of the array.
     * @param nums
     * @param target
     * @return
     */
    public int searchWrong(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid = -1;

        while (start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                if (nums[start] <= target) {
                    // normal order: start <= target < mid
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end]) {
                    // normal order: mid < target <= end
                    start = mid + 1;
                } else {
                    // order: mid < target, end < target
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * As mentioned in the previous method, the strategy should be finding which half of the array is sorted, and then determine if target is in there. If not, we are sure target is in the other half of the array.
     * This also smartly included the use case where the whole array is sorted.
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid = -1;

        while (start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            // Left is sorted
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // Right is sorted
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * This question has to be solved by recursion because you need to call both if A[start] == A[mid] == A[end]
     * @param A
     * @param target
     * @return
     */

    public boolean searchWithDuplicates(int[] A, int target) {
        if (A == null || A.length == 0) return false;
        return searchWithDuplicates(A, target, 0, A.length - 1);

    }

    private boolean searchWithDuplicates(int[] A, int target, int start, int end) {

        if (start > end) return false;

        int mid = (start + end) / 2;
        if (A[mid] == target) return true;

        if (A[start] < A[mid]) {//left is sorted
            if (A[start] <= target && A[mid] > target) {
                return searchWithDuplicates(A, target, start, mid - 1);
            } else {
                return searchWithDuplicates(A, target, mid + 1, end);
            }
        } else if (A[start] > A[mid]) {// right is sorted
            if (A[mid] < target && A[end] >= target) {
                return searchWithDuplicates(A, target, mid + 1, end);
            } else {
                return searchWithDuplicates(A, target, start, mid - 1);
            }
        } else {// A[start] == A[mid]
            if (A[end] != A[mid]) {// left are all duplicates
                return searchWithDuplicates(A, target, mid + 1, end);
            } else {
                return searchWithDuplicates(A, target, start, mid - 1) || searchWithDuplicates(A, target, mid + 1, end);
            }
        }

    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums[0] < nums[nums.length - 1]) {
            //Whole array is sorted
            return nums[0];
        }
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return nums[start];
        }

        if (end - start == 1) {
            // Found the turning point
            return nums[end];
        }

        int mid = (start + end) / 2;
        if (nums[start] < nums[mid]) {
            //Left is sorted
            return findMin(nums, mid, end);
        } else if (nums[start] > nums[mid]) {
            //Right is sorted
            return findMin(nums, start, mid);
        } else {
            //nums[start] == nums[mid]
            if (nums[mid] != nums[end]) {
                return findMin(nums, mid, end);
            } else {
                int toReturn = findMin(nums, start, mid);
                if (toReturn == -1) {
                    toReturn = findMin(nums, mid, end);
                }
                return toReturn;
            }
        }
    }

}
