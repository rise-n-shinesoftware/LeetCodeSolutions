package com.risensoftware.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Question:
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.
*/
public class TopKFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequency = new HashMap<>();
    for (int num : nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }

    List<List<Integer>> buckets = new ArrayList<>(nums.length + 1);
    for (int i = 0; i <= nums.length; i++) {
      buckets.add(new ArrayList<>());
    }

    for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
      buckets.get(entry.getValue()).add(entry.getKey());
    }

    int[] result = new int[k];
    int index = 0;
    for (int count = buckets.size() - 1; count >= 0 && index < k; count--) {
      for (int num : buckets.get(count)) {
        result[index++] = num;
        if (index == k) {
          break;
        }
      }
    }

    return result;
  }
}
