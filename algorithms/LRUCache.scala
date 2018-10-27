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

import java.util
import java.util.Map.Entry
import collection.mutable.HashMap

//Solution #1 (short, but hacky)
class LRUCache(_capacity: Int) {
  val cache = new util.LinkedHashMap[Int, Int](_capacity, 1, true) {
    override def removeEldestEntry(eldest: Entry[Int, Int]): Boolean =  {
      return size() > _capacity
    }
  }

  def get(key: Int): Int = {
    cache.getOrDefault(key, -1)
  }

  def put(key: Int, value: Int) {
    cache.put(key, value)
  }
}

//Solution #2 (fair implementation)
class FairLRUCache(capacity: Int) {
  private val map = HashMap.empty[Int, Node]
  private var head: Node = _
  private var last: Node = _

  def get(key: Int): Int = {
    val nodeOpt = map.get(key)
    if (nodeOpt.isEmpty) {
      -1
    } else {
      val node = nodeOpt.get
      if (node ne head) {
        val prev = node.prev
        val next = node.next
        prev.next = next
        if (node eq last) last = prev
        else next.prev = prev
        node.prev = null
        node.next = head
        head.prev = node
        head = node
      }
      head.value
    }
  }

  def put(key: Int, value: Int): Unit = {
    if (map.contains(key)) {
      get(key)
      head.value = value
    } else if (capacity > 0) {
      val node = Node(key, value)
      if (map.isEmpty) {
        head = node
        last = node
      } else {
        node.next = head
        head.prev = node
        head = node
      }
      map += key -> node
      if (map.size > capacity) {
        map.remove(last.key)
        last = last.prev
        last.next.prev = null
        last.next = null
      }
    }
  }

  private case class Node private(key: Int, var value: Int) {
    var prev: Node = null
    var next: Node = null
  }

}