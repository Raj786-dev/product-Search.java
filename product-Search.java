import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - ₹" + price;
    }
}

public class ProductSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Sample product list
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 55000));
        products.add(new Product("Phone", "Electronics", 25000));
        products.add(new Product("Shoes", "Fashion", 2000));
        products.add(new Product("T-Shirt", "Fashion", 800));
        products.add(new Product("Refrigerator", "Appliances", 30000));

        System.out.println("=== Product Search ===");
        System.out.print("Enter name keyword (or press Enter to skip): ");
        String keyword = input.nextLine().toLowerCase();

        System.out.print("Enter category (or press Enter to skip): ");
        String category = input.nextLine().toLowerCase();

        System.out.print("Enter minimum price (or 0 to skip): ");
        double minPrice = input.nextDouble();

        System.out.print("Enter maximum price (or 0 to skip): ");
        double maxPrice = input.nextDouble();

        System.out.println("\n--- Search Results ---");
        boolean found = false;

        for (Product p : products) {
            boolean matches = true;

            if (!keyword.isEmpty() && !p.name.toLowerCase().contains(keyword)) {
                matches = false;
            }
            if (!category.isEmpty() && !p.category.toLowerCase().equals(category)) {
                matches = false;
            }
            if (minPrice > 0 && p.price < minPrice) {
                matches = false;
            }
            if (maxPrice > 0 && p.price > maxPrice) {
                matches = false;
            }

            if (matches) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No products found matching the criteria.");
        }

        input.close();
    }
}
