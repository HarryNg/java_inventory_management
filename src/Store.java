import java.util.*;

public class Store {
    // A collection to store items, which is private. Initially, this will be an empty collection.
    private List<Item> items = new ArrayList<>();

    public Store(){}

    //Methods to add/delete one item to the collection. Do not allow adding items with the same name to the store.
    public void addItem(Item item){
        if(!itemNameMatch(item.getName())) {
            items.add(item);
        }else {
            System.out.println("Cannot add item with the same name " + item.getName());
        }
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public boolean itemNameMatch(String itemName){
        return items.stream().anyMatch(item -> item.getName().equalsIgnoreCase(itemName));
    }

    //Implement a method getItemsList that returns a list of all items in the store.
    public List<Item> getItemsList(){
        return new ArrayList<>(items);
    }

    //Implement a method getItemsMap that returns a map where keys are item names and values are item objects.
    public Map<String,Item> getItemsMap(){
        Map<String,Item> result = new HashMap<>();
        for(Item item : items){
            result.put(item.getName(),item);
        }
        return result;
    }
    //Write a function getItemQuantities that returns a map where keys are item names and values are quantities.
    public Map<String, Integer> getItemQuantities(){
        Map<String,Integer> result = new HashMap<>();
        for(Item item : items){
            result.put(item.getName(),item.getQuantity());
        }
        return result;
    }
    //Implement a method getUniqueItemNames that returns a set of all unique item names in the store.
    public Set<String> getUniqueItemNames(){
        Set<String> result = new HashSet<>();
        for(Item item : items){
            result.add(item.getName());
        }
        return result;
    }

    //Method getCurrentVolume to compute the total amount of items in the store.
    public int getCurrentVolume(){
        int total = 0;
        for(Item item : items){
            total = total + item.getQuantity();
        }
        return total;
    }
    //Method findItemByName to find an item by name.
    public Item findItemByName(String itemName){
        for(Item current : items){
            if(current.getName().equalsIgnoreCase(itemName)){
                return current;
            }
        }
        return null;
    }
}
