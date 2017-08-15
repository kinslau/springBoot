package com.kinslau.Test.loader;

/**
 * Created by 刘 辉 on 2017/8/14.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {

        for(int i =0;i<nums.length-1;i++){
          for (int j = i+1;j<nums.length;j++){
              if ((nums[i]+nums[j]) == target){
                return new int[]{i,j};
              }
          }
        }
        return null;
    }




}
