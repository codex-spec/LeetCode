/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
//Find the median of two sorted arrays 
//Given two sorted arrays nums1 and nums2 of size m and n respectively, 
//return the median of the two sorted arrays.
//The overall run time complexity should be O(log (m+n)).

var findMedianSortedArrays = function(nums1, nums2) {
    var res = []; 
    for(var i = 0; i < nums1.length; i++) {
        res.push(nums1[i]);
    }
    
    for(var j = 0; j < nums2.length; j++) {
        res.push(nums2[j]);
    }
    
    res = res.sort(function (a, b) { return a - b; });
    
    if (res.length % 2 === 0) {
        var ind = Math.floor((res.length -1) / 2);
       return (res[ind] + res[ind+1]) / 2;
    }
    else {
       
       var h = Math.floor(res.length/2);
       return fv = res[h];
    }
             
      
    
}