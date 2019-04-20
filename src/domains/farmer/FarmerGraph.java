package domains.farmer;

import framework.graph.Graph;
import framework.graph.Vertex;

/**
 * A graph for the FWGC problem.
 * @author Your name and section here
 */
public class FarmerGraph extends Graph {
    
    public FarmerGraph() {
       
        
        
        v1 = 
                new Vertex(new FarmerState("West",
                                           "West",
                                           "West",
                                           "West"));
        
        v2 = 
                new Vertex(new FarmerState("West",
                                           "East",
                                           "West",
                                           "East"));
        v3 = 
                new Vertex(new FarmerState("West",
                                           "East",
                                           "West",
                                           "West"));
        v4 = 
                new Vertex(new FarmerState("West",
                                           "West",
                                           "East",
                                           "West"));
        v5 = 
                new Vertex(new FarmerState("West",
                                           "West",
                                           "West",
                                           "East"));
        v6 = 
                new Vertex(new FarmerState("East",
                                           "East",
                                           "East",
                                           "East"));
        v7 = 
                new Vertex(new FarmerState("East",
                                           "West",
                                           "East",
                                           "West"));
        v8 = 
                new Vertex(new FarmerState("East",
                                           "West",
                                           "East",
                                           "East"));
        v9 = 
                new Vertex(new FarmerState("East",
                                           "East",
                                           "West",
                                           "East"));
        v10 = 
                new Vertex(new FarmerState("East",
                                           "East",
                                           "East",
                                           "West"));
        
       
        
        
        
        graph.addEdge(v7,v4);
        
        graph.addEdge(v4,v10);
        
        graph.addEdge(v4,v8);
        
        graph.addEdge(v10,v3);
        
        graph.addEdge(v8,v5);
        
        graph.addEdge(v5,v9);
        
        graph.addEdge(v3,v9);
        
        graph.addEdge(v9,v2);
        
        graph.addEdge(v2,v6);
        
        
        
    }
    
    public Vertex getStart() {
        return v1;
    }
    
    public Vertex getEnd() {
        return v6;
    }
    
    Vertex v1,v2,v3,v4,v5,v6,v7,v8,v9,v10;
    Graph graph = new Graph();
    
}