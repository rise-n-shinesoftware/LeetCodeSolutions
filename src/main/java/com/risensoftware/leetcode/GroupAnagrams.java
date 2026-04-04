package com.risensoftware.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Question:
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.
*/
public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> groups = new HashMap<>();

    for (String word : strs) {
      int[] counts = new int[26];
      for (int i = 0; i < word.length(); i++) {
        counts[word.charAt(i) - 'a']++;
      }

      StringBuilder keyBuilder = new StringBuilder();
      for (int count : counts) {
        keyBuilder.append('#').append(count);
      }

      String key = keyBuilder.toString();
      groups.computeIfAbsent(key, ignored -> new ArrayList<>()).add(word);
    }

    return new ArrayList<>(groups.values());
  }
}
