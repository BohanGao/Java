import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
    public static void main(String[] args) {
        //load spring config
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //get instance created by spring context
//        User user = context.getBean("user", User.class);
//
//        System.out.println(user);
//        user.add();
        //testUserService();
        //testEmployeeInner();
        //testEmployeeCascading();
        //testCollectionGeneral();
        //testCollectionObject();
        //testUtilExtraction();
        testFactoryBean();
    }

    private static void testUserService(){
        //load spring config
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_userdao.xml");

        UserService userService = context.getBean("userService", UserService.class);

        userService.add();
    }

    private static void testEmployeeInner(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_employee_inner.xml");

        Employee employee = context.getBean("employee", Employee.class);

        employee.printDepartment();
    }

    private static void testEmployeeCascading(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_employee_cascading.xml");

        Employee employee = context.getBean("employee", Employee.class);

        employee.printDepartment();
    }

    private static void testCollectionGeneral(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_collection_general.xml");

        MyCollectionGeneral myCollectionGeneral = context.getBean("myCollectionGeneral", MyCollectionGeneral.class);

        myCollectionGeneral.print();
    }

    private static void testCollectionObject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_collection_object.xml");

        Student student = context.getBean("student", Student.class);

        student.printCourses();
    }

    private static void testUtilExtraction(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_extract.xml");

        Roster roster = context.getBean("roster", Roster.class);

        roster.printPlayers();
    }

    private static void testFactoryBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_factory.xml");

        Course course = context.getBean("myFactoryBean", Course.class);

        System.out.println(course);
    }
}
