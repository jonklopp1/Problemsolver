/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.farmer;
import framework.problem.State;
import java.util.Objects;
import java.util.stream.Stream;
/**
 *
 * @author jonkl
 */
public class FarmerState implements State {
   
    public FarmerState(String farmer, String wolf, String goat, String cabbage){
       
         fPos = farmer;
         wPos = wolf;
         gPos = goat;
         cPos = cabbage;
        
        
    }
    public String getfPos(){
        return fPos;
    }
    
    public String getwPos(){
        return wPos;
    }
    
    public String getgPos(){
        return gPos;
    }
    
    public String getcPos(){
        return cPos;
    }
   
    
    @Override
    public boolean equals(Object other){
        
        if(this == other){
            return true;
        }
        
        
        FarmerState otherFarmer = (FarmerState) other;
        
        
        if (otherFarmer == null)
            return false;
        
        return fPos == otherFarmer.fPos &&
                wPos == otherFarmer.wPos &&
                gPos == otherFarmer.gPos &&
                cPos == otherFarmer.cPos;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.fPos);
        hash = 11 * hash + Objects.hashCode(this.wPos);
        hash = 11 * hash + Objects.hashCode(this.gPos);
        hash = 11 * hash + Objects.hashCode(this.cPos);
        return hash;
    }
    
    @Override
    public String toString(){
         strcontents = "   |  |   \n";
        if ( fPos == "West"){
             strcontents += " F |  |   \n";
        }else{
             strcontents += "   |  | F \n";
        }
        if ( wPos == "West"){
             strcontents += " W |  |   \n";
        }else{
             strcontents += "   |  | W \n";
        }
        if ( gPos == "West"){
             strcontents += " G |  |   \n";
        }else{
             strcontents += "   |  | G \n";
        }
        if ( cPos == "West"){
             strcontents += " C |  |   \n";
        }else{
             strcontents += "   |  | C \n";
        }
         strcontents +="   |  |   ";
         
         
         
        return strcontents;
    }
    
    
    private String strcontents;
    private final String fPos;
    private final String wPos;
    private final String gPos;
    private final String cPos;
}
