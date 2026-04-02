package com.risensoftware.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Question:
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
you must take course bi first if you want to take course ai.
Return true if you can finish all courses. Otherwise, return false.
*/
public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] prerequisite : prerequisites) {
      graph.get(prerequisite[1]).add(prerequisite[0]);
    }

    int[] state = new int[numCourses];
    for (int course = 0; course < numCourses; course++) {
      if (hasCycle(course, graph, state)) {
        return false;
      }
    }

    return true;
  }

  private boolean hasCycle(int course, List<List<Integer>> graph, int[] state) {
    if (state[course] == 1) {
      return true;
    }
    if (state[course] == 2) {
      return false;
    }

    state[course] = 1;
    for (int next : graph.get(course)) {
      if (hasCycle(next, graph, state)) {
        return true;
      }
    }

    state[course] = 2;
    return false;
  }
}
