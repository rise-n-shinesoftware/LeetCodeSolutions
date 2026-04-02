package com.risensoftware.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Question:
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class with get and put operations in O(1) average time.
*/
public class LRUCache {
  private static class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final int capacity;
  private final Map<Integer, Node> cache;
  private final Node head;
  private final Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    Node node = cache.get(key);
    if (node == null) {
      return -1;
    }

    moveToFront(node);
    return node.value;
  }

  public void put(int key, int value) {
    Node node = cache.get(key);
    if (node != null) {
      node.value = value;
      moveToFront(node);
      return;
    }

    if (cache.size() == capacity) {
      Node lru = tail.prev;
      removeNode(lru);
      cache.remove(lru.key);
    }

    Node inserted = new Node(key, value);
    cache.put(key, inserted);
    addAfterHead(inserted);
  }

  private void moveToFront(Node node) {
    removeNode(node);
    addAfterHead(node);
  }

  private void addAfterHead(Node node) {
    node.next = head.next;
    node.prev = head;
    head.next.prev = node;
    head.next = node;
  }

  private void removeNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }
}
