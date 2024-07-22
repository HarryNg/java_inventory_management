package database;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import store.Item;

public class FileIO {
    private final String filePath;

    public FileIO(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(List<Item> items) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(items);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Item> readFromFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found, returning an empty list.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Item>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


}
