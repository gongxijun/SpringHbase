
import java.util.Scanner;

/**
 * author: 龚细军
 * class-aim:
 */


class Node {
    public int key, size;
    public Node left, right;

    public Node() {
        this.size = 0;
        this.left = null;
        this.right = null;
    }

    public void clone(Node node) {
        this.key = node.key;
        this.size = node.size;
        this.left = node.left;
        this.right = node.right;
    }
}

public class Main3 {
    private static final int DEFAULT_INITIAL_CAPACITY = 1;

    public static int getSize(Node node) {
        return node == null ? 0 : node.size;
    }

    public static int compare(Node a, int key) {
        return a.key - key;
    }

    public static void update(Node node) {
        if (node == null) return;
        node.size = getSize(node.left) + getSize(node.right) + 1;
    }

    public static void rightRotate(Node master, Node node) {
        Node newNode = new Node();
        newNode.clone(master);
        newNode.left = node.right;
        node.right = newNode;
        update(newNode);
        update(node);
        master.clone(node);
    }

    public static void leftRotate(Node master, Node node) {
        Node tmpNode = new Node();
        tmpNode.clone(master);
        tmpNode.right = node.left;
        node.left = tmpNode;
        update(tmpNode);
        update(node);
        master.clone(node);
    }

    public static void insert(Node master, int key) {

        if (master.size == 0) {
            master.left = new Node();
            master.right = new Node();
            master.size = DEFAULT_INITIAL_CAPACITY;
            master.key = key;
        } else if (compare(master, key) > 0) {
            insert(master.left, key);
            if (getSize(master.left.left) > getSize(master.right)) {
                //右旋转
                rightRotate(master, master.left);
            }
        } else {
            insert(master.right, key);
            if (getSize(master.right.right) > getSize(master.left)) {
                //左旋转
                leftRotate(master, master.right);
            }
        }

        update(master);

    }

    private static int abs(int flag) {
        return flag > 0 ? flag : -1 * flag;
    }

    public static int query(Node node, int kMin) {

        int flag = node.left.size - kMin + 1;
        if (flag == 0) return node.key;
        if (flag < 0) return query(node.right, abs(flag));
        return query(node.left, kMin);
    }

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
                if (cmd.equals("I"))
                    Main3.insert(root, val);
                else
                    System.out.println(Main3.query(root, val));
            }
        }
    }
}

