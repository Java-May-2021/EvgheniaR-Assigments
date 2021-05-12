import java.util.ArrayList;

public class Portofolio{
    ArrayList<Project> projects = new ArrayList<Project>();
    public Portofolio(){
    }
    public void addProject(Project myProject){
        this.projects.add(myProject);
    }
    public double getPortofolioCost(){
        double sum = 0;
        for(Project project : this.projects){
            sum += project.getInitialCost();
        }
        return sum;
    }
    public void showPortofolio(){
        for(Project project: this.projects){
            System.out.println(project.elevtorPitch());
        }
        System.out.println("The total cost is: $" + this.getPortofolioCost());
    }
}