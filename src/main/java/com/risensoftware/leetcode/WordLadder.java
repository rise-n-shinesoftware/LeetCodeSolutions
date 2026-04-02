package com.risensoftware.leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
Question:
A transformation sequence from beginWord to endWord using a dictionary wordList is a sequence of words
such that only one letter differs between adjacent words and every transformed word exists in wordList.
Return the number of words in the shortest transformation sequence, or 0 if no such sequence exists.
*/
public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> remaining = new HashSet<>(wordList);
    if (!remaining.contains(endWord)) {
      return 0;
    }

    Queue<String> queue = new ArrayDeque<>();
    queue.offer(beginWord);
    int steps = 1;

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        String current = queue.poll();
        if (current.equals(endWord)) {
          return steps;
        }

        char[] chars = current.toCharArray();
        for (int pos = 0; pos < chars.length; pos++) {
          char original = chars[pos];
          for (char next = 'a'; next <= 'z'; next++) {
            if (next == original) {
              continue;
            }
            chars[pos] = next;
            String candidate = new String(chars);
            if (remaining.remove(candidate)) {
              queue.offer(candidate);
            }
          }
          chars[pos] = original;
        }
      }
      steps++;
    }

    return 0;
  }
}
