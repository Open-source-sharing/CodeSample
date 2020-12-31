package org.codesample.base;


public class ForeachWhile {



    /**
     * After Compile
     *
     *    public static void main(String[] args) {
     *         int i;
     *         for(i = 0; i < 2; ++i) {
     *             System.err.println(i);
     *         }
     *
     *         for(i = 0; i < 2; ++i) {
     *             System.err.println(i);
     *         }
     *
     *         i = 0;
     *
     *         do {
     *             System.err.println(i);
     *             ++i;
     *         } while(i < 2);
     *
     *     }
     *
     *
     * @param args args
     */
    public static void main(String[] args) {
        int i;
        for (i = 0; i < 2; i++) {
            System.err.println(i);
        }

        i = 0;
        while (i < 2) {
            System.err.println(i);
            ++i;
        }

        i = 0;
        do {
            System.err.println(i);
            ++i;
        } while (i < 2);
    }


}
