import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static class Item{
        // name (readonly), quantity, and created date
        private final String name;
        private int quantity;
        private LocalDate created_date;

        public Item(String name, int quantity, LocalDate created_date){
            this.name = name;
            this.quantity = normalizeQuantity(quantity);
            this.created_date = created_date;
        }
        public Item(String name, int quantity){
            this.name = name;
            this.quantity = normalizeQuantity(quantity);
            this.created_date = LocalDate.now();
        }

        public String getName() {
            return name;
        }

        public LocalDate getCreated_date() {
            return created_date;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setCreated_date(LocalDate created_date) {
            this.created_date = created_date;
        }

        public void setQuantity(int quantity) {
            if(quantity < 0){
                throw new IllegalArgumentException("Quantity cannot be negative");
            }
            this.quantity = quantity;
        }

        public int normalizeQuantity(int quantity){
            return (quantity < 0 ? -quantity : quantity);
        }
    }
    public static void main(String[] args) {
        Item item1 = new Item("car",20);
        System.out.println(item1.getQuantity());
        item1.setQuantity(-10);
        System.out.println(item1.getQuantity());
    }
}