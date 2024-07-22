package store;

import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable {

    // name (readonly), quantity, and created date
    private final String name;
    private int quantity;
    private LocalDate created_date;

    public Item(String name, int quantity, LocalDate created_date){
        this.name = name;
        this.quantity = quantity;
        this.created_date = created_date;
    }
    public Item(String name, int quantity){
        this(name, quantity, LocalDate.now());
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
        if(quantity<0){
            System.out.println("Quantity cannot be negative.");
        }else{
            this.quantity = quantity;
        }
    }


    @Override
    public String toString(){
        return "{"+
                "name='" + name + "\'"+
                ", quantity=" + quantity +
                ", created_date=" +created_date + "}";
    }
}
