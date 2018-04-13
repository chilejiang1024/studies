package main.data.structure;

import org.jetbrains.annotations.NotNull;

import java.util.Stack;

import static java.lang.System.out;

/**
 * Title : main.data.structure <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/4/13 14:38
 */
public class OrdinaryBinaryTree {

    static class Node {
        int value;
        Node left;
        Node right;
        Node(int x) {
            this.value = x;
        }
    }

    public static void main(String[] args) {

        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }

        /*
         *            0
         *          ╱   ╲
         *         1     6
         *        ╱ ╲   ╱ ╲
         *       2   5 7   8
         *      ╱ ╲         ╲
         *     3   4         9
         *
         *   preorder  : 0123456789
         *   inorder   : 3241507689
         *   postorder : 1234567890
         */
        // build test binary tree
        nodes[0].left = nodes[1];
        nodes[1].left = nodes[2];
        nodes[2].left = nodes[3];
        nodes[6].left = nodes[7];
        nodes[0].right = nodes[6];
        nodes[1].right = nodes[5];
        nodes[2].right = nodes[4];
        nodes[6].right = nodes[8];
        nodes[8].right = nodes[9];

        // play with it
        Node rootNode = nodes[0];

        recursivePreorderTraversal(rootNode);
        out.println();
//        recursiveInorderTraversal(rootNode);
//        out.println();
//        recursivePostorderTraversal(rootNode);
//        out.println();
        preorderTraversal(rootNode);
        out.println();
    }


    private static void recursivePreorderTraversal(Node root) {
        if (null != root) {
            out.print(root.value);
            recursivePreorderTraversal(root.left);
            recursivePreorderTraversal(root.right);
        }
    }

    private static void recursiveInorderTraversal(Node root) {
        if (null != root) {
            recursiveInorderTraversal(root.left);
            out.print(root.value);
            recursiveInorderTraversal(root.right);
        }
    }

    private static void recursivePostorderTraversal(Node root) {
        if (null != root) {
            recursivePreorderTraversal(root.left);
            recursivePreorderTraversal(root.right);
            out.print(root.value);
        }
    }

    private static void preorderTraversal(Node root) {
        Stack<Node> s = new Stack<>();
        Node p = root;
        while (null != p || !s.isEmpty()) {
            out.print(p.value);
            if (null != p.left) {
                s.push(p);
                p = p.left;
            } else if (!s.isEmpty()){
                p = s.pop().right;
                while (null == p && !s.isEmpty()) {
                    p = s.pop().right;
                }
            } else {
                p = p.right;
            }

        }
    }

}
