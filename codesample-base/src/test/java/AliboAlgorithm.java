

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;


public class AliboAlgorithm {


    @Test
    public void test1() throws InterruptedException {
        String[] arr = {"bella", "label", "roller"};

        for (int i = 0; i < 5; i++) {

            //      耗时1009
            System.err.println(getDuplicateChar1(arr));
//      耗时1001
            System.err.println(getDuplicateChar2(arr));
        }
    }

    public Set<Character> getDuplicateChar1(String[] arrays) throws InterruptedException {
        long startMs = System.currentTimeMillis();
        String minLengthString = Arrays.stream(arrays)
                .min(Comparator.comparingInt(String::length))
                .orElseThrow(IllegalArgumentException::new);
        Set<Character> allContainChar = new HashSet<>();
        for (int i = 0; i < minLengthString.length(); i++) {
            char c = minLengthString.charAt(i);

            List<String> otherStrings = Arrays.stream(arrays)
                    .filter(t -> minLengthString != t)
                    .collect(Collectors.toList());

            boolean allMatch = otherStrings.stream()
                    .allMatch(t -> {
                        for (int j = 0; j < t.length(); j++) {
                            if (t.charAt(j) == c) return true;
                        }
                        return false;
                    });

            if (allMatch) {
                allContainChar.add(c);
            }
        }
        Thread.sleep(1000);
        System.err.println(String.format("耗时%s", System.currentTimeMillis() - startMs));
        return allContainChar;
    }

    public Set<Character> getDuplicateChar2(String[] arrays) throws InterruptedException {
        long startMs = System.currentTimeMillis();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (String string : arrays) {
            for (int i = 0; i < string.length(); i++) {
                Integer defaultVal = map.getOrDefault(string.charAt(i), 0);
                ++defaultVal;
                map.put(string.charAt(i), defaultVal);
            }
        }

        Set<Character> characters = map.entrySet().stream()
                .filter(t -> t.getValue() >= arrays.length)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        Thread.sleep(1000);
        System.err.println(String.format("耗时%s", System.currentTimeMillis() - startMs));
        return characters;

    }

    private static class Node {
        Node pre;
        Node next;
        Integer value;

        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(String.valueOf(this.value));
            Node next = this.next;
            while (next != null) {
                if (next.value != null) {
                    sb.append("-").append(next.value);
                }
                next = next.next;
            }
            return sb.toString();

//            return String.valueOf(this.value);
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode node = this;
            StringBuilder sb = new StringBuilder();
            while (node != null) {
                sb.append("-").append(node.val);
                node = node.next;
            }
            return sb.toString();
//            return this.val + "";
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode second = null, first = head, pre = null;

        while (first != null && (second = first.next) != null) {

            first.next = second.next;
            second.next = first;

            first = first.next;
            second = first.next;

            if (pre != null) {
                pre.next = first;
            }
            pre = first;
        }
        return second;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs1(next.next);
        next.next = head;
        return next;
    }

    @Test
    public void testSwapPairs() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        System.err.println(swapPairs1(n1));
    }

    // 把一个大的问题进行拆解
}
