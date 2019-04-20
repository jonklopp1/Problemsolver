package framework.problem;


import framework.problem.State;


public class Benchmark {
        public Benchmark(State state,State goal,String name){
            this.state = state;
            this.name = name;
            this.goal = goal;
        }
        
        public State getGoal(){
            return this.goal;
        }
        
        public State getState(){
            return this.state;
        }
        
        
        
        @Override
        public String toString(){
            return this.name;
        }
        private State goal;
        private State state;
        private String name;
    }
    
   