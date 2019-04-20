package framework.solution;

import domains.puzzle.PuzzleState;
import framework.graph.Vertex;
import framework.problem.Problem;
import framework.problem.State;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/* imports go here */

/**
 * This class represents an A* solver by extending the StateSpaceSolver
 * class.
 * @author Your name and section here
 */
public class AStarSolver extends StateSpaceSolver {
    
    /**
     * Creates an A* solver.
     * This constructor should set the queue to a priority queue (PQ)
     * and set the statistics header.
     * @param problem 
     */
    public AStarSolver(Problem problem) {
        super(problem, false);
        Pque = new PriorityQueue<Vertex>(getComparator());
        
        
    }
    
    /**
     * Adds a vertex to the PQ.
     * @param v the vertex to be added
     */
    @Override
    public void add(Vertex v) {
        Pque.add(v);
            
        
    }
    
    /**
     * Creates a comparator object that compares vertices for ordering
     * in a PQ during A* search.
     * This should be used when creating the PQ.
     * @return the comparator object
     */
    public final Comparator<Vertex> getComparator() {
        return new stateComparator();
    }
    
    public class stateComparator implements Comparator<Vertex>{

        @Override
        public int compare(Vertex o1, Vertex o2) {
            State v1 = (State) o1.getData();
            State v2 = (State) o2.getData();
            int i1 = v1.getHeuristic(problem.getFinalState());
            int i2 = v2.getHeuristic(problem.getFinalState());
            
            if (i1<i2){
                return 1;
            }else if(i1>i2){
                return -1;
            }
            return 0;
        }
    }
    
    private final PriorityQueue Pque;
}