public class Employee {
    private String name;
    private String gender;

    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void printDepartment(){
        System.out.println(name+"'s department is "+department.getName());
    }
}
