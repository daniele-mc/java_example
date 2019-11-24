import java.util.concurrent.RecursiveTask;

public class ForkClass extends RecursiveTask<Long> {
    private int parada = 10;



    @Override
    protected Long compute() {
        if(parada == 0){
            return Long.valueOf(0);
        }

        parada--;
        ForkClass forkClass = new ForkClass();
        System.out.println("Sou o filho");
        forkClass.fork();
        return forkClass.join();
    }

}
