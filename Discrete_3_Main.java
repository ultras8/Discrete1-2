import java.util.Scanner;

public class Discrete_3_Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String strLine = sc.nextLine();
        Discrete_3_Stack stack = new Discrete_3_Stack(strLine); 
        stack.getAns();

    }
}