import java.util.concurrent.*;

public class Fibonacci extends RecursiveTask<Integer> {

   public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ForkJoinPool pool = new ForkJoinPool();
 	 ForkJoinTask<Integer> task = new Fibonacci(n);
        int result = pool.invoke(task);
   }

   private final int n;

   public Fibonacci(int n) { this.n = n; }

   public Integer compute() {
        if (n <= 1) return n;
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.invoke() + f1.join();
   }
}


