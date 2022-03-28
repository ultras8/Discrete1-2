import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Graph {
    
    private String[] graphWalk;
    private int repeatedEdge = 0;
    private int repeatedVertex = 0;
    private int startendSamepoint = 0;
    // 0 = false 1 = true 3 = allowed

    Graph(String all){  

        this.graphWalk = all.split(" ");


    }

    public boolean Trail(int repeatedEdge, int repeatedVertex, int startendSamepoint){

        //repeatedEdge = 0;
        //repeatedVertex = 3;
        //startendSamepoint = 3;

        if(repeatedEdge == 0) return true;
        return false;

    }

    public boolean circuit(int repeatedEdge, int repeatedVertex, int startendSamepoint){

        //repeatedEdge = 0;
        //repeatedVertex = 3;
        //startendSamepoint = 1;

        if(repeatedEdge == 0 && startendSamepoint == 1) return true;
        return false;

    }

    public boolean simpleCircuit(int repeatedEdge, int repeatedVertex, int startendSamepoint){

        //repeatedEdge = 0;
        //repeatedVertex = 4; // start and stop in 1 vertex
        //startendSamepoint = 1;

        if(repeatedEdge == 0 && repeatedVertex == 4 && startendSamepoint == 1) return true;
        return false;

    }

    public String checkGraph(){

        int sumOf = 0;
        List<String> list = Arrays.asList(graphWalk);
        if(graphWalk[0].equals(graphWalk[graphWalk.length-1])){
            repeatedVertex = 1;
            startendSamepoint = 1;
        }
        for(int i = 0; i < graphWalk.length; i++){

            sumOf += Collections.frequency(list, graphWalk[i]);
            if(Collections.frequency(list, graphWalk[i]) > 1){

                if( i % 2 == 0 ){
                    if(i == 0 ) repeatedVertex = 4;
                    else if(i != graphWalk.length-1) repeatedVertex = 1;
                }
                else if(i % 2 != 0 ) repeatedEdge = 1;

            }

        }

        if(sumOf == graphWalk.length) return "Path";
        if(simpleCircuit(repeatedEdge, repeatedVertex, startendSamepoint)) return "Simple Circuit";
        if(circuit(repeatedEdge, repeatedVertex, startendSamepoint)) return "Circuit";
        if(Trail(repeatedEdge, repeatedVertex, startendSamepoint)) return "Trail";

        return "Walk";

    }

}
