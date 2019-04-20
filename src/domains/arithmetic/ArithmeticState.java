/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.arithmetic;

import framework.problem.State;
import java.util.stream.Stream;

/**
 *
 * @author jonkl
 */
public class ArithmeticState implements State {
    
    public ArithmeticState(int contents) {
            this.contents = contents;
            String stringContents = (String) Integer.toString(contents);
            this.strcontents = ("The value is: " + stringContents);
            
        }

   
     
     public int getContents(){
        return contents;
    }
        @Override
     public boolean equals(Object other) {
           ArithmeticState otherArith = (ArithmeticState) other;
           
           return (this.strcontents.equals(otherArith.strcontents));
        }

    @Override
     public String toString() {
         
         String[] lines = strcontents.split("/");
            Stream<Integer> lengths = Stream.of(lines).map(String::length);
            int maxLength = lengths.max(Integer::compare).get();

            StringBuilder sb = new StringBuilder();
            addDashes(sb, maxLength + 2);
            sb.append(NEW_LINE);
            for (String line : lines) {
                sb.append("| ");
                sb.append(String.format("%1$-" + maxLength + "s", line));
                sb.append(" |");
                sb.append(NEW_LINE);
            }
            addDashes(sb, maxLength + 2);
            return sb.toString();
     }
        private void addDashes(StringBuilder sb, int n) {
            sb.append("+");
            for (int i = 0; i < n; i++) {
                sb.append("-");
            }
            sb.append("+");
        }

       
        private final int contents;
        private final String strcontents;
        private static final String NEW_LINE = "\n";
    }

