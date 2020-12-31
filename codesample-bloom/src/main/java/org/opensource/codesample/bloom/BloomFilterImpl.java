package org.opensource.codesample.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * BloomFilterImpl
 *
 * @see com.google.common.hash.BloomFilter
 */
public class BloomFilterImpl {

    public static void main(String[] args) {
        BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), 100000);
        bf.put(1);
        System.err.println(bf.put(1));
        System.err.println(bf.mightContain(2));

        // 1000000000000000000000000000000000000000000000000000000000000000
    }
}
