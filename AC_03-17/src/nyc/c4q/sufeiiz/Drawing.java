package nyc.c4q.sufeiiz;

/**
 * Access Code 2.1
 * Drawing.java
 * Create by ggundersen
 */

public class Drawing {

    private static final String[] lines = {
            "  |",
            "\n \\",
            "0",
            "/",
            "\n  |",
            "\n /",
            " \\"
    };

    public Drawing() {
    }

    public static String get(int misses) {
        String drawing = "";
        for (int i = 1; i <= misses; i++) {
            drawing += lines[i];
        }
        return drawing;
    }
}