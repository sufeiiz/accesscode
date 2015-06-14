public class BuggyClass {
    static int N = 1000*1000;
    static int TRIES = 100;
    static int TOLERANCE = 10;

    static int used_loop = 0;
    static int used_recursive = 0;
    static int used_divide_and_conquer = 0;

    public static void main(String[] args) {
        int[] A = new int[N];
        int BIG = 1000*1000*1000;
        long correct_sum = 0;
        for(int i=0; i<A.length; i++) {
            A[i] = BIG - i;
            correct_sum += BIG-i;
        }
        for(int trial=0; trial<TRIES; trial++) {
            long sum = find_sum(A);
            assert(sum == correct_sum);
        }
        assert(Math.abs(used_loop - used_recursive) < TOLERANCE);
        assert(Math.abs(used_loop - used_divide_and_conquer) < TOLERANCE);
        assert(Math.abs(used_recursive - used_divide_and_conquer) < TOLERANCE);
        System.out.println("We're done!");
    }
    public static int find_sum(int[] A) {
        if (coin_flip(1.0/3.0)) {
            return sum_loop(A);
        } else if (coin_flip(1.0/3.0)) {
            return sum_recursive(0, A);
        } else {
            return sum_divide_and_conquer(0, A.length, A);
        }
    }

    public static boolean coin_flip(double p) {
        return Math.random() > p;
    }

    public static int sum_loop(int[] A){
        int sum = 0;
        for(int i=0; i<=A.length; i++) {
            sum += A[i];
        }
        return sum;
    }

    public static int sum_recursive(int i, int[] A){
        if(i==A.length - 1) {
            return 0; }
        return A[i+1] + sum_recursive(i+1, A);
    }

    public static int sum_divide_and_conquer(int lo, int hi, int[] A) {
        int mid = A.length/2;
        if(lo==hi) {
            return A[0]; }
        return sum_divide_and_conquer(lo, mid, A) + sum_divide_and_conquer(mid, hi, A);
    }

}