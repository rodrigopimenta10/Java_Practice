import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int temp = 0;
        int length = a.length;
        int tempD = 0;
        int increment = 0;

        int[] b = new int[length];
        for (int i = 0; i < length; i++) {
            b[i] = a[i];
        }
        
        if(length==d){
            return a;
        }

        while(d>length){
            d = d-length;
        }
        
        tempD = d;
        for (int i = 0; i < length; i++) {
            increment = tempD+i;
            while(increment>=length){
                increment = increment-length;
            }
            a[i]=b[increment];
        }
        
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
