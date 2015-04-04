package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/12/15.
 */
public class DrawRocket {
    public static void head(int size) {
        String top = "**";
        String left = "/", right = "\\";
        for (int a = (size * 2 - 1); a > 0; a--) {
            top = left + top + right;
            for (int b = a; b > 0; b--) {
                System.out.print(" ");
            }
            System.out.println(top);
        }
    }

    public static void line(int size) {
        String line = "*";
        for (int c = 0; c < size; c++) {
            line += "*=*=";
        }
        line += "*";
        System.out.println(line);

    }

    // TODO: Finish this
    public static void bodyUp(int size) {
        // dots   0 0       carrot     1 1
        //      1 0 0 1              2 1 1 2
        //    2 1 0 0 1 2          3 2 1 1 2 3

        String dot = ".";
        String carrot = "/\\";
        String build = "|";

        for (int f=1; f<=size; f++) {
            for (int d = size-1; d > 1; d--) {
                build += dot;
            }
            for (int e = f; e <= size-1; e++) {
                build += carrot;
            }
            build += "|";
            System.out.println(build);
        }

    }

    public static void bodyDown(int size) {

        //for

    }

    public static void main(String[] args) {
        int size = 3;
        head(size);
        line(size);
        bodyUp(size);
        line(size);
        bodyUp(size);
        line(size);
        head(size);
    }
}

