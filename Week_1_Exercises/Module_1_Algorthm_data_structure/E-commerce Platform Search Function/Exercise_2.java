import java.util.Arrays;
import java.util.Comparator;

public class Exercise_2 {

    // Product class with attributes and methods
    public static class Product {
        private int productId;
        private String productName;
        private String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category + "]";
        }
    }

    // Linear Search
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null; // Not found
    }

    // Binary Search (requires sorted array)
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == targetId) {
                return products[mid];
            } else if (products[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Not found
    }

    // Sort products by productId
    public static void sortProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
    }

    public static void main(String[] args) {
        // Example products
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(203, "Smartphone", "Electronics"),
            new Product(305, "Coffee Maker", "Appliances")
        };

        // Linear Search Example
        Product searchResultLinear = linearSearch(products, 203);
        System.out.println("Linear Search Result: " + (searchResultLinear != null ? searchResultLinear : "Not Found"));

        // Sorting the products by productId for Binary Search
        sortProducts(products);

        // Binary Search Example
        Product searchResultBinary = binarySearch(products, 203);
        System.out.println("Binary Search Result: " + (searchResultBinary != null ? searchResultBinary : "Not Found"));
    }
}








