package Demo;

/**
 * *********************************************************
 * <p/>
 * Created with IntelliJ IDEA.
 *
 * @Package: Demo
 * @Author: XiJun.Gong(Vipgxjun@163.com)
 * @Date: 2016-07-26 19:51
 * @Version: default 1.0.0
 * @Class description：
 * <p/>
 * *********************************************************
 */

public class MyException1 extends Exception {

    private static final long serialVersionUID = 6700697376100628473L;

    public MyException1() {
        super();
    }

    public MyException1(String msg) {
        super(msg);
    }
}
