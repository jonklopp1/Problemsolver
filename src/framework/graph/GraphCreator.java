package framework.graph;

import framework.graph.Vertex;
import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import java.util.List;
import java.util.Stack;

/**
 * Author: jon klopp
 */
public class GraphCreator {
    
    public Graph createGraphFor(Problem problem) {
        graph = new Graph();
        stack = new Stack();
        mover = problem.getMover();
        Vertex start = new Vertex(problem.getInitialState());
        stack.push(start);
        moves = mover.getMoveNames();
        while(!stack.isEmpty()){
           // System.out.println(stack.size());
            Vertex u = (Vertex) stack.pop();
            for(String x:moves){
             //   System.out.println(x);
                State next = mover.doMove(x, (State) u.getData());
                if(next != null){
                    Vertex v = new Vertex(next);
                    if (graph.getVertices().containsKey(v)){
                        v =  graph.getVertices().get(v);
                    }
                    else{
                        stack.push(v);
                    }
                    graph.addEdge(u, v);
                    
                }/*else{
                    System.out.println("null");
                }*/
                
            }
        }
        return graph;
    }
    
    private Mover mover;
    private List<String> moves; 
    private Stack stack;
    private Graph graph = null;
}