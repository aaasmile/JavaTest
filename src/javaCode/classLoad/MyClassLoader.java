package javaCode.classLoad;

import java.io.IOException;

public class MyClassLoader extends ClassLoader {

    private static final String BASE_DIR ="javaCode/";
    // javaCode/classLoad/hello/HelloImpl.class
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = name.replaceAll("\\.", "/");
        fileName = BASE_DIR + fileName + ".class";
        try {
            byte[] bytes = BinaryFileUtils.readFileToByteArray(fileName);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException ex) {
            throw new ClassNotFoundException("failed to load class " + name, ex);
        }
    }
}
