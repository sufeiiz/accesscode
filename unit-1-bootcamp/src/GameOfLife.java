import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Sufei Zhao on 4/14/15.
 */
public class GameOfLife {
    final static int M = 25;
    final static int N = 75;

    // Take a world and the coordinates of a cell and return the number of
    // neighbors (organisms in neighboring cells) that the cell has
    public static int neighbors(char[][] gen, int m, int n) {
        int numNeighbor = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                // if neighbor is alive (X) and coordinates are not the original cell
                if (gen[m+i][n+j] == 'X' && (m+i != m || n+j != n))
                    numNeighbor++;
            }
        }
        return numNeighbor;
    }

    // Simulate new generation from old generation
    public static char[][] newGen(char[][] gen) {
        char[][] newGen = new char[M+1][N+1];
        int numNeighbor;
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                numNeighbor = neighbors(gen, i, j);

                // 1. Each organism of the current generation survives to the next generation if it has 2 or 3 neighbors
                //    Otherwise, it dies and its cell becomes empty in the next generation.
                //    Note: it dies if it is ``lonely'' or ``overcrowded''.
                // 2. Each vacant cell in the current generation becomes occupied by a new organism in the next generation if
                //    it has exactly 3 neighbors. Otherwise, it remains vacant in the next generation.
                if (gen[i][j] == 'X') {
                    if (numNeighbor == 2 || numNeighbor == 3)
                        newGen[i][j] = 'X';
                    else
                        newGen[i][j] = '.';
                } else if (gen[i][j] == '.') {
                    if (numNeighbor == 3)
                        newGen[i][j] = 'X';
                    else
                        newGen[i][j] = '.';
                }
            }
        }
        return newGen;
    }

    // The other should take a generation array and return a Boolean value that tells whether or
    // not the world represented by the array is empty.
    public static boolean allDead(char[][] gen) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (gen[i][j] == 'X')
                    return false;
            }
        }
        return true;
    }

    // Print generation
    public static void printGen(char[][] gen) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(gen[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String filename, line, answer;
        char curr;
        int count = 0;

        // User input initial generation from .dat file
        // /Users/sufeizhao/Desktop/accesscode_forks/unit-1-bootcamp/src/Files/life1.dat
        System.out.print("Which file do you want to open?");
        filename = input.nextLine();
        File file = new File(filename);
        Scanner reader = new Scanner(file);

        // Generation 0
        char[][] gen0 = new char[M + 1][N + 1];
        for (int i = 0; i < M; i++) {
            line = reader.next();
            for (int j = 0; j < line.length(); j++) {
                curr = line.charAt(j);
                gen0[i + 1][j + 1] = curr;
            }
        }
        System.out.println("\nGeneration " + count);
        printGen(gen0);

        while (!allDead(gen0)) {
            System.out.println("Would you like to see the next generation? Y or N");
            answer = input.next();

            if (answer.toUpperCase().charAt(0) == 'Y') {
                // next generation
                count ++;
                char[][] nextGen = newGen(gen0);
                System.out.println("\nGeneration " + count);
                printGen(nextGen);

                if (allDead(nextGen)) {
                    System.out.println("All organisms have died. End program.");
                    break;
                }

                gen0 = nextGen;
            } else if (answer.toUpperCase().charAt(0) == 'N') {
                System.out.println("End program.");
                break;
            } else
                System.out.println("Try again.");
        }
    }
}
