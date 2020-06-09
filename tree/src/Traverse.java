import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: AlgorithmProject.PACKAGE_NAME.Traverse
 * @description: 二叉树遍历技术
 * @author: Ruipeng
 * @create: 2020/6/1 2:46
 */
public class Traverse {
    /**
     * @Description: 节点数据结构
     * @Param:
     * @return:
     * @Author: Ruipeng
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * @Description: 初始化树
     * @Param: [inputList]
     * @return: Traverse.TreeNode
     * @Author: Ruipeng
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * @Description: 二叉树前序遍历
     * @Param: [node]
     * @return: void
     * @Author: Ruipeng
     */
    public static void preOrderTraver(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraver(node.leftChild);
        preOrderTraver(node.rightChild);
    }

    /**
     * @Description: 二叉树中序遍历
     * @Param: [node]
     * @return: void
     * @Author: Ruipeng
     */
    public static void inOrderTraver(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraver(node.leftChild);
        System.out.println(node.data);
        inOrderTraver(node.rightChild);
    }

    /**
     * @Description: 二叉树后序遍历
     * @Param: [node]
     * @return: void
     * @Author: Ruipeng
     */
    public static void postOrderTraver(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraver(node.leftChild);
        postOrderTraver(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * @Description: 使用栈进行二叉树的前序遍历
     * @Param: [root]
     * @return: void
     * @Author: Ruipeng
     */
    public static void preOrderTraverWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * @Description: 非递归方式实现二叉树的中序遍历
     * @Param: [root]
     * @return: void
     * @Author: Ruipeng
     */
    public static void inOrderTraverWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.data);
                node = node.rightChild;
            }
        }
    }

    /**
     * @Description: 非递归方式实现二叉树的后序遍历
     * @Param: [head]
     * @return: void
     * @Author: Ruipeng
     */
    public static void posOrderUnRecur1(TreeNode head) {
        System.out.print("PosOrder:");
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.leftChild != null) {
                    s1.push(head.leftChild);
                }
                if (head.rightChild != null) {
                    s1.push(head.rightChild);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().data + " ");
            }
        }
        System.out.println();
    }

    public static void levelOrderTraver(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }


    public static void main(String[] args) {
//        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null));
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(1, 2, 4, null, null, 5, null, null, 3, null, 6, null, null));
//        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode rootNode = createBinaryTree(inputList);
        System.out.println("前序遍历：");
        preOrderTraver(rootNode);
        System.out.println("中序遍历：");
        inOrderTraver(rootNode);
        System.out.println("后序遍历：");
        postOrderTraver(rootNode);

        System.out.println("非递归方式");
        System.out.println("前序遍历");
        preOrderTraverWithStack(rootNode);
        System.out.println("中序遍历");
        inOrderTraverWithStack(rootNode);
        System.out.println("后序遍历：");
        posOrderUnRecur1(rootNode);

        System.out.println("层序遍历");
        levelOrderTraver(rootNode);
    }


}
