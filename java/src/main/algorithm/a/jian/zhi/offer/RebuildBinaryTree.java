package main.algorithm.a.jian.zhi.offer;

/**
 * Title : main.algorithm.a.jian.zhi.offer <br>
 * Description : <br>
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 *             1
 *            ╱ ╲
 *           2   3
 *          ╱   ╱ ╲
 *         4   5   6
 *        ╱       ╱
 *       7       8
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018-4-12 22:11:27
 */
public class RebuildBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in  = {4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(pre, in);
    }

    /**
     * According to the preorder and inorder traversal result, rebuild the binary tree
     * @param pre preorder traversal result
     * @param in  inorder traversal result
     * @return    the root node of the binary tree
     */
    private static TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        return null;
    }

}
