import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class Node {
        int A;
        int[] B;
        int bLastIndex = 0;

        Node(int a, int bLength) {
            A = a;
            B = new int[bLength];
        }

        void add(int ele) {
            B[bLastIndex++] = ele;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loop = 0;
        int m = 0, n = 0, R = 0;
        int[] A = null, B = null;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            String[] strings = line.split("\\W+");
            if (loop == 0) {
                m = Integer.parseInt(strings[0]);
                n = Integer.parseInt(strings[1]);
                R = Integer.parseInt(strings[2]);
            } else if (loop == 1) {
                A = new int[strings.length];
                for (int i = 0; i < strings.length; i++) {
                    A[i] = Integer.parseInt(strings[i]);
                }
            } else if (loop == 2) {
                B = new int[strings.length];
                for (int i = 0; i < strings.length; i++) {
                    B[i] = Integer.parseInt(strings[i]);
                }
            }
            if (loop == 2) break;
            ++loop;
        }
        scanner.close();

        Node[] matchConditionEles = new Node[m];
        int index = 0;

        for (int item : A) {
            for (int value : B) {
                if (item <= value && Math.abs(item - value) < R) {
                    boolean existAExist = false;
                    for (Node matchConditionEle : matchConditionEles) {
                        if (matchConditionEle != null && matchConditionEle.A == item) {
                            matchConditionEle.add(value);
                            existAExist = true;
                        }
                    }
                    if (!existAExist) {
                        Node node = new Node(item, n);
                        matchConditionEles[index++] = node;
                        node.add(value);
                    }
                }
            }
        }

        String result = Arrays.stream(matchConditionEles)
                .filter(Objects::nonNull)
                .sorted(new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        return o1.A - o2.A;
                    }
                })
                .map(node -> {
                    int minEle = Arrays.stream(node.B).sorted().findFirst().orElse(0);
                    return node.A + " " + minEle;
                })
                .collect(Collectors.joining("\n"));

        System.err.println(result);

    }

}
