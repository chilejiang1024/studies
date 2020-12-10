package main.design.pattern.adapter.example1;

/**
 * Title : main.design.pattern.adapter.example1 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/12/10 11:08
 */
public class BigDrillBit implements IDrillBit {

    /**
     * drill a hole, size is {#size}
     * @param size
     */
    @Override
    public void drill(int size) {
        System.out.println("drill big hole! size : " + size);
    }
}
