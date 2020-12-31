package org.codesample.base.algorithm.leetcode.alibaba;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @see Integer
 */
public class AddTwoNumbers {

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            Node node = this;
            StringBuilder sb = new StringBuilder();
            while (node != null) {
                sb.append("-").append(node.val);
                node = node.next;
            }
            return sb.toString();
        }
    }

    Node addTwoNumbers(Node n1, Node n2) {
        int n1Val = Integer.parseInt(getNodeIntVal(n1));
        int n2Val = Integer.parseInt(getNodeIntVal(n2));

        int sum = n1Val + n2Val;
        String numStr = String.valueOf(sum);

        Node[] nodes = new Node[numStr.length()];
        for (int i = numStr.length() - 1, j = 0; i >= 0; i--, j++)
            nodes[j] = new Node(Integer.parseInt(numStr.substring(i, i + 1)));

        Node head = nodes[0];
        Node node = head;
        for (int i = 1; i < nodes.length; i++) {
            node.next = nodes[i];
            node = nodes[i];
        }
        return head;
    }

    String getNodeIntVal(Node node) {
        if (node == null) return "";
        int val = node.val;
        return getNodeIntVal(node.next) + val;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);


        Node n5 = new Node(1);
        Node n6 = new Node(2);
        Node n7 = new Node(3);

        //
        n1.next = n2;
        n2.next = n3;

        n5.next = n6;
        n6.next = n7;

        System.err.println(new AddTwoNumbers().addTwoNumbers(n1, n5));
        System.err.println(new AddTwoNumbers().leetCodeAddTwoNumbers(n1, n5));
    }

    /**
     * LeetCode标准答案
     */
    public Node leetCodeAddTwoNumbers(Node l1, Node l2) {
        Node head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new Node(sum % 10);
            } else {
                tail.next = new Node(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new Node(carry);
        }
        return head;
    }

}
