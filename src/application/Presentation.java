package application;

import java.util.ArrayList;

public class Presentation {
    String name;
    ArrayList<Checkpoint> checkpointList;

    public Presentation(String name){
        this.checkpointList = new ArrayList<Checkpoint>();
        //this.checkpointList.add(new Checkpoint("tyt", "des"));
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public ArrayList<Checkpoint> getCheckpointList(){
        return this.checkpointList;
    }

    public void updateCheckpointList(ArrayList<Checkpoint> checkpointList ){
        this.checkpointList = checkpointList;
    }


}
