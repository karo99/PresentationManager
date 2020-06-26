package application;

public class Checkpoint {
    private String title;
    private String description;

    public Checkpoint(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String newDescription){
        this.description = newDescription;
    }
}
