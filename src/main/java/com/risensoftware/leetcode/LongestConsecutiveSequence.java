package com.risensoftware.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Question:
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
*/
public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    Set<Integer> values = new HashSet<>();
    for (int num : nums) {
      values.add(num);
    }

    int best = 0;
    for (int num : values) {
      if (values.contains(num - 1)) {
        continue;
      }

      int current = num;
      int length = 1;
      while (values.contains(current + 1)) {
        current++;
        length++;
      }

      best = Math.max(best, length);
    }

    return best;
  }
}
