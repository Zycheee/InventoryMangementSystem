import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<PerishableProduct> products = new ArrayList <PerishableProduct>();
        PerishableProduct apple = new PerishableProduct("P001", "Apple", 50, 0.5, "2024-12-31");
        NonPerishableProduct rice = new NonPerishableProduct("NP001", "Rice", 12, 0.1, "2025-12-31");
        Inventory inventory = new Inventory();

        try {
            inventory.addProduct(apple);
            System.out.println("Stock Updated: " + apple.getProductName() + " new quantity " + apple.updateStock(30));
            System.out.println("Stock Updated: " + apple.getProductName() + " new quantity " + apple.updateStock(30));
        } catch (Exception e) {System.out.print(e.getMessage());}
        products.add(apple);

        inventory.removeProduct("P001");
        inventory.displayProducts();

    }
}