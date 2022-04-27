package Matrix;

public class Graph {
    private int[][] graphG;
    private int[][] graphNew;

    public Graph() {
        this.graphG = setGraph();
        this.graphNew = graphG;
        // System.out.println("Origin address: " + graphG);
        // System.out.println("Clone address: " + graphNew);
    }

    public void powerOfMatrix(int round) {
        for (int i = 0; i < round - 1; i++)
            multiplyGraph();
        getGraph();
    }

    public int[][] setGraph() {
        int[][] graphReturn = {
                { 0, 1, 0 },
                { 1, 1, 2 },
                { 0, 2, 0 } };
        return graphReturn;
    }

    public void multiplyGraph() {
        int tmp;
        int[][] graphTemp = new int[graphG[0].length][graphG.length];
        for (int i = 0; i < graphG.length; i++) {
            for (int j = 0; j < graphG[0].length; j++) {
                tmp = 0;
                for (int k = 0; k < graphG[i].length; k++) {
                    tmp += graphG[i][k] * graphNew[k][j];
                }
                graphTemp[i][j] = tmp;
            }

        }
        graphNew = graphTemp;
    }

    public void getGraph() {
        for (int[] matrix : graphNew) {
            System.out.print("|");
            for (int row : matrix)
                System.out.print(" " + row + " ");
            System.out.println("|");
        }
    }
}
