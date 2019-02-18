public class JadenTest {
    static int value = 7;
    static int inc(){
        return value++;
    }

    static int dec(){
        return value--;
    }

    static int getResult(){
        /*try {
            return inc();
        }finally {
            System.out.println("finally");
            return dec();
        }*/

        return value--;
    }

    public static void main(String[] args) {
        System.out.println(getResult());
        System.out.println(value);
    }
}
