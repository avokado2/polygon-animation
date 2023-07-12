public class MathUtils {

        private MathUtils() {
        }

        public static long calculatePhactorial(int n) {
            long res = 1;
            for (int i = 1; i <= n; i++) {
                res = res * i;
            }
            return res;
        }
    public static long calculatePhactorialRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n * calculatePhactorialRecursive(n-1);
    }
}

