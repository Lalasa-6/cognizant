import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "Product ID: " + productId
            + ", Name: " + productName
            + ", Category: " + category;
    }
}

public class EcommerceSearch {

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);
            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] linearArray = {
            new Product(201, "Shoes", "Footwear"),
            new Product(202, "Laptop", "Electronics"),
            new Product(203, "T-shirt", "Clothing"),
            new Product(204, "Watch", "Accessories"),
            new Product(205, "Headphones", "Electronics")
        };

        Product[] binaryArray = {
            new Product(301, "Shoes", "Footwear"),
            new Product(302, "Laptop", "Electronics"),
            new Product(303, "T-shirt", "Clothing"),
            new Product(304, "Watch", "Accessories"),
            new Product(305, "Headphones", "Electronics")
        };

        Arrays.sort(binaryArray, Comparator.comparing(p ->
            p.productName.toLowerCase()));

        System.out.println("=== Linear Search ===");
        for (Product p : linearArray) System.out.println(p);
        System.out.println("\nSearching for 'Laptop' (linear)...");
        Product foundL = linearSearch(linearArray, "Laptop");
        System.out.println(foundL != null ? "Found: " + foundL
                                          : "Not found.");

        System.out.println("\n=== Binary Search ===");
        for (Product p : binaryArray) System.out.println(p);
        System.out.println("\nSearching for 'Laptop' (binary)...");
        Product foundB = binarySearch(binaryArray, "Laptop");
        System.out.println(foundB != null ? "Found: " + foundB
                                          : "Not found.");
    }
}
