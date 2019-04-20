package framework.solution;

import framework.graph.Vertex;
import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import java.util.List;
import framework.solution.Statistics;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Queue;

/* imports go here */

/**
 * This class represents a state space solver by extending the abstract
 * Solver class.
 * @author Jon klopp
 */
public class StateSpaceSolver extends Solver {
    
    /**
     * Creates a BFS or DFS state space solver.
     * This constructor should set the queue to a double-ended queue (DEQUE)
     * and set the statistics header.
     * @param problem the problem being solved
     * @param bfs a boolean flag indicating whether BFS is to be performed
     */
    public StateSpaceSolver(Problem problem, boolean bfs) {
        super(problem);
        this.problem = problem;
        this.mover = problem.getMover();
        this.bfs = bfs;
        deque = new LinkedList<Vertex>() ;
        stat = getStatistics();
        if (this.bfs == true){
        stat.setHeader("Breadth-First State Space Search");   
        }else{
        stat.setHeader("Deapth-First State Space Search");
        }
        
        super.setQueue(deque);
        
        
        
    }
    
    /**
     * Adds a vertex to the DEQUE.
     * If BFS is being performed, the vertex should be added to the
     * end of the DEQUE, so the DEQUE acts like an ordinary queue.
     * If DFS is being performed, the vertex should be added to the
     * front of the DEQUE, so the DEQUE acts like a stack.
     * @param v 
     */
    @Override
    public void add(Vertex v) {
	if (bfs){
        deque.addLast(v);
        }else{
        deque.addFirst(v);
        }
    }
    
    /**
     * This method implements the expand operation required by the 
     * state space search algorithm:

       Expand(u)
          children = {}
          for each name ∈ moveNames do
             child = mover.doMove(name, u)
             if child ≠ null and not OccursOnPath(child, u)
                then d[child] = d[u] + 1
                     pred[child] = u
                     add child to children
          return children

     * @param u the vertex being expanded
     * @return 
     */
    @Override
    public List<Vertex> expand(Vertex u) {
	List<Vertex> children = new LinkedList<>();
        List<String> moveNames = mover.getMoveNames();
        
        for (String x : moveNames){
            Vertex child = new Vertex(mover.doMove(x,(State) u.getData()));
            if (child.getData() != null && !occursOnPath(child,u)){
               child.setPredecessor(u);
               children.add(child);
               
              }
        }
        
        return children; 
    }

    /**
     * Checks whether a given vertex appears on the predecessor path
     * of a given ancestor.
     * @param v the vertex to check
     * @param ancestor the ancestor vertex of v
     * @return true if v occurs on the predecessor path of ancestor,
     * false otherwise
     */
    public static boolean occursOnPath(Vertex v, Vertex ancestor) {
	Vertex predecessor = ancestor; 
        while(predecessor != null){
            if(predecessor.equals(v)){
                return true;
                } 
            predecessor = predecessor.getPredecessor();   
        }
        
        return false;
    }
    
    
    private Deque<Vertex> deque;
    private final Statistics stat;
    final Problem problem;
    private final Boolean bfs;
    private final Mover mover;
   
}

