import java.util.Arrays;


public class ProjectTest{
    public static void main(String [] args){
        Project project1 = new Project();
        Project project2 = new Project("My second project");
        Project project3 = new Project ("My third project","I love it!");
        Project project4 = new Project("My fourth project","The best project and last",100);

        System.out.println(project1.elevtorPitch());
        System.out.println(project2.elevtorPitch());
        System.out.println(project3.elevtorPitch());
        System.out.println(project4.elevtorPitch());

        project1.setName("Number One");
        System.out.println(project1.getName());
        project1.setDescription("Is my favorite");
        System.out.println(project1.getDescription());
        project1.setInitialCost(50);
        System.out.println(project1.getInitialCost());
        project2.setDescription("Amazing,no words!");
        project2.setInitialCost(200);
        project3.setInitialCost(250);

        Portofolio newPortofolio = new Portofolio();
        newPortofolio.addProject(project1);
        newPortofolio.addProject(project2);
        newPortofolio.addProject(project3);
        newPortofolio.addProject(project4);

        System.out.println(newPortofolio.getPortofolioCost());
        newPortofolio.showPortofolio();
    }
}