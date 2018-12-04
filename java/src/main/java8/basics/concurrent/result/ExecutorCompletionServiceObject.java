package main.java8.basics.concurrent.result;

import java.util.concurrent.*;

/**
 * Title : main.java8.basics.concurrent <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/12/4 10:27
 */
public class ExecutorCompletionServiceObject {

    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService pools = Executors.newFixedThreadPool(5);
        CompletionService<Integer> s = new ExecutorCompletionService<Integer>(pools);

        //创建多个有返回值的任务
        for (int i = 0; i <= 10; i++) {
            s.submit(new Task(i));
        }
        for (int i = 0; i <= 10; i++) {
            try {
                Future<Integer> f = s.take();
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        pools.shutdown();
    }

}