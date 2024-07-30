class FinancialForecasting {

    // Recursive method to calculate future value
    double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized recursive method using memoization
    double calculateFutureValueOptimized(double currentValue, double growthRate, int years, Double[] memo) {
        if (years == 0) {
            return currentValue;
        }
        if (memo[years] != null) {
            return memo[years];
        }
        memo[years] = calculateFutureValueOptimized(currentValue * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        FinancialForecasting ff = new FinancialForecasting();
        double currentValue = 1000.0;
        double growthRate = 0.05; // 5% annual growth
        int years = 10;

        // Using simple recursion
        double futureValue = ff.calculateFutureValue(currentValue, growthRate, years);
        System.out.println("Future Value (Simple Recursion): " + futureValue);

        // Using optimized recursion with memoization
        Double[] memo = new Double[years + 1];
        double futureValueOptimized = ff.calculateFutureValueOptimized(currentValue, growthRate, years, memo);
        System.out.println("Future Value (Optimized Recursion): " + futureValueOptimized);
    }
}

