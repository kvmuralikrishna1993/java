import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.io.IOException;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Plagarisam p = new Plagarisam();
        String path =
        "/Users/Muralikrishna/Desktop/java/assignments/m24/Stringmatching/";
        String filename = "";
        Scanner scan = new Scanner(System.in);
        try {
            filename = scan.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("Empty Directory");
            return;
        }
        path += filename; //creating a path from folder name
        File folder = new File(path); //giving folder name
        if (folder.isDirectory()) { //checking it is folder or not
            File[] fileList = folder.listFiles();
            //storing in fileList array
            Arrays.sort(fileList);
            //sorting all files
            try {
                for (File file:fileList) {
                    BufferedReader br = new BufferedReader(
                    new FileReader(path + "/" + file.getName()));
                    //creating a path
                    StringBuilder sb = new StringBuilder();
                    //append string
                    String line = br.readLine();
                    //read each line
                        while (line != null) { //line not equals nothing
                            sb.append(line).append("\n");
                            //append line by line
                            line = br.readLine();
                            //reading line untill null
                        }
                    String fileAsString = sb.toString();
                    //convert to string
                    p.addfile(fileAsString, file.getName());
                    //storing files in string array
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        p.cleanfile();
        p.printresult();
    }
}
