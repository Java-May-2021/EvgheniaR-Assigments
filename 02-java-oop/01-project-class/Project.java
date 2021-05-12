public class Project{
    private String name;
    private String description;
    private double initialCost;

    public String elevtorPitch(){
        return (name + "(" + initialCost+"),"+ description);
    }
    public Project(){
    }
    public Project(String name){
        this.name = name;
    }
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Project(String name, String description, double cost){
        this.name = name;
        this.description = description;
        this.initialCost = cost;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Double getInitialCost(){
        return initialCost;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setInitialCost(double cost){
        this.initialCost = cost;
    }
}