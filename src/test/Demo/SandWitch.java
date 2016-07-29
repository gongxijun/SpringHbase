package Demo;

/**
 * *********************************************************
 * <p/>
 * Created with IntelliJ IDEA.
 *
 * @Package: Demo
 * @Author: XiJun.Gong
 * @Date: 2016-07-25 11:32
 * @Class description:
 * <p/>
 * *********************************************************
 */
//: Sandwich.java
// Order of constructor calls
class Meal {
    Meal() { System.out.println("Meal()"); }
}
class Bread {
    Bread() { System.out.println("Bread()"); }
}
class Cheese {
    Cheese() { System.out.println("Cheese()"); }
}
class Lettuce {
    Lettuce() { System.out.println("Lettuce()"); }
}
class Lunch extends Meal {
    Lunch() { System.out.println("Lunch()");}
}
class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}
class Sandwich extends PortableLunch {

    Cheese c = new Cheese();
    Bread b = new Bread();
    Lettuce l = new Lettuce();
    Sandwich() {
        System.out.println("Sandwich()");
    }
    public static void main(String[] args) {
        new Sandwich();
    }
} ///:~
