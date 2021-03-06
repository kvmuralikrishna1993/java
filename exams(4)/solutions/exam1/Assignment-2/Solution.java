import java.util.Scanner;
//import java.lang.Math;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author :
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      r     Number of rows
     * @param      c    Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] rH(final int[][] a, final int r, final int c) {
        final float factor = 100;
        final int fac = 100;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //System.out.println(a[i][j]);
                //System.out.println(k);
                //System.out.println(Math.round(k));
                a[i][j] = ((int) Math.round​(a[i][j] / factor)) * fac;
            }
        }
        return a;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = rH(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
