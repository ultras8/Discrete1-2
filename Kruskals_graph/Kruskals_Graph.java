import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Kruskals_Graph extends BuildGraph {

    private HashMap<String,ParentNode> node = new HashMap<>();
    private ArrayList<BuildGraph> path = new ArrayList<>();
    private ParentNode A = new ParentNode();
    private ParentNode B = new ParentNode();

    public Kruskals_Graph(){
        
        Scanner sc = new Scanner(System.in);
        int numLine = sc.nextInt();
        for(int i = 0; i < numLine; i++){

            String firstName = sc.next();
            String secondName = sc.next();
            int weight = sc.nextInt();

            node.put(firstName, new ParentNode(firstName, 0));
            node.put(secondName, new ParentNode(secondName, 0));
            
            path.add(new BuildGraph(weight, firstName, secondName));
             // set path

        }

        sc.close();

        sortByCompare(); // sort by weight
        setGraphParent(); // check circuit
        graphToGrid();

    }

    public void setGraphParent(){

        for(BuildGraph connect : path) {

            A = node.get(connect.getStart());
            B = node.get(connect.getEnd());

            if( !( A .getParent().equals( B .getParent())) ){  

                if( node.get( A . getParent() ) .getRank() >=  node.get( B . getParent() ) .getRank()){
                    B .setParent( A .getParent() );
                    A .setRank( node.get( A . getParent() ).getRank() + 1 );

                    if( B .getChildSize() == 0) A .setChild( node.get(connect.getEnd()) .getName() );
                    else{
                        for(String child : B .getChild()){
                            A.setChild(child);
                            node.get(child).setParent(A.getParent());
                        }
                    }

                }else{

                    A .setParent( B .getParent() );
                    B .setRank( node.get( B . getParent() ).getRank() + 1 );

                    if( A .getChildSize() == 0) B .setChild( node.get(connect.getStart()) .getName() );
                    else{
                        for(String child : A .getChild()){
                            B.setChild(child);
                            node.get(child).setParent( B.getParent() );
                        }
                    }

                } connect.setStatus("Added");

            }else connect.setStatus("Not Added");
        }

    }


    @Override
    public void graphToGrid() {

        int i = 0;

        System.out.println("------------------------------------------------------------");
        System.out.printf("| idx |             Edge           | weight |    status    |\n");
        System.out.println("------------------------------------------------------------");

        for (BuildGraph graph : path) {
            System.out.printf("| %3d | %13s - %10s | %6d | %12s |\n", i + 1, graph.getStart(),
                    graph.getEnd(), graph.getWeight(), graph.getStatus());
            i++;
        }

        System.out.println("------------------------------------------------------------");
    }

    @Override
    public void graphToString(BuildGraph path) {

        System.out.println(path.getWeight() + " " + path.getStart() + " " + path.getEnd());

    }

    public void sortByCompare(){
        Collections.sort(path, new SortByCompare());
    }

}

class SortByCompare implements Comparator<BuildGraph> {
 
    @Override
    public int compare(BuildGraph one, BuildGraph two) {
        return one.getWeight() - two.getWeight();
    }

}
