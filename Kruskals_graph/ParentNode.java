import java.util.ArrayList;

public class ParentNode {
    
    private String parent = "";
    private String node;
    private int rank = 0;
    private ArrayList<String> child = new ArrayList<>();

    public ParentNode() {}

    public ParentNode(String parent, int rank) {

        this.parent = parent;
        this.rank = rank;
        this.node = parent;

    }

    public String getName(){
        return node;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getParent() {
        return parent;
    }

    public void setChild(String name) {
        child.add(name);
    }

    public ArrayList<String> getChild() {
        return this.child;
    }

    public int getChildSize() {
        return this.child.size();
    }

}
