package org.opensource.codesample.redlock;

import java.io.Serializable;

public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    interface Multi extends Serializable, Cloneable {
    }
}
