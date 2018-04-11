package main.algorithm.a.jian.zhi.offer;

import java.util.Objects;
import java.util.Stack;

import static java.lang.System.out;

/**
 * Title : main.algorithm.a.jian.zhi.offer <br>
 * Description : <br>
 *
 * 输入链表的第一个节点，从尾到头反过来打印出每个结点的值。
 *
 * @author chile
 * @version 1.0
 * @date 2018/4/11 15:05
 */
public class PrintListBackwards {

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;
        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node<Integer> n0 = new Node<>(null, 0, null);
        Node<Integer> n1 = new Node<>(null, 1, null);
        Node<Integer> n2 = new Node<>(null, 2, null);
        Node<Integer> n3 = new Node<>(null, 3, null);
        Node<Integer> n4 = new Node<>(null, 4, null);
        Node<Integer> n5 = new Node<>(null, 5, null);

        n0.next = n1;
        n1.prev = n0;
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;

        method1(n0);
    }

    private static void method1(Node<Integer> node) {
        Node<Integer> tempNode = node;
        Stack<Node> stack = new Stack<>();
        while (Objects.nonNull(tempNode.next)) {
            stack.add(tempNode);
            tempNode = tempNode.next;
        }
        while (!stack.isEmpty()) {
            out.print(stack.pop().item);
        }
    }


}
