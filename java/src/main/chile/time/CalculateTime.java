package main.chile.time;

/**
 * Title : main.chile.time
 * Description :
 *  - 计算一个方法执行所用的时间
 *  -  
 *
 * @author main.chile
 * @version 1.0
 * @date 2017/5/12 13:46
 */
public class CalculateTime {

    public static void main(String[] args) throws Exception {
        long begin = System.currentTimeMillis();

        // the method that be calculate

        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("程序执行共耗时 : " + time + "ms");
    }

}
