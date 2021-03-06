import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 * @author :
 */
class Set {
/**
 * { array declaration }.
 */
    private int[] set;
/**
 * { size declaration }.
 */
    private int size;
/**
 * { array size }.
 */
    private final int var = 10;
/**
 * Constructs the object.
 */
    Set() {
        set = new int[var];
        size = 0;
    }
    /**
     * { Dynamic array }.
     *
     * @param      args   The array
     *
     * @return     { array }
     */
    public int[] resize(final int[] args) {
        int[] temp = new int[(args.length * 2)];
        for (int i = 0; i < args.length; i++) {
            temp[i] = args[i];
        }
        return temp;
    }
    /**
     * { list add function }.
     *
     * @param      item  elements
     */
    public void add(final int item) {
        if (!contains(item)) {
            if (size < set.length) {
            set[size] = item;
            size += 1;
            } else {
            set = resize(set);
            set[size] = item;
            size += 1;
            }
        }
    }
    /**
     * { returns size of list.}.
     *
     * @return     {size of list.}.
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }
    /**
     * { checks the element in list.}.
     *
     * @param      item  The item
     *
     * @return     { true or false.}
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return true;
            }
        }
        return false;
    }
        /**
     * {print display}.
     *
     * @return     String of list.
     */
    public String toString() {
        // Replace the code below
        String str = "{";
        String cmm = ", ";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                cmm = "";
            }
            str = str + Integer.toString(set[i]) + cmm;
        }
        str = str + '}';
        return str;
    }
     /**
     * Adds all elements given.
     *
     * @param      item  The item
     */
    public void add(final int[] item) {
        for (int i = 0; i < item.length; i++) {
            add(item[i]);
        }
    }
    /**
     * { intersection function}.
     *
     * @param      args  The arguments
     *
     * @return     { description_of_the_return_value }
     */
    public Set intersection(final Set args) {
        Set inter = new Set();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < args.set.length; j++) {
                if (set[i] == args.set[j]) {
                    inter.add(set[i]);
                }
            }
        } return inter;
    }
    /**
     * { remove function }.
     *
     * @param      index  The index
     */
    public void remove(final int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
            set[i] = set[i + 1];
            }
            size -= 1;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }
    /**
     * { function_retainAll }.
     *
     * @param      args  The arguments
     *
     * @return     { Object }
     */
    public Set retainAll(final int[] args) {
        Set retain = new Set();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < args.length; j++) {
                if (set[i] == args[j]) {
                    retain.add(set[i]);
                }
            }
        }
        return retain;
    }
    /**
     * { function cartesianProduct }.
     *
     * @param      args  The arguments
     *
     * @return     { Object }
     */
    public Object[] cartesianProduct(final Set args) {
        final int len1 = size;
        final int len2 = args.size();
        Object[] cartesianProduct = new Object[size * len2];
        int k = 0;
        if (len1 == 0 || len2 == 0) {
            return null;
        }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < len2; j++) {
                    cartesianProduct[k] = new int[]{set[i], args.set[j]};
                    k++;
                }
            }
        return cartesianProduct;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
