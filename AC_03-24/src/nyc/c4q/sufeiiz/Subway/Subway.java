package nyc.c4q.sufeiiz.Subway;

import java.awt.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Subway {

    public static void drawBar(Graphics2D g, Color color, int y, int count, String letter) {
        // Step 4.
        // Implement this method. It takes the Graphics2D instance and some
        // data we need to create a single bar on the bar chart.
        g.setColor(color);
        g.drawString(letter, 0, y);
        g.setStroke(new BasicStroke(10));
        g.drawLine(20, y-5, 20+count, y-5);
        g.drawString(String.valueOf(count), 30+count, y);
    }

    public static int countEntrances(ArrayList<ArrayList<String>> lines, String subwayLine) {
        // Step 3.
        // Implement this method. It takes an ArrayList of an ArrayList of
        // Strings and the subway line we're interested in and returns the
        // number of entrances for that line.
        Iterator<ArrayList<String>> linesIter = lines.iterator();
        int count = 0;

        while (linesIter.hasNext()) {
            if (linesIter.next().get(2).contains(subwayLine))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        // This creates a 500x250 pixel drawing.
        DrawingPanel panel = new DrawingPanel(500, 300);
        // This gets a Graphics2D object that we can use to draw on the panel.
        Graphics2D g = panel.getGraphics();

        // Step 1:
        // Modify this String to indicate the full path to the subway data on your computer.
        // Run your program. If it does not throw an error, you are referencing the file correctly
        File f = new File("/Users/sufeizhao/Desktop/accesscode/AC_03-24/src/nyc/c4q/sufeiiz/Subway/Subway-data.txt");

        // Step 2.
        // Get the lines as a nested ArrayList of Strings from the File instance.
        // Make sure everything is working correctly by printing the data.
        ArrayList<ArrayList<String>> data = f.getLines();
        // System.out.println(data.get(0).get(0));

        // Step 3.
        // Implement countEntrances().
        int A = countEntrances(data, "A");
        int C = countEntrances(data, "C");
        int E = countEntrances(data, "E");
        int B = countEntrances(data, "B");
        int D = countEntrances(data, "D");
        int F = countEntrances(data, "F");
        int M = countEntrances(data, "M");
        int G = countEntrances(data, "G");
        int L = countEntrances(data, "L");
        int J = countEntrances(data, "J");
        int Z = countEntrances(data, "Z");
        int N = countEntrances(data, "N");
        int Q = countEntrances(data, "Q");
        int R = countEntrances(data, "R");
        int one = countEntrances(data, "1");
        int two = countEntrances(data, "2");
        int three = countEntrances(data, "3");
        int four = countEntrances(data, "4");
        int five = countEntrances(data, "5");
        int six = countEntrances(data, "6");
        int seven = countEntrances(data, "7");
        int S = countEntrances(data, "S");

        // Step 4.
        // Implement drawBar().
        Color blue = new Color(0, 0, 255);
        Color orange = new Color(255, 153, 0);
        Color lightGreen = new Color(92, 222, 92);
        Color lightGrey = new Color(188, 202, 202);
        Color brown = new Color(153, 102, 51);
        Color yellow = new Color(255, 255, 0);
        Color red = new Color(255, 0, 0);
        Color green = new Color(0, 153, 51);
        Color purple = new Color(153, 0, 153);
        Color grey = new Color(128, 128, 128);

        drawBar(g, blue, 20, A, "A");
        drawBar(g, blue, 32, C, "C");
        drawBar(g, blue, 44, E, "E");
        drawBar(g, orange, 56, B, "B");
        drawBar(g, orange, 68, D, "D");
        drawBar(g, orange, 80, F, "F");
        drawBar(g, orange, 92, M, "M");
        drawBar(g, lightGreen, 104, G, "G");
        drawBar(g, lightGrey, 116, L, "L");
        drawBar(g, brown, 128, J, "J");
        drawBar(g, brown, 140, Z, "Z");
        drawBar(g, yellow, 152, N, "N");
        drawBar(g, yellow, 164, Q, "Q");
        drawBar(g, yellow, 176, R, "R");
        drawBar(g, red, 188, one, "1");
        drawBar(g, red, 200, two, "2");
        drawBar(g, red, 212, three, "3");
        drawBar(g, green, 224, four, "4");
        drawBar(g, green, 236, five, "5");
        drawBar(g, green, 248, six, "6");
        drawBar(g, purple, 260, seven, "7");
        drawBar(g, grey, 272, S, "S");
    }

}
