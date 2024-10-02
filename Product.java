class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}

// Custom exception for invalid quantity
class Product extends Throwable {
    private String productId;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    public String getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class PerishableProduct extends Product {
    private String expirationDate;
    public PerishableProduct(String productId, String productName, int quantity, double price, String expirationDate) {
        super(productId, productName, quantity, price);
        this.expirationDate = expirationDate;
    }
    public int updateStock (int amount) throws InsufficientStockException{
        int newQuantity = getQuantity() + amount;
        if (amount < 0)
            throw new InsufficientStockException("Quantity cannot be negative.\n");
        else if (amount > newQuantity)
            throw new InsufficientStockException("Insufficient stock for product apple.\n");
        else if (newQuantity > 100) {
            throw new InsufficientStockException("Cannot exceed maximum quantity of 100 for perishable products.\n");
        }
        setQuantity(newQuantity);
        return getQuantity();
    }
}

class NonPerishableProduct extends Product {
    private String shelfLife;
    public NonPerishableProduct(String productId, String productName,int quantity, double price, String shelfLife) {
        super(productId, productName, quantity, price);
    }
    public int updateStock (int amount) {
        return getQuantity() + amount;
    }
}
