package Matrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // new GraphCalculation(sc.nextInt());
        new Graph().powerOfMatrix(sc.nextInt());
        sc.close();
    }
}
