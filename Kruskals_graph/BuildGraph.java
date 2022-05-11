public class BuildGraph {

    private int weight;
    private String start, end, status;

    public BuildGraph() {
    }

    public BuildGraph(int weight, String start, String end) {

        this.weight = weight;
        this.start = start;
        this.end = end;

    }

    public int getWeight() {
        return weight;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void graphToGrid() {

        for (int i = 0; i < weight; i++) {
            System.out.printf("| %3d | %13s - %10s | %6d | %12s |\n", i + 1, start,
                    end, weight, status);
        }

    }

    public void graphToString(BuildGraph path) {

        System.out.println(weight + " " + start + " " + end+" " + status);

    }

}
