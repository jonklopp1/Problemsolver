/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.arithmetic;


import framework.problem.Mover;
import framework.problem.State;
/**
 *
 * @author jonkl
 */
public class ArithmeticMover extends Mover {
     public static final String ADD3 = "Add 3";
     public static final String SUB5 = "Subtract 5";
     public static final String DIV2 = "Divide by 2";
     public static final String MULT2 = "Multiply by 2";
     
     public ArithmeticMover() {
         super.addMove(ADD3, s -> add3(s));
         super.addMove(SUB5, s -> sub5(s));
         super.addMove(DIV2, s -> div2(s));
         super.addMove(MULT2, s -> mult2(s));
         
     }
     
     private State add3(State state){
         ArithmeticState curState = (ArithmeticState) state;
         return new ArithmeticState(curState.getContents()+3);
     }
     private State sub5(State state){
         ArithmeticState curState = (ArithmeticState) state;
         return new ArithmeticState(curState.getContents()-5);
     }
     private State div2(State state){
         ArithmeticState curState = (ArithmeticState) state;
         return new ArithmeticState(curState.getContents()/2);
     }
     private State mult2(State state){
         ArithmeticState curState = (ArithmeticState) state;
         return new ArithmeticState(curState.getContents()*2);
     }
}
