import java.util.*;

public class lc295 {
    class MedianFinder {

        /**
         * initialize your data structure here.
         */
        Queue<Integer> higher;
        Queue<Integer> lower;
        double mid;
        int size;

        public MedianFinder() {
            higher = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
            lower = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
            mid = 0;
            size = 0;
        }

        public void addNum(int num) {
            size++;
            if (num > mid) {
                higher.add(num);
                if (higher.size() - lower.size() == 2)
                    lower.add(higher.poll());
            } else {
                lower.add(num);
                if (lower.size() - higher.size() == 2)
                    higher.add(lower.poll());
            }
            if (size % 2 == 1) {
                if (higher.size() > lower.size())
                    mid = higher.peek();
                else
                    mid = lower.peek();
            } else {
                if (size == 2) {
                    if (higher.size() == 0)
                        mid = (num + lower.peek()) / 2.0;
                    else if (lower.size() == 0) {
                        mid = (num + higher.peek()) / 2.0;
                    } else
                        mid = (higher.peek() + lower.peek()) / 2.0;
                } else
                    mid = (higher.peek() + lower.peek()) / 2.0;
            }
            if (higher.size() > 0)
                while (higher.peek() < mid) {
                    int temp = higher.poll();
                    lower.add(temp);
                }
            if (lower.size() > 0)
                while (lower.peek() > mid) {
                    int temp = lower.poll();
                    higher.add(temp);
                }
        }

        public double findMedian() {
            return mid;
        }
    }
}
