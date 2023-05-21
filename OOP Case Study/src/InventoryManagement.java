import java.util.*;
import java.util.HashMap;

class Inventory {
    HashMap<String, Integer> items = new HashMap<String, Integer>();
}
// adding item
public void AddItem(String item, int quantity){
    items.put(item, quantity);
    System.out.println(item + "with a number of" quantity + "has been added.");
}
// removing item
public void DeleteItem(String item, int quantity){
    items.remove(item, quantity);
    System.out.println(item + "with a number of" quantity + "has been remove.")
}

public class InventoryManagement {
    public static void main(String[] args) {

    }
}