package main.design.pattern.adapter.example1;

/**
 * Title : main.design.pattern.adapter.example1 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/12/10 11:22
 */
public class Drill {

    public Drill() {
        super();
    }

    public void drill(int size) {
        IDrillBit drillBit = DrillBitHolder.getDrillBit(size);
        if (drillBit == null) {
            System.out.println("drill bit not found");
            throw new RuntimeException("drill bit not found");
        }
        drillBit.drill(size);
    }

}
