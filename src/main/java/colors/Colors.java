package colors;

/**
 * The enum Colors.
 */
public enum Colors {
    /**
     * Red colors.
     */
    RED("\u001B[31m"),
    /**
     * Purple colors.
     */
    PURPLE("\u001B[35m"),
    /**
     * Blue colors.
     */
    BLUE("\u001B[34m"),
    /**
     * Reset colors.
     */
    RESET("\u001B[0m");

    private final String code;

    Colors(String code){
        this.code = code;
    }
    @Override
    public String toString() {
        return code;
    }
}
