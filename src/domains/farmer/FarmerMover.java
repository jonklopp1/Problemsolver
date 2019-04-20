package domains.farmer;

import framework.problem.Mover;
import framework.problem.State;

/**
 * 
 * @author jonkl
 */

public class FarmerMover extends Mover{
     public static final String ALONE = "Farmer Goes Alone";
     public static final String TAKEWOLF = "Farmer Takes Wolf";
     public static final String TAKEGOAT = "Farmer Takes Goat";
     public static final String TAKECAB = "Farmer Takes Cabbage";
     
     public FarmerMover(){
         super.addMove(ALONE, s -> alone(s));
         super.addMove(TAKEWOLF, s -> takeWolf(s));
         super.addMove(TAKEGOAT, s -> takeGoat(s));
         super.addMove(TAKECAB, s -> takeCab(s));
     }
     
     private State alone(State state){
     FarmerState cs = (FarmerState) state;  // cs is current state
     String f = changeSide(cs.getfPos());
     String w = cs.getwPos();
     String g = cs.getgPos();
     String c = cs.getcPos();
     
     if(f != g){
         if(g == c){
             return null;
         }
     }
     if(f != w){
         if(w == g){
             return null;
         }
     }
     return new FarmerState(f,w,g,c);  
     }
     
     private State takeWolf(State state){
     FarmerState cs= (FarmerState) state; 
     String f = changeSide(cs.getfPos()) ;
     String w = changeSide(cs.getwPos());
     String g = cs.getgPos();
     String c = cs.getcPos();
     
     if(f != g){
         if(g == c){
             return null;
         }
     }
     if(f != w){
         if(w == g){
             return null;
         }
     }
      if(cs.getfPos() == cs.getwPos()){
         return new FarmerState(f,w,g,c);
     }else{
         return null;
      }
     }
     
     private State takeGoat(State state){
     FarmerState cs = (FarmerState) state; 
     String f = changeSide(cs.getfPos());
     String w = cs.getwPos();
     String g = changeSide(cs.getgPos());
     String c = cs.getcPos();
     
     if(f != g){
         if(g == c){
             return null;
         }
     }
     if(f != w){
         if(w == g){
             return null;
         }
     }
     if (cs.getfPos() == cs.getgPos()){
         return new FarmerState(f,w,g,c);
     }else{
         return null;
      }
     }
     
     private State takeCab(State state){
     FarmerState cs = (FarmerState) state; 
     String f = changeSide(cs.getfPos());
     String w = cs.getwPos();
     String g = cs.getgPos();
     String c = changeSide(cs.getcPos());
     
     
     if(f != g){
         if(g == c){
             return null;
         }
     }
     if(f != w){
         if(w == g){
             return null;
         }
     }
     if (cs.getfPos() == cs.getcPos()){
         return new FarmerState(f,w,g,c);
     }else{
         return null;
     }
     
     }
     
     private String changeSide(String side){
         if(side == "West")
             return "East";
         else
             return "West";
     }
}