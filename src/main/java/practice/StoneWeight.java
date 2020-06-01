package practice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class StoneWeight {
    public static void main(String[] args) {
        calculateMinWeight(new int[]{2,7,4,1,8,1});
    }

    private static void calculateMinWeight(int[] arr) {
        // creating max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)->n2-n1);
        Arrays.stream(arr).forEach(heap::add);
        int n = arr.length;
        int num1,num2;
        while(n>1) {
            num1 = heap.poll();
            num2 = heap.poll();
            heap.offer(num1 - num2);
            n--;
        }
        System.out.println(heap.peek());
    }
}
