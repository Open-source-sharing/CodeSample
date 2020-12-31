package org.opensource.codesample.redlock;

import java.util.*;

public class Main {

    private static char[] yuanyinChars = {
            'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
    };

    static class Node {
        String subString;
        int degree;

        Node(String subString, int degree) {
            this.subString = subString;
            this.degree = degree;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loop = 0;

        String inputString = null;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            if (loop == 0) {
                int expectDegree = Integer.parseInt(line);
            } else if (loop == 1) {
                inputString = line;
                break;
            }
            ++loop;
        }

        int length = inputString.length();
        List<Integer> stringsLength = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > 0; j--) {
                // Not include end char
                String subString = inputString.substring(i, j + 1);

                boolean startYuanyinChar = false;
                boolean endYuanyinChar = false;

                for (char yuanyinChar : yuanyinChars) {
                    if (subString.indexOf(0) == yuanyinChar) {
                        startYuanyinChar = true;
                    }
                    if (subString.indexOf(subString.length() - 1) == yuanyinChar) {
                        endYuanyinChar = true;
                    }
                }

                /*int degree = 0;*/
                if (startYuanyinChar && endYuanyinChar) {
                   /* for (int k = 1; k < subString.length() - 1; k++) {
                        for (char yuanyinChar : yuanyinChars)
                            if (subString.indexOf(k) != yuanyinChar) ++degree;
                    }*/
                    stringsLength.add(subString.length());
                }
            }
        }

        Integer result = stringsLength.stream().max(Comparator.naturalOrder()).orElse(0);
        System.out.println(result);
    }
}
