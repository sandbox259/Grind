package Stock;

import java.time.LocalDateTime;
import java.util.*;

class Order {
    enum Side {
        BUY,SELL
    }

    private static int orderIdCounter = 0;;
    private int orderId;
    private double price;
    private int quantity;
    private LocalDateTime timestamp;
    private Side side;
    
        public Order( Side side , double price , int quantity){
            this.orderId = ++orderIdCounter;
            this.side = side;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = LocalDateTime.now();
    }

    public int getOrderId(){
        return orderId;
    }

    public Side getSide(){
        return side;
    
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("OrderID: %d, Side: %s, Price: %.2f, Quantity: %d, Timestamp: %s",
                orderId, side, price, quantity, timestamp);
    }
}

class MatchingEngine {

    
}











public class StockSystem {

    public static void main (String[] args) {

    }
    
}
