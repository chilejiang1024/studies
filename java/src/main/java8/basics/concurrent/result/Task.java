package main.java8.basics.concurrent.result;

import java.util.concurrent.Callable;

/**
 * Title : main.java8.basics.concurrent.result <br>
 * Company : 北京华宇元典信息服务有限公司 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/12/4 10:33
 */
public class Task implements Callable<Integer> {
    private Integer taskID;

    Task(Integer taskID) {
        this.taskID = taskID;
    }

    @Override
    public Integer call() throws Exception {
        if (taskID.equals(3)) {
            Thread.sleep(10000);
        }
        System.out.println("任务[" + taskID + "]开始执行");
        return taskID;
    }
}