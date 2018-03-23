package main.java8.study.of.jdk.map.hashmap;

/**
 * Title : main.java8.study.of.jdk.map.hashmap <br>
 * Description :
 *  <p> A instruction of method {@link java.util.HashMap#tableSizeFor(int)}
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/3/20 16:49
 */
public class MethodTableSizeFor {

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * Returns a power of two size for the given target capacity.
     *
     * <p> An ingenious method.
     *
     * <p> What does this method do?
     * <p> An number of int type, in binary string always looks like <br>
     *     0000 0000 0000 0000 1xxx xxxx xxxx xxxx <br>
     *     This method makes all of the `x` equals to 1.
     *
     * <p> How does this method work?
     * <p> <code>n |= n >>> x</code>
     *     hahaha
     *     Not explained, could only be unspeakable.
     *     ^_^
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }



}
