package main.java8.basics.traversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;

/**
 * Title : main.java8.basics.traversal <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/4/10 14:14
 */
public class ListTraversal {

    public static void main(String[] args) {

        // 1. ArrayList
        // for(), foreach and iterator almost the same, all good to use
        List<Integer> intList = new ArrayList<>();
        intList.add(0);
        intList.add(1);
        intList.add(2);
        intList.add(3);
        // for()
        for (int i = 0, j = intList.size(); i < j; i++) {
            out.println(intList.get(i));
        }
        // foreach
        for (Integer i : intList) {
            out.println(i);
        }
        // iterator
        Iterator<Integer> iterator = intList.iterator();
        while (iterator.hasNext()) {
            out.println(iterator.next());
        }

        // 2. LinkedList
        // foreach and iterator is better
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        // foreach
        for (Integer i : linkedList) {
            out.println(i);
        }
        // iterator
        Iterator<Integer> linkedListIterator = linkedList.iterator();
        while (linkedListIterator.hasNext()) {
            out.println(linkedListIterator.next());
        }

    }

}
