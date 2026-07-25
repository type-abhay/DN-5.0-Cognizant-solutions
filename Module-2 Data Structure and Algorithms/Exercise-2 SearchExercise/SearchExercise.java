import java.util.Arrays;

// Step 2: Define Product class
class Product implements Comparable<Product> {
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
        return "Product{ID=" + productId + ", Name='" + productName + "', Category='" + category + "'}";
    }

    // Required to keep array sorted for binary search
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }
}

public class SearchExercise {

    // Step 3: Linear Search Algorithm
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product; // Found
            }
        }
        return null; // Not found
    }

    // Step 3: Binary Search Algorithm (Requires sorted array)
    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedProducts[mid].getProductId() == targetId) {
                return sortedProducts[mid]; // Found
            } else if (sortedProducts[mid].getProductId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        System.out.println("=== EXERCISE 2: E-COMMERCE SEARCH FUNCTION ===\n");

        // Sample Data
        Product[] products = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(108, "Running Shoes", "Apparel"),
            new Product(102, "Coffee Mug", "Home"),
            new Product(104, "Gaming Headset", "Electronics")
        };

        int targetId = 108;

        // --- Linear Search ---
        System.out.println("1. Linear Search Execution:");
        Product resultLinear = linearSearch(products, targetId);
        System.out.println("Found: " + resultLinear);

        // --- Binary Search ---
        System.out.println("\n2. Binary Search Execution:");
        // Copy array and sort it first for binary search
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts);

        Product resultBinary = binarySearch(sortedProducts, targetId);
        System.out.println("Found: " + resultBinary);

        // Step 1 & Step 4: Output Analysis Summary
        printAnalysis();
    }

    private static void printAnalysis() {
        System.out.println("\n--- Theoretical Analysis ---");
        System.out.println("Linear Search Complexity:");
        System.out.println(" - Best Case: O(1) [Item is at the first index]");
        System.out.println(" - Worst / Average Case: O(n) [Must scan through array]");
        
        System.out.println("\nBinary Search Complexity:");
        System.out.println(" - Best Case: O(1) [Item is at middle]");
        System.out.println(" - Worst / Average Case: O(log n) [Divides search space in half each step]");

        System.out.println("\nPlatform Recommendation:");
        System.out.println(" - Binary search is significantly better for large e-commerce platforms with thousands or millions of products.");
        System.out.println(" - Tradeoff: Array must remain sorted. If product updates/inserts are frequent, balanced trees or search engines (e.g., Elasticsearch) are preferred.");
    }
}