/* There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays.The overall run time complexity should
be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty.
Example 1:
nums1 = [1, 3]
nums2 = [2]
The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5 */
public class Q4_MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        // Merge nums1 and nums2 into nums
        while (i < nums1.length && j < nums2.length) {

            // Compare nums1[i] and nums2[j]
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }

        // Copy remaining elements of nums1
        while (i < nums1.length) {
            nums[k++] = nums1[i++];
        }

        // Copy remaining elements of nums2
        while (j < nums2.length) {
            nums[k++] = nums2[j++];
        }

        // Calculate the median of nums after merging
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
        } else {
            return nums[nums.length / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}

/*Expected Output:

2.0

* */