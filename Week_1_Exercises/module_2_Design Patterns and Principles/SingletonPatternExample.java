// Create a new Java project named SingletonPatternExample

// Define a Singleton Class
class Logger {
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {}

    // Public method to provide access to the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Example logging method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Implement the Singleton Pattern
// The above code already ensures the Logger class follows the Singleton design pattern

// Test the Singleton Implementation
public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is a singleton logger instance.");

        // Verify that only one instance is created
        System.out.println("Logger instances are the same: " + (logger1 == logger2));
    }
}
