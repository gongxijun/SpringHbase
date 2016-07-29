package Demo;

/**
 * *********************************************************
 * <p/>
 * Created with IntelliJ IDEA.
 *
 * @Package: Demo
 * @Author: XiJun.Gong
 * @Date: 2016-07-25 13:59
 * @Class description:
 * <p/>
 * *********************************************************
 */
//: LostMessage.java
// How an exception can be lost
class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }

}

class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}

public class LostMessage {
    private final int age;
    private final String sex;

    static class Builder {
        private final String sex;
        private int age = 21;

        public Builder(String sex) {
            this.sex = sex;
        }

        public Builder setAge(int val) {
            age = val;
            return this;
        }

        public LostMessage build() {
            return new LostMessage(this);
        }

    }

    public LostMessage(Builder builder) {
        sex = builder.sex;
        age = builder.age;
    }

    public void disPlay() {
        System.out.println(this.age + this.sex);
    }

    public static void main(String args[]) {
        LostMessage lostMessage = new LostMessage.Builder("男").setAge(23).build();
        lostMessage.disPlay();
    }
} ///:~
