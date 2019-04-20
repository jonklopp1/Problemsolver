/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.puzzle;
import framework.problem.Problem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import framework.problem.Benchmark;
/**
 *
 * @author jonkl
 */
public class PuzzleProblem extends Problem {
       
    public PuzzleProblem(){
        super();
        super.setName("8-Puzzle");
        super.setIntroduction(INTRO);
        super.setMover(new PuzzleMover());
        super.setInitialState(new PuzzleState(
                new int[][]{new int[]{2, 8, 3}, 
                            new int[]{1, 6, 4}, 
                            new int[]{7, 0, 5}}));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(new PuzzleState(
                new int[][]{new int[]{1, 2, 3}, 
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}}));
    sg = new PuzzleState(
                new int[][]{new int[]{1, 2, 3},   // the goal state
                            new int[]{8, 0, 4}, 
                            new int[]{7, 6, 5}});
    
    s1 = new PuzzleState(
                new int[][]{new int[]{2, 8, 3},   
                            new int[]{1, 6, 4}, 
                            new int[]{7, 0, 5}});
    
    s2 = new PuzzleState(
                new int[][]{new int[]{3,6,4},   
                            new int[]{1,0,2}, 
                            new int[]{8,7,5}});
    
    s3 = new PuzzleState(
                new int[][]{new int[]{3,0,4},   
                            new int[]{1,6,5}, 
                            new int[]{8,2,7}});
    
    s4 = new PuzzleState(
                new int[][]{new int[]{2,1,3},   
                            new int[]{8,0,4}, 
                            new int[]{6,7,5}});
    
    s5 = new PuzzleState(
                new int[][]{new int[]{4,2,0},  
                            new int[]{8,3,6}, 
                            new int[]{7,5,1}});
    
    s6 = new PuzzleState(
                new int[][]{new int[]{1,6,3},   
                            new int[]{4,0,8}, 
                            new int[]{7,2,5}});
    
    s7 = new PuzzleState(
                new int[][]{new int[]{5,2,7},   
                            new int[]{8,0,4}, 
                            new int[]{3,6,1}});
    
    s8 = new PuzzleState(
                new int[][]{new int[]{5,6,7},   
                            new int[]{4,0,8}, 
                            new int[]{3,2,1}});
    
    
    b1 = new Benchmark(s1,sg,"Benchmark 1: 5 Steps");
    b2 = new Benchmark(s2,sg,"Benchmark 2: 10 Steps");
    b3 = new Benchmark(s3,sg,"Benchmark 3: 13 Steps");
    b4 = new Benchmark(s4,sg,"Benchmark 4: 18 Steps");
    b5 = new Benchmark(s5,sg,"Benchmark 5: 20 Steps");
    b6 = new Benchmark(s6,sg,"Benchmark 6: 24 Steps");
    b7 = new Benchmark(s7,sg,"Benchmark 7: 30 Steps");
    b8 = new Benchmark(s8,sg,"Benchmark 8: 30 Steps");
    
    super.getBenchmarks().add(b1);
    super.getBenchmarks().add(b2);
    super.getBenchmarks().add(b3);
    super.getBenchmarks().add(b4);
    super.getBenchmarks().add(b5);
    super.getBenchmarks().add(b6);
    super.getBenchmarks().add(b7);
    super.getBenchmarks().add(b8);
            
    }

            private static final String INTRO = 
                    "You are given a board in which numbered tiles can slide around. "
                    + "There is one blank space that holds no tile.  A legal move "
                    + "consists of sliding a tile into the blank space if the tile is"
                    + "adjacent to it. The goal is to move tiles around until the board"
                    + "looks like the final state below.\n";
                    
            
            
      
        
        
        private PuzzleState sg,s1,s2,s3,s4,s5,s6,s7,s8;
        private final Benchmark b1,b2,b3,b4,b5,b6,b7,b8;
}


       