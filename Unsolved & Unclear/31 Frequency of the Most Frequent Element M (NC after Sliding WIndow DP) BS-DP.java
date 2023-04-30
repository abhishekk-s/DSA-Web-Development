/* The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.

 

Example 1:

Input: nums = [1,2,4], k = 5 
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.

Example 2:

Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.

Example 3:

Input: nums = [3,9,6], k = 2
Output: 1

 

Constraints:

    1 <= nums.length <= 105
    1 <= nums[i] <= 105
    1 <= k <= 105
 */


//using sliding window https://www.youtube.com/watch?v=vgBrQ0NM5vE&ab_channel=NeetCode

//using BS https://www.youtube.com/watch?v=nveGJc_oYAI&ab_channel=AdityaRajiv

//https://leetcode.com/problems/frequency-of-the-most-frequent-element/solutions/2596103/most-simple-sliding-window-binary-search-detailed-explanation/?orderBy=most_votes&topicTags=binary-search


class Solution {
    public boolean possible(int[] nums, int mid, int k) {
        long windowSum = 0, totalSum = 0;
        for (int i = 0; i < mid; i++) {
            windowSum += nums[i];
        }

        totalSum = 1L* nums[mid - 1] * mid;

        if (totalSum - windowSum <= k) {
            return true;
        }

        int j = 0;
        for (int i = mid; i < nums.length; i++) {
            windowSum -= nums[j];
            windowSum += nums[i];
            totalSum = 1L* nums[i] * mid;

            if (totalSum - windowSum <= k) {
                return true;
            }
            j++;
        }

        return false;
    }

    public int maxFrequency(int[] nums, int k) {
        int l = 1, h = nums.length, ans = 0;
        Arrays.sort(nums);

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (possible(nums, mid, k)) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return ans;
    }
}


//====================================================================

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left=0,right=0,res=0;
        long sum=0;

        while(right<nums.length)
        {
            sum+=nums[right];
            while(nums[right]*(right-left+1)>sum+k)
            {
                sum-=nums[left];
                left+=1;
            }

            res=Math.max(res,right-left+1);
            right+=1;
        }

        return res;
    }
}

//need to check sliding window 