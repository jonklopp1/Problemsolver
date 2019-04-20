/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.puzzle;
import domains.puzzle.PuzzleState.Location;
import framework.problem.Mover;
import framework.problem.State;
/**
 *
 * @author jonkl
 */
public class PuzzleMover extends Mover {
    public static final String SLIDE_TILE_1 = "Slide Tile 1";
    public static final String SLIDE_TILE_2 = "Slide Tile 2";
    public static final String SLIDE_TILE_3 = "Slide Tile 3";
    public static final String SLIDE_TILE_4 = "Slide Tile 4";
    public static final String SLIDE_TILE_5 = "Slide Tile 5";
    public static final String SLIDE_TILE_6 = "Slide Tile 6";
    public static final String SLIDE_TILE_7 = "Slide Tile 7";
    public static final String SLIDE_TILE_8 = "Slide Tile 8";
    
    public PuzzleMover(){
    super.addMove(SLIDE_TILE_1 , s -> slideTile1(s));
    super.addMove(SLIDE_TILE_2 , s -> slideTile2(s));
    super.addMove(SLIDE_TILE_3 , s -> slideTile3(s));
    super.addMove(SLIDE_TILE_4 , s -> slideTile4(s));
    super.addMove(SLIDE_TILE_5 , s -> slideTile5(s));
    super.addMove(SLIDE_TILE_6 , s -> slideTile6(s));
    super.addMove(SLIDE_TILE_7 , s -> slideTile7(s));
    super.addMove(SLIDE_TILE_8 , s -> slideTile8(s));
    
    
    }
    
    public boolean isAdjacent(State s , int tileNum){
       PuzzleState cs = (PuzzleState) s;
       Location blank =  cs.getLocation(0);
       Location tile = cs.getLocation(tileNum);
       
       int tR = tile.getRow();
       int tC = tile.getColumn();
       int bR = blank.getRow();
       int bC = blank.getColumn();
       
       return(tR == bR && tC == bC+1 ||
              tR == bR+1 && tC == bC ||
              tR == bR && tC == bC-1 ||
              tR == bR-1 && tC == bC);
           
      
       
    }

    private State slideTile1(State s) {
       if ( isAdjacent(s,1)){
        PuzzleState cs = (PuzzleState) s;
        Location blank =  cs.getLocation(0);
        Location tile = cs.getLocation(1);
       return new PuzzleState(cs,blank,tile);
       }else{
           return null;
       }
    }

    private State slideTile2(State s) {
        if ( isAdjacent(s,2)){
        PuzzleState cs = (PuzzleState) s;
        Location blank =  cs.getLocation(0);
        Location tile = cs.getLocation(2);
       return new PuzzleState(cs,blank,tile);
       }else{
           return null;
       }
        
    }

    private State slideTile3(State s) {
        if ( isAdjacent(s,3)){
        PuzzleState cs = (PuzzleState) s;
        Location blank =  cs.getLocation(0);
        Location tile = cs.getLocation(3);
       return new PuzzleState(cs,blank,tile);
       }else{
           return null;
       }
        
    }

    private State slideTile4(State s) {
        if ( isAdjacent(s,4)){
        PuzzleState cs = (PuzzleState) s;
        Location blank =  cs.getLocation(0);
        Location tile = cs.getLocation(4);
       return new PuzzleState(cs,blank,tile);
       }else{
           return null;
       }
        
    }

    private State slideTile5(State s) {
        if ( isAdjacent(s,5)){
        PuzzleState cs = (PuzzleState) s;
        Location blank =  cs.getLocation(0);
        Location tile = cs.getLocation(5);
       return new PuzzleState(cs,blank,tile);
       }else{
           return null;
       }
        
    }

    private State slideTile6(State s) {
        if ( isAdjacent(s,6)){
        PuzzleState cs = (PuzzleState) s;
        Location blank =  cs.getLocation(0);
        Location tile = cs.getLocation(6);
       return new PuzzleState(cs,blank,tile);
       }else{
           return null;
       }
        
    }

    private State slideTile7(State s) {
        if ( isAdjacent(s,7)){
        PuzzleState cs = (PuzzleState) s;
        Location blank =  cs.getLocation(0);
        Location tile = cs.getLocation(7);
       return new PuzzleState(cs,blank,tile);
       }else{
           return null;
       }
        
    }

    private State slideTile8(State s) {
        if ( isAdjacent(s,8)){
        PuzzleState cs = (PuzzleState) s;
        Location blank =  cs.getLocation(0);
        Location tile = cs.getLocation(8);
       return new PuzzleState(cs,blank,tile);
       }else{
           return null;
       }
        
    }
    
    
}
