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
        super.setQueue(new PriorityQueue<Vertex>(getComparator()));
        
        
    }
    
    /**
     * Adds a vertex to the PQ.
     * @param v the vertex to be added
     */
    @Override
    public void add(Vertex v) {
        super.getQueue().add(v);
            
        
    }
    
    /**
     * Creates a comparator object that compares vertices for ordering
     * in a PQ during A* search.
     * This should be used when creating the PQ.
     * @return the comparator object
     */
    public final Comparator<Vertex> getComparator() {
        return (v1, v2) -> {
        State goal = getProblem().getFinalState();
        State s1 = (State)v1.getData();
        State s2 = (State)v2.getData();
        int h1 = s1.getHeuristic(goal);
        int h2 = s2.getHeuristic(goal);
        int d1 = v1.getDistance();
        int d2 = v2.getDistance();
        return Integer.compare(h1+d1, h2+d2);
        };
    }
}
    
   