package com.risensoftware.leetcode;

/*
Question:
Given an integer array nums, return an array answer such that answer[i]
is equal to the product of all the elements of nums except nums[i].
You must write an algorithm that runs in O(n) time and without using division.
*/
public class ProductOfArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    int prefix = 1;

    for (int i = 0; i < nums.length; i++) {
      result[i] = prefix;
      prefix *= nums[i];
    }

    int suffix = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      result[i] *= suffix;
      suffix *= nums[i];
    }

    return result;
  }
}
