# Inventory Management

In this assignment, you will create a simple inventory management system which allows users to add, remove,
and view items in the inventory.

## Requirements

## Level 1

- Create class `Item`, which has at least name (readonly), quantity, and created date, which are private.
- Amount of each item cannot be negative.
- Constructor to take parameters of the needed fields, however, created date (optional, if not set, it will be current date).

2. Create class `Store` with the following properties and methods:
- A collection to store items, which is private. Initially, this will be an empty collection.
- Implement a method getItemsList that returns a list of all items in the store.
- Implement a method getItemsMap that returns a map where keys are item names and values are item objects.
- Write a function getItemQuantities that returns a map where keys are item names and values are quantities.
- Implement a method getUniqueItemNames that returns a set of all unique item names in the store.
- Methods to add/delete one item to the collection. Do not allow adding items with the same name to the store.
- Method `getCurrentVolume` to compute the total amount of items in the store.
- Method `findItemByName` to find an item by name.

```java
// items example - You do not need to follow exactly the same
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
Item sunscreen = new Item("Sunscreen", 8);
```

## Level 2

Class `Store` should have these additional features:

- Maximum capacity, which is the total amount of items allowed in the store, and the constructor should also take
an integer value as the maximum capacity of the inventory.
  - Modify the add method to not overload the capacity.
- Implement a method trackItemHistory that uses a stack to keep track of changes made to an item’s quantity over time.
Each change (addition or subtraction) is pushed onto the stack.

## Level 3

- **Filter Items by Quantity:**
  - Implement a method `filterItemsByQuantity` that takes a minimum and maximum quantity as parameters and returns a list of items whose quantity falls within the specified range.
  ```java
  public List<Item> filterItemsByQuantity(int minQuantity, int maxQuantity);
  ```

- **Sort Items by Name:**
  - Implement a method `sortItemsByName` that returns a list of all items sorted by their names in alphabetical order.
  ```java
  public List<Item> sortItemsByName();
  ```

- **Sort Items by Creation Date:**
  - Implement a method `sortItemsByDate` that returns a list of all items sorted by their creation date, either ascending or descending based on a parameter.
  ```java
  public List<Item> sortItemsByDate(boolean ascending);
  ```

- **Get Items Created After Date:**
  - Implement a method `getItemsCreatedAfter` that takes a `LocalDate` parameter and returns a list of items created after the specified date.
  ```java
  public List<Item> getItemsCreatedAfter(LocalDate date);
  ```

- **Count Items by Name:**
  - Implement a method `countItemsByName` that returns a map where keys are item names and values are the number of items with that name in the store.
  ```java
  public Map<String, Long> countItemsByName(String name);
  ```

- **Get Total Quantity of Items:**
  - Implement a method `getTotalQuantity` that returns the sum of quantities of all items in the store.
  ```java
  public int getTotalQuantity();
  ```

- **Find Item Names Containing String:**
  - Implement a method `findItemNamesContaining` that takes a string parameter and returns a list of item names that contain the specified string.
  ```java
  public List<String> findItemNamesContaining(String searchString);
  ```

- **Group Items by Quantity Range:**
  - Implement a method `groupItemsByQuantityRange` that groups items into ranges of quantities (e.g., 1-10, 11-20, etc.) and returns a map where keys are the ranges and values are lists of items within those ranges.
  ```java
  public Map<String, List<Item>> groupItemsByQuantityRange();
  ```

- **Average Quantity of Items:**
  - Implement a method `getAverageQuantity` that returns the average quantity of all items in the store.
  ```java
  public double getAverageQuantity();
  ```
  
- **Track Most Frequent Modifications:**
  - Implement a method `getMostFrequentModifications` that returns a list of items that have had the most modifications to their quantities. Use the history stack to track the frequency of changes and return the top number most frequently modified items.
  ```java
  // n could be 3 -> top 3 ranking.
  public List<Item> getMostFrequentModifications(int n);
  ```


## Level 4
- **Work with File System**
  - Implement two methods:
    - Write method: this method should write / update a file based on a data source.
    - Read method: this method should read from a file and load it to a variable.
      This would act like a DB if there are data in your file then load them, otherwise have initial values.
  - Make sure you have a good folder structure where you split
    - File I/O methods(the functions that talks to a datasource). Could be one class.
    - Datasource (your files)