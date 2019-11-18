import java.util.concurrent.RecursiveTask;

public class ForkClass extends RecursiveTask<Long> {

    private long fodase;

    @Override
    protected Long compute() {
        ForkClass forkClass = new ForkClass();
        System.out.println("Sou o filho");
        forkClass.fork();
        return forkClass.join();
    }

}
