public class Main {
    public static void main(String[] args) {
        int[] b = {5,2,6,9,3,4,1};
        int[] a = bubble(b);
        for (int j : a) {
            System.out.print(j + " ");
        }
    }
    public static int[] bubble(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        return a;
    }
}