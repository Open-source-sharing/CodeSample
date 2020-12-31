package org.codesample.base.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @see java.lang.ref.Reference
 * @see WeakReference
 * @see SoftReference
 * @see PhantomReference
 * @see Object#finalize()
 */
public class JdkReference {

    public static void main(String[] args) {
        SoftReference<Object> sr = new SoftReference<Object>("a");
    }
}
