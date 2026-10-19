package lt.viko.eif;

public final class Utils {

    /**
     * Construct an error message string, and print it to the standard error
     * stream (stderr). Returns the string printed to the stderr.
     * @param t any subclass of {@link Throwable}, e.g. {@link RuntimeException}
     * @param message information about the error
     * @return the error message string, which was printed to stderr
     */
    public static String showThrowableError(Throwable t, String message) {
        String fullMsg = "[error]: " + message + ": " + t.getMessage() + "\n";
        System.err.print(fullMsg);
        return fullMsg;
    }

    /**
     * Construct an error message string, and print it to the standard error
     * stream (stderr). Returns the string printed to the stderr.
     * <p>
     * Similar to {@link showThrowableError}, except it does not use a Throwable type
     * exception's message.
     * @param message information about the error
     * @return the error message string, which was printed to stderr
     */
    public static String showStringError(String message) {
        String fullMsg = "[error]: " + message + "\n";
        System.err.print(fullMsg);
        return fullMsg;
    }
}
