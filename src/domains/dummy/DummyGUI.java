package domains.dummy;

import framework.ui.ProblemGUI;

public class DummyGUI extends ProblemGUI {
    
    public DummyGUI(){
        super(new DummyProblem(), 900, 1000);
    }
}