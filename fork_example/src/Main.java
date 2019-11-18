import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkClass forkClass = new ForkClass();
        forkJoinPool.invoke(forkClass).toString();

    }
}
