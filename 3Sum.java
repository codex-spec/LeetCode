// 3Sum

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lis = new LinkedList<>();
        for(int i =0;i<nums.length-2;i++){
            if(i==0||(i>0 && nums[i]!=nums[i-1]))
               {
                   int lo = i+1, hi = nums.length-1, sum = 0-(nums[i]);
                   while(lo<hi){
                       if(nums[lo]+nums[hi]==sum){
                           lis.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                           
                        while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                        while(lo<hi&& nums[hi]==nums[hi-1]) hi--;
                           lo++;
                           hi--;
                       }
                       else if(nums[lo]+nums[hi]<sum) lo++;
                       else hi--;
                   }
               }
               }
            
          return lis;         
            
        
    }
}