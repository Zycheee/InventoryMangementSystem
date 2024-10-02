import java.util.*;
class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}
abstract class InventoryOperation {
    public abstract void addProduct(Product product);
    public abstract void removeProduct(String productId);
}

class Inventory  extends InventoryOperation {
    ArrayList<Product> products = new ArrayList<Product>();
    public void addProduct(Product product) {
        System.out.println("Product added: "+ product.getProductName() +" with quantity "+product.getQuantity());
        products.add(product);
    }
    public void removeProduct(String productId) {
        if (products.contains(productId)) {
            System.out.println("Product removed: " + productId);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }
    public void displayProducts() {
        for (Product displayProduct : products) {
            System.out.println(displayProduct.getProductName()+"\n"+displayProduct.getProductId()+"\n"+displayProduct.getQuantity()+"\n"+displayProduct.getPrice());
        }
    }
}
