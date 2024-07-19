import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Item waterBottle = new Item("Water Bottle", 10, LocalDate.of(2023, 1, 1));
        Item chocolateBar = new Item("Chocolate Bar", 15, LocalDate.of(2023, 2, 1));
        Item notebook = new Item("Notebook", 5, LocalDate.of(2023, 3, 1));
        Item pen = new Item("Pen", 20, LocalDate.of(2023, 4, 1));
        Item tissuePack = new Item("Tissue Pack", 30, LocalDate.of(2023, 5, 1));
        Item chipsBag = new Item("Chips Bag", 25, LocalDate.of(2023, 6, 1));
        Item sodaCan = new Item("Soda Can", 8, LocalDate.of(2023, 7, 1));
        Item soap = new Item("Soap", 12, LocalDate.of(2023, 8, 1));
        Item shampoo = new Item("Shampoo", 40, LocalDate.of(2023, 9, 1));
        Item toothbrush = new Item("Toothbrush", 50, LocalDate.of(2023, 10, 1));
        Item coffee = new Item("Coffee", 20);
        Item sandwich = new Item("Sandwich", 15);
        Item batteries = new Item("Batteries", 10);
        Item umbrella = new Item("Umbrella", 5);
        Item umbrella2 = new Item("Umbrella", 1);
        Item sunscreen = new Item("Sunscreen", 8);

        System.out.println("===============================================\n");
        Store store = new Store(100);
        store.addItem(waterBottle);
        store.addItem(notebook);
        store.addItem(pen);
        store.addItem(tissuePack);
        store.addItem(sandwich);
        store.addItem(umbrella);
        store.addItem(umbrella2);
        System.out.println("===============================================");
        System.out.println("===============================================\n");
        System.out.println("Item list: " + store.getItemsList());
        System.out.println("Item map: " + store.getItemsMap());
        System.out.println("getItemQuantities: " + store.getItemQuantities());
        System.out.println("getUniqueItemNames: " + store.getUniqueItemNames());
        System.out.println("Total items in store: " + store.getCurrentVolume());
        store.findItemByName("Pen").ifPresent(item -> System.out.println("findItemByName: " +item));
        store.findItemByName("Pencil").ifPresent(item -> System.out.println("findItemByName: " +item));
        Optional<Item> foundItem = store.findItemByName("Banana");
        if (foundItem.isPresent()) {
            System.out.println("Found item: " + foundItem.get().getName());
        } else {
            System.out.println("Item 'Banana' not found.");
        }

        System.out.println("===============================================");
        System.out.println("================= Level 2 tests ==============================\n");

        // try to overload the store capacity
        store.addItem(coffee);
        System.out.println("Total items in store: " + store.getCurrentVolume());
        System.out.println("===============================================\n");

        store.trackItemHistory();
        System.out.println("===============================================\n");
        store.removeItem(umbrella);
        store.addItem(umbrella2);
        System.out.println("getItemQuantities: " + store.getItemQuantities());
        store.trackItemHistory();
        System.out.println("==================== Level 3 tests ===========================\n");
        // filter items by quantity from 10 to 20
        System.out.println(store.filterItemsByQuantity(10,20));;
        // Sort items by name
        System.out.println(store.sortItemsByName());;
        // Sort items by date created
        System.out.println(store.sortItemsByDate(true));;
        System.out.println(store.sortItemsByDate(false));;
        // filter items by date created after 1 Apr 2023
        System.out.println(store.getItemsCreatedAfter(LocalDate.of(2023, 4, 1)));;
        //count items by their name
        Item umbrella_red = new Item("Umbrella Red", 5);
        store.addItem(umbrella_red);
        System.out.println(store.countItemsByName("Umbrella"));;
        // sum of quantities of all items in the store
        System.out.println("Total sum of Items quantity in store: " + store.getTotalQuantity());    }
}