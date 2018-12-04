package main.java8.basics.concurrent.result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Title : main.java8.basics.concurrent <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/3/30 13:40
 */
public class FutureObject {

    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService pools = Executors.newFixedThreadPool(5);
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        //创建多个有返回值的任务
        for (int i = 0; i <= 10; i++) {
            Future<Integer> futures = pools.submit(new Task(i));
            list.add(futures);
        }
        for (Future<Integer> f : list) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        pools.shutdown();
    }
}


