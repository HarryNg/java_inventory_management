import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ItemHistory {
    private final Map<String, Stack<Integer>> itemHistory;

    public ItemHistory() {
        itemHistory = new HashMap<>();
    }

    public void trackItemHistory(Item item, int change) {
        if (item != null) {
            Stack<Integer> quantityHistory = itemHistory.getOrDefault(item.getName(), new Stack<>());
            quantityHistory.push(change);
            itemHistory.put(item.getName(), quantityHistory);
        }
    }

    public void retrieveHistory() {
        for (Map.Entry<String, Stack<Integer>> entry : itemHistory.entrySet()) {
            System.out.println("Item: " + entry.getKey() + " History: " + entry.getValue());
        }
    }

    public int getModificationCount(String itemName) {
        return itemHistory.containsKey(itemName) ? itemHistory.get(itemName).size() : 0;
    }
}
