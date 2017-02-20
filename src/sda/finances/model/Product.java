package sda.finances.model;


public class Product {

    private String name;
    private double unitPrice;
    private int amount;

    public Product(String type, double unitPrice, int amount) {
        this.name = type;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", amount=" + amount +
                '}';
    }
}


