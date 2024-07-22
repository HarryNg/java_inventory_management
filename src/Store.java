import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Store {
    // A collection to store items, which is private. Initially, this will be an empty collection.
    private List<Item> items = new ArrayList<>();
    private final int maxCapacity;
    private ItemHistory history;

    public Store(int max){
        this.maxCapacity = max;
        this.history = new ItemHistory();
    }

    //Methods to add/delete one item to the collection. Do not allow adding items with the same name to the store.
    public void addItem(Item item){
        if(getTotalQuantity()+item.getQuantity() >= maxCapacity){
            System.out.println("Store capacity is full. Cannot add more item. " + item.getQuantity() + " : " + item.getName());
        }
        else if(!itemNameMatch(item.getName())) {
            items.add(item);
            history.trackItemHistory(item, item.getQuantity());
        }else {
            System.out.println("Cannot add item with the same name " + item.getName());
        }
    }

    public void removeItem(Item item){
        if (items.remove(item)) {
            history.trackItemHistory(item, -item.getQuantity());
        }
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
        return items.size();
    }
    //Method findItemByName to find an item by name.
    public Optional<Item> findItemByName(String itemName){
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst();
    }

    public void trackItemHistory(){
        history.retrieveHistory();
    }

    public List<Item> filterItemsByQuantity(int minQuantity, int maxQuantity){
        return items.stream().filter(item -> item.getQuantity() <=maxQuantity && item.getQuantity() >=minQuantity).toList();
    }
    public List<Item> sortItemsByName(){
        return items.stream().sorted(Comparator.comparing(Item::getName)).toList();
    }
    public List<Item> sortItemsByDate(boolean ascending){
        return items.stream()
                .sorted(ascending ? Comparator.comparing(Item::getCreated_date)
                        : Comparator.comparing(Item::getCreated_date).reversed())
                .toList();
    }
    public List<Item> getItemsCreatedAfter(LocalDate date){
        return items.stream()
                .filter(item -> item.getCreated_date().isAfter(date))
                .toList();
    }
    public Map<String, Long> countItemsByName(String name){
        return items.stream()
                .filter(item -> item.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.groupingBy(Item::getName,Collectors.summingLong(Item::getQuantity)));
    }
    public int getTotalQuantity(){
        return items.stream().mapToInt(Item::getQuantity).sum();
    }
    public List<String> findItemNamesContaining(String searchString){
        return items.stream()
                .map(Item::getName)
                .filter(item -> item.toLowerCase().contains(searchString.toLowerCase()))
                .toList();
    }
    public Map<String, List<Item>> groupItemsByQuantityRange(){
        final int rangeSize = 10;
        Map<String, List<Item>> groupedItems = new HashMap<>();
        for (Item item : items) {
            int quantity = item.getQuantity();
            int lowerBound = (quantity / rangeSize) * rangeSize + 1;
            int upperBound = lowerBound + rangeSize - 1;
            String rangeKey = lowerBound + "-" + upperBound;
            groupedItems.computeIfAbsent(rangeKey, k -> new ArrayList<>()).add(item);
        }
        return groupedItems;
    }
}
