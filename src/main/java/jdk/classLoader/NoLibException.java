package jdk.classLoader;

public class NoLibException {
    public native void nativeMethod();

    static{
        System.loadLibrary("NoLib");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.library.path"));
        new NoLibException().nativeMethod();
    }
}
