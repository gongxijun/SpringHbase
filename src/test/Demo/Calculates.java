package Demo;

/**
 * *********************************************************
 * <p/>
 * Created with IntelliJ IDEA.
 *
 * @Package: Demo
 * @Author: XiJun.Gong(Vipgxjun@163.com)
 * @Date: 2016-07-26 11:59
 * @Version: default 1.0.0
 * @Class description：
 * <p/>
 * *********************************************************
 */

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.Arrays.asList;

public class Calculates {

    static class Sum implements Callable<Long> {
        private final long from;
        private final long to;

        public Sum(long from, long to) {
            this.from = from;
            this.to = to;
        }

        public Sum(BuilderSum builderSum) {
            this.from = builderSum.from;
            this.to = builderSum.to;
        }

        static class BuilderSum {

            private long from = 0;
            private long to = 0;

            public BuilderSum() {
            }

            public long getFrom() {
                return from;
            }

            public BuilderSum setFrom(long from) {
                this.from = from;
                return this;
            }

            public long getTo() {
                return to;
            }

            public BuilderSum setTo(long to) {
                this.to = to;
                return this;
            }

            public Sum builder() {
                return new Sum(this);
            }
        }


        @Override
        public Long call() {
            long acc = 0;
            for (long i = from; i <= to; i++) {
                acc = acc + i;
            }
            return acc;
        }
    }


    public static void main(String[] args) throws Exception {

        long startTime1 = System.nanoTime();   //获取开始时间
        long sum = 0;
        for (long i = 0; i <= 10000000; i++) {
            sum += i;
        }

        try {
            System.out.println(sum);
            long endTime1 = System.nanoTime();
            System.out.println("程序运行时间： " + (endTime1 - startTime1) + "ns");
        } catch (Exception e) {
            e.printStackTrace();
        }

        long startTime = System.nanoTime();   //获取开始时间
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<Long>> results;
        results = executor.invokeAll(asList(
                new Sum(1, 10), new Sum(11, 100), new Sum(101, 1000), new Sum(1001, 10000),
                new Sum(10001, 100000), new Sum(100001, 1000000), new Sum(1000001, 10000000)
        ));

        executor.shutdown();
        long ans = 0;
        for (Future<Long> result : results) {
            ans += result.get();
        }

        System.out.println(ans);
        long endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }
}


