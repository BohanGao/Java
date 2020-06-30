import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
    public static void main(String[] args) {
        //load spring config
        ApplicationContext context = new ClassPathXmlApplicationContext("userBean.xml");

        //get instance created by spring context
        User user = context.getBean("user", User.class);

        System.out.println(user);
        user.add();
    }
}
