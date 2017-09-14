package model.pojo;

public class ProjectDetailsPOJO {
    
    private String projectnumber;
    private String projectname;
    
    public ProjectDetailsPOJO() {
        super();
    }

    public ProjectDetailsPOJO(String projectnumber, String projectname) {
        super();
        this.projectnumber = projectnumber;
        this.projectname = projectname;
    }

    public void setProjectnumber(String projectnumber) {
        this.projectnumber = projectnumber;
    }

    public String getProjectnumber() {
        return projectnumber;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectname() {
        return projectname;
    }
}
