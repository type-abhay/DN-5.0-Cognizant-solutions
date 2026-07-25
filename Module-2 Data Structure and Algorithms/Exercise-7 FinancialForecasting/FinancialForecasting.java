public class FinancialForecasting {

    // Step 2 & 3: Recursive method to calculate Future Value
    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int periods) {
        // Base case: 0 periods remaining
        if (periods <= 0) {
            return presentValue;
        }
        // Recursive case
        return calculateFutureValueRecursive(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    // Step 4: Optimized Iterative / Memoized approach to demonstrate efficiency
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        System.out.println("=== EXERCISE 7: FINANCIAL FORECASTING ===\n");

        double initialInvestment = 1000.00; // $1,000 initial
        double annualGrowthRate = 0.07;      // 7% annual growth rate
        int forecastYears = 10;              // 10 years prediction

        System.out.println("Parameters:");
        System.out.println(" - Initial Investment (PV): $" + initialInvestment);
        System.out.println(" - Annual Growth Rate (r): " + (annualGrowthRate * 100) + "%");
        System.out.println(" - Forecast Periods (n): " + forecastYears + " years\n");

        // Run Recursive Calculation
        double predictedValueRecursive = calculateFutureValueRecursive(initialInvestment, annualGrowthRate, forecastYears);
        System.out.printf("Predicted Future Value (Recursive): $%.2f%n", predictedValueRecursive);

        // Run Optimized Calculation
        double predictedValueIterative = calculateFutureValueIterative(initialInvestment, annualGrowthRate, forecastYears);
        System.out.printf("Predicted Future Value (Iterative): $%.2f%n", predictedValueIterative);

        // Step 1 & Step 4: Theoretical Discussion
        printAnalysis();
    }

    private static void printAnalysis() {
        System.out.println("\n--- Recursive Algorithm Analysis ---");
        System.out.println("1. Concept of Recursion:");
        System.out.println("   Recursion simplifies complex problems by breaking them down into smaller self-similar sub-problems until reaching a base condition.");

        System.out.println("\n2. Time & Space Complexity:");
        System.out.println("   - Simple Linear Recursion: O(n) time complexity and O(n) call stack space memory.");
        System.out.println("   - Tree Recursion (if branch factors increase): can jump up to O(2^n) exponential complexity if computing subproblems repeatedly.");

        System.out.println("\n3. Optimization Techniques:");
        System.out.println("   - Memoization: Caching previously calculated recursive results to avoid redundant computations.");
        System.out.println("   - Tail-Call Optimization / Iteration: Converting recursion to an iterative loop reduces memory overhead down to O(1) space.");
    }
}