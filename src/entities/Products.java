package entities;

public class Products {
    public Integer id;
    public String name;
    public float price;
    public Integer quantity;
    public float subtotal;
    public float total;

    public Products() {
    }

    public Products(Integer id, String name, float price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public float getSubtotal() {
        return this.quantity * price;
    }

    public float getTotal() {
        return total = total + getSubtotal();
    }

    public float setTotal(float total) {
        return this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getName();
    }
}
