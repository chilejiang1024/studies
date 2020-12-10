package main.design.pattern.adapter.example1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Title : main.design.pattern.adapter.example1 <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/12/10 11:06
 */
public class DrillBitHolder {

    private static final Map<Integer, IDrillBit> DRILL_BIT_CACHE;

    private static final Map<Integer, Class<? extends IDrillBit>> DRILL_CLASS_HOLDER;


    static {
        DRILL_BIT_CACHE = new ConcurrentHashMap<>(16);
        DRILL_CLASS_HOLDER = new HashMap<>(16);
        DRILL_CLASS_HOLDER.put(1, SmallDrillBit.class);
        DRILL_CLASS_HOLDER.put(10, BigDrillBit.class);
    }

    public static IDrillBit getDrillBit(int size) {
        if (size <= 0) {
            return null;
        }
        IDrillBit drillBit = DRILL_BIT_CACHE.get(size);
        if (drillBit == null) {
            Class<? extends IDrillBit> drillClass = DRILL_CLASS_HOLDER.get(size);
            if (drillClass == null) {
                throw new RuntimeException("no such size drill bit");
            }
            try {
                IDrillBit drillBitImpl = drillClass.newInstance();
                DRILL_BIT_CACHE.put(size, drillBitImpl);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return DRILL_BIT_CACHE.get(size);
    }

}
