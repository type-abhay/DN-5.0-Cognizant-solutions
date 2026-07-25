// Logger class (not public)
class Logger {
    private static Logger instance;

    private Logger() {
        System.out.println("Logger initialized.");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

// Main class matching the file name
public class SingletonPatternExample {
    public static void main(String[] args) {
        System.out.println("--- Testing Singleton Pattern ---");

        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        System.out.println("\nChecking Instance Equality:");
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both loggers point to the SAME instance.");
        } else {
            System.out.println("FAILURE: Loggers point to DIFFERENT instances.");
        }
    }
}