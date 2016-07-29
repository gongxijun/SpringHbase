package Demo;

/**
 * *********************************************************
 * <p/>
 * Created with IntelliJ IDEA.
 *
 * @Package: Demo
 * @Author: XiJun.Gong
 * @Date: 2016-07-25 11:59
 * @Class description:
 * <p/>
 * *********************************************************
 */
//: Inheriting.java
// Inheriting your own exceptions
class MyException extends Exception {
    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}

public class Inheriting {
       public static void f() throws MyException1 {

        System.out.println(
                "Throwing MyException from f()");
        throw new MyException1();
    }

    public static void g() throws MyException1 {
        System.out.println(
                "Throwing MyException from g()");
        throw new MyException1("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException1 e) {
            e.printStackTrace();
        }
        try {
            g();
        } catch (MyException1 e) {
            e.printStackTrace();
        }
    }
} ///:~