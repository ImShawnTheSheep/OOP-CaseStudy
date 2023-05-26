import java.util.HashMap;
import java.util.Map;

/* class for Inventory */
class Inventory {
    // Initializations
    private Map<String, Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    // adding item, also check if item exists or not
    public void addItem(String item, int quantity) {
        if (items.containsKey(item)) {
            int current_quantity = items.get(item);
            items.put(item, current_quantity + quantity);
        }
        if (!items.containsKey(item))
            items.put(item, quantity);
    }

    // removing item
    public void removeItem(String item) {
        items.remove(item);
    }

    // check if item exist
    public boolean containsItem(String itemName) {
        return items.containsKey(itemName);
    }

    // get items
    public Map<String, Integer> getItems() {
        return items;
    }

    // get quantity
    public int getQuantity(String item) {
        return items.getOrDefault(item, 0);
    }
}