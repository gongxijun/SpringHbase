/*
import java.util.Scanner;

*/
/**
 * author: 龚细军
 * class-aim:
 *//*


class Node {
    public Integer key;
    public long size;
    public Node left;
    public Node right;

    public Node() {
        size = 0;
        key = null;
        left = right = null;
    }
}

*/
/*二叉排序树,此题不需要调解平衡*//*

class BSTree {
    private static final int DEFAULT_INITIAL_CAPACITY = 1;

    public static int query(Node node, int kMin) {
        Long flag = node.left.size - kMin + 1;
        if (flag == 0) return node.key;
        if (flag < 0) return query(node.right, (int) abs(flag));
        return query(node.left, kMin);
    }

    private static long abs(Long flag) {
        return flag > 0 ? flag : -1 * flag;
    }

    public static void insert(Node node, int data) {
        if (node.size > 0) {
            node.size++;
            insert(data > node.key ? node.right : node.left, data);
        } else {
            node.key = data;
            node.size = DEFAULT_INITIAL_CAPACITY;
            node.left = new Node();
            node.right = new Node();
        }
    }

}


class SBTree {
    private static final int DEFAULT_INITIAL_CAPACITY = 1;

    public static int query(Node node, int kMin) {
        Long flag = node.left.size - kMin + 1;
        if (flag == 0) return node.key;
        if (flag < 0) return query(node.right, (int) abs(flag));
        return query(node.left, kMin);
    }

    private static long abs(Long flag) {
        return flag > 0 ? flag : -1 * flag;
    }

    //旋转

    public static void insert(Node node, int data) {
        if (node.size > 0) {
            node.size++;
            insert(data > node.key ? node.right : node.left, data);
        } else {
            node.key = data;
            node.size = DEFAULT_INITIAL_CAPACITY;
            node.left = new Node();
            node.right = new Node();
        }
    }

}

public class Main1 {

    public static void main(String args[]) {
        int num, val;
        String cmd;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            num = scanner.nextInt();
            Node root = new Node();
            while (num-- > 0) {
                cmd = scanner.next();
                val = scanner.nextInt();
                if (cmd.equals("I")) BSTree.insert(root, val);
                else {
                    System.out.println(BSTree.query(root, val));
                }
            }
        }
    }

}


*/
