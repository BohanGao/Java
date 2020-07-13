import java.util.List;

public class Student {
    private List<Course> courses;

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void printCourses(){
        System.out.println(courses);
    }
}
