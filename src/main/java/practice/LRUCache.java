package practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {

        if (map.get(key) == null)
            return -1;
        Node node = map.get(key);
        removeNode(node);
        offerNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.get(key)!=null) {
            Node t = map.get(key);
            t.val = value;// update value
            removeNode(t);
            offerNode(t);
        }
        else {
            if (map.size()>=capacity) {
                map.remove(head.key);
                removeNode(head);
            }
            Node node = new Node(key, value);
            offerNode(node);
            map.put(key, node);
        }
    }

    private void removeNode(Node node) {
        if (node.prev !=null) {
            node.prev.next = node.next;
        }
        else head = node.next;

        if (node.next!=null) {
            node.next.prev = node.prev;
        }
        else tail = node.prev;
    }
    private void offerNode(Node node) {
        if (tail != null) {
            tail.next = node;
        }
        node.prev = tail;
        node.next = null;
        tail = node;

        if (head == null)
            head = node;
    }

    static class Node {
        Node prev;
        Node next;
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(3);
        obj.put(1,1);
        obj.put(2,2);
        obj.put(3,3);
        System.out.println(obj.get(1));
        obj.put(4,4);
        System.out.println(obj.get(2));
    }
}