import java.util.Scanner;

public class runGraph {
    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        String all = sn.nextLine();
        sn.close();

        Graph G = new Graph(all);
        System.out.println(G.checkGraph());
    }
}




