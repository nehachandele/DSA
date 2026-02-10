import java.util.*;

class Item {
    int value, weight;
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class Solution {
    double fractionalKnapsack(int W, Item[] items, int n) {

        Arrays.sort(items, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1); // descending order
        });

        double totalValue = 0.0;

        for (Item item : items) {
            if (W == 0) break;

            if (item.weight <= W) {
                totalValue += item.value;
                W -= item.weight;
            } else {
                totalValue += ((double) item.value / item.weight) * W;
                W = 0;
            }
        }
        return totalValue;
    }
}
