public class Main {
    public static void main(String[] args) {
        fibonacci(11);
    }

    static void fibonacci(int num) {
        int f1 = 0;
        System.out.println(f1);
        int f2 = 1;
        System.out.println(f2);
        for (int i = 2; i < num; i++) {
            int f3 = f1 + f2;
            System.out.println(f3);
            f1 = f2;
            f2 = f3;
        }
    }
}