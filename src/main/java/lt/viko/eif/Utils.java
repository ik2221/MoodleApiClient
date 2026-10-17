package lt.viko.eif;

public final class Utils {

    /**
     * Constructs an error message string, and print it to the standard error
     * stream (stderr). Returns the string printed to the stderr.
     * @param t any subclass of {@code Throwable}, e.g. {@code RuntimeException}
     * @param message information about the error
     * @return the error message string
     */
    public static String showError(Throwable t, String message) {
        String fullMsg = "[error]: " + message + ": " + t.getMessage() + "\n";
        System.err.print(fullMsg);
        return fullMsg;
    }
}
