package exercise.lc.hard;

import java.util.PriorityQueue;

/**
 * @author wangtianchuan 2021/8/28
 */
public class Title295 {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1);
        System.out.println(mf.findMedian());
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());
        mf.addNum(-4);
        System.out.println(mf.findMedian());
        mf.addNum(-5);
        System.out.println(mf.findMedian());
    }

    static class MedianFinder {

        private PriorityQueue<Integer> before;
        private PriorityQueue<Integer> after;

        public MedianFinder() {
            before = new PriorityQueue<>((a, b) -> (b - a));
            after = new PriorityQueue<>();
        }

        public void addNum(int num) {
            Integer mid;
            if (before.size() == 0) {
                before.add(num);
                return;
            }
            if (before.size() == after.size()) {
                Integer bigger = after.poll();
                if (num > bigger){
                    before.offer(bigger);
                    after.offer(num);
                } else {
                    before.offer(num);
                    after.offer(bigger);
                }
                return;
            }
            mid = before.poll();
            double newMid = (mid + num) / 2.0;
            if (mid <= newMid) {
                before.offer(mid);
                after.offer(num);
            } else if (mid > newMid) {
                before.offer(num);
                after.offer(mid);
            }
        }

        public double findMedian() {
            if (before.size() == 0) {
                return 0;
            }
            if (before.size() > after.size()) {
                return before.peek();
            }
            return (before.peek() + after.peek()) / 2.0;
        }
    }
}
