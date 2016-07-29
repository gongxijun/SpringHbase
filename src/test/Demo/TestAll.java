package Demo;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * author: 龚细军
 * class-aim:
 */
public class TestAll {

    @Test
    public void testOrange() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new
                ClassPathXmlApplicationContext("Demo/Orange.xml");
        Orange orange = (Orange) classPathXmlApplicationContext.getBean("orangeId");
        orange.display();
    }

}
