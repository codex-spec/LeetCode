//Container With Most Water

/*
*
*You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
*
*Find two lines that together with the x-axis form a container, such that the container contains the most water.
*
*Return the maximum amount of water a container can store.
*
*Notice that you may not slant the container.
*/

class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, max = 0;
        while(l < r){
            int w = r - l;
            int h = Math.min(height[l], height[r]);
            int area = h * w;
            max = Math.max(max, area);
            if(height[l] < height[r]) l++;
            else if(height[l] > height[r]) r--;
            else {
                l++;
                r--;
            }
        }
        return max;
    }
}

 
