package main.design.pattern.adapter.example1;

/**
 * Title : main.design.pattern.adapter.example1 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/12/10 11:05
 */
public class Test {

    public static void main(String[] args) {
        Drill drill = new Drill();
        drill.drill(1);
        drill.drill(10);
        drill.drill(5);
    }

}
