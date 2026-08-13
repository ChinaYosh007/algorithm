import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode2462 {

    public long totalCost(int[] costs, int k, int candidates) {
        Comparator<Pair> comparator = this::compare;
        PriorityQueue<Pair> left = new PriorityQueue<>(comparator);
        PriorityQueue<Pair> right = new PriorityQueue<>(comparator);

        int n = costs.length;
        int l = 0;
        int r = n - 1;

        for (int i = 0; i < candidates && l <= r; i++) {
            left.offer(new Pair(costs[l], l));
            l++;
        }

        for (int i = 0; i < candidates && l <= r; i++) {
            right.offer(new Pair(costs[r], r));
            r--;
        }

        long cost = 0;

        for (int i = 0; i < k; i++) {
            boolean chooseLeft = shouldChooseLeft(left, right);

            if (chooseLeft) {
                Pair cur = left.poll();
                cost += cur.value1;

                if (l <= r) {
                    left.offer(new Pair(costs[l], l));
                    l++;
                }
            } else {
                Pair cur = right.poll();
                cost += cur.value1;

                if (l <= r) {
                    right.offer(new Pair(costs[r], r));
                    r--;
                }
            }
        }

        return cost;
    }

    private boolean shouldChooseLeft(PriorityQueue<Pair> left, PriorityQueue<Pair> right) {
        if (right.isEmpty()) {
            return true;
        }

        if (left.isEmpty()) {
            return false;
        }

        return compare(left.peek(), right.peek()) <= 0;
    }

    private int compare(Pair a, Pair b) {
        if (a.value1 != b.value1) {
            return Integer.compare(a.value1, b.value1);
        }
        return Integer.compare(a.value2, b.value2);
    }

    private static class Pair {
        int value1; // cost
        int value2; // index

        Pair(int value1, int value2) {
            this.value1 = value1;
            this.value2 = value2;
        }
    }
}