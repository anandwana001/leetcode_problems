/*
https://leetcode.com/problems/lru-cache/description/

Problem:

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

        LRUCache cache = new LRUCache( 2 ); //capacity = 2

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

//Solution #1 (short, but hacky)
class LRUCache {
    private final Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 1, true) {
            @Override
            protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}

//Solution #2 (fair implementation)
class FairLRUCache {
    private final int capacity;
    private final Map<Integer, Node> map;
    private Node last;
    private Node head;

    public FairLRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = null;
        this.last = null;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        if (node != head) {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;

            if (node == last) {
                last = prev;
            } else {
                next.prev = prev;
            }

            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }

        return head.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (map.containsKey(key)) {
            get(key);
            head.value = value;
            return;
        }

        Node node = new Node(key, value);

        if (map.isEmpty()) {
            head = node;
            last = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        map.put(key, node);

        if(map.size() > capacity) {
            map.remove(last.key);
            last = last.prev;
            last.next.prev = null;
            last.next = null;
        }
    }

    private class Node {
        private int key;
        private int value;
        private Node prev = null;
        private Node next = null;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}